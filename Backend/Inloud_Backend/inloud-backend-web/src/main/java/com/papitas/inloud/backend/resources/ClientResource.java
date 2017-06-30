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

import com.papitas.inloud.backend.dtos.ClientDTO;
import com.papitas.inloud.backend.dtos.ClientDetailDTO;
import com.papitas.inloud.backend.dtos.InvoiceDTO;
import com.papitas.inloud.backend.dtos.InvoiceDetailDTO;
import com.papitas.inloud.backend.ejbs.ClientLogic;
import com.papitas.inloud.backend.entities.ClientEntity;
import com.papitas.inloud.backend.entities.InvoiceEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author venegas
 */
@Path("/client")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
    @Inject
    ClientLogic logic;
    
    @GET
    @Path("/{id : \\d+}")
    public ClientDTO getCliente(@PathParam("id") long id ){
        ClientEntity entity=logic.getClient(id);
        return new ClientDetailDTO(entity);
    }
    
    @GET
    @Path("/{id : \\d+}/invoices")
    public List<InvoiceDTO> getInvoices(@PathParam("id") long id ){
        List<InvoiceEntity> invoicesEntity=logic.getInvoices(id);
        List<InvoiceDTO> dtos= new ArrayList<>();
        for (InvoiceEntity invoiceEntity : invoicesEntity) {
            dtos.add(new InvoiceDetailDTO(invoiceEntity));
        }
        return dtos;
    }
    
    @PUT
    @Path("/{id : \\d+}")
    public ClientDTO putCliente(@PathParam("id") long id, ClientDTO nuevo){

        ClientEntity entity=logic.putClient(id, nuevo.toEntity());
        return new ClientDTO(entity);
    }
    
    @POST
    public ClientDTO postCliente( ClientDTO nuevo){
        ClientEntity entity=logic.postClient(nuevo.toEntity());
        return new ClientDTO(entity);
    }
    
    
}
