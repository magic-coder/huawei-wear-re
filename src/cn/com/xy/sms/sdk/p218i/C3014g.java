package cn.com.xy.sms.sdk.p218i;

final class C3014g extends Thread {
    C3014g() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r2 = "xiaoyuan_taskqueue";
        r10.setName(r2);	 Catch:{ Throwable -> 0x0056 }
        r2 = cn.com.xy.sms.sdk.p218i.C3013f.f10174b;	 Catch:{ Throwable -> 0x0056 }
        android.os.Process.setThreadPriority(r2);	 Catch:{ Throwable -> 0x0056 }
    L_0x000b:
        r2 = cn.com.xy.sms.sdk.p218i.C3013f.f10173a;	 Catch:{ Throwable -> 0x003b }
        r2 = r2.take();	 Catch:{ Throwable -> 0x003b }
        r0 = r2;
        r0 = (cn.com.xy.sms.sdk.p218i.C3015h) r0;	 Catch:{ Throwable -> 0x003b }
        r8 = r0;
        if (r8 == 0) goto L_0x000b;
    L_0x0017:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003b }
        r3 = "task =";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x003b }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x003b }
        r3 = " type: ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x003b }
        r3 = r8.f10176a;	 Catch:{ Throwable -> 0x003b }
        r2.append(r3);	 Catch:{ Throwable -> 0x003b }
        r2 = r8.f10176a;	 Catch:{ Throwable -> 0x003b }
        switch(r2) {
            case 1: goto L_0x0034;
            case 2: goto L_0x0061;
            case 3: goto L_0x0065;
            case 4: goto L_0x006b;
            case 5: goto L_0x0071;
            case 6: goto L_0x0077;
            case 7: goto L_0x007d;
            case 8: goto L_0x0081;
            case 9: goto L_0x008a;
            case 10: goto L_0x009c;
            case 11: goto L_0x00a9;
            case 12: goto L_0x00b0;
            case 13: goto L_0x00c4;
            case 14: goto L_0x00dd;
            case 15: goto L_0x00fc;
            case 16: goto L_0x0141;
            default: goto L_0x0033;
        };	 Catch:{ Throwable -> 0x003b }
    L_0x0033:
        goto L_0x000b;
    L_0x0034:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r3 = 1;
        cn.com.xy.sms.sdk.p214f.C2978a.m13401a(r2, r3);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x003b:
        r2 = move-exception;
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0056 }
        r5 = "startTaskQueue: ";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0056 }
        r5 = r2.getMessage();	 Catch:{ Throwable -> 0x0056 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0056 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0056 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r2);	 Catch:{ Throwable -> 0x0056 }
        goto L_0x000b;
    L_0x0056:
        r2 = move-exception;
        r3 = "XIAOYUAN";
        r4 = r2.getMessage();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r2);
        return;
    L_0x0061:
        cn.com.xy.sms.sdk.p229l.C3056u.m13720a();	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x0065:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.C2959z.m13308a(r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x006b:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.C2959z.m13311b(r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x0071:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.aa.m13213a(r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x0077:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.C2949p.m13285a(r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x007d:
        cn.com.xy.sms.sdk.p218i.C3011d.m13535a();	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x0081:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.ag.m13239a(r2);	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p218i.C3009b.m13533a();	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x008a:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.p212a.C2925c.m13167a(r2);	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p218i.C3008a.m13531a();	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p220j.p224d.C3026b.m13568b();	 Catch:{ Throwable -> 0x003b }
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.p212a.C2925c.m13173c(r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x009c:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.p212a.C2925c.m13172b(r2);	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p218i.C3008a.m13531a();	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p220j.p224d.C3026b.m13569c();	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x00a9:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.C2941h.m13253a(r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x00b0:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r3 = "state";
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x003b }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x003b }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p229l.ad.m13586a(r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x00c4:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r3 = "phoneNum";
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x003b }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x003b }
        r3 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r4 = "dbresoult";
        r3 = r3.get(r4);	 Catch:{ Throwable -> 0x003b }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p220j.p223c.C3023a.m13558a(r2, r3);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x00dd:
        r3 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r2 = "phoneNumber";
        r2 = r3.get(r2);	 Catch:{ Throwable -> 0x003b }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x003b }
        r4 = "isSuccess";
        r3 = r3.get(r4);	 Catch:{ Throwable -> 0x003b }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x003b }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ Throwable -> 0x003b }
        r3 = r3.booleanValue();	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p208d.p211c.ah.m13245a(r2, r3);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x00fc:
        r2 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r3 = "msgId";
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x003b }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x003b }
        r3 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r4 = "num";
        r3 = r3.get(r4);	 Catch:{ Throwable -> 0x003b }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x003b }
        r4 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r5 = "cnum";
        r4 = r4.get(r5);	 Catch:{ Throwable -> 0x003b }
        r4 = (java.lang.String) r4;	 Catch:{ Throwable -> 0x003b }
        r5 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r6 = "msg";
        r5 = r5.get(r6);	 Catch:{ Throwable -> 0x003b }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x003b }
        r6 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        r7 = "smsTime";
        r6 = r6.get(r7);	 Catch:{ Throwable -> 0x003b }
        r6 = (java.lang.String) r6;	 Catch:{ Throwable -> 0x003b }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x003b }
        r6 = r6.longValue();	 Catch:{ Throwable -> 0x003b }
        r8 = r8.m13540a();	 Catch:{ Throwable -> 0x003b }
        r9 = 0;
        cn.com.xy.sms.p204a.C2903e.m13075a(r2, r3, r4, r5, r6, r8, r9);	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x0141:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x003b }
        r4 = 35;
        r6 = 2592000000; // 0x9a7ec800 float:-5.2687528E-23 double:1.280618154E-314;
        r4 = cn.com.xy.sms.sdk.p213e.C2973a.m13350a(r4, r6);	 Catch:{ Throwable -> 0x003b }
        r4 = r2 - r4;
        r2 = "tb_shard_data";
        r3 = "msg_time<=?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x0173 }
        r7 = 0;
        r9 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x0173 }
        r6[r7] = r9;	 Catch:{ Throwable -> 0x0173 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13134a(r2, r3, r6);	 Catch:{ Throwable -> 0x0173 }
    L_0x0164:
        r3 = r8.f10177b;	 Catch:{ Throwable -> 0x003b }
        if (r3 == 0) goto L_0x016e;
    L_0x0168:
        r2 = r3.isEmpty();	 Catch:{ Throwable -> 0x003b }
        if (r2 == 0) goto L_0x0197;
    L_0x016e:
        cn.com.xy.sms.sdk.p220j.p224d.C3026b.m13563a();	 Catch:{ Throwable -> 0x003b }
        goto L_0x000b;
    L_0x0173:
        r2 = move-exception;
        r3 = "XIAOYUAN";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003b }
        r7 = "ShardDataManager deleteBeforeLastTime lastTime:";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x003b }
        r4 = r6.append(r4);	 Catch:{ Throwable -> 0x003b }
        r5 = " error:";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x003b }
        r5 = r2.getMessage();	 Catch:{ Throwable -> 0x003b }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x003b }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x0164;
    L_0x0197:
        r2 = "num";
        r2 = r3.get(r2);	 Catch:{ Throwable -> 0x01e6 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x01e6 }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13646b(r2);	 Catch:{ Throwable -> 0x01e6 }
        r2 = "msg";
        r2 = r3.get(r2);	 Catch:{ Throwable -> 0x01e6 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x01e6 }
        r5 = "smsTime";
        r3 = r3.get(r5);	 Catch:{ Throwable -> 0x01e6 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x01e6 }
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r4);	 Catch:{ Throwable -> 0x01e6 }
        if (r5 != 0) goto L_0x016e;
    L_0x01ba:
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r2);	 Catch:{ Throwable -> 0x01e6 }
        if (r5 != 0) goto L_0x016e;
    L_0x01c0:
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r3);	 Catch:{ Throwable -> 0x01e6 }
        if (r5 != 0) goto L_0x016e;
    L_0x01c6:
        r2 = r2.trim();	 Catch:{ Throwable -> 0x01e6 }
        r2 = cn.com.xy.sms.sdk.p213e.C2973a.m13382d(r2);	 Catch:{ Throwable -> 0x01e6 }
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r2);	 Catch:{ Throwable -> 0x01e6 }
        if (r5 != 0) goto L_0x016e;
    L_0x01d4:
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13654f(r2);	 Catch:{ Throwable -> 0x01e6 }
        r6 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r5);	 Catch:{ Throwable -> 0x01e6 }
        if (r6 != 0) goto L_0x016e;
    L_0x01de:
        r2 = cn.com.xy.sms.sdk.p216h.p217a.C2994l.m13472a(r2);	 Catch:{ Throwable -> 0x01e6 }
        cn.com.xy.sms.sdk.p208d.p211c.p212a.C2932j.m13196a(r4, r5, r2, r3);	 Catch:{ Throwable -> 0x01e6 }
        goto L_0x016e;
    L_0x01e6:
        r2 = move-exception;
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003b }
        r5 = "ShardDataManager parseShardSignForMsg error:";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x003b }
        r5 = r2.getMessage();	 Catch:{ Throwable -> 0x003b }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x003b }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x003b }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r2);	 Catch:{ Throwable -> 0x003b }
        goto L_0x016e;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.i.g.run():void");
    }
}
