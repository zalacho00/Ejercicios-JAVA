import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner code = new Scanner(System.in);
        String codigoInput = code.nextLine();

        Pattern patron = Pattern.compile("[A-Z]{3}-[0-9]{2,4}");// expresion regular para validar que debe ser 3 letras mayusculas, un guion y de 2 a 4 numeros
        Matcher comparador = patron.matcher(codigoInput);// creo un objeto Matcher para comparar el codigo ingresado con el patron definido en la expresion regular

        if(comparador.find()){// aqui uso el metodo find() del objeto Matcher para buscar si el codigo ingresado cumple con el patron definido en la expresion regular
            System.out.println("El codigo: " + codigoInput + " es aceptable");
        }else{
            System.out.println("El codigo: " + codigoInput + " no es aceptable");
        }

        code.close();
    }
}