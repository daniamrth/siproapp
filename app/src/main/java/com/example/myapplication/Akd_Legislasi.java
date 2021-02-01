package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Akd_Legislasi extends Activity {

    Button btBackBadLeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akd__legislasi);

        btBackBadLeg = findViewById(R.id.backBadLeg);

        btBackBadLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAkd_Leg = new Intent(Akd_Legislasi.this, Data.class);
                startActivity(iAkd_Leg);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Akd_Legislasi.this, Data.class);
        startActivity(intent0);
    }

}