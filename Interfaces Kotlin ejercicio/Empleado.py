from abc import ABC, abstractmethod

class Empleado(ABC):
    @abstractmethod
    def calcular_pago(self):
        pass

class EmpleadoPorHoras(Empleado):
    def __init__(self, horas_trabajadas, tarifa_hora):
        self.horas_trabajadas = horas_trabajadas
        self.tarifa_hora = tarifa_hora

    def calcular_pago(self):
        if self.horas_trabajadas > 40:
            horas_extra = self.horas_trabajadas - 40
            pago = (40 * self.tarifa_hora) + (horas_extra * self.tarifa_hora * 1.5)
        else:
            pago = self.horas_trabajadas * self.tarifa_hora
        return pago

class EmpleadoAsalariado(Empleado):
    def __init__(self, salario_semanal):
        self.salario_semanal = salario_semanal

    def calcular_pago(self):
        return self.salario_semanal

class EmpleadoComisionista(Empleado):
    def __init__(self, salario_base, ventas_totales, porcentaje_comision):
        self.salario_base = salario_base
        self.ventas_totales = ventas_totales
        self.porcentaje_comision = porcentaje_comision

    def calcular_pago(self):
        comision = self.ventas_totales * (self.porcentaje_comision / 100)
        return self.salario_base + comision

def main():
    empleado_horas = EmpleadoPorHoras(45, 20)
    empleado_asalariado = EmpleadoAsalariado(1000)
    empleado_comisionista = EmpleadoComisionista(500, 2000, 5)

    print(f"Empleado por horas: Pago = ${empleado_horas.calcular_pago()}")
    print(f"Empleado asalariado: Pago = ${empleado_asalariado.calcular_pago()}")
    print(f"Empleado comisionista: Pago = ${empleado_comisionista.calcular_pago()}")

if __name__ == "__main__":
    main()
