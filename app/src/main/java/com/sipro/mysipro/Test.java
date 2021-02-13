package com.sipro.mysipro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Test extends Activity {

    private static final String KEY_TITLE = "Clock In";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("absensi");
//    private DocumentReference noteRef = db.collection("Users")
//            .document("UsermITdhULlPtZXyHih17hCRtQeoqa2")
//            .collection("Data")
//            .document("Presensi")
//            .collection("In2")
//            .document("2020");



    private TextView textViewData, userXx, loadTest, textViewData2;
    private Button loadData, saveData;

    private FirebaseFirestore mFirestore;
    private EditText editText, editText2;


    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textViewData = findViewById(R.id.testTv);
        textViewData2 = findViewById(R.id.testTv2);
        loadData = findViewById(R.id.load);
        editText = findViewById(R.id.titleText);
        editText2 = findViewById(R.id.descText);
        saveData = findViewById(R.id.add);



        mFirestore = FirebaseFirestore.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();

        //get userid
        final String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        userXx = findViewById(R.id.userxx);
        userXx.setText(currentuser);


    }

//    public void loadData (View v) {
//        noteRef.get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        if (documentSnapshot.exists()) {
//                            String title = documentSnapshot.getString(KEY_TITLE);
//
//                            textViewData.setText("Title : "+title);
//
//                        } else {
//                            Toast.makeText(Test.this, "Document tidak ada", Toast.LENGTH_SHORT).show();
//
//                        }
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(Test.this, "Error", Toast.LENGTH_SHORT).show();
//
//            }
//                });
//    }


//    public void addNotes(View v){
//
//        String title = editText.getText().toString();
//        String desc = editText2.getText().toString();
//
//
//        Note note = new Note(title, desc);
//
//        notebookRef.add(note);
//    }
//
//    public void loadNotes(View v) {
//
//        notebookRef.get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        String data = "";
//                        String data2="";
//
//                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
//                            Note note = documentSnapshot.toObject(Note.class);
//
//                            String title = note.getTitle();
//                            String desc = note.getDesc();
//
//                            data += "Title: " + title + "\n\n";
//                            data2 += "Desc: " + desc + "\n\n";
//
//
//
//                        }
//
//                        textViewData.setText(data);
//                        textViewData2.setText(data2);
//
//                    }
//                });
//    }


}