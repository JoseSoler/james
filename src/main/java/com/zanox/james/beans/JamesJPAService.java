/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.beans;

import com.zanox.james.rest.JamesService;
import com.eclipsesource.json.QuestionToJsonConverter;
import com.zanox.james.entities.Answer;
import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.entities.Question;
import com.zanox.james.exceptions.UnexistentQuestionException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;

/**
 *
 * @author jose.soler
 */
@Stateless
public class JamesJPAService implements JamesService {
    
    //@PersistenceContext(name = "james_persistence")
    private EntityManager em;
    
    private Logger log = Logger.getLogger(JamesJPAService.class);
    
    @Override
    public String getQuestion(Integer questionId) throws UnexistentQuestionException {
        
       
        Question aQuestion = getQuestionById(questionId);
        
        if(aQuestion == null) throw new UnexistentQuestionException();
        
        
        return aQuestion.getQuestionText();
    
    }
    
    @Override
    public String setAnswer(Integer questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException  {
        
        Question aQuestion = getQuestionById(questionId);
        
        if(aQuestion == null) throw new UnexistentQuestionException();
        
        
        Answer anAnswer = new Answer();
        anAnswer.setAnswerText(answer);
        
        aQuestion.addAnswer(anAnswer);
        
        try {
        
            em.persist(aQuestion);
            
             return "{ " + questionId + ": \"OK\" }";
        
        }catch(Exception ex){
            
            throw new UnacceptedAnswerException();
        }
        
        
    }
    
    
    

    @Override
    public String getAnswerSummaryForQuestionId(Integer id) throws UnexistentQuestionException{
        
         Question aQuestion = getQuestionById(id);
         
         if(aQuestion == null) throw new UnexistentQuestionException();
         
         return QuestionToJsonConverter.convertQuestionAnswersToJson(aQuestion);
          
        
    }
    
    
    
    
    private Question getQuestionById(Integer id){
        
         Question aQuestion = em.find(Question.class, id);
         
         return aQuestion;
    
    }
    
}
