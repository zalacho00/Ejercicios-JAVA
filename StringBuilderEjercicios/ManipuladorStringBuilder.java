package StringBuilderEjercicios;
import java.util.*;

public class ManipuladorStringBuilder {
    public static void reversar(StringBuilder palabra){
        for(int i = palabra.length() - 1; i > 1; i--){
            if(i <= 7){
                for(int j = 2; j < 8; j++){
                    palabra.deleteCharAt(j);
                    palabra.insert(i, palabra.charAt(j));
                    i--;
                }
            }
            
        }
        System.out.println(palabra.toString());
    }

    public static void inserccionGuiones(StringBuilder palabra){
        for(int i = palabra.length(); i > -1; i--){
            if(i % 3 == 0){
                if(i == 0){
                    break;
                }
                palabra.insert(i, '-');
            }
        }
        System.out.println(palabra.toString());
    }
    
    public static void eliminarVocales(StringBuilder palabra){
        
        for(int i = 0; i < palabra.length(); i++){
            if(palabra.charAt(i) == 'a' || 
               palabra.charAt(i) == 'e' ||
               palabra.charAt(i) == 'i' ||
               palabra.charAt(i) == 'o' ||
               palabra.charAt(i) == 'u' ){
                palabra.deleteCharAt(i);
              }
        }

        for(int i = 0; i < palabra.length(); i++){
            if(palabra.charAt(i) == '-' && palabra.charAt(i + 1) == '-'){
                palabra.deleteCharAt(i + 1);
            }
        }

        if(palabra.charAt(0) == '-'){
            palabra.deleteCharAt(0);
        }else if(palabra.charAt(palabra.length() - 1)  == '-'){
            palabra.deleteCharAt(palabra.length() - 1);
        }

        System.out.println(palabra.toString());
    }
    
    public static void copiaInvertida(StringBuilder palabra){
        for(int i = palabra.length() - 1; i > -1; i--){
            if(palabra.charAt(i) == '-'){
                palabra.append('-');
            }else{
                palabra.append(Character.toUpperCase(palabra.charAt(i)));
            }
        }
    }
    

    
    public static void main(String[] args) {
        StringBuilder pal = new StringBuilder();
        pal.append("abracadabra");

        reversar(pal);
        inserccionGuiones(pal);
        eliminarVocales(pal);
        copiaInvertida(pal);

        System.out.println(pal.toString());
        
    }
}
