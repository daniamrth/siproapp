package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fraksi_DIP extends Activity {

    Button btBackdip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraksi__d_i_p);


        btBackdip = findViewById(R.id.backdip);

        btBackdip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifdip = new Intent(Fraksi_DIP.this, Data.class);
                startActivity(ifdip);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Fraksi_DIP.this, Data.class);
        startActivity(intent0);
    }
}