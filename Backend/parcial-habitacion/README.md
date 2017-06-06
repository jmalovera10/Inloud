# Creación de un Servicio REST

En la compañía se ha empezado a construir un software para manejar reservas de habitaciones. Ud debe crear unos servicios REST para poder crear y consultar esas habitaciones.

## Datos de las Habitaciones.

- De cada una de las habitaciones se espera tener un identificador (id) auto-generado, un nombre corto y una descripción. Adicionalmente, debe tener un único período de disponibilidad, con una fecha de inicio y una fecha de terminación.

![diagrama de clases](./images/diagrama-de-clases.png)

- **NOTA:** Al momento de crear la clase Entidad (Entity) es necesario determinar si la fecha se debe guardar como fecha, hora o fecha y hora (timestamp).

## Lógica de Negocio.

- Los datos del período de disponibilidad de la habitación deben validarse. La fecha de inicio debe ser menor a la fecha de terminación. Si la fecha no es menor, debe generar una excepción.

- **NOTA:** La clase java.util.Date tiene métodos para comparar fechas. Es posible saber si una fecha es antes o después de otra usando los métodos before() y after(), o comparar fechas usando el método compareTo(). 
Por ejemplo:
```
if (fechaInicio.after( fechaFinal )) {
  throw new BusinessException(“fecha de inicio después de fecha final”);
}
```

## Servicio REST

- Deben implementarse un servicio REST que permita (1) agregar una habitación y (2) obtener un listado de habitación.
- Representación
Representación:
```
{
  id: ‘’, 		/* Long */
  nombre: ‘’,		/* String */
  descripcion: ‘’,	/* String */
  fechaInicial: ‘’,	/* Date */
  fechaFinal: ‘’, 	/* Date */
}
```


| REST | URL | Parámetros | Descripción |
|------|-----|------------|-------------|
| GET  | /habitaciones | | Consulta el listado de habitaciones |
| POST | /habitaciones | En el body: nueva habitación | Adiciona una nueva habitación | 

