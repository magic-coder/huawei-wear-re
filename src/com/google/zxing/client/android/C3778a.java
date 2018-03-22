package com.google.zxing.client.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.google.zxing.client.android.p286a.C3775e;
import com.google.zxing.client.android.p286a.C3776f;

/* compiled from: AmbientLightManager */
public final class C3778a implements SensorEventListener {
    private final Context f14715a;
    private C3775e f14716b;
    private Sensor f14717c;

    public C3778a(Context context) {
        this.f14715a = context;
    }

    public void m19003a(C3775e c3775e) {
        this.f14716b = c3775e;
        if (C3776f.m18999a(PreferenceManager.getDefaultSharedPreferences(this.f14715a)) == C3776f.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f14715a.getSystemService("sensor");
            this.f14717c = sensorManager.getDefaultSensor(5);
            if (this.f14717c != null) {
                sensorManager.registerListener(this, this.f14717c, 3);
            }
        }
    }

    public void m19002a() {
        if (this.f14717c != null) {
            ((SensorManager) this.f14715a.getSystemService("sensor")).unregisterListener(this);
            this.f14716b = null;
            this.f14717c = null;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.f14716b == null) {
            return;
        }
        if (f <= 45.0f) {
            this.f14716b.m18992a(true);
        } else if (f >= 450.0f) {
            this.f14716b.m18992a(false);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
