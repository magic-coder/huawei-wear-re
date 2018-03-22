package com.huawei.hwid.openapi.p442c;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.OpenHwID;
import com.huawei.hwid.openapi.out.IHwIDCallBack;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5246b;
import com.huawei.hwid.openapi.p445e.C5251f;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;
import com.huawei.hwid.openapi.p445e.p448c.C5247a;
import java.util.HashMap;

public class C5231a {
    private static final String f18856g = C5213b.f18818a;
    ProgressDialog f18857a = null;
    AlertDialog f18858b = null;
    IHwIDCallBack f18859c = null;
    Activity f18860d = null;
    String f18861e = null;
    Bundle f18862f = null;

    public C5231a(Activity activity, String str, IHwIDCallBack iHwIDCallBack, Bundle bundle) {
        this.f18860d = activity;
        this.f18861e = str;
        this.f18862f = bundle;
        Log.i(f18856g, "HwIDProxy bundle is " + C5243e.m25421a(this.f18862f));
        this.f18857a = new ProgressDialog(activity);
        this.f18857a.setMessage(C5247a.m25440a(HWDeviceDFXConstants.ERROR_CODE_GET_FILE_NAME_ERROR));
        this.f18857a.requestWindowFeature(1);
        this.f18857a.setCanceledOnTouchOutside(false);
        m25392a(iHwIDCallBack);
    }

    private int m25376a(Bundle bundle, String str, int i) {
        if (bundle != null) {
            try {
                i = Integer.parseInt(String.valueOf(bundle.get(str)));
            } catch (Throwable th) {
            }
        }
        return i;
    }

    private void m25377a(Bundle bundle) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                stringBuffer.append(HwAccountConstants.BLANK).append(str).append("=").append(bundle.get(str)).append(",");
            }
        }
        stringBuffer.append(" heads:[");
        Bundle retHeads = OutReturn.getRetHeads(bundle);
        for (String str2 : retHeads.keySet()) {
            stringBuffer.append(str2).append("=").append(retHeads.get(str2)).append(",");
        }
        stringBuffer.append("]");
        Log.e(f18856g, "errInfo:" + stringBuffer.toString());
        m25382a(new Exception("server is err!"));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(C5247a.m25440a(10002)).append(OutReturn.getRetCode(bundle)).append("/").append(OutReturn.getRetResCode(bundle)).append("/").append(OutReturn.getErrInfo(bundle)).append(C5247a.m25440a(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE));
        m25384a(this.f18860d.getString(17039380), stringBuffer2.toString(), this.f18860d.getString(17039370), this.f18860d.getString(17039360));
    }

    private void m25382a(Exception exception) {
        Throwable exception2;
        if (exception == null) {
            exception2 = new Exception("unknown error!!");
        }
        Log.e(f18856g, exception2.toString(), exception2);
        m25395d();
        if (this.f18859c != null) {
            this.f18859c.onUserInfo(m25394c());
        }
    }

    private final void m25383a(String str) {
        try {
            OpenHwID.userInfoRequest(this.f18860d, new C5233c(this), str);
        } catch (Throwable e) {
            Log.e(f18856g, e.toString(), e);
        }
    }

    private void m25384a(String str, String str2, String str3, String str4) {
        OnClickListener c5234d = new C5234d(this);
        OnClickListener c5235e = new C5235e(this);
        if (this.f18858b != null && this.f18858b.isShowing()) {
            this.f18858b.dismiss();
        }
        this.f18858b = new Builder(this.f18860d).setTitle(str).setMessage(str2).setNegativeButton(17039360, c5235e).setPositiveButton(17039370, c5234d).show();
    }

    private void m25385b(Bundle bundle) {
        String nspstatus = OutReturn.getNSPSTATUS(bundle);
        int retCode = OutReturn.getRetCode(bundle);
        int a = m25376a(bundle, HwAccountConstants.EXTRA_OPLOG_ERROR, 0);
        if ("6".equals(nspstatus) || "102".equals(nspstatus)) {
            m25390g();
        } else if (2 == retCode || 1107 == a) {
            m25391a();
        } else if (100 == retCode || 102 == retCode) {
            m25389f();
        } else {
            m25377a(bundle);
        }
    }

    private void m25387b(String str) {
        if (str == null) {
            str = "";
        }
        try {
            C5246b.m25437a(this.f18860d, "userInfo", str);
        } catch (Throwable e) {
            Log.e(f18856g, e.toString(), e);
        }
    }

    private void m25389f() {
        Log.i(f18856g, "net work err!!");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C5247a.m25440a(10001)).append(C5247a.m25440a(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE));
        m25384a(this.f18860d.getString(17039380), stringBuffer.toString(), this.f18860d.getString(17039370), this.f18860d.getString(17039360));
    }

    private final void m25390g() {
        try {
            OpenHwID.authorize(this.f18860d, "https://www.huawei.com/auth/account", "oob", "mobile", new C5232b(this), this.f18861e, null, null);
        } catch (Throwable e) {
            Log.e(f18856g, e.toString(), e);
        }
    }

    public void m25391a() {
        Log.i(f18856g, "enter onUserCancel()");
        m25395d();
        if (this.f18859c != null) {
            this.f18859c.onUserInfo(m25394c());
        }
    }

    public void m25392a(IHwIDCallBack iHwIDCallBack) {
        this.f18859c = iHwIDCallBack;
    }

    public final void m25393b() {
        String accessToken = OpenHwID.getAccessToken(this.f18860d, this.f18861e, null, null);
        if (TextUtils.isEmpty(accessToken)) {
            m25390g();
        } else {
            m25383a(accessToken);
        }
    }

    public HashMap m25394c() {
        try {
            return C5251f.m25460a(C5246b.m25438b(this.f18860d, "userInfo", ""));
        } catch (Throwable e) {
            Log.e(f18856g, e.toString(), e);
            return new HashMap();
        }
    }

    public void m25395d() {
        m25387b(null);
        OpenHwID.logOut(this.f18860d, this.f18861e, null, null);
    }
}
