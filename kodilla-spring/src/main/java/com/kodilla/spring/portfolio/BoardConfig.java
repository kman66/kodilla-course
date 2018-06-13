package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Bean
    public Board board() {
        return new Board(doneList(), inProgressList(), toDoList());
    }

    @Bean
    public TaskList doneList() {
        return new TaskList();
    }

    @Bean
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean
    public TaskList toDoList() {
        return new TaskList();
    }
}
