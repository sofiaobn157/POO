class CupoCompletoException extends Exception {
    public CupoCompletoException(String mensaje) {
        super(mensaje);
    }
}

class ClaseUniversitaria {
    private String[] estudiantes;
    private int contadorEstudiantes;

    public ClaseUniversitaria(int limite) {
        estudiantes = new String[limite];
        contadorEstudiantes = 0;
    }

    public void agregarEstudiante(String nombre) throws CupoCompletoException {
        if (contadorEstudiantes >= estudiantes.length) {
            throw new CupoCompletoException("El cupo de la clase ya está completo.");
        }
        estudiantes[contadorEstudiantes] = nombre;
        contadorEstudiantes++;
    }
}