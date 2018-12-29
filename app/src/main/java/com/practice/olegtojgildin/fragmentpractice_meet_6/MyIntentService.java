package com.practice.olegtojgildin.fragmentpractice_meet_6;

import android.app.IntentService;

/**
 * Created by olegtojgildin on 29/12/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import java.util.concurrent.TimeUnit;


public class MyIntentService extends IntentService {

    public static final Intent newIntent(Context context) {
        return new Intent(context, MyIntentService.class);
    }

    public static final String ACTION = "sendInfo";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent arg0) {
        for (int i = 0; i < 1000; i++) {
            Intent in = new Intent(ACTION);
            in.putExtra("Info", i);
            LocalBroadcastManager.getInstance(this).sendBroadcast(in);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}