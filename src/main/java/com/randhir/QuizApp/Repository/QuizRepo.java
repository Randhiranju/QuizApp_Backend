package com.randhir.QuizApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.randhir.QuizApp.Entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {

}
