package com.snowballtech.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesUtil {
    private static PreferencesUtil instance;

    private PreferencesUtil() {
    }

    public static PreferencesUtil getInstance() {
        if (instance == null) {
            instance = new PreferencesUtil();
        }
        return instance;
    }

    private SharedPreferences getSharedPreferences(String str, Context context) {
        return context.getSharedPreferences(str, 0);
    }

    public void keepField(String str, String str2, Context context) {
        Editor edit = getSharedPreferences(str, context).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String getField(String str, Context context) {
        return getSharedPreferences(str, context).getString(str, "");
    }

    public void removeField(String str, Context context) {
        Editor edit = getSharedPreferences(str, context).edit();
        edit.remove(str);
        edit.commit();
    }

    public <T> void keepEntity(String str, T t, Context context) {
        keepField(str, JsonUtil.getInstance().serializeObject(t, new boolean[0]), context);
    }

    public <T> T getEntity(String str, Class<T> cls, Context context) {
        return JsonUtil.getInstance().deSerializeString(getField(str, context), cls);
    }
}
