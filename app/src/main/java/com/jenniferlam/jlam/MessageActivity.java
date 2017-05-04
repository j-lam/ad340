package com.jenniferlam.jlam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra("Input");
        TextView txtView_Message= (TextView) findViewById(R.id.txtView_Message);
        txtView_Message.setText(message);
        Log.d("My filter", "onCreate() method called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("My filter", "onStart() method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("My filter", "onPause() method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("My filter", "onResume() method called");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("My filter", "onStop() method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("My filter", "onDestroy() method called");
    }
}
