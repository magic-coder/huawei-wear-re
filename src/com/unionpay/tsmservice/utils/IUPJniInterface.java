package com.unionpay.tsmservice.utils;

import android.content.Context;
import java.util.ArrayList;

public class IUPJniInterface {
    public static final native void aaP(String str);

    public static final native void acP();

    public static final native synchronized boolean acSKV(String str);

    public static final native synchronized String adM(String str);

    public static final native void adOP();

    public static final native String adP(ArrayList<String> arrayList);

    public static final native synchronized String aeM(String str);

    public static final native String aeP(String str);

    public static final native String aePO(String str);

    public static final native String aePPB(String str, String str2);

    public static final native boolean aiJNIE(Context context);

    public static final native synchronized String amSK();

    private static final native synchronized String arE(String str, String str2);

    private static final native synchronized String arEP(String str);

    public static final native synchronized void asSK(String str);

    public static final native synchronized void auSKT(String str, String str2);

    public static final synchronized String arEWK(String str, String str2) {
        String arE;
        synchronized (IUPJniInterface.class) {
            arE = arE(str, str2);
        }
        return arE;
    }

    public static final synchronized String arEPWK(String str) {
        String arEP;
        synchronized (IUPJniInterface.class) {
            arEP = arEP(str);
        }
        return arEP;
    }
}
