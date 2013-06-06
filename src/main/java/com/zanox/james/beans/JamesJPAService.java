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
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author jose.soler
 */
@Stateless
public class JamesJPAService implements JamesService {
    
    @PersistenceContext(unitName = "james_persistence")
    private EntityManager em;
    
    private Logger log = Logger.getLogger(JamesJPAService.class);
    
    @Override
    public String getQuestion(String questionId) throws UnexistentQuestionException {
        
       
        Question aQuestion = getQuestionById(questionId);
        
        if(aQuestion == null) throw new UnexistentQuestionException();
        
        
        return QuestionToJsonConverter.generateJsonSuccess(aQuestion);
    
    }
    
    @Override
    public String setAnswer(String questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException  {
        
        Question aQuestion = getQuestionById(questionId);
        
        if(aQuestion == null) throw new UnexistentQuestionException();
        
        answer = decorateAnswer(answer);
                
        Answer anAnswer = new Answer();
        anAnswer.setAnswerText(answer);
        
        //build the relationships
        anAnswer.setQuestion(aQuestion);
        aQuestion.addAnswer(anAnswer);
        
        try {
        
            em.persist(aQuestion);
            
            return QuestionToJsonConverter.generateJsonSuccess(aQuestion);
            
        
        }catch(Exception ex){
            
            throw new UnacceptedAnswerException();
        }
        
        
    }

    @Override
    public String getAnswerSummaryForQuestionId(String id) throws UnexistentQuestionException{
        
         Question aQuestion = getQuestionById(id);
         
         if(aQuestion == null) throw new UnexistentQuestionException();
         
         //compute the aggregates
         Map aggregates = AnswerSummaryCalculator.calculate(aQuestion);
         
         return QuestionToJsonConverter.convertQuestionAnswersToJson(aggregates);
          
        
    }
    
  
    @Override
    public String createQuestion(String questionId, String question) {
        
        log.info("Going to create new question: " + questionId + " - " + question);
        
        Question aQuestion = new Question();
        
        aQuestion.setId(questionId);
        aQuestion.setQuestionText(question);
        
        em.persist(aQuestion);
        
        return QuestionToJsonConverter.generateJsonSuccess(aQuestion);
        
        
    }
    
    
      private Question getQuestionById(String id){
        
         Question aQuestion = em.find(Question.class, id);
         
         return  aQuestion;
    
    }

    private String decorateAnswer(String answer) {
        
        answer = answer.trim();
        answer = answer.toLowerCase();
        
        return answer;
        
    }

    
    
    
    
    
    
}
