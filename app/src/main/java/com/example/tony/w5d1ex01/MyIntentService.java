package com.example.tony.w5d1ex01;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.widget.TextView;

/**
 * Created by tony on 8/14/17.
 */

public class MyIntentService extends IntentService{
    public static final String RESULT_MESSAGE="com.example.tony.w5d1ex01_RESULT_MESSAGE";
    public static final String INPUT_MESSAGE="com.example.tony.w5d1ex01_INPUT_MESSAGE";
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String msg= intent.getStringExtra(INPUT_MESSAGE);

        SystemClock.sleep(10000);//10 seconds

        String result=msg+""+ DateFormat.format("MM/dd/yy h:mmaa",
                System.currentTimeMillis());
        Intent broadcast= new Intent();
        broadcast.setAction(MainActivity.MyReceiver.ACTION_RESPOND);
        broadcast.addCategory(Intent.CATEGORY_DEFAULT);
        broadcast.putExtra(RESULT_MESSAGE,result);
        sendBroadcast(broadcast);
    }
}
