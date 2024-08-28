import java.util.Sacanner;

public class Vocales{
    public static void main(String[] args){
        try (Sacanner scanner = new Sacanner(System,in)){

            System.out.println("Ingrese una oración");
            String oracion = Scanner.nextLine();

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

                i++;

            }

            System.out.println("Cantidad de 'a': " + contadorA);
        System.out.println("Cantidad de 'e': " + contadorE);
        System.out.println("Cantidad de 'i': " + contadorI);
        System.out.println("Cantidad de 'o': " + contadorO);
        System.out.println("Cantidad de 'u': " + contadorU);



        }
    }
}


