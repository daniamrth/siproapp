package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class P_ifdali extends Activity {

    Button btBackPa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_ifdali);

        btBackPa = (Button) findViewById(R.id.backpa);
        btBackPa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent bifdali = new Intent(P_ifdali.this, Data.class);
                startActivity(bifdali);
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(P_ifdali.this, Data.class);
        startActivity(intent0);
    }

}