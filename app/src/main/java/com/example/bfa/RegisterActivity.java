package com.example.bfa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private ImageView curve,google,facebook,twitter;
    private TextView register,methods;
    private EditText email,password,confirmation_password,first_name,last_name;
    private Button btn_signup,btn_Location;
    private ProgressBar loading;
    private static String URL_SIGNUP = "https://bfinder-be.herokuapp.com/api/user/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // initialize
        loading = findViewById(R.id.loading);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmation_password= findViewById(R.id.confirmation_password);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        btn_signup = findViewById(R.id.btn_signup);

        // click on listner

        btn_Location = findViewById(R.id.btn_Location);
        btn_Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });




        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup();
            }
        });

    }

    // Post Api for Register
    private void Signup(){

        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String save = preferences.getString("token","");

        loading.setVisibility(View.VISIBLE);
        btn_signup.setVisibility(View.GONE);

        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
        final String confirmation_password = this.confirmation_password.getText().toString().trim();
        final String first_name = this.first_name.getText().toString().trim();
        final String last_name= this.last_name.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SIGNUP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegisterActivity.this,"Registered", Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_signup.setVisibility(View.VISIBLE);

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_signup.setVisibility(View.VISIBLE);

                    }
                })
        {


            // Params
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                params.put("confirmation_password",confirmation_password);
                params.put("first_name",first_name);
                params.put("last_name",last_name);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}