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
        int opc;
        AccesoSAX a = new AccesoSAX();
        //a.parsearXMLconLibrosSAXhandler(f);
        //a.parsearXMLconEtiquetasSAXhandler(f,1);
        do
        {
            System.out.println("Que accion quieres realizar");
            System.out.println(" - 1 - Ver el XML completo");
            System.out.println(" - 2 - Ver el XML por etiqueta");
            System.out.println(" - 3 - Cerrar el programa");
            opc = sc.nextInt();
            switch (opc)
            {
                case 1:
                    a.parsearXMLconLibrosSAXhandler(f);
                    break;
                case 2:
                    System.out.println("Que etiqueta quieres ver");
                    System.out.println(" - 1 - Fecha de publicacion");
                    System.out.println(" - 2 - Titulo");
                    System.out.println(" - 3 - Autor");
                    opc = sc.nextInt();
                    a.parsearXMLconEtiquetasSAXhandler(f, opc);
                    break;
            }
            System.out.println("");
        }
        while (opc != 0);
    }
}

