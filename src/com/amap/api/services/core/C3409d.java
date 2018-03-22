package com.amap.api.services.core;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public class C3409d {
    public static boolean m16882a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static double m16877a(int i) {
        return ((double) i) / 111700.0d;
    }

    public static void m16883b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") && jSONObject.has("info")) {
                String string = jSONObject.getString("status");
                String string2 = jSONObject.getString("info");
                if (!string.equals("1") && string.equals("0")) {
                    if (string2.equals("INVALID_USER_KEY") || string2.equals("INSUFFICIENT_PRIVILEGES") || string2.equals("INVALID_USER_SCODE") || string2.equals("INVALID_USER_SIGNATURE")) {
                        throw new AMapException("key鉴权失败");
                    } else if (string2.equals("SERVICE_NOT_EXIST") || string2.equals("服务正在维护中")) {
                        throw new AMapException(AMapException.ERROR_SERVER);
                    } else if (string2.startsWith("UNKNOWN_ERROR")) {
                        throw new AMapException("未知的错误");
                    } else if (string2.equals("INVALID_PARAMS") || string2.equals("参数缺失或格式非法") || string2.equals("账号未激活或已被冻结")) {
                        throw new AMapException("无效的参数 - IllegalArgumentException");
                    } else if (string2.equals("OVER_QUOTA") || string2.equals("USER_VISIT_TOO_FREQUENTLY") || string2.equals("USER_DAILY_VISITS_EXCESS") || string2.equals("IP_FORBIDDEN")) {
                        throw new AMapException(AMapException.ERROR_QUOTA);
                    } else if (string2.equals("SERVICE_RESPONSE_ERROR")) {
                        throw new AMapException(AMapException.ERROR_SERVICE);
                    } else {
                        throw new AMapException(string2);
                    }
                }
            }
        } catch (Throwable e) {
            C3409d.m16881a(e, "CoreUtil", "paseAuthFailurJson");
        }
    }

    public static double m16876a(double d) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    public static String m16878a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        double a = C3409d.m16876a(latLonPoint.getLongitude());
        return a + "," + C3409d.m16876a(latLonPoint.getLatitude());
    }

    public static Date m16884c(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (Throwable e) {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (ParseException e2) {
                C3409d.m16881a(e, "CoreUtil", "parseString2Date");
            }
        }
        return date;
    }

    public static Date m16885d(String str) {
        Date date = null;
        if (!(str == null || str.trim().equals(""))) {
            try {
                date = new SimpleDateFormat("HHmm").parse(str);
            } catch (Throwable e) {
                C3409d.m16881a(e, "CoreUtil", "parseString2Time");
            }
        }
        return date;
    }

    public static String m16879a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static Date m16886e(String str) {
        Date date = null;
        if (!(str == null || str.trim().equals(""))) {
            try {
                date = new SimpleDateFormat("HH:mm").parse(str);
            } catch (Throwable e) {
                C3409d.m16881a(e, "CoreUtil", "parseTime");
            }
        }
        return date;
    }

    public static String m16880a(List<LatLonPoint> list) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            LatLonPoint latLonPoint = (LatLonPoint) list.get(i);
            double a = C3409d.m16876a(latLonPoint.getLongitude());
            stringBuffer.append(a).append(",").append(C3409d.m16876a(latLonPoint.getLatitude()));
            stringBuffer.append(";");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static void m16881a(Throwable th, String str, String str2) {
        ay b = ay.m16710b();
        if (b != null) {
            b.m16712b(th, str, str2);
        }
        th.printStackTrace();
    }
}
