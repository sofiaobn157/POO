import java.util.Scanner;

public class Invertir {
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){

            System.out.println("Ingrese una oración");
            String oracion = scanner.nextLine();

            String[] palabras = oracion.split(" ");

            for (int i = 0; i < palabras.length; i++) {
                for (int j = palabras[i].length() - 1; j >= 0; j--) {
                    System.out.print(palabras[i].charAt(j));

        }
        if ( i < palabras.length - 0){
            System.out.print(" ");
        }



        }
    }

    }
}

