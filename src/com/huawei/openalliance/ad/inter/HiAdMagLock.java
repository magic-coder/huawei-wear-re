package com.huawei.openalliance.ad.inter;

import android.content.Context;
import com.huawei.openalliance.ad.inter.constant.EventType;
import com.huawei.openalliance.ad.inter.data.CubeParameters;
import com.huawei.openalliance.ad.inter.data.MagLockAdInfo;
import com.huawei.openalliance.ad.inter.listener.MagLockConfigListener;
import com.huawei.openalliance.ad.inter.listener.MagLockListener;
import com.huawei.openalliance.ad.p112a.p118d.C1246a;

public interface HiAdMagLock {

    public final class Builder {
        public final HiAdMagLock build() {
            return new C1246a();
        }
    }

    void onNetworkConnected(Context context);

    void reportEvent(Context context, String str, EventType eventType);

    void requestAds(Context context, String[] strArr, String[] strArr2, String[] strArr3, CubeParameters cubeParameters, MagLockListener magLockListener, boolean z);

    void requestAds(Context context, String[] strArr, String[] strArr2, String[] strArr3, MagLockListener magLockListener, boolean z);

    void requestConfig(Context context, String str, MagLockConfigListener magLockConfigListener);

    void updateMagLockInfo(Context context, MagLockAdInfo magLockAdInfo);
}
