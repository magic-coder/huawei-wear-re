package com.huawei.hwdataaccessmodel.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.ak.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.a.d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.o.b;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: SharedPreferenceManager */
public class C0996a {
    public static int m3611a(Context context, String str, String str2, String str3, C0993c c0993c) {
        try {
            Object sharedPreferenceModel;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            String string = sharedPreferences.getString(str2, "");
            if (TextUtils.isEmpty(string)) {
                sharedPreferenceModel = new SharedPreferenceModel();
                if (c0993c == null || c0993c.f1665b == 0) {
                    sharedPreferenceModel.setValue(str3);
                    sharedPreferenceModel.setEncryptType(0);
                } else {
                    sharedPreferenceModel.setValue(b.a(BaseApplication.m2632b()).a(c0993c.f1665b, str3));
                    sharedPreferenceModel.setEncryptType(c0993c.f1665b);
                }
            } else {
                SharedPreferenceModel sharedPreferenceModel2 = (SharedPreferenceModel) new Gson().fromJson(string, SharedPreferenceModel.class);
                if (sharedPreferenceModel2 == null) {
                    return 201000;
                }
                if (c0993c == null && sharedPreferenceModel2.getEncryptType() != 0) {
                    return 200004;
                }
                if (c0993c != null && sharedPreferenceModel2.getEncryptType() != c0993c.f1665b) {
                    return 200004;
                }
                if (sharedPreferenceModel2.getEncryptType() == 0) {
                    sharedPreferenceModel2.setValue(str3);
                } else {
                    sharedPreferenceModel2.setValue(b.a(BaseApplication.m2632b()).a(sharedPreferenceModel2.getEncryptType(), str3));
                    C2538c.m12677c("SharedPreferenceManager", "need to encrypt");
                }
            }
            Editor edit = sharedPreferences.edit();
            edit.putString(str2, new Gson().toJson(sharedPreferenceModel));
            if (edit.commit()) {
                return 0;
            }
            return 201000;
        } catch (Exception e) {
            C2538c.m12680e("SharedPreferenceManager", "setSharedPreference exception1." + e.toString());
            return 201000;
        }
    }

    public static Set<String> m3613a(Context context, String str) {
        Set<String> hashSet = new HashSet();
        for (Object obj : context.getSharedPreferences(str, 0).getAll().keySet()) {
            hashSet.add(obj.toString());
        }
        return hashSet;
    }

    public static String m3612a(Context context, String str, String str2) {
        try {
            SharedPreferenceModel sharedPreferenceModel = (SharedPreferenceModel) new Gson().fromJson(context.getSharedPreferences(str, 0).getString(str2, ""), SharedPreferenceModel.class);
            if (sharedPreferenceModel == null) {
                return "";
            }
            if (sharedPreferenceModel.getEncryptType() == 0) {
                return sharedPreferenceModel.getValue();
            }
            return b.a(BaseApplication.m2632b()).b(sharedPreferenceModel.getEncryptType(), sharedPreferenceModel.getValue());
        } catch (Exception e) {
            C2538c.m12680e("SharedPreferenceManager", "getSharedPreference exception:", e.getMessage());
            return null;
        }
    }

    public static Map<String, String> m3618b(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            Map<String, String> hashMap = new HashMap();
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                SharedPreferenceModel sharedPreferenceModel = (SharedPreferenceModel) new Gson().fromJson((String) entry.getValue(), SharedPreferenceModel.class);
                if (sharedPreferenceModel != null) {
                    if (sharedPreferenceModel.getEncryptType() == 0) {
                        hashMap.put(entry.getKey(), sharedPreferenceModel.getValue());
                    } else {
                        C2538c.m12677c("SharedPreferenceManager", "need to encrypt");
                        hashMap.put(entry.getKey(), b.a(BaseApplication.m2632b()).b(sharedPreferenceModel.getEncryptType(), sharedPreferenceModel.getValue()));
                    }
                }
            }
            return hashMap;
        } catch (Exception e) {
            C2538c.m12680e("SharedPreferenceManager", "getAllSharedPreferencesById exception");
            return null;
        }
    }

    public static int m3617b(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.remove(str2);
        if (edit.commit()) {
            return 0;
        }
        return 201000;
    }

    public static int m3620c(Context context, String str) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.clear();
        if (edit.commit()) {
            return 0;
        }
        return 201000;
    }

    public static void m3616a(String str, String str2, String str3, C0993c c0993c, com.huawei.hwdataaccessmodel.a.b bVar) {
        a.a().a(new b(str, str2, c0993c, str3, bVar));
    }

    public static void m3615a(String str, String str2, com.huawei.hwdataaccessmodel.a.b bVar) {
        a.a().a(new c(str, str2, bVar));
    }

    private static void m3619b(com.huawei.hwdataaccessmodel.a.b bVar, d dVar) {
        if (bVar != null) {
            bVar.a(dVar);
        }
    }
}
