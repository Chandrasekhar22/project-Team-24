package com.example.time_p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class RockPaperScissor extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView userSelectionTextView,compSelectionTextView,wonLostTieTextView,scoreTextView;

    int userScore = 0,compScore = 0;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissor);

        userSelectionTextView = findViewById(R.id.userSelectionTextView);
        compSelectionTextView = findViewById(R.id.compSelectionTextView);
        wonLostTieTextView = findViewById(R.id.wonLostTieTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        userSelectionTextView.setText("");
        compSelectionTextView.setText("");
        wonLostTieTextView.setText("");

        random = new Random();
    }
    public void resetButton(View view) {

        wonLostTieTextView.setText("");
        userSelectionTextView.setText("");
        compSelectionTextView.setText("");
        userScore = 0;
        compScore = 0;
        setScoreTextView(userScore ,compScore);
    }

    public void rpsButtonSelected(View view) {

        int  userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG,"rpsButtonSelected: " + userSelection);
        matchGame(userSelection);
    }

    private  void matchGame(int userSelection){

        int low = 1, high = 3;

        int compSelection = random.nextInt(high) + low;

        if ( userSelection == compSelection){
            //tie
            wonLostTieTextView.setText("Tie");

        }else if((userSelection - compSelection) % 3 == 1){
            //user win
            userScore++;
            wonLostTieTextView.setText("yay, you won");
        }else{
            //comp win
            compScore++;
            wonLostTieTextView.setText("oops, you lost!");
        }

        switch (userSelection){
            case 1:
                userSelectionTextView.setText("Rock");
                break;
            case 2:
                userSelectionTextView.setText("paper");
                break;
            case 3:
                userSelectionTextView.setText("scissors");
                break;
        }

        switch (compSelection){
            case 1:
                compSelectionTextView.setText("Rock");
                break;
            case 2:
                compSelectionTextView.setText("paper");
                break;
            case 3:
                compSelectionTextView.setText("scissors");
                break;
        }
        setScoreTextView(userScore, compScore);

    }

    private void setScoreTextView(int userScore,int compScore){

        scoreTextView.setText(String.valueOf(userScore) + ":"+String.valueOf(compScore));
    }
}