interface Empleado {
double calcularPago();
}

class EmpleadoPorHoras implements Empleado {
private int horasTrabajadas;
private double tarifaPorHora;

public EmpleadoPorHoras(int horasTrabajadas, double tarifaPorHora) {
this.horasTrabajadas = horasTrabajadas;
this.tarifaPorHora = tarifaPorHora;
}

@Override
public double calcularPago() {

if (horasTrabajadas > 40) {
int horasExtra = horasTrabajadas - 40;
return (40 * tarifaPorHora) + (horasExtra * tarifaPorHora * 1.5);
} else {
return horasTrabajadas * tarifaPorHora;
        }
    }   
}

class EmpleadoAsalariado implements Empleado {
private double salarioSemanal;

public EmpleadoAsalariado(double salarioSemanal) {
this.salarioSemanal = salarioSemanal;
}

@Override
public double calcularPago() {
return salarioSemanal;
    }
}

class EmpleadoComisionista implements Empleado {
private double salarioBase;
private double totalVentas;
private double porcentajeComision;

public EmpleadoComisionista(double salarioBase, double totalVentas, double porcentajeComision) {
this.salarioBase = salarioBase;
this.totalVentas = totalVentas;
this.porcentajeComision = porcentajeComision;
    }

@Override
public double calcularPago() {
return salarioBase + (totalVentas * porcentajeComision / 100);
    }
}

public class Main {
public static void main(String[] args) {
Empleado empleadoPorHoras = new EmpleadoPorHoras(45, 20);
Empleado empleadoAsalariado = new EmpleadoAsalariado(1000);
Empleado empleadoComisionista = new EmpleadoComisionista(500, 2000, 5);

System.out.println("Empleado por horas: Pago = $" + empleadoPorHoras.calcularPago());
System.out.println("Empleado asalariado: Pago = $" + empleadoAsalariado.calcularPago());
System.out.println("Empleado comisionista: Pago = $" + empleadoComisionista.calcularPago());
    }
}