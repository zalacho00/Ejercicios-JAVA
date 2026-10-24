import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class VerificarCorreo {
    public static void main(String[] args) {
        ArrayList<String> correosSucios = new ArrayList<String>();
        ArrayList<String> correosLimpios = new ArrayList<String>();
        Scanner correoInput = new Scanner(System.in);

        System.out.println("Escribe los correos separados por un espacio: ");

        String correos = correoInput.nextLine();
        String[] correosDiv = correos.split("\\s+");
        String regex = "^[\\w.+-]+@[\\w-]+(?:\\.[\\w-]+)+$";
        Pattern p = Pattern.compile(regex);
        
        for(String CD /*correosDiv*/: correosDiv){
            correosSucios.add(CD);
        }

        for(String c : correosSucios){
            Matcher m = p.matcher(c);
            if(m.find()){
                correosLimpios.add(c);
            }else{
                continue;
            }
        }

        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");

        System.out.println("lista de correos limpios: ");
        for(String CL : correosLimpios){
            System.out.println(CL);
        }
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");

        correoInput.close();
    }
}
