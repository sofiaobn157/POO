class CupoCompletoException(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)

class ClaseUniversitaria:
    def __init__(self, limite):
        self.estudiantes = []
        self.limite = limite

    def agregar_estudiante(self, nombre):
        if len(self.estudiantes) >= self.limite:
            raise CupoCompletoException("El cupo de la clase ya está completo.")
        self.estudiantes.append(nombre)

try:
    clase = ClaseUniversitaria(30)
    
    for i in range(35):
        clase.agregar_estudiante(f"Estudiante {i + 1}")
except CupoCompletoException as e:
    print(e)
