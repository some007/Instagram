package com.example.instagramclone.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.instagramclone.R;
import com.example.instagramclone.fragments.HomeFragment;
import com.example.instagramclone.fragments.NotificationFragment;
import com.example.instagramclone.fragments.ProfileFragment;
import com.example.instagramclone.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment selectFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        selectFragment = new HomeFragment();
                        break;
                    case R.id.nav_search:
                        selectFragment = new SearchFragment();
                        break;

                    case R.id.nav_add:
                        selectFragment = null;
                        startActivity(new Intent(MainActivity.this,PostActivity.class));
                        break;

                    case R.id.nav_heart:
                        selectFragment = new NotificationFragment();
                        break;

                    case R.id.nav_profile:
                        selectFragment = new ProfileFragment();
                        break;

                }
                if(selectFragment != null)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectFragment).commit();
                }
                return true;

            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

    }
}