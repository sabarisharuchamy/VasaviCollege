package com.appin.icecube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
//Button b1;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView=findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/myText.html");
        //webView.loadUrl("https://www.srivasavi.ac.in/");
        String data="<html>\n" +
                "<body>\n" +
                "<h1>This is my first Android app<h1>\n" +
                "</body>\n" +
                "</html>";
        //webView.loadData(data,"text/html","UTF-8");

        //b1=findViewById(R.id.button);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.facebook.com"));
//                startActivity(intent);
//            }
//        });
    }
}