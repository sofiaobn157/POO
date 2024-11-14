class LibroNoDisponibleException extends Exception {
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}

class Biblioteca {
    private String titulo;
    private int cantidadCopias;

    public Biblioteca(String titulo, int cantidadCopias) {
        this.titulo = titulo;
        this.cantidadCopias = cantidadCopias;
    }

    public void prestarLibro() throws LibroNoDisponibleException {
        if (cantidadCopias == 0) {
            throw new LibroNoDisponibleException("No hay copias disponibles del libro: " + titulo);
        }
        cantidadCopias--;
        System.out.println("Libro '" + titulo + "' prestado. Quedan " + cantidadCopias + " copias.");
    }
}
