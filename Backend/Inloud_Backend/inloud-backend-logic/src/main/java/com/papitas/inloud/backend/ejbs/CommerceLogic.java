/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.ejbs;

import com.papitas.inloud.backend.entities.CommerceEntity;
import com.papitas.inloud.backend.entities.InvoiceEntity;
import com.papitas.inloud.backend.exceptions.BusinessLogicException;
import com.papitas.inloud.backend.persistence.CommercePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author venegas
 */
@Stateless
public class CommerceLogic {
    @Inject
    CommercePersistence persistence;
    
    public CommerceEntity getCommerce(long id) {
        return persistence.find(id);
    }

    public CommerceEntity putCommerce(long id, CommerceEntity toEntity) throws BusinessLogicException {
         if (toEntity==null) throw new BusinessLogicException("La entidad no puede ser nulla");
        CommerceEntity entity = persistence.find(id);
        if (entity==null) throw new BusinessLogicException("Comercio no encontrado");
        toEntity.setId(entity.getId());
        if (!entity.getNit().equals(toEntity.getId())) throw new BusinessLogicException("El nit debe ser igual");
        return persistence.update(toEntity);
    }

    public CommerceEntity postCommerce(CommerceEntity toEntity) {
        return persistence.create(toEntity);
    }

    public List<InvoiceEntity> getInvoices(long id) throws BusinessLogicException {
        CommerceEntity entity = persistence.find(id);
        if (entity==null) throw new BusinessLogicException("Comercio no encontrado");
        return entity.getInvoices();
    }
    
}
