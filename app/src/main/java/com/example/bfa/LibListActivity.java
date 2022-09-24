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

import java.util.ArrayList;
import java.util.List;

import PojoModels.LibList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LibListActivity extends AppCompatActivity
        implements LibListAdapter.MyViewHolder.itemClickListener,
        LibListAdapter.MyViewHolder.itemLongClickListener{

     ImageView back1;
    String Url;

    List<DatumBookList> items = new ArrayList<DatumBookList>();
    LibListAdapter myAdapter;
    RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, LibListActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_list);

        Intent intent = getIntent();
         Url = intent.getStringExtra("Url");

        // for back pressed

        back1 = findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibListActivity.super.onBackPressed();
            }
        });

        // for adapter
        myAdapter = new LibListAdapter(items, this,this);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        GetBooksList();
    }

    private void GetBooksList() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjY0MDMzMTA1LCJpYXQiOjE2NjM5NDY3MDUsImp0aSI6Ijk4NDk5MzJmY2FkNzRhYTJiMWNkYmZkYjc1MDVjNjE5IiwidXNlcl9pZCI6MzZ9.6VPNZ3WD_ZGg0fdWDoVA1tR7PwyG7k9OEOYBQUy5xMg";//preferences.getString("token", "");
        Call<LibList> call = RestApi.getClients(token).getLibBooks(Url);
        call.enqueue(new Callback<LibList>() {
            @Override
            public void onResponse(Call<LibList> call, Response<LibList> response) {
                if(response.errorBody() == null){
                    if(response.body() != null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myAdapter.setItems(response.body().getData());
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<LibList> call, Throwable t) {

            }
        });

    }
    @Override
    public void onItemClick(int position) {
        //Open Hospital detail
    }

    @Override
    public boolean onItemLongClick(int position) {
        //Extra functionality for hospital
        return true;
    }
}