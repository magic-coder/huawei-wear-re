package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import java.io.File;

public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack, int i) {
        RequestQueue requestQueue;
        File file = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (httpStack == null) {
            if (VERSION.SDK_INT >= 9) {
                httpStack = new HurlStack();
            } else {
                httpStack = new HttpClientStack(AndroidHttpClient.newInstance(str));
            }
        }
        Network basicNetwork = new BasicNetwork(httpStack);
        if (i <= -1) {
            requestQueue = new RequestQueue(new DiskBasedCache(file), basicNetwork);
        } else {
            requestQueue = new RequestQueue(new DiskBasedCache(file, i), basicNetwork);
        }
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context, int i) {
        return newRequestQueue(context, null, i);
    }

    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        return newRequestQueue(context, httpStack, -1);
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }
}
