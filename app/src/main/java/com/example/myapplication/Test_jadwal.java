package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Test_jadwal extends Activity {

    private JSONObject jObject;
    private String jsonResult ="";
    ProgressDialog pd;

    private static final String TAG = "MyActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private  CollectionReference schedRef = db.collection("Schedules");

    private TextView jadJudul, jadStart, jadLoc, jadDesc, jadWaktu;
    private Button btLoad, btBackJadwal;

    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_jadwal);

      //jadJudul = findViewById(R.id.jadjudul);
//       jadStart = findViewById(R.id.jadstart);
//       jadLoc = findViewById(R.id.jadloc);
      jadDesc = findViewById(R.id.jaddesc);
     btLoad = findViewById(R.id.load2);
     btBackJadwal = findViewById(R.id.backJadwal);
     jadWaktu = findViewById(R.id.jadwaktu);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        TextView textView1 = findViewById(R.id.tanggaljad);
        textView1.setText(formattedDate);

        btBackJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iJadwalBack = new Intent(Test_jadwal.this, Beranda.class);
                startActivity(iJadwalBack);
            }
        });
//        CollectionReference ref = db.collection("Users").document(auth.getCurrentUser().getUid()).collection("Schedules");
//        ref.get(Source.CACHE).addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        Log.d(TAG, document.getId() + " => " + document.getData());
//                    }
//                } else {
//                    Log.d(TAG, "Error getting documents: ", task.getException());
//                }
//            }
//        });
//
//    }

    }

    public void get_protected_data(View view) {

        StringRequest PostRequest = new StringRequest(Request.Method.GET, "http://sipro.saijaansmartdev.com/api/v1/meeting", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
//                    Toast.makeText(Test_jadwal.this, response, Toast.LENGTH_SHORT).show();
                    //jObject = new JSONObject(response);
                    //JSONArray menuitemArray = jObject
                    //        .getJSONArray("produk");
                    /*JSONArray jsonarray = new JSONArray(jsonStr);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String name = jsonobject.getString("name");
                        String url = jsonobject.getString("url");
                    }*/
//                    String jwt = response.getJSONObject("data").getString("access_token");

//                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
//                                Detailjadwal detailjadwal = documentSnapshot.toObject(Detailjadwal.class);

                    JSONObject jo = new JSONObject(response);
                    JSONArray arr = jo.getJSONObject("data").getJSONArray("peserta_rapat");

                    String desc ="";
                    String waktu = "";
                    for (int i = 0; i < arr.length(); i++) {

                                String vdesc = arr.getJSONObject(i).getJSONObject("meeting").getString("judul_rapat"); //detailjadwal.getTitle();
                                String vlocation =  arr.getJSONObject(i).getJSONObject("meeting").getString("lokasi_rapat");; //detailjadwal.getLocation();
                                String vtstart =  arr.getJSONObject(i).getJSONObject("meeting").getString("waktu_rapat");
                                String vttanggal =  arr.getJSONObject(i).getJSONObject("meeting").getString("tanggal_rapat");
//                                String vwaktu = detailjadwal.getWaktu();
//                                Timestamp vstart = detailjadwal.getStart();
//                                Timestamp vtstart = detailjadwal.getTime().get("start");
//                                Timestamp vtend = detailjadwal.getTime().get("end");

//                            tstart = vstart;
//                            dstart = (vstart.toDate());
//
//                            tastart = vstart;
//                            dastart = (vtstart.toDate());
//
//                            tbstart = vstart;
//                            dbend = (vtend.toDate());
//
//
//
//                            //create object
//                            Date datea = new Date();
//                            datea = dstart;
//
//                            Date dateb = new Date();
//                            dateb = dastart;
//
//                            Date datec = new Date();
//                            datec = dbend;
//
//                            //set date format
//                            TimeZone utcZone = TimeZone.getTimeZone("Asia/Singapore");
//
//                            SimpleDateFormat sdfa = new SimpleDateFormat("dd-MMMM-yyyy");
//                            sdfa.setTimeZone(utcZone);
//
//                            SimpleDateFormat sdfb = new SimpleDateFormat("HH:mm");
//                            sdfb.setTimeZone(utcZone);

                            //convert
                            String strDate = ""; //sdfa.format(datea);
                            String strDateb = "";  //sdfb.format(dateb);
                            String strEnd =""; //sdfb.format(datec);

//                                desc += vdesc;
//                                location += vlocation;
//                                waktu += vwaktu;

//
//                                desc += "Waktu : " + vwaktu
//                                        + "\nJudul : " + vdesc
//                                        + "\nLokasi : " + vlocation
//                                        + "\nJam Mulai : " +strDate
//                                        + "\nJasm Selesai : "+strDate
//                                        + "\n\n";



                            desc += vdesc
                                    + "\n"+ vlocation
                                    + "\n" +vttanggal
                                    + "\n" +vtstart
                                    + "\n\n";

                        }

                        jadDesc.setText(desc);
//                        jadWaktu.setText(waktu);
//                        jadLoc.setText(location);
//                        jadStart.setText(waktu);

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
                        Toast.makeText(Test_jadwal.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();

                //params.put("username", User); //not used
                //params.put("password", Pass); //not used

                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer "+GlobalVar.jwt_token );
                return params;
            }
        };

        pd = ProgressDialog.show(Test_jadwal.this, "Please Wait", "Connecting", true);
        pd.setCancelable(true);

        Volley.newRequestQueue(this).add(PostRequest);
    }



