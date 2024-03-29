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
package com.papitas.inloud.backend.persistence;

import com.papitas.inloud.backend.entities.CommerceEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author juanm
 */
@Stateless
public class CommercePersistence {
    @PersistenceContext(unitName = "inloudPU")
    protected EntityManager em;
    
    public CommerceEntity find (Long id){
        return em.find(CommerceEntity.class, id);
    }
    
    public List<CommerceEntity> findAll(){
        TypedQuery<CommerceEntity> q = em.createQuery(
        "select u from CommerceEntity u",CommerceEntity.class);
        return q.getResultList();
    }
    
    public CommerceEntity create(CommerceEntity e){
        em.persist(e);
        return e;
    }
    
    public CommerceEntity update(CommerceEntity e){
        return em.merge(e);
    }
    
    public void delete(Long id){
        CommerceEntity e = em.find(CommerceEntity.class, id);
        em.remove(e);
    }
}
