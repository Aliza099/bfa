package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MakeSelection extends AppCompatActivity {

    private Button next;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);

        // click on Listner
        next = findViewById(R.id.btn_call);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeSelection.this,verifyOTP.class);
                startActivity(intent);
            }
        });

        // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back1);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MakeSelection.super.onBackPressed();
            }
        });
    }
}