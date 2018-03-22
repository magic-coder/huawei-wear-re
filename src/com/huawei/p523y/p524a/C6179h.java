package com.huawei.p523y.p524a;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.p063b.C4715d;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C4999b;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5003f;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5007k;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DataOtaParametersV2;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwservicesmgr.C5368p;
import com.huawei.hwservicesmgr.j;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

import java.io.File;

/* compiled from: HWOTAV2Mgr */
public class C6179h extends C6172a {
    private Context f21662a = null;
    private j f21663b = null;
    private C5368p f21664c = null;
    private C4999b f21665d;
    private String f21666e;
    private String f21667f;
    private int f21668g;
    private IBaseResponseCallback f21669h = new C6180i(this);
    private IBaseResponseCallback f21670i = new C6181j(this);

    C6179h(Context context) {
        super(context);
        this.f21662a = context;
        this.f21665d = C4999b.m24006a(context);
    }

    public void mo5184a(String str, int i, String str2, j jVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jVar == null) {
            C2538c.e("HWOTAV2Mgr", new Object[]{"OTA V2 transferOtaFile ,parameter is error!!!"});
            if (jVar != null) {
                try {
                    jVar.a(109001, "OTA V2 transferOtaFile ,parameter is error!!!");
                    return;
                } catch (RemoteException e) {
                    C2538c.e("HWOTAV2Mgr", new Object[]{"OTA V2 transferOtaFile ,parameter is error!!! " + e.getMessage()});
                    return;
                }
            }
            return;
        }
        this.f21666e = str2;
        this.f21667f = str;
        this.f21663b = jVar;
        this.f21668g = i;
        C6172a.m28559a(this.f21669h);
        m28609b(str, i, str2, this.f21663b);
    }

    private void m28609b(String str, int i, String str2, j jVar) {
        C2538c.c("HWOTAV2Mgr", new Object[]{"Enter getIsUpdate() updateMode = " + i});
        try {
            if (TextUtils.isEmpty(str2)) {
                C2538c.e("HWOTAV2Mgr", new Object[]{"---transferOtaFile V2, filePath is null---"});
                jVar.a(104003, "升级文件不存在 ");
            } else if (new File(str2).exists()) {
                C2538c.c("HWOTAV2Mgr", new Object[]{" Enter getIsUpdate()"});
                C2538c.c("HWOTAV2Mgr", new Object[]{"getIsUpdate(),component_size = " + ((int) C5007k.m24047a(str2))});
                m28605a(str, r0, i);
            } else {
                C2538c.e("HWOTAV2Mgr", new Object[]{"file is not exist"});
                jVar.a(104003, "升级文件不存在 ");
            }
        } catch (Exception e) {
            C2538c.e("HWOTAV2Mgr", new Object[]{"---getIsUpdate Exception---e = " + e.getMessage()});
        }
    }

    private void m28605a(String str, int i, int i2) {
        String e = C0973a.e(str);
        e = C0973a.a(1) + C0973a.a(e.length() / 2) + e;
        String str2 = C0973a.a(2) + C0973a.a(2) + C0973a.a(i);
        e = e + str2 + (C0973a.a(3) + C0973a.a(1) + C0973a.a(i2));
        C2538c.c("HWOTAV2Mgr", new Object[]{"5.9.1 queryOtaAllow : " + e});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(9);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataContent(C0973a.b(e));
        deviceCommand.setDataLen(C0973a.b(e).length);
        com.huawei.n.c.a(this.f21662a).a(deviceCommand);
    }

    private void m28604a(Object obj) {
        try {
            C5003f c5003f = (C5003f) obj;
            int a = c5003f.m24036a();
            int b = c5003f.m24038b();
            C2538c.c("HWOTAV2Mgr", new Object[]{"查询单板是否允许升级，Response: errorCode = " + a + ", batteryThreshold = " + b});
            if (a == 100000) {
                m28614e();
            } else if (-1 != b) {
                this.f21663b.a(a, String.valueOf(b));
            } else {
                this.f21663b.a(a, "");
            }
        } catch (Exception e) {
            C2538c.e("HWOTAV2Mgr", new Object[]{"---queryOtaAllowHandle Exception---e = " + e.getMessage()});
        }
    }

    private void m28608b(Object obj) {
        try {
            int[] iArr = (int[]) obj;
            if (100000 != iArr[0]) {
                this.f21663b.a(iArr[0], C4715d.m22592a(iArr[0]));
            }
        } catch (Exception e) {
            C2538c.e("HWOTAV2Mgr", new Object[]{"---errorCodeHandle Exception---e = " + e.getMessage()});
        }
    }

    private void m28614e() {
        C2538c.c("HWOTAV2Mgr", new Object[]{"升级协商参数 getOtaParametersV2() Enter ... "});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(9);
        deviceCommand.setCommandID(2);
        deviceCommand.setDataContent(null);
        deviceCommand.setDataLen(0);
        com.huawei.n.c.a(this.f21662a).a(deviceCommand);
    }

    private void m28611c(Object obj) {
        DataOtaParametersV2 dataOtaParametersV2 = (DataOtaParametersV2) obj;
        C2538c.c("HWOTAV2Mgr", new Object[]{"开始通知单板准备升级"});
        m28615f();
        try {
            com.huawei.n.c.a(this.f21662a).a(this.f21666e, this.f21667f, new Gson().toJson(dataOtaParametersV2), this.f21668g, this.f21663b);
        } catch (Exception e) {
            C2538c.e("HWOTAV2Mgr", new Object[]{"getOtaParametersV2handle() TLV error = " + e.getMessage()});
        }
    }

    private void m28615f() {
        C2538c.c("HWOTAV2Mgr", new Object[]{"5.9.9 APP升级状态通知单板"});
        String str = C0973a.a(1) + C0973a.a(1) + C0973a.a(1);
        C2538c.c("HWOTAV2Mgr", new Object[]{"5.9.9 otaStatusData : " + str});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(9);
        deviceCommand.setCommandID(9);
        deviceCommand.setDataContent(C0973a.b(str));
        deviceCommand.setDataLen(C0973a.b(str).length);
        com.huawei.n.c.a(this.f21662a).a(deviceCommand);
        C6172a.m28560b();
    }

    public void mo5185a(String str, C5368p c5368p) {
        this.f21664c = c5368p;
        m28605a(str, 256, 2);
        C6172a.m28559a(this.f21670i);
    }

    private void m28613d(Object obj) {
        try {
            int a = ((C5003f) obj).m24036a();
            C2538c.b("HWOTAV2Mgr", new Object[]{"查询单板是否允许静默升级，Response: errorCode = " + a});
            if (a == 100000) {
                this.f21664c.m25849a(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                return;
            }
            this.f21664c.m25849a(a, "设备不允许升级");
            C6172a.m28560b();
        } catch (Exception e) {
            C2538c.e("HWOTAV2Mgr", new Object[]{"---queryOtaAllowHandle Exception---e = " + e.getMessage()});
        }
    }
}
