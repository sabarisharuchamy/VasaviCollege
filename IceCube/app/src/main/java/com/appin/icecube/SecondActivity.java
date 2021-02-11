package com.appin.icecube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
EditText editText;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        Bundle extras = getIntent().getExtras();
//        String name = extras.getString("name");
//        String designation = extras.getString("designation");
//        Toast.makeText(getApplicationContext(),"Name: "+name+"\nDesignation: "+designation,Toast.LENGTH_LONG).show();
editText=findViewById(R.id.edit1);
b1=findViewById(R.id.button2);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String message = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("MESSAGE",message);
        setResult(2,intent);
        finish();
    }
});
    }
}