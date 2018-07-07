package com.andyshon.detectionphonecalls;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CallReceiver myReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        setReceiver();
        super.onStart();
    }


    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
        super.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }


    private void setReceiver() {
        myReceiver = new CallReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, intentFilter);
    }


    public static void onIncomingCallReceived(Context ctx, String number, Date start) {
        Toast.makeText(ctx, "Incoming call: " + number, Toast.LENGTH_LONG).show();
    }


    public static void onIncomingCallAnswered(Context ctx, String number, Date start) {
        Toast.makeText(ctx, "You just answered on call " + number, Toast.LENGTH_SHORT).show();
    }


    public static void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        StringBuilder time = new StringBuilder(String.valueOf(end.getTime() - start.getTime()));
        time.insert(time.length()-3, ",").append(" sec");
        Toast.makeText(ctx, "Incoming call ended: " + time, Toast.LENGTH_LONG).show();
        System.out.println("Incoming call ended: " + time);
    }


    public static void onMissedCall(Context ctx, String number, Date start) {
        Toast.makeText(ctx, "You missed a call!\n" + number, Toast.LENGTH_LONG).show();
    }


    public static void onOutgoingCallStarted(Context ctx, String number, Date start) {
        Toast.makeText(ctx, "You started call to " + number, Toast.LENGTH_LONG).show();
    }


    public static void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
        StringBuilder time = new StringBuilder(String.valueOf(end.getTime() - start.getTime()));
        time.insert(time.length()-3, ",").append(" sec");
        Toast.makeText(ctx, "You ended call after " + time, Toast.LENGTH_LONG).show();
    }

}
