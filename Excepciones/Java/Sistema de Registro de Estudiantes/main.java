public class Main {
    public static void main(String[] args) {
        ClaseUniversitaria clase = new ClaseUniversitaria(30);

        try {
            for (int i = 0; i < 35; i++) {
                clase.agregarEstudiante("Estudiante " + (i + 1));
            }
        } catch (CupoCompletoException e) {
            System.out.println(e.getMessage());
        }
    }
}