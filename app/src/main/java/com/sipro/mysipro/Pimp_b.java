package com.sipro.mysipro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pimp_b extends Activity {

    Button btBackPimpB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pimp_b);

        btBackPimpB = (Button) findViewById(R.id.backPimpB);
        btBackPimpB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Pimp_b.this, Pimpinan.class);
                startActivity(intent1);
            }

        });

    }


    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Pimp_b.this, Pimpinan.class);
        startActivity(intent0);
    }

}