import java.util.Scanner;

public class Aritmetica {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            
            System.out.println("Ingrese el primer numero: ");
            int numero_uno = scanner.nextInt();

            System.out.println("Ingrese el segundo numero: ");
            int numero_dos = scanner.nextInt();

            int suma = numero_uno + numero_dos;
            System.out.println("El resultado de la suma es: "+suma);

            int resta = numero_uno - numero_dos;
            System.out.println("El resultado de la resta es: "+resta);

            int multiplicacion = numero_uno * numero_dos;
            System.out.println("El resultado de la multipliacion es: "+multiplicacion);

            int division = numero_uno / numero_dos;
            System.out.println("El resultado de la division es: "+division);

            if (numero_uno > numero_dos){
                System.out.print("El primer numero es mayor que el segundo y ");
            } else {
                System.out.print("El primer numero no es mayor que el segundo y ");
            }


            if (numero_uno > 0 && numero_dos > 0){
            System.out.println("ambos numeros son positivos");
            } else {
                System.out.print("ambos numeros no son positivos");

            }
        }
    }
}
