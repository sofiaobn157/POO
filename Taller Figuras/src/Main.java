import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el radio del circulo: ");
        double radio = scanner.nextDouble();
        Circulo circulo = new Circulo(radio);

        System.out.print("Ingrese la base del rectangulo: ");
        double baseRectangulo = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectangulo: ");
        double alturaRectangulo = scanner.nextDouble();
        Rectangulo rectangulo = new Rectangulo(baseRectangulo, alturaRectangulo);

        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        Cuadrado cuadrado = new Cuadrado(lado);

        System.out.print("Ingrese la base del triangulo rectangulo: ");
        double baseTriangulo = scanner.nextDouble();
        
        System.out.print("Ingrese la altura del triangulo rectangulo: ");
        double alturaTriangulo = scanner.nextDouble();
        TrianguloRectangulo triRectangulo = new TrianguloRectangulo(baseTriangulo, alturaTriangulo);

        System.out.println("Circulo:");
        System.out.println("Area: " + circulo.calcularArea());
        System.out.println("Perimetro: " + circulo.calcularPerimetro());

        System.out.println("Rectangulo:");
        System.out.println("Area: " + rectangulo.calcularArea());
        System.out.println("Perimetro: " + rectangulo.calcularPerimetro());

        System.out.println("Cuadrado:");
        System.out.println("Area: " + cuadrado.calcularArea());
        System.out.println("Perimetro: " + cuadrado.calcularPerimetro());

        System.out.println("Triangulo Rectangulo:");
        System.out.println("Area: " + triRectangulo.calcularArea());
        System.out.println("Perimetro: " + triRectangulo.calcularPerimetro());
        System.out.println("Hipotenusa: " + triRectangulo.calcularHipotenusa());
        System.out.println("Tipo: " + triRectangulo.determinarTipo());
        
        }
    }