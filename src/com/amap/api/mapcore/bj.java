package com.amap.api.mapcore;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.RemoteException;
import android.view.WindowManager;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Marker;

/* compiled from: SensorEventHelper */
public class bj implements SensorEventListener {
    private SensorManager f11092a;
    private Sensor f11093b;
    private long f11094c = 0;
    private final int f11095d = 100;
    private float f11096e;
    private Context f11097f;
    private aa f11098g;
    private Marker f11099h;

    public bj(Context context, aa aaVar) {
        this.f11097f = context;
        this.f11098g = aaVar;
        this.f11092a = (SensorManager) context.getSystemService("sensor");
        this.f11093b = this.f11092a.getDefaultSensor(3);
    }

    public void m15083a() {
        this.f11092a.registerListener(this, this.f11093b, 3);
    }

    public void m15085b() {
        this.f11092a.unregisterListener(this, this.f11093b);
    }

    public void m15084a(Marker marker) {
        this.f11099h = marker;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (System.currentTimeMillis() - this.f11094c >= 100 && this.f11098g.mo3750S().m15311a()) {
            switch (sensorEvent.sensor.getType()) {
                case 3:
                    float a = (sensorEvent.values[0] + ((float) m15082a(this.f11097f))) % 360.0f;
                    if (a > BitmapDescriptorFactory.HUE_CYAN) {
                        a -= 360.0f;
                    } else if (a < -180.0f) {
                        a += 360.0f;
                    }
                    if (Math.abs(this.f11096e - a) >= 3.0f) {
                        if (Float.isNaN(a)) {
                            a = 0.0f;
                        }
                        this.f11096e = a;
                        if (this.f11099h != null) {
                            try {
                                this.f11098g.mo3776a(C3259o.m15340d(this.f11096e));
                                this.f11099h.setRotateAngle(-this.f11096e);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                        this.f11094c = System.currentTimeMillis();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static int m15082a(Context context) {
        switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return -90;
            default:
                return 0;
        }
    }
}
