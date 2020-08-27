package com.example.time_p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class spinbottle extends AppCompatActivity {

    public static final Random  RANDOM=new Random();
    private View main;
    private ImageView bottle;
    private int lastangle=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinbottle);
        main = findViewById(R.id.main);
        bottle = findViewById(R.id.bottle);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinBottle();
            }
        });
        Toast.makeText(this,"touch the bottle to spin",Toast.LENGTH_SHORT).show();

    }
    private void spinBottle() {
        int angle = RANDOM.nextInt(3600-360)+360;
        float pivotx= bottle.getWidth()/2;
        float pivoty= bottle.getHeight()/2;

        final Animation rotateAnimation = new RotateAnimation(lastangle ==-1 ? 0:lastangle,angle,pivotx,pivoty);
        lastangle=angle;
        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);

        bottle.startAnimation(rotateAnimation);
    }
}