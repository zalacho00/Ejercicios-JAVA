package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.text.Normalizer;

class ListaObjetos {

    public static HashSet<String> SinOrden(String[] listaObjetos){
        var objSinDuplicados = new HashSet<String>();
        for(String objeto : listaObjetos){
            objSinDuplicados.add(objeto);
        }
        System.out.println("Lista sin duplicados: ");
        return objSinDuplicados;
    }
    

    public static TreeSet<String> OrdenAutomatico(String[] listaObjetos){
        var objOrderAuto = new TreeSet<String>();
        for(String objeto : listaObjetos){
            objOrderAuto.add(objeto);
        }
        System.out.println("Lista con orden automatico y sin duplicados: ");
        return objOrderAuto;
    }
    

    public static LinkedHashSet<String> OrdenPorInserccion(String[] listaObjetos){
        var objInsertOrder = new LinkedHashSet<String>();
        for(String objeto : listaObjetos){
            objInsertOrder.add(objeto);
        }
        System.out.println("Lista con orden de ingreso y sin duplicados: ");
        return objInsertOrder;
    }

    
    public static void main(String[] args) {
        var obj = new Scanner(System.in);
        System.out.println("Ingresa los objetos separados por espacio: ");
        String objetos = obj.nextLine();
        objetos = Normalizer.normalize(objetos, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        String regex = "[\\s]+";
        String[] listaObjetos = objetos.split(regex);
        
        System.out.println("Tres tipos de lista: \n\n");

        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println(SinOrden(listaObjetos));
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println(OrdenPorInserccion(listaObjetos));
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println(OrdenAutomatico(listaObjetos));
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        obj.close();
    }
        
}