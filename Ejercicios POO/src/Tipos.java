import java.util.Scanner;

public class Tipos {
    public static void main(String[] args){
    try (Scanner scanner = new Scanner(System.in)){

System.out.println("Ingrese su edad");
int edad1 = scanner.nextInt();

System.out.println("Ingrese su estatura");
double est= scanner.nextDouble();

boolean mayor = edad1 > 18;
System.out.println("¿Es mayor de edad? " + mayor);

scanner.nextLine();

System.out.println("Ingrese la inicial de su nombre");
char ok = scanner.nextLine().charAt(0);

System.out.println("Su edad es "+edad1 +" "+ "su estatura es "+est+" "+ "la inicial de su nombre es "+ok);

    }
}

}
