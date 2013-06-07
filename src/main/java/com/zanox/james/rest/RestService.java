/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.rest;

import com.eclipsesource.json.QuestionToJsonConverter;
import com.zanox.james.entities.Answer;
import com.zanox.james.entities.Question;
import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.exceptions.UnexistentQuestionException;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

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
    
    @Inject
    private JamesService jps;
    
    
    private Logger log = Logger.getLogger(RestService.class);
   
    @GET 
    @Path("getQuestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuestionById(@QueryParam("id") String id){
       
        try {
            
          
            id = decorateTheReceivedId(id);
            
            Question aQuestion = jps.getQuestion(id);
            
            return QuestionToJsonConverter.generateJsonSuccess(aQuestion);
        
        } catch (UnexistentQuestionException ex) {
           
            log.warn("Someone trying to get an unexistent question Id !! " + id);
           
            return QuestionToJsonConverter.generateUnexistentQuestionJsonError(id);
            
            
        }
        
    }
    
    
    @GET 
    @Path("setAnswer")
    @Produces(MediaType.TEXT_PLAIN)
    public String setAnswer(@QueryParam("id") String id, @QueryParam("answer") String answer ){
        
        try {
             
            id = decorateTheReceivedId(id);
            answer = decorateAnswer(answer);
             
            Question aQuestion = jps.setAnswer(id, answer);
            
            return QuestionToJsonConverter.generateJsonSuccess(aQuestion);
        
        } catch (UnacceptedAnswerException ex) {
           
             log.warn("Error while trying to store the answer: " + answer);
            
             return QuestionToJsonConverter.generatePersistenceJsonError(id);
        
        } catch (UnexistentQuestionException ex) {
            
             String msg = "Someone trying to answer an unexistent question Id !! :\" + id ";
            
             return QuestionToJsonConverter.generateUnexistentQuestionJsonError(id);
         
        }
        
       
    }
    
    @GET
    @Path("getAnswerSummary")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnswerSummaryForQuestionId(@QueryParam("id") String id) {

        try {

            id = decorateTheReceivedId(id);
             
            Map<String,String> aggregates = jps.getAnswerSummaryForQuestionId(id);
            
             return QuestionToJsonConverter.convertQuestionAnswersToJson(aggregates);

        } catch (UnexistentQuestionException ex) {

            log.warn("Someone trying to get answers for an unexistent question Id !! " + id);
            return QuestionToJsonConverter.generateUnexistentQuestionJsonError(id);

        }

    }

    @GET 
    @Path("createQuestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String createQuestion(@QueryParam("id") String id, @QueryParam("question") String question ){
       
        try {
        
            id = decorateTheReceivedId(id);
             
            Question aQuestion = jps.createQuestion(id, question);
            
            return QuestionToJsonConverter.generateJsonSuccess(aQuestion);
        
        } catch (Exception ex) {
           
            log.error("Error while creating question id: " + id + "  -  " + question);
            return QuestionToJsonConverter.generateCreatingQuestionJsonError(id);
            
        }
        
    }
    
    @GET 
    @Path("allQuestions")
    @Produces(MediaType.TEXT_PLAIN)
    public String listAllQuestions(){
       
        try {
        
            List<Question> allQuestions = jps.listAllQuestions();
            
             return QuestionToJsonConverter.generateAllQuestionsJson(allQuestions);
        
        } catch (Exception ex) {
           
            log.error("Error while trying to list all questions.");
            return QuestionToJsonConverter.generateAllQuestionsError();
            
        }
        
    }
    
    @GET 
    @Path("allAnswersForQuestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String listAllAnswersForQuestions(@QueryParam("id") String id){
       
        try {
        
             List<Answer> allAnswers = jps.listAllAnswersForQuestion(id);
            
             return QuestionToJsonConverter.generateAllAnswersJson(allAnswers);
        
        } catch (Exception ex) {
           
            log.error("Error while trying to list all answers for question with id " + id);
            return QuestionToJsonConverter.generateUnexistentQuestionJsonError(id);
            
        }
        
    }
    
    @GET 
    @Path("deleteAnswersForQuestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteAnswersForQuestion(@QueryParam("id") String id){
       
        try {
        
            Question aQuestion = jps.deleteAnswersForQuestion(id);
            
            return QuestionToJsonConverter.generateDeleteAnswersJson(aQuestion);
        
        } catch (Exception ex) {
           
            log.error("Error while trying to delete answers for question id " + id);
            
            return QuestionToJsonConverter.generateUnexistentQuestionJsonError(id);
            
        }
        
    }
    
    @GET 
    @Path("deleteQuestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteQuestion(@QueryParam("id") String id){
       
        try {
        
            Question aQuestion = jps.deleteQuestion(id);
            
            return QuestionToJsonConverter.generateDeleteQuestionJson(aQuestion);
        
        } catch (Exception ex) {
           
            log.error("Error while trying to list all answers for question with id " + id);
            
            return QuestionToJsonConverter.generateUnexistentQuestionJsonError(id);
            
        }
        
    }

    private String decorateTheReceivedId(String id){
        
          id = id.toLowerCase();  //ignore the case ( as Camille requested :-) )
        
          return id;
    }
    
     private String decorateAnswer(String answer) {

        answer = answer.trim();
        answer = answer.toLowerCase();

        return answer;

    }
        

   
}
