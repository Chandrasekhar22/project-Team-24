package com.example.time_p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rps(View view) {
        Intent i = new Intent(MainActivity.this,RockPaperScissor.class);
        startActivity(i);
    }

    public void tictactoe(View view) {
        Intent i = new Intent(MainActivity.this,TicTacToe.class);
        startActivity(i);
    }

    public void spinbottle(View view) {
        Intent i = new Intent(MainActivity.this,spinbottle.class);
        startActivity(i);
    }
}