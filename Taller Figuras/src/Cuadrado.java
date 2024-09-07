public class Cuadrado extends FiguraGeometrica {
        double lado;
    
        public Cuadrado(double l) {
            lado = l;
        }
    
        public double calcularArea() {
            return lado * lado;
        }
    
        public double calcularPerimetro() {
            return 4 * lado;
        }
    }