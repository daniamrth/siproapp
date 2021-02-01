package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Akd_Musyawarah extends Activity {

    Button btBackBadMus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akd__musyawarah);

        btBackBadMus = findViewById(R.id.backBadanMus);

        btBackBadMus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAkd_Mus = new Intent(Akd_Musyawarah.this, Data.class);
                startActivity(iAkd_Mus);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Akd_Musyawarah.this, Data.class);
        startActivity(intent0);
    }
}