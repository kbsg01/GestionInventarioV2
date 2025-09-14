# Semana 5 Formativa: GestionInventarioJavaV2

## Descripción del Proyecto

Este proyecto es una aplicación de consola en Java que permite gestionar el inventario de una tienda.
Permite agregar, eliminar, actualizar y listar productos en el inventario.

## Rquerimientos del proyecto

| Requisitos funcionales                                                                                                                                                                              | Requisitos no funcionales                                                                                                                                                              |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Modelar las entidades **Producto** e **Inventario** con atributos mínimos (`id`, `nombre`, `precio`, `stock`, `descripción`) y operaciones para **agregar, actualizar, eliminar, buscar y listar**. | **Usabilidad en CLI**: menú claro, opciones numeradas, confirmaciones y mensajes de error **descriptivos**.                                                                            |
| **Buscar** producto por **ID**, por **nombre (parcial)** y por **descripción**.                                                                                                                     | **Código limpio y documentado**: uso de **Javadoc** en clases y métodos clave, y un **README** con instrucciones de ejecución.                                                         |
| **Listar** todos los productos.                                                                                                                                                                     | **Diseño de clases completado**: incluir un **diagrama simple** de clases (Producto, Inventario, y clase de menú/servicio) con atributos y métodos específicos, versionado en el repo. |
| **Generar reportes**: productos con bajo stock, total de productos, total de unidades y valor total del inventario.                                                                                 | **Pruebas documentadas**: tabla con casos reales, pasos, resultado esperado/obtenido y anomalías encontradas.                                                                          |
| **Flujo básico de menú en consola**: al menos Agregar, Listar y Buscar.                                                                                                                             |                                                                                                                                                                                        |

## Estructura del Proyecto

El proyecto está organizado en las siguientes clases:

- src:
  - main:
    - java:
      - model:
        - `Producto`: Representa un producto en el inventario.
        - `Inventario`: Gestiona la lista de productos y las operaciones sobre ellos.
        - `Categoria`: Enum para las categorías de productos.

      - view:
        - `IView`:
        - `MenuPrincipalView` implementa `IView`: Vista para el menú principal.
        - `ProductoView` implementa `IView`: Vista específica para productos.
        - `InventarioView` implementa `IView`: Vista específica para el inventario.

      - controller:
        - `IController`: Interfaz para el controlador.

      - demo:
        - `GestionInventario`: Clase principal que inicia la aplicación.
  - test:
    - java:
      - integracion:
        - `ProductoInventarioTest`: Pruebas de integración para las clases `Producto` e `Inventario`.
      - unitarias:
        - `ProductoTest`: Pruebas unitarias para la clase `Producto`.
        - `InventarioTest`: Pruebas unitarias para la clase `Inventario`.

## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clonar el repositorio:
2. Navegar al directorio del proyecto
3. Compilar el proyecto usando un IDE como IntelliJ IDEA o NetBeans, o desde la línea de comandos con `javac`.
4. Ejecutar la clase `GestionInventario` para iniciar la aplicación.
5. Seguir las instrucciones en la consola para gestionar el inventario.

## Pruebas de integración y unitarias

El proyecto incluye pruebas de integración y unitarias para asegurar la funcionalidad correcta de las clases principales
implementadas con JUnit.

- Las pruebas unitarias se encuentran en la carpeta `test/unitarias` y cubren métodos individuales de las clases `Producto` e `Inventario`.
- Las pruebas de integración se encuentran en la carpeta `test/integracion` y verifican la interacción entre las clases `Producto` e `Inventario`.
