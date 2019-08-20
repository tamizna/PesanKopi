package com.example.pesankopi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    // deklarasiin komponen
    private TextView btnMenu, btnOrder, btnTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // hubungin variabel java dengan komponen di XML
        btnMenu = findViewById(R.id.home_menu);
        btnOrder = findViewById(R.id.home_order);
        btnTentang = findViewById(R.id.home_tentang);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(pindah);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HomeActivity.this, OrderActivity.class);
                startActivity(pindah);
            }
        });

        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder tentangDialog = new AlertDialog.Builder(HomeActivity.this);

                tentangDialog.setTitle("Tentang Aplikasi");

                tentangDialog.setMessage("Aplikasi ini dibuat dengan sepenuh hati oleh Lab TI");

                // Nambahin button OK
                tentangDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // kalo button OK diklik, maka dialog akan diclose
                        dialogInterface.cancel();
                    }
                });

                // nampilin alert dialognya
                tentangDialog.show();
            }
        });
    }
}
