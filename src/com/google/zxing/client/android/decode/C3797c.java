package com.google.zxing.client.android.decode;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.zxing.C3709a;
import com.google.zxing.C3803p;
import com.google.zxing.C3880e;
import com.google.zxing.client.android.CaptureActivity;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: DecodeThread */
final class C3797c extends Thread {
    private final CaptureActivity f14772a;
    private final Map<C3880e, Object> f14773b = new EnumMap(C3880e.class);
    private Handler f14774c;
    private final CountDownLatch f14775d = new CountDownLatch(1);

    C3797c(CaptureActivity captureActivity, Collection<C3709a> collection, Map<C3880e, ?> map, String str, C3803p c3803p) {
        this.f14772a = captureActivity;
        if (map != null) {
            this.f14773b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(captureActivity);
            collection = EnumSet.noneOf(C3709a.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D", false)) {
                collection.addAll(C3796b.f14768b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", false)) {
                collection.addAll(C3796b.f14769c);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", false)) {
                collection.addAll(C3796b.f14770d);
            }
        }
        this.f14773b.put(C3880e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f14773b.put(C3880e.CHARACTER_SET, str);
        }
        this.f14773b.put(C3880e.NEED_RESULT_POINT_CALLBACK, c3803p);
        Log.i("DecodeThread", "Hints: " + this.f14773b);
    }

    Handler m19030a() {
        try {
            this.f14775d.await();
        } catch (InterruptedException e) {
        }
        return this.f14774c;
    }

    public void run() {
        Looper.prepare();
        this.f14774c = new DecodeHandler(this.f14772a, this.f14773b);
        this.f14775d.countDown();
        Looper.loop();
    }
}
