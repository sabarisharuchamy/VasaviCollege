package com.appin.icecube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private Button buttonStart;
    private Button buttonStop;
    private TextView textViewPercent;

    private ProgressBar progressBar;

    private Intent serviceIntent;

    private ResponseReceiver receiver = new ResponseReceiver();


    // Broadcast component
    public class ResponseReceiver extends BroadcastReceiver {

        // On broadcast received
        @Override
        public void onReceive(Context context, Intent intent) {

            // Check action name.
            if(intent.getAction().equals(SimpleIntentService.ACTION_1)) {
                int value = intent.getIntExtra(SimpleIntentService.PARAM_PERCENT, 0);

                new ShowProgressBarTask().execute(value);
            }
        }
    }

    // Display value for the ProgressBar.
    class ShowProgressBarTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... args) {

            return args[0];
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

            progressBar.setProgress(result);

            textViewPercent.setText(result + " % Loaded");

            if (result == 100) {
                textViewPercent.setText("Completed");
                buttonStart.setEnabled(true);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.textViewPercent = (TextView) this.findViewById(R.id.textView_percent);
        this.progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        this.buttonStart = (Button) this.findViewById(R.id.button_start);
        this.buttonStop = (Button)this.findViewById(R.id.button_stop);

        this.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStartClicked();
            }
        });

        this.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStopClicked();
            }
        });
    }


    // On Resume of MainActivity
    @Override
    protected void onResume() {
        super.onResume();

        // Register receiver with Activity.
        registerReceiver(receiver, new IntentFilter(
                SimpleIntentService.ACTION_1));
    }

    // On Stop of MainActivity
    @Override
    protected void onStop() {
        super.onStop();

        // Unregister receiver with Activity.
        unregisterReceiver(receiver);
    }

    // Method is called when the user clicks on the Start button.
    public void buttonStartClicked( )  {
        this.buttonStart.setEnabled(false);

        this.serviceIntent = new Intent(this, SimpleIntentService.class);

        startService(this.serviceIntent);
    }


    public void buttonStopClicked( )  {
        if(this.serviceIntent!= null)  {
            // stopService(this.serviceIntent) does not work with IntentService(s).

            // Mandatory stopping of an IntentService is not recommended.
            SimpleIntentService.shouldStop = true;
        }
    }

}