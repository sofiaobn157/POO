import java.util.Scanner;

public class Identificadores {
     public static void main(String[] args) {
     try (Scanner scanner = new Scanner(System.in)){

System.out.print("Ingresa tu nombre: ");
String nombre_ingreso = scanner.nextLine();

System.out.print("Ingresa tu apellido: ");
String apellido_ingreso = scanner.nextLine();

System.out.print("Ingresa tu edad: ");
int edad_ingreso = scanner.nextInt();

System.out.println("Tu nombre completo es: "+nombre_ingreso + " " + apellido_ingreso + " "+ "y tu edad es: "+edad_ingreso);

     }
}

}