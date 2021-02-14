package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fraksi_Golkar extends Activity {

    Button btBackGolkar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraksi__golkar);

        btBackGolkar = findViewById(R.id.backgolkar);

        btBackGolkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifgolkar = new Intent(Fraksi_Golkar.this, Data.class);
                startActivity(ifgolkar);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Fraksi_Golkar.this, Data.class);
        startActivity(intent0);
    }
}