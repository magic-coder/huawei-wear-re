package com.huawei.nfc.carrera.lifecycle.swipeservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.huawei.nfc.carrera.logic.swipe.channel.ChannelCloseCallback;
import com.huawei.nfc.carrera.logic.swipe.channel.ChannelManager;
import com.huawei.nfc.carrera.logic.swipe.channel.GetDefaultCardCallback;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.util.NFCFragmentUtil;

public class TransactionChannelService extends Service implements ChannelCloseCallback, GetDefaultCardCallback {
    private static final int WAKE_LOCK_TIMEOUT = 10000;
    private static WakeLock channelSwitchWakeLock;
    private int defaultCardType = 1;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        LogX.m5475i("TransactionChannelService onCreate.");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            LogX.m5469e("TransactionChannelService, but intent is illegal.");
        } else {
            acquireWakelock();
            super.onStartCommand(intent, i, i2);
            LogX.m5475i("TransactionChannelService onStartCommand");
            ChannelManager.getInstance(getApplicationContext()).getDefaultCard(this);
        }
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        LogX.m5475i("TransactionChannelService onDestroy.");
    }

    private void acquireWakelock() {
        if (channelSwitchWakeLock == null) {
            channelSwitchWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "channelWakeLock");
            channelSwitchWakeLock.setReferenceCounted(false);
        }
        channelSwitchWakeLock.acquire(10000);
    }

    private void releaseWakelock() {
        if (channelSwitchWakeLock != null) {
            LogX.m5465d("release the wake lock now.");
            if (channelSwitchWakeLock.isHeld()) {
                channelSwitchWakeLock.release();
            }
        }
    }

    private void operateTransactionChannel() {
        LogX.m5465d("operateTransactionChannel default card type " + this.defaultCardType);
        if (this.defaultCardType == 1) {
            ChannelManager.getInstance(getApplicationContext()).disableTransactionChannel(this.defaultCardType, this);
        } else if (NFCFragmentUtil.isPhoneSupportShutdownSwipe()) {
            LogX.m5475i("operateTransactionChannel support shutdown swipe.");
        } else {
            LogX.m5475i("operateTransactionChannel not support shutdown swipe.");
            ChannelManager.getInstance(getApplicationContext()).disableCardEmulation(this);
        }
    }

    public void closeChannelResult(boolean z) {
        LogX.m5465d("close channel background result: " + z);
        close();
    }

    public void getDefaultCardCallback(TACardInfo tACardInfo) {
        if (tACardInfo == null) {
            LogX.m5469e("TransactionChannelService getDefaultCardCallback defaultCard == null");
            close();
            return;
        }
        this.defaultCardType = tACardInfo.cardGroupType;
        operateTransactionChannel();
    }

    private void close() {
        releaseWakelock();
        stopSelf();
    }
}
