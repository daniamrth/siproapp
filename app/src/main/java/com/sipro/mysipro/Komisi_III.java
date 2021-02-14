package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Komisi_III extends Activity {

    Button btBackk3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komisi__i_i_i);

        btBackk3 = findViewById(R.id.backk3);

        btBackk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iK3 = new Intent(Komisi_III.this, Data.class);
                startActivity(iK3);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Komisi_III.this, Data.class);
        startActivity(intent0);
    }
}