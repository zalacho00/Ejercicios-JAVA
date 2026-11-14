import java.util.*;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
// ------------------> ejecutar en la consola: chcp 65001 <---------------

public class Practica {
    public static void main(String[] args) {
        StringBuilder palindromo = new StringBuilder();
        Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
        String palabra = scan.nextLine();

        // Normalizar la palabra para eliminar acentos y caracteres especiales y espacios en blanco
        palabra = Normalizer.normalize(palabra, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                                                                    .replaceAll("\\s+", "");

        palabra.chars().forEach(c -> System.out.print(c + " "));
        palindromo.append(palabra).reverse();
        
        System.out.println("Palabra original: " + palabra);
        System.out.println("Palabra invertida: " + palindromo);

        if(palabra.equals("")){
            System.out.println("La palabra debe tener almenos un caracter.");
        }else if(palabra.equalsIgnoreCase(palindromo.toString())){
            System.out.println("La palabra es palindroma");
        }else{
            System.out.println("La palabra no es palindroma");
        }

        scan.close();
    }
}
