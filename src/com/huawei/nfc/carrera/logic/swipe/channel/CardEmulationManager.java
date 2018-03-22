package com.huawei.nfc.carrera.logic.swipe.channel;

import android.content.Context;
import android.content.IntentFilter;
import com.huawei.nfc.carrera.logic.swipe.receiver.FieldOffDetectedReceiver;
import com.huawei.nfc.carrera.logic.swipe.receiver.SwipeFieldOffListener;
import com.huawei.nfc.carrera.logic.util.timeout.TimeoutListener;
import com.huawei.nfc.carrera.logic.util.timeout.TimeoutTimer;
import com.huawei.nfc.carrera.util.LogX;

public final class CardEmulationManager implements SwipeFieldOffListener, TimeoutListener {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final int WAIT_TIMEOUT = 6000;
    private static volatile CardEmulationManager instance;
    private FieldOffDetectedReceiver fieldOffReceiver;
    private Context mContext;
    private TimeoutTimer timer;

    private CardEmulationManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static CardEmulationManager getInstance(Context context) {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new CardEmulationManager(context);
                }
            }
        }
        return instance;
    }

    public void startListenFieldOff() {
        LogX.i("startListenFieldOff");
        if (this.fieldOffReceiver == null) {
            this.fieldOffReceiver = new FieldOffDetectedReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(FieldOffDetectedReceiver.ACTION_RF_FIELD_OFF_DETECTED);
            this.mContext.registerReceiver(this.fieldOffReceiver, intentFilter);
        }
        if (this.timer == null) {
            this.timer = new TimeoutTimer(WAIT_TIMEOUT, this);
        }
        this.timer.startTimer();
    }

    public void stopListenFieldOff() {
        LogX.i("stopListenFieldOff");
        if (this.timer != null) {
            this.timer.stopTimer();
            this.timer = null;
        }
        if (this.fieldOffReceiver != null) {
            this.mContext.unregisterReceiver(this.fieldOffReceiver);
            this.fieldOffReceiver = null;
        }
    }

    private void stopListenAndDisableEmulation() {
        LogX.i("stopListenAndDisableEmulation");
        stopListenFieldOff();
        ChannelManager.getInstance(this.mContext).disableCardEmulation(null);
    }

    public void fieldOff() {
        LogX.i("CardEmulationManager fieldOff");
        stopListenAndDisableEmulation();
    }

    public void timeout() {
        LogX.i("CardEmulationManager timeout");
        stopListenAndDisableEmulation();
    }
}
