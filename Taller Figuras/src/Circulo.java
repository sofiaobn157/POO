public class Circulo extends FiguraGeometrica{
        Double radio;

        public Circulo(double r){
            radio = r;
        }

        public double calcularArea(){
            return 3.1416 * radio * radio;
        }

        public double calcularPerimetro(){
            return 2 * 3.1416 * radio;
        }

    }