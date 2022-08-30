package com.example.bfa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadActivity extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        // click on listner on arrow
        // for move previous activity
        backBtn = findViewById(R.id.back1);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadActivity.super.onBackPressed();
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
