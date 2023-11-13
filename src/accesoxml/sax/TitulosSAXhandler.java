package accesoxml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class TitulosSAXhandler extends DefaultHandler{
    
    private String etiqueta = "";
    private StringBuilder elemento;
    
    public TitulosSAXhandler()
    {
        System.out.println("LISTADOS DE TITULOS");
        System.out.println("-------------------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        elemento = new StringBuilder();
        if (qName.equals("Libro"))
        {
            etiqueta = "Libro";
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
        if (etiqueta.equals("Titulo"))
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
            System.out.println(" - " + contenido);
        }
    }
    
    
    
}
