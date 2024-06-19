import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame {
    private static final int max_time = 10;
    private int currentQuesNo = 0;
    private int score = 0;
    private int time_left;
    private Timer timer;

    private String[][] questions = {
            {"What is the capital of India?", "a) Rajasthan", "b) West Bengal", "c) Delhi", "d) Punjab", "c"},
            {"Which bird is India's National Bird?", "a) Hen", "b) Peacock", "c) Cuckoo", "d) Nightingale", "b"},
            {"What language is spoken most in Gujarat?", "a) Marathi", "b) Hindi", "c) Tamil", "d) Gujarati", "d"}
    };

    private JLabel questionLabel = new JLabel();
    private JRadioButton[] options = new JRadioButton[4];
    private ButtonGroup optionsGroup = new ButtonGroup();
    private JButton submitButton = new JButton("Submit");
    private JLabel timerLabel = new JLabel("Time left: " + max_time + " seconds");

    public Quiz() {
        setTitle("Simple Quiz with Timer");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        add(questionLabel);
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            add(options[i]);
        }
        add(timerLabel);
        add(submitButton);

        submitButton.addActionListener(new SubmitButtonListener());

        displayQuestion();
        startTimer();

        setVisible(true);
    }

    private void displayQuestion() {
        if (currentQuesNo < questions.length) {
            String[] question = questions[currentQuesNo];
            questionLabel.setText(question[0]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(question[i + 1]);
                options[i].setSelected(false);
            }
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        time_left = max_time;
        timerLabel.setText("Time left: " + time_left + " seconds");
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time_left--;
                timerLabel.setText("Time left: " + time_left + " seconds");
                if (time_left <= 0) {
                    timer.stop();
                    checkAnswer(null);
                }
            }
        });
        timer.start();
    }

    private void checkAnswer(String selectedOption) {
        timer.stop();
        String correctAnswer = questions[currentQuesNo][5];
        if (selectedOption != null && selectedOption.equalsIgnoreCase(correctAnswer)) {
            score++;
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, "Wrong. The correct answer was: " + correctAnswer);
        }
        currentQuesNo++;
        if (currentQuesNo < questions.length) {
            displayQuestion();
            startTimer();
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz over! Your score is: " + score + "/" + questions.length);
        System.exit(0);
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (JRadioButton option : options) {
                if (option.isSelected()) {
                    checkAnswer(option.getText().substring(0, 1));
                    return;
                }
            }
            JOptionPane.showMessageDialog(Quiz.this, "Please select an option.");
        }
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
