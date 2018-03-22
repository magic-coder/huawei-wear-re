package com.huawei.hwservicesmgr.p076a.p078b;

import android.os.Message;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskManager */
class C5340m implements IBaseResponseCallback {
    final /* synthetic */ d f19081a;

    C5340m(d dVar) {
        this.f19081a = dVar;
    }

    public void onResponse(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length < 2) {
            C2538c.e("HWFileTransferTaskManager", new Object[]{"onResponse(), error data, return"});
            return;
        }
        byte b = bArr[1];
        C2538c.c("HWFileTransferTaskManager", new Object[]{"当前的command id = " + b});
        if (TagName.IDENTIFYING_TYPE == b) {
            C2538c.c("HWFileTransferTaskManager", new Object[]{"当前可维可测状态 = " + d.b(this.f19081a) + "==" + false});
            if (d.b(this.f19081a)) {
                C2538c.c("HWFileTransferTaskManager", new Object[]{"当前可维可测状态繁忙或者不支持！"});
            } else {
                C2538c.c("HWFileTransferTaskManager", new Object[]{"当前可维可测状态繁忙或者不支持！"});
            }
        } else if (d.a(this.f19081a) != null) {
            Message message = new Message();
            message.what = b;
            message.obj = bArr;
            d.a(this.f19081a).sendMessage(message);
        }
    }
}
