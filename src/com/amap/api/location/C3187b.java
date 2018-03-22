package com.amap.api.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.C3189a;
import com.amap.api.location.core.C3191c;
import com.amap.api.location.core.C3192d;
import com.aps.bh;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AMapWeather */
public class C3187b implements AMapLocationListener {
    C3186a f10656a = null;
    AMapLocalWeatherListener f10657b;
    C3184a f10658c;
    List<Integer> f10659d = new ArrayList();
    List<AMapLocalWeatherListener> f10660e = new ArrayList();
    private Context f10661f;
    private int f10662g;
    private AMapLocalWeatherListener f10663h;
    private boolean f10664i = false;

    /* compiled from: AMapWeather */
    class C3186a extends Handler {
        private WeakReference<C3187b> f10655a;

        C3186a(C3187b c3187b, Looper looper) {
            super(looper);
            try {
                this.f10655a = new WeakReference(c3187b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                final C3187b c3187b = (C3187b) this.f10655a.get();
                switch (message.what) {
                    case 1:
                        if (c3187b.f10657b != null) {
                            c3187b.f10657b.onWeatherLiveSearched((AMapLocalWeatherLive) message.obj);
                            return;
                        }
                        return;
                    case 2:
                        if (c3187b.f10657b != null) {
                            c3187b.f10657b.onWeatherForecaseSearched((AMapLocalWeatherForecast) message.obj);
                            return;
                        }
                        return;
                    case 3:
                        final AMapLocation aMapLocation = (AMapLocation) message.obj;
                        new Thread(this) {
                            final /* synthetic */ C3186a f10654c;

                            public void run() {
                                int i = 0;
                                while (i < c3187b.f10659d.size()) {
                                    try {
                                        if (((Integer) c3187b.f10659d.get(i)).intValue() == 1) {
                                            c3187b.m14089a(aMapLocation, "base", (AMapLocalWeatherListener) c3187b.f10660e.get(i));
                                        }
                                        if (((Integer) c3187b.f10659d.get(i)).intValue() == 2) {
                                            c3187b.m14089a(aMapLocation, "all", (AMapLocalWeatherListener) c3187b.f10660e.get(i));
                                        }
                                        i++;
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                        return;
                                    }
                                }
                                c3187b.f10659d.clear();
                                c3187b.f10660e.clear();
                            }
                        }.start();
                        return;
                    case 4:
                        try {
                            AMapLocException aMapLocException = (AMapLocException) message.obj;
                            for (int i = 0; i < c3187b.f10659d.size(); i++) {
                                try {
                                    if (((Integer) c3187b.f10659d.get(i)).intValue() == 1) {
                                        AMapLocalWeatherLive aMapLocalWeatherLive = new AMapLocalWeatherLive();
                                        aMapLocalWeatherLive.m14050a(aMapLocException);
                                        ((AMapLocalWeatherListener) c3187b.f10660e.get(i)).onWeatherLiveSearched(aMapLocalWeatherLive);
                                    }
                                    if (((Integer) c3187b.f10659d.get(i)).intValue() == 2) {
                                        AMapLocalWeatherForecast aMapLocalWeatherForecast = new AMapLocalWeatherForecast();
                                        aMapLocalWeatherForecast.m14047a(aMapLocException);
                                        ((AMapLocalWeatherListener) c3187b.f10660e.get(i)).onWeatherForecaseSearched(aMapLocalWeatherForecast);
                                    }
                                } catch (Throwable th) {
                                }
                            }
                            c3187b.f10659d.clear();
                            c3187b.f10660e.clear();
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable th22) {
                th22.printStackTrace();
            }
            th22.printStackTrace();
        }
    }

    public C3187b(C3184a c3184a, Context context) {
        this.f10661f = context;
        this.f10658c = c3184a;
        this.f10656a = new C3186a(this, context.getMainLooper());
    }

    void m14088a(int i, AMapLocalWeatherListener aMapLocalWeatherListener, AMapLocation aMapLocation) {
        try {
            this.f10662g = i;
            this.f10663h = aMapLocalWeatherListener;
            if (aMapLocation == null) {
                if (this.f10659d != null) {
                    this.f10659d.add(Integer.valueOf(this.f10662g));
                }
                if (this.f10660e != null) {
                    this.f10660e.add(this.f10663h);
                }
                if (!this.f10664i) {
                    this.f10664i = true;
                    this.f10658c.m14074a(-1, 10.0f, (AMapLocationListener) this, LocationProviderProxy.AMapNetwork, true);
                    return;
                }
                return;
            }
            if (i == 1) {
                m14089a(aMapLocation, "base", aMapLocalWeatherListener);
            }
            if (i == 2) {
                m14089a(aMapLocation, "all", aMapLocalWeatherListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void m14089a(AMapLocation aMapLocation, String str, AMapLocalWeatherListener aMapLocalWeatherListener) throws Exception {
        this.f10657b = aMapLocalWeatherListener;
        if (aMapLocation != null) {
            AMapLocException aMapLocException;
            byte[] a = m14085a(aMapLocation, str);
            String a2 = m14084a();
            AMapLocException aMapLocException2 = new AMapLocException();
            String str2 = null;
            try {
                str2 = bh.m17409a().m17417a(this.f10661f, a2, a, "sea");
            } catch (AMapLocException e) {
                aMapLocException2 = e;
            }
            if ("base".equals(str)) {
                AMapLocalWeatherLive a3;
                if (str2 != null) {
                    aMapLocException = aMapLocException2;
                    a3 = m14083a(str2, aMapLocation);
                } else {
                    a3 = new AMapLocalWeatherLive();
                    aMapLocException = new AMapLocException("http连接失败 - ConnectionException");
                }
                a3.m14050a(aMapLocException);
                a3.setCity(aMapLocation.getCity());
                a3.setCityCode(aMapLocation.getCityCode());
                a3.setProvince(aMapLocation.getProvince());
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = a3;
                this.f10656a.sendMessage(obtain);
            } else {
                aMapLocException = aMapLocException2;
            }
            if ("all".equals(str)) {
                AMapLocalWeatherForecast b;
                if (str2 != null) {
                    b = m14086b(str2, aMapLocation);
                } else {
                    b = new AMapLocalWeatherForecast();
                    aMapLocException = new AMapLocException("http连接失败 - ConnectionException");
                }
                b.m14047a(aMapLocException);
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                obtain2.obj = b;
                this.f10656a.sendMessage(obtain2);
            }
        }
    }

    private byte[] m14085a(AMapLocation aMapLocation, String str) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&ec=1").append("&extensions=" + str).append("&city=").append(aMapLocation.getAdCode());
        stringBuffer.append("&key=" + C3191c.m14120a());
        return C3189a.m14109b(C3189a.m14107a(stringBuffer.toString())).getBytes("utf-8");
    }

    private String m14084a() {
        return "http://restapi.amap.com/v3/weather/weatherInfo?";
    }

    private AMapLocalWeatherLive m14083a(String str, AMapLocation aMapLocation) throws JSONException {
        AMapLocalWeatherLive aMapLocalWeatherLive = new AMapLocalWeatherLive();
        try {
            C3192d.m14143a(str);
        } catch (AMapLocException e) {
            aMapLocalWeatherLive.m14050a(e);
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("lives");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                String a = m14087a(jSONObject, "weather");
                String a2 = m14087a(jSONObject, "temperature");
                String a3 = m14087a(jSONObject, "winddirection");
                String a4 = m14087a(jSONObject, "windpower");
                String a5 = m14087a(jSONObject, "humidity");
                String a6 = m14087a(jSONObject, "reporttime");
                aMapLocalWeatherLive.m14051a(a);
                aMapLocalWeatherLive.m14056f(a6);
                aMapLocalWeatherLive.m14055e(a5);
                aMapLocalWeatherLive.m14052b(a2);
                aMapLocalWeatherLive.m14053c(a3);
                aMapLocalWeatherLive.m14054d(a4);
                aMapLocalWeatherLive.setCity(aMapLocation.getCity());
                aMapLocalWeatherLive.setCityCode(aMapLocation.getCityCode());
                aMapLocalWeatherLive.setProvince(aMapLocation.getProvince());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aMapLocalWeatherLive;
    }

    private AMapLocalWeatherForecast m14086b(String str, AMapLocation aMapLocation) throws JSONException {
        AMapLocalWeatherForecast aMapLocalWeatherForecast = new AMapLocalWeatherForecast();
        try {
            C3192d.m14143a(str);
        } catch (AMapLocException e) {
            aMapLocalWeatherForecast.m14047a(e);
            e.printStackTrace();
        }
        JSONArray jSONArray = new JSONObject(str).getJSONArray("forecasts");
        if (jSONArray != null && jSONArray.length() > 0) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(0);
            aMapLocalWeatherForecast.m14048a(m14087a(jSONObject, "reporttime"));
            JSONArray jSONArray2 = jSONObject.getJSONArray("casts");
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                List arrayList = new ArrayList();
                for (int i = 0; i < jSONArray2.length(); i++) {
                    AMapLocalDayWeatherForecast aMapLocalDayWeatherForecast = new AMapLocalDayWeatherForecast();
                    jSONObject = (JSONObject) jSONArray2.get(i);
                    String a = m14087a(jSONObject, "date");
                    String a2 = m14087a(jSONObject, "week");
                    String a3 = m14087a(jSONObject, "dayweather");
                    String a4 = m14087a(jSONObject, "nightweather");
                    String a5 = m14087a(jSONObject, "daytemp");
                    String a6 = m14087a(jSONObject, "nighttemp");
                    String a7 = m14087a(jSONObject, "daywind");
                    String a8 = m14087a(jSONObject, "nightwind");
                    String a9 = m14087a(jSONObject, "daypower");
                    String a10 = m14087a(jSONObject, "nightpower");
                    aMapLocalDayWeatherForecast.m14037a(a);
                    aMapLocalDayWeatherForecast.m14038b(a2);
                    aMapLocalDayWeatherForecast.m14039c(a3);
                    aMapLocalDayWeatherForecast.m14040d(a4);
                    aMapLocalDayWeatherForecast.m14041e(a5);
                    aMapLocalDayWeatherForecast.m14042f(a6);
                    aMapLocalDayWeatherForecast.m14043g(a7);
                    aMapLocalDayWeatherForecast.m14044h(a8);
                    aMapLocalDayWeatherForecast.m14045i(a9);
                    aMapLocalDayWeatherForecast.m14046j(a10);
                    aMapLocalDayWeatherForecast.setCity(aMapLocation.getCity());
                    aMapLocalDayWeatherForecast.setCityCode(aMapLocation.getCityCode());
                    aMapLocalDayWeatherForecast.setProvince(aMapLocation.getProvince());
                    arrayList.add(aMapLocalDayWeatherForecast);
                }
                aMapLocalWeatherForecast.m14049a(arrayList);
            }
        }
        return aMapLocalWeatherForecast;
    }

    protected String m14087a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        if (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) {
            return str2;
        }
        return jSONObject.optString(str);
    }

    public void onLocationChanged(Location location) {
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        Message obtain;
        if (aMapLocation != null) {
            try {
                if (aMapLocation.getAMapException() != null && aMapLocation.getAMapException().getErrorCode() == 0 && aMapLocation.getAdCode() != null && aMapLocation.getAdCode().length() > 0) {
                    this.f10658c.m14076a((AMapLocationListener) this);
                    obtain = Message.obtain();
                    obtain.what = 3;
                    obtain.obj = aMapLocation;
                    this.f10656a.sendMessage(obtain);
                    this.f10664i = false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.f10658c.m14076a((AMapLocationListener) this);
        obtain = Message.obtain();
        AMapLocException aMapLocException = new AMapLocException(AMapLocException.ERROR_FAILURE_LOCATION);
        obtain.what = 4;
        obtain.obj = aMapLocException;
        this.f10656a.sendMessage(obtain);
        this.f10664i = false;
    }
}
