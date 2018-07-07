package com.andyshon.detectionphonecalls;

import android.content.Context;

import java.util.Date;

/**
 * Created by andyshon on 07.07.18.
 */

public class CallReceiver extends IncomingCall{

    public CallReceiver() {}


    @Override
    public void onIncomingCallReceived(Context ctx, String number, Date start)
    {
        MainActivity.onIncomingCallReceived(ctx, number, start);
    }


    @Override
    public void onIncomingCallAnswered(Context ctx, String number, Date start)
    {
        MainActivity.onIncomingCallAnswered(ctx, number, start);
    }


    @Override
    public void onIncomingCallEnded(Context ctx, String number, Date start, Date end)
    {
        MainActivity.onIncomingCallEnded(ctx, number, start, end);
    }


    @Override
    public void onOutgoingCallStarted(Context ctx, String number, Date start)
    {
        MainActivity.onOutgoingCallStarted(ctx, number, start);
    }


    @Override
    public void onOutgoingCallEnded(Context ctx, String number, Date start, Date end)
    {
        MainActivity.onOutgoingCallEnded(ctx, number, start, end);
    }


    @Override
    public void onMissedCall(Context ctx, String number, Date start)
    {
        MainActivity.onMissedCall(ctx, number, start);
    }

}
