package com.jenniferlam.jlam;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    GridView grid;

    String[] name={"Recyler View","two","three","four"};
    String[] selection = {"Yes", "No"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        Log.d("My filter", "onCreate() method called");


        final Button btnEnter = (Button)findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Intent message = new Intent(MainActivity.this, MessageActivity.class);
                EditText textInput = (EditText) findViewById(R.id.editText);
                String text = textInput.getText().toString();
                message.putExtra("Input", text);
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Do you want to Enter")
                        .setItems(selection, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch(which){
                                    case 0:
                                        startActivity(message);
                                        Log.d("message", "You clicked on Yes");
                                        break;
                                    case 1:
                                        Log.d("message", "You clicked on No");
                                        break;
                                }
                            }
                        });
                builder.create();
                builder.show();
            }
        });

        GridViewAdapter adapter = new GridViewAdapter(MainActivity.this,name);
        grid=(GridView)findViewById(R.id.activity_main_gridView);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id){
                Toast.makeText(MainActivity.this, "You clicked at " +name[+ position], Toast.LENGTH_SHORT).show();
                if(name[position].equals("Recyler View")){
                    Intent intent2 = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    startActivity(intent2);
                    checkInternetConenction();
                }
            }
        });
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
            Toast.makeText(MainActivity.this,
                    "You have clicked on about action menu",
                    Toast.LENGTH_SHORT)
                    .show();
            Intent about= new Intent(MainActivity.this, aboutActivity.class);
            startActivity(about);
        }
        if(item.getItemId() == R.id.recycleview1) {
            Toast.makeText(MainActivity.this,
                    "You have clicked on RecycleView action menu",
                    Toast.LENGTH_SHORT)
                    .show();
            Intent about= new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(about);
        }
        if(item.getItemId() == R.id.txtView_Message) {
            Toast.makeText(MainActivity.this,
                    "You have clicked on Message action menu",
                    Toast.LENGTH_SHORT)
                    .show();
            Intent about= new Intent(MainActivity.this, MessageActivity.class);
            startActivity(about);
        }
        if(item.getItemId() == R.id.map) {
            Toast.makeText(MainActivity.this,
                    "You have clicked on map action menu",
                    Toast.LENGTH_SHORT)
                    .show();
            Intent about= new Intent(MainActivity.this, MapsActivity.class);
            startActivity(about);
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean checkInternetConenction() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec
                =(ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {
            Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            return true;
        }else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED  ) {
            Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }



}





