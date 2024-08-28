import java.util.Scanner;

public class Duplicados{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa una cadena de caracteres: ");
        String cadena = scanner.nextLine();

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (resultado.indexOf(String.valueOf(c)) == -1) {
                resultado.append(c);


                System.out.println("Cadena sin duplicados: " + resultado.toString());



    }
}
    }
}
