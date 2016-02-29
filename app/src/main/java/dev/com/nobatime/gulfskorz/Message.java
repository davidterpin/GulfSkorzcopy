package dev.com.nobatime.gulfskorz;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by stickman on 4/10/15.
 */
public class Message {
    public static void message(Context context, String message){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

    }
}
