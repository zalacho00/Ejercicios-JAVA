package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;


class Objeto_valor {

    public static void listaGuardar(HashMap<String, Double> unOrderList, LinkedHashMap<String, Double> insertOrderList, TreeMap<String, Double> AutoOrderList, String objeto, Double precio){
        unOrderList.put(objeto, precio);
        insertOrderList.put(objeto, precio);
        AutoOrderList.put(objeto, precio);
    }
    
    public static HashMap<String, Double> ListaSinOrden(HashMap<String, Double> unOrderList){
        System.out.println("\n*************************************");
        System.out.println("Lista sin orden: ");
        System.out.println("*************************************");
        return unOrderList;
    }

    public static LinkedHashMap<String, Double> ListaPorInserccion(LinkedHashMap<String, Double> insertOrderList){
        System.out.println("\n*************************************");
        System.out.println("Lista con orden de inserccion: ");
        System.out.println("*************************************");
        return insertOrderList;
    }

    public static TreeMap<String, Double> ListaAuto(TreeMap<String, Double> AutoOrderList){
        System.out.println("\n*************************************");
        System.out.println("Lista con orden automatico: ");
        System.out.println("*************************************");
        return AutoOrderList;
    }
    

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var unOrderList = new HashMap<String, Double>();
        var insertOrderList = new LinkedHashMap<String, Double>();
        var AutoOrderList = new TreeMap<String, Double>();
        
        String objeto = "";
        double precio = 0.0;
        int opcion;
        
        do{
            System.out.println("Elije 1 para añadir objeto, 2 para generar listas");
            System.out.println("ingrese la opcion: ");
            opcion = scan.nextInt();
            scan.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("ingrese el nombre del objeto: ");
                    objeto = scan.nextLine();

                    System.out.println("ingrese el valor de dicho objeto: ");
                    precio = scan.nextDouble();
                    listaGuardar(unOrderList, insertOrderList, AutoOrderList, objeto, precio);
                    
                    break;
                case 2:
                    System.out.println("cargando listas...\n");
                    System.out.println("**********************************");
                    
                    System.out.println(ListaSinOrden(unOrderList));
                    
                    System.out.println(ListaPorInserccion(insertOrderList));
                    
                    System.out.println(ListaAuto(AutoOrderList));
                    break;
                
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        }while(opcion == 1);

        scan.close();
    }
}

/*
Imagina que estás creando el sistema de inventario de una tienda de videojuegos o rol. Cada objeto tiene un nombre (la Clave, tipo String) y un precio o cantidad en stock (el Valor, tipo Integer o Double).

Tu misión es crear un programa que reciba una lista de productos con sus valores, los almacene en los tres tipos de mapas (HashMap, LinkedHashMap y TreeMap), y nos muestre cómo se comportan al imprimirlos.
*/