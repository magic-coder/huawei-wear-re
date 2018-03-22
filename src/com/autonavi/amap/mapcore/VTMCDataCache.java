package com.autonavi.amap.mapcore;

import java.util.ArrayList;
import java.util.Hashtable;

public class VTMCDataCache {
    public static final int MAXSIZE = 500;
    public static final int MAX_EXPIREDTIME = 300;
    private static VTMCDataCache instance;
    static Hashtable<String, C3526f> vtmcHs = new Hashtable();
    static ArrayList<String> vtmcList = new ArrayList();
    public int mNewestTimeStamp = 0;

    public static VTMCDataCache getInstance() {
        if (instance == null) {
            instance = new VTMCDataCache();
        }
        return instance;
    }

    public void reset() {
        vtmcList.clear();
        vtmcHs.clear();
    }

    public int getSize() {
        return vtmcList.size();
    }

    private void deleteData(String str) {
        vtmcHs.remove(str);
        for (int i = 0; i < vtmcList.size(); i++) {
            if (((String) vtmcList.get(i)).equals(str)) {
                vtmcList.remove(i);
                return;
            }
        }
    }

    public synchronized C3526f getData(String str, boolean z) {
        C3526f c3526f;
        c3526f = (C3526f) vtmcHs.get(str);
        if (!z) {
            if (c3526f == null) {
                c3526f = null;
            } else if (((int) (System.currentTimeMillis() / 1000)) - c3526f.f13290c > 300) {
                c3526f = null;
            } else if (this.mNewestTimeStamp > c3526f.f13292e) {
                c3526f = null;
            }
        }
        return c3526f;
    }

    public synchronized C3526f putData(byte[] bArr) {
        C3526f c3526f;
        C3526f c3526f2 = new C3526f(bArr);
        if (this.mNewestTimeStamp < c3526f2.f13292e) {
            this.mNewestTimeStamp = c3526f2.f13292e;
        }
        c3526f = (C3526f) vtmcHs.get(c3526f2.f13289b);
        if (c3526f != null) {
            if (c3526f.f13291d.equals(c3526f2.f13291d)) {
                c3526f.m17638a(this.mNewestTimeStamp);
            } else {
                deleteData(c3526f2.f13289b);
            }
        }
        if (vtmcList.size() > 500) {
            vtmcHs.remove(vtmcList.get(0));
            vtmcList.remove(0);
        }
        vtmcHs.put(c3526f2.f13289b, c3526f2);
        vtmcList.add(c3526f2.f13289b);
        c3526f = c3526f2;
        return c3526f;
    }
}
