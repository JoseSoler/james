/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jose.soler
 */

@Path("services")
public class RestService {
    
   
    @GET 
    @Path("info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo(@QueryParam("id") Integer id){
        
        return id.toString();
       //return bb.getBookInfo();
    }
}
