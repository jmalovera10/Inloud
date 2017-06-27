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

    public ClientDetailDTO(List<InvoiceEntity> invoices, Long id, String login, String name, String email, Long idNumber, String idType, Date birthDate) {
        super(id, login, name, email, idNumber, idType, birthDate);
        this.invoices = invoices;
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
