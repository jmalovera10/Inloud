/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.dtos;

import com.papitas.inloud.backend.entities.InvoiceEntity;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Venegas
 */
public class InvoiceDTO implements Serializable {
       /**
     * Invoice ID
     */
    
    private Long id;
    
    /**
     * Invoice serial ID
     */
    private Long serialId;
    
    /**
     * Invoice date
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;
    
    /**
     * Invoice total cost
     */
    private Double totalCost;
    
    /**
     * Invoice tax
     */
    private Double tax;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long id, Long serialId, Timestamp date, Double totalCost, Double tax) {
        this.id = id;
        this.serialId = serialId;
        this.date = date;
        this.totalCost = totalCost;
        this.tax = tax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
    
    public InvoiceEntity toEntity(){
        InvoiceEntity entity = new InvoiceEntity();
        entity.setDate(date);
        entity.setId(id);
        entity.setSerialId(serialId);
        entity.setTax(tax);
        entity.setTotalCost(totalCost);
        
        return entity;
    }
}
