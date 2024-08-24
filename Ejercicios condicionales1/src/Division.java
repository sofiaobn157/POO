import java.util.Scanner;

public class Division{ 
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){

            System.out.print("Ingrese el numerador: ");
            double num = scanner.nextDouble();

            System.out.print("Ingrese el divisor: ");
            double num2 = scanner.nextDouble();

        if (num2 == 0){
            System.out.println("No se puede dividir por cero");
        }else{
            double resultado = num / num2;
            System.out.println("El resultado de la división es: " + resultado);
    
        }
    }

}

}