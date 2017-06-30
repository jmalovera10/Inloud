/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.dtos;

import com.papitas.inloud.backend.entities.ClientEntity;
import com.papitas.inloud.backend.entities.InvoiceEntity;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Venegas
 */
public class ClientDetailDTO extends ClientDTO{
     private List<InvoiceEntity> invoices;

    public ClientDetailDTO() {
    }

    public ClientDetailDTO(ClientEntity entity) {
        super(entity);
        if(entity!=null){
        this.invoices = entity.getInvoices();
        }
    }
     
     
     @Override
     public ClientEntity toEntity(){
         ClientEntity entity = super.toEntity();
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
