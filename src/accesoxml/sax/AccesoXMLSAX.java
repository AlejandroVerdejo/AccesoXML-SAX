package accesoxml.sax;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class AccesoXMLSAX{

    public static void main(String[] args) {

        try { System.setOut(new PrintStream(System.out, true, "UTF-8"));} 
        catch (UnsupportedEncodingException e) {System.out.println(e);}
        Scanner sc = new Scanner(System.in);
        File f = new File("Libros.xml");
        AccesoSAX a = new AccesoSAX();
        a.parsearXMLconLibrosSAXhandler(f);
        a.parsearXMLconTitulosSAXhandler(f);
    }
}

