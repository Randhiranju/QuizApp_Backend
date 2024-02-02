package com.randhir.QuizApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.randhir.QuizApp.Entity.Questions;

public interface QuestionsRepo extends JpaRepository<Questions, Integer>{
	
	// to fetch data using non-primary key we need to give simply defination in dao no body is required here
	List<Questions> findByCatogery(String catogery);
	// but if we need lot's of customization then we need to use HQL (hybernate query language) or JPQL
	
	
	// for writing custom query we need to use @Query annotation  argument : value (sql_query), nativeQuery=true (query will be generated as per SQL)
	@Query(value = "select * from questions where difficulty_level = :level limit :num",nativeQuery = true)
	List<Questions>findByDifficultyLevel(int num,String level);
	
	// to get random number of questions by catogery using JPQL query
	@Query(value="select * from questions q where q.catogery= :catogery order by Rand() limit :numQ", nativeQuery=true)
	List<Questions> findRandomQuestionsByCatogery(String catogery, int numQ);
}
