package com.example.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Beranda extends Activity {

//    private JSONObject jObject;
//    private String jsonResult ="";
//    ProgressDialog pd;
//
//    private TextView jadJudul, jadStart, jadLoc, jadDesc;
//    private Button btLoad, btBackJadwal;



    private static int WELCOME_TIMEOUT = 850;
    Button btlogin, btdata, btjadwal, btpresensi, btkehadiran, btlogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

//        get_Jadwal_Beranda();

        setUpFcmToken();


        btlogout = findViewById(R.id.logout);
        btlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent inToLogin = new Intent(Beranda.this, Login.class);
                startActivity(inToLogin);


            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                //intent profil
//                btuser = findViewById(R.id.user);
//                btuser.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent0 = new Intent(Beranda.this, Profil.class);
//                        startActivity(intent0);
//                        // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//
//                    }
//                });
                //intent data paga
                btdata = findViewById(R.id.data);
                btdata.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent(Beranda.this, Data.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    }
                });


                //intent jadwal page
                btjadwal = findViewById(R.id.jadwal);
                btjadwal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(Beranda.this, Test_jadwal.class);
                        startActivity(intent2);
                        // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    }
                });


                //intent kehadiran page
                btkehadiran = findViewById(R.id.kehadiran);
                btkehadiran.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3 = new Intent(Beranda.this, Kehadiran.class);
                        startActivity(intent3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    }
                });

                //intent presensi paga
                btpresensi = findViewById(R.id.presensi);
                btpresensi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent4 = new Intent(Beranda.this, Presensi.class);
                        startActivity(intent4);
                        // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    }
                });


            }
        }, WELCOME_TIMEOUT);


    }


    private void setUpFcmToken() {

//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, instanceIdResult -> {
//            String newToken = instanceIdResult.getToken();
//            Log.e("newToken", newToken);
//        });

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                final String newToken = instanceIdResult.getToken();
//                Log.e("newToken", newToken);


                JSONObject param = new JSONObject();

                try {
                    param.put("fcm", newToken);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                RequestQueue requstQueue = Volley.newRequestQueue(Beranda.this);

                JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, "http://sipro.saijaansmartdev.com/api/v1/fcm",param,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("newToken", newToken);

                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Beranda.this, error.toString(), Toast.LENGTH_SHORT).show();
                                //
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
                requstQueue.add(jsonobj);

            }
        });

    }


//    public void get_Jadwal_Beranda() {
//
//        StringRequest PostRequest = new StringRequest(Request.Method.GET, "http://sipro.saijaansmartdev.com/api/v1/meeting", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
////                    Toast.makeText(Test_jadwal.this, response, Toast.LENGTH_SHORT).show();
//                    //jObject = new JSONObject(response);
//                    //JSONArray menuitemArray = jObject
//                    //        .getJSONArray("produk");
//                    /*JSONArray jsonarray = new JSONArray(jsonStr);
//                    for (int i = 0; i < jsonarray.length(); i++) {
//                        JSONObject jsonobject = jsonarray.getJSONObject(i);
//                        String name = jsonobject.getString("name");
//                        String url = jsonobject.getString("url");
//                    }*/
////                    String jwt = response.getJSONObject("data").getString("access_token");
//
////                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
////                                Detailjadwal detailjadwal = documentSnapshot.toObject(Detailjadwal.class);
//
//                    JSONObject jo = new JSONObject(response);
//                    JSONArray arr = jo.getJSONObject("data").getJSONArray("peserta_rapat");
//
//                    String desc ="";
//                    for (int i = 0; i < arr.length(); i++) {
//
//                        String vdesc = arr.getJSONObject(i).getJSONObject("meeting").getString("judul_rapat"); //detailjadwal.getTitle();
//                        String vlocation =  arr.getJSONObject(i).getJSONObject("meeting").getString("lokasi_rapat");; //detailjadwal.getLocation();
//                        String vtstart =  arr.getJSONObject(i).getJSONObject("meeting").getString("waktu_rapat");
//                        String vttanggal =  arr.getJSONObject(i).getJSONObject("meeting").getString("tanggal_rapat");
////                                String vwaktu = detailjadwal.getWaktu();
////                                Timestamp vstart = detailjadwal.getStart();
////                                Timestamp vtstart = detailjadwal.getTime().get("start");
////                                Timestamp vtend = detailjadwal.getTime().get("end");
//
////                            tstart = vstart;
////                            dstart = (vstart.toDate());
////
////                            tastart = vstart;
////                            dastart = (vtstart.toDate());
////
////                            tbstart = vstart;
////                            dbend = (vtend.toDate());
////
////
////
////                            //create object
////                            Date datea = new Date();
////                            datea = dstart;
////
////                            Date dateb = new Date();
////                            dateb = dastart;
////
////                            Date datec = new Date();
////                            datec = dbend;
////
////                            //set date format
////                            TimeZone utcZone = TimeZone.getTimeZone("Asia/Singapore");
////
////                            SimpleDateFormat sdfa = new SimpleDateFormat("dd-MMMM-yyyy");
////                            sdfa.setTimeZone(utcZone);
////
////                            SimpleDateFormat sdfb = new SimpleDateFormat("HH:mm");
////                            sdfb.setTimeZone(utcZone);
//
//                        //convert
//                        String strDate = ""; //sdfa.format(datea);
//                        String strDateb = "";  //sdfb.format(dateb);
//                        String strEnd =""; //sdfb.format(datec);
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
//                        desc += "Rapat : " + vdesc
//                                + "\n\n";
//
//                    }
//
//                    jadDesc.setText(desc);
////                        jadLoc.setText(location);
////                        jadStart.setText(waktu);
//
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    Toast.makeText(getBaseContext(), "Gagal",
//                            Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//                }
//
//                pd.dismiss();
//            }
//
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(Beranda.this, "Error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        ){
//            protected Map<String, String> getParams(){
//                Map<String, String> params = new HashMap<>();
//
//                //params.put("username", User); //not used
//                //params.put("password", Pass); //not used
//
//                return params;
//            }
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+GlobalVar.jwt_token );
//                return params;
//            }
//        };
//
//        pd = ProgressDialog.show(Beranda.this, "Please Wait", "Connecting", true);
//        pd.setCancelable(true);
//
//        Volley.newRequestQueue(this).add(PostRequest);
//    }

    @Override
    public void onBackPressed() {
    }
}
