import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class SistemaGestionInventario extends JFrame {

    private java.util.List<Libro> libros;
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private JTextField txtBuscar;
    private JLabel lblEstado;

    public SistemaGestionInventario() {
        libros = new ArrayList<>();

        setTitle("Gestión de Inventario - Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemCargar = new JMenuItem("Cargar");
        itemGuardar.addActionListener(e -> guardarInventario());
        itemCargar.addActionListener(e -> cargarInventario());
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemCargar);
        menuBar.add(menuArchivo);

        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAyuda = new JMenuItem("Cómo usar");
        itemAyuda.addActionListener(e -> mostrarAyuda());
        menuAyuda.add(itemAyuda);
        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        modeloTabla = new DefaultTableModel(new Object[]{"Título", "Autor", "ISBN"}, 0);
        tablaLibros = new JTable(modeloTabla);

        txtBuscar = new JTextField(20);
        txtBuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                buscarLibro(txtBuscar.getText());
            }
        });

        lblEstado = new JLabel("Listo", JLabel.CENTER);
        lblEstado.setPreferredSize(new Dimension(600, 25));
        lblEstado.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton btnAgregar = new JButton("Agregar Libro");
        btnAgregar.addActionListener(e -> agregarLibro());

        JButton btnEliminar = new JButton("Eliminar Libro");
        btnEliminar.addActionListener(e -> eliminarLibro());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tablaLibros), BorderLayout.CENTER);
        panel.add(txtBuscar, BorderLayout.NORTH);
        panel.add(lblEstado, BorderLayout.SOUTH);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);

        add(panel, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void buscarLibro(String query) {
        java.util.List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(query.toLowerCase()) ||
                libro.getAutor().toLowerCase().contains(query.toLowerCase())) {
                resultados.add(libro);
            }
        }
        actualizarTabla(resultados);
    }

    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog(this, "Título del libro:");
        if (titulo == null || titulo.trim().isEmpty()) {
            lblEstado.setText("Operación cancelada o título inválido");
            return;
        }

        String autor = JOptionPane.showInputDialog(this, "Autor:");
        if (autor == null || autor.trim().isEmpty()) {
            lblEstado.setText("Operación cancelada o autor inválido");
            return;
        }

        String isbn = JOptionPane.showInputDialog(this, "ISBN:");
        if (isbn == null || isbn.trim().isEmpty()) {
            lblEstado.setText("Operación cancelada o ISBN inválido");
            return;
        }

        try {
            for (Libro libro : libros) {
                if (libro.getIsbn().equals(isbn)) {
                    throw new IllegalArgumentException("El libro con ese ISBN ya existe.");
                }
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    throw new IllegalArgumentException("El libro con ese título ya existe.");
                }
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    throw new IllegalArgumentException("El libro con ese autor ya existe.");
                }
            }

            Libro libro = new Libro(titulo, autor, isbn);
            libros.add(libro);
            actualizarTabla(libros);
            lblEstado.setText("Libro agregado correctamente.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarLibro() {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada != -1) {
            String isbn = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
            libros.removeIf(libro -> libro.getIsbn().equals(isbn));
            actualizarTabla(libros);
            lblEstado.setText("Libro eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarTabla(java.util.List<Libro> libros) {
        modeloTabla.setRowCount(0);
        for (Libro libro : libros) {
            modeloTabla.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getIsbn()});
        }
    }

    private void guardarInventario() {
        try {
            FileManager.guardarInventario(libros);
            lblEstado.setText("Inventario guardado correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el inventario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarInventario() {
    String archivoSeleccionado = FileManager.seleccionarArchivoParaCargar();
    
    if (archivoSeleccionado != null) {
        try {
            libros = FileManager.cargarInventario(archivoSeleccionado);
            actualizarTabla(libros);
            lblEstado.setText("Inventario cargado correctamente desde " + archivoSeleccionado);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el inventario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        lblEstado.setText("Operación cancelada.");
    }
}

    private void mostrarAyuda() {
        JOptionPane.showMessageDialog(this, "1. Agregar libro: Ingresa los detalles del libro.\n" +
                "2. Eliminar libro: Selecciona un libro y elimínalo.\n" +
                "3. Buscar libro: Usa el campo de búsqueda para encontrar libros.\n" +
                "4. Guardar y cargar inventario: Guarda o carga los datos en un archivo.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaGestionInventario());
    }
}

class Libro implements Serializable {
    private static final long serialVersionUID = 1L;  // Esta línea es opcional, pero recomendable
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }
}

class FileManager {
    public static void guardarInventario(java.util.List<Libro> libros) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona dónde guardar el inventario");
        fileChooser.setSelectedFile(new File("inventario.dat"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int result = fileChooser.showSaveDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file.exists()) {
                int overwriteOption = JOptionPane.showConfirmDialog(null, 
                        "El archivo ya existe. ¿Deseas sobrescribirlo?", "Confirmar",
                        JOptionPane.YES_NO_OPTION);
                if (overwriteOption != JOptionPane.YES_OPTION) {
                    return; // Si no desea sobrescribir, salimos
                }
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(libros);
                JOptionPane.showMessageDialog(null, "Inventario guardado correctamente en " + file.getAbsolutePath());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    }

    public static java.util.List<Libro> cargarInventario(String archivo) throws IOException, ClassNotFoundException {
        File file = new File(archivo);
        
        if (!file.exists()) {
            throw new FileNotFoundException("El archivo no existe en la ruta especificada.");
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (java.util.List<Libro>) in.readObject();
        }
    }

    public static String seleccionarArchivoParaCargar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo para cargar");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null; 
        }
    }
}