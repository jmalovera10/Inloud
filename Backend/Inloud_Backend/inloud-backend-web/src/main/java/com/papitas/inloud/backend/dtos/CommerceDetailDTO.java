/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.dtos;

import com.papitas.inloud.backend.entities.CommerceEntity;
import com.papitas.inloud.backend.entities.InvoiceEntity;
import java.util.List;

/**
 *
 * @author Venegas
 */
public class CommerceDetailDTO extends CommerceDTO{
    private List<InvoiceEntity> invoices;

    public CommerceDetailDTO() {
    }

    public CommerceDetailDTO(CommerceEntity entity) {
        super(entity);
        if(entity!=null){
        this.invoices = entity.getInvoices();
        }
    }
     
    @Override
    public CommerceEntity toEntity(){
        CommerceEntity entity = super.toEntity();
        entity.setInvoices(invoices);
        return entity;
    }

    public List<InvoiceEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        this.invoices = invoices;
    }
    
    
    
}
