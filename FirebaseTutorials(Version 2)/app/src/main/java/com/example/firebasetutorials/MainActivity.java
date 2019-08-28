package com.example.firebasetutorials;

import android.support.annotation.IntegerRes;
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
    private int user = 0;

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

        

        // Set onclick listener for the button
        mFirebaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1- Create a child in the root object
                //2-  Assign some value to the child object

                // Adding a child to the Database
                /* Incrment User Number by 1 */
                user++;
                String usernumber = Integer.toString(user);
                // Creating a database reference to a child*/
                mDatabase = FirebaseDatabase.getInstance().getReference().child("User_"+usernumber);
                int tmp = Integer.parseInt(usernumber);
                user = tmp;

                mDatabase.push().setValue(username.getText().toString().trim());
                mDatabase.push().setValue(email.getText().toString().trim());
                mDatabase.push().setValue(contact.getText().toString().trim());

                username.setText("");
                email.setText("");
                contact.setText("");

            }
        });

    }
}
