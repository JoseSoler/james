/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.beans;

import com.zanox.james.entities.Answer;
import com.zanox.james.entities.Question;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jose.soler
 */
public class AnswerSummaryCalculator {

    public static Map<String,String> calculate(Question aQuestion) {
        
        Map<String,String> aggregation = new HashMap<String,String>();
        
        
        for(Answer anAnswer: aQuestion.getAnswers()){
            
            String value = aggregation.get(anAnswer.getAnswerText());
            
            if(value == null){
                
                aggregation.put(anAnswer.getAnswerText(), "1");
            
            } else {
                
                Integer intValue = Integer.parseInt(value);
                intValue++;
                
                aggregation.put(anAnswer.getAnswerText(), intValue.toString());
                
            }
        
        }
        
        
        return aggregation;
        
    }
    
}
