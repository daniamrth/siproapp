package com.sipro.mysipro;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Data extends Activity {

    Spinner spDivisi, spSubDivisi;
    Button btCari, btDataBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        btCari = (Button) findViewById(R.id.cari);
        spDivisi = (Spinner) findViewById(R.id.divisi);
        spSubDivisi = (Spinner) findViewById(R.id.subDivisi);
        btDataBack = (Button) findViewById(R.id.backData);

        btDataBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDataBack = new Intent(Data.this, Beranda.class);
                startActivity(iDataBack);

            }
        });

        final String isiDivisi[] = {
                "Pimpinan",
                "Fraksi",
                "Komisi",
                "Alat Kelengkapan Dewan"

        };



        final String isiPimpinan[] = {
                "Pimpinan"
        };

        final String isiFraksi[] = {
                "Fraksi Partai Golongan Karya",
                "Fraksi Partai Persatuan Pembangunan",
                "Fraksi Partai Demokrasi Indonesia Perjuangan",
                "Fraksi Nasional Demokrat",
                "Fraksi Indonesia Raya Keadilan Sejahtera",
                "Fraksi Amanat Bintang Demokrasi"
        };


        final String isiKomisi[]= {

                "Komisi I",
                "Komisi II",
                "Komisi III"
        };


        final String isiAkd[] = {
                "Badan Anggaran",
                "Badan Musyawarah",
                "Badan Pemperda",
                "Badan Kehormatan"
        };

//        final String isiPartai[] = {
//                "Partai Amanat Nasional",
//                "Partai Bulan Bintang",
//                "Partai Demokrasi Indonesia Perjuangani",
//                "Partai Gerindra",
//                "Partai Golongan Karya",
//                "Partai Hanura",
//                "Partai Keadilan Sejahtera",
//                "Partai Kebangkitan Bangsa",
//                "Partai Nasional Demokrat",
//                "Partai Persatuan Pembangunan"
//
//
//        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, isiDivisi);
        spDivisi.setAdapter(adapter);

        spDivisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String divisiSelect = isiDivisi[position];

                /*Divisi Pimpinan*/
                if (position == 0) {
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Data.this, R.layout.spinner_item, isiPimpinan);
                    spSubDivisi.setAdapter(adapter1);

                    spSubDivisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

                            switch (i) {

                                /*Pimpinan*/
                                case 0:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View v) {

                                            //HERE
                                            Intent intent1 = new Intent(Data.this, Pimpinan.class);
                                            startActivity(intent1);
                                        }

                                    });

                                    break;

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }

                    });

                }

                /*Sub divisi fraksi*/
                if (position == 1) {
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Data.this, R.layout.spinner_item, isiFraksi);
                    spSubDivisi.setAdapter(adapter2);
                    spSubDivisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                            switch (i) {

                                /*Fraksi Partai Golkar*/
                                case 0:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent2 = new Intent(Data.this, Fraksi_Golkar.class);
                                            startActivity(intent2);
                                        }
                                    });

                                    break;

                                /*Fraksi PPP*/
                                case 1:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent3 = new Intent(Data.this, Fraksi_PPP.class);
                                            startActivity(intent3);
                                        }
                                    });

                                    break;


                                /*Fraksi DIP*/
                                case 2:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent4 = new Intent(Data.this, Fraksi_DIP.class);
                                            startActivity(intent4);
                                        }
                                    });

                                    break;

                                /*Fraksi Nasdem*/
                                case 3:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent5 = new Intent(Data.this, Fraksi_Nasdem.class);
                                            startActivity(intent5);
                                        }
                                    });

                                    break;

                                /*Fraksi IRKS*/
                                case 4:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent6 = new Intent(Data.this, Fraksi_IRKS.class);
                                            startActivity(intent6);
                                        }
                                    });

                                    break;

                                /*Fraksi Amanat Bintang Demokrasi*/
                                case 5:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent6 = new Intent(Data.this, Fraksi_ABD.class);
                                            startActivity(intent6);
                                        }
                                    });

                                    break;



                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) { }
                    });
                }

                /*Sub divisi komisi*/
                if (position == 2) {
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Data.this, R.layout.spinner_item, isiKomisi);
                    spSubDivisi.setAdapter(adapter3);
                    spSubDivisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                            switch (i) {

                                /*Komisi I*/
                                case 0:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent7 = new Intent(Data.this, Komisi_I.class);
                                            startActivity(intent7);
                                        }
                                    });

                                    break;

                                /*Komisi II*/
                                case 1:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent8 = new Intent(Data.this, Komisi_II.class);
                                            startActivity(intent8);
                                        }
                                    });

                                    break;


                                /*Komisi III*/
                                case 2:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent9 = new Intent(Data.this, Komisi_III.class);
                                            startActivity(intent9);
                                        }
                                    });

                                    break;


                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                /*Sub divisi Alat Kelengkapan Dewan*/
                if (position == 3) {
                    ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(Data.this, R.layout.spinner_item, isiAkd);
                    spSubDivisi.setAdapter(adapter4);

                    spSubDivisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

                            switch (i) {

                                /*AKD  Anggaran*/
                                case 0:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View v) {
                                            Intent intent10 = new Intent(Data.this, Akd_Anggaran.class);
                                            startActivity(intent10);
                                        }

                                    });


                                    break;

                                /*AKD Musyawarah*/
                                case 1:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent11 = new Intent(Data.this, Akd_Musyawarah.class);
                                            startActivity(intent11);
                                        }
                                    });

                                    break;


                                /*AKD  pemperda*/
                                case 2:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent12 = new Intent(Data.this, Akd_Legislasi.class);
                                            startActivity(intent12);
                                        }
                                    });

                                    break;

                                /*ACS kehormatan*/
                                case 3:
                                    btCari = (Button) findViewById(R.id.cari);
                                    btCari.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent13 = new Intent(Data.this, Akd_Kehormatan.class);
                                            startActivity(intent13);
                                        }
                                    });

                                    break;

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }

                    });

                }

                /*Sub partai*/
