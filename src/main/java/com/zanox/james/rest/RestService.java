/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jose.soler
 */

@Path("")
public class RestService {
    
   
    @GET 
    @Path("getQuestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuestionById(@QueryParam("id") Integer id){
        
        return "Question ID: " + id + " ???";
    }
    
    
    @GET 
    @Path("setAnswer")
    @Produces(MediaType.TEXT_PLAIN)
    public String setAnswer(@QueryParam("qId") Integer id, @QueryParam("answer") String answer ){
        
        return validateAnswer(id, answer);
       
    }

    private String validateAnswer(Integer id, String answer) {
        
        if( id == null || answer == null || answer.length() == 0) return "KO";
        else return "OK";
        
    }

   
}
