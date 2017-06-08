/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.dtos;

import com.papitas.inloud.backend.entities.ClientEntity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Venegas
 */
public class ClientDTO implements Serializable {
    /**
     * Client ID
     */
    
    private Long id;
    
    /**
     * Client login
     */
    private String login;
    
    
    /**
     * Client name
     */
    private String name;
    
    /**
     * Client email
     */
    private String email;
    
    /**
     * Client ID number
     */
    private Long idNumber;
    
    /**
     * Client idType
     */
    private String idType;
    
    /**
     * Client idType
     */
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String login, String name, String email, Long idNumber, String idType, Date birthDate) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.email = email;
        this.idNumber = idNumber;
        this.idType = idType;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    
    public ClientEntity toEntity(){
        ClientEntity entity = new ClientEntity();
        entity.setBirthDate(birthDate);
        entity.setEmail(email);
        entity.setId(id);
        entity.setIdNumber(idNumber);
        entity.setIdType(idType);
        entity.setLogin(login);
        entity.setName(name);
        return entity;
    }
}
