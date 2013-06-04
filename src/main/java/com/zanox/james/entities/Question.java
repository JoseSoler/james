/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jose.soler
 */

@Entity
public class Question {
    
    @Id @GeneratedValue
    private Integer id;
    
    private String questionText;
    
    private List<Answer> answers;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer anAnswer) {
    
       answers.add(anAnswer);
    }
    
    
    
    
    
    
}
