package com.sipro.mysipro;
import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Jadwal extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        TextView textView1 = findViewById(R.id.tanggaljad);
        textView1.setText(formattedDate);

//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
//        String time = format.format(calendar.getTime());
//        TextView textView = findViewById(R.id.time);
//        textView.setText(time);

    }
}