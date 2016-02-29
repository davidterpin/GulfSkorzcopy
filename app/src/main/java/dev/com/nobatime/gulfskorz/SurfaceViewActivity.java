package dev.com.nobatime.gulfskorz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.Policy;
import java.util.ArrayList;
import java.util.List;


public class SurfaceViewActivity extends Activity implements Runnable {
    private Button swapBtn,markBtn,clubBtn;
    private SurfaceView surface;
    private SurfaceHolder holder;
    private boolean locker=true;
    private Thread thread;

    private boolean left = true;
    //physics


    Bitmap marker;
    Bitmap backbit;
     int a,b,c;


    float x,y;
    int bg,holecnt,i,s,strokecnt;
    int[] strokes;
    int[] strokeX;
    int[] strokeY;



   private static String DEBUG ="NOBA";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);



        Log.d(MainActivity.DEBUG, "*******MESSAGE FROM SURFACE VIEW ");






        swapBtn = (Button) findViewById(R.id.scorebutton);
        markBtn = (Button) findViewById(R.id.markerbutton);
        clubBtn =(Button)findViewById(R.id.clubutton);
        surface = (SurfaceView) findViewById(R.id.mysurface);
        holder = surface.getHolder();











        backgroundset();

        holeButtonListener();


        //   backbit = BitmapFactory.decodeResource(getResources(), R.drawable.hole2);

        marker = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
        //   gball = BitmapFactory.decodeResource(getResources(), R.drawable.gulfball);

        x = 0;
        y = 0;


        strokes = new int[4];

        strokeX = new int[14];
        strokeY = new int[14];
        //  strokeX[0]=800;
        //  strokeY[0]=800;

        strokes[0] = 100;
        strokes[1] = 300;
        strokes[2] = 400;
        strokes[3] = 520;
        i = 0;
        s = 0;

        thread = new Thread(this);
        thread.start();

        surface.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getX();
                y = event.getY();

                //      Toast.makeText(SurfaceViewActivity.this, "x is " +x+ " Y is "+y, Toast.LENGTH_SHORT).show();
                //       Log.d(MainActivity.DEBUG, "you pressed something");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                switch (event.getAction()) {
         /*   case MotionEvent.ACTION_DOWN:
              x = event.getX();
               y = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                x = event.getX();
                y = event.getY();

                break;
*/
                    case MotionEvent.ACTION_MOVE:
                        x = event.getX();
                        y = event.getY();

                        //  Toast.makeText(SurfaceViewExample.this, "x and Y "+x+y, Toast.LENGTH_SHORT).show();
                     //   Log.d(MainActivity.DEBUG, "you moved your finger around");
                        //    ball= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);


                        break;

                }

                return true;
            }


        });

        markBtn.setOnClickListener(new View.OnClickListener() {

            private List<Point> points = new ArrayList<Point>();
            @Override
            public void onClick(View v) {
                Toast.makeText(SurfaceViewActivity.this, "Stroke X  " + strokeX[0] + " Stroke Y is " + strokeY[0], Toast.LENGTH_SHORT).show();
                //   Toast.makeText(SurfaceViewActivity.this, "x is " +x+ " Y is "+y, Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.DEBUG, "you pressed MARK BALL : X Coord= " + x + " Y Coord =" + y);

                strokeX[strokecnt] = (int) (Math.round(x));
                strokeY[strokecnt] = (int) (Math.round(y));




                points.add(new Point(strokeX[strokecnt],strokeY[strokecnt]));




                // Toast.makeText(SurfaceViewActivity.this, "x is " +strokex[strokecnt]+ " Y is "+strokey[strokecnt], Toast.LENGTH_SHORT).show();

                if (strokecnt == 7) {
                    Toast.makeText(SurfaceViewActivity.this, "SNOWMAN ", Toast.LENGTH_SHORT).show();
                    Log.d(MainActivity.DEBUG, "This is the SNOWMAN event trigger");
                    strokecnt++;
                }
                strokecnt++;

            }


        });



        // onClick listener sets buttons

        swapBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //   Toast.makeText(SurfaceViewActivity.this, "Stroke X  " +strokeX[0]+ " Stroke Y is "+strokeY[0], Toast.LENGTH_SHORT).show();
                Toast.makeText(SurfaceViewActivity.this, "YOUR SCORE IS " +strokecnt, Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.DEBUG, "you pressed SCORE BUTTON, SCORE = " +strokecnt);





            }
        });

        clubBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //   Toast.makeText(SurfaceViewActivity.this, "Stroke X  " +strokeX[0]+ " Stroke Y is "+strokeY[0], Toast.LENGTH_SHORT).show();
                Toast.makeText(SurfaceViewActivity.this, "Club Button " +strokecnt, Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.DEBUG, "you pressed CLub BUTTON, SCORE = " +strokecnt);
            }

        });
    }




    private void showPrompt() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setTitle("Move ball market with your finger. Tap MARK BALL to enter stroke");
        AlertDialog dlg = builder.create();
        dlg.show();
    }


    private void holeButtonListener() {
        Button holeset =(Button)findViewById(R.id.holebutton);
        holeset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // if we are changing the background, we should probably reset the strokes and the
              //  places we left the ball

                holeset();
              }
        });

    }

    private void holeset() {

        if (holecnt == 1) {

            // imageView.setImageResource(R.drawable.hole1);
            backbit = BitmapFactory.decodeResource(getResources(), R.drawable.hole1);

        }
        if (holecnt == 2) {

            // imageView.setImageResource(R.drawable.hole2);
            backbit = BitmapFactory.decodeResource(getResources(), R.drawable.hole2);

        }
        if (holecnt == 3) {

            //    imageView.setImageResource(R.drawable.hole3);
            backbit = BitmapFactory.decodeResource(getResources(), R.drawable.hole3);

        }
        if (holecnt > 3) {
            holecnt = 1;
        }
        holecnt++;
    }

    private void backgroundset() {

        // the intent passed from Mainactivity chooses which hole to play
        Intent intent = getIntent();
        Integer pos = intent.getIntExtra("course", -1);
        showPrompt();

        if (pos ==1){
            backbit = BitmapFactory.decodeResource(getResources(), R.drawable.hole1);

        }if (pos ==2){
            backbit = BitmapFactory.decodeResource(getResources(), R.drawable.hole2);

        }if (pos ==3){
            backbit = BitmapFactory.decodeResource(getResources(), R.drawable.hole3);

        }

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(locker){
            //checks if the lockCanvas() method will be success,and if not, will check this statement again
            if(!holder.getSurface().isValid()){
                continue;
            }
          /** Start editing pixels in this surface.*/
         Canvas canvas = holder.lockCanvas();

           onDrawBackground(canvas);

           onDrawMarker(canvas);

         //  onDrawOLDSTROKES(canvas);

           onDrawGulfBall(canvas);

           onDrawMarker(canvas);


         //
            // End of painting to canvas. system will paint with this canvas,to the surface.
            holder.unlockCanvasAndPost(canvas);
        }
    }

    protected void onDrawOLDSTROKES(Canvas canvas) {

        // this draws holes stored in database
        Bitmap bread = BitmapFactory.decodeResource(getResources(), R.drawable.bread);












        // This iterates through the entire arrays length
        for(int i=0; i< strokes.length;i++){
            int temp = strokes[i];

           canvas.drawBitmap(bread,strokeX[i],strokeY[i],null);

        }

    }

    protected void onDrawGulfBall(Canvas canvas) {
        Bitmap gball = BitmapFactory.decodeResource(getResources(), R.drawable.gulfball);
        // this draws ball

            for (int s = 0; s < strokeX.length; s++) {
                int tempX = strokeX[s];
                int tempY =strokeY[s];
                if (tempX > 0) {

                   // canvas.drawBitmap(gball, strokeX[s], strokeY[s], null);
                    canvas.drawBitmap(gball, tempX, tempY, null);
                }
            }

    }

    protected void onDrawMarker(Canvas canvas) {
        Bitmap gball = BitmapFactory.decodeResource(getResources(), R.drawable.gulfball);
        canvas.drawBitmap(marker, x, y, null);
        // marker is set at x, y position which is 1,1
    }

    protected void onDrawBackground(Canvas canvas) {

        // this draws the ball where the marker is on the field
          canvas.drawBitmap(backbit,0,0,null);
        // canvas.drawBitmap(backbit, 10, 10, null);

    }



    @Override
    protected void onPause() {
        super.onPause();
        pause();
    }

    private void pause() {
        //CLOSE LOCKER FOR run();
        locker = false;
        while(true){
            try {
                //WAIT UNTIL THREAD DIE, THEN EXIT WHILE LOOP AND RELEASE a thread
                thread.join();
            } catch (InterruptedException e) {e.printStackTrace();
            }
            break;
        }
        thread = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume();
    }

    private void resume() {
        //RESTART THREAD AND OPEN LOCKER FOR run();
        locker = true;
        thread = new Thread(this);
        thread.start();
    }





}
