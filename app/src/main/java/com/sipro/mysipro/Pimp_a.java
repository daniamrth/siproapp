package com.sipro.mysipro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pimp_a extends Activity {


    Button btBackPimpA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pimp_a);

        btBackPimpA = (Button) findViewById(R.id.backPimpA);
        btBackPimpA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Pimp_a.this, Pimpinan.class);
                startActivity(intent1);
            }

        });



}

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Pimp_a.this, Pimpinan.class);
        startActivity(intent0);
    }

}