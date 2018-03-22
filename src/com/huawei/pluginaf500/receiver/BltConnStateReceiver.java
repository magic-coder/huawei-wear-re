package com.huawei.pluginaf500.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.huawei.pluginaf500.ui.C5793b;

public class BltConnStateReceiver extends BroadcastReceiver {
    private Handler f19636a;

    public BltConnStateReceiver(Handler handler) {
        this.f19636a = handler;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (action.equals("com.fenda.hwbracelet.ALARM_SET_FAIL")) {
            m26589a(C5793b.BT_ALARM_SYN_FAIL.m26879a());
        } else if (action.equals("com.fenda.hwbracelet.ALARM_SET_SUCCESS")) {
            m26589a(C5793b.BT_ALARM_SYN_SUCCESS.m26879a());
        } else if (action.equals("com.fenda.hwbracelet.SLEEP_REMIND_SET_FAIL")) {
            m26589a(C5793b.BT_SET_SLEEP_SYN_FAIL.m26879a());
        } else if (action.equals("com.fenda.hwbracelet.SLEEP_REMIND_SET_SUCCESS")) {
            m26589a(C5793b.BT_SET_SLEEP_SYN_SUCCESS.m26879a());
        } else if (action.equals("com.fenda.hwbracelet.SPORT_REMIND_SET_FAIL")) {
            m26589a(C5793b.BT_SET_SPORT_SYN_FAIL.m26879a());
        } else if (action.equals("com.fenda.hwbracelet.SPORT_REMIND_SET_SUCCESS")) {
            m26589a(C5793b.BT_SET_SPORT_SYN_SUCCESS.m26879a());
        } else if (action.equals("com.colorband.dispaly_state")) {
            m26589a(C5793b.BC_DISPLAY_STAE.m26879a());
        } else if (action.equals("com.colorband.gesture_state")) {
            m26589a(C5793b.BC_GESTURE_STATE.m26879a());
        } else if (action.equals("com.fenda.hwbracelet.CONNECTION_STATE")) {
            m26589a(intent.getIntExtra("com.fenda.hwbracelet.XB_CONNECTION_STATE", 0));
        }
    }

    private void m26589a(int i) {
        this.f19636a.sendMessage(this.f19636a.obtainMessage(i));
    }
}
