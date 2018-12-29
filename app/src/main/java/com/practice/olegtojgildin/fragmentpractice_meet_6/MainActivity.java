package com.practice.olegtojgildin.fragmentpractice_meet_6;

import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        editText = findViewById(R.id.editTextFirstFragment);

    }

    private LocalBroadcastManager mLocalBroadcastManager;

    @Override
    protected void onResume() {
        super.onResume();
        startService(MyIntentService.newIntent(MainActivity.this));
        IntentFilter iff = new IntentFilter(MyIntentService.ACTION);
        mLocalBroadcastManager.registerReceiver(mReceiver, iff);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            editText.setText(Integer.toString(intent.getIntExtra("Info", 0)));
        }
    };
}
