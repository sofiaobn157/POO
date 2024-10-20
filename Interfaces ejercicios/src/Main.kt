interface Empleado {
    fun calcularPago(): Double
}

class EmpleadoPorHoras(val horasTrabajadas: Int, val tarifaHora: Double) : Empleado {
    override fun calcularPago(): Double {
        return if (horasTrabajadas > 40) {
            val horasExtra = horasTrabajadas - 40
            (40 * tarifaHora) + (horasExtra * tarifaHora * 1.5)
        } else {
            horasTrabajadas * tarifaHora
        }
    }
}

class EmpleadoAsalariado(val salarioSemanal: Double) : Empleado {
    override fun calcularPago(): Double {
        return salarioSemanal
    }
}

class EmpleadoComisionista(val salarioBase: Double, val ventasTotales: Double, val porcentajeComision: Double) : Empleado {
    override fun calcularPago(): Double {
        val comision = ventasTotales * (porcentajeComision / 100)
        return salarioBase + comision
    }
}

fun main() {
    // Creamos empleados
    val empleadoPorHoras = EmpleadoPorHoras(45, 20.0)
    val empleadoAsalariado = EmpleadoAsalariado(1000.0)
    val empleadoComisionista = EmpleadoComisionista(500.0, 2000.0, 5.0)

    println("Empleado por horas: Pago = $${empleadoPorHoras.calcularPago()}")
    println("Empleado asalariado: Pago = $${empleadoAsalariado.calcularPago()}")
    println("Empleado comisionista: Pago = $${empleadoComisionista.calcularPago()}")
}
