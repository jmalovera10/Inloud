/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.dtos;

import com.papitas.inloud.backend.entities.ClientEntity;
import com.papitas.inloud.backend.entities.CommerceEntity;
import com.papitas.inloud.backend.entities.InvoiceEntity;
import com.papitas.inloud.backend.entities.ItemEntity;
import java.sql.Timestamp;
import java.util.List;


/**
 *
 * @author Venegas
 */
public class InvoiceDetailDTO extends InvoiceDTO{
    
    private CommerceEntity commerce;
    
    private List<ItemEntity> items;
    
    private ClientEntity client;

    public InvoiceDetailDTO() {
        
        
    }

    public InvoiceDetailDTO(CommerceEntity commerce, List<ItemEntity> items, ClientEntity client, Long id, Long serialId, Timestamp date, Double totalCost, Double tax) {
        super(id, serialId, date, totalCost, tax);
        this.commerce = commerce;
        this.items = items;
        this.client = client;
    }

    @Override 
    public InvoiceEntity toEntity(){
        InvoiceEntity entity = super.toEntity();
        entity.setClient(client);
        entity.setCommerce(commerce);
        entity.setItems(items);
        return entity;
    }

    public CommerceEntity getCommerce() {
        return commerce;
    }

    public void setCommerce(CommerceEntity commerce) {
        this.commerce = commerce;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
    
    
    
}
