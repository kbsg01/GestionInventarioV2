# Evidencia

## Tabla de pruebas

| ID  | Caso de prueba                                              | Secuencia de entrada (consola)                                                                                                                                                      | Estado inicial                                                                                                               | Resultado esperado                                                                                                               | Resultado observado | Notas / cómo forzar fallo                                                                                 |
|-----|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|---------------------|------------------------------------------------------------------------------------------------------------|
| T01 | Agregar producto — caso válido                              | Menú -> 1 -> Código: P007 -> Nombre: Mouse Logitech -> Descripción: Mouse óptico -> Precio: 15000 -> Stock: 12                                                                        | Productos P001..P006 presentes                                                                                               | Mensaje "Producto agregado correctamente." y P007 presente en inventario                                                         |                     | Añadir producto con código nuevo                                                                           |
| T02 | Agregar producto — código duplicado                         | Menú -> 1 -> Código: P001 -> ... resto campos válidos                                                                                                                               | P001 existe                                                                                                                  | Mensaje "Ya existe un producto con ese código." y no duplicar                                                                    |                     | Forzar usando código existente P001                                                                        |
| T03 | Agregar producto — input no numérico para precio            | Menú -> 1 -> Código: P008 -> Nombre: X -> Precio: "abc" -> re-introducir inválido                                                                                                   | Estado inicial                                                                                                               | Mensaje de validación (reintentar) o rechazo sin agregar                                                                        |                     | Ingresar texto en campo numérico; verificar manejo de NumberFormatException                               |
| T04 | Agregar producto — campo obligatorio vacío                  | Menú -> 1 -> Código: (ENTER) -> Nombre: ...                                                                                                                                         | Estado inicial                                                                                                               | Vista solicita nuevamente el campo obligatorio o muestra error; no se agrega                                                     |                     | Dejar código vacío para verificar validación en ProductoView                                                |
| T05 | Actualizar producto — caso válido                           | Menú -> 2 -> Código: P002 -> Cambiar precio a 1150000 -> Mantener otros campos (ENTER)                                                                                              | P002 presente                                                                                                                | Mensaje "Producto actualizado correctamente." y P002 con nuevo precio                                                           |                     | Verificar que campo vacío mantiene valor previo                                                             |
| T06 | Actualizar producto — producto inexistente                  | Menú -> 2 -> Código: P999                                                                                                                                                           | P999 no existe                                                                                                               | Mensaje "No existe un producto con ese código."                                                                                 |                     | Intentar actualizar código que no existe                                                                    |
| T07 | Eliminar producto — caso válido                             | Menú -> 3 -> Código: P005                                                                                                                                                            | P005 presente                                                                                                                | Mensaje "Producto eliminado correctamente." y P005 no aparece en listado                                                         |                     | Verificar eliminación real en listar                                                                         |
| T08 | Eliminar producto — inexistente                             | Menú -> 3 -> Código: P999                                                                                                                                                            | P999 no existe                                                                                                               | Mensaje "No existe un producto con ese código."                                                                                 |                     | Intentar eliminar código incorrecto                                                                         |
| T09 | Listar productos — caso general                             | Menú -> 4                                                                                                                                                                           | P001..P006 presentes (o tras T07 sin P005)                                                                                   | Lista con todos los productos actuales (cada producto mostrando descripción completa)                                           |                     | Verificar formato legible y que coincida con inventario                                                     |
| T10 | Buscar producto por ID — encontrado                         | Menú -> 5 -> Opción 1 -> Código: P003                                                                                                                                               | P003 presente                                                                                                                | Se muestra descripción completa de P003                                                                                         |                     | Verificar búsqueda exacta por ID                                                                             |
| T11 | Buscar producto por ID — no encontrado                      | Menú -> 5 -> Opción 1 -> Código: P999                                                                                                                                               | P999 no existe                                                                                                               | Mensaje "No se encontró el producto con ese código."                                                                            |                     |                                                                                                            |
| T12 | Buscar por nombre (parcial) — múltiples resultados          | Menú -> 5 -> Opción 2 -> Nombre: "Laptop"                                                                                                                                            | P001, P002 presentes                                                                                                         | Se listan P001 y P002                                                                                                            |                     | Probar con subcadena parcial "top" o distinto case para validar case-insensitive                            |
| T13 | Buscar por nombre (parcial) — sin resultados                | Menú -> 5 -> Opción 2 -> Nombre: "Tablet"                                                                                                                                            | ninguno con "Tablet"                                                                                                         | Mensaje "No se encontraron productos con ese nombre."                                                                            |                     |                                                                                                            |
| T14 | Buscar por descripción (parcial) — resultado                | Menú -> 5 -> Opción 3 -> Descripción: "gaming"                                                                                                                                        | P002 y P003 tienen "gaming"                                                                                                  | Se listan P002 y P003                                                                                                            |                     | Case-insensitive parcial                                                                                     |
| T15 | Buscar — input vacío en búsqueda parcial                    | Menú -> 5 -> Opción 2 -> Nombre: (ENTER)                                                                                                                                             | Estado inicial                                                                                                               | Debe manejarse: mostrar todos o pedir reentrada; preferible solicitar entrada válida                                              |                     | Forzar ENTER vacío para validar manejo                                                                        |
| T16 | Menú — opción inválida (alfanumérica)                       | Menú -> "x"                                                                                                                                                                         | Estado inicial                                                                                                               | Vista muestra mensaje "Opción no válida." o solicita reintento sin crashear                                                      |                     | Ingresar letra en elección de menú                                                                            |
| T17 | Menú — opción fuera de rango                                 | Menú -> 99                                                                                                                                                                          | Estado inicial                                                                                                               | Mensaje "Opción no válida." y volver a mostrar menú                                                                             |                     |                                                                                                            |
| T18 | Reporte inventario — caso general                           | Menú -> 6                                                                                                                                                                           | Productos presentes                                                                                                          | Mostrar resumen: total productos, total unidades, valor total (suma precio*stock). No pide umbral.                               |                     | Validar cálculo: para el stack dado, calcular totales y comparar                                             |
| T19 | Reporte inventario — precisión numérica                     | Menú -> 6                                                                                                                                                                           | Estado inicial                                                                                                               | Valor total calculado correctamente con decimales y sin overflow                                                                 |                     | Verificar suma = Σ(precio*stock)                                                                              |
| T20 | Flujo completo — secuencia de operaciones                   | 4 (listar) -> 5 buscar nombre "Teclado" -> 1 agregar P007 -> 4 listar -> 3 eliminar P007 -> 4 listar                                                                               | Estado inicial                                                                                                               | Comportamiento consistente en todas las operaciones, inventario actualizado en cada paso                                         |                     | Validar consistencia de estado entre operaciones                                                              |

