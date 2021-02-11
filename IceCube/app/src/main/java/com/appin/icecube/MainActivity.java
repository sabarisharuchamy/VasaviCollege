package com.appin.icecube;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button b1;
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate","onCreate Event Invoked");
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
//                intent.putExtra("name","Sabari");
//                intent.putExtra("designation","software developer");
//                startActivity(intent);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2){
            String message = data.getStringExtra("MESSAGE");
t1.setText(message);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart","onStart Event Invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","onPause Event Invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","onResume Event Invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart","onRestart Event Invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop","onStop Event Invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","onDestroy Event Invoked");
    }
}