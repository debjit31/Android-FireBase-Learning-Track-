package com.example.firebasetutorials;

import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // Button Reference
    private Button mFirebaseButton;
    private EditText musername;
    private EditText memail;
    private EditText mcontact;

    // Database Reference
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseButton = (Button) findViewById(R.id.FirebaseBtn);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        musername = (EditText) findViewById(R.id.editText1);
        memail = (EditText) findViewById(R.id.editText2);
        mcontact = (EditText) findViewById(R.id.editText3);

        // Set onclick listener for the button
        mFirebaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_name = musername.getText().toString().trim();
                String email_id = memail.getText().toString().trim();
                String contact_no = mcontact.getText().toString().trim();

                HashMap<String, String> newMap = new HashMap<String, String>();
                newMap.put("Name", user_name);
                newMap.put("Email:-", email_id);
                newMap.put("Phone",contact_no);

                mDatabase.push().setValue(newMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Your entry is added!!!!!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Failed to Add!!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                musername.setText("");
                memail.setText("");
                mcontact.setText("");


            }
        });

    }
}
