package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

public class ChangePassword extends AppCompatActivity {
    private TextInputEditText old_password,new_password,confirmation_password;
    private Button btn_confirm;
    private ProgressBar loading;
    private static String URL_CHANGE = "https://bfinder-be.herokuapp.com/api/user/change-password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        old_password = (TextInputEditText)findViewById(R.id.old_password);
        new_password = (TextInputEditText)findViewById(R.id.new_password);
        confirmation_password = (TextInputEditText)findViewById(R.id.confirmation_password);

        loading= findViewById(R.id.loading);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change();
            }
        });
    }

    private void Change() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token","");

        loading.setVisibility(View.VISIBLE);
        btn_confirm.setVisibility(View.GONE);


        final String old_password = this.old_password.getText().toString().trim();
        final String new_password = this.new_password.getText().toString().trim();
        final String confirmation_password = this.confirmation_password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CHANGE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ChangePassword.this,"Registered", Toast.LENGTH_SHORT).show();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ChangePassword.this, error.toString(), Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                btn_confirm.setVisibility(View.VISIBLE);

            }
        })
        {

            @Override
            protected Map<String, String> getParams() {
                Map<String,String> Params = new HashMap<>();
                Params.put("old_password",old_password);
                Params.put("new_password",new_password);
                Params.put("confirmation_password",confirmation_password);
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

}
