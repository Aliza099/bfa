package com.example.bfa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //move activity
    private Button next;
    private Button next2;
    private Button lib;
    private Button next4;
    private Button next5;
    private Button next6;

    //drawer
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         // for move all cardview to next activities
        next = findViewById(R.id.btn_browse);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this,BrowseContentActivity.class);
                startActivity(intent);
            }
        });

        next2 = findViewById(R.id.btn_upload);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,UploadActivity.class);
                startActivity(intent);
            }
        });



                lib = findViewById(R.id.btn_library);
                lib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HomeActivity.this,LibraryActivity.class);
                        startActivity(intent);
                    }
                });

         next4 = findViewById(R.id.btn_books);
         next4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(HomeActivity.this,BookshopsActivity.class);
                 startActivity(intent);
             }
         });
         next5 = findViewById(R.id.btn_writer);
         next5.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(HomeActivity.this,WriterActivity.class);
                 startActivity(intent);
             }
         });
         next6 = findViewById(R.id.btn_fav);
         next6.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(HomeActivity.this,FavouritecontentActivity.class);
                 startActivity(intent);
             }
         });



       // for drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // for open & close menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    // for move drawer to next activities

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent =new Intent(HomeActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                Intent intent1 = new Intent(HomeActivity.this,UserProfile.class);
                startActivity(intent1);
                break;
            case R.id.nav_favourite:
                Intent intent2 = new Intent(HomeActivity.this,FavouritecontentActivity.class);
                startActivity(intent2);
                break;

        }
        return true;

        }
}