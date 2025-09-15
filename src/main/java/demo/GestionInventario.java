package demo;

import controller.MenuPrincipalController;
import model.Inventario;
import model.MenuPrincipal;
import model.Producto;
import view.MenuPrincipalView;
import view.ProductoView;

public class GestionInventario {

    public static void main(String[] args) {
        
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuPrincipalView menuView = new MenuPrincipalView(menuPrincipal);
        ProductoView productoView = new ProductoView();
        Inventario inventario = menuPrincipal.getInventario();
        
        //Stack de datos de prueba
        inventario.addProducto(new Producto("P001", "Laptop HP", "Portátil para oficina", 429990.0, 10));
        inventario.addProducto(new Producto("P002", "Laptop Dell", "Portátil para gaming", 1200000.0, 8));
        inventario.addProducto(new Producto("P003", "Audifonos Razer", "Audifonos para gaming", 55000, 4));
        inventario.addProducto(new Producto("P004", "Audifonos Sony", "Audifonos con cancelación de ruido", 155000, 2));
        inventario.addProducto(new Producto("P005", "Teclado Redragon", "Teclado mecanico", 35000, 6));
        inventario.addProducto(new Producto("P006", "Teclado HP", "Teclado de oficina", 25000, 10));
        
        
        MenuPrincipalController controller = new MenuPrincipalController(menuView, productoView, menuPrincipal);
        controller.run();
    }
}
