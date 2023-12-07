package com.example.my.bottle_flip;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    RelativeLayout back;
    Random random;
    int lastPosition;
    int rounds;
    boolean flagBottleSpinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        random = new Random();
        bottle = findViewById(R.id.img_bottle);
        back = findViewById(R.id.back_main);
        rounds = 5;
    }

    public void spinBottle(View view) {
        if (!flagBottleSpinning) {

            int move = random.nextInt(360);
            float x = bottle.getWidth() / 2;
            float y = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastPosition, move + rounds * 360, x, y);
            rotate.setDuration(6500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    flagBottleSpinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    flagBottleSpinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            bottle.startAnimation(rotate);
            lastPosition = move;
        }
    }

    public void clickBack_01(View view) {
        back.setBackgroundResource(R.drawable.back_1);
    }

    public void clickBack_02(View view) {
        back.setBackgroundResource(R.drawable.back_2);
    }

    public void clickBack_03(View view) {
        back.setBackgroundResource(R.drawable.back_3);
    }

    public void bottle_1(View view) {
        bottle.setImageResource(R.drawable.bottle_2);
    }

    public void bottle_2(View view) {
        bottle.setImageResource(R.drawable.bottle_3);
    }

    public void bottle_3(View view) {
        bottle.setImageResource(R.drawable.botttle_4);
    }

}