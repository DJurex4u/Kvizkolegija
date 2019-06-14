package com.ivanbudos.kvizkolegija;

public class GenerateQuiz {
    /*public static  GenerateQuiz1();*/
  private QuestionModel[] quiz;

  public GenerateQuiz(int num){
      switch (num) {
          case 1:
              GeneratorQuiz1();
              break;
          case 2:
              GeneratorQuiz2();
              break;
          case 3:
              GeneratorQuiz3();
              break;
          case 4:
              GeneratorQuiz4();
              break;
          default:
              GeneratorQuiz1();
      }
  }

  private void GeneratorQuiz1(){
      int max = AllQuestions.questionsQuiz1.length;
      quiz = new QuestionModel[max];
      for(int i = 0; i < max -1 ; i++){

          String question = (AllQuestions.questionsQuiz1[i]);
          int rightAnswer = (AllQuestions.rightAnswersQuiz1[i]);
          String[] possibleAnswers = (AllQuestions.posibleAnswersQuiz1[i]);

          quiz[i] = new QuestionModel(question, possibleAnswers, rightAnswer);
      }

  }

    private void GeneratorQuiz2() {
        int max = AllQuestions.questionsQuiz2.length;
        quiz = new QuestionModel[max];
        for (int i = 0; i < max -1; i++) {
            String question = (AllQuestions.questionsQuiz2[i]);
            int rightAnswer = (AllQuestions.rightAnswersQuiz2[i]);
            String[] possibleAnswers = (AllQuestions.posibleAnswersQuiz2[i]);
            quiz[i] = new QuestionModel(question, possibleAnswers, rightAnswer);
        }
    }


    private void GeneratorQuiz3() {
        int max = AllQuestions.questionsQuiz3.length;
        quiz = new QuestionModel[max];
        for (int i = 0; i < max -1; i++) {
            String question = (AllQuestions.questionsQuiz3[i]);
            int rightAnswer = (AllQuestions.rightAnswersQuiz3[i]);
            String[] possibleAnswers = (AllQuestions.posibleAnswersQuiz3[i]);
            quiz[i] = new QuestionModel(question, possibleAnswers, rightAnswer);
        }
    }

    private void GeneratorQuiz4() {
        int max = AllQuestions.questionsQuiz4.length;
        quiz = new QuestionModel[max];
        for (int i = 0; i < max -1; i++) {
            String question = (AllQuestions.questionsQuiz4[i]);
            int rightAnswer = (AllQuestions.rightAnswersQuiz4[i]);
            String[] possibleAnswers = (AllQuestions.posibleAnswersQuiz4[i]);
            quiz[i] = new QuestionModel(question, possibleAnswers, rightAnswer);
        }
    }

    public QuestionModel[] getQuiz() {
        return quiz;
    }
}
