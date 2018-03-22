package com.huawei.nfc.carrera.logic.swipe.channel;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.lifecycle.swipeservice.TransactionChannelService;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.util.LogX;

public class ChannelManager {
    private static final long CHANNEL_AVAILABLE_TIMEOUT = 65000;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static ChannelManager instance;
    private Handler channelHandler;
    private Context context;
    private Handler uiHandler;

    private ChannelManager(Context context) {
        this.context = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("channel_switch_handlers");
        handlerThread.start();
        this.channelHandler = new ChannelStateSwitchHandler(context, handlerThread.getLooper());
        this.uiHandler = new Handler(context.getMainLooper());
    }

    public static ChannelManager getInstance(Context context) {
        ChannelManager channelManager;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new ChannelManager(context);
            }
            channelManager = instance;
        }
        return channelManager;
    }

    public void enableTransactionChannelByFpPwd(int i, ChannelOpenCallback channelOpenCallback) {
        LogX.m5475i("enableTransactionChannelByFpPwd");
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = channelOpenCallback;
        this.channelHandler.sendMessage(obtain);
    }

    public void enableTransactionChannelByPayPwd(int i, ChannelOpenCallback channelOpenCallback) {
        LogX.m5475i("enableTransactionChannelByPayPwd");
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i;
        obtain.obj = channelOpenCallback;
        this.channelHandler.sendMessage(obtain);
    }

    public void disableTransactionChannel(int i, ChannelCloseCallback channelCloseCallback) {
        LogX.m5475i("disableTransactionChannel");
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i;
        obtain.obj = channelCloseCallback;
        this.channelHandler.sendMessage(obtain);
    }

    public void setDefaultCard(String str, SetDefaultCardCallback setDefaultCardCallback) {
        LogX.m5475i("ChannelManager setDefaultCard");
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.arg1 = 81;
        obtain.obj = new Object[]{str, setDefaultCardCallback};
        this.channelHandler.sendMessage(obtain);
    }

    public void getDefaultCard(GetDefaultCardCallback getDefaultCardCallback) {
        LogX.m5475i("ChannelManager getDefaultCard");
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = getDefaultCardCallback;
        this.channelHandler.sendMessage(obtain);
    }

    public void enableCardEmulation(ChannelOpenCallback channelOpenCallback) {
        LogX.m5475i("enableCardEmulation");
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = channelOpenCallback;
        this.channelHandler.sendMessage(obtain);
    }

    public void disableCardEmulation(ChannelCloseCallback channelCloseCallback) {
        LogX.m5475i("disableCardEmulation");
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = channelCloseCallback;
        this.channelHandler.sendMessage(obtain);
    }

    public void setDefaultCardRFConf(int i, boolean z) {
        LogX.m5475i("ChannelManager setDefaultCardRFConf");
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.arg1 = 83;
        obtain.obj = new Object[]{Integer.valueOf(i), Boolean.valueOf(z)};
        this.channelHandler.sendMessage(obtain);
    }

    void channelOpenCallback(ChannelOpenCallback channelOpenCallback, boolean z, int i) {
        if (z) {
            LogX.m5475i("open channel success, set timeout alarm.");
            sendTimeoutAlarm();
        }
        if (channelOpenCallback == null) {
            LogX.m5465d("channelOpenCallback, no need to handle the result");
        } else {
            this.uiHandler.post(new ChannelOpenResultRunnable(channelOpenCallback, z));
        }
    }

    void channelCloseCallback(ChannelCloseCallback channelCloseCallback, boolean z, int i) {
        if (z) {
            LogX.m5475i("close channel success, cancel timeout alarm.");
            cancelTimeoutAlarm();
        }
        if (channelCloseCallback == null) {
            LogX.m5465d("channelOpenCallback, no need to handle the result");
        } else {
            this.uiHandler.post(new ChannelCloseResultRunnable(channelCloseCallback, z));
        }
    }

    void setDefaultCardCallback(SetDefaultCardCallback setDefaultCardCallback, boolean z) {
        if (setDefaultCardCallback != null) {
            setDefaultCardCallback.setDefaultCardCallback(z);
        }
    }

    void getDefaultCardCallback(GetDefaultCardCallback getDefaultCardCallback, TACardInfo tACardInfo) {
        if (getDefaultCardCallback == null) {
            LogX.m5465d("ChannelManager getDefaultCardCallback, no need to handle the result");
        } else {
            this.uiHandler.post(new GetDefaultCardCallbackRunnable(getDefaultCardCallback, tACardInfo));
        }
    }

    private void sendTimeoutAlarm() {
        AlarmManager alarmManager = (AlarmManager) this.context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(this.context, 0, new Intent(this.context, TransactionChannelService.class), HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        alarmManager.cancel(service);
        alarmManager.set(2, SystemClock.elapsedRealtime() + CHANNEL_AVAILABLE_TIMEOUT, service);
    }

    private void cancelTimeoutAlarm() {
        ((AlarmManager) this.context.getSystemService("alarm")).cancel(PendingIntent.getService(this.context, 0, new Intent(this.context, TransactionChannelService.class), HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR));
    }
}
