import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la marca del automóvil:");
        String marca = scanner.nextLine();

        System.out.println("Ingrese el año del modelo:");
        int modelo = scanner.nextInt();

        System.out.println("Ingrese el volumen del motor en litros:");
        double motor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese el tipo de combustible (GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GASNATURAL):");
        String combustibleStr = scanner.nextLine();
        Combustible tipoCombustible = Combustible.valueOf(combustibleStr.toUpperCase());

        System.out.println("Ingrese el tipo de automóvil (CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV):");
        String tipoAutoStr = scanner.nextLine();
        TipoAutomovil tipoAutomovil = TipoAutomovil.valueOf(tipoAutoStr.toUpperCase());

        System.out.println("Ingrese el número de puertas:");
        int numeroPuertas = scanner.nextInt();

        System.out.println("Ingrese la cantidad de asientos:");
        int cantidadAsientos = scanner.nextInt();

        System.out.println("Ingrese la velocidad máxima en km/h:");
        int velocidadMaxima = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el color (BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA):");
        String colorStr = scanner.nextLine();
        TipoColor color = TipoColor.valueOf(colorStr.toUpperCase());

        Automovil auto = new Automovil(marca, modelo, motor, tipoCombustible, tipoAutomovil, numeroPuertas, cantidadAsientos, velocidadMaxima, color);

        System.out.println("Ingrese la velocidad inicial del automóvil en km/h:");
        int velocidadInicial = scanner.nextInt();
        auto.setVelocidadActual(velocidadInicial);

        System.out.println("Velocidad actual: " + auto.getVelocidadActual() + " km/h");

        System.out.println("Ingrese el incremento de velocidad en km/h:");
        int incremento = scanner.nextInt();
        auto.acelerar(incremento); 

        System.out.println("Ingrese el decremento de velocidad en km/h:");
        int decremento = scanner.nextInt();
        auto.desacelerar(decremento); 
            auto.frenar();

        auto.mostrarValores();
    }
}

