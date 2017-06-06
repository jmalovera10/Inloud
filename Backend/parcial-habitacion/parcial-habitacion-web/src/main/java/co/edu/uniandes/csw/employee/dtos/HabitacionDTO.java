/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.employee.dtos;

import co.edu.uniandes.csw.employee.entities.HabitacionEntity;
import java.io.Serializable;
import java.util.Date;

public class HabitacionDTO implements Serializable {
    
    private Long    id;
    private String  nombre;
    private String  descripcion;
    private Date    fechaInicio;
    private Date    fechaFin;

    public HabitacionDTO() {
    }
 
    public HabitacionDTO(HabitacionEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.nombre = entity.getNombre();
            this.descripcion = entity.getDescripcion();
            this.fechaInicio = entity.getFechaInicio();
            this.fechaFin = entity.getFechaFin();
        }
    }
    
    public HabitacionEntity toEntity() {
        HabitacionEntity entity = new HabitacionEntity();
        entity.setId(this.getId());
        entity.setNombre(this.getNombre());
        entity.setDescripcion(this.getDescripcion());
        entity.setFechaInicio(this.getFechaInicio());
        entity.setFechaFin(this.getFechaFin());
        return entity;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
