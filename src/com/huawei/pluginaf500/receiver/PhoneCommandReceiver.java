package com.huawei.pluginaf500.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.ITelephony;
import com.huawei.p190v.C2538c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PhoneCommandReceiver extends BroadcastReceiver {
    private ITelephony f2961a;
    private AudioManager f2962b;

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                this.f2962b = (AudioManager) context.getSystemService("audio");
                try {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getITelephony", (Class[]) null);
                    declaredMethod.setAccessible(true);
                    this.f2961a = (ITelephony) declaredMethod.invoke(telephonyManager, (Object[]) null);
                } catch (NoSuchMethodException e) {
                } catch (IllegalAccessException e2) {
                } catch (IllegalArgumentException e3) {
                } catch (InvocationTargetException e4) {
                }
                if ("com.fenda.hwbracelet.PHONE_CALL_MUTE".equals(action)) {
                    int ringerMode = this.f2962b.getRingerMode();
                    this.f2962b.setRingerMode(0);
                    C1375a.m6156a().m6161a(new C1376d(this, ringerMode));
                } else if ("com.fenda.hwbracelet.PHONE_CALL_REJECT".equals(action)) {
                    C1375a.m6156a().m6162b();
                    try {
                        this.f2961a.endCall();
                    } catch (RemoteException e5) {
                    }
                }
            } catch (Exception e6) {
                C2538c.m12680e("PhoneCommandReceiver", "onReceive exception  =" + e6.getMessage());
            }
        }
    }
}
