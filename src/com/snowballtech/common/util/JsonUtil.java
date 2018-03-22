package com.snowballtech.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import org.json.JSONObject;

public class JsonUtil {
    private static volatile JsonUtil singleton;
    private Gson gson = new Gson();
    private Gson gsonNoHtml;

    private JsonUtil() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();
        this.gsonNoHtml = gsonBuilder.create();
    }

    public static JsonUtil getInstance() {
        if (singleton == null) {
            synchronized (JsonUtil.class) {
                if (singleton == null) {
                    singleton = new JsonUtil();
                }
            }
        }
        return singleton;
    }

    public <T> String serializeObject(T t, boolean... zArr) {
        T t2 = "";
        if (t != null) {
            Gson gson;
            if (zArr == null || zArr.length == 0 || (zArr.length > 0 && zArr[0])) {
                gson = this.gson;
            } else {
                gson = this.gsonNoHtml;
            }
            try {
                if (t.getClass().getName().endsWith("String")) {
                    return (String) t;
                }
                return gson.toJson(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t2;
    }

    public <T> JSONObject serializeObjectJson(T t) {
        if (t != null) {
            try {
                return new JSONObject(this.gsonNoHtml.toJson(t));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public <T> T deSerializeString(String str, Class<T> cls) {
        T t = null;
        if (!ValueUtil.isEmpty(str)) {
            try {
                t = this.gsonNoHtml.fromJson(str, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public <T> T deSerializeStringByType(String str, Type type) {
        T t = null;
        if (!ValueUtil.isEmpty(str)) {
            try {
                t = this.gsonNoHtml.fromJson(str, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
