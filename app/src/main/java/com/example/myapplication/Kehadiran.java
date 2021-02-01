package com.example.myapplication;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ServerTimestamp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class Kehadiran extends Activity  {


    ProgressDialog pd;
    String your_JWT_Token="";

    private Button btIn, btOut, btBackKehadiran;
    private TextView waktu, tanggalIn, tampilClockIn, tampilClockOut, tUi, attTypeCi, attTypeCo, txTodayDate;

    TextView txMm, txYy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran);

        txMm = findViewById(R.id.tMm);
        txYy = findViewById(R.id.tYy);



        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        txTodayDate = (TextView) findViewById(R.id.todaydate);
        txTodayDate.setText(date);

        //get date
        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);


        TextView textView1 = findViewById(R.id.tanggal);
        textView1.setText(formattedDate);

        btIn = (Button) findViewById(R.id.in);
        btOut = (Button) findViewById(R.id.out);


//        mInputData = (EditText) findViewById(R.id.inputData);

        btBackKehadiran = findViewById(R.id.backKehadiran);
        btBackKehadiran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iKehadiranBack = new Intent(Kehadiran.this, Beranda.class);
                startActivity(iKehadiranBack);

            }
        });


        waktu =(TextView) findViewById(R.id.time);
        tanggalIn = (TextView) findViewById(R.id.tanggal);
        tampilClockIn=(TextView)  findViewById(R.id.showClockIn);
        tampilClockOut=(TextView) findViewById(R.id.showClockOut);
        attTypeCi = (TextView) findViewById(R.id.att_type_in);
        attTypeCo = (TextView) findViewById(R.id.att_type_out);



        //clock in
        btIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get date
                SimpleDateFormat fulldate = new SimpleDateFormat("YYYY:MM:DD");
                String fd = fulldate.format(new Date());
                txYy = (TextView) findViewById(R.id.tYy);
                txYy.setText(fd);

                //get time
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                String time1 = format.format(calendar.getTime());
                final TextView textView = findViewById(R.id.time);
                textView.setText(time1);

                String inputWaktuCi = textView.getText().toString();
                String fulld = txYy.getText().toString();

                inputJamMasuk(fulld,inputWaktuCi,"4321","4321");
                tampilClockIn.setText(inputWaktuCi+"                                                      Jam Masuk");

                btIn.setEnabled(false);
                btOut.setEnabled(true);

            }


        });


        //clock out
        btOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get date
                SimpleDateFormat fulldateo = new SimpleDateFormat("YYYY:MM:DD");
                String fdo = fulldateo.format(new Date());
                txMm = (TextView) findViewById(R.id.tMm);
                txMm.setText(fdo);

                //get Time
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                String time2 = format.format(calendar.getTime());
                final TextView textView2 = findViewById(R.id.timeOut);
                textView2.setText(time2);
                String inputWaktuCo = textView2.getText().toString();
                String fulldo = txMm.getText().toString();
                inputJamKeluar(fulldo,inputWaktuCo,"4321","4321");

                tampilClockOut.setText(inputWaktuCo+"                                                      Jam Keluar");

                btOut.setEnabled(false);
                btIn.setEnabled(true);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Kehadiran.this, Beranda.class);
        startActivity(intent0);
    }

    public void inputJamMasuk(final String tanggal_absensi, final String waktu_absensi, final String lat, final String lng) {

        StringRequest PostRequest = new StringRequest(Request.Method.POST, "https://sipro.saijaansmartdev.com/api/v1/attendence", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                   // Toast.makeText(Kehadiran.this, response, Toast.LENGTH_SHORT).show();
                    //jObject = new JSONObject(response);
                    //JSONArray menuitemArray = jObject
                    //        .getJSONArray("produk");

                    /*JSONArray jsonarray = new JSONArray(jsonStr);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String name = jsonobject.getString("name");
                        String url = jsonobject.getString("url");
                    }*/

                    JSONObject jo = new JSONObject(response);
                    GlobalVar.absenId = jo.getJSONObject("data").getString("id");

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(getBaseContext(), "Gagal",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                pd.dismiss();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Kehadiran.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();

                params.put("tanggal_absensi", tanggal_absensi); //not used
                params.put("waktu_absensi", waktu_absensi); //not used
                params.put("lat", lat);
                params.put("lng", lng);

                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer "+ GlobalVar.jwt_token);
                return params;
            }
        };

        pd = ProgressDialog.show(Kehadiran.this, "Silahkan tunggu", "Proses input jam masuk", true);
        pd.setCancelable(true);

        Volley.newRequestQueue(this).add(PostRequest);
    }

    public void inputJamKeluar(final String tanggal_absensi, final String waktu_absensi, final String lat, final String lng) {

        StringRequest PostRequest = new StringRequest(Request.Method.PATCH, "https://sipro.saijaansmartdev.com/api/v1/attendence/"+GlobalVar.absenId, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(Kehadiran.this, response, Toast.LENGTH_SHORT).show();
                    //jObject = new JSONObject(response);
                    //JSONArray menuitemArray = jObject
                    //        .getJSONArray("produk");

                    /*JSONArray jsonarray = new JSONArray(jsonStr);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String name = jsonobject.getString("name");
                        String url = jsonobject.getString("url");
                    }*/

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(getBaseContext(), "Gagal",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                pd.dismiss();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Kehadiran.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();

                params.put("tanggal_absensi", tanggal_absensi); //not used
                params.put("waktu_absensi", waktu_absensi); //not used
                params.put("lat", lat);
                params.put("lng", lng);

                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer "+ GlobalVar.jwt_token);
                return params;
            }
        };

        pd = ProgressDialog.show(Kehadiran.this, "Silahkan tunggu", "Proses input jam keluar", true);
        pd.setCancelable(true);

        Volley.newRequestQueue(this).add(PostRequest);
    }

}