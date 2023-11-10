package accesoxml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class LibrosSAXhandler extends DefaultHandler{
    
    public LibrosSAXhandler() {}
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException
    {
        if (qName.equals("Libro"))
        {
            System.out.println("-Fecha de publicacion: " + atts.getValue(atts.getQName(0)));
        }
        else if (qName.equals("Titulo"))
        {
            System.out.print("\n-Titulo: ");
        }
        else if (qName.equals("Autor"))
        {
            System.out.print("\n-Autor: ");
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equals("Libro"))
        {
            System.out.println("--------------------");
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String car = new String(ch,start,length);
        car = car.replaceAll("\t", "");
        car = car.replaceAll("\n", "");
        System.out.println(car);
    }
    
}
