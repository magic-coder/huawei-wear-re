package com.huawei.nfc.carrera.storage.sp;

import android.content.Context;
import android.content.SharedPreferences;

public final class NFCPreferences {
    private static final String HOTALK_PROPERTIES_NAME = "NFC_Properties";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static NFCPreferences instance = null;
    private SharedPreferences sp = null;

    private NFCPreferences(Context context) {
        this.sp = context.getApplicationContext().getSharedPreferences(HOTALK_PROPERTIES_NAME, 0);
    }

    public static NFCPreferences getInstance(Context context) {
        NFCPreferences nFCPreferences;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new NFCPreferences(context);
            }
            nFCPreferences = instance;
        }
        return nFCPreferences;
    }

    public boolean remove(String str) {
        return this.sp.edit().remove(str).commit();
    }

    public boolean putLong(String str, Long l) {
        return this.sp.edit().putLong(str, l.longValue()).commit();
    }

    public Long getLong(String str, Long l) {
        return Long.valueOf(this.sp.getLong(str, l.longValue()));
    }

    public boolean putString(String str, String str2) {
        return this.sp.edit().putString(str, str2).commit();
    }

    public String getString(String str, String str2) {
        return this.sp.getString(str, str2);
    }

    public boolean putBoolean(String str, boolean z) {
        return this.sp.edit().putBoolean(str, z).commit();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.sp.getBoolean(str, z);
    }

    public boolean putInt(String str, int i) {
        return this.sp.edit().putInt(str, i).commit();
    }

    public int getInt(String str, int i) {
        return this.sp.getInt(str, i);
    }
}
