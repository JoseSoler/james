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
        // {"tags": [ {"answer":"Twitter", "count":"4"},{"answer":"Facebook", "count":"1"},{"answer":"Zanox Marketplace", "count":"2"} ]}

       
        JsonArray jArray = new JsonArray();
        
        JsonObject element1 = new JsonObject();
        element1.add("answer", "twitter");
        element1.add("count", "4");
        
        JsonObject element2 = new JsonObject();
        element2.add("answer", "facebook");
        element2.add("count", "1");
        
        JsonObject element3 = new JsonObject();
        element3.add("answer", "ms word");
        element3.add("count", "2");
                
        
        jArray.add(element1);
        jArray.add(element2);
        jArray.add(element3);
        
        
        JsonObject jResult = new JsonObject();
        jResult.add("tags", jArray);
        
        return jResult.toString();
        
       
    }
    
    public static String convertQuestionToJson(Question question){
        
         JsonObject result = new JsonObject();
         
         result.add(question.getId(), question.getQuestionText());
         
         return result.toString();
    }
}
