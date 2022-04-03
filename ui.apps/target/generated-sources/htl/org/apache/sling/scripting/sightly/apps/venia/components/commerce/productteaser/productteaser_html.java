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
package org.apache.sling.scripting.sightly.apps.venia.components.commerce.productteaser;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class productteaser_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_product = null;
Object _global_templates = null;
Object _global_actionstpl = null;
Object _global_imagetpl = null;
Object _dynamic_properties = bindings.get("properties");
Object _global_isconfigured = null;
Object _global_hasproduct = null;
Object _global_template = null;
out.write("\n\n");
_global_product = renderContext.call("use", com.venia.core.models.commerce.MyProductTeaser.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_actionstpl = renderContext.call("use", "actions.html", obj());
_global_imagetpl = renderContext.call("use", "image.html", obj());
_global_isconfigured = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "selection");
if (renderContext.getObjectModel().toBoolean(_global_isconfigured)) {
_global_hasproduct = renderContext.getObjectModel().resolveProperty(_global_product, "url");
    if (renderContext.getObjectModel().toBoolean(_global_hasproduct)) {
        out.write("\n    ");
        {
            Object var_testvariable0 = ((renderContext.getObjectModel().toBoolean(_global_isconfigured) ? _global_hasproduct : _global_isconfigured));
            if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
                out.write("<div");
                {
                    Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_global_product, "sku");
                    {
                        Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
                        {
                            Object var_shoulddisplayattr4 = ((renderContext.getObjectModel().toBoolean(var_attrcontent2) ? var_attrcontent2 : ("false".equals(var_attrvalue1))));
                            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr4)) {
                                out.write(" data-product-sku");
                                {
                                    boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                                    if (!var_istrueattr3) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent2));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                {
                    Object var_attrvalue5 = renderContext.getObjectModel().resolveProperty(_global_product, "id");
                    {
                        Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
                        {
                            Object var_shoulddisplayattr8 = ((renderContext.getObjectModel().toBoolean(var_attrcontent6) ? var_attrcontent6 : ("false".equals(var_attrvalue5))));
                            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr8)) {
                                out.write(" id");
                                {
                                    boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                                    if (!var_istrueattr7) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                out.write(" class=\"item__root\" data-cmp-is=\"productteaser\"");
                {
                    Object var_attrvalue9 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_product, "data"), "json");
                    {
                        Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
                        {
                            Object var_shoulddisplayattr12 = ((renderContext.getObjectModel().toBoolean(var_attrcontent10) ? var_attrcontent10 : ("false".equals(var_attrvalue9))));
                            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr12)) {
                                out.write(" data-cmp-data-layer");
                                {
                                    boolean var_istrueattr11 = (var_attrvalue9.equals(true));
                                    if (!var_istrueattr11) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent10));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                {
                    Object var_attrvalue13 = renderContext.getObjectModel().resolveProperty(_global_product, "virtualProduct");
                    {
                        Object var_attrcontent14 = renderContext.call("xss", var_attrvalue13, "attribute");
                        {
                            Object var_shoulddisplayattr16 = ((renderContext.getObjectModel().toBoolean(var_attrcontent14) ? var_attrcontent14 : ("false".equals(var_attrvalue13))));
                            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr16)) {
                                out.write(" data-virtual");
                                {
                                    boolean var_istrueattr15 = (var_attrvalue13.equals(true));
                                    if (!var_istrueattr15) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent14));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                out.write(">\n        ");
                {
                    Object var_testvariable17 = renderContext.getObjectModel().resolveProperty(_global_product, "showBadge");
                    if (renderContext.getObjectModel().toBoolean(var_testvariable17)) {
                        out.write("<div class=\"item__badge\">\n            <span>");
                        {
                            Object var_18 = renderContext.call("xss", ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text")) ? renderContext.getObjectModel().resolveProperty(_dynamic_properties, "text") : "New")), "text");
                            out.write(renderContext.getObjectModel().toString(var_18));
                        }
                        out.write("</span>\n        </div>");
                    }
                }
                out.write("\n\n        ");
                {
                    Object var_templatevar19 = renderContext.getObjectModel().resolveProperty(_global_imagetpl, "actions");
                    {
                        Object var_templateoptions20_field$_product = _global_product;
                        {
                            java.util.Map var_templateoptions20 = obj().with("product", var_templateoptions20_field$_product);
                            callUnit(out, renderContext, var_templatevar19, var_templateoptions20);
                        }
                    }
                }
                out.write("\n\n        <a class=\"item__name\"");
                {
                    Object var_attrvalue21 = renderContext.getObjectModel().resolveProperty(_global_product, "url");
                    {
                        Object var_attrcontent22 = renderContext.call("xss", var_attrvalue21, "uri");
                        {
                            Object var_shoulddisplayattr24 = ((renderContext.getObjectModel().toBoolean(var_attrcontent22) ? var_attrcontent22 : ("false".equals(var_attrvalue21))));
                            if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr24)) {
                                out.write(" href");
                                {
                                    boolean var_istrueattr23 = (var_attrvalue21.equals(true));
                                    if (!var_istrueattr23) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent22));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                out.write("><span>");
                {
                    Object var_25 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_product, "name"), "text");
                    out.write(renderContext.getObjectModel().toString(var_25));
                }
                out.write("</span></a>\n        ");
_global_template = renderContext.call("use", "core/cif/components/commons/v1/price.html", obj());
                {
                    Object var_templatevar26 = renderContext.getObjectModel().resolveProperty(_global_template, "price");
                    {
                        Object var_templateoptions27_field$_pricerange = renderContext.getObjectModel().resolveProperty(_global_product, "priceRange");
                        {
                            boolean var_templateoptions27_field$_displayyousave = false;
                            {
                                java.util.Map var_templateoptions27 = obj().with("priceRange", var_templateoptions27_field$_pricerange).with("displayYouSave", var_templateoptions27_field$_displayyousave);
                                callUnit(out, renderContext, var_templatevar26, var_templateoptions27);
                            }
                        }
                    }
                }
                out.write("\n        ");
                {
                    Object var_templatevar28 = renderContext.getObjectModel().resolveProperty(_global_actionstpl, "actions");
                    {
                        Object var_templateoptions29_field$_product = _global_product;
                        {
                            java.util.Map var_templateoptions29 = obj().with("product", var_templateoptions29_field$_product);
                            callUnit(out, renderContext, var_templatevar28, var_templateoptions29);
                        }
                    }
                }
                out.write("\n    </div>");
            }
        }
        out.write("\n");
    }
}
out.write("\n\n");
{
    Object var_templatevar30 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions31_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_isconfigured));
        {
            java.util.Map var_templateoptions31 = obj().with("isEmpty", var_templateoptions31_field$_isempty);
            callUnit(out, renderContext, var_templatevar30, var_templateoptions31);
        }
    }
}
out.write("\n");
{
    Object var_templatevar32 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        Object var_templateoptions33_field$_isempty = ((renderContext.getObjectModel().toBoolean(_global_isconfigured) ? (!renderContext.getObjectModel().toBoolean(_global_hasproduct)) : _global_isconfigured));
        {
            String var_templateoptions33_field$_emptytextappend = "Configured, but no product to display";
            {
                java.util.Map var_templateoptions33 = obj().with("isEmpty", var_templateoptions33_field$_isempty).with("emptyTextAppend", var_templateoptions33_field$_emptytextappend);
                callUnit(out, renderContext, var_templatevar32, var_templateoptions33);
            }
        }
    }
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

