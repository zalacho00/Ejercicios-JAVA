import java.util.*;



class EnumeracionLetras {

    public static void main(String[] args) {
        StringBuilder palabraConstruida = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        String palabra = scan.nextLine();

        for(int i = 0; i < palabra.length();){
            char currentChar = palabra.charAt(i);
            int contador = 0;

            while(i < palabra.length() && palabra.charAt(i) == currentChar){
                contador++;
                i++;
            }
            palabraConstruida.append(contador).append(currentChar);
        }
        
        System.out.println(palabraConstruida);
        scan.close();
    }
}

// vallaaas -> 1v1a2l3a1s
// 01234567