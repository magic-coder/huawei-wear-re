package com.google.android.gms.wearable;

import android.util.Log;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.eq;
import com.huawei.hwid.core.constants.HwAccountConstants;

public class ab {
    private final PutDataRequest f915a;
    private final C0571r f916b = new C0571r();

    private ab(PutDataRequest putDataRequest, C0571r c0571r) {
        this.f915a = putDataRequest;
        if (c0571r != null) {
            this.f916b.m2235a(c0571r);
        }
    }

    public static ab m1688a(String str) {
        return new ab(PutDataRequest.create(str), null);
    }

    public C0571r m1689a() {
        return this.f916b;
    }

    public PutDataRequest m1690b() {
        ec a = eb.m1272a(this.f916b);
        this.f915a.setData(eq.m1280a(a.f708a));
        int size = a.f709b.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) a.f709b.get(i);
            String valueOf;
            if (num == null) {
                valueOf = String.valueOf(asset);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("asset key cannot be null: ").append(valueOf).toString());
            } else if (asset == null) {
                String str = "asset cannot be null: key=";
                valueOf = String.valueOf(num);
                throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            } else {
                if (Log.isLoggable("DataMap", 3)) {
                    String valueOf2 = String.valueOf(asset);
                    Log.d("DataMap", new StringBuilder((String.valueOf(num).length() + 33) + String.valueOf(valueOf2).length()).append("asPutDataRequest: adding asset: ").append(num).append(HwAccountConstants.BLANK).append(valueOf2).toString());
                }
                this.f915a.putAsset(num, asset);
                i++;
            }
        }
        return this.f915a;
    }
}
