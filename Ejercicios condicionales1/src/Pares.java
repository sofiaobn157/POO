import java.util.Scanner;

public class Pares{ 
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){

            System.out.print("Ingrese un número entero: ");
            int entero = scanner.nextInt();

            if (entero % 2 == 0){
                System.out.println("El número ingresado es par");
            }else{
                System.out.println("El número ingresado es impar");
            

            }
            }
        }
    }
