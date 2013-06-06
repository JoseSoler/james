/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.beans;

import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.exceptions.UnexistentQuestionException;
import org.apache.log4j.Logger;

/**
 *
 * @author jose.soler
 */
public class JamesDummyService{
    
    private Logger log = Logger.getLogger(JamesDummyService.class);

    public String getAnswerSummaryForQuestionId(String id) throws UnexistentQuestionException {
        
        log.info("Answer Summary called");
        
        return "{\"tags\": [ {\"answer\":\"Twitter\", \"count\":\"4\"},{\"answer\":\"Facebook\", \"count\":\"1\"},{\"answer\":\"Zanox Marketplace\", \"count\":\"2\"} ]}";
      
        
    }

    public String getQuestion(String questionId) throws UnexistentQuestionException {
        
           log.info("Get Question Called");
           return "{ \"" + questionId + "\": \"What is your favorite app?\" }";
    }

    public String setAnswer(String questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException {
        
        log.info("Set Answer Called");
        
        if(questionId == null || answer == null|| answer.length() == 0) throw new UnacceptedAnswerException();
        
        return "{ \"" + questionId + "\": \"OK\" }";
        
        
    }
    
}
