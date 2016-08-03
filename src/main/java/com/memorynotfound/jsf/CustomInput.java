package com.memorynotfound.jsf;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;

@FacesComponent(value = "com.husnutapan.jsf.CustomInput")
public class CustomInput extends UIInput {

    @Override
    public void decode(FacesContext context) {
      //DECODE AREA
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        String clientId = getClientId(context);
        char sep = UINamingContainer.getSeparatorChar(context);
        encodeDivInside(context);
    }

    private void encodeDivInside(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", this);
        writer.writeAttribute("id", "blueimp-image-carousel", null);
        writer.writeAttribute("class", "blueimp-gallery blueimp-gallery-carousel", null);

        writer.startElement("div", this);
        writer.writeAttribute("class", "slides", null);
        writer.endElement("div");

        writer.startElement("h3", this);
        writer.writeAttribute("class", "title", null);
        writer.endElement("h3");

        writer.startElement("a", this);
        writer.writeAttribute("class", "prev", null);
        writer.write("‹");
        writer.endElement("a");

        writer.startElement("a", this);
        writer.writeAttribute("class", "next", null);
        writer.write("›");
        writer.endElement("a");

        writer.startElement("a", this);
        writer.writeAttribute("class", "play-pause", null);
        writer.write(">");
        writer.endElement("a");

        writer.endElement("div");
    }

}
