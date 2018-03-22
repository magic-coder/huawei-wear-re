package com.huawei.hwid.api.common.p424a;

import android.content.Context;
import com.huawei.cloudservice.opensdk.ResReqHandler;

/* compiled from: ResouceRequest */
class C5071c extends Thread {
    private Context f18300a = null;
    private C5069a f18301b = null;
    private ResReqHandler f18302c = null;

    public C5071c(Context context, C5069a c5069a, ResReqHandler resReqHandler) {
        this.f18300a = context;
        this.f18301b = c5069a;
        this.f18302c = resReqHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r5 = this;
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r5.f18300a;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = r5.f18301b;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = r2.m24392b();	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = com.huawei.hwid.api.common.p424a.C5070b.m24394a(r0, r2);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = r5.f18301b;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = r2.m24390a(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = "ReqResourceInThread";
        r3 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r3.<init>();	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r4 = "decode bundle = ";
        r3 = r3.append(r4);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r4 = com.huawei.hwid.core.encrypt.C5203g.m25314a(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r3 = r3.append(r4);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r3 = r3.toString();	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24904a(r2, r3);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        r3 = com.huawei.cloudservice.opensdk.OutReturn.getRetResCode(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        if (r2 != r3) goto L_0x0114;
    L_0x0038:
        r2 = "ReqResourceInThread";
        r3 = "redirect 302";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r2, r3);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = "res_head";
        r2 = r0.getBundle(r2);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        if (r2 == 0) goto L_0x0114;
    L_0x0047:
        r0 = "Location";
        r0 = r2.getString(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = "oob#";
        r2 = r0.contains(r2);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        if (r2 == 0) goto L_0x0106;
    L_0x0055:
        r2 = "oob#";
        r3 = "";
        r0 = r0.replace(r2, r3);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = com.huawei.hwid.api.common.p424a.C5070b.m24396b(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = "access_token";
        r0 = r2.containsKey(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        if (r0 == 0) goto L_0x0082;
    L_0x0069:
        r0 = "error";
        r0 = r2.containsKey(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        if (r0 != 0) goto L_0x0082;
    L_0x0071:
        r0 = "ReqResourceInThread";
        r1 = "isRequestSuccess";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r0, r1);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = r5.f18302c;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1 = com.huawei.cloudservice.opensdk.OutReturn.addSuccessCode(r2);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0.finish(r1);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
    L_0x0081:
        return;
    L_0x0082:
        r0 = "error";
        r0 = r2.containsKey(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        if (r0 == 0) goto L_0x00da;
    L_0x008a:
        r0 = "error";
        r0 = r2.getString(r0);	 Catch:{ NumberFormatException -> 0x00ce, Exception -> 0x00ed }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00ce, Exception -> 0x00ed }
    L_0x0094:
        r1 = "ReqResourceInThread";
        r3 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r3.<init>();	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r4 = "isRequestFail, res_code is: ";
        r3 = r3.append(r4);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r3 = r3.append(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r3 = r3.toString();	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r1, r3);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1 = r5.f18302c;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = com.huawei.cloudservice.opensdk.OutReturn.addFailCode(r2, r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1.finish(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        goto L_0x0081;
    L_0x00b6:
        r0 = move-exception;
        r1 = "ReqResourceInThread";
        r2 = r0.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r1, r2, r0);
        r1 = r5.f18302c;
        r0 = r0.getMessage();
        r0 = com.huawei.cloudservice.opensdk.OutReturn.creatRunTimeErrRet(r0);
        r1.finish(r0);
        goto L_0x0081;
    L_0x00ce:
        r0 = move-exception;
        r3 = "ReqResourceInThread";
        r0 = r0.getMessage();	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24908c(r3, r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = r1;
        goto L_0x0094;
    L_0x00da:
        r0 = "ReqResourceInThread";
        r1 = "isRequestFail, res_code is: 1000";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r0, r1);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = r5.f18302c;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = com.huawei.cloudservice.opensdk.OutReturn.addFailCode(r2, r1);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0.finish(r1);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        goto L_0x0081;
    L_0x00ed:
        r0 = move-exception;
        r1 = "ReqResourceInThread";
        r2 = r0.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r1, r2, r0);
        r1 = r5.f18302c;
        r0 = r0.getMessage();
        r0 = com.huawei.cloudservice.opensdk.OutReturn.creatRunTimeErrRet(r0);
        r1.finish(r0);
        goto L_0x0081;
    L_0x0106:
        r1 = r5.f18300a;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2 = new com.huawei.hwid.api.common.a.a;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r2.<init>(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r0 = r5.f18302c;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        com.huawei.hwid.api.common.p424a.C5072d.m24397a(r1, r2, r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        goto L_0x0081;
    L_0x0114:
        r1 = "ret_code";
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.putInt(r1, r2);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1 = "ReqResourceInThread";
        r2 = "isRequestFail";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r1, r2);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1 = "res_code";
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.getInt(r1, r2);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1 = r5.f18302c;	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        r1.finish(r0);	 Catch:{ NumberFormatException -> 0x00b6, Exception -> 0x00ed }
        goto L_0x0081;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.api.common.a.c.run():void");
    }
}
