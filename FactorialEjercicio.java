

class FactorialEjercicio {


    public static int factorial(int numero, int contador){
        if(numero < 0) throw new IllegalArgumentException("El numero debe ser positivo");
        if(numero == 0) return 1;
        if(contador > 0){
            numero *= contador;
            contador--;
            return factorial(numero, contador);
        }else{
            return numero;
        }
    }

    public static void main(String[] args) {
        int num = 5;
        int count = num - 1;

        System.out.println("El factorial de " + num + " es: " + factorial(num, count));
    }
}
