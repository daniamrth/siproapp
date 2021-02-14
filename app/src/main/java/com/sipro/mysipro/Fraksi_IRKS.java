package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fraksi_IRKS extends Activity {

    Button btBackirks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraksi__i_r_k_s);

        btBackirks = findViewById(R.id.backirks);

        btBackirks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifirks = new Intent(Fraksi_IRKS.this, Data.class);
                startActivity(ifirks);

            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Fraksi_IRKS.this, Data.class);
        startActivity(intent0);
    }
}