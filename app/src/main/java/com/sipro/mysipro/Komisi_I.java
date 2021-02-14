package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Komisi_I extends Activity {

    Button btBackk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komisi__i);

        btBackk1 = findViewById(R.id.backk1);

        btBackk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iK1 = new Intent(Komisi_I.this, Data.class);
                startActivity(iK1);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Komisi_I.this, Data.class);
        startActivity(intent0);
    }
}