import java.util.Scanner;

public class Entrada {
    public static void main(String[] args){
  try (Scanner scanner = new Scanner(System.in)){

System.out.println("Ingrese su nombre:");
String nombre = scanner.nextLine();

System.out.println("Ingrese su edad:");
int edad = scanner.nextInt();

System.out.println("Ingrese su salario mensual:");
double sueldo = scanner.nextDouble();

double sueldo_anual = sueldo * 12;
System.out.println("Bienvenid@ "+nombre+", a la edad de " +edad+ " ganas al año $"+sueldo_anual);

    }
}

}
