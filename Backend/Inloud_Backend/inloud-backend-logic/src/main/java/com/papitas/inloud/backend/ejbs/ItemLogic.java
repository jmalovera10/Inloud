/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papitas.inloud.backend.ejbs;

import com.papitas.inloud.backend.entities.ItemEntity;
import com.papitas.inloud.backend.exceptions.BusinessLogicException;
import com.papitas.inloud.backend.persistence.ItemPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author juanm
 */
@Stateless
public class ItemLogic {
    @Inject private ItemPersistence persistence;
    
    public ItemEntity createItem(ItemEntity entity)throws BusinessLogicException
    {
        if(entity.getBarcode()!=null 
                && !persistence.findByBarcode(entity.getBarcode()).isEmpty()){
            throw new BusinessLogicException("The item with the specified barcode"
                    + " already exists");
        }
        return persistence.create(entity);
    }
    
    public ItemEntity getItem(Long id){
        return persistence.find(id);
    }
    
    public ItemEntity updateItem(ItemEntity entity)throws BusinessLogicException{
        return persistence.update(entity);
    }
    
    public void deleteItem(Long id){
        persistence.delete(id);
    }
}
