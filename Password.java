import java.util.Scanner;


public class Password {

    public static boolean passwordFine(String passwordInput){
        if(passwordInput.length() > 8){
                System.out.println("La contraseña debe ser de 8 caracteres");
                return false;
            }else{
                if(passwordInput.matches(".*[a-z].*")){
                   if(passwordInput.matches(".*[A-Z].*")){
                       if(passwordInput.matches(".*[\\p{Punct}].*")){
                           if(passwordInput.matches(".*[0-9].*")){
                               System.out.println("La contraseña: "+ passwordInput + " es perfecta");
                               return true;
                           }else{
                               System.out.println("La contraseña debe tener almenos un numero");
                               return false;
                           }
                       }else{
                           System.out.println("La contraseña debe tener almenos un simbolo especial");
                           return false;
                       }
                   }else{
                       System.out.println("La contraseña debe tener almenos una letra mayuscula");
                       return false;
                   }
                }else{
                    System.out.println("La contraseña debe tener almenos una letra minuscula");
                    return false;
                }
            }
    }
    
    public static void main(String[] args) {
        Scanner password = new Scanner(System.in);
        String passwordInput;
        boolean passwordFine = true;

        do{
            System.out.println("Escribe la contraseña: ");
            passwordInput = password.nextLine();
            passwordFine = passwordFine(passwordInput);
            
        }while(passwordFine == false);
        
        password.close();
    }
    
}