package com.example.bfa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

import PojoModels.Browse;
import PojoModels.CategoryChip;
import PojoModels.GenreChip;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrowseContentActivity extends AppCompatActivity
        implements BrowseAdapter.MyViewHolder.itemClickListener,
        BrowseAdapter.MyViewHolder.itemLongClickListener{


    // for Category chips show
    private ChipGroup chip_group;
    private ProgressDialog progressDialog;
    String chipData;

    // for Genre Chip show
    private ChipGroup chip_Genre;
    String GenreData;

    // for List show
    List<Response> items = new ArrayList<Response>();
    BrowseAdapter myAdapter;
    RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, BrowseContentActivity.class);
        context.startActivity(intent);
    }




    // for Location Access
    public static final int REQUEST_CODE_PERMISSIONS = 101;
    Button ok;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_content);

        // for Genre Chip
        chip_Genre = findViewById(R.id.chip_Genre);

        GetGenre();

        // for Category Chip
        progressDialog = new ProgressDialog(this);
        chip_group = findViewById(R.id.chip_group);

        GetChip();


        // fo

        // for list Show
        myAdapter = new BrowseAdapter(items, this,this);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        GetBooks();

//        ok = findViewById(R.id.ok);

        requestLocationPermission();

//        ok.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                requestLocationPermission();
//            }
//        });

    }

    private void GetGenre() {
        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Call<GenreChip> call = RestApi.getClients(token).getGenreChip();
        call.enqueue(new Callback<GenreChip>() {
            @Override
            public void onResponse(Call<GenreChip> call, Response<GenreChip> response) {
                if(response.errorBody() == null){
                    if(response.body() != null){
                        GenreChip browseChip = response.body();
                        for (int i = 0; i<browseChip.getData().size(); i++)
                        {
                            Chip chip = new Chip(BrowseContentActivity.this);
                            GenreData = browseChip.getData().get(i).getName();
                            chip.setText(GenreData);
                            chip.setCheckable(true);
                            chip.setClickable(true);
                            chip_Genre.addView(chip);
                        }
                        chip_Genre.setVisibility(View.VISIBLE);

                    }
                }
            }



            @Override
            public void onFailure(Call<GenreChip> call, Throwable t) {
                Toast.makeText(BrowseContentActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void GetChip() {
        progressDialog. setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Call<CategoryChip> call = RestApi.getClients(token).getBrowseChip();
        call.enqueue(new Callback<CategoryChip>() {
            @Override
            public void onResponse(Call<CategoryChip> call, Response<CategoryChip> response) {
                progressDialog.dismiss();
                if (response.errorBody() == null) {
                    if (response.body() != null) {
                        CategoryChip browseChip = response.body();
                        for (int i = 0; i<browseChip.getData().size(); i++)
                        {
                            Chip chip = new Chip(BrowseContentActivity.this);
                            chipData = browseChip.getData().get(i).getName();
                            chip.setText(chipData);
                            chip.setCheckable(true);
                            chip.setClickable(true);
                            chip_group.addView(chip);
                        }
                        chip_group.setVisibility(View.VISIBLE);

                    }
                }
            }


            @Override
            public void onFailure(Call<CategoryChip> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(BrowseContentActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void GetBooks() {

        SharedPreferences preferences = getSharedPreferences("bfa", MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Call<Browse> call = RestApi.getClients(token).getBrowseList();
        call.enqueue(new Callback<Browse>() {
            @Override
            public void onResponse(Call<Browse> call, Response<Browse> response) {
                if(response.errorBody() == null){
                    if(response.body() != null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myAdapter.setItems(response.body().getData());
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<Browse> call, Throwable t) {

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


    // for Location Permission

    private void requestLocationPermission() {

        boolean foreground = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        if (foreground) {
            boolean background = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED;

            if (background) {
                handleLocationUpdates();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION}, REQUEST_CODE_PERMISSIONS);
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_BACKGROUND_LOCATION}, REQUEST_CODE_PERMISSIONS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {

            boolean foreground = false, background = false;

            for (int i = 0; i < permissions.length; i++) {
                if (permissions[i].equalsIgnoreCase(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    //foreground permission allowed
                    if (grantResults[i] >= 0) {
                        foreground = true;
                        Toast.makeText(getApplicationContext(), "Foreground location permission allowed", Toast.LENGTH_SHORT).show();
                        continue;
                    } else {
                        Toast.makeText(getApplicationContext(), "Location Permission denied", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                if (permissions[i].equalsIgnoreCase(Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {
                    if (grantResults[i] >= 0) {
                        foreground = true;
                        background = true;
                        Toast.makeText(getApplicationContext(), "Background location location permission allowed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Background location location permission denied", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            if (foreground) {
                if (background) {
                    handleLocationUpdates();
                } else {
                    handleForegroundLocationUpdates();
                }
            }
        }
    }

    private void handleLocationUpdates() {
        //foreground and background
        Toast.makeText(getApplicationContext(),"Start Foreground and Background Location Updates",Toast.LENGTH_SHORT).show();
    }

    private void handleForegroundLocationUpdates() {
        //handleForeground Location Updates
        Toast.makeText(getApplicationContext(),"Start foreground location updates",Toast.LENGTH_SHORT).show();
    }

    }




//
//    Button ok;
//    TextView textView1,textView2,textView3,textView4,textView5;
//    FusedLocationProviderClient fusedLocationProviderClient;

//    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_browse_content);
//
//        ActivityResultLauncher<String[]> locationPermissionRequest =
//                registerForActivityResult(new ActivityResultContracts
//                                .RequestMultiplePermissions(), result -> {
//                            Boolean fineLocationGranted = result.getOrDefault(
//                                    Manifest.permission.ACCESS_FINE_LOCATION, false);
//                            Boolean coarseLocationGranted = result.getOrDefault(
//                                    Manifest.permission.ACCESS_COARSE_LOCATION,false);
//                            if (fineLocationGranted != null && fineLocationGranted) {
//                                // Precise location access granted.
//                            } else if (coarseLocationGranted != null && coarseLocationGranted) {
//                                // Only approximate location access granted.
//                            } else {
//                                // No location access granted.
//                            }
//                        }
//                );
//
//// ...
//
//// Before you perform the actual permission request, check whether your app
//// already has the permissions, and whether your app needs to show a permission
//// rationale dialog. For more details, see Request permissions.
//        locationPermissionRequest.launch(new String[] {
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//        });
//