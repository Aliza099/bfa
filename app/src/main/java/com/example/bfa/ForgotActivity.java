package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class ForgotActivity extends AppCompatActivity {

    ImageView backBtn;
    private TextInputEditText email;
    private Button btn_next_otp;
    private ProgressBar loading;
    private static String URL_SELECT = "https://bfinder-be.herokuapp.com/api/user/send-reset-password-email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // listner for move next Make selection Activity
        setContentView(R.layout.activity_forgot);
        btn_next_otp = findViewById(R.id.btn_next_otp);
        email = (TextInputEditText) findViewById(R.id.email);
        loading = findViewById(R.id.loading);

        btn_next_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Select();
            }
        });


        // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotActivity.super.onBackPressed();
            }
        });
    }

    private void Select() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");

        loading.setVisibility(View.VISIBLE);
        btn_next_otp.setVisibility(View.GONE);

        final String email = this.email.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SELECT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.setVisibility(View.GONE);
                        btn_next_otp.setVisibility(View.VISIBLE);
                        Toast.makeText(ForgotActivity.this, "PASS", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(ForgotActivity.this,verifyOTP.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ForgotActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                btn_next_otp.setVisibility(View.VISIBLE);


            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}