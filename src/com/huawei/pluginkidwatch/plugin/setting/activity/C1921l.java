package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.hwcloudmodel.callback.a;

/* compiled from: BindbyQrActivity */
class C1921l implements a<Boolean> {
    final /* synthetic */ String f6687a;
    final /* synthetic */ BindbyQrActivity f6688b;

    C1921l(BindbyQrActivity bindbyQrActivity, String str) {
        this.f6688b = bindbyQrActivity;
        this.f6687a = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m10116a(java.lang.Boolean r10, java.lang.String r11, boolean r12) {
        /*
        r9 = this;
        r1 = -1;
        r3 = 0;
        r2 = 1;
        r0 = r9.f6688b;
        r0 = r0.f6266b;
        r4 = new java.lang.Object[r2];
        r5 = "matb resetManagerPreCheck operationResult ...";
        r4[r3] = r5;
        com.huawei.p190v.C2538c.m12677c(r0, r4);
        if (r12 == 0) goto L_0x00c1;
    L_0x0014:
        r0 = r9.f6688b;
        r0 = r0.f6266b;
        r4 = new java.lang.Object[r2];
        r5 = "matb resetManagerPreCheck 1111 号码变更!!!";
        r4[r3] = r5;
        com.huawei.p190v.C2538c.m12677c(r0, r4);
        r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0098 }
        r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0098 }
        r4 = com.huawei.hwcloudmodel.model.kidsdevice.ResetManagerPreCheckRsp.class;
        r0 = r0.fromJson(r11, r4);	 Catch:{ JsonSyntaxException -> 0x0098 }
        r0 = (com.huawei.hwcloudmodel.model.kidsdevice.ResetManagerPreCheckRsp) r0;	 Catch:{ JsonSyntaxException -> 0x0098 }
        if (r0 == 0) goto L_0x003f;
    L_0x0032:
        r1 = r0.getResultCode();	 Catch:{ JsonSyntaxException -> 0x0098 }
        r4 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0098 }
        r0 = r0.getManagerPhoneNum();	 Catch:{ JsonSyntaxException -> 0x0098 }
        r4.f6263A = r0;	 Catch:{ JsonSyntaxException -> 0x0098 }
    L_0x003f:
        r0 = r1;
    L_0x0040:
        r1 = r9.f6688b;
        r1 = r1.f6266b;
        r4 = new java.lang.Object[r2];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "matb resetManagerPreCheck 1111 号码变更!!! mPhoneNum = ";
        r5 = r5.append(r6);
        r6 = r9.f6688b;
        r6 = r6.f6263A;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r4[r3] = r5;
        com.huawei.p190v.C2538c.m12677c(r1, r4);
        r1 = r9.f6688b;
        r1 = r1.f6288x;
        if (r1 == 0) goto L_0x01ef;
    L_0x006e:
        if (r0 != 0) goto L_0x01ef;
    L_0x0070:
        r0 = r9.f6688b;
        r0 = r0.f6288x;
        r1 = new com.huawei.pluginkidwatch.plugin.setting.activity.m;
        r1.<init>(r9);
        r0.post(r1);
        r0 = r2;
    L_0x007f:
        if (r0 != 0) goto L_0x0097;
    L_0x0081:
        r0 = r9.f6688b;
        r0 = r0.f6288x;
        if (r0 == 0) goto L_0x0097;
    L_0x0089:
        r0 = r9.f6688b;
        r0 = r0.f6288x;
        r1 = new com.huawei.pluginkidwatch.plugin.setting.activity.p;
        r1.<init>(r9);
        r0.post(r1);
    L_0x0097:
        return;
    L_0x0098:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        r4 = r9.f6688b;
        r4 = r4.f6266b;
        r5 = new java.lang.Object[r2];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "matb resetManagerPreCheck 1111  json exception :";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r3] = r1;
        com.huawei.p190v.C2538c.m12677c(r4, r5);
        goto L_0x0040;
    L_0x00c1:
        r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = com.huawei.hwcloudmodel.model.kidsdevice.ResetManagerPreCheckRsp.class;
        r0 = r0.fromJson(r11, r4);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = (com.huawei.hwcloudmodel.model.kidsdevice.ResetManagerPreCheckRsp) r0;	 Catch:{ JsonSyntaxException -> 0x0172 }
        if (r0 == 0) goto L_0x00dd;
    L_0x00d0:
        r1 = r0.getResultCode();	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.getManagerPhoneNum();	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4.f6263A = r0;	 Catch:{ JsonSyntaxException -> 0x0172 }
    L_0x00dd:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6266b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ JsonSyntaxException -> 0x0172 }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r6.<init>();	 Catch:{ JsonSyntaxException -> 0x0172 }
        r7 = "matb resetManagerPreCheck operationResult resultCode = ";
        r6 = r6.append(r7);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r6 = r6.append(r1);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r7 = "  mPhoneNum = ";
        r6 = r6.append(r7);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r7 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r7 = r7.f6263A;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r6 = r6.append(r7);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r6 = r6.toString();	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4[r5] = r6;	 Catch:{ JsonSyntaxException -> 0x0172 }
        com.huawei.p190v.C2538c.m12677c(r0, r4);	 Catch:{ JsonSyntaxException -> 0x0172 }
        switch(r1) {
            case 0: goto L_0x0137;
            case 1001: goto L_0x0160;
            case 1003: goto L_0x019b;
            case 1004: goto L_0x01ad;
            case 13237: goto L_0x01c0;
            case 13238: goto L_0x01d3;
            default: goto L_0x0112;
        };	 Catch:{ JsonSyntaxException -> 0x0172 }
    L_0x0112:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6266b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ JsonSyntaxException -> 0x0172 }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r6.<init>();	 Catch:{ JsonSyntaxException -> 0x0172 }
        r7 = "matb resetManagerPreCheck unknow error!!!  resultCode = ";
        r6 = r6.append(r7);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r1 = r6.append(r1);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r1 = r1.toString();	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4[r5] = r1;	 Catch:{ JsonSyntaxException -> 0x0172 }
        com.huawei.p190v.C2538c.m12677c(r0, r4);	 Catch:{ JsonSyntaxException -> 0x0172 }
    L_0x0134:
        r0 = r3;
        goto L_0x007f;
    L_0x0137:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6266b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = 0;
        r5 = "matb resetManagerPreCheck 2222 号码变更!!!";
        r1[r4] = r5;	 Catch:{ JsonSyntaxException -> 0x0172 }
        com.huawei.p190v.C2538c.m12677c(r0, r1);	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6288x;	 Catch:{ JsonSyntaxException -> 0x0172 }
        if (r0 == 0) goto L_0x0134;
    L_0x0150:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x01ec }
        r0 = r0.f6288x;	 Catch:{ JsonSyntaxException -> 0x01ec }
        r1 = new com.huawei.pluginkidwatch.plugin.setting.activity.n;	 Catch:{ JsonSyntaxException -> 0x01ec }
        r1.<init>(r9);	 Catch:{ JsonSyntaxException -> 0x01ec }
        r0.post(r1);	 Catch:{ JsonSyntaxException -> 0x01ec }
        r3 = r2;
        goto L_0x0134;
    L_0x0160:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6266b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = 0;
        r5 = "matb resetManagerPreCheck parameter wrongful!!!";
        r1[r4] = r5;	 Catch:{ JsonSyntaxException -> 0x0172 }
        com.huawei.p190v.C2538c.m12677c(r0, r1);	 Catch:{ JsonSyntaxException -> 0x0172 }
        goto L_0x0134;
    L_0x0172:
        r0 = move-exception;
        r1 = r3;
    L_0x0174:
        r4 = r9.f6688b;
        r4 = r4.f6266b;
        r2 = new java.lang.Object[r2];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "matb resetManagerPreCheck 2222  json exception :";
        r5 = r5.append(r6);
        r0 = r0.getMessage();
        r0 = r5.append(r0);
        r0 = r0.toString();
        r2[r3] = r0;
        com.huawei.p190v.C2538c.m12677c(r4, r2);
        r0 = r1;
        goto L_0x007f;
    L_0x019b:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6266b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = 0;
        r5 = "matb resetManagerPreCheck conversation expire!!!";
        r1[r4] = r5;	 Catch:{ JsonSyntaxException -> 0x0172 }
        com.huawei.p190v.C2538c.m12677c(r0, r1);	 Catch:{ JsonSyntaxException -> 0x0172 }
        goto L_0x0134;
    L_0x01ad:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6266b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = 0;
        r5 = "matb resetManagerPreCheck token expire!!!";
        r1[r4] = r5;	 Catch:{ JsonSyntaxException -> 0x0172 }
        com.huawei.p190v.C2538c.m12677c(r0, r1);	 Catch:{ JsonSyntaxException -> 0x0172 }
        goto L_0x0134;
    L_0x01c0:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6266b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ JsonSyntaxException -> 0x0172 }
        r4 = 0;
        r5 = "matb resetManagerPreCheck manager number not same!!!";
        r1[r4] = r5;	 Catch:{ JsonSyntaxException -> 0x0172 }
        com.huawei.p190v.C2538c.m12677c(r0, r1);	 Catch:{ JsonSyntaxException -> 0x0172 }
        goto L_0x0134;
    L_0x01d3:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x0172 }
        r0 = r0.f6288x;	 Catch:{ JsonSyntaxException -> 0x0172 }
        if (r0 == 0) goto L_0x0134;
    L_0x01db:
        r0 = r9.f6688b;	 Catch:{ JsonSyntaxException -> 0x01ec }
        r0 = r0.f6288x;	 Catch:{ JsonSyntaxException -> 0x01ec }
        r1 = new com.huawei.pluginkidwatch.plugin.setting.activity.o;	 Catch:{ JsonSyntaxException -> 0x01ec }
        r1.<init>(r9);	 Catch:{ JsonSyntaxException -> 0x01ec }
        r0.post(r1);	 Catch:{ JsonSyntaxException -> 0x01ec }
        r3 = r2;
        goto L_0x0134;
    L_0x01ec:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0174;
    L_0x01ef:
        r0 = r3;
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.plugin.setting.activity.l.a(java.lang.Boolean, java.lang.String, boolean):void");
    }
}
