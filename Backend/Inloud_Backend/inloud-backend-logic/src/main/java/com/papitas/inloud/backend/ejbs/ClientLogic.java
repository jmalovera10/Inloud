/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.ejbs;

import com.papitas.inloud.backend.entities.ClientEntity;
import com.papitas.inloud.backend.entities.InvoiceEntity;
import com.papitas.inloud.backend.exceptions.BusinessLogicException;
import com.papitas.inloud.backend.persistence.ClientPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author venegas
 */
@Stateless
public class ClientLogic {
    @Inject
    private ClientPersistence persistence ;

    public ClientEntity getClient(long id) {
        return persistence.find(id);
    }

    public ClientEntity putClient(long id, ClientEntity toEntity) throws BusinessLogicException {
        if (toEntity==null) throw new BusinessLogicException("La entidad no puede ser nulla");
        ClientEntity entity = persistence.find(id);
        if (entity==null) throw new BusinessLogicException("Cliente no encontrado");
        toEntity.setId(entity.getId());
        if (!entity.getLogin().equals(toEntity.getLogin())) throw new BusinessLogicException("El login no es el correcto");
        if (toEntity.getPassword().length()<8) throw new BusinessLogicException("Contraseña muy corta ");
        //birthDate
        //email
        return persistence.update(toEntity);
    }

    public ClientEntity postClient(ClientEntity toEntity) throws BusinessLogicException {
        if (toEntity.getPassword().length()<8) throw new BusinessLogicException("Contraseña muy corta ");
        return persistence.create(toEntity);
    }

    public List<InvoiceEntity> getInvoices(long id) throws BusinessLogicException {
        ClientEntity entity = persistence.find(id);
        if (entity==null) throw new BusinessLogicException("Cliente no encontrado");
        return entity.getInvoices();
 
    }

    
   
    
}
