package com.huawei.hwbasemgr;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwdataaccessmodel.db.a;
import com.huawei.hwdataaccessmodel.db.b;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: HWBaseManager */
public class C0628a {
    public static final String CONTENT_KEY = "content";
    private static final String TAG = "HWBaseManager";
    private static Set<Integer> sModuleIdSet = new HashSet();
    private static Set<C0628a> sModuleInstancesSet = new HashSet();
    private Context mContext;
    private LocalBroadcastManager mLocalBR;

    public static Set<Integer> getModuleIdSet() {
        return sModuleIdSet;
    }

    public static Set<C0628a> getModuleInstancesSet() {
        return sModuleInstancesSet;
    }

    public C0628a(Context context) {
        this.mContext = context;
        init();
    }

    protected Integer getModuleId() {
        return null;
    }

    protected Set<String> getAvailableBroadcastSet() {
        return new HashSet();
    }

    protected Serializable getDataForBroadcast(String str) {
        return null;
    }

    public Serializable getDataForBroadcastFromOtherManager(String str) {
        for (C0628a c0628a : C0628a.getModuleInstancesSet()) {
            if (c0628a.getAvailableBroadcastSet().contains(str)) {
                return c0628a.getDataForBroadcast(str);
            }
        }
        return null;
    }

    private void init() {
        C2538c.m12677c(TAG, "AvailableBroadcastSet is " + getAvailableBroadcastSet());
        if (getModuleId() == null) {
            C2538c.m12680e(TAG, "The module id is empty! you must implements getModuleId method first.");
            throw new RuntimeException("The module id is empty! you must implements getModuleId method first.");
        }
        if (C0628a.getModuleIdSet().contains(getModuleId())) {
            C2538c.m12680e(TAG, "The module id is duplicated!");
        } else {
            C0628a.getModuleIdSet().add(getModuleId());
            C0628a.getModuleInstancesSet().add(this);
        }
        this.mLocalBR = LocalBroadcastManager.getInstance(this.mContext);
    }

    protected void onDestroy() {
        C0628a.getModuleIdSet().remove(getModuleId());
        b.a(this.mContext, String.valueOf(getModuleId())).d();
    }

    public void registerBroadcast(BroadcastReceiver broadcastReceiver, String str) {
        if (this.mLocalBR == null) {
            C2538c.m12680e(TAG, "registerBroadcast, but mLocalBR is null");
            return;
        }
        this.mLocalBR.registerReceiver(broadcastReceiver, new IntentFilter(str));
    }

    public void unregisterBroadcast(BroadcastReceiver broadcastReceiver) {
        if (this.mLocalBR == null) {
            C2538c.m12680e(TAG, "unregisterBroadcast, but mLocalBR is null");
            return;
        }
        this.mLocalBR.unregisterReceiver(broadcastReceiver);
    }

    public boolean sendBroadcast(String str) {
        if (!getAvailableBroadcastSet().contains(str)) {
            C2538c.m12677c(TAG, "this broadcast is invalid!");
            return false;
        } else if (this.mLocalBR == null) {
            C2538c.m12680e(TAG, "sendBroadcast, but mLocalBR is null");
            return false;
        } else {
            Intent intent = new Intent(str);
            intent.putExtra("content", getDataForBroadcast(str));
            this.mLocalBR.sendBroadcast(intent);
            return true;
        }
    }

    public int setSharedPreference(String str, String str2, C0993c c0993c) {
        return C0996a.m3611a(this.mContext, String.valueOf(getModuleId()), str, str2, c0993c);
    }

    public Set<String> getExistingKeys() {
        return C0996a.m3613a(this.mContext, String.valueOf(getModuleId()));
    }

    public String getSharedPreference(String str) {
        return C0996a.m3612a(this.mContext, String.valueOf(getModuleId()), str);
    }

    public int deleteSharedPreference(String str) {
        return C0996a.m3617b(this.mContext, String.valueOf(getModuleId()), str);
    }

    public int resetSharedPreference() {
        return C0996a.m3620c(this.mContext, String.valueOf(getModuleId()));
    }

    public int createStorageDataTable(String str, int i, String str2) {
        return a.a(this.mContext, String.valueOf(getModuleId()), str, i, str2);
    }

    public Cursor queryStorageData(String str, int i, String str2) {
        return a.c(this.mContext, String.valueOf(getModuleId()), str, i, str2);
    }

    public Cursor queryStorageDataToOrder(String str, int i, String str2, String str3) {
        return a.a(this.mContext, String.valueOf(getModuleId()), str, i, str2, str3);
    }

    public int updateStorageData(String str, int i, ContentValues contentValues, String str2) {
        return a.a(this.mContext, String.valueOf(getModuleId()), str, i, contentValues, str2);
    }

    public int updateStorageData(String str, int i, ContentValues contentValues, String str2, String[] strArr) {
        return a.a(this.mContext, String.valueOf(getModuleId()), str, i, contentValues, str2, strArr);
    }

    public long insertStorageData(String str, int i, ContentValues contentValues) {
        return a.a(this.mContext, String.valueOf(getModuleId()), str, i, contentValues);
    }

    public long insertStorageDataWithOnConfict(String str, int i, ContentValues contentValues, int i2) {
        return a.a(this.mContext, String.valueOf(getModuleId()), str, i, contentValues, i2);
    }

    public int deleteStorageData(String str, int i, String str2) {
        return a.b(this.mContext, String.valueOf(getModuleId()), str, i, str2);
    }

    public int deleteStorageData(String str, int i, String str2, String[] strArr) {
        return a.a(this.mContext, String.valueOf(getModuleId()), str, i, str2, strArr);
    }

    public Cursor rawQueryStorageData(int i, String str, String[] strArr) {
        return a.a(this.mContext, String.valueOf(getModuleId()), i, str, strArr);
    }

    public String getTableFullName(String str) {
        return a.a(String.valueOf(getModuleId()), str);
    }

    public static void finishAll() {
        Iterator it = C0628a.getModuleInstancesSet().iterator();
        while (it.hasNext()) {
            try {
                C0628a c0628a = (C0628a) it.next();
                it.remove();
                c0628a.onDestroy();
            } catch (Exception e) {
                C2538c.m12680e(TAG, "finishAll() Exception e = " + e.getMessage());
            }
        }
        C0628a.getModuleInstancesSet().clear();
    }

    public boolean onDataMigrate() {
        return true;
    }
}
