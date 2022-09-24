package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import PojoModels.Writer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WriterActivity extends AppCompatActivity
        implements WriterAdapter.MyViewHolder.itemClickListener,
        WriterAdapter.MyViewHolder.itemLongClickListener{

    List<DatumCardList> items = new ArrayList<DatumCardList>();
    WriterAdapter myAdapter;
    RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, WriterActivity.class);
        context.startActivity(intent);
    }

    private Button btn3;
    ImageView back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer);

        myAdapter = new WriterAdapter(items, this,this);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);


        // click on listner on arrow
        // for move previous activity
        back_pressed = findViewById(R.id.back_pressed);
        back_pressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriterActivity.super.onBackPressed();
            }
        });


//        btn3 = findViewById(R.id.btn3);
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(WriterActivity.this,Writer3Activity.class);
//                startActivity(intent);
//            }
//        });


        GetWriter();
    }

    private void GetWriter() {
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
        Intent intent = new Intent(WriterActivity.this,LibListActivity.class);
        if(myAdapter != null && myAdapter.getItems() != null && myAdapter.getItems().size() > position){

            String url = "content/writers/"+ myAdapter.getItems().get(position).getId();
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

