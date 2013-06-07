/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclipsesource.json;

import com.zanox.james.entities.Answer;
import com.zanox.james.entities.Question;
import java.util.List;
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
   
   
    public static String generateUnexistentQuestionJsonError(String id) {
        
           JsonObject result = new JsonObject();
         
            result.add("id", id);
            result.add("question", "unknown");
            result.add("result", "error");
            result.add("message", "Unexistent question in the Database.");
        
            return result.toString();
         
            
    }
    
     public static String generateJsonSuccess(Question question) {
        
         JsonObject result = new JsonObject();
         
         result.add("id", question.getId());
         result.add("question", question.getQuestionText());
         result.add("result", "success");
         
         
         return result.toString();
         
            
    }

    public static String generateCreatingQuestionJsonError(String id) {
    
        
           JsonObject result = new JsonObject();
         
            result.add("id", id);
            result.add("question", "unknown");
            result.add("result", "error");
            result.add("message", "Error while creating new question.");
        
            return result.toString();
    
    }

    public static String generateAllQuestionsError() {
        
            JsonObject result = new JsonObject();
         
            result.add("id", "ALL");
            result.add("question", "ALL");
            result.add("result", "error");
            result.add("message", "Error while generating all questions.");
        
            return result.toString();
        
    }

    public static String generateAllQuestionsJson(List<Question> allQuestions) {
       
        JsonObject result = new JsonObject();
        JsonArray  questions = new JsonArray();
        
        
        for(Question aQuestion: allQuestions){
        
            JsonObject jsonQuestion = new JsonObject();
         
            jsonQuestion.add("id", aQuestion.getId());
            jsonQuestion.add("question", aQuestion.getQuestionText());
            
            questions.add(jsonQuestion);
        
        }
        
        
        
        result.add("allQuestions", questions);
        return result.toString();
        
    }

    public static String generateAllAnswersJson(List<Answer> allAnswers) {
       
          JsonObject result = new JsonObject();
          JsonArray  answers = new JsonArray();
        
        
        for(Answer anAnswer: allAnswers){
        
            JsonObject jsonAnswer = new JsonObject();
         
            jsonAnswer.add("answer", anAnswer.getAnswerText());
            
            answers.add(jsonAnswer);
        
        }
        
        
        
        result.add("allAnswers", answers);
        return result.toString();
        
        
    }

    public static String generateDeleteAnswersJson(Question aQuestion) {
       
        JsonObject result = new JsonObject();
        
        result.add("id", aQuestion.getId());
        result.add("question", aQuestion.getQuestionText());
        result.add("result", "sucess");
        result.add("message", "All answers have been deleted from database.");

        return result.toString();
        
    }

    public static String generatePersistenceJsonError(String id) {

        JsonObject result = new JsonObject();

        result.add("id", id);
        result.add("question", "unknown");
        result.add("result", "error");
        result.add("message", "Error while persisting the information.");

        return result.toString();

    }

    public static String generateDeleteQuestionJson(Question aQuestion) {
       
        JsonObject result = new JsonObject();
        
        result.add("id", aQuestion.getId());
        result.add("question", aQuestion.getQuestionText());
        result.add("result", "sucess");
        result.add("message", "Question have been deleted from database.");

        return result.toString();
    }
}
