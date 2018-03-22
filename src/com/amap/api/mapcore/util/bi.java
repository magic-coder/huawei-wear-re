package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* compiled from: ResourcesUtil */
public class bi {
    private static boolean f11498a;

    static {
        f11498a = false;
        f11498a = new File("/system/framework/amap.jar").exists();
    }

    public static AssetManager m15630a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (!f11498a) {
            return assets;
        }
        try {
            assets.getClass().getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assets, new Object[]{"/system/framework/amap.jar"});
            return assets;
        } catch (Throwable th) {
            ca.m15831a(th, "ResourcesUtil", "getSelfAssets");
            return assets;
        }
    }
}
