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

import java.util.ArrayList;
import java.util.List;

import PojoModels.Writer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookshopsActivity extends AppCompatActivity implements BookshopAdapter.MyViewHolder.itemClickListener,
        BookshopAdapter.MyViewHolder.itemLongClickListener {
    ImageView back_pressed;
    ImageView image1, image2, image3, image4;
    TextView name1, name2, name3, name4, no1, no2, no3, no4;

    List<DatumCardList> items = new ArrayList<DatumCardList>();
    BookshopAdapter myAdapter;
    RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, BookshopsActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookshops);

        myAdapter = new BookshopAdapter(items, this,this);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);


        GetBooks();

        // click on listner on arrow
        // for move previous activity
        back_pressed = findViewById(R.id.back_pressed);
        back_pressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookshopsActivity.super.onBackPressed();
            }
        });
    }

    private void GetBooks() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Call<Writer> call = RestApi.getClients(token).getWriter();
        call.enqueue(new Callback<Writer>() {
            @Override
            public void onResponse(Call<Writer> call, Response<Writer> response) {
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
            public void onFailure(Call<Writer> call, Throwable t) {

            }
        });

    }
    @Override
    public void onItemClick(int position) {
        //Open Hospital detail

        Intent intent = new Intent(BookshopsActivity.this,LibListActivity.class);
        if(myAdapter != null && myAdapter.getItems() != null && myAdapter.getItems().size() > position){

            String url = "content/bookshops/"+ myAdapter.getItems().get(position).getId();
            intent.putExtra("Url",url);
            startActivity(intent);
        }
    }


    @Override
    public boolean onItemLongClick(int position) {
        //Extra functionality for hospital
        return true;
    }
}
