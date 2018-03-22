package com.huawei.openalliance.ad.inter.listener;

import com.huawei.openalliance.ad.inter.data.MagLockAdInfo;
import java.util.List;

public interface MagLockListener extends AdListener {
    void onAdFailed(int i, List<String> list);

    void onAdSuccess(MagLockAdInfo magLockAdInfo);
}
