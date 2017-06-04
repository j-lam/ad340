package com.jenniferlam.jlam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by jennifer on 5/2/2017.
 */

public class aboutActivity extends AppCompatActivity {
   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.about_page);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

   }


   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater menuInflater = getMenuInflater();
      menuInflater.inflate(R.menu.my_menu, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {

      if (item.getItemId() == R.id.action_about_us) {

         Intent about = new Intent(aboutActivity.this, aboutActivity.class);
         startActivity(about);
      }
      if (item.getItemId() == R.id.recycleview1) {
         Intent about = new Intent(aboutActivity.this, RecyclerViewActivity.class);
         startActivity(about);
      }
      if (item.getItemId() == R.id.txtView_Message) {

         Intent about = new Intent(aboutActivity.this, MessageActivity.class);
         startActivity(about);
      }
      if (item.getItemId() == R.id.map) {

         Intent about = new Intent(aboutActivity.this, MapsActivity.class);
         startActivity(about);
      }
      return super.onOptionsItemSelected(item);
   }
}