package accesoxml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class EtiquetasSAXhandler extends DefaultHandler{
    
    private String etiqueta = "";
    private StringBuilder elemento;
    private int obj,count = 1;
    private String[] opc = {"Libro","Titulo","Autor"};
    private String[] opcs = {"fechas de publicacion","titulos","autores"};
    
    public EtiquetasSAXhandler(int obj)
    {
        this.obj = obj - 1;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        super.startElement(uri, localName, qName, atts); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        elemento = new StringBuilder();
        if (qName.equals("Libro"))
        {
            etiqueta = "Libro";
            if (etiqueta.equals(opc[obj]))
            {
                System.out.println(" - " + count + " - " + atts.getValue(atts.getQName(0)));
                count++;
            }
        }
        else if (qName.equals("Titulo"))
        {
            etiqueta = "Titulo";
        }
        else if (qName.equals("Autor"))
        {
            etiqueta = "Autor";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (etiqueta.equals(opc[obj]))
        {
            String car = new String(ch,start,length);
            car = car.replaceAll("/t", "");
            car = car.replaceAll("/n", "");
            elemento.append(car);
        }
        else
        {
            
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        String contenido = elemento.toString().trim();
        if (!contenido.isEmpty())
        {
            System.out.println(" - " + count + " - " + contenido);
            count++;
            elemento = new StringBuilder();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("LISTADO DE " + opcs[obj].toUpperCase());
        System.out.print("---------");
        for (int i=0;i<opcs[obj].length();i++)
        {
            System.out.print("-");
        }
        System.out.println("");
    }
    
    
    
    
}
