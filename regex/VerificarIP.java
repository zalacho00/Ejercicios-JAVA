package regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

class VerificarIP {

    public static void verificacionInformacion(String regex, String[] lineas, StringBuilder ipLimpia){

        for(int i = 0; i < lineas.length; i++){
            Pattern patron = Pattern.compile(regex);
            Matcher matcher = patron.matcher(lineas[i].trim());
            if(matcher.matches()){
                ipLimpia.append(lineas[i].trim());
                ipLimpia.append("\n");
            }
        }
        
    }

    /*public static void EnmascararIP(String regex, StringBuilder ipLimpia, String octeto){
        Pattern ip = Pattern.compile("ip=(?<Ip>" + octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto + ")");
        Matcher matcher = ip.matcher(ipLimpia);
        if(matcher.find()){
            int indiceInicio = matcher.start();
            int indiceFinal = matcher.end();

            for(int i = indiceFinal; i > indiceInicio; i--){
                if(!String.valueOf(ipLimpia.charAt(i)).equals(".")){
                    ipLimpia.setCharAt(i, 'x');
                }else{
                    break;
                }
            }
        }
    }*/

       /*  public static void EnmascararIP(String regex, StringBuilder ipLimpia, String octeto){
        Pattern ip = Pattern.compile("ip=(?<Ip>" + octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto + ")");
        
        String[] ipLimpiaLista = ipLimpia.toString().split("\"");
        for(int j = 0; j < ipLimpiaLista.length; j++){
            Matcher matcher = ip.matcher(ipLimpiaLista[j].trim());
            System.out.println(ipLimpiaLista[j].trim());
            if(matcher.find()){
                int indiceInicio = matcher.start();
                int indiceFinal = matcher.end();
                

                for(int i = indiceFinal; i > indiceInicio; i--){
                    if(!String.valueOf(ipLimpia.charAt(i)).equals(".")){
                        ipLimpia.setCharAt(i, 'x');
                    }else{
                        break;  
                    }
                }
            }
            matcher.reset();
        }
        
    }*/
    public static void EnmascararIP(String regex, StringBuilder ipLimpia, String octeto){
        Pattern ip = Pattern.compile("(ip=(?:" + octeto + "\\.){3})" + octeto + "(?=\\s|$)");
        Matcher matcher = ip.matcher(ipLimpia);
        String resultado = matcher.replaceAll("$1xxx");
        ipLimpia.replace(0, ipLimpia.length(), resultado);
    }


    /*public static void limpiarConBool(String regex, StringBuilder ipLimpia, String octeto){
        Pattern ip = Pattern.compile("ip=(?<Ip>" + octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto + ")");
        Matcher matcher = ip.matcher(ipLimpia);
        boolean bandera = true;
        int contador = 1;
        char caracter = Character.valueOf((char)(matcher.end() - contador));
        ipLimpia.setCharAt(matcher.end() + 1, 'x');
        while(bandera){
        if(caracter == '.'){
            bandera = false;
        }else{
            ipLimpia.setCharAt(caracter, 'x');
            contador++;
            caracter = Character.valueOf((char)(matcher.end() - contador));
        }
}
    }*/

    public static void Enumeramiento(StringBuilder ips){
        Map<String, Integer> Nivel = new HashMap<String, Integer>();
        Pattern level = Pattern.compile("(?<INFO>INFO)|(?<WARN>WARN)|(?<ERROR>ERROR)");
        Matcher matcher = level.matcher(ips);
        
        Nivel.put("INFO", 0);
        Nivel.put("WARN", 0);
        Nivel.put("ERROR", 0);

        while(matcher.find()){
            if(matcher.group("INFO") != null){
                Nivel.put("INFO", Nivel.get("INFO") + 1);
            }else if(matcher.group("WARN") != null){
                Nivel.put("WARN", Nivel.get("WARN") + 1);
            }else if(matcher.group("ERROR") != null){
                Nivel.put("ERROR", Nivel.get("ERROR") + 1);
            }
        }
        
        
        System.out.println("Enumeracion de niveles de errores: \n");
        listaNiveles(Nivel);
    } 

    public static void listaNiveles(Map<String, Integer> niveles){
        List< Map.Entry<String, Integer> > listaLevels = new ArrayList<>(niveles.entrySet());
        listaLevels.forEach(entrada -> System.out.println(entrada.getKey() + ": " + entrada.getValue()));
    }

    
    public static void main(String[] args) {

        String octeto = "(0|[1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";

        String regex = "\\[(?<year>(\\d{4})-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1]) (?:[0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d))\\]" +
                       "\\s+" +
                       "(?<Nivel>INFO|WARN|ERROR)" +
                       "\\s+" +
                       "user=(?<Usuario>([a-zA-Z][\\w_.]{2,11}))" +
                       "\\s+" +
                       "ip=(?<Ip>" + octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto + ")" +
                       "\\s+" +
                       "msg=\"(?<mensaje>[^\"]*)\"";

             
            String informaciones = """
                                    [2026-11-24 16:47:03] ERROR user=ana_99 ip=192.168.1.15 msg="Fallo al conectar"
                                    [2026-11-24 16:48:10] INFO user=luis.m ip=10.0.0.256 msg="Login ok"
                                    [2026-11-25 09:05:59] WARN user=bad_7 ip=172.16.254.1 msg="Intento 3 de 5"
                                    [2026-13-01 25:61:00] ERROR user=zoe ip=8.8.8.8 msg="Fecha imposible"
                                    [2026-11-25 10:00:00] INFO user=_bad ip=1.1.1.1 msg="Usuario raro"
                                   """;
            
            String[] lineas = informaciones.split("\n");
            StringBuilder sb = new StringBuilder();

            verificacionInformacion(regex, lineas, sb);
            EnmascararIP(regex, sb, octeto);
            Enumeramiento(sb);
            /*limpiarConBool(regex, sb,  octeto);*/

            System.out.println("Información válida:\n" + sb.toString());

    }
}
//2026-11-24 16:47:03
//Nivel: solo INFO, WARN o ERROR
//Usuario: 3 a 12 caracteres, empieza con letra, y el resto puede ser letras, dígitos, _ o ..
//IP: IPv4 donde cada octeto va de 0 a 255 (sin ceros a la izquierda como 01).
//Mensaje: entre comillas dobles, puede tener cualquier cosa menos comillas dentro.
