package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.text.Normalizer;

class ListaObjetos {

    public static HashSet<String> SinOrden(String[] listaObjetos){
        var objSinDuplicados = new HashSet<String>(); // HashSet para eliminar duplicados y no importa el orden
        for(String objeto : listaObjetos){
            objSinDuplicados.add(objeto);
        }
        System.out.println("Lista sin duplicados: ");
        return objSinDuplicados;
    }
    

    public static TreeSet<String> OrdenAutomatico(String[] listaObjetos){
        var objOrderAuto = new TreeSet<String>(); // TreeSet para eliminar duplicados y ordenar automaticamente de menor a mayor
        for(String objeto : listaObjetos){
            objOrderAuto.add(objeto);
        }
        System.out.println("Lista con orden automatico y sin duplicados: ");
        return objOrderAuto;
    }
    

    public static LinkedHashSet<String> OrdenPorInserccion(String[] listaObjetos){
        var objInsertOrder = new LinkedHashSet<String>(); // LinkedHashSet para eliminar duplicados y mantener el orden de inserccion 
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
        // Normalizer para eliminar acentos y tildes de los objetos ingresados 
        String regex = "[\\s]+"; // expresion regular para separar los objetos por espacio
        String[] listaObjetos = objetos.split(regex); // separo los objetos ingresador por espacio y los guardo en un array de String
        
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

// Espada Poción Escudo Poción Arco Armadura Espada Casco Poción Daga