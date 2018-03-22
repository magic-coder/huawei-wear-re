package com.huawei.crowdtestsdk.utils;

import android.content.Context;
import android.util.Log;

public class ResUtil {
    private static final String TAG = "BETACLUB_SDK";
    public static final String TYPE_ANIM = "anim";
    public static final String TYPE_ARRAY = "array";
    public static final String TYPE_DIMEN = "dimen";
    public static final String TYPE_DRAWABLE = "drawable";
    public static final String TYPE_ID = "id";
    public static final String TYPE_LAYOUT = "layout";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_STYLEABLE = "styleable";

    public static int getResId(Context context, String str, String str2) {
        try {
            Class cls = Class.forName(context.getPackageName() + ".R$" + str2);
            return cls.getField(str).getInt(cls.newInstance());
        } catch (Exception e) {
            Log.d("BETACLUB_SDK", "[ResUtil.getLayoutResID]" + e.toString());
            return 0;
        }
    }
}
