package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.service.autofill.UserData;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    //variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image = findViewById(R.id.imageView6);
        logo = findViewById(R.id.tv_logo);
        slogan = findViewById(R.id.tv_slogan);
        // for defining animations
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        //for automatically move to Login Activity After Splash Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences preferences = getSharedPreferences("bfa",MODE_PRIVATE);
                String LoginInfo = preferences.getString("login", "");
                if(! LoginInfo.isEmpty()){
                    //user already logged in, go to Main Screen
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));

                }else {
                    //user hasn't logged in yet, to go Login Screen

                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                }
                }

//                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
        },SPLASH_SCREEN);
    }

}

