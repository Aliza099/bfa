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

import PojoModels.Library;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LibraryActivity extends AppCompatActivity implements LibraryAdapter.MyViewHolder.itemClickListener,
        LibraryAdapter.MyViewHolder.itemLongClickListener {



    List<DatumCardList> items = new ArrayList<DatumCardList>();
    LibraryAdapter myAdapter;
    RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, LibraryActivity.class);
        context.startActivity(intent);
    }

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        myAdapter = new LibraryAdapter(items, this, this);
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
        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjY0MDMzMTA1LCJpYXQiOjE2NjM5NDY3MDUsImp0aSI6Ijk4NDk5MzJmY2FkNzRhYTJiMWNkYmZkYjc1MDVjNjE5IiwidXNlcl9pZCI6MzZ9.6VPNZ3WD_ZGg0fdWDoVA1tR7PwyG7k9OEOYBQUy5xMg";//preferences.getString("token", "");
        Call<Library> call = RestApi.getClients(token).getLibrary();
        call.enqueue(new Callback<Library>() {
            @Override
            public void onResponse(Call<Library> call, Response<Library> response) {
                if (response.errorBody() == null) {
                    if (response.body() != null) {
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
            public void onFailure(Call<Library> call, Throwable t)
            {

            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(LibraryActivity.this,LibListActivity.class);
        if(myAdapter != null && myAdapter.getItems() != null && myAdapter.getItems().size() > position){

            String url = "content/libraries/"+ myAdapter.getItems().get(position).getId();
            intent.putExtra("Url",url);
            startActivity(intent);
        }
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}


//    @Override
//    public void onItemClick(int position) {
//
//    }
//
//    @Override
//    public boolean onItemLongClick(int position) {
//        return false;

