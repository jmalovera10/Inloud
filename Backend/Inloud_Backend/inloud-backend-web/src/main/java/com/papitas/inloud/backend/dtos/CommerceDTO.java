/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public CommerceDTO(Long id, Long nit, String name, String address, Boolean active) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.active = active;
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
