package com.example.bfa;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class UserProfile extends AppCompatActivity {

    private TextView move;
    private Button btn_update;
    private ProgressBar loading;
    private String firstName,setlastName;
    private TextView first_name, last_name;
    private static String URL_UPDATE = "https://bfinder-be.herokuapp.com/api/user/profile";
    private static String URL_UPDATE1 = "https://bfinder-be.herokuapp.com/api/user/profile";
    model.UserProfile dataClass = new model.UserProfile();

    private  final String TAG = "UserProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        //email = findViewById(R.id.email);

        Gson gson = new Gson();
         String jsonInString = "{\"email\":\"alxzmj1433@gmail.com\",\"firstName\":\"Aleeza\",\"lastName\":\"Naeem\",\"userName\":\"Aleeza Naeem\"}";
        model.UserProfile userProfile = gson.fromJson(jsonInString, model.UserProfile.class);



        // click on Listner
        move = findViewById(R.id.change);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, ChangePassword.class);
                startActivity(intent);
            }
        });
        loading = findViewById(R.id.loading);
        btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update();
            }
        });

        Get();

    }

    private void Update() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String save = preferences.getString("token", "");

        loading.setVisibility(View.VISIBLE);
        btn_update.setVisibility(View.GONE);

        final String first_name = this.first_name.getText().toString().trim();
        final String last_name = this.last_name.getText().toString().trim();
        //final String email = this.email.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPDATE1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(UserProfile.this, "Send", Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_update.setVisibility(View.VISIBLE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(UserProfile.this, error.toString(), Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                btn_update.setVisibility(View.VISIBLE);


            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("first_name", first_name);
                params.put("last_name", last_name);
                // params.put("email", email);

                return params;
            }

            SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
            String save = preferences.getString("token", "");


            // Headers
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
               // headerMap.put("Content-Type", "application/json");
                headerMap.put("Authorization", save);
                return headerMap;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    // Get Api Call
    private void Get() {

//        Gson gson = new Gson();
//        String data = "{\"email\":\"alxzmj1433@gmail.com\",\"firstName\":\"Aleeza\", \"lastName\": \"Naeem\"\"username\":\"null\",}";
//        DataClass dataClass = gson.fromJson(data, DataClass.class);

        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String save = preferences.getString("token", "");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_UPDATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UserProfile.this, "send", Toast.LENGTH_SHORT).show();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserProfile.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }) {
            // Headers
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                headerMap.put("Content-Type", "application/json");
                headerMap.put("Authorization", save);
                return headerMap;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}









