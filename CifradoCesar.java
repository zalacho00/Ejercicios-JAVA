import java.util.Scanner;


class CifradoCesar {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Escribe el texto a cifrar: ");
        String texto = scan.nextLine();
        System.out.println("Escribe el desplazamiento: ");
        int n = scan.nextInt();
        String textoCifrado;
        

        StringBuilder textoCesar = new StringBuilder();

        for(int i = 0; i < texto.length(); i++){
            char caracter = texto.charAt(i);
                
            if(caracter > 64 && caracter < 91){
                for(int j = 0; j <= n; j++){
                    if(((char)(caracter + n)) > 90){
                        char N = (char)(n - j);
                        caracter = (char)(64 + N);
                        textoCesar.append(caracter);
                        break;
                    }else{
                        textoCesar.append((char)(caracter + n));
                        break;
                    }
                }
            }else if(caracter > 96 && caracter < 123){
                for(int l = 0; l <= n; l++){
                    if(((char)(caracter + n)) > 122){
                        char NN = (char)(n - l);
                        caracter = (char)(96 + NN);
                        textoCesar.append(caracter);
                        break;
                    }else{
                        textoCesar.append((char)(caracter + n));
                        break;
                    }
                }
            }else{
                textoCesar.append(caracter);
            }
            
        }
        
        textoCifrado = textoCesar.toString();
        System.out.println(textoCifrado);


        scan.close();
    }
}