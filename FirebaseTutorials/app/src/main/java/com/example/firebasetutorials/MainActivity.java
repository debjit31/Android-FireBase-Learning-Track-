package com.example.firebasetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // Button Reference
    private Button mFirebaseButton;
    private EditText username;
    private EditText email;
    private EditText contact;

    // Database Reference
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseButton = (Button) findViewById(R.id.FirebaseBtn);

        username = (EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        contact = (EditText) findViewById(R.id.editText3);

        /* Database reference pointing to the root directory of the database */
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Set onclick listener for the button
        mFirebaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1- Create a child in the root object
                //2-  Assign some value to the child object

                // Adding a child to the Database
                mDatabase.child("Name").setValue(username.getText().toString());
                mDatabase.child("Email:- ").setValue(email.getText().toString());
                mDatabase.child("Contact Info :- ").setValue(contact.getText().toString());

                username.setText("");
                email.setText("");
                contact.setText("");

            }
        });

    }
}
