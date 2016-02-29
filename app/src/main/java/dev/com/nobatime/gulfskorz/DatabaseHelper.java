package dev.com.nobatime.gulfskorz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 * Created by stickman on 4/10/15.
 */
public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Gulfdata";
    private static final String TABLE_NAME = "TUT";
    private static final String TABLE_NAME_STROKES = "STROKES";
    private static final String TABLE_NAME_OLD = "OLD";
    private static final String TABLE_NAME_LOCATION = "LOCATION";



    private static final int DATABASE_VERSION = 6;
    private static final String UID = "_id ";
    private static final String NAME = "Name";
  //  private static final String ADDRESS = "ADDRESS";
    private static final String PASSWORD = "password";
    private static final String COLX = "X";
    private static final String COLY = "Y";
   private static final String CREATETHETABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), "+PASSWORD+ " VARCHAR(255) );";

     private static final String CREATETABLESTROKES = "CREATE TABLE " + TABLE_NAME_STROKES + " (" + UID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " + COLX + " VARCHAR(255)," + COLY + " VARCHAR(255) );";
             private static final String CREATETABLEOLD = "CREATE TABLE " + TABLE_NAME_OLD + " (" + UID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " + COLX + " VARCHAR(255)," + COLY + " VARCHAR(255) );";
     private static final String CREATETABLELOCATIONS = "CREATE TABLE " + TABLE_NAME_LOCATION + " (" + UID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) );";

    private static final String DROPTHETABLE="DROP TABLE IF EXISTS "+ TABLE_NAME+" "  ;
    private static final String DROPTHETABLESTROKES="DROP TABLE IF EXISTS "+ TABLE_NAME_STROKES+" "  ;
    private static final String DROPTHETABLEOLD="DROP TABLE IF EXISTS "+ TABLE_NAME_OLD+" "  ;
    private static final String DROPTHETABLELOCATION="DROP TABLE IF EXISTS "+ TABLE_NAME_LOCATION+" "  ;



    private Context context;

    public DatabaseHelper(Context context) {
        //  super(context, "", null, 1);
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        Message.message(context,"Constructor Called");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE STROKES (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255));
        //   String query="CREATE TABLE "+TABLE_NAME+" ("+UID+"INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";


        try {
            db.execSQL(CREATETHETABLE);
        //    db.execSQL(CREATETABLEOLD);
        //    db.execSQL(CREATETABLESTROKES);
        //    db.execSQL(CREATETABLELOCATIONS);



          //  db.execSQL(CREATE_TABLETWO);
            Message.message(context,"onCreate is called");
            Log.d(MainActivity.DEBUG, "SUCCESS CREATING DATABASE "+DATABASE_NAME);
        } catch (android.database.SQLException e)
        {
            Log.d(MainActivity.DEBUG, "ERROR MESSAGE " +e);
           Message.message(context,""+e);
            Log.d(MainActivity.DEBUG, "FAILURE CREATING "+DATABASE_NAME);
        }





    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    try {
        Message.message(context,"onUpgrade is called");
            db.execSQL(DROPTHETABLE);
     //   db.execSQL(DROPTHETABLEOLD);
     //   db.execSQL(DROPTHETABLESTROKES);
     //   db.execSQL(DROPTHETABLELOCATION);

        Log.d(MainActivity.DEBUG, "SUCCESS UPGRADING DATABASE "+DATABASE_NAME);
           onCreate(db);
        } catch (android.database.SQLException e)
        {
            Log.d(MainActivity.DEBUG, "ERROR MESSAGE " +e);
            Message.message(context,""+e);
            Log.d(MainActivity.DEBUG, "FAILURE UPGRADING "+DATABASE_NAME);
        }

    }
}
