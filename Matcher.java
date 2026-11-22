import java.util.regex.Pattern;


public class Matcher {

    public static boolean isMatch(String s, String p) {
        Pattern pat = Pattern.compile(p);
        java.util.regex.Matcher mat = pat.matcher(s);

        boolean match = mat.matches();
        if(match){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        String s = "aa";
        String p = ".*";

        System.out.println(isMatch(s, p));
    }
}
