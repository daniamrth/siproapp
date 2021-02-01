package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Akd_Anggaran extends Activity {

   Button btBackAkdAnggaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akd__anggaran);

        btBackAkdAnggaran = findViewById(R.id.backBadAng);

        btBackAkdAnggaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAkd_Ang = new Intent(Akd_Anggaran.this, Data.class);
                startActivity(iAkd_Ang);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Akd_Anggaran.this, Data.class);
        startActivity(intent0);
    }
}