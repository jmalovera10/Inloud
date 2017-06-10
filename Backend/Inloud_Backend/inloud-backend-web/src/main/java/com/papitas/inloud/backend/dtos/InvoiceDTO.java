/* 
 * The MIT License
 *
 * Copyright 2017 juanm.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
