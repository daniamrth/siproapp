package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fraksi_Nasdem extends Activity {

    Button btBacknasdem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraksi__nasdem);


        btBacknasdem = findViewById(R.id.backnasdem);

        btBacknasdem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifnasdem = new Intent(Fraksi_Nasdem.this, Data.class);
                startActivity(ifnasdem);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Fraksi_Nasdem.this, Data.class);
        startActivity(intent0);
    }
}