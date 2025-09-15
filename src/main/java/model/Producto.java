package model;

public class Producto {
    private final String codigo;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;

    /**
     * Constructor de la clase Producto.
     * 
     * @param codigo      Código único del producto.
     * @param nombre      Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param stock       Cantidad en inventario.
     * @param precio      Precio del producto.
     */
    public Producto(String codigo, String nombre, String descripcion, double precio, int stock) {
        this.codigo = codigo;
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setStock(stock);
        this.setPrecio(precio);
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Muestra la descripción completa del producto.
     **/
    public String fullDescription() {
        return "DETALLE DEL PRODUCTO\n" +
                "Código: " + this.getCodigo() + "\n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Precio: $" + this.getPrecio() + "\n" +
                "Stock: " + this.getStock() + "\n" +
                "Descripción: " + this.getDescripcion();
    }

    /**
     * Representación en cadena del producto.
     * 
     * @return Una cadena que representa el producto.
     **/
    @Override
    public String toString() {
        return "[ " + codigo + " ] | " + stock + " | " + nombre + " | $" + precio + " | "
                + descripcion.substring(0, Math.min(20, descripcion.length())) + "..." + " |";
    }
}
