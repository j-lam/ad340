package com.jenniferlam.jlam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    GridView grid;

    String[] name={"Recyler View","two","three","four"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        Log.d("My filter", "onCreate() method called");

        Button btnEnter = (Button)findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent message = new Intent(MainActivity.this, MessageActivity.class);
                EditText textInput = (EditText) findViewById(R.id.editText);
                String text = textInput.getText().toString();
                message.putExtra("Input", text);
                startActivity(message);
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



}





