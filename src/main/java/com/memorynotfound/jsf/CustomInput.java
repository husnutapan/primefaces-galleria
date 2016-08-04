package com.memorynotfound.jsf;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.primefaces.component.galleria.Galleria;

@FacesComponent(value = "com.husnutapan.jsf.CustomInput")
public class CustomInput extends UIInput {

    public static final String blueimpGallery = "blueimp-gallery";
    public static final String carousel = "blueimp-gallery-carousel";
    public static final String galleryControls = "blueimp-gallery-controls";
    public static final String idVideo = "blueimp-video-carousel";
    public static final String idImage = "blueimp-image-carousel";
    public static final String idLightBox = "blueimp-gallery";

    @Override
    public void decode(FacesContext context) {
        //DECODE AREA
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        System.out.println(getAttributes().get("imageShow"));
        System.out.println(getAttributes().get("lightBoxShow"));

        encodeDivInside(context);
    }

    private void encodeDivInside(FacesContext context) throws IOException {

        ResponseWriter writer = context.getResponseWriter();
        if (getAttributes().get("lightBoxShow") != null) {

            writer.startElement("div", this);
            writer.writeAttribute("id", "links", null);
            writer.writeAttribute("class", "links", null);

            Collection<?> value = (Collection<?>) getAttributes().get("value");

            for (Iterator<?> it = value.iterator(); it.hasNext();) {

                Object object = it.next();
                writer.startElement("a", this);
                writer.writeAttribute("href", getAttributes().get("prefix") + "" + object, null);
                writer.writeAttribute("data-gallery", null, null);
                writer.startElement("img", this);
                writer.writeAttribute("src", getAttributes().get("prefix") + "" + object, null);
                writer.writeAttribute("style", "width:100px;height:100px;", null);
                writer.endElement("a");

            }
            writer.endElement("div");
        }
        writer.startElement("div", this);

        if (getAttributes().get("imageShow") != null) {
            writer.writeAttribute("id", idImage, null);
        }

        if (getAttributes().get("videoShow") != null) {
            writer.writeAttribute("id", idVideo, null);
        }

        if (getAttributes().get("lightBoxShow") != null) {
            writer.writeAttribute("id", idLightBox, null);
        }

        if (getAttributes().get("imageShow") != null) {
            writer.writeAttribute("class", blueimpGallery + " " + carousel, null);
        }

        if (getAttributes().get("videoShow") != null) {
            writer.writeAttribute("class", blueimpGallery + " " + galleryControls + " " + carousel, null);
        }

        if (getAttributes().get("lightBoxShow") != null) {
            writer.writeAttribute("class", idLightBox, null);
        }

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
        writer.endElement("a");

        if (getAttributes().get("lightBoxShow") != null) {
            writer.startElement("a", this);
            writer.writeAttribute("class", "close", null);
            writer.write("×");
            writer.endElement("a");

            writer.startElement("ol", this);
            writer.writeAttribute("class", "indicator", null);
            writer.endElement("ol");
        }
        writer.endElement("div");
    }
}
