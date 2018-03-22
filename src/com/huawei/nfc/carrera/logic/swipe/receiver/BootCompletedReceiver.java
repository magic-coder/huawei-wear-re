package com.huawei.nfc.carrera.logic.swipe.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.util.LogX;

public class BootCompletedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        LogX.i("start service after boot to check channel now.");
    }
}
