package com.huawei.crowdtestsdk.devices;

import android.content.Context;
import android.util.LongSparseArray;
import com.huawei.crowdtestsdk.common.IssueMaker;
import com.huawei.crowdtestsdk.common.RemoteIssueMaker;
import java.util.Date;

public class IssueMakerFactory {
    private static final LongSparseArray<IssueMaker> issueMakerList = new LongSparseArray();

    public static synchronized IssueMaker newIssueMaker(Context context, CommonDevice commonDevice, int i) {
        IssueMaker remoteIssueMaker;
        synchronized (IssueMakerFactory.class) {
            long time = new Date().getTime();
            remoteIssueMaker = new RemoteIssueMaker(time, context, commonDevice, i);
            issueMakerList.append(time, remoteIssueMaker);
        }
        return remoteIssueMaker;
    }

    public static synchronized void destroyIssueMaker(long j) {
        synchronized (IssueMakerFactory.class) {
            issueMakerList.remove(j);
        }
    }
}
