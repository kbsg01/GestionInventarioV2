package controller;

import view.*;
import model.MenuPrincipal;
import model.Producto;

import java.util.List;

public class MenuPrincipalController {
    private final MenuPrincipalView menuView;
    private final ProductoView productoView;
    private final MenuPrincipal menuPrincipal;

    public MenuPrincipalController(MenuPrincipalView menuView, ProductoView productoView, MenuPrincipal menuPrincipal) {
        this.menuView = menuView;
        this.productoView = productoView;
        this.menuPrincipal = menuPrincipal;
    }

    /**
     * Inicia el menú principal y gestiona las opciones del usuario.
    */
    public void run() {
        int opcion;
        do {
            menuView.displayMenu();
            opcion = menuView.getUserChoice();
            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> actualizarProducto();
                case 3 -> eliminarProducto();
                case 4 -> listarProductos();
                case 5 -> buscarProducto();
                case 6 -> mostrarReporteInventario();
                case 0 -> menuView.displayMessage("Saliendo...");
                default -> menuView.displayMessage("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Permite al usuario agregar un nuevo producto al inventario.
    */
    // RF1: Agregar producto
    private void agregarProducto() {
        Producto nuevo = productoView.crearProducto();
        if (nuevo == null) {
            menuView.displayMessage("No se creó el producto.");
            return;
        }
        // Verificar existencia usando el modelo
        if (menuPrincipal.buscarPorId(nuevo.getCodigo()) != null) {
            menuView.displayMessage("Ya existe un producto con ese código.");
            return;
        }
        menuPrincipal.agregarProducto(nuevo);
        menuView.displayMessage("Producto agregado correctamente.");
    }

    /**
     * Permite al usuario actualizar un producto existente.
    */
    // RF1: Actualizar producto
    private void actualizarProducto() {
        menuView.displayMessage("* Al modificar un producto, si se deja algún campo vacío se mantiene el valor actual");
        String codigo = productoView.obtenerCampoObligatorio("Código del producto a actualizar");
        Producto existente = menuPrincipal.buscarPorId(codigo);
        if (existente == null) {
            menuView.displayMessage("No existe un producto con ese código.");
            return;
        }
        productoView.actualizarProducto(existente);
        menuPrincipal.actualizarProducto(existente);
        menuView.displayMessage("Producto actualizado correctamente.");
    }

    /**
     * Permite al usuario eliminar un producto por su código.
    */
    // RF1: Eliminar producto
    private void eliminarProducto() {
        String codigo = productoView.obtenerCampoObligatorio("Código del producto a eliminar");
        Producto existente = menuPrincipal.buscarPorId(codigo);
        if (existente == null) {
            menuView.displayMessage("No existe un producto con ese código.");
            return;
        }
        menuPrincipal.eliminarProducto(codigo);
        menuView.displayMessage("Producto eliminado correctamente.");
    }

    /**
     * Permite al usuario buscar productos por código, nombre o descripción.
    */
    // RF2: Método unificado para búsqueda
    private void buscarProducto() {
        menuView.displayMessage("Seleccione el campo de búsqueda:");
        menuView.displayMessage("1. Buscar por código (ID)");
        menuView.displayMessage("2. Buscar por nombre (parcial)");
        menuView.displayMessage("3. Buscar por descripción (parcial)");
        int opcion = menuView.getUserChoice();

        String input;
        List<Producto> resultados;

        switch (opcion) {
            case 1 -> {
                input = menuView.getInput("Ingrese el código a buscar: ");
                Producto producto = menuPrincipal.buscarPorId(input);
                menuView.displayMessage(producto.fullDescription());
            }
            case 2 -> {
                input = menuView.getInput("Ingrese el nombre (o parte) a buscar: ");
                if (input.isBlank()) {
                    menuView.displayMessage("El nombre no puede estar vacío.");
                    return; 
                }
                resultados = menuPrincipal.buscarPorNombre(input);
                resultados.forEach(p -> menuView.displayMessage(p.fullDescription()));
            }
            case 3 -> {
                input = menuView.getInput("Ingrese la descripción (o parte) a buscar: ");
                if(input.isBlank()) {
                    menuView.displayMessage("La descripción no puede estar vacía.");
                    return;
                }
                resultados = menuPrincipal.buscarPorDescripcion(input);
                resultados.forEach(p -> menuView.displayMessage(p.fullDescription()));
            }
            default -> menuView.displayMessage("Opción de búsqueda no válida.");
        }
    }

    /**
     * Muestra todos los productos en el inventario con detalles completos.
     */
    // RF3: Listar todos los productos
    private void listarProductos() {
        List<Producto> productos = menuPrincipal.listarProductos();
        if (productos == null || productos.isEmpty()) {
            menuView.displayMessage("No hay productos en el inventario.");
        }
        productos.forEach(p -> menuView.displayMessage(p.fullDescription()));
    }

    /**
     * Muestra un resumen detallado de todos los productos en el inventario.
     **/
    // RF4: Mostrar reporte completo del inventario
    private void mostrarReporteInventario() {
        String reporte = menuPrincipal.reporteCompleto();
        menuView.displayMessage(reporte);
    }
}