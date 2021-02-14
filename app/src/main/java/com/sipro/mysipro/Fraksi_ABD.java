package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fraksi_ABD extends Activity {

    Button btBackabd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraksi__a_b_d);

        btBackabd = findViewById(R.id.backabd);

        btBackabd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifabd = new Intent(Fraksi_ABD.this, Data.class);
                startActivity(ifabd);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Fraksi_ABD.this, Data.class);
        startActivity(intent0);
    }
}