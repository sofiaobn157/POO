import java.util.Scanner;

public class Vocales{
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            
            System.out.println("Ingrese una oración");
            String oracion = scanner.nextLine();

            int contadorA = 0, contadorE = 0, contadorI = 0, contadorO = 0, contadorU = 0;

            int indice = 0;

            while(indice < oracion.length()){
                char caracter = oracion.charAt(indice);

                if (caracter == 'a' || caracter == 'A') {
                    contadorA++;
                } else if (caracter == 'e' || caracter == 'E') {
                    contadorE++;
                } else if (caracter == 'i' || caracter == 'I') {
                    contadorI++;
                } else if (caracter == 'o' || caracter == 'O') {
                    contadorO++;
                } else if (caracter == 'u' || caracter == 'U') {
                    contadorU++;
                }

                indice++;

            }

        System.out.println("Cantidad de 'a': " + contadorA);
        System.out.println("Cantidad de 'e': " + contadorE);
        System.out.println("Cantidad de 'i': " + contadorI);
        System.out.println("Cantidad de 'o': " + contadorO);
        System.out.println("Cantidad de 'u': " + contadorU);


        }

        }
    }


