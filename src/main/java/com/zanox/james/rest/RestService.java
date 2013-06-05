/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.rest;

import com.zanox.james.beans.JamesDummyService;
import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.exceptions.UnexistentQuestionException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

/**
 *
 * @author jose.soler
 */

@Path("")
public class RestService {
    
    private JamesService jps = new JamesDummyService();
    
    
    private Logger log = Logger.getLogger(RestService.class);
   
    @GET 
    @Path("getQuestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuestionById(@QueryParam("id") Integer id){
       
        try {
        
            return jps.getQuestion(id);
        
        } catch (UnexistentQuestionException ex) {
           
            log.warn("Someone trying to get an unexistent question Id !! " + id);
            
            return "Unexistent Question Id";
            
        }
        
    }
    
    
    @GET 
    @Path("setAnswer")
    @Produces(MediaType.TEXT_PLAIN)
    public String setAnswer(@QueryParam("qId") Integer id, @QueryParam("answer") String answer ){
        
        try {
            
            return jps.setAnswer(id, answer);
        
        } catch (UnacceptedAnswerException ex) {
           
            String msg = "Error while trying to store the answer: " + answer;
            log.warn(msg);
            
            return "{ " + id + ":\"KO\" }";
        
        } catch (UnexistentQuestionException ex) {
            
            String msg = "Someone trying to answer an unexistent question Id !! :\" + id ";
            
            log.warn(msg);
           
            return "{ " + id + ":\"KO\" }";
        }
        
       
    }
    
    @GET
    @Path("getAnswerSummary")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnswerSummaryForQuestionId(@QueryParam("id") Integer id) {

        try {

            return jps.getAnswerSummaryForQuestionId(id);

        } catch (UnexistentQuestionException ex) {

            log.warn("Someone trying to get answers for an unexistent question Id !! " + id);

            return "Unexistent Question Id";

        }

    }

   

   
}
