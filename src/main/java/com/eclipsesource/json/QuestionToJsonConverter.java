/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclipsesource.json;

import com.zanox.james.entities.Question;

/**
 *
 * @author jose.soler
 */
public class QuestionToJsonConverter {
    
    public static String convertQuestionAnswersToJson(Question question){
        
        return "{ \"Twitter\":4, \"Facebook\":1, \"Zanox Marketplace\":2}";
    }
    
    public static String convertQuestionToJson(Question question){
        
         return "{ 1: \"What is your favorite app?\" }";
    }
}
