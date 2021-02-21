package com.sipro.mysipro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class P_ahsani extends Activity {

    Button btBackB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_ahsani);

        btBackB = (Button) findViewById(R.id.backpb);
        btBackB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent bahsani = new Intent(P_ahsani.this, Data.class);
                startActivity(bahsani);
            }

        });

    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(P_ahsani.this, Data.class);
        startActivity(intent0);
    }
}