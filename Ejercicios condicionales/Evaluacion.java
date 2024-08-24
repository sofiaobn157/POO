import java.util.Scanner;

public class Evaluacion {
    public static void main(String[] args) {
        int dinero = 1000;
        try (Scanner scanner = new Scanner(System.in)){
         
            System.out.print("Ingrese su puntuación: ");
        Double puntuacion = scanner.nextDouble();

 String nivel;
 Double dinero_uno = 0.0;

    if (puntuacion == 0.0) {
        nivel = "Rendimiento bajo";
    } else if (puntuacion == 0.4) {
        nivel = "Rendimiento alto";
    } else if (puntuacion >= 0.6) {
        nivel = "Rendimiento intermedio";
    } else {
        nivel = "Puntuación no válida";
    }

    if (nivel.equals("Puntuación no válida")) {
        System.out.println(nivel);
    } else {
        dinero_uno = dinero * puntuacion;
        System.out.println("Nivel de rendimiento: " + nivel);
        System.out.println("Dinero que recibirá: $" + dinero_uno);
    }
            }
        }
    }
