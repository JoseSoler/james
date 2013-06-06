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
   
   
    public static String generateJsonError(Question question, String errorMessage) {
        
         JsonObject result = new JsonObject();
         
         result.add("id", question.getId());
         result.add("question", question.getQuestionText());
         result.add("result", "error");
         result.add("message", errorMessage);
         
         
         
         return result.toString();
         
            
    }
    
     public static String generateJsonSuccess(Question question) {
        
         JsonObject result = new JsonObject();
         
         result.add("id", question.getId());
         result.add("question", question.getQuestionText());
         result.add("result", "success");
         
         
         return result.toString();
         
            
    }
}
