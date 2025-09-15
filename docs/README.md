# Semana 5 Formativa: GestionInventarioJavaV2

## Descripción del Proyecto

Este proyecto es una aplicación de consola en Java que permite gestionar el inventario de una tienda.
Permite agregar, eliminar, actualizar y listar productos en el inventario.

### Recursos adicionales

- Link Miro:
  - [Roadmap - Gestión Inventario en Java alt1](https://miro.com/welcomeonboard/V3dPd3VwcDFveE4rVzNMZm1zODIvalRZb0dVVVBaMTE2cVZSMkxBY2hnVWthU3NSbHZMR1NBSGtremJ5VjZtTzY2cDZVZGJFNUdLR2RBeUd5cDd1NlhuZDZZRWJVYjN3WDJESXhsNmxnSGJCVHRLb1ZBQUxYRm5peTFjR1N0VWRBd044SHFHaVlWYWk0d3NxeHNmeG9BPT0hdjE=?share_link_id=634671075036)
  - [Roadmap - Gestión Inventario en Java alt2](https://miro.com/app/board/uXjVJIIgWos=/?share_link_id=677630185176)
- Link Trello: [Tablero - Gestión Inventario en Java](https://trello.com/b/KFmbDkwP)
- [Requisitos funcionales/no funcionales entrega anterior](<Requerimientos Funcionales V1.md>)
- Diagrama de clases simple:![Diagrama de clases UML](GestionInventarioV2.drawio.svg)

## Rquerimientos del proyecto

| Requisitos funcionales                                                                                                                                                                              | Requisitos no funcionales                                                                                                                                                              |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RF1.** Modelar las entidades **Producto** e **Inventario** con atributos mínimos (`codigo`, `nombre`, `precio`, `stock`, `descripción`) y operaciones para **agregar, actualizar, eliminar, buscar y listar**. | **RNF1.** **Usabilidad en CLI**: menú claro, opciones numeradas, confirmaciones y mensajes de error **descriptivos**.                                                                            |
| **RF2.** **Buscar** producto por **ID**, por **nombre (parcial)** y por **descripción**.                                                                                                                     | **RFN2.** **Código limpio y documentado**: uso de **Javadoc** en clases y métodos clave, y un **README** con instrucciones de ejecución.                                                         |
| **RF3.** **Listar** todos los productos.                                                                                                                                                                     | **RFN3.** **Diseño de clases completado**: incluir un **diagrama simple** de clases (Producto, Inventario, y clase de menú/servicio) con atributos y métodos específicos, versionado en el repo. |
| **RF4.** **Generar reportes**: productos con bajo stock, total de productos, total de unidades y valor total del inventario.                                                                                 | **RFN4.** **Pruebas documentadas**: tabla con casos reales, pasos, resultado esperado/obtenido y anomalías encontradas.                                                                          |
| **RF5.** **Flujo básico de menú en consola**: al menos Agregar, Listar y Buscar.                                                                                                                             |                                                                                                                                                                                        |

## Estructura del Proyecto

El proyecto está organizado en las siguientes clases:

- src:
  - main:
    - java:
      - model:
        - `Producto`: Representa un producto en el inventario.
        - `Inventario`: Gestiona la lista de productos y las operaciones sobre ellos.
        - `MenuPrincipal`: Gestiona la manipulación del inventario en base a uso de usuario.

      - view:
        - `MenuPrincipalView`: Vista para el menú principal.
        - `ProductoView`: Vista específica para productos.

      - controller:
        - `MenuPrincipalController`: Controlador de menú principal, encargado de gestionar la interacción del usuario con las vistas.

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
