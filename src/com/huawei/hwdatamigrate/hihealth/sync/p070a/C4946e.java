package com.huawei.hwdatamigrate.hihealth.sync.p070a;

import android.util.SparseArray;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;

/* compiled from: ExceptionStr */
public class C4946e {
    private static final SparseArray<String> f18025a = new SparseArray();

    static {
        f18025a.put(1, "SYNC_EX: CLOUD_NO_ANS ");
        f18025a.put(99, "SYNC_EX:INTERFACE_NOT_AVAILABLE ");
        f18025a.put(100, "SYNC_EX:REACH_FLOW_THRESHOLD ");
        f18025a.put(101, "SYNC_EX:CLOUD_BUSY ");
        f18025a.put(999, "SYNC_EX:INTERFACE_NEED_UPGRADE ");
        f18025a.put(1001, "SYNC_EX: ILLEGAL_PARAMETERS ");
        f18025a.put(1002, "SYNC_EX: AUTH_FAILED ");
        f18025a.put(1003, "SYNC_EX: SESSION_TIMEOUT ");
        f18025a.put(1004, "SYNC_EX: TOKEN_EXPIRED ");
        f18025a.put(1005, "SYNC_EX: AUTH_VERIFY_FAILED ");
        f18025a.put(PayStatusCodes.PAY_STATE_PARAM_ERROR, "SYNC_EX: NO_HUID_FOUND ");
        f18025a.put(PayStatusCodes.PAY_STATE_TIME_OUT, "SYNC_EX: NO_CUSTOM_ATTRIBUTES ");
        f18025a.put(30003, "SYNC_EX: NO_SUCH_PRODUCT_ID ");
        f18025a.put(30004, "SYNC_EX: NO_DEVICE_FOUND ");
        f18025a.put(PayStatusCodes.PAY_STATE_NET_ERROR, "SYNC_EX: ILLEGAL_DEVICE ");
        f18025a.put(PayStatusCodes.PAY_OTHER_ERROR, "SYNC_EX: USER_ATTRIBUTES_ALL_NULL ");
        f18025a.put(30007, "SYNC_EX: NO_USER_PROFILE ");
        f18025a.put(201001, "SYNC_EX: NOT_LOGIN_OR_ILLEGAL_HUID ");
        f18025a.put(9999, "SYNC_EX: SYSTEM_ERROR ");
    }

    public static String m23813a(int i) {
        return (String) f18025a.get(i);
    }
}
