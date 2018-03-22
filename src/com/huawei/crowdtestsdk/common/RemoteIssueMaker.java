package com.huawei.crowdtestsdk.common;

import android.content.Context;
import com.huawei.crowdtestsdk.devices.CommonDevice;

public class RemoteIssueMaker extends IssueMaker {
    public RemoteIssueMaker(long j, Context context, CommonDevice commonDevice, int i) {
        super(j);
        this.context = context;
        this.bugTypeId = i;
    }
}
