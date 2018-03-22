package com.huawei.hwcloudmodel.p061c;

import com.huawei.p190v.C2538c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ParseWeatherXML */
public class C4709v {
    public static final int m22535a(String str, String str2) {
        int c;
        Object e;
        try {
            c = C4709v.m22538c(new JSONObject(str).getString(str2));
            try {
                c.c("ParseWeatherXML", new Object[]{"parseWeather result= " + c});
            } catch (JSONException e2) {
                e = e2;
                c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return c;
            } catch (NumberFormatException e3) {
                e = e3;
                c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return c;
            }
        } catch (JSONException e4) {
            JSONException jSONException = e4;
            c = -1;
            e = jSONException;
            c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return c;
        } catch (NumberFormatException e5) {
            NumberFormatException numberFormatException = e5;
            c = -1;
            e = numberFormatException;
            c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return c;
        }
        return c;
    }

    public static final int m22534a(String str) {
        int c;
        Object e;
        try {
            c = C4709v.m22538c(new JSONArray(str).getJSONObject(0).getJSONObject("Temperature").getJSONObject("Metric").getString("Value"));
            try {
                c.c("ParseWeatherXML", new Object[]{"parseJsonForTemp result= " + c});
            } catch (JSONException e2) {
                e = e2;
                c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return c;
            } catch (NumberFormatException e3) {
                e = e3;
                c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return c;
            }
        } catch (JSONException e4) {
            JSONException jSONException = e4;
            c = -99;
            e = jSONException;
            c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return c;
        } catch (NumberFormatException e5) {
            NumberFormatException numberFormatException = e5;
            c = -99;
            e = numberFormatException;
            c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return c;
        }
        return c;
    }

    public static final int m22536b(String str) {
        int c;
        Object e;
        try {
            c = C4709v.m22538c(new JSONArray(str).getJSONObject(0).getString("WeatherIcon"));
            try {
                c.c("ParseWeatherXML", new Object[]{"parseJsonForTemp result= " + c});
            } catch (JSONException e2) {
                e = e2;
                c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return c;
            } catch (NumberFormatException e3) {
                e = e3;
                c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return c;
            }
        } catch (JSONException e4) {
            JSONException jSONException = e4;
            c = -99;
            e = jSONException;
            c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return c;
        } catch (NumberFormatException e5) {
            NumberFormatException numberFormatException = e5;
            c = -99;
            e = numberFormatException;
            c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return c;
        }
        return c;
    }

    public static final int m22537b(String str, String str2) {
        int a;
        Object e;
        try {
            a = C4709v.m22533a(Float.parseFloat(new JSONObject(str).getJSONArray("DailyForecasts").getJSONObject(0).getJSONObject("Temperature").getJSONObject(str2).getString("Value")));
            try {
                C2538c.c("ParseWeatherXML", new Object[]{"parseJsonForHigh result= " + a});
            } catch (JSONException e2) {
                e = e2;
                C2538c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return a;
            } catch (NumberFormatException e3) {
                e = e3;
                C2538c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
                return a;
            }
        } catch (JSONException e4) {
            JSONException jSONException = e4;
            a = -99;
            e = jSONException;
            C2538c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return a;
        } catch (NumberFormatException e5) {
            NumberFormatException numberFormatException = e5;
            a = -99;
            e = numberFormatException;
            C2538c.c("ParseWeatherXML", new Object[]{"Exception e = " + e});
            return a;
        }
        return a;
    }

    private static int m22538c(String str) throws NumberFormatException {
        return (int) Math.round(Double.parseDouble(str));
    }

    public static final int m22533a(float f) {
        float f2 = ((f - 32.0f) * 5.0f) / 9.0f;
        if (f2 >= 0.0f) {
            return (int) (((double) f2) + 0.5d);
        }
        return (int) (((double) f2) - 0.5d);
    }
}
