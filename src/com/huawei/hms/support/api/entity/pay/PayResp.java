package com.huawei.hms.support.api.entity.pay;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.security.SecureRandom;

public class PayResp implements IMessageEntity {
    @C0860a
    public PendingIntent pendingIntent;
    @C0860a
    public int retCode;

    public PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public void setPendingIntent(Context context, Intent intent) {
        this.pendingIntent = PendingIntent.getActivity(context, new SecureRandom().nextInt(), intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }
}
