package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import PojoModels.Library;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LibraryActivity extends AppCompatActivity  {

    ImageView logo1,logo2,logo3,logo4;
    TextView name1,name2,name3,name4,address1,address2,address3,address4;
    List<Library> items = new ArrayList<Library>();
    LibraryAdapter myAdapter;
    RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, LibraryAdapter.class);
        context.startActivity(intent);
    }

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        myAdapter = new LibraryAdapter(items);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        // click on listner on arrow
        // for move previous activity

        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibraryActivity.super.onBackPressed();
            }
        });


        GetLibrary();
    }

    private void GetLibrary() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String save = preferences.getString("token","");
        Call<Library> call=RestApi.getClients(save).getLibrary();
        call.enqueue(new Callback<Library>() {
            @Override
            public void onResponse(Call<Library> call, Response<Library> response) {
                if(response.errorBody() == null){
                    if(response.body() != null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                renderUI(response.body());
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<Library> call, Throwable t) {

            }
        });
    }

    private void renderUI(Library body) {

        //
    }


//    @Override
//    public void onItemClick(int position) {
//
//    }
//
//    @Override
//    public boolean onItemLongClick(int position) {
//        return false;
    }
