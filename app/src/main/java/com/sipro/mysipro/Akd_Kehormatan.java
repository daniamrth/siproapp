package com.sipro.mysipro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Akd_Kehormatan extends Activity {

    Button btBackBadKeh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akd__kehormatan);

        btBackBadKeh = findViewById(R.id.backBadKeh);

        btBackBadKeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAkd_Keh= new Intent(Akd_Kehormatan.this, Data.class);
                startActivity(iAkd_Keh);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Akd_Kehormatan.this, Data.class);
        startActivity(intent0);
    }

}