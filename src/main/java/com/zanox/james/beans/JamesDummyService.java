/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.beans;

import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.exceptions.UnexistentQuestionException;
import com.zanox.james.rest.JamesService;
import org.apache.log4j.Logger;

/**
 *
 * @author jose.soler
 */
public class JamesDummyService implements JamesService{
    
    private Logger log = Logger.getLogger(JamesDummyService.class);

    @Override
    public String getAnswerSummaryForQuestionId(Integer id) throws UnexistentQuestionException {
        
        log.info("Answer Summary called");
        
        return "{ \"Twitter\":4, \"Facebook\":1, \"Zanox Marketplace\":2}";
    }

    @Override
    public String getQuestion(Integer questionId) throws UnexistentQuestionException {
        
           log.info("Get Question Called");
           return "{ " + questionId + ": \"What is your favorite app?\" }";
    }

    @Override
    public String setAnswer(Integer questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException {
        
        log.info("Set Answer Called");
        
        if(questionId == null || answer == null|| answer.length() == 0) throw new UnacceptedAnswerException();
        
        return "{ " + questionId + ": \"OK\" }";
        
        
    }
    
}
