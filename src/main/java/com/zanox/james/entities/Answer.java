/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jose.soler
 */
@Entity
public class Answer {
    
      
    @Id @GeneratedValue
    private Integer id;
    
    private String answerText;
    
    
    private Integer questionId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "questionId", referencedColumnName = "id")
    private Question question;
    
    
    
    public Answer(String answer) {
    
        this.answerText = answer;
    }
    
    public Answer() {}
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    

     
}
