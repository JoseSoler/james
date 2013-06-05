/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.rest;

import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.exceptions.UnexistentQuestionException;

/**
 *
 * @author jose.soler
 */
public interface JamesService {

    String getAnswerSummaryForQuestionId(Integer id) throws UnexistentQuestionException;

    String getQuestion(Integer questionId) throws UnexistentQuestionException;

    String setAnswer(Integer questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException;
    
}
