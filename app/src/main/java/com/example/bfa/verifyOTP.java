package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class verifyOTP extends AppCompatActivity {
    private Button next;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        // click on listner
        next = findViewById(R.id.verify);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(verifyOTP.this,Setnewpassword.class);
                startActivity(intent);

            }
        });

        // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back2);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyOTP.super.onBackPressed();
            }
        });
    }
}