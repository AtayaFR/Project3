package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton btnSetting, btnUndertone;  // Tombol Undetone

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        btnSetting = findViewById(R.id.btn_setting);
        btnUndertone = findViewById(R.id.btn_undertone);  // Inisialisasi tombol Undetone

        // Tombol untuk membuka drawer
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.openDrawer(navigationView);
                } else {
                    drawerLayout.closeDrawer(navigationView);
                }
            }
        });

        // Menangani klik item menu di drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_general) {
                    Toast.makeText(MainActivity.this, "General clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_about) {
                    Toast.makeText(MainActivity.this, "About Us clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_follow) {
                    Toast.makeText(MainActivity.this, "Follow Us clicked", Toast.LENGTH_SHORT).show();
                }

                // Tutup drawer setelah memilih item
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });

        // Set up OnClickListener untuk btnUndertone agar berpindah ke MainActivity2
        btnUndertone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent); // Memulai aktivitas MainActivity2
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
        } else {
            super.onBackPressed();
        }
    }
}