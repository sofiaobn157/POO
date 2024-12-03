import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

interface Operaciones {
    void agregar();
    void editar();
    void eliminar();
}

class Plato {
    private String nombre;
    private double precio;
    private String descripcion;

    public Plato(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}

class Menu implements Operaciones {
    private List<Plato> platos;

    public Menu() {
        platos = new ArrayList<>();
    }

    @Override
    public void agregar() {
        String nombre = JOptionPane.showInputDialog("Nombre del Plato:");
        String precioStr = JOptionPane.showInputDialog("Precio del Plato:");
        String descripcion = JOptionPane.showInputDialog("Descripcion del Plato:");
        if (nombre != null && precioStr != null && descripcion != null) {
            try {
                double precio = Double.parseDouble(precioStr);
                platos.add(new Plato(nombre, precio, descripcion));
                JOptionPane.showMessageDialog(null, "Plato agregado");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Precio invalido");
            }
        }
    }

    @Override
    public void editar() {
        String nombre = JOptionPane.showInputDialog("Nombre del Plato a editar:");
        for (Plato plato : platos) {
            if (plato.getNombre().equals(nombre)) {
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                String nuevoPrecio = JOptionPane.showInputDialog("Nuevo precio:");
                String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripcion:");
                try {
                    double precio = Double.parseDouble(nuevoPrecio);
                    platos.add(new Plato(nuevoNombre, precio, nuevaDescripcion)); // Editamos el plato
                    JOptionPane.showMessageDialog(null, "Plato editado");
                    break;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Precio invalido");
                }
            }
        }
    }

    @Override
    public void eliminar() {
        String nombre = JOptionPane.showInputDialog("Nombre del Plato a eliminar:");
        platos.removeIf(plato -> plato.getNombre().equals(nombre));
        JOptionPane.showMessageDialog(null, "Plato eliminado");
    }

    public List<Plato> getPlatos() {
        return platos;
    }
}

class Cliente implements Operaciones {
    private String nombre;
    private boolean frecuente;

    public Cliente(String nombre, boolean frecuente) {
        this.nombre = nombre;
        this.frecuente = frecuente;
    }

    @Override
    public void agregar() {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del Cliente:");
        String frecuenteStr = (String) JOptionPane.showInputDialog(null, "Es Cliente Frecuente?", "Cliente",
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"Si", "No"}, "No");
        if (nombreCliente != null && frecuenteStr != null) {
            boolean frecuente = frecuenteStr.equalsIgnoreCase("Si");
            Cliente cliente = new Cliente(nombreCliente, frecuente);
            JOptionPane.showMessageDialog(null, "Cliente agregado");
        }
    }

