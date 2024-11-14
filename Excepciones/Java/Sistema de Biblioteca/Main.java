public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("El Quijote", 2);

        try {
            biblioteca.prestarLibro();
            biblioteca.prestarLibro();
            biblioteca.prestarLibro();
        } catch (LibroNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }
}
