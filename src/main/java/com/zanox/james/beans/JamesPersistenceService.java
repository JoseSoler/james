/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.beans;

import com.zanox.james.entities.Answer;
import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.entities.Question;
import com.zanox.james.exceptions.UnexistentQuestionException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author jose.soler
 */
@Stateless
public class JamesPersistenceService {
    
    @PersistenceContext(name = "james_persistence")
    private EntityManager em;
    
    private Logger log = Logger.getLogger(JamesPersistenceService.class);
    
    public String getQuestion(Integer questionId) throws UnexistentQuestionException {
        
       
        Question aQuestion = getQuestionById(questionId);
        
        if(aQuestion == null) throw new UnexistentQuestionException();
        
        
        return aQuestion.getQuestionText();
    
    }
    
    public void setAnswer(Integer questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException  {
        
        Question aQuestion = getQuestionById(questionId);
        
        if(aQuestion == null) throw new UnexistentQuestionException();
        
        
        Answer anAnswer = new Answer();
        anAnswer.setAnswerText(answer);
        
        aQuestion.addAnswer(anAnswer);
        
        try {
        
            em.persist(aQuestion);
        
        }catch(Exception ex){
            
            throw new UnacceptedAnswerException();
        }
        
        
    }
    
    
    
    
    
    private Question getQuestionById(Integer id){
        
         Question aQuestion = em.find(Question.class, id);
         
         return aQuestion;
    
    }
    
}
