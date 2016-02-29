package dev.com.nobatime.gulfskorz;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    ImageView StartImg;
    public static String DEBUG ="NOBA";
    DatabaseHelper databasehelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartImg =(ImageView)findViewById(R.id.startScreen);
        StartImg.setImageResource(R.drawable.title);
        databasehelper =new DatabaseHelper(this);


        SQLiteDatabase sqLiteDatabase =databasehelper.getWritableDatabase();



        startbuttonListener();




    }

    private void startbuttonListener() {

        Button startbutton = (Button)findViewById(R.id.startbutton);

         startbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

  Intent intent = new Intent(MainActivity.this, TeeOff.class);
                intent.putExtra("course", 1);
               startActivity(intent);


             }
         });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
