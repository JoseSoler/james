/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclipsesource.json;

import com.zanox.james.entities.Question;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author jose.soler
 */
public class QuestionToJsonConverter {
    
    public static String convertQuestionAnswersToJson(Map<String,String> aggregates){
        // {"tags": [ {"answer":"Twitter", "count":"4"},{"answer":"Facebook", "count":"1"},{"answer":"Zanox Marketplace", "count":"2"} ]}

       
        JsonArray jArray = new JsonArray();
        
        
        for (Entry<String, String> anEntry : aggregates.entrySet()) {

            JsonObject element = new JsonObject();
            element.add("answer", anEntry.getKey());
            element.add("count", anEntry.getValue());

            jArray.add(element);
        }
        
        
        
        JsonObject jResult = new JsonObject();
        jResult.add("tags", jArray);
        
        return jResult.toString();
        
       
    }
    
    public static String convertQuestionToJson(Question question){
        
         JsonObject result = new JsonObject();
         
         result.add(question.getId(), question.getQuestionText());
         
         return result.toString();
    }

    public static String answerAccepted(Question question) {
        
         JsonObject result = new JsonObject();
         
         result.add(question.getId(), "OK");
         
         return result.toString();
         
            
    }
}
