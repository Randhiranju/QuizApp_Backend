package com.randhir.QuizApp.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.randhir.QuizApp.Entity.QuestionWrapper;
import com.randhir.QuizApp.Entity.Questions;
import com.randhir.QuizApp.Entity.Quiz;
import com.randhir.QuizApp.Entity.Response;
import com.randhir.QuizApp.Exception.BadRequestException;
import com.randhir.QuizApp.Repository.QuestionsRepo;
import com.randhir.QuizApp.Repository.QuizRepo;

@Service
public class QuizServices {
	
	@Autowired
	QuizRepo qzRepo;
	
	@Autowired
	QuestionsRepo qsRepo;  // to get questions
	
	public  ResponseEntity<Quiz> createQuiz(String catogery, int numQ, String title) {
		
		List<Questions> questions= qsRepo.findRandomQuestionsByCatogery(catogery,numQ); // to get random question we need to create this method manually using JQL
		
		Quiz q= new Quiz();
		q.setTitle(title);
		q.setQuestions(questions);
		Quiz q1 = qzRepo.save(q);
		
		return new ResponseEntity<>(q1,HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
		Optional<Quiz> quiz= qzRepo.findById(id);
		List<Questions> questionsFromDb= quiz.get().getQuestions();// since we have used optional we need to get object first using get() method 
		List<QuestionWrapper>questionsForUser= new ArrayList<>();
		//converting question to question wrapper to only give necessary info to user
		for(Questions q : questionsFromDb) {
			QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz qz= qzRepo.findById(id).get();
		if(qz == null)
		{
			throw new BadRequestException("Quiz not found");
		}
		List<Questions> questions= qz.getQuestions(); // all questions
		
		int score=0;
		Map<Integer,String> map= new HashMap<>();//store id mapped to correct answer
		for(Questions q:questions) {
			Integer qid= q.getId();
			String rightAnswer=q.getRightAnswer();
			map.put(qid, rightAnswer);
		}
		for(Response resp:responses) {
			Integer rid=resp.getId();
			String res=resp.getResponse();
			if(map.containsKey(rid)) {
				String correctAns=map.get(rid);
				if(res.equals(correctAns)) {
					score++;
				}
			}
		}
		return new ResponseEntity<>(score,HttpStatus.OK);
	} 
	
}
