import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner code = new Scanner(System.in);
        String codigoInput = code.nextLine();

        Pattern patron = Pattern.compile("[A-Z]{3}-[0-9]{2,4}");
        Matcher comparador = patron.matcher(codigoInput);

        if(comparador.find()){
            System.out.println("El codigo: " + codigoInput + " es aceptable");
        }else{
            System.out.println("El codigo: " + codigoInput + " no es aceptable");
        }

        code.close();
    }
}