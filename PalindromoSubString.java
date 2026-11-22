

public class PalindromoSubString {

    public static String longestPalindrome(String s) {
        StringBuilder word = new StringBuilder();
        s = s.toLowerCase().replaceAll("á", "a")
                           .replaceAll("é", "e")
                           .replaceAll("í", "i")
                           .replaceAll("ó", "o")
                           .replaceAll("ú", "u");
        

        s = s.substring(1, s.length() - 1);
        System.out.println("palabra: " + s);
        word = word.append(s).reverse();
        
        

        if(word.toString().equals("")){
            System.out.println("debe haber algun caracter");
            return null;
        }else if(s.equals(word.toString())){
            return word.toString();
        }else{
            System.out.println("no hay palindromos");
            return null;
        }
    }
    
    public static void main(String[] args) {
        String palabra = "babadfd";

        System.out.println(longestPalindrome(palabra));
    }
}
