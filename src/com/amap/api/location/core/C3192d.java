package com.amap.api.location.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.LocationProviderProxy;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public class C3192d {
    public static String f10700a = "";
    public static String f10701b = "";
    static int f10702c = 2048;
    static String f10703d = null;
    private static String f10704e = null;
    private static SharedPreferences f10705f = null;
    private static Editor f10706g = null;
    private static Method f10707h;

    public static boolean m14144a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            State state = activeNetworkInfo.getState();
            if (state == null || state == State.DISCONNECTED || state == State.DISCONNECTING) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static AMapLocation m14145b(Context context) {
        try {
            if (f10704e == null) {
                f10704e = C3193e.m14147a("MD5", context.getApplicationContext().getPackageName());
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("last_known_location", 0);
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(LocationProviderProxy.AMapNetwork);
            double parseDouble = Double.parseDouble(C3193e.m14153b(sharedPreferences.getString("a", ""), f10704e));
            double parseDouble2 = Double.parseDouble(C3193e.m14153b(sharedPreferences.getString("b", ""), f10704e));
            aMapLocation.setLatitude(parseDouble);
            aMapLocation.setLongitude(parseDouble2);
            aMapLocation.setProvince(C3193e.m14153b(sharedPreferences.getString("c", ""), f10704e));
            aMapLocation.setCity(C3193e.m14153b(sharedPreferences.getString("d", ""), f10704e));
            aMapLocation.setDistrict(C3193e.m14153b(sharedPreferences.getString("e", ""), f10704e));
            aMapLocation.setCityCode(C3193e.m14153b(sharedPreferences.getString("f", ""), f10704e));
            aMapLocation.setAdCode(C3193e.m14153b(sharedPreferences.getString("g", ""), f10704e));
            aMapLocation.setAccuracy(Float.parseFloat(C3193e.m14153b(sharedPreferences.getString("h", ""), f10704e)));
            aMapLocation.setTime(Long.parseLong(C3193e.m14153b(sharedPreferences.getString("i", ""), f10704e)));
            aMapLocation.setAddress(C3193e.m14153b(sharedPreferences.getString("j", ""), f10704e));
            aMapLocation.setRoad(C3193e.m14153b(sharedPreferences.getString("k", ""), f10704e));
            aMapLocation.setPoiId(C3193e.m14153b(sharedPreferences.getString("l", ""), f10704e));
            aMapLocation.setPoiName(C3193e.m14153b(sharedPreferences.getString("m", ""), f10704e));
            return aMapLocation;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void m14141a(Context context, AMapLocation aMapLocation) {
        try {
            if (f10705f == null) {
                f10705f = context.getSharedPreferences("last_known_location", 0);
            }
            if (f10706g == null) {
                f10706g = f10705f.edit();
            }
            if (f10704e == null) {
                f10704e = C3193e.m14147a("MD5", C3191c.m14122b());
            }
            f10706g.putString("a", C3193e.m14160d(String.valueOf(aMapLocation.getLatitude()).getBytes(), f10704e));
            f10706g.putString("b", C3193e.m14160d(String.valueOf(aMapLocation.getLongitude()).getBytes(), f10704e));
            String province = aMapLocation.getProvince();
            if (province != null && province.length() > 0) {
                f10706g.putString("c", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getCity();
            if (province != null && province.length() > 0) {
                f10706g.putString("d", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getDistrict();
            if (province != null && province.length() > 0) {
                f10706g.putString("e", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getCityCode();
            if (province != null && province.length() > 0) {
                f10706g.putString("f", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getAdCode();
            if (province != null && province.length() > 0) {
                f10706g.putString("g", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getAccuracy() + "";
            if (province != null && province.length() > 0) {
                f10706g.putString("h", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getTime() + "";
            if (province != null && province.length() > 0) {
                f10706g.putString("i", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getAddress() + "";
            if (province != null && province.length() > 0) {
                f10706g.putString("j", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getRoad() + "";
            if (province != null && province.length() > 0) {
                f10706g.putString("k", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getPoiId() + "";
            if (province != null && province.length() > 0) {
                f10706g.putString("l", C3193e.m14160d(province.getBytes(), f10704e));
            }
            province = aMapLocation.getPoiName() + "";
            if (province != null && province.length() > 0) {
                f10706g.putString("m", C3193e.m14160d(province.getBytes(), f10704e));
            }
            C3192d.m14142a(f10706g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void m14142a(Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                try {
                    if (f10707h == null) {
                        f10707h = Editor.class.getDeclaredMethod("apply", new Class[0]);
                    }
                    f10707h.invoke(editor, new Object[0]);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    editor.commit();
                    return;
                }
            }
            editor.commit();
        }
    }

    public static String m14139a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + "1" + valueOf.substring(length - 1);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String m14140a(String str, String str2) {
        String str3 = null;
        try {
            if (f10703d == null || f10703d.length() == 0) {
                f10703d = C3191c.m14119a(null).m14138i();
            }
            str3 = C3195g.m14163a(f10703d + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str3;
    }

    public static void m14143a(String str) throws AMapLocException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") && jSONObject.has("info")) {
                String string = jSONObject.getString("status");
                String string2 = jSONObject.getString("info");
                if (!string.equals("1") && string.equals("0")) {
                    if (string2.equals("INVALID_USER_KEY") || string2.equals("INSUFFICIENT_PRIVILEGES") || string2.equals("USERKEY_PLAT_NOMATCH") || string2.equals("INVALID_USER_SCODE")) {
                        throw new AMapLocException("key鉴权失败");
                    } else if (string2.equals("SERVICE_NOT_EXIST") || string2.equals("SERVICE_RESPONSE_ERROR") || string2.equals("OVER_QUOTA") || string2.equals("UNKNOWN_ERROR")) {
                        throw new AMapLocException("未知的错误");
                    } else if (string2.equals("INVALID_PARAMS")) {
                        throw new AMapLocException("无效的参数 - IllegalArgumentException");
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
