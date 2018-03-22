package com.huawei.openalliance.ad.p112a.p125g;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.openalliance.ad.inter.listener.AdListener;
import com.huawei.openalliance.ad.inter.listener.SplashListener;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import java.util.Arrays;

public class C1282f implements C1278b {
    private static int[] f2726a = new int[]{204, HttpStatus.SC_LOCKED, HttpStatus.SC_FAILED_DEPENDENCY, 425, 432, 442};

    public C1282f() {
        Arrays.sort(f2726a);
    }

    public void mo2442a(int i, AdListener adListener) {
        if (adListener != null && (adListener instanceof SplashListener)) {
            SplashListener splashListener = (SplashListener) adListener;
            if (200 == i) {
                return;
            }
            if (Arrays.binarySearch(f2726a, i) >= 0) {
                splashListener.onAdFailed(i);
            } else {
                splashListener.onAdFailed(499);
            }
        }
    }

    public boolean mo2443a(C1235b c1235b) {
        return 200 == c1235b.getRetcode__() || 206 == c1235b.getRetcode__();
    }
}
