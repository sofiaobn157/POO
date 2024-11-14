class LibroNoDisponibleException(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)

class Biblioteca:
    def __init__(self, titulo, cantidad_copias):
        self.titulo = titulo
        self.cantidad_copias = cantidad_copias

    def prestar_libro(self):
        if self.cantidad_copias == 0:
            raise LibroNoDisponibleException(f"No hay copias disponibles del libro: {self.titulo}")
        self.cantidad_copias -= 1
        print(f"Libro '{self.titulo}' prestado. Quedan {self.cantidad_copias} copias.")

biblioteca = Biblioteca("El Quijote", 2)

try:
    biblioteca.prestar_libro()
    biblioteca.prestar_libro()
    biblioteca.prestar_libro()  # Esto debería lanzar la excepción
except LibroNoDisponibleException as e:
    print(e)
