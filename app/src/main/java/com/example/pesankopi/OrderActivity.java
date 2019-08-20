package com.example.pesankopi;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private int jumlah = 0;
    private int harga = 0;
    private String kopi;

    private TextInputEditText nama;
    private RadioGroup rgJenisKopi;
    private RadioButton americano, cappucino, mochaccino;
    private CheckBox krim, coklat;
    private TextView txtHarga, txtJumlah;
    private Button pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // ngubungin variabel widget di java dan XML (melalui id)
        nama = findViewById(R.id.txt_nama);
        americano = findViewById(R.id.rb_americano);
        cappucino = findViewById(R.id.rb_cappucino);
        mochaccino = findViewById(R.id.rb_mochaccino);
        krim = findViewById(R.id.cb_krim);
        coklat = findViewById(R.id.cb_coklat);
        txtHarga = findViewById(R.id.txt_harga);
        txtJumlah = findViewById(R.id.txt_jumlahkopi);
        pesan = findViewById(R.id.btn_pesan);
        rgJenisKopi = findViewById(R.id.rg_jeniskopi);

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ambil jenis kopi yg dipilih user dari radio group
                int id = rgJenisKopi.getCheckedRadioButtonId();

                switch (id) {
                    // Kalo americano yg dipilih
                    case R.id.rb_americano:
                        kopi = americano.getText().toString();
                        harga = 2000;
                        break;
                    // Kalo cappucino yg dipilih
                    case R.id.rb_cappucino:
                        kopi = cappucino.getText().toString();
                        harga = 5000;
                        break;
                    // Kalo mochaccino yg dipilih
                    case R.id.rb_mochaccino:
                        kopi = mochaccino.getText().toString();
                        harga = 10000;
                        break;
                }

               /* cek apakah checkbox krim diceklis atau engga.
                Kalo iya, harganya nambah*/
                if (krim.isChecked()) {
                    harga = harga + 1000;
                }

                /* cek apakah checkbox coklat diceklis atau engga.
                Kalo iya, harganya nambah*/
                if (coklat.isChecked()) {
                    harga = harga + 1500;
                }

                // ngitung harga berdasarkan jumlah kopi yg dipesen
                harga = harga * jumlah;

                // nampilin harga
                txtHarga.setText(String.valueOf(harga));

            }
        });
    }

    // buat nambahin jumlah kopi yang dipesen
    public void increment(View view) {
        jumlah = jumlah + 1;
        txtJumlah.setText(String.valueOf(jumlah));
    }

    // buat ngurangin jumlah kopi yang dipesen
    public void decrement(View view) {
        jumlah = jumlah - 1;
        txtJumlah.setText(String.valueOf(jumlah));
    }
}
