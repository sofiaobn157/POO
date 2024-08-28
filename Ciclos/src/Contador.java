import java.util.Scanner;

public class Contador{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa una oración");
        String oracion = scanner.nextLine();

                oracion = oracion.trim();

                 int contador = 0;

                if (!oracion.isEmpty()) {

                String[] palabras = oracion.split("\\s+");

            contador = palabras.length;

            System.out.println("Número de palabras: " + contador);


                }
    }


    }
