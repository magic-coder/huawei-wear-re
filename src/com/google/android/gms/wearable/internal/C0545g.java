package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C0544j;
import com.google.android.gms.wearable.C0548k;
import com.google.android.gms.wearable.C0550m;
import com.google.android.gms.wearable.PutDataRequest;

public final class C0545g implements C0544j {
    private void m2172a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public C0382t<C0550m> mo2020a(C0378p c0378p, Asset asset) {
        m2172a(asset);
        return c0378p.mo1839a(new C0547i(this, c0378p, asset));
    }

    public C0382t<C0548k> mo2021a(C0378p c0378p, PutDataRequest putDataRequest) {
        return c0378p.mo1839a(new C0546h(this, c0378p, putDataRequest));
    }
}
