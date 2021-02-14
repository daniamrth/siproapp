package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fraksi_PPP extends Activity {

    Button btBackPPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraksi__p_p_p);

        btBackPPP = findViewById(R.id.backppp);

        btBackPPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifppp = new Intent(Fraksi_PPP.this, Data.class);
                startActivity(ifppp);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Fraksi_PPP.this, Data.class);
        startActivity(intent0);
    }
}