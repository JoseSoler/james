/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.rest;

import com.zanox.james.entities.Answer;
import com.zanox.james.exceptions.PersistenceException;
import com.zanox.james.entities.Question;
import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.exceptions.UnexistentQuestionException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jose.soler
 */
public interface JamesService {


    public Question getQuestion(String questionId) throws UnexistentQuestionException;

    public Question setAnswer(String questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException;

    public Question createQuestion(String id, String question) throws PersistenceException;
    
    public Question deleteAnswersForQuestion(String id) throws UnexistentQuestionException, PersistenceException;
    
    public Question deleteQuestion(String id) throws UnexistentQuestionException, PersistenceException; 
    
    public Map<String,String> getAnswerSummaryForQuestionId(String questionId) throws UnexistentQuestionException;

    public List<Question> listAllQuestions() throws PersistenceException;

    public List<Answer> listAllAnswersForQuestion(String id) throws UnexistentQuestionException, PersistenceException;

    
    
}
