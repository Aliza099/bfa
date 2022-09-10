package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import PojoModels.PojoLibrary;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LibraryActivity extends AppCompatActivity {

    ImageView logo1,logo2,logo3,logo4;
    TextView name1,name2,name3,name4,address1,address2,address3,address4;

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // click on listner on arrow
        // for move previous activity

        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibraryActivity.super.onBackPressed();
            }
        });

        logo1 = findViewById(R.id.logo1);
        logo2 = findViewById(R.id.logo2);
        logo3 = findViewById(R.id.logo3);
        logo4 = findViewById(R.id.logo4);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        name4 = findViewById(R.id.name4);
        address1 = findViewById(R.id.address1);
        address2 = findViewById(R.id.address2);
        address3 = findViewById(R.id.address3);
        address4 = findViewById(R.id.address4);

        GetLibrary();
    }

    private void GetLibrary() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token","");
        Call<PojoLibrary> call=RestApi.getClients(token).getLibrary();
        call.enqueue(new Callback<PojoLibrary>() {
            @Override
            public void onResponse(Call<PojoLibrary> call, Response<PojoLibrary> response) {

            }

            @Override
            public void onFailure(Call<PojoLibrary> call, Throwable t) {

            }
        });
    }
}