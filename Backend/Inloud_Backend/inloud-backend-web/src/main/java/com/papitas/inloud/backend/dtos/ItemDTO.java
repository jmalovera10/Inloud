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

import com.papitas.inloud.backend.entities.ItemEntity;

/**
 *
 * @author juanm
 */
public class ItemDTO {
    
    /**
     * Item ID
     */
    private Long id;
    
    /**
     * Item name
     */
    private String name;
    
    /**
     * Item cost
     */
    private Double cost;

    public ItemDTO() {
    }
    
    public ItemDTO(ItemEntity entity) {
        if(entity!=null){
            this.id = entity.getId();
            this.name = entity.getName();
            this.cost = entity.getCost();
        }
    }
    
    public ItemEntity toEntity(){
        ItemEntity entity = new ItemEntity();
        entity.setCost(cost);
        entity.setId(id);
        entity.setName(name);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
   
}
