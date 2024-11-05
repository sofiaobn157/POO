import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Colecciones {
    private ArrayList<String> tareas = new ArrayList<>();
    private HashSet<String> usuarios = new HashSet<>();
    private HashMap<Integer, String> detallesUsuarios = new HashMap<>();
    private Stack<String> accionesTexto = new Stack<>();
    private TreeSet<Double> preciosProductos = new TreeSet<>();

    public static void main(String[] args) {
        Colecciones app = new Colecciones();
        app.menuPrincipal();
    }

    private void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Gestion de Tareas");
            System.out.println("2. Registro de Usuarios");
            System.out.println("3. Editor de Texto (Deshacer)");
            System.out.println("4. Gestion de Productos (Precios)");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarTareas(scanner);
                    break;
                case 2:
                    registrarUsuarios(scanner);
                    break;
                case 3:
                    editorTexto(scanner);
                    break;
                case 4:
                    gestionarProductos(scanner);
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private void gestionarTareas(Scanner scanner) {
        while (true) {
            System.out.println("\nGestion de Tareas:");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Completar tarea");
            System.out.println("3. Mostrar tareas");
            System.out.println("4. Volver al menu principal");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la tarea: ");
                    String tarea = scanner.nextLine();
                    tareas.add(tarea);
                    break;
                case 2:
                    System.out.print("Introduce el indice de la tarea completada: ");
                    int indiceCompleto = scanner.nextInt();
                    if (indiceCompleto >= 0 && indiceCompleto < tareas.size()) {
                        tareas.remove(indiceCompleto);
                        System.out.println("Tarea completada.");
                    } else {
                        System.out.println("Indice no valido.");
                    }
                    break;
                case 3:
                    System.out.println("Tareas pendientes: " + tareas);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private void registrarUsuarios(Scanner scanner) {
        while (true) {
            System.out.println("\nRegistro de Usuarios:");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Volver al menu principal");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre de usuario: ");
                    String usuario = scanner.nextLine();
                    if (usuarios.add(usuario)) {
                        System.out.println("Usuario registrado exitosamente.");
                    } else {
                        System.out.println("El usuario ya existe.");
                    }
                    break;
                case 2:
                    System.out.println("Usuarios registrados: " + usuarios);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private void editorTexto(Scanner scanner) {
        while (true) {
            System.out.println("\nEditor de Texto (Eliminar):");
            System.out.println("Escribe algo (o 'eliminar' para eliminar): ");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("eliminar")) {
                if (!accionesTexto.isEmpty()) {
                    accionesTexto.pop();
                    System.out.println("Ultima accion eliminada.");
                } else {
                    System.out.println("No hay acciones para eliminar.");
                }
            } else {
                accionesTexto.push(entrada);
                System.out.println("Acción guardada: " + entrada);
            }
            System.out.println("Acciones actuales: " + accionesTexto);
        }
    }

    private void gestionarProductos(Scanner scanner) {
        while (true) {
            System.out.println("\nGestion de Productos:");
            System.out.println("1. Añadir precio");
            System.out.println("2. Mostrar precios ordenados");
            System.out.println("3. Volver al menu principal");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el precio del producto: ");
                    double precio = scanner.nextDouble();
                    preciosProductos.add(precio);
                    break;
                case 2:
                    System.out.println("Precios ordenados: " + preciosProductos);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
