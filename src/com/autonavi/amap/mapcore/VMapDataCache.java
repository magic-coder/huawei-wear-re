package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.bf;
import java.util.ArrayList;
import java.util.HashMap;

public class VMapDataCache {
    private static final int MAXSIZE = 400;
    private static VMapDataCache instance;
    HashMap<String, C3525e> vCancelMapDataHs = new HashMap();
    ArrayList<String> vCancelMapDataList = new ArrayList();
    HashMap<String, C3525e> vMapDataHs = new HashMap();
    ArrayList<String> vMapDataList = new ArrayList();

    public static VMapDataCache getInstance() {
        if (instance == null) {
            instance = new VMapDataCache();
        }
        return instance;
    }

    public synchronized void reset() {
        bf.m15627a(bf.f11497a, hashCode() + " VMapData reset, clear all list", 111);
        this.vMapDataHs.clear();
        this.vMapDataList.clear();
        this.vCancelMapDataHs.clear();
        this.vCancelMapDataList.clear();
    }

    public int getSize() {
        return this.vMapDataHs.size();
    }

    static String getKey(String str, int i) {
        return str + "-" + i;
    }

    public synchronized C3525e getRecoder(String str, int i) {
        C3525e c3525e;
        bf.m15627a(bf.f11497a, hashCode() + " VMapData GetData " + str + "-" + i, 111);
        c3525e = (C3525e) this.vMapDataHs.get(getKey(str, i));
        if (c3525e != null) {
            c3525e.f13287d++;
        }
        return c3525e;
    }

    public synchronized C3525e getCancelRecoder(String str, int i) {
        C3525e c3525e;
        bf.m15627a(bf.f11497a, hashCode() + " VMapData GetCancelData " + str + "-" + i, 111);
        c3525e = (C3525e) this.vCancelMapDataHs.get(getKey(str, i));
        if (c3525e != null && (System.currentTimeMillis() / 1000) - ((long) c3525e.f13285b) > 10) {
            c3525e = null;
        }
        return c3525e;
    }

    public synchronized C3525e putRecoder(byte[] bArr, String str, int i) {
        C3525e c3525e;
        c3525e = new C3525e(str, i);
        if (c3525e.f13284a == null) {
            c3525e = null;
        } else {
            if (this.vMapDataHs.size() > 400) {
                this.vMapDataHs.remove(this.vMapDataList.get(0));
                this.vMapDataList.remove(0);
            }
            this.vMapDataHs.put(getKey(str, i), c3525e);
            this.vMapDataList.add(getKey(str, i));
            bf.m15627a(bf.f11497a, hashCode() + " VMapData putData " + c3525e.f13284a + "-" + i, 111);
        }
        return c3525e;
    }

    public synchronized C3525e putCancelRecoder(byte[] bArr, String str, int i) {
        C3525e c3525e = null;
        synchronized (this) {
            if (getRecoder(str, i) == null) {
                C3525e c3525e2 = new C3525e(str, i);
                if (c3525e2.f13284a != null) {
                    if (this.vCancelMapDataHs.size() > 400) {
                        this.vCancelMapDataHs.remove(this.vMapDataList.get(0));
                        this.vCancelMapDataList.remove(0);
                    }
                    this.vCancelMapDataHs.put(getKey(str, i), c3525e2);
                    this.vCancelMapDataList.add(getKey(str, i));
                    c3525e = c3525e2;
                }
            }
        }
        return c3525e;
    }
}
