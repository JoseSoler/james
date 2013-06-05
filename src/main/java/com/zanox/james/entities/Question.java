/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jose.soler
 */

@Entity
public class Question {
    
    @Id @GeneratedValue
    private Integer id;
    
    private String questionText;
    
    @OneToMany( mappedBy = "questionId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Answer> answers;
    

    
     public Question(String question) {
    
        this.questionText = question;
    }
    
    public Question() {}
    
    
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

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer anAnswer) {
        
        if(answers == null){
            answers = new ArrayList<Answer>();
        }
            
        this.answers.add(anAnswer);
        
    }

      
      
    
}
