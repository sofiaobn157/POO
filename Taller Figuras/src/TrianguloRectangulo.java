public class TrianguloRectangulo extends FiguraGeometrica {
        double base;
        double altura;
    
        public TrianguloRectangulo(double b, double h) {
            base = b; 
            altura = h;
        }
    
        public double calcularArea() {
            return 0.5 * base * altura;
        }
    
        public double calcularPerimetro() {
            double hipotenusa = Math.sqrt(base * base + altura * altura);
            return base + altura + hipotenusa;
        }
    
        public double calcularHipotenusa() {
            return Math.sqrt(base * base + altura * altura);
        }
    
        public String determinarTipo() {
            double hipotenusa = calcularHipotenusa();
            if (base == altura && base == hipotenusa) {
                return "Equilátero";
            } else if (base == altura || base == hipotenusa || altura == hipotenusa) {
                return "Isósceles";
            } else {
                return "Escaleno";
            }
        }

}