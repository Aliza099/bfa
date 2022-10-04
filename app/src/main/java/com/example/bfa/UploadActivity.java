package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import PojoModels.CategoryChip;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadActivity extends AppCompatActivity {
    ImageView backBtn;
    AutoCompleteTextView auto_C;
    TextInputLayout Category;
    String CategoryData;
//    String[] items = {"soft", "hard"};
//    String[] itemG = {"programming"};
//    public AutoCompleteTextView auto_C;
//    AutoCompleteTextView auto_G;
//
//    ArrayAdapter<String> adapterItems;
//    ArrayAdapter<String> adapterItemG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        auto_C = findViewById(R.id.auto_C);
        Category = findViewById(R.id.Category);

       // GetCategory();

        backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadActivity.super.onBackPressed();
            }
        });

//    auto_C = findViewById(R.id.auto_C);
//        adapterItems = new ArrayAdapter<String>(this,R.layout.list_items,items);
//        auto_C.setAdapter(adapterItems);
//
//        auto_G = findViewById(R.id.auto_G);
//        adapterItemG = new ArrayAdapter<String>(this,R.layout.list_items,itemG);
//        auto_G.setAdapter(adapterItemG);

//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, items);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_c.setAdapter(adapter);



//         click on listner on arrow
//         for move previous activity
//        backBtn = findViewById(R.id.back1);
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                UploadActivity.super.onBackPressed();
//            }
//        });
    }

    private void GetCategory() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Call<CategoryChip> call = RestApi.getClients(token).getBrowseChip();
        call.enqueue(new Callback<CategoryChip>() {
            @Override
            public void onResponse(Call<CategoryChip> call, Response<CategoryChip> response) {
                if(response.errorBody() == null) {
                    if (response.body() != null) {
                        CategoryChip browseChip = response.body();
                        for (int i = 0; i < browseChip.getData().size(); i++) {
                            AutoCompleteTextView autoCompleteTextView = new AutoCompleteTextView(UploadActivity.this);
                            CategoryData = browseChip.getData().get(i).getName();
                            auto_C.setText(CategoryData);

                            //    Category.addView(autoCompleteTextView);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CategoryChip> call, Throwable t) {

            }
        });
    }

    int requestcode = 1;

    public void onActivityResult(int requestcode, int resulCode, Intent data)
    {
        super.onActivityResult(requestcode,resulCode,data);
        Context context = getApplicationContext();
        if (requestcode == requestcode && resulCode == Activity.RESULT_OK)
        {
            if (data == null)
            {
                return;
            }
            Uri uri = data.getData();
            Toast.makeText(context,uri.getPath(),Toast.LENGTH_SHORT).show();

        }
    }

    public void openfilechooser(View view)
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent,requestcode);
    }

}
