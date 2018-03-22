package cn.com.xy.sms.sdk.p206b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.AssetManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2942i;
import cn.com.xy.sms.sdk.p208d.p211c.C2943j;
import cn.com.xy.sms.sdk.p215g.C2982a;
import com.amap.api.location.LocationManagerProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class C2916a {
    public static String m13091a(int i, Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "";
            }
            List runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return "";
            }
            RunningAppProcessInfo runningAppProcessInfo;
            Iterator it = runningAppProcesses.iterator();
            do {
                if (!it.hasNext()) {
                    return "";
                }
                runningAppProcessInfo = (RunningAppProcessInfo) it.next();
            } while (runningAppProcessInfo.pid != i);
            return runningAppProcessInfo.processName;
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "getCurProcessName error: " + th.getMessage(), th);
        }
    }

    public int m13092a(Context context) {
        return 0;
    }

    public AssetManager m13093a() {
        return null;
    }

    public JSONArray m13094a(String str, long j) {
        return null;
    }

    public JSONObject m13095a(int i) {
        Throwable th;
        String b = m13102b(i);
        if (b == null) {
            return null;
        }
        JSONObject jSONObject;
        try {
            C2942i a = C2943j.m13260a(b, C2917a.m13105a());
            if (a != null) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("provice", a.f9987i);
                    jSONObject.put("sp", a.f9988j);
                } catch (Throwable th2) {
                    th = th2;
                    C2982a.m13415a("XIAOYUAN", "getProviceAndSP: " + th.getMessage(), th);
                    return jSONObject;
                }
            }
            jSONObject = null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            jSONObject = null;
            th = th4;
            C2982a.m13415a("XIAOYUAN", "getProviceAndSP: " + th.getMessage(), th);
            return jSONObject;
        }
        return jSONObject;
    }

    public void m13096a(int i, Map<String, Object> map) {
    }

    public void m13097a(Context context, int i) {
    }

    public void m13098a(Context context, Handler handler) {
        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER)) {
            Location lastKnownLocation;
            Criteria criteria = new Criteria();
            criteria.setAccuracy(2);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(3);
            criteria.setSpeedRequired(false);
            Location lastKnownLocation2 = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            if (lastKnownLocation2 == null) {
                lastKnownLocation = locationManager.getLastKnownLocation(LocationManagerProxy.NETWORK_PROVIDER);
                new StringBuilder().append(lastKnownLocation);
                if (lastKnownLocation == null) {
                    handler.obtainMessage(4100).sendToTarget();
                    return;
                }
            }
            lastKnownLocation = lastKnownLocation2;
            Message obtainMessage = handler.obtainMessage(4102);
            Bundle bundle = new Bundle();
            bundle.putDouble("latitude", lastKnownLocation.getLatitude());
            bundle.putDouble("longitude", lastKnownLocation.getLongitude());
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            return;
        }
        handler.obtainMessage(4100).sendToTarget();
    }

    public void m13099a(String str, String str2, Throwable th) {
    }

    public void m13100a(String str, String str2, Map<String, Object> map) {
    }

    public boolean m13101a(Context context, String str) {
        return false;
    }

    public String m13102b(int i) {
        return null;
    }

    public String m13103b(int i, Map map) {
        switch (i) {
            case 1:
                return "cn.com.xy.sms.sdk.ui.popu.util.ViewManger";
            case 2:
                return "cn.com.xy.sms.sdk.ui.popu.web.SdkWebActivity";
            case 3:
                return "cn.com.xy.sms.sdk.ui.config.UIConfig";
            default:
                return null;
        }
    }

    public JSONObject m13104c(int i) {
        return null;
    }
}
