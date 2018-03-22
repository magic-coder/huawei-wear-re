package com.google.android.gms.wearable;

import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.C0468m;
import com.google.android.gms.wearable.internal.aq;
import com.google.android.gms.wearable.internal.cs;
import com.google.android.gms.wearable.internal.zzbz;
import com.google.android.gms.wearable.internal.zzcc;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzk;
import com.google.android.gms.wearable.internal.zzo;
import com.google.android.gms.wearable.internal.zzs;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import java.util.List;

final class ai extends aq {
    final /* synthetic */ WearableListenerService f930a;
    private volatile int f931b;

    private ai(WearableListenerService wearableListenerService) {
        this.f930a = wearableListenerService;
        this.f931b = -1;
    }

    private boolean m1703a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f931b) {
            return true;
        }
        if (cs.m2090a(this.f930a).m2095a(NFCBaseActivity.AW_NAME_CN) && C0468m.m834a(this.f930a, callingUid, NFCBaseActivity.AW_NAME_CN)) {
            this.f931b = callingUid;
            return true;
        } else if (C0468m.m833a(this.f930a, callingUid)) {
            this.f931b = callingUid;
            return true;
        } else {
            Log.e("WearableLS", "Caller is not GooglePlayServices; caller UID: " + callingUid);
            return false;
        }
    }

    private boolean m1704a(Runnable runnable, String str, Object obj) {
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", String.format("%s: %s %s", new Object[]{str, this.f930a.f908a.toString(), obj}));
        }
        if (!m1703a()) {
            return false;
        }
        synchronized (this.f930a.f913f) {
            if (this.f930a.f914g) {
                return false;
            }
            this.f930a.f909b.post(runnable);
            return true;
        }
    }

    public void mo1914a(DataHolder dataHolder) {
        Runnable ajVar = new aj(this, dataHolder);
        try {
            String valueOf = String.valueOf(dataHolder);
            if (!m1704a(ajVar, "onDataItemChanged", new StringBuilder(String.valueOf(valueOf).length() + 18).append(valueOf).append(", rows=").append(dataHolder.getCount()).toString())) {
            }
        } finally {
            dataHolder.close();
        }
    }

    public void mo1915a(zzbz com_google_android_gms_wearable_internal_zzbz) {
        m1704a(new ak(this, com_google_android_gms_wearable_internal_zzbz), "onMessageReceived", com_google_android_gms_wearable_internal_zzbz);
    }

    public void mo1916a(zzcc com_google_android_gms_wearable_internal_zzcc) {
        m1704a(new al(this, com_google_android_gms_wearable_internal_zzcc), "onPeerConnected", com_google_android_gms_wearable_internal_zzcc);
    }

    public void mo1917a(zzh com_google_android_gms_wearable_internal_zzh) {
        m1704a(new aq(this, com_google_android_gms_wearable_internal_zzh), "onEntityUpdate", com_google_android_gms_wearable_internal_zzh);
    }

    public void mo1918a(zzk com_google_android_gms_wearable_internal_zzk) {
        m1704a(new ap(this, com_google_android_gms_wearable_internal_zzk), "onNotificationReceived", com_google_android_gms_wearable_internal_zzk);
    }

    public void mo1919a(zzo com_google_android_gms_wearable_internal_zzo) {
        m1704a(new ao(this, com_google_android_gms_wearable_internal_zzo), "onConnectedCapabilityChanged", com_google_android_gms_wearable_internal_zzo);
    }

    public void mo1920a(zzs com_google_android_gms_wearable_internal_zzs) {
        m1704a(new ar(this, com_google_android_gms_wearable_internal_zzs), "onChannelEvent", com_google_android_gms_wearable_internal_zzs);
    }

    public void mo1921a(List<zzcc> list) {
        m1704a(new an(this, list), "onConnectedNodes", list);
    }

    public void mo1922b(zzcc com_google_android_gms_wearable_internal_zzcc) {
        m1704a(new am(this, com_google_android_gms_wearable_internal_zzcc), "onPeerDisconnected", com_google_android_gms_wearable_internal_zzcc);
    }
}
