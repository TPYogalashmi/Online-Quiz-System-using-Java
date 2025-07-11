public interface Quiz {
    void loadQuestions();
    void displayQuestion();
    void checkAnswer(String selected);
    void showResult();
}