//    public void loadJadwal(View view) {
//
//        schedRef
//                .orderBy("start", Query.Direction.ASCENDING)
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    String desc = "";
//                    String location = "";
//                    String waktu = "";
//                    String sstart = "";
//                    Date dstart;
//                    Date dastart;
//                    Date dbend;
//
//                    Timestamp tstart;
//                    Timestamp tastart;
//                    Timestamp tbstart;
//
//                    Map <String, Object> time;
//
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
//                                Detailjadwal detailjadwal = documentSnapshot.toObject(Detailjadwal.class);
//
//                                String vdesc = detailjadwal.getTitle();
//                                String vlocation = detailjadwal.getLocation();
//                                String vwaktu = detailjadwal.getWaktu();
//                                Timestamp vstart = detailjadwal.getStart();
//                                Timestamp vtstart = detailjadwal.getTime().get("start");
//                                Timestamp vtend = detailjadwal.getTime().get("end");
//
//                            tstart = vstart;
//                            dstart = (vstart.toDate());
//
//                            tastart = vstart;
//                            dastart = (vtstart.toDate());
//
//                            tbstart = vstart;
//                            dbend = (vtend.toDate());
//
//
//
//                            //create object
//                            Date datea = new Date();
//                            datea = dstart;
//
//                            Date dateb = new Date();
//                            dateb = dastart;
//
//                            Date datec = new Date();
//                            datec = dbend;
//
//                            //set date format
//                            TimeZone utcZone = TimeZone.getTimeZone("Asia/Singapore");
//
//                            SimpleDateFormat sdfa = new SimpleDateFormat("dd-MMMM-yyyy");
//                            sdfa.setTimeZone(utcZone);
//
//                            SimpleDateFormat sdfb = new SimpleDateFormat("HH:mm");
//                            sdfb.setTimeZone(utcZone);
//
//                            //convert
//                            String strDate = sdfa.format(datea);
//                            String strDateb = sdfb.format(dateb);
//                            String strEnd = sdfb.format(datec);
//
////                                desc += vdesc;
////                                location += vlocation;
////                                waktu += vwaktu;
//
////
////                                desc += "Waktu : " + vwaktu
////                                        + "\nJudul : " + vdesc
////                                        + "\nLokasi : " + vlocation
////                                        + "\nJam Mulai : " +strDate
////                                        + "\nJam Selesai : "+strDate
////                                        + "\n\n";
//                            desc += "Rapat : " + vdesc
//                                    + "\nLokasi : " + vlocation
//                                    + "\nTanggal : " +strDate
//                                    + "\nJam Mulai : " +strDateb
//                                    + "\nJam Selesai : "+strEnd
//                                    + "\n\n";
//
//                        }
//                        jadDesc.setText(desc);
////                        jadLoc.setText(location);
////                        jadStart.setText(waktu);
//
//                    }
//                });
//    }


}