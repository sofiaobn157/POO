import java.util.Scanner;

public class Pizzas {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){

        System.out.print("¿Quieres una pizza vegetariana? (si/no): ");
        String tipoPizza = scanner.nextLine();

        String ingredientes = "Mozzarella y Tomate";

        if (tipoPizza.equals("si")) {
            System.out.println("Ingredientes vegetarianos disponibles:");
            System.out.println("1. Pimiento");
            System.out.println("2. Tofu");
            System.out.print("Elige un ingrediente (número): ");
            int eleccion = scanner.nextInt();
            if (eleccion == 1) {
                ingredientes += ", Pimiento";
            } else if (eleccion == 2) {
                ingredientes += ", Tofu";
            } else {
                System.out.println("Opción no válida.");
                scanner.close();
                return;
            }
            System.out.println("Has elegido una pizza vegetariana con los siguientes ingredientes: " + ingredientes);

        } else if (tipoPizza.equals("no")) {
            System.out.println("Ingredientes no vegetarianos disponibles:");
            System.out.println("1. Peperoni");
            System.out.println("2. Jamón");
            System.out.println("3. Salmón");
            System.out.print("Elige un ingrediente (número): ");
            int eleccion = scanner.nextInt();
            if (eleccion == 1) {
                ingredientes += ", Peperoni";
            } else if (eleccion == 2) {
                ingredientes += ", Jamón";
            } else if (eleccion == 3) {
                ingredientes += ", Salmón";
            } else {
                System.out.println("Opción no válida.");
                scanner.close();
                return;
            }
            System.out.println("Has elegido una pizza no vegetariana con los siguientes ingredientes: " + ingredientes);

        } else {
            System.out.println("Opción no válida.");
        }
    }
}

}
