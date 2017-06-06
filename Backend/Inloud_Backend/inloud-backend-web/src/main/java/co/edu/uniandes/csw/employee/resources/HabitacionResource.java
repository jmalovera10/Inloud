/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.employee.resources;

import co.edu.uniandes.csw.employee.dtos.HabitacionDTO;
import co.edu.uniandes.csw.employee.entities.HabitacionEntity;
import co.edu.uniandes.csw.employee.exceptions.BusinessLogicException;
import co.uniandes.csw.employee.ejbs.HabitacionLogic;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jma.lovera10
 */
@Path("/companies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HabitacionResource {
    @Inject private HabitacionLogic habitacionLogic;
    
    @GET
    public List<HabitacionDTO> getHabitaciones(){
        List<HabitacionDTO> lista = new ArrayList<HabitacionDTO>();
        List<HabitacionEntity> entities = habitacionLogic.getHabitaciones();
        
        for(HabitacionEntity entity : entities){
            HabitacionDTO dto = new HabitacionDTO(entity);
            lista.add(dto);
        }
        return lista;
    }
    
    
    @POST
    public HabitacionDTO addCompany(HabitacionDTO habitacionDTO)throws BusinessLogicException{
        HabitacionEntity habitacion = habitacionDTO.toEntity();
        HabitacionEntity storedCompany = habitacionLogic.createHabitacion(habitacion);
        return new HabitacionDTO(storedCompany);
    }
}
