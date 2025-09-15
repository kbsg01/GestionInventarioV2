package model;

import java.util.List;

public class MenuPrincipal {

    private final Inventario inventario;

    /**
     * Constructor que inicializa el inventario.
     */
    public MenuPrincipal() {
        this.inventario = new Inventario();
    }

    /**
     * Métodos para interactuar con el inventario
    **/
    //? RF1: Operaciones CRUD
    public void agregarProducto(Producto producto) {
        inventario.addProducto(producto);
    }

    /**
     * Actualiza un producto existente en el inventario.
    */
    public void actualizarProducto(Producto producto) {
        inventario.updateProducto(producto);
    }

    /**
     * Elimina un producto del inventario por su código.
    */
    public void eliminarProducto(String codigo) {
        inventario.deleteProducto(codigo);
    }

    /**
     * Métodos de búsqueda: Buscar por ID
    */
    //? RF2: Búsquedas
    public Producto buscarPorId(String codigo) {
        return inventario.searchByCode(codigo);
    }

    
    /**
     * Métodos de búsqueda: Buscar por nombre parcial
    */
    public List<Producto> buscarPorNombre(String nombre) {
        return inventario.searchByName(nombre);
    }

    
    /**
     * Métodos de búsqueda: Buscar por descripción parcial
    */
    public List<Producto> buscarPorDescripcion(String descripcion) {
        return inventario.searchByDescription(descripcion);
    }


    
    /**
     * Lista todos los productos del inventario
    */
    //? - RF3: Listar todos los productos
    public List<Producto> listarProductos() {
        return inventario.productosConBajoStock(Integer.MAX_VALUE); // Devuelve todos
    }

    /**
     * Lista productos con stock menor o igual al umbral dado
     * @return Lista de productos con stock bajo.
     */
    //? - RF4: Reporte
    public String reporteCompleto() {
        return inventario.getReporteInventario();
    }

    /**
     * Obtiene el inventario (para uso interno o pruebas).
    */
    public Inventario getInventario() {
        return inventario;
    }

}
