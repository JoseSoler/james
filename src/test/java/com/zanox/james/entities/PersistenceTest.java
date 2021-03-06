/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanox.james.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author jose.soler
 */

public class PersistenceTest {

    @Ignore
    public void testEntities() {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("james_persistence");
        EntityManager em = emf.createEntityManager();

        
        Question aQuestion = new Question();
        
        aQuestion.setQuestionText("What is your name?");
        

        em.getTransaction().begin();

        em.persist(aQuestion);
        
        em.getTransaction().commit();
        
        assertNotNull(aQuestion.getId());
              
        
        em.close();
        emf.close();





    }
}
