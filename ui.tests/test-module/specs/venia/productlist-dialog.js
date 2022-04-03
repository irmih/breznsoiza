/*
 *  Copyright 2022 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

const config = require('../../lib/config');
const { OnboardingDialogHandler, randomString } = require('../../lib/commons');

describe('Product List Component Dialog', function () {
    const editor_page = `${config.aem.author.base_url}/editor.html`;

    let testing_page;
    let onboardingHdler;

    before(function () {
        // Set window size to desktop
        browser.setWindowSize(1280, 960);

        // AEM Login
        browser.AEMForceLogout();
        browser.url(config.aem.author.base_url);
        browser.AEMLogin(config.aem.author.username, config.aem.author.password);

        // Enable helper to handle onboarding dialog popup
        onboardingHdler = new OnboardingDialogHandler(browser);
        onboardingHdler.enable();

        const pageName = `testing-${randomString()}`;
        testing_page = `/content/venia/us/en/${pageName}`;
        browser.AEMCreatePage({
            title: 'Testing Page',
            name: pageName,
            parent: '/content/venia/us/en',
            template: '/conf/venia/settings/wcm/templates/page-content'
        });
        browser.pause(1000);
        addComponentToPage();
    });

    after(function () {
        // Disable helper to handle onboarding dialog popup
        if (onboardingHdler) {
            onboardingHdler.disable();

            // Clean up page
            browser.AEMDeletePage(testing_page);
        }
    });

    const addComponentToPage = (name = 'Product List', group = 'Venia - Commerce') => {
        browser.url(`${editor_page}${testing_page}.html`);
        browser.AEMEditorLoaded();
        browser.EditorOpenSidePanel();

        // Open the Components tab
        $('coral-tab[title="Components"]').waitAndClick({ x: 1, y: 1 });

        // Filter for Commerce components
        $('#components-filter coral-select button').waitAndClick();
        browser.pause(200);
        $(`coral-selectlist-item[value="${group}"]`).waitAndClick();
        expect($('#components-filter coral-select [handle=label]')).toHaveText(group);

        // Drag and drop component on the page
        const carouselCmp = $(`div[data-title="${name}"]`);
        expect(carouselCmp).toBeDisplayed();
        const dropTarget = $(`div[data-path="${testing_page}/jcr:content/root/container/container/*"]`);
        carouselCmp.dragAndDrop(dropTarget, 1000);
    };

    const openComponentDialog = (
        node = 'productlist',
        trackingId = 'aem:sites:components:dialogs:cif-core-components:productlist:v2'
    ) => {
        // Open component dialog
        const cmpPlaceholder = $(`div[data-path="${testing_page}/jcr:content/root/container/container/${node}"]`);
        expect(cmpPlaceholder).toBeDisplayed();
        cmpPlaceholder.click();
        const configureButton = $('button[title="Configure"]');
        expect(configureButton).toBeDisplayed();
        configureButton.click();
        const dialog = $(`coral-dialog[trackingfeature="${trackingId}"]`);
        expect(dialog).toBeDisplayed();
        return dialog;
    };

    it('checks the component dialog', () => {
        let dialog = openComponentDialog();
        let header = dialog.$('coral-dialog-header');

        expect(header).toHaveText('Product List');

        let fields = dialog.$$('.cq-dialog-content .coral-Form-fieldwrapper');

        // check fields
        expect(fields.length).toEqual(5);
        expect(fields[0].$('label')).toHaveText('Manual Category Selection');
        expect(fields[0].$('category-field')).toExist();
        expect(fields[0].$('input[name="./category"]')).toExist();
        expect(fields[0].nextElement()).toHaveElementClass('coral-Well');
        expect(fields[1].$('label')).toHaveText('Page Size');
        expect(fields[1].$('input[name="./pageSize"]')).toExist();
        expect(fields[2].$('coral-checkbox-label')).toHaveText('Show title');
        expect(fields[2].$('input[name="./showTitle"]')).toExist();
        expect(fields[3].$('coral-checkbox-label')).toHaveText('Show image');
        expect(fields[3].$('input[name="./showImage"]')).toExist();
        expect(fields[4].$('label')).toHaveText('ID');
        expect(fields[4].$('input[name="./id"]')).toExist();

        // close the dialog
        dialog.$('button[title="Cancel"]').click();
        expect(dialog.isExisting()).toBe(false);
    });
});
