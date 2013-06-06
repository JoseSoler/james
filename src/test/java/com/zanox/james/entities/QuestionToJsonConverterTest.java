/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.entities;

import com.eclipsesource.json.QuestionToJsonConverter;
import org.junit.Assert;
import org.junit.Ignore;

/**
 *
 * @author jose.soler
 */
public class QuestionToJsonConverterTest {
    
    
    @Ignore
    public void convertToJson(){
    
               
        Question aQuestion = new Question("Your favorite app?");
        
        Answer answer1 = new Answer("Twitter");
        Answer answer2 = new Answer("Facebook");
        Answer answer3 = new Answer("Zanox Marketplace");
        Answer answer4 = new Answer("Twitter");
        Answer answer5 = new Answer("Twitter");
        Answer answer6 = new Answer("Zanox Marketplace");
        Answer answer7 = new Answer("Twitter");
        
        
        aQuestion.addAnswer(answer1);
        aQuestion.addAnswer(answer2);
        aQuestion.addAnswer(answer3);
        aQuestion.addAnswer(answer4);
        aQuestion.addAnswer(answer5);
        aQuestion.addAnswer(answer6);
        aQuestion.addAnswer(answer7);
        
        
        String expected = "{ \"Twitter\":4, \"Facebook\":1, \"Zanox Marketplace\":2}";
        
        String actual = QuestionToJsonConverter.convertQuestionAnswersToJson(aQuestion);
        
        Assert.assertEquals("Json Question Parser not working as expected.", expected, actual);
        
        
    }
    
}
