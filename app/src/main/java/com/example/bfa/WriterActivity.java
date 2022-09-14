package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WriterActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4;
    TextView name,name1,name2,name3;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer);

        // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back6);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriterActivity.super.onBackPressed();
            }
        });

        //click on listner
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WriterActivity.this,Writer1Activity.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WriterActivity.this,Writer2Activity.class);
                startActivity(intent);
            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WriterActivity.this,Writer3Activity.class);
                startActivity(intent);
            }
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WriterActivity.this,Writer4Activity.class);
                startActivity(intent);
            }
        });

        name = findViewById(R.id.name);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);

        GetWriter();
    }

    private void GetWriter() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String save = preferences.getString("token","");
        Call<PojoWriters> call=RestApi.getClients(save).getWriter();
        call.enqueue(new Callback<PojoWriters>() {
            @Override
            public void onResponse(Call<PojoWriters> call, Response<PojoWriters> response) {

            }

            @Override
            public void onFailure(Call<PojoWriters> call, Throwable t) {

            }
        });

    }
}