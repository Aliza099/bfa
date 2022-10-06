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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PojoModels.CategoryChip;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadActivity extends AppCompatActivity {
    ImageView backBtn;
    TextInputEditText title,summary,book_category_id;
    private Button btn_upload;
    AutoCompleteTextView auto_C,auto_G;
    String CategoryData;
    private static String URL_UPLOAD = "https://bfinder-be.herokuapp.com/api/content/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        title = findViewById(R.id.title);
        summary = findViewById(R.id.summary);
        auto_C = findViewById(R.id.auto_C);
        auto_G = findViewById(R.id.auto_G);
        book_category_id = findViewById(R.id.book_category_id);
        btn_upload = findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Upload();
            }
        });




       // GetCategory();

        backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadActivity.super.onBackPressed();
            }
        });

//
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

    private void Upload() {

        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");

        final String title = this.title.getText().toString().trim();
        final String summary = this.summary.getText().toString().trim();
        final String auto_C = this.auto_C.getText().toString().trim();
        final String auto_G = this.auto_G.getText().toString().trim();
        final String book_category_id = this.book_category_id.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPLOAD,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(UploadActivity.this, "send", Toast.LENGTH_SHORT).show();

                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(UploadActivity.this, "fail", Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> Params = new HashMap<>();
                Params.put("title",title);
                Params.put("summary",summary);
                Params.put("auto_C",auto_C);
                Params.put("auto_G",auto_G);
                Params.put("book_category_id",book_category_id);
                return Params;
        }
            SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
            String token = preferences.getString("token","");

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                // headerMap.put("Content-Type", "application/json");
                headerMap.put("Authorization",  token);
                return headerMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



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
            public void onFailure(Call<CategoryChip> call, Throwable t) {

            }
        });
    }

    private void renderUI(CategoryChip Object) {
        try {
            auto_C.setText(Object.getData().get(0).getId());
        }catch (Exception e){
            auto_C.setText("ERROR");
        }
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
