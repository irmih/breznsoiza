/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.venia.components.heroimage;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class heroimage_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_heroimage = null;
Object _dynamic_properties = bindings.get("properties");
Object _dynamic_currentpage = bindings.get("currentpage");
out.write("\n");
_global_heroimage = renderContext.call("use", com.adobe.cq.commerce.core.components.models.HeroImage.class.getName(), obj());
out.write("\n    <div");
{
    String var_attrcontent0 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_heroimage, "classList"), "attribute")) + " jumbotron");
    {
        Object var_shoulddisplayattr1 = ((renderContext.getObjectModel().toBoolean(var_attrcontent0) ? var_attrcontent0 : ("false".equals(var_attrcontent0))));
        if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr1)) {
            out.write(" class=\"");
            out.write(renderContext.getObjectModel().toString(var_attrcontent0));
            out.write("\"");
        }
    }
}
{
    String var_attrcontent2 = (("background-image: url('" + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "fileReference")) ? renderContext.getObjectModel().resolveProperty(_dynamic_properties, "fileReference") : renderContext.getObjectModel().resolveProperty(_dynamic_properties, "fileName")))) ? renderContext.getObjectModel().resolveProperty(_global_heroimage, "imageSrc") : ""), "uri"))) + "');");
    {
        Object var_shoulddisplayattr3 = ((renderContext.getObjectModel().toBoolean(var_attrcontent2) ? var_attrcontent2 : ("false".equals(var_attrcontent2))));
        if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr3)) {
            out.write(" style=\"");
            out.write(renderContext.getObjectModel().toString(var_attrcontent2));
            out.write("\"");
        }
    }
}
out.write(">\n        <div class=\"container cq-dd-image\">\n            <div class=\"venia-HeroImage-wrapper\">\n                <p class=\"h3\">");
{
    Object var_4 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "heading"), "text");
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</p>\n                <strong class=\"venia-HeroImage-title h1\">");
{
    Object var_5 = renderContext.call("xss", ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "title")) ? renderContext.getObjectModel().resolveProperty(_dynamic_properties, "title") : renderContext.getObjectModel().resolveProperty(_dynamic_currentpage, "title"))), "text");
    out.write(renderContext.getObjectModel().toString(var_5));
}
out.write("</strong>\n\n                ");
{
    Object var_testvariable6 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonLabel")) ? renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonLinkTo") : renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonLabel")));
    if (renderContext.getObjectModel().toBoolean(var_testvariable6)) {
        out.write("<p>\n                    <a class=\"btn btn-primary btn-action\"");
        {
            Object var_attrvalue7 = renderContext.call("uriManipulation", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonLinkTo"), obj().with("extension", "html"));
            {
                Object var_attrcontent8 = renderContext.call("xss", var_attrvalue7, "uri");
                {
                    Object var_shoulddisplayattr10 = ((renderContext.getObjectModel().toBoolean(var_attrcontent8) ? var_attrcontent8 : ("false".equals(var_attrvalue7))));
                    if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr10)) {
                        out.write(" href");
                        {
                            boolean var_istrueattr9 = (var_attrvalue7.equals(true));
                            if (!var_istrueattr9) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent8));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(" role=\"button\">");
        {
            Object var_11 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonLabel"), "text");
            out.write(renderContext.getObjectModel().toString(var_11));
        }
        out.write("</a>\n                </p>");
    }
}
out.write("\n            </div>\n        </div>\n    </div>\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

