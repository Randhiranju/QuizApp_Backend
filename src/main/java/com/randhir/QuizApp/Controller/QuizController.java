package com.randhir.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.randhir.QuizApp.Entity.QuestionWrapper;
import com.randhir.QuizApp.Entity.Questions;
import com.randhir.QuizApp.Entity.Quiz;
import com.randhir.QuizApp.Entity.Response;
import com.randhir.QuizApp.Services.QuizServices;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizServices quizServ;
	
	//quiz controller to create quiz and put it in quiz db
	@PostMapping("/create")
	public ResponseEntity<Quiz> createQuiz(@RequestParam String catogery,@RequestParam int numQ, @RequestParam String title){
		return quizServ.createQuiz(catogery,numQ,title);
	}
	
	// get quiz with quiz id 
	@GetMapping("/getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
		return  quizServ.getQuizQuestions(id);
	}
	
	//calculate Result
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
		return quizServ.calculateResult(id,responses);
	}
}
