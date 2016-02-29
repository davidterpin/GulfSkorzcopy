package dev.com.nobatime.gulfskorz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class TeeOff extends ActionBarActivity {
    ImageView HoleImg;
    Integer course;
    public int holecnt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tee_off);
    //  HoleImg =(ImageView)findViewById(R.id.holePic);
     //  HoleImg.setImageResource(R.drawable.hole1);



        courseCheck();
        playerButtonListener();
        parButtonListener();
        strokeButtonListener();
        startButtonListener();
        clubButtonListener();
        eventButtonListner();
        markballButtonListener();
        holeButtonListener();











    }

    private void holeButtonListener() {

        Button holebutton =(Button)findViewById(R.id.holebutton);
        holecnt = 1;

        holebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(TeeOff.this,"Your Pressed the HOLE button",Toast.LENGTH_SHORT).show();


                holeset();







            }
        });
    }

    private void holeset() {
        // this just sets the view for the hole.


        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.holePic);


        if (holecnt == 1) {

           // imageView.setImageResource(R.drawable.hole1);
            Intent intent = new Intent(TeeOff.this, SurfaceViewActivity.class);
            intent.putExtra("course", 1);
            startActivity(intent);


        }
        if (holecnt ==2){

       // imageView.setImageResource(R.drawable.hole2);
            Intent intent = new Intent(TeeOff.this, SurfaceViewActivity.class);
            intent.putExtra("course", 2);
            startActivity(intent);



        }
        if (holecnt ==3){

        //    imageView.setImageResource(R.drawable.hole3);
            Intent intent = new Intent(TeeOff.this, SurfaceViewActivity.class);
            intent.putExtra("course", 3);
            startActivity(intent);


        }
        if(holecnt >3){
            holecnt=0;
        }holecnt++;


 }

    private void markballButtonListener() {
        Button marker =(Button)findViewById(R.id.markerbutton);
        marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeeOff.this,"Your Pressed the MARKBALL button",Toast.LENGTH_SHORT).show();




            }
        });
    }

    private void eventButtonListner() {
        Button events =(Button)findViewById(R.id.eventbutton);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeeOff.this,"Your Pressed the EVENT button",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void clubButtonListener() {
        Button club =(Button)findViewById(R.id.clubutton);
        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeeOff.this,"Your Pressed the CLUB button",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startButtonListener() {
        Button score =(Button)findViewById(R.id.scorebutton);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeeOff.this,"You presses the SCORE Button",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void strokeButtonListener() {
        Button strokes =(Button)findViewById(R.id.strokebutton);
        strokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeeOff.this, "You are pressed the Strokes button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void parButtonListener() {
        Button par =(Button)findViewById(R.id.parbutton);
        par.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeeOff.this, "You are pressed the PAR button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void playerButtonListener() {
        Button players =(Button)findViewById(R.id.playerbutton);
        players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeeOff.this, "You are pressed the Player button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void courseCheck() {

        Intent intent = getIntent();
        Integer course = intent.getIntExtra("course", -1);
        if (course == 1) {
       //     Toast.makeText(TeeOff.this, "You are playing at the Best Course", Toast.LENGTH_SHORT).show();


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tee_off, menu);
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
