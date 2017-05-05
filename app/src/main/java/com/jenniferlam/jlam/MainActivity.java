package com.jenniferlam.jlam;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Do you want to Enter")
                        .setItems(selection, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch(which){
                                    case 0:
                                        Intent message = new Intent(MainActivity.this, MessageActivity.class);
                                        EditText textInput = (EditText) findViewById(R.id.editText);
                                        String text = textInput.getText().toString();
                                        message.putExtra("Input", text);
                                        startActivity(message);
                                        break;
                                    case 1:
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
            Intent about= new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(about);
        }
        if(item.getItemId() == R.id.txtView_Message) {

            Intent about= new Intent(MainActivity.this, MessageActivity.class);
            startActivity(about);
        }
        return super.onOptionsItemSelected(item);
    }
}