    @Override
    public void editar() {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del Cliente a editar:");
        if (nombreCliente != null) {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
            String frecuenteStr = (String) JOptionPane.showInputDialog(null, "Es Cliente Frecuente?", "Cliente",
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"Si", "No"}, "No");
            boolean frecuente = frecuenteStr.equalsIgnoreCase("Si");
            this.nombre = nuevoNombre;
            this.frecuente = frecuente;
            JOptionPane.showMessageDialog(null, "Cliente editado");
        }
    }

    @Override
    public void eliminar() {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del Cliente a eliminar:");
        if (nombreCliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isFrecuente() {
        return frecuente;
    }
}

class Mesa {
    private int id;
    private int capacidad;
    private boolean ocupada;

    public Mesa(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.ocupada = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Mesa " + id + " (Capacidad: " + capacidad + ")";
    }
}

class Pedido {
    private Cliente cliente;
    private List<Plato> platos;
    private Mesa mesa;
    private String estado;

    public Pedido(Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
        this.platos = new ArrayList<>();
        this.mesa = mesa;
        this.estado = "Pendiente";
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public double calcularTotal() {
        double total = 0;
        for (Plato plato : platos) {
            total += plato.getPrecio();
        }
        if (cliente.isFrecuente()) {
            total *= 0.9;
        }
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<Plato> getPlatos() {
        return platos;
    }
}

public class RestauranteApp extends JFrame {
    private Menu menu;
    private List<Pedido> pedidos;
    private List<Mesa> mesas;
    private JTextArea areaPedidos;

    public RestauranteApp() {
        setTitle("Gestion de Restaurante");
        setSize(800, 600); // Ajustamos el tamaño para más espacio
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        menu = new Menu();
        pedidos = new ArrayList<>();
        mesas = new ArrayList<>();

        JButton btnAgregarPlato = new JButton("Agregar Plato");
        btnAgregarPlato.addActionListener(e -> menu.agregar());

        JButton btnAgregarMesa = new JButton("Agregar Mesa");
        btnAgregarMesa.addActionListener(e -> agregarMesa());

        JButton btnRegistrarPedido = new JButton("Registrar Pedido");
        btnRegistrarPedido.addActionListener(e -> registrarPedido());

        JButton btnMostrarPedidos = new JButton("Mostrar Pedidos");
        btnMostrarPedidos.addActionListener(e -> mostrarPedidos());

        JButton btnCambiarEstado = new JButton("Cambiar Estado Pedido");
        btnCambiarEstado.addActionListener(e -> cambiarEstadoPedido());

        JButton btnDescargarReporte = new JButton("Descargar Reporte");
        btnDescargarReporte.addActionListener(e -> descargarReporte());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Ajustamos el espacio entre los botones
        panelBotones.setPreferredSize(new Dimension(800, 80)); // Tamaño suficiente para los botones
        panelBotones.add(btnAgregarPlato);
        panelBotones.add(btnAgregarMesa);
        panelBotones.add(btnRegistrarPedido);
        panelBotones.add(btnMostrarPedidos);
        panelBotones.add(btnCambiarEstado);
        panelBotones.add(btnDescargarReporte);

        areaPedidos = new JTextArea(15, 60);
        areaPedidos.setEditable(false);
        JScrollPane scrollPedidos = new JScrollPane(areaPedidos);

        add(panelBotones, BorderLayout.NORTH);
        add(scrollPedidos, BorderLayout.CENTER);
    }

    private void agregarMesa() {
        String idStr = JOptionPane.showInputDialog("Numero de Mesa:");
        String capacidadStr = JOptionPane.showInputDialog("Capacidad de la Mesa:");
        if (idStr != null && capacidadStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                int capacidad = Integer.parseInt(capacidadStr);
                mesas.add(new Mesa(id, capacidad));
                JOptionPane.showMessageDialog(this, "Mesa agregada");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Datos invalidos");
            }
        }
    }

    private void registrarPedido() {
        if (mesas.isEmpty() || menu.getPlatos().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay mesas ni platos disponibles");
            return;
        }

        String nombreCliente = JOptionPane.showInputDialog("Nombre del Cliente:");
        String frecuenteStr = (String) JOptionPane.showInputDialog(this, "Es Cliente Frecuente?", "Cliente",
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"Si", "No"}, "No");

        if (nombreCliente != null && frecuenteStr != null) {
            boolean frecuente = frecuenteStr.equalsIgnoreCase("Si");
            Cliente cliente = new Cliente(nombreCliente, frecuente);

            Mesa mesa = (Mesa) JOptionPane.showInputDialog(this, "Seleccione una Mesa", "Mesa",
                    JOptionPane.QUESTION_MESSAGE, null, mesas.toArray(), mesas.get(0));

            if (mesa != null) {
                Pedido pedido = new Pedido(cliente, mesa);
                pedido.agregarPlato(menu.getPlatos().get(0)); // Puedes agregar más platos
                pedidos.add(pedido);
                JOptionPane.showMessageDialog(this, "Pedido registrado");
            }
        }
    }

    private void mostrarPedidos() {
        areaPedidos.setText("");
        for (Pedido pedido : pedidos) {
            areaPedidos.append("Cliente: " + pedido.getCliente().getNombre() + "\n");
            areaPedidos.append("Mesa: " + pedido.getMesa() + "\n");
            areaPedidos.append("Platos: \n");
            for (Plato plato : pedido.getPlatos()) {
                areaPedidos.append("- " + plato.getNombre() + ": $" + plato.getPrecio() + "\n");
            }
            areaPedidos.append("Total: $" + pedido.calcularTotal() + "\n");
            areaPedidos.append("Estado: " + pedido.getEstado() + "\n\n");
        }
    }

    private void cambiarEstadoPedido() {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del Cliente:");
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getNombre().equals(nombreCliente)) {
                String[] estados = {"Pendiente", "Enviado", "Servido"};
                JComboBox<String> comboBox = new JComboBox<>(estados);
                
                int option = JOptionPane.showConfirmDialog(this, comboBox, "Selecciona el nuevo estado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
                if (option == JOptionPane.OK_OPTION) {
                    String estadoSeleccionado = (String) comboBox.getSelectedItem();
                    if (estadoSeleccionado != null) {
                        pedido.setEstado(estadoSeleccionado);
                        JOptionPane.showMessageDialog(this, "Estado cambiado a: " + estadoSeleccionado);
                        break;
                    }
                }
            }
        }
    }

    private void descargarReporte() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como CSV");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV Files", "csv"));
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            if (!file.getName().endsWith(".csv")) {
                file = new File(file.getAbsolutePath() + ".csv");
            }
    
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("Cliente, Mesa, Platos, Total, Estado\n");
    
                for (Pedido pedido : pedidos) {
                    writer.write(pedido.getCliente().getNombre() + ", ");
                    writer.write(pedido.getMesa().getId() + ", ");
                    
                    StringBuilder platos = new StringBuilder();
                    for (Plato plato : pedido.getPlatos()) {
                        platos.append(plato.getNombre()).append(" ($").append(plato.getPrecio()).append("), ");
                    }
                    if (platos.length() > 0) platos.setLength(platos.length() - 2);
                    
                    writer.write(platos.toString() + ", ");
                    writer.write(pedido.calcularTotal() + ", ");
                    writer.write(pedido.getEstado() + "\n");
                }
                
                JOptionPane.showMessageDialog(this, "Reporte CSV guardado exitosamente");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el reporte CSV");
            }
        }
    }

    public void generarCuentaFinal(Pedido pedido) {
        double totalPlatos = 0;
        StringBuilder resumenPlatos = new StringBuilder();
        for (Plato plato : pedido.getPlatos()) {
            totalPlatos += plato.getPrecio();
            resumenPlatos.append(plato.getNombre()).append(" ($").append(plato.getPrecio()).append("), ");
        }

        if (resumenPlatos.length() > 0) {
            resumenPlatos.setLength(resumenPlatos.length() - 2);
        }

        double descuento = 0;
        if (pedido.getCliente().isFrecuente()) {
            descuento = totalPlatos * 0.1; 
        }

        double totalConDescuento = totalPlatos - descuento;

        String cuentaFinal = "Cliente: " + pedido.getCliente().getNombre() + "\n" +
                             "Mesa: " + pedido.getMesa().getId() + "\n" +
                             "Platos: " + resumenPlatos.toString() + "\n" +
                             "Total: $" + totalPlatos + "\n" +
                             "Descuento: -$" + descuento + "\n" +
                             "Total con Descuento: $" + totalConDescuento + "\n" +
                             "Estado: " + pedido.getEstado();
        
        JOptionPane.showMessageDialog(null, cuentaFinal, "Cuenta Final", JOptionPane.INFORMATION_MESSAGE);
    }

    public void generarReporteCuentaFinal() {
        for (Pedido pedido : pedidos) {
            generarCuentaFinal(pedido);
        }
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RestauranteApp app = new RestauranteApp();
            app.setVisible(true);
        });
    }
}