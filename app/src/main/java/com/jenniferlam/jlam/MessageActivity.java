package com.jenniferlam.jlam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String message = intent.getStringExtra("Input");
        TextView txtView_Message= (TextView) findViewById(R.id.txtView_Message);
        txtView_Message.setText(message);
        Log.d("My filter", "onCreate() method called");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_about_us) {
            Toast.makeText(MessageActivity.this,
                    "You have clicked on about action menu",
                    Toast.LENGTH_SHORT)
                    .show();
            Intent about= new Intent(MessageActivity.this, aboutActivity.class);
            startActivity(about);
        }
        if(item.getItemId() == R.id.recycleview1) {
            Intent about= new Intent(MessageActivity.this, RecyclerViewActivity.class);
            startActivity(about);
        }
        if(item.getItemId() == R.id.txtView_Message) {

            Intent about= new Intent(MessageActivity.this, MessageActivity.class);
            startActivity(about);
        }
        if(item.getItemId() == R.id.map) {

            Intent about= new Intent(MessageActivity.this, MapsActivity.class);
            startActivity(about);
        }
        return super.onOptionsItemSelected(item);
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
