import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        System.out.print("Ingresa el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int b = scanner.nextInt();

        try {
            double resultado = calculadora.dividir(a, b);
            System.out.println("Resultado: " + resultado);
        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
