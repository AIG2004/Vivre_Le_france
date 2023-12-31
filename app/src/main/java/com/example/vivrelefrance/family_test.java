package com.example.vivrelefrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class family_test extends AppCompatActivity {
    private List<Question> questionsList = new ArrayList<>();
    private TextView questionTextView;
    private ImageButton optionButton1;
    private ImageButton optionButton2;
    private int currentIndexQ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_test);

        // Move the view initialization here
        questionTextView = findViewById(R.id.question);
        optionButton1 = findViewById(R.id.option1);
        optionButton2 = findViewById(R.id.option2);

        questionsList.add(new Question("mère", R.drawable.grandmother, R.drawable.mother, 2));
        questionsList.add(new Question("grand-mère", R.drawable.grandmother, R.drawable.father, 1));
        questionsList.add(new Question("père", R.drawable.father, R.drawable.sister, 1));
        questionsList.add(new Question("sœur", R.drawable.sister, R.drawable.mother, 1));

        displayQuestion();
    }

    public void displayQuestion() {
        Question currentQ = questionsList.get(currentIndexQ);
        questionTextView.setText(currentQ.getQuestionBody());
        optionButton1.setImageResource(currentQ.getResOption1());
        optionButton2.setImageResource(currentQ.getResOption2());
    }

    // hide the questions
    public void hideQuestions() {
        questionTextView.setVisibility(View.GONE);
        optionButton1.setVisibility(View.GONE);
        optionButton2.setVisibility(View.GONE);
    }

    // show the questions
    public void showQuestions() {
        questionTextView.setVisibility(View.VISIBLE);
        optionButton1.setVisibility(View.VISIBLE);
        optionButton2.setVisibility(View.VISIBLE);
    }

    public void startQuiz(View view) {
        // display gone to the strt button
        findViewById(R.id.startButton).setVisibility(View.GONE);
        // show the questions
        displayQuestion();
        showQuestions();
    }

    // calculate the score
    private void calculateScore() {
        int score = 0;

        SharedPreferences preferences = getSharedPreferences("user_answers", MODE_PRIVATE);

        for (Question question : questionsList) {
            String questionKey = question.getQuestionBody();
            int userAnswer = preferences.getInt(questionKey, -1); // -1 is a default value if the key is not found

            if (userAnswer == question.getCorrectAns()) {
                score++;
            }
        }
        hideQuestions();
        TextView finalScoreTextView = findViewById(R.id.finalScore);
        finalScoreTextView.setText("Your Score: " + score * 10);
        finalScoreTextView.setVisibility(View.VISIBLE);
    }

    // the action taken when clicking an option answer
    public void onClickOption(View view) {
        String selectedOption = view.getTag().toString();// need to be changed into integer
        // save the users answer in shared
        SharedPreferences preferences = getSharedPreferences("user_answers", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(questionsList.get(currentIndexQ).getQuestionBody(), Integer.parseInt(selectedOption));// the parsing function is to change the string to integer
        editor.apply();// to ensure the changes have been made
        if (currentIndexQ < questionsList.size() - 1) {
            currentIndexQ++;
            displayQuestion();
        } else {
            calculateScore();
        }
    }
}
