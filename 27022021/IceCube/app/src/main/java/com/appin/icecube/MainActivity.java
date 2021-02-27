package com.appin.icecube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText2;
    Button button1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button);
        textView = findViewById(R.id.textView3);
        DatabaseHandler db = new DatabaseHandler(this);
        // Inserting Contacts

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Insert: ", "Inserting ..");
                db.addContact(new Contact(editText.getText().toString(), editText2.getText().toString()));
            }
        });

        /*db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));*/
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();
        StringBuilder sb = new StringBuilder();
        for (Contact cn : contacts) {
            String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone: " +
                    cn.get_phone_number();
            // Writing Contacts to log
            Log.d("Name: ", log);
            sb.append(log + "\n");
        }
        textView.setText(sb.toString());
    }
}