//                if (position == 4) {
//                    ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(Data.this, R.layout.spinner_item, isiPartai);
//                    spSubDivisi.setAdapter(adapter5);
//                    spSubDivisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
//
//                            switch (i) {
//
//                                /*AKD  Anggaran*/
//                                case 0:
//                                    btCari = (Button) findViewById(R.id.cari);
//                                    btCari.setOnClickListener(new View.OnClickListener() {
//
//                                        @Override
//                                        public void onClick(View v) {
//                                            Intent intent10 = new Intent(Beranda.this, MainActivity.class);
//                                            startActivity(intent10);
//                                        }
//
//                                    });
//
//
//                                    break;
//
//                                /*AKD Musyawarah*/
//                                case 1:
//                                    btCari = (Button) findViewById(R.id.cari);
//                                    btCari.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View v) {
//                                            Intent intent11 = new Intent(Beranda.this, MainActivity.class);
//                                            startActivity(intent11);
//                                        }
//                                    });
//
//                                    break;
//
//
//                                /*AKD  legilasi*/
//                                case 2:
//                                    btCari = (Button) findViewById(R.id.cari);
//                                    btCari.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View v) {
//                                            Intent intent12 = new Intent(Beranda.this, MainActivity.class);
//                                            startActivity(intent12);
//                                        }
//                                    });
//
//                                    break;
//
//                                /*ACS kehormatan*/
//                                case 3:
//                                    btCari = (Button) findViewById(R.id.cari);
//                                    btCari.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View v) {
//                                            Intent intent13 = new Intent(Beranda.this, MainActivity.class);
//                                            startActivity(intent13);
//                                        }
//                                    });
//
//                                    break;
//
//                            }
//                        }
//
//                        @Override
//                        public void onNothingSelected(AdapterView<?> parent) {
//                        }
//
//                    });

//                }
//
//            }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });




    }
    @Override
    public void onBackPressed() {
        Intent intent0 = new Intent(Data.this, Beranda.class);
        startActivity(intent0);
    }

}