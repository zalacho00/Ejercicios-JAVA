package Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SumaListasInvertidas {


    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(List.of(2, 4, 3));
        List<Integer> l2 = new ArrayList<>(List.of(5, 6, 4));

        System.out.println("Lista 1: " + l1);
        System.out.println("Lista 2: " + l2);

        Collections.reverse(l1);// invertimos las listas para sumarlas correctamente
        Collections.reverse(l2);

        System.out.println("Lista 1 invertida: " + l1);
        System.out.println("Lista 2 invertida: " + l2);


        int num1 = Integer.parseInt(l1.toString().replaceAll("\\D", "")); // \\D para eliminar cualquier caracter que no sea un digito
        int num2 = Integer.parseInt(l2.toString().replaceAll("\\D", ""));
                   // el int lo convierto a un string y reemplazo cualquier caracter que no sea digito por vacio
        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);

        int valor = num1 + num2;

        System.out.println("Suma: " + valor);

        List<Integer> listaSum = new LinkedList<>();
        String.valueOf(valor).chars().forEach(caracter -> listaSum.add(caracter - '0'));
        // como un String tomo el valor de un int, recorro cada caracter con chars() y luego para cada uno de esos caracteres
        // lo añado a la lista de la suma, pero como es un caracter le resto '0' para que me devulva el valor numero y no el 
        // valor del caracter en la tabla ASCII
        Collections.reverse(listaSum);
        // invierto la suma para que quede en el orden correcto

        System.out.println("Lista de la suma: " + listaSum);
    }
}
