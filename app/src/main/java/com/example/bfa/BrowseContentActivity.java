package com.example.bfa;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class BrowseContentActivity extends AppCompatActivity {
//
//    Button ok;
//    TextView textView1,textView2,textView3,textView4,textView5;
//    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_content);

//        ok = findViewById(R.id.ok);
//        textView1= findViewById(R.id.text_view1);
//        textView2 = findViewById(R.id.text_view2);
//        textView3 = findViewById(R.id.text_view3);
//        textView4 = findViewById(R.id.text_view4);
//        textView5 = findViewById(R.id.text_view5);
//
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(
//                BrowseContentActivity.this
//        );
//
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // check condition
//                if (ActivityCompat.checkSelfPermission(BrowseContentActivity.this
//                ,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(BrowseContentActivity.this
//                ,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                    // when both permission are granted
//                    getCurrentLocation();
//                }
//            }
//        });
//
//
//    }
//
//    @SuppressLint("MissingPermission")
//    private void getCurrentLocation() {
//        LocationManager locationManager = (LocationManager) getSystemService(
//                Context.LOCATION_SERVICE
//        );
//
//        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//        || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
//
//            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
//                @Override
//                public void onComplete(@NonNull Task<Location> task) {
//                    Location location = task.getResult();
//
//                    if (location != null){
//                        textView1.setText(String.valueOf(location.getLatitude()));
//                        textView2.setText(String.valueOf(location.getLongitude()));
//                    }else {
//                    }
//                }
//            });
//        }
    }
}