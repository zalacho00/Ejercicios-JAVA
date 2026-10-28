
class PalindromoString {

    public static void main(String[] args) {
        String word = "Anita lava la tina";
        StringBuilder palindromeWord = new StringBuilder();
        String regex = "[^a-zA-Z0-9]";
        

        System.out.println("Frase / palabra: " + word);
        word = word.toLowerCase()
            .replaceAll("á", "a")
            .replaceAll("é", "e")
            .replaceAll("í", "i")
            .replaceAll("ó", "o")
            .replaceAll("ú", "u")
            .replaceAll(regex, "");
            
        
        palindromeWord = palindromeWord.append(word).reverse();

        System.out.println("Frase / palabra al revez: " + palindromeWord);

        if((palindromeWord.toString()).equals("")){
            System.out.println("La palabra debe tener letras o numeros");

        }else if(word.equals(palindromeWord.toString())){
            System.out.println("La palabra es palindroma");

        }else{
            System.out.println("La palabra no es palindroma");
        }

    }
}

