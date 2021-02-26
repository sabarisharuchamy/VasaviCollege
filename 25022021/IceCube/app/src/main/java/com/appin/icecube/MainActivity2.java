package com.appin.icecube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {
    //private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Requesting Permission to access External Storage
        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
          //      EXTERNAL_STORAGE_PERMISSION_CODE);
        verifyStoragePermissions(MainActivity2.this);
        VideoView videoView =(VideoView)findViewById(R.id.videoView1);

        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        //specify the location of media file
        //Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Movies/test.mp4");
//Uri uri=Uri.parse("/storage/8349-18F9/Movies/1.mp4");
        //Uri uri=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test);
        /*Log.d("External Storage Path ",String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)));
        String path = Environment.getExternalStorageDirectory().toString();
        Log.d("Files", "Path: " + path);
        //File directory = new File("/storage/8349-18F9/Movies");
        File directory=new File("/storage/emulated/0/Movies");
        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);
        for (int i = 0; i < files.length; i++)
        {
            Log.d("Files", "FileName:" + files[i].getName());
        }*/
        //Setting MediaController and URI, then starting the videoView
        File directory = new File("/storage/");
        File[] files = directory.listFiles();
        String path = directory.getPath()+"/"+files[0].getName();
        Log.d("Files", "Size: "+ path);
        Uri uri=Uri.parse(path+"/Movies/1.mp4");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}