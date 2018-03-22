package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.wearable.PutDataRequest;

public final class bs {
    public static IntentFilter m2008a(String str) {
        IntentFilter intentFilter = new IntentFilter(str);
        intentFilter.addDataScheme(PutDataRequest.WEAR_URI_SCHEME);
        intentFilter.addDataAuthority("*", null);
        return intentFilter;
    }
}
