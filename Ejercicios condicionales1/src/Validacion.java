import java.util.Scanner;

public class Validacion {
        public static void main(String[] args){
            try (Scanner scanner = new Scanner(System.in)){
    
                System.out.println("¿Cual es su edad?");
                int edad = scanner.nextInt();
    
                if (edad > 18){
                    System.out.println("Usted es mayor de edad");
                }else{
                    System.out.println("Usted NO es mayor de edad");
                }
            }
        }
}
    
