package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import PojoModels.PojoBookshop;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookshopsActivity extends AppCompatActivity {
    ImageView backBtn;
    ImageView image1,image2,image3,image4;
    TextView name1,name2,name3,name4,no1,no2,no3,no4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookshops);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        name4 = findViewById(R.id.name4);
        no1 = findViewById(R.id.no1);
        no2 = findViewById(R.id.no2);
        no3 = findViewById(R.id.no3);
        no4 = findViewById(R.id.no4);

        GetBooks();

         // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back6);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookshopsActivity.super.onBackPressed();
            }
        });
    }

    private void GetBooks() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token","");
        Call <PojoBookshop> call=RestApi.getClients(token).getBook();
        call.enqueue(new Callback<PojoBookshop>() {
            @Override
            public void onResponse(Call<PojoBookshop> call, Response<PojoBookshop> response) {

            }

            @Override
            public void onFailure(Call<PojoBookshop> call, Throwable t) {

            }
        });
    }
}