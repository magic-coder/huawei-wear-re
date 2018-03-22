package com.huawei.android.pushselfshow.richpush.p341c.p342a;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Handler;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.p341c.p343b.C4181b;
import com.huawei.android.pushselfshow.richpush.p341c.p343b.C4188i;
import com.huawei.android.pushselfshow.richpush.p341c.p343b.C4189j;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class C4171a implements SensorEventListener {
    public SoundPool f15673a = null;
    public boolean f15674b = false;
    private SensorManager f15675c;
    private Activity f15676d;
    private String f15677e;
    private C4181b f15678f;
    private float f15679g = 0.0f;
    private float f15680h = 0.0f;
    private float f15681i = 0.0f;
    private long f15682j = 0;
    private int f15683k;
    private int f15684l = 0;
    private int f15685m;
    private int f15686n;
    private int f15687o;
    private int f15688p;
    private long f15689q = 0;
    private Handler f15690r = null;
    private Runnable f15691s = new C4172b(this);

    public C4171a(Activity activity) {
        m20344a(0);
        this.f15675c = (SensorManager) activity.getSystemService("sensor");
        this.f15676d = activity;
    }

    private void m20343a() {
        if (this.f15683k == 1) {
            m20344a(3);
            m20346a(C4189j.ACCL_CAN_NOT_START);
        }
    }

    private void m20344a(int i) {
        this.f15683k = i;
    }

    private void m20346a(C4189j c4189j) {
        try {
            e.e("PushSelfShowLog", " accelListener fail,the status is " + C4188i.m20377a()[c4189j.ordinal()]);
            this.f15678f.m20372a(this.f15677e, c4189j, HwAccountConstants.EXTRA_OPLOG_ERROR, null);
        } catch (RuntimeException e) {
            e.e("PushSelfShowLog", " accelListener fail error");
        } catch (Exception e2) {
            e.e("PushSelfShowLog", " accelListener fail error");
        }
    }

    private void m20347b() {
        e.e("PushSelfShowLog", " accelListener success");
        this.f15678f.m20372a(this.f15677e, C4189j.f15754a, LightCloudConstants.RESPONSE_RESULT_SUCCESS, m20348c());
    }

    private JSONObject m20348c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) this.f15679g);
            jSONObject.put("y", (double) this.f15680h);
            jSONObject.put("z", (double) this.f15681i);
            jSONObject.put("timestamp", this.f15682j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        if (sensor.getType() == 1 && this.f15683k != 0) {
            this.f15684l = i;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && this.f15674b && this.f15683k != 0) {
            m20344a(2);
            if (this.f15684l >= this.f15685m) {
                this.f15679g = sensorEvent.values[0];
                this.f15680h = sensorEvent.values[1];
                this.f15681i = sensorEvent.values[2];
                this.f15682j = System.currentTimeMillis();
                if (Math.abs(this.f15679g) > ((float) this.f15686n) || Math.abs(this.f15680h) > ((float) this.f15687o) || Math.abs(this.f15681i) > ((float) this.f15688p)) {
                    e.b("PushSelfShowLog", "onSensorChanged and x = %s , y=%s , z=%s ", new Object[]{Float.valueOf(this.f15679g), Float.valueOf(this.f15680h), Float.valueOf(this.f15681i)});
                    m20347b();
                }
            }
        }
    }
}
