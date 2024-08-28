import java.util.Scanner;

public class Palindromos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Palindromos = 0;

        System.out.println("Ingresa palabras una por una. Escribe 'fin' para terminar.");

        while (true) {
            System.out.print("Ingresa una palabra: ");
            String palabra = scanner.nextLine();

            if (palabra.equals("fin")) {
                break;
            }

            int esPalindromo = 1;  
            int longitud = palabra.length();
            for (int i = 0; i < longitud / 2; i++) {
                if (palabra.charAt(i) != palabra.charAt(longitud - 1 - i)) {
                    esPalindromo = 0; 
                    i = longitud;
                }
            }

            if (esPalindromo == 1) {
                Palindromos++;
            }
        }
    

        System.out.println("Número de palíndromos ingresados: " + Palindromos);
    }
}
