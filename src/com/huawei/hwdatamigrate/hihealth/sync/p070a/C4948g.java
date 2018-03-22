package com.huawei.hwdatamigrate.hihealth.sync.p070a;

import android.util.SparseArray;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.p190v.C2538c;

/* compiled from: SyncErrorMgr */
public class C4948g {
    private static final SparseArray<C4942d> f18026a = new SparseArray();

    static {
        f18026a.put(1, new C4944b());
        f18026a.put(99, new C4944b());
        f18026a.put(100, new C4944b());
        f18026a.put(101, new C4944b());
        f18026a.put(999, new C4944b());
        f18026a.put(1001, new C4943a());
        f18026a.put(1002, new C4944b());
        f18026a.put(1003, new C4944b());
        f18026a.put(1004, new C4944b());
        f18026a.put(1005, new C4944b());
        f18026a.put(PayStatusCodes.PAY_STATE_PARAM_ERROR, new C4947f());
        f18026a.put(PayStatusCodes.PAY_STATE_TIME_OUT, new C4944b());
        f18026a.put(30003, new C4945c());
        f18026a.put(30004, new C4945c());
        f18026a.put(PayStatusCodes.PAY_STATE_NET_ERROR, new C4944b());
        f18026a.put(PayStatusCodes.PAY_OTHER_ERROR, new C4944b());
        f18026a.put(30007, new C4944b());
        f18026a.put(201001, new C4944b());
        f18026a.put(9999, new C4944b());
    }

    public static boolean m23815a(CloudCommonReponse cloudCommonReponse, boolean z) throws h {
        if (cloudCommonReponse == null) {
            throw new h("SYNC_EX: CLOUD_NO_ANS ");
        }
        int resultCode = cloudCommonReponse.getResultCode();
        if (resultCode == 0) {
            return true;
        }
        C4942d c4942d = (C4942d) f18026a.get(resultCode);
        if (c4942d == null) {
            throw new h("SYNC_EX: UNDEFINE_ERROR ");
        }
        C2538c.e("HiH_SyncErrorMgr", new Object[]{"checkCloudAns rsp is ", cloudCommonReponse.getClass(), ", resultCode is ", Integer.valueOf(resultCode)});
        c4942d.mo4575a(cloudCommonReponse);
        return false;
    }
}
