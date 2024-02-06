package com.randhir.QuizApp.Services;
// Logic : CRUD operation on questions
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.randhir.QuizApp.Entity.Questions;
import com.randhir.QuizApp.Exception.BadRequestException;
import com.randhir.QuizApp.Exception.SizeException;
import com.randhir.QuizApp.Repository.QuestionsRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;



@Service
public class QuestionsServices {
	
	@Autowired
	QuestionsRepo repo;
	
	/*write questions
	public String addQuestions(Questions question) {
		repo.save(question);
		return "Successfully Added";
	}*/
	
	public ResponseEntity<String>addQuestions(Questions question) {
		repo.save(question);
		return new ResponseEntity<>("Successfully Added",HttpStatus.CREATED);
	}
	
	
	// to get all questions
	/*public List<Questions> getAllQuestions() {
		return repo.findAll(); // find all returns list 
	}*/
	
	//Getting all questions along with status code
	public ResponseEntity<List<Questions>> getAllQuestions(int pageNumber, int pageSize, String sortField, String sortDir) {
		
		Sort sort = null;
		if(sortDir.equals("asc"))
		{
			sort = Sort.by(sortField).ascending();
			
		}
		else 
		{
			sort = Sort.by(sortField).descending();
			
		}
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Questions> page = repo.findAll(pageable);
		List<Questions>list = page.getContent();
		
		if(list.size()==0) {
			throw new BadRequestException("No questions are there in DB");
		}else {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
	}
	
	/*get questions by catogery
	public List<Questions> getQuestionsByCatogery(String catogery){
		// we want to get data from non-primary key hence can't use getById
		return repo.findByCatogery(catogery);
	}*/
	public ResponseEntity<List<Questions>> getQuestionsByCatogery(String catogery){
		// we want to get data from non-primary key hence can't use getById
		List<Questions> list = repo.findByCatogery(catogery);
		if(list.size()==0) {
			throw new BadRequestException("Catogery not available");
		}else if(list.size()==1) {
			throw new SizeException("Size Greater than 1");
		}else {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		
		
	}
	
	// get by difficulty level
	public List<Questions> getQuestionByDifficultyLevel(String difficulty_level){
		return repo.findByDifficultyLevel(1, difficulty_level);
	}
	
	//update Question 
	public String updateQuestion(Integer id,Questions ques) {
		
		Questions q= repo.findById(id).get();
		if(q == null)
		{
			throw new BadRequestException("Resource not found : " + id);
		}
		//changing
		q.setCatogery(ques.getCatogery());
		q.setDifficultyLevel(ques.getDifficultyLevel());
		q.setQuestionTitle(ques.getQuestionTitle());
		q.setOption1(ques.getOption1());
		q.setOption2(ques.getOption2());
		q.setOption3(ques.getOption3());
		q.setOption4(ques.getOption4());
		q.setRightAnswer(ques.getRightAnswer());
		
		repo.save(q);
		return "Updated SuccessFully";
	}
	
	//delete operation 
	public String deleteQuestion(Integer id) {
		repo.deleteById(id);
		return "Deleted Successfully";
	}
	
}
