package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import PojoModels.BooksResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksDetailsActivity extends AppCompatActivity
        implements BookDetailAdapter.MyViewHolder.itemClickListener,
        BookDetailAdapter.MyViewHolder.itemLongClickListener{

   // TextInputEditText Title,Category,Author,Total,Published,Description;

    String Url;

    List<Data> items = new ArrayList<Data>();
    BookDetailAdapter myAdapter;
    RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, BooksDetailsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_details);

//        Title = (TextInputEditText) findViewById(R.id.Title);
//        Category = (TextInputEditText) findViewById(R.id.Category);
//        Author = (TextInputEditText) findViewById(R.id.Author);
//        Total = (TextInputEditText) findViewById(R.id.Total);
//        Published = (TextInputEditText) findViewById(R.id.Published);
//        Description = (TextInputEditText) findViewById(R.id.Description);
//


//        Intent intent = getIntent();
//        Url = intent.getStringExtra("Url");

        myAdapter = new BookDetailAdapter(items, this,this);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        GetBookDetail();
    }

    private void GetBookDetail() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Call<BooksResponse> call = RestApi.getClients(token).getBooksDetail();
        call.enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
                if(response.errorBody() == null){
                    if(response.body() != null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {

            }
        });
    }
    @Override
    public void onItemClick(int position) {
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}


//    private void Get() {
//
//        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
//        String token = preferences.getString("token","");
//        Call<BooksResponse> call = RestApi.getClients(token).getBooksDetail();
//        call.enqueue(new Callback<BooksResponse>() {
//            @Override
//            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
//                if(response.errorBody() == null){
//                    if(response. body() != null){
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                renderUI(response.body());
//                            }
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BooksResponse> call, Throwable t) {
//                Toast.makeText(BooksDetailsActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//    private void renderUI(BooksResponse object) {
//        try {
//            Title.setText(object.getData().getTitle());
//            Category.setText(object.getData().getBookCategoryId());
//            Author.setText(object.getData().getAuthor());
//            Total.setText(object.getData().getTotalCopies());
//            Published.setText(object.getData().getPublishedAt());
//            Description.setText(object.getData().getSummary());
//        }catch (Exception e){
//            Title.setText("Error");
//            Category.setText("Error");
//            Author.setText("Error");
//            Total.setText("Error");
//            Published.setText("Error");
//            Description.setText("Error");
//        }
//    }
//}
