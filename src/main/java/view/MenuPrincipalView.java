package view;

import java.util.Scanner;

import model.MenuPrincipal;
import model.Producto;

public class MenuPrincipalView {
    private final Scanner scanner = new Scanner(System.in);
    private final MenuPrincipal menuPrincipal;

    public MenuPrincipalView(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    /**
     * Muestra el menú principal al usuario.
    */
    public void displayMenu() {
        System.out.println("=== MENÚ PRINCIPAL ===");
        System.out.println("1. Agregar producto al inventario");
        System.out.println("2. Actualizar producto del inventario");
        System.out.println("3. Eliminar producto del inventario");
        System.out.println("4. Listar todos los productos");
        System.out.println("5. Buscar producto");
        System.out.println("6. Reporte de inventario");
        System.out.println("0. Salir");
    }

    /**
     * Agrega un nuevo producto al inventario.
    */
    public void agregarProducto(Producto producto) {
        displayMessage("* Al modificar un producto, si se deja algún campo vacío se mantiene el valor actual");
        menuPrincipal.agregarProducto(producto);
    }

    
    /**
     * Elimina un producto del inventario por su código.
     * **/
    public void eliminarProducto(String codigo) {
        if (menuPrincipal.buscarPorId(codigo) == null) {
            displayMessage("No existe un producto con ese código.");
            return;
        }
        menuPrincipal.eliminarProducto(codigo);
        displayMessage("Producto eliminado correctamente.");
    }

    /**
     * Lista todos los productos en el inventario.
    */
    public void listarProductos() {
        System.out.println("=== LISTA DE PRODUCTOS EN INVENTARIO ===");
        System.out.println("Código | Stock | Nombre |  Precio | Descripción ");
        if (menuPrincipal.listarProductos().isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        } else {
            for (Producto p : menuPrincipal.listarProductos()) {
                System.out.printf("%s | %d | %s | %.2f | %s%n",
                        p.getCodigo(), p.getStock(), p.getNombre(), p.getPrecio(), p.getDescripcion());
            }
        }
    }

    /**
     * Genera un reporte completo del inventario.
    */
    public String generarReporteInventario() {
        return "=== REPORTE DE INVENTARIO ===\n" + menuPrincipal.reporteCompleto();
    }

    // Buscar por ID
    public String buscarProductoPorCodigo(String codigo) {
        Producto p = menuPrincipal.buscarPorId(codigo);
        return p != null ? p.getCodigo() : null;
    }

    // Buscar por nombre
    public void buscarProductoPorNombre(String nombre) {
        menuPrincipal.buscarPorNombre(nombre);
    }

    // Buscar por descripcion
    public void buscarProductoPorDescripcion(String descripcion) {
        menuPrincipal.buscarPorDescripcion(descripcion);
    }

    /**
     * Muestra un mensaje al usuario.
    */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Obtiene la opción seleccionada por el usuario en el menú.
    */
    public int getUserChoice() {
        while (true) {
            try {
                System.out.print("Seleccione una opción: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                displayMessage("Error: ingrese un número válido.");
            }
        }
    }

    /**
     * Solicita una entrada al usuario con un mensaje personalizado.
     * @param prompt Mensaje a mostrar al usuario.
     * @return Entrada del usuario como cadena.
    */
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}