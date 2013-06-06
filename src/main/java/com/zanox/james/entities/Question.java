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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jose.soler
 */

@Entity
@Table(name = "QUESTION", schema = "JAMES")
public class Question {
    
    @Id
    private String id;
    
    private String questionText;
    
    @OneToMany( mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Answer> answers;
    

    
     public Question(String question) {
    
        this.questionText = question;
    }
    
    public Question() {}
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
