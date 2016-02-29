package dev.com.nobatime.gulfskorz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Point;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.List;

/**
 * Created by stickman on 4/8/15.
 */


 public final class Database {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public Database() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

    }
}