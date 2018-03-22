package com.huawei.hihealth.p394c;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

/* compiled from: HiJsonUtil */
public class C4543e {
    public static <T> T m21777a(String str, Class<T> cls) {
        return new Gson().fromJson(str, cls);
    }

    public static <T> T m21778a(String str, Type type) {
        return new Gson().fromJson(str, type);
    }

    public static <T> T m21781b(String str, Class<T> cls) {
        return new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, cls);
    }

    public static String m21779a(Object obj) {
        return new Gson().toJson(obj);
    }

    public static String m21780a(Object obj, Type type) {
        return new Gson().toJson(obj, type);
    }
}
