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
package org.apache.sling.scripting.sightly.apps.venia.components.commerce.logo;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class logo_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_component = null;
Object _global_header = null;
Object _global_templates = null;
Object _global_logoname = null;
Object _global_testpath = null;
Object _dynamic_resource = bindings.get("resource");
Object _global_hasimage = null;
out.write("\n");
_global_component = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Component.class.getName(), obj());
_global_header = renderContext.call("use", com.adobe.cq.commerce.core.components.models.header.Header.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_logoname = "logo.svg";
out.write("\n<a");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_global_component, "id");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            Object var_shoulddisplayattr3 = ((renderContext.getObjectModel().toBoolean(var_attrcontent1) ? var_attrcontent1 : ("false".equals(var_attrvalue0))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr3)) {
                out.write(" id");
                {
                    boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                    if (!var_istrueattr2) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" class=\"logo__link\"");
{
    Object var_attrvalue4 = renderContext.getObjectModel().resolveProperty(_global_header, "navigationRootPageUrl");
    {
        Object var_attrcontent5 = renderContext.call("xss", var_attrvalue4, "uri");
        {
            Object var_shoulddisplayattr7 = ((renderContext.getObjectModel().toBoolean(var_attrcontent5) ? var_attrcontent5 : ("false".equals(var_attrvalue4))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr7)) {
                out.write(" href");
                {
                    boolean var_istrueattr6 = (var_attrvalue4.equals(true));
                    if (!var_istrueattr6) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent5));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">\n    ");
_global_testpath = (renderContext.getObjectModel().toString(_global_logoname) + "/jcr:primaryType");
_global_hasimage = renderContext.getObjectModel().resolveProperty(_dynamic_resource, _global_testpath);
if (renderContext.getObjectModel().toBoolean(_global_hasimage)) {
    out.write("<img class=\"logo__image\"");
    {
        String var_attrcontent8 = ((renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_resource, "path"), "uri")) + "/") + renderContext.getObjectModel().toString(renderContext.call("xss", _global_logoname, "uri")));
        {
            Object var_shoulddisplayattr9 = ((renderContext.getObjectModel().toBoolean(var_attrcontent8) ? var_attrcontent8 : ("false".equals(var_attrcontent8))));
            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr9)) {
                out.write(" src=\"");
                out.write(renderContext.getObjectModel().toString(var_attrcontent8));
                out.write("\"");
            }
        }
    }
    out.write(" height=\"24\"");
    {
        Object var_attrvalue10 = renderContext.getObjectModel().resolveProperty(_global_header, "navigationRootPageTitle");
        {
            Object var_attrcontent11 = renderContext.call("xss", var_attrvalue10, "attribute");
            {
                Object var_shoulddisplayattr13 = ((renderContext.getObjectModel().toBoolean(var_attrcontent11) ? var_attrcontent11 : ("false".equals(var_attrvalue10))));
                if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr13)) {
                    out.write(" alt");
                    {
                        boolean var_istrueattr12 = (var_attrvalue10.equals(true));
                        if (!var_istrueattr12) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent11));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    {
        Object var_attrvalue14 = renderContext.getObjectModel().resolveProperty(_global_header, "navigationRootPageTitle");
        {
            Object var_attrcontent15 = renderContext.call("xss", var_attrvalue14, "attribute");
            {
                Object var_shoulddisplayattr17 = ((renderContext.getObjectModel().toBoolean(var_attrcontent15) ? var_attrcontent15 : ("false".equals(var_attrvalue14))));
                if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr17)) {
                    out.write(" title");
                    {
                        boolean var_istrueattr16 = (var_attrvalue14.equals(true));
                        if (!var_istrueattr16) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent15));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\n    ");
{
    boolean var_testvariable18 = (!renderContext.getObjectModel().toBoolean(_global_hasimage));
    if (var_testvariable18) {
        {
            Object var_19 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_header, "navigationRootPageTitle"), "text");
            out.write(renderContext.getObjectModel().toString(var_19));
        }
    }
}
out.write("\n</a>\n");
{
    Object var_templatevar20 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions21_field$_isempty = ((!renderContext.getObjectModel().toBoolean(_global_hasimage)) && (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_header, "navigationRootPageTitle"))));
        {
            java.util.Map var_templateoptions21 = obj().with("isEmpty", var_templateoptions21_field$_isempty);
            callUnit(out, renderContext, var_templatevar20, var_templateoptions21);
        }
    }
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

