/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.beans;

import com.zanox.james.rest.JamesService;
import com.zanox.james.entities.Answer;
import com.zanox.james.exceptions.UnacceptedAnswerException;
import com.zanox.james.entities.Question;
import com.zanox.james.exceptions.PersistenceException;
import com.zanox.james.exceptions.UnexistentQuestionException;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public Question getQuestion(String questionId) throws UnexistentQuestionException {

        Question aQuestion = getQuestionById(questionId);

        return aQuestion;

    }

    @Override
    public Question setAnswer(String questionId, String answer) throws UnacceptedAnswerException, UnexistentQuestionException {

        Question aQuestion = getQuestionById(questionId);

        Answer anAnswer = new Answer();
        anAnswer.setAnswerText(answer);

        //build the relationships
        anAnswer.setQuestion(aQuestion);
        aQuestion.addAnswer(anAnswer);

        try {

            em.persist(aQuestion);

            return aQuestion;


        } catch (Exception ex) {

            throw new UnacceptedAnswerException();
        }


    }

    @Override
    public Map<String, String> getAnswerSummaryForQuestionId(String id) throws UnexistentQuestionException {

        Question aQuestion = getQuestionById(id);

        
        //compute the aggregates
        Map aggregates = AnswerSummaryCalculator.calculate(aQuestion);

        return aggregates;


    }

    @Override
    public Question createQuestion(String questionId, String question) throws PersistenceException {

        log.info("Creating new question: " + questionId + " - " + question);

        Question aQuestion = new Question();

        aQuestion.setId(questionId);
        aQuestion.setQuestionText(question);

        try {

            em.persist(aQuestion);

            return aQuestion;

        } catch (Exception ex) {

            throw new PersistenceException();
        }

    }

    @Override
    public List<Question> listAllQuestions() throws PersistenceException{

        Query qr = em.createQuery("SELECT q FROM Question q");

        List<Question> allQuestions = qr.getResultList();

        return allQuestions;


    }

    @Override
    public List<Answer> listAllAnswersForQuestion(String id) throws UnexistentQuestionException, PersistenceException{
        
        Question aQuestion = getQuestionById(id);
        
        return aQuestion.getAnswers();
        
        
    }

    @Override
    public Question deleteAnswersForQuestion(String id) throws UnexistentQuestionException, PersistenceException {
      
        Question aQuestion = getQuestionById(id);
        
        aQuestion.getAnswers().clear();
               
        em.merge(aQuestion);
        
        return aQuestion;
        
        
    }
    
    @Override
    public Question deleteQuestion(String id) throws UnexistentQuestionException, PersistenceException {
        
        Question aQuestion = getQuestion(id);
        
        em.remove(aQuestion);
        
        return aQuestion;
        
    }

    

    private Question getQuestionById(String id) throws UnexistentQuestionException {

        Question aQuestion = em.find(Question.class, id);

        if (aQuestion == null) {
        
            throw new UnexistentQuestionException();
        }else {
              return aQuestion;
        }
        
      

    }

   

   
}
