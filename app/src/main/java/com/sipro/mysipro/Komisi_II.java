package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Komisi_II extends Activity {

    Button btBackk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komisi__i_i);

        btBackk2 = findViewById(R.id.backk2);

        btBackk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iK2 = new Intent(Komisi_II.this, Data.class);
                startActivity(iK2);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Komisi_II.this, Data.class);
        startActivity(intent0);
    }
}