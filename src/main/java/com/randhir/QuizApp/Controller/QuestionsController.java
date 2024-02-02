package com.randhir.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.randhir.QuizApp.Entity.Questions;
import com.randhir.QuizApp.Services.QuestionsServices;

@RestController
@RequestMapping("/questions")
// to do manipulation with questions CRUD
public class QuestionsController {
	@Autowired
	QuestionsServices qs;
	
	//write
		@PostMapping("/addQuestions")
		//requestBody annotation used to change JSON to object
		public ResponseEntity<String> addQuestions(@RequestBody Questions question) {
			 return qs.addQuestions(question);
		}
	
	/*get all question controller ( returns a list of question )
		@GetMapping("/getAllQuestions")
		public List<Questions> getAllQuestions(){
			return qs.getAllQuestions();
		}*/
		
		//using ResponseEntity to send http code
		@GetMapping("/getAllQuestions")
		public ResponseEntity<List<Questions>>getAllQuestions(){
			return qs.getAllQuestions();
		}
	
	/*get question by catogery 
		@GetMapping("/catogery/{catogery}")
		public List<Questions> getQuestionsByCatogery(@PathVariable String catogery){
			//since name of pathVarible is same in url and here we needn't specify else we have to specify
			// like pathvaribale("cat") String catogery
			return qs.getQuestionsByCatogery(catogery);
		}*/
		
		
		@GetMapping("/catogery/{catogery}")
		public ResponseEntity<List<Questions>>getQuestionsByCatogery(@PathVariable String catogery){
			//since name of pathVarible is same in url and here we needn't specify else we have to specify
			// like pathvaribale("cat") String catogery
			return qs.getQuestionsByCatogery(catogery);
		}
		
		@GetMapping("/difficulty/{difficultyLevel}")
		public List<Questions> getByDifficultyLevel(@PathVariable String difficultyLevel){
			return qs.getQuestionByDifficultyLevel(difficultyLevel);
		}
		
		//update questions
		@PutMapping("/update/{id}")
		public String updateQuestion(@PathVariable Integer id,@RequestBody Questions ques) {
			return qs.updateQuestion(id, ques);
		}
		//delete questions 
		@DeleteMapping("/delete/{id}")
		public String deleteQuestion(@PathVariable Integer id) {
			return qs.deleteQuestion(id);
		}
}