## Pruebas Unitarias

### Producto

- T01 Agregar válido:
  - Teclear en menú: 1
    - Código: P007
    - Nombre: Mouse Logitech
    - Descripción: Mouse óptico
    - Precio: 15000
    - Stock: 12
- T02 Agregar duplicado:
  - Menú: 1
    - Código: P001
    - Resto datos (cualquiera) -> Esperar mensaje de código duplicado

- T03 Precio no numérico:
  - Menú: 1
    - Código: P008
    - Nombre: X
    - Precio: abc (ver si la vista pide reingresar o muestra error)
    - Si pide reintentar, ingresar 1000 y continuar.

- T04 Campo obligatorio vacío (código):
  - Menú: 1
    - Código: (ENTER) -> verificar que la vista pida o muestre error

- T05 Actualizar válido:
  - Menú: 2
    - Código: P002
    - Nuevo nombre: (ENTER) — mantener
    - Nuevo precio: 1150000
    - Nuevo stock: (ENTER)
    - Nueva descripción: (ENTER)

- T06 Actualizar inexistente:
  - Menú: 2
    - Código: P999 -> esperar mensaje "No existe..."

- T07 Eliminar válido:
  - Menú: 3
    - Código: P005 -> esperar "Producto eliminado correctamente."

- T08 Eliminar inexistente:
  - Menú: 3
    - Código: P999 -> esperar mensaje de no existencia

### Inventario

- T09 Listar productos:
  - Menú: 4 -> revisar listado mostrado

- T10 Buscar por ID encontrado:
  - Menú: 5
  - Elegir opción de búsqueda: 1
  - Código: P003

- T11 Buscar por ID no encontrado:
  - Menú: 5 -> opción 1 -> P999

- T12 Buscar por nombre parcial:
  - Menú: 5 -> opción 2 -> escribir: Laptop

- T13 Buscar por nombre sin resultados:
  - Menú: 5 -> opción 2 -> Tablet

- T14 Buscar por descripción parcial:
  - Menú: 5 -> opción 3 -> gaming

- T15 Búsqueda con input vacío:
  - Menú: 5 -> opción 2 -> (ENTER) -> observar comportamiento

## Pruebas de integración

### Menu Principal

- T17 Opción fuera de rango:
  - Menú: 99 -> observar mensaje "Opción no válida."

- T18 / T19 Reporte inventario:
  - Menú: 6 -> revisar resumen mostrado; validar totales (ver nota de cálculo en la tabla)

- T20 Flujo completo:
  - Menú:4 -> Menú: 5(op2) -> Teclado -> 1 (agregar P007) -> 4 listar -> 3 eliminar P007 -> 4 listar
