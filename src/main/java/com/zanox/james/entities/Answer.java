/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author jose.soler
 */
@Entity
@Table(name = "ANSWER", schema = "JAMES")
public class Answer {
     
    @TableGenerator(name="answer_gen", schema = "JAMES", table = "ID_GEN", pkColumnName = "gen_name" , valueColumnName = "gen_val")
    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "answer_gen")
    private Integer id;
    
    private String answerText;
    
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

   
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    

     
}
