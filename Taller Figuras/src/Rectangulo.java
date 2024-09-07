public class Rectangulo extends FiguraGeometrica{
        Double base;
        Double altura;

        public Rectangulo(double b, double h){
            base = b;
            altura = h;
        }
        public double calcularArea() {
            return base * altura;
        }
        
        public double calcularPerimetro(){
            return 2 * (base + altura);
        }

    
    }