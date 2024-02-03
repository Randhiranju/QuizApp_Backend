# QuizApp_Backend
Contains Basic functionalities of a quiz app like create quiz, add question , calculate score etc. It also explores various aspect of backend like CRUD operation , SpringBoot Bean Validation and Exception Handling.



                       QUESTIONS OPERATIONS

1. Add Question: http://localhost:8080/questions/addQuestions
   
![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/4603b985-88ef-42c2-a3fd-a08b7ea3a77a)



2. View All Questions : http://localhost:8080/questions/getAllQuestions
   
![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/c4e883ab-752d-4191-84c3-8fcae753b272)

         Parsed

  ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/dda4de18-7117-4880-9533-2967b44dfbc6)



        

3. Get Question by Catogery : http://localhost:8080/questions/catogery/{catogery}
   
![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/efa8c47f-29ef-4766-b6d7-9f439ff83161)



4. Get Question by difficulty Level : http://localhost:8080/questions/difficulty/{difficulty_level}
   
   ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/9c3378e7-08bb-4002-bec3-0af3d6bfb662)

   

5. Update Question: http://localhost:8080/questions/update/{id}

   ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/a2a6b28d-81b9-451c-b82e-34eda19b0f23)

    

6. Delete Question : http://localhost:8080/questions/delete/{id}
   
      ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/0762e087-56a8-4299-8326-8ffbfd7e5d91)
   

7. Bean Validation and Exception Handling on Questions :
   
     ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/d1e8ce5e-1a9d-41c8-a6dd-7bda408bd391)

   


                                    QUIZ OPERATIONS
   
   
1. Create Quiz Using Random Questions : http://localhost:8080/quiz/create?catogery=Java&numQ=3&title=JavaQuiz
   
   ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/b8506bdd-a4f6-4b51-95a4-c6157443b04d)

   

2. Assign Quiz : http://localhost:8080/quiz/getQuiz/1
   
   ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/5445521d-f9df-4657-9201-871a8bd7bd0a)

   

3. Quiz Evaluation : http://localhost:8080/quiz/submit/{quiz_id}
   
   ![image](https://github.com/Randhiranju/QuizApp_Backend/assets/94231655/139fe813-7331-44e3-b5d6-5bd2a7c65eec)


   








