enum Combustible {
    GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GASNATURAL
}

enum TipoAutomovil {
    CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV
}

enum TipoColor {
    BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA
}

public class Automovil {
    private String marca;
    private int modelo;
    private double motor;
    private Combustible tipoCombustible;
    private TipoAutomovil tipoAutomovil;
    private int numeroPuertas;
    private int cantidadAsientos;
    private int velocidadMaxima;
    private TipoColor color;
    private int velocidadActual;

    public Automovil(String marca, int modelo, double motor, Combustible tipoCombustible, TipoAutomovil tipoAutomovil,
                     int numeroPuertas, int cantidadAsientos, int velocidadMaxima, TipoColor color) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.velocidadActual = 0;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public double getMotor() {
        return motor;
    }

    public Combustible getTipoCombustible() {
        return tipoCombustible;
    }

    public TipoAutomovil getTipoAutomovil() {
        return tipoAutomovil;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public TipoColor getColor() {
        return color;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public void setTipoCombustible(Combustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public void setTipoAutomovil(TipoAutomovil tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setColor(TipoColor color) {
        this.color = color;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public void acelerar(int incremento) {
        if (velocidadActual + incremento > velocidadMaxima) {
            System.out.println("No se puede acelerar más allá de la velocidad máxima.");
        } else {
            velocidadActual += incremento;
            System.out.println("Velocidad actual después de aumentar: " + velocidadActual + " km/h");
        }
    }
    
    public void desacelerar(int decremento) {
        if (velocidadActual - decremento < 0) {
            System.out.println("No se puede desacelerar a una velocidad negativa.");
        } else {
            velocidadActual -= decremento;
            System.out.println("Velocidad actual después de disminuir: " + velocidadActual + " km/h");
        }
    }

    public void frenar() {
        velocidadActual = 0;
        System.out.println("Automóvil detenido. Velocidad actual: " + velocidadActual + " km/h");
    }

    public void calcularTiempoEstimada(double distancia) {
        if (velocidadActual == 0) {
            System.out.println("El automóvil está detenido. No se puede calcular el tiempo estimado.");
        } else {
            double tiempo = distancia / velocidadActual;
            System.out.println("Tiempo estimado de llegada: " + tiempo + " horas");
        }
    }

    public void mostrarValores() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Motor: " + motor + " litros");
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Tipo de Automóvil: " + tipoAutomovil);
        System.out.println("Número de Puertas: " + numeroPuertas);
        System.out.println("Cantidad de Asientos: " + cantidadAsientos);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Velocidad Actual: " + velocidadActual + " km/h");
    }
}
