package com.huawei.hwfitnessmgr;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C4746m;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class an implements IBaseResponseCallback {
    final /* synthetic */ q f18155a;

    an(q qVar) {
        this.f18155a = qVar;
    }

    public void onResponse(int i, Object obj) {
        if (i != 0 || obj == null) {
            C2538c.e("HWFitnessMgr", new Object[]{"onResponse recv bt data ret=" + i});
        } else if (4 == this.f18155a.i()) {
            C4746m c4746m = (C4746m) new Gson().fromJson((String) obj, C4746m.class);
            if (c4746m == null) {
                C2538c.e("HWFitnessMgr", new Object[]{"HUAWEI_AF500 data is null"});
                return;
            }
            q.a(this.f18155a, i, c4746m);
        } else {
            byte[] bArr = (byte[]) obj;
            C2538c.c("HWFitnessMgr", new Object[]{"onResponse recv bt data" + C0973a.a(bArr)});
            switch (bArr[1]) {
                case (byte) 1:
                    q.a(this.f18155a, bArr, 1);
                    return;
                case (byte) 2:
                    q.a(this.f18155a, bArr, 10002);
                    return;
                case (byte) 3:
                    if (this.f18155a.f() != 0) {
                        q.a(this.f18155a, bArr);
                        return;
                    } else if (bArr.length <= 3 || TagName.ELECTRONIC_PUBLISH_START_TIME != bArr[2]) {
                        q.a(this.f18155a, 3, bArr);
                        return;
                    } else {
                        C2538c.e("HWFitnessMgr", new Object[]{"Get V0 today data command send timeout."});
                        return;
                    }
                case (byte) 4:
                    if (this.f18155a.f() != 0) {
                        q.b(this.f18155a, bArr);
                        return;
                    } else if (bArr.length <= 3 || TagName.ELECTRONIC_PUBLISH_START_TIME != bArr[2]) {
                        q.a(this.f18155a, 4, bArr);
                        return;
                    } else {
                        C2538c.e("HWFitnessMgr", new Object[]{"Get V0 frame count command send timeout."});
                        return;
                    }
                case (byte) 5:
                    if (this.f18155a.f() != 0) {
                        q.e(this.f18155a, bArr);
                        return;
                    } else if (bArr.length > 3 && TagName.ELECTRONIC_PUBLISH_START_TIME == bArr[2]) {
                        C2538c.e("HWFitnessMgr", new Object[]{"Get V0 detail data command send timeout."});
                        return;
                    } else if (2 == bArr.length) {
                        C2538c.c("HWFitnessMgr", new Object[]{"Clear V0 data success."});
                        return;
                    } else if (-1 != q.g(this.f18155a)) {
                        q.c(this.f18155a, bArr);
                        return;
                    } else {
                        q.d(this.f18155a, bArr);
                        return;
                    }
                case (byte) 6:
                    q.f(this.f18155a, bArr);
                    return;
                case (byte) 7:
                    q.a(this.f18155a, bArr, 7);
                    return;
                case (byte) 8:
                    q.g(this.f18155a, bArr);
                    return;
                case (byte) 9:
                    q.a(this.f18155a, bArr, 10002);
                    return;
                case (byte) 10:
                    q.h(this.f18155a, bArr);
                    return;
                case (byte) 11:
                    q.i(this.f18155a, bArr);
                    return;
                case (byte) 12:
                    q.j(this.f18155a, bArr);
                    return;
                case (byte) 13:
                    q.k(this.f18155a, bArr);
                    return;
                case (byte) 14:
                    q.a(this.f18155a, bArr, 14);
                    return;
                case (byte) 15:
                    q.l(this.f18155a, bArr);
                    return;
                case (byte) 16:
                    q.a(this.f18155a, bArr, 16);
                    return;
                case (byte) 18:
                    q.h(this.f18155a);
                    return;
                case (byte) 19:
                    q.a(this.f18155a, bArr, 19);
                    return;
                case (byte) 21:
                    q.m(this.f18155a, bArr);
                    return;
                case (byte) 22:
                    q.b(this.f18155a, bArr, 22);
                    return;
                case (byte) 27:
                    q.n(this.f18155a, bArr);
                    return;
                default:
                    return;
            }
        }
    }
}
