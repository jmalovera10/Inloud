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
package com.papitas.inloud.backend.entities;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juanm
 */
@Entity
public class InvoiceEntity {
    
    /**
     * Invoice ID
     */
    @Id
    @GeneratedValue
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
    
    /**
     * Invoice client
     */
    @ManyToOne
    private ClientEntity client;
    
    /**
     * Invoice commerce
     */
    @ManyToOne
    private CommerceEntity commerce;
    
    /**
     * Invoice related items
     */
    @ManyToMany
    private List<ItemEntity> items;

    public InvoiceEntity() {
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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
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

    public void addItem(ItemEntity item) {
        this.items.add(item);
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
    
  
}
