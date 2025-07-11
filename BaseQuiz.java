import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class BaseQuiz extends Frame implements Quiz, ActionListener {
    Label label;
    Button optionA, optionB, optionC, optionD, nextBtn;
    List<String[]> questionBank = new ArrayList<>();
    List<String[]> selectedQuestions = new ArrayList<>();
    int index = 0, score = 0;

    public BaseQuiz(String subject) {
        setTitle(subject + " Quiz");
        setSize(500, 300);
        setLayout(null);
        setVisible(true);

        label = new Label();
        label.setBounds(50, 50, 400, 30);
        add(label);

        optionA = new Button("");
        optionB = new Button("");
        optionC = new Button("");
        optionD = new Button("");
        nextBtn = new Button("Next");

        optionA.setBounds(50, 100, 150, 30);
        optionB.setBounds(250, 100, 150, 30);
        optionC.setBounds(50, 150, 150, 30);
        optionD.setBounds(250, 150, 150, 30);
        nextBtn.setBounds(180, 200, 100, 30);

        add(optionA);
        add(optionB);
        add(optionC);
        add(optionD);
        add(nextBtn);

        optionA.addActionListener(this);
        optionB.addActionListener(this);
        optionC.addActionListener(this);
        optionD.addActionListener(this);
        nextBtn.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        loadQuestions();
        selectRandomQuestions();
        displayQuestion();
    }

    public void selectRandomQuestions() {
        Collections.shuffle(questionBank);
        for (int i = 0; i < Math.min(10, questionBank.size()); i++) {
            selectedQuestions.add(questionBank.get(i));
        }
    }

    public void displayQuestion() {
        if (index < selectedQuestions.size()) {
            String[] q = selectedQuestions.get(index);
            label.setText("Q" + (index + 1) + ": " + q[0]);
            optionA.setLabel(q[1]);
            optionB.setLabel(q[2]);
            optionC.setLabel(q[3]);
            optionD.setLabel(q[4]);
        } else {
            showResult();
        }
    }

    public void checkAnswer(String selected) {
        String[] currentQ = selectedQuestions.get(index);
        if (selected.equals(currentQ[5])) {
            score++;
        }
    }

    public void showResult() {
        label.setText("Quiz Completed! Your Score: " + score + " / " + selectedQuestions.size());
        optionA.setVisible(false);
        optionB.setVisible(false);
        optionC.setVisible(false);
        optionD.setVisible(false);
        nextBtn.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == optionA) checkAnswer("A");
        else if (ae.getSource() == optionB) checkAnswer("B");
        else if (ae.getSource() == optionC) checkAnswer("C");
        else if (ae.getSource() == optionD) checkAnswer("D");

        if (ae.getSource() == nextBtn) {
            index++;
            displayQuestion();
        }
    }
}
