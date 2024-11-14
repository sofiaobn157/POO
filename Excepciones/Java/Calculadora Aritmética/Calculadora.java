class DivisionPorCeroException extends Exception {
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}

class Calculadora {
    public double dividir(int a, int b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException("No se puede dividir por cero.");
        }
        return (double) a / b;
    }
}
