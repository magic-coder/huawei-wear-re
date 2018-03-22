package com.huawei.crowdtestsdk.bases;

import android.util.SparseIntArray;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.utils.ResUtil;

public class SendType {
    public static final SparseIntArray sendTypeResIdIndex = new SparseIntArray();

    public enum SEND_TYPE {
        DROP,
        DRAFT,
        SEND_NOW,
        SEND_ON_WIFI,
        UNKNOWN
    }

    static {
        sendTypeResIdIndex.put(SEND_TYPE.SEND_NOW.ordinal(), ResUtil.getResId(AppContext.getInstance().getApplicationContext(), "sdk_crowdtest_send_type_all", ResUtil.TYPE_STRING));
        sendTypeResIdIndex.put(SEND_TYPE.SEND_ON_WIFI.ordinal(), ResUtil.getResId(AppContext.getInstance().getApplicationContext(), "sdk_crowdtest_send_type_wifi", ResUtil.TYPE_STRING));
    }
}
