/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.ejbs;


import com.papitas.inloud.backend.entities.InvoiceEntity;
import com.papitas.inloud.backend.exceptions.BusinessLogicException;
import com.papitas.inloud.backend.persistence.InvoicePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author venegas
 */

@Stateless
public class InvoiceLogic {

    @Inject
    InvoicePersistence persistence;
    
    
    public InvoiceEntity getInvoice(long id) {
        return persistence.find(id);
    }

    public void deleteInvoice(long id) {
        persistence.delete(id);
    }

    public InvoiceEntity postInvoice(InvoiceEntity toEntity) throws BusinessLogicException {
        if (toEntity==null) throw new BusinessLogicException("null entity");
        return persistence.create(toEntity);
    }
    
}
