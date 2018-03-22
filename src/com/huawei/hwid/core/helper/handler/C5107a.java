package com.huawei.hwid.core.helper.handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.p430b.p431a.C5139b;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;

/* compiled from: RequestCallback */
public class C5107a {
    protected Context f18415b;

    public ArrayList<Integer> m24600c(Bundle bundle) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("UIHandlerErrCodeList");
        if (integerArrayList == null) {
            return new ArrayList();
        }
        return integerArrayList;
    }

    public boolean m24601d(Bundle bundle) {
        return bundle.getBoolean("isUIHandlerAllErrCode");
    }

    public C5107a(Context context) {
        this.f18415b = context;
    }

    public void mo4615a(Bundle bundle) {
    }

    public void mo4616b(Bundle bundle) {
    }

    public void m24602e(Bundle bundle) {
        try {
            int i = bundle.getInt("responseCode");
            int i2 = bundle.getInt("resultCode");
            C5165e.m24906b("RequestCallback", "disposeRequestMessage  orgin responseCode = " + i + " orgin resultCode = " + i2);
            int a = C5139b.m24806a(bundle, bundle.getInt(Constant.KEY_ERROR_CODE));
            String string = bundle.getString(Constant.KEY_ERROR_DESC);
            Bundle bundle2;
            Parcelable errorStatus;
            if (3000 == i) {
                bundle2 = new Bundle();
                errorStatus = new ErrorStatus(FragmentTransaction.TRANSIT_FRAGMENT_FADE, "token invalid");
                C5165e.m24912e("RequestCallback", "error: " + errorStatus.toString());
                bundle2.putParcelable("requestError", errorStatus);
                mo4616b(bundle2);
            } else if (200 == i || m24601d(bundle)) {
                ArrayList c = m24600c(bundle);
                if (i2 == 0 || c.contains(Integer.valueOf(a)) || m24601d(bundle)) {
                    bundle2 = new Bundle();
                    if (i2 == 0) {
                        mo4615a(bundle);
                        return;
                    }
                    errorStatus = new ErrorStatus(a, string);
                    C5165e.m24912e("RequestCallback", "error: " + errorStatus.toString());
                    bundle2.putParcelable("requestError", errorStatus);
                    bundle2.putBoolean("isRequestSuccess", true);
                    mo4616b(bundle2);
                    return;
                }
                C5165e.m24904a("RequestManager", "errorCode = " + a + ", errorDesc = " + C5203g.m25316a(string));
                Object a2 = C5139b.m24807a(this.f18415b, a);
                if (TextUtils.isEmpty(a2)) {
                    i = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                } else {
                    i = a;
                }
                r2 = new Bundle();
                r3 = new ErrorStatus(i, a2);
                C5165e.m24912e("RequestCallback", "error: " + r3.toString());
                r2.putParcelable("requestError", r3);
                mo4616b(r2);
            } else {
                String str = "";
                if (i == 307) {
                    i2 = 70001104;
                }
                C5165e.m24906b("RequestManager", "network is unavailable, code = " + i);
                String a3 = m24597a(i, i2);
                if (!(i == 3008 || i == 1007)) {
                    i = InputDeviceCompat.SOURCE_TOUCHSCREEN;
                }
                r2 = new Bundle();
                r3 = new ErrorStatus(i, a3);
                C5165e.m24912e("RequestCallback", "error: " + r3.toString());
                r2.putParcelable("requestError", r3);
                C5165e.m24906b("RequestCallback", "time: " + C5166b.m24951g("yyyy/MM/dd HH:mm:ss:SSS"));
                mo4616b(r2);
            }
        } catch (Throwable th) {
            C5165e.m24911d("RequestCallback", th.getMessage(), th);
        }
    }

    private String m24597a(int i, int i2) {
        int a;
        if (1007 == i) {
            a = C5180k.m25027a(this.f18415b, "CS_network_connect_error");
        } else {
            a = C5180k.m25027a(this.f18415b, "CS_ERR_for_cannot_conn_service");
        }
        return this.f18415b.getString(a);
    }
}
