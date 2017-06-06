/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.employee.ejbs;

import co.edu.uniandes.csw.employee.entities.HabitacionEntity;
import co.edu.uniandes.csw.employee.exceptions.BusinessLogicException;
import co.uniandes.csw.employee.persistence.HabitacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jma.lovera10
 */
@Stateless
public class HabitacionLogic {
    @Inject private HabitacionPersistence persistence;
    
     public HabitacionEntity createHabitacion(HabitacionEntity entity)throws BusinessLogicException
    {
        if(entity.getFechaInicio().after(entity.getFechaFin()))throw new BusinessLogicException("Las fehcas son erróneas");
        return persistence.create(entity);
    }
    
    public List<HabitacionEntity> getHabitaciones(){
        return persistence.findAll();
    }
    
    public HabitacionEntity getHabitacion(Long id){
        return persistence.find(id);
    }
    
    public HabitacionEntity updateHabitacion(HabitacionEntity entity)throws BusinessLogicException{
        if(entity.getFechaInicio().after(entity.getFechaFin()))throw new BusinessLogicException("Las fehcas son erróneas");
        return persistence.update(entity);
    }
    
    public void deleteHabitacion(Long id){
        persistence.delete(id);
    }
}
