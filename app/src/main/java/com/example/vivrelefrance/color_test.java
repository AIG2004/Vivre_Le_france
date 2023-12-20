package com.example.vivrelefrance;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class color_test extends AppCompatActivity {
    private List<Question> questionsList = new ArrayList<>();
    private TextView questionTextView;
    private ImageButton optionButton1;
    private ImageButton optionButton2;
    private int currentIndexQ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_test);

        // Move the view initialization here
        questionTextView = findViewById(R.id.question);
        optionButton1 = findViewById(R.id.option1);
        optionButton2 = findViewById(R.id.option2);

        // Inserting questions in the list
        questionsList.add(new Question("couleur rouge", R.drawable.black, R.drawable.red, 2));
        questionsList.add(new Question("couleur noire", R.drawable.black, R.drawable.green, 1));
        questionsList.add(new Question("couleur blanche", R.drawable.green, R.drawable.white, 2));
        questionsList.add(new Question("couleur bleue", R.drawable.blue, R.drawable.red, 1));
        questionsList.add(new Question("couleur verte", R.drawable.green, R.drawable.white, 1));

        // Display question
        displayQuestion();

    }

    public void displayQuestion() {
        Question currentQ = questionsList.get(currentIndexQ);
        questionTextView.setText(currentQ.getQuestionBody());
        optionButton1.setImageResource(currentQ.getResOption1());
        optionButton2.setImageResource(currentQ.getResOption2());
    }

    public void hideQuestions() {
        questionTextView.setVisibility(View.GONE);
        optionButton1.setVisibility(View.GONE);
        optionButton2.setVisibility(View.GONE);
    }

    public void showQuestions() {
        questionTextView.setVisibility(View.VISIBLE);
        optionButton1.setVisibility(View.VISIBLE);
        optionButton2.setVisibility(View.VISIBLE);
    }

    public void startQuiz(View view) {
        findViewById(R.id.startButton).setVisibility(View.GONE);
        displayQuestion();
        showQuestions();
    }

    private void calculateScore() {
        int score = 0;

        SharedPreferences preferences = getSharedPreferences("user_answers", MODE_PRIVATE);

        for (Question question : questionsList) {
            String questionKey = question.getQuestionBody();
            int userAnswer = preferences.getInt(questionKey, -1);

            if (userAnswer == question.getCorrectAns()) {
                score++;
            }
        }

        hideQuestions();
        TextView finalScoreTextView = findViewById(R.id.finalScore);
        finalScoreTextView.setText("Your Score: " + score);
        finalScoreTextView.setVisibility(View.VISIBLE);
    }

    public void onClickOption(View view) {
        String selectedOption = view.getTag().toString();
        SharedPreferences preferences = getSharedPreferences("user_answers", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(questionsList.get(currentIndexQ).getQuestionBody(), Integer.parseInt(selectedOption));
        editor.apply();
        if (currentIndexQ < questionsList.size() - 1) {
            currentIndexQ++;
            displayQuestion();
        } else {
            calculateScore();
        }
    }
}
