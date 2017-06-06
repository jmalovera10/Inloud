/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.employee.persistence;

import co.edu.uniandes.csw.employee.entities.HabitacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jma.lovera10
 */
@Stateless
public class HabitacionPersistence {
    @PersistenceContext(unitName = "employeePU")
    protected EntityManager em;
    
    public HabitacionEntity find(Long id){
        return em.find(HabitacionEntity.class, id);
    }
    
    public List<HabitacionEntity> findAll(){
        TypedQuery<HabitacionEntity> q = em.createQuery(
        "select u from CompanyEntity u",HabitacionEntity.class);
        return q.getResultList();
    }
    
    public HabitacionEntity create(HabitacionEntity e){
        em.persist(e);
        return e;
    }
    
    public HabitacionEntity update(HabitacionEntity e){
        return em.merge(e);
    }
    
    public void delete(Long id){
        HabitacionEntity e = em.find(HabitacionEntity.class, id);
        em.remove(e);
    }
}
