class DivisionPorCeroException(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)

class Calculadora:
    def dividir(self, a, b):
        if b == 0:
            raise DivisionPorCeroException("No se puede dividir por cero.")
        return a / b

calculadora = Calculadora()

try:
    a = int(input("Ingresa el primer número: "))
    b = int(input("Ingresa el segundo número: "))
    resultado = calculadora.dividir(a, b)
    print(f"Resultado: {resultado}")
except DivisionPorCeroException as e:
    print(e)
