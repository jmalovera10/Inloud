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
    
}
