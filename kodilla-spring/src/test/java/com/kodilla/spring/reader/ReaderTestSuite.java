package com.kodilla.spring.reader;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class ReaderTestSuite {
    @Test
    public void testRead() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);

        //When
        String result = reader.read();

        //Then
        Assert.assertEquals("Reading: The book number one", result);
    }

    @Test
    public void testConditional() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);

        //When
        boolean book2Exists = context.containsBean("book2");

        //Then
        if (LocalDate.now().getDayOfMonth() % 2 != 0) {
            Assert.assertTrue(book2Exists);
        } else {
            Assert.assertFalse(book2Exists);
        }

        System.out.println("Bean book2 was found in the container: " + book2Exists);
    }
}
