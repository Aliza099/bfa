package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SuccessMessage extends AppCompatActivity {
    private Button move;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_message);

        // click on listner
        move = findViewById(R.id.finish);
        move. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccessMessage.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back4);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuccessMessage.super.onBackPressed();
            }
        });

    }
}