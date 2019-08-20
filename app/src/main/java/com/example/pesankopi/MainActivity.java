package com.example.pesankopi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // 1000 = 1 detik
    private int waktu_loading=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*postDelayed berfungsi untuk nunda task yang ada
        di dalem method run buat dijalanin sampe waktu tertentu (waktu_loading) */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                /* setelah udah lewat batas waktunya, maka akan
                 langsung berpindah ke home activity*/
                Intent home=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(home);
                finish();
            }
        },waktu_loading);
    }
}
