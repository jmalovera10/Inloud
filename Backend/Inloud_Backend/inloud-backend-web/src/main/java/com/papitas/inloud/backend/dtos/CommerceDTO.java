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

import com.papitas.inloud.backend.entities.CommerceEntity;

/**
 *
 * @author Venegas
 */
public class CommerceDTO {
    /**
     * Commerce ID
     */
    private Long id;
    
    /**
     * Commerce NIT
     */
    private Long nit;
    
    /**
     * Commerce name
     */
    private String name;
    
    /**
     * Commerce address
     */
    private String address;
    
    /**
     * Commerce state
     */
    private Boolean active;

    public CommerceDTO() {
    }

    public CommerceDTO(CommerceEntity entity) {
        if(entity!=null){
        this.id = entity.getId();
        this.nit = entity.getNit();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.active = entity.getActive();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public CommerceEntity toEntity(){
        CommerceEntity entity = new CommerceEntity();
        entity.setActive(active);
        entity.setAddress(address);
        entity.setId(id);
        entity.setName(name);
        entity.setNit(nit);
        
        return entity;
    }
}
