package com.appin.icecube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup rg;
RadioButton rb1;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.radioGroup);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedid = rg.getCheckedRadioButtonId();
                rb1=findViewById(selectedid);
                if(selectedid==-1){
                    Toast.makeText(getApplicationContext(),"Nothing selected",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),rb1.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}