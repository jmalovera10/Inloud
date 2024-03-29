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
package com.papitas.inloud.backend.resources;

import com.papitas.inloud.backend.dtos.InvoiceDTO;
import com.papitas.inloud.backend.dtos.InvoiceDetailDTO;
import com.papitas.inloud.backend.ejbs.InvoiceLogic;
import com.papitas.inloud.backend.entities.InvoiceEntity;
import com.papitas.inloud.backend.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author venegas
 */
@Path("/invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceResource {
    @Inject
    InvoiceLogic logic;
    @GET
    @Path("/{id : \\d+}")
    public InvoiceDTO getCliente(@PathParam("id") long id ){
        InvoiceEntity entity=logic.getInvoice(id);
        return new InvoiceDetailDTO(entity);
    }
    
    @DELETE
    @Path("/{id : \\d+}")
    public void deleteInvoice(@PathParam("id") long id ){
       logic.deleteInvoice(id);
       
    }
    
    @POST
    public InvoiceDetailDTO postInvoice(InvoiceDetailDTO invoice )throws BusinessLogicException{
        InvoiceEntity entity= logic.postInvoice(invoice.toEntity());
        return new InvoiceDetailDTO(entity);
    }
    
}
