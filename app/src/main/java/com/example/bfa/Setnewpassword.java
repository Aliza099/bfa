package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class Setnewpassword extends AppCompatActivity {
    private Button btn_ok;
    private TextInputEditText password, confirmation_password;
    private static String URL_SET_PASSWORD = "https://bfinder-be.herokuapp.com/api/user/reset-password/Mw/bagzq7-b7bfeb2d91cf7cd9b2d4e1e8eeaa6843";
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setnewpassword);

        // FOR API CALL
        password =(TextInputEditText) findViewById(R.id.password);
        confirmation_password =(TextInputEditText) findViewById(R.id.confirmation_password);
        btn_ok = findViewById(R.id.btn_oK);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetPassword();
            }
        });


        // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back3);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Setnewpassword.super.onBackPressed();
            }
        });

    }

    private void SetPassword() {
        
        final String password = this.password.getText().toString().trim();
        final String confirmation_password = this.confirmation_password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SET_PASSWORD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Setnewpassword.this, "success", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Setnewpassword.this, "error", Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("password", password);
                params.put("confirmation_password", confirmation_password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        }

    }


