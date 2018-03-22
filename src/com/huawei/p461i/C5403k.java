package com.huawei.p461i;

import android.os.Handler;
import android.os.Looper;

/* compiled from: HWAlarmManager */
class C5403k extends Handler {
    final /* synthetic */ C5393a f19219a;

    public C5403k(C5393a c5393a, Looper looper) {
        this.f19219a = c5393a;
        super(looper);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r15) {
        /*
        r14 = this;
        r13 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r12 = -1;
        r10 = -1;
        r9 = 0;
        r5 = 1;
        super.handleMessage(r15);
        r0 = r15.what;
        switch(r0) {
            case 1: goto L_0x0011;
            case 2: goto L_0x00d0;
            case 3: goto L_0x0117;
            case 4: goto L_0x01b9;
            case 5: goto L_0x0278;
            case 6: goto L_0x02c0;
            default: goto L_0x0010;
        };
    L_0x0010:
        return;
    L_0x0011:
        r0 = r15.obj;
        r0 = (com.huawei.datatype.DBAlarmObject) r0;
        r4 = com.huawei.p461i.C5393a.f19190o;
        monitor-enter(r4);
        r1 = r0.getObject();	 Catch:{ all -> 0x003c }
        r1 = (java.util.List) r1;	 Catch:{ all -> 0x003c }
        r2 = 0;
        r6 = r1.iterator();	 Catch:{ all -> 0x003c }
    L_0x0026:
        r1 = r6.hasNext();	 Catch:{ all -> 0x003c }
        if (r1 == 0) goto L_0x009a;
    L_0x002c:
        r1 = r6.next();	 Catch:{ all -> 0x003c }
        r1 = (com.huawei.datatype.EventAlarmInfo) r1;	 Catch:{ all -> 0x003c }
        r2 = r5 + -1;
        r3 = com.huawei.p461i.C5393a.f19188h;	 Catch:{ all -> 0x003c }
        if (r2 != r3) goto L_0x003f;
    L_0x003a:
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        goto L_0x0010;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        throw r0;
    L_0x003f:
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x003c }
        r2.<init>();	 Catch:{ all -> 0x003c }
        r3 = "User_ID";
        r7 = com.huawei.p461i.C5393a.m25964d();	 Catch:{ all -> 0x003c }
        r2.put(r3, r7);	 Catch:{ all -> 0x003c }
        r3 = "event_alarm_index";
        r7 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x003c }
        r2.put(r3, r7);	 Catch:{ all -> 0x003c }
        r3 = "event_alarm_enable";
        r7 = r1.getEventAlarmEnable();	 Catch:{ all -> 0x003c }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x003c }
        r2.put(r3, r7);	 Catch:{ all -> 0x003c }
        r3 = "event_alarm_time";
        r7 = r1.getEventAlarmStartTime_hour();	 Catch:{ all -> 0x003c }
        r7 = r7 * 100;
        r8 = r1.getEventAlarmStartTime_mins();	 Catch:{ all -> 0x003c }
        r7 = r7 + r8;
        r7 = java.lang.String.valueOf(r7);	 Catch:{ all -> 0x003c }
        r2.put(r3, r7);	 Catch:{ all -> 0x003c }
        r3 = "event_alarm_cycle";
        r7 = r1.getEventAlarmRepeat();	 Catch:{ all -> 0x003c }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x003c }
        r2.put(r3, r7);	 Catch:{ all -> 0x003c }
        r3 = "event_alarm_name";
        r1 = r1.getEventAlarmName();	 Catch:{ all -> 0x003c }
        r2.put(r3, r1);	 Catch:{ all -> 0x003c }
        r1 = r14.f19219a;	 Catch:{ all -> 0x003c }
        r3 = "event_alarm";
        r7 = 1;
        r2 = r1.insertStorageData(r3, r7, r2);	 Catch:{ all -> 0x003c }
        r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r1 != 0) goto L_0x00b6;
    L_0x009a:
        r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r1 != 0) goto L_0x00ba;
    L_0x009e:
        r1 = r0.getiBaseResponseCallback();	 Catch:{ all -> 0x003c }
        if (r1 == 0) goto L_0x00ba;
    L_0x00a4:
        r0 = r0.getiBaseResponseCallback();	 Catch:{ all -> 0x003c }
        r1 = -1;
        r2 = 108001; // 0x1a5e1 float:1.51342E-40 double:5.33596E-319;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x003c }
        r0.onResponse(r1, r2);	 Catch:{ all -> 0x003c }
    L_0x00b3:
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        goto L_0x0010;
    L_0x00b6:
        r5 = r5 + 1;
        goto L_0x0026;
    L_0x00ba:
        r1 = r0.getiBaseResponseCallback();	 Catch:{ all -> 0x003c }
        if (r1 == 0) goto L_0x00b3;
    L_0x00c0:
        r0 = r0.getiBaseResponseCallback();	 Catch:{ all -> 0x003c }
        r1 = 0;
        r2 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x003c }
        r0.onResponse(r1, r2);	 Catch:{ all -> 0x003c }
        goto L_0x00b3;
    L_0x00d0:
        r0 = r15.obj;
        r0 = (java.util.List) r0;
        r1 = r0.iterator();
    L_0x00d8:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0010;
    L_0x00de:
        r0 = r1.next();
        r0 = (com.huawei.datatype.EventAlarmInfo) r0;
        r2 = r14.f19219a;
        r3 = "event_alarm";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "User_ID='";
        r4 = r4.append(r6);
        r6 = com.huawei.p461i.C5393a.m25964d();
        r4 = r4.append(r6);
        r6 = "' AND event_alarm_index='";
        r4 = r4.append(r6);
        r0 = r0.getEventAlarmIndex();
        r0 = r4.append(r0);
        r4 = "'";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r2.deleteStorageData(r3, r5, r0);
        goto L_0x00d8;
    L_0x0117:
        r0 = r15.obj;
        r0 = (com.huawei.hwbasemgr.IBaseResponseCallback) r0;
        r1 = com.huawei.p461i.C5393a.f19190o;
        monitor-enter(r1);
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x01ac }
        r2.<init>();	 Catch:{ all -> 0x01ac }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ac }
        r3.<init>();	 Catch:{ all -> 0x01ac }
        r4 = "User_ID='";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01ac }
        r4 = com.huawei.p461i.C5393a.m25964d();	 Catch:{ all -> 0x01ac }
        r3 = r3.append(r4);	 Catch:{ all -> 0x01ac }
        r4 = "'";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01ac }
        r3 = r3.toString();	 Catch:{ all -> 0x01ac }
        r4 = r14.f19219a;	 Catch:{ all -> 0x01ac }
        r5 = "event_alarm";
        r6 = 1;
        r3 = r4.queryStorageData(r5, r6, r3);	 Catch:{ all -> 0x01ac }
        if (r3 == 0) goto L_0x01b2;
    L_0x014d:
        r4 = r3.moveToNext();	 Catch:{ all -> 0x01ac }
        if (r4 == 0) goto L_0x01af;
    L_0x0153:
        r4 = new com.huawei.datatype.EventAlarmInfo;	 Catch:{ all -> 0x01ac }
        r4.<init>();	 Catch:{ all -> 0x01ac }
        r5 = "event_alarm_index";
        r5 = r3.getColumnIndex(r5);	 Catch:{ all -> 0x01ac }
        r5 = r3.getInt(r5);	 Catch:{ all -> 0x01ac }
        r4.setEventAlarmIndex(r5);	 Catch:{ all -> 0x01ac }
        r5 = "event_alarm_enable";
        r5 = r3.getColumnIndex(r5);	 Catch:{ all -> 0x01ac }
        r5 = r3.getInt(r5);	 Catch:{ all -> 0x01ac }
        r4.setEventAlarmEnable(r5);	 Catch:{ all -> 0x01ac }
        r5 = "event_alarm_time";
        r5 = r3.getColumnIndex(r5);	 Catch:{ all -> 0x01ac }
        r5 = r3.getString(r5);	 Catch:{ all -> 0x01ac }
        r6 = java.lang.Integer.parseInt(r5);	 Catch:{ all -> 0x01ac }
        r6 = r6 / 100;
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ all -> 0x01ac }
        r5 = r5 % 100;
        r4.setEventAlarmStartTime_hour(r6);	 Catch:{ all -> 0x01ac }
        r4.setEventAlarmStartTime_mins(r5);	 Catch:{ all -> 0x01ac }
        r5 = "event_alarm_cycle";
        r5 = r3.getColumnIndex(r5);	 Catch:{ all -> 0x01ac }
        r5 = r3.getInt(r5);	 Catch:{ all -> 0x01ac }
        r4.setEventAlarmRepeat(r5);	 Catch:{ all -> 0x01ac }
        r5 = "event_alarm_name";
        r5 = r3.getColumnIndex(r5);	 Catch:{ all -> 0x01ac }
        r5 = r3.getString(r5);	 Catch:{ all -> 0x01ac }
        r4.setEventAlarmName(r5);	 Catch:{ all -> 0x01ac }
        r2.add(r4);	 Catch:{ all -> 0x01ac }
        goto L_0x014d;
    L_0x01ac:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01ac }
        throw r0;
    L_0x01af:
        r3.close();	 Catch:{ all -> 0x01ac }
    L_0x01b2:
        r3 = 0;
        r0.onResponse(r3, r2);	 Catch:{ all -> 0x01ac }
        monitor-exit(r1);	 Catch:{ all -> 0x01ac }
        goto L_0x0010;
    L_0x01b9:
        r0 = r15.obj;
        r0 = (com.huawei.datatype.DBAlarmObject) r0;
        r1 = r0.getObject();
        r1 = (java.util.List) r1;
        r2 = 0;
        r6 = r1.iterator();
        r4 = r5;
    L_0x01ca:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x0246;
    L_0x01d0:
        r1 = r6.next();
        r1 = (com.huawei.datatype.SmartAlarmInfo) r1;
        r2 = r4 + -1;
        r3 = com.huawei.p461i.C5393a.f19189i;
        if (r2 == r3) goto L_0x0010;
    L_0x01de:
        r2 = new android.content.ContentValues;
        r2.<init>();
        r3 = "User_ID";
        r7 = com.huawei.p461i.C5393a.m25964d();
        r2.put(r3, r7);
        r3 = "smart_alarm_index";
        r7 = r1.getSmartAlarmIndex();
        r7 = java.lang.Integer.valueOf(r7);
        r2.put(r3, r7);
        r3 = "smart_alarm_enable";
        r7 = r1.getSmartAlarmEnable();
        r7 = java.lang.Integer.valueOf(r7);
        r2.put(r3, r7);
        r3 = "smart_alarm_time";
        r7 = r1.getSmartAlarmStartTime_hour();
        r7 = r7 * 100;
        r8 = r1.getSmartAlarmStartTime_mins();
        r7 = r7 + r8;
        r7 = java.lang.String.valueOf(r7);
        r2.put(r3, r7);
        r3 = "smart_alarm_cycle";
        r7 = r1.getSmartAlarmRepeat();
        r7 = java.lang.Integer.valueOf(r7);
        r2.put(r3, r7);
        r3 = "smart_alarm_ahead_time";
        r1 = r1.getSmartAlarmAheadTime();
        r1 = java.lang.Integer.valueOf(r1);
        r2.put(r3, r1);
        r1 = r14.f19219a;
        r3 = "smart_alarm";
        r2 = r1.insertStorageData(r3, r5, r2);
        r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r1 != 0) goto L_0x0260;
    L_0x0246:
        r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r1 != 0) goto L_0x0265;
    L_0x024a:
        r1 = r0.getiBaseResponseCallback();
        if (r1 == 0) goto L_0x0265;
    L_0x0250:
        r0 = r0.getiBaseResponseCallback();
        r1 = 108001; // 0x1a5e1 float:1.51342E-40 double:5.33596E-319;
        r1 = java.lang.Integer.valueOf(r1);
        r0.onResponse(r12, r1);
        goto L_0x0010;
    L_0x0260:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x01ca;
    L_0x0265:
        r1 = r0.getiBaseResponseCallback();
        if (r1 == 0) goto L_0x0010;
    L_0x026b:
        r0 = r0.getiBaseResponseCallback();
        r1 = java.lang.Integer.valueOf(r13);
        r0.onResponse(r9, r1);
        goto L_0x0010;
    L_0x0278:
        r0 = r15.obj;
        r0 = (java.util.List) r0;
        r1 = r0.iterator();
    L_0x0280:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0010;
    L_0x0286:
        r0 = r1.next();
        r0 = (com.huawei.datatype.SmartAlarmInfo) r0;
        r2 = r14.f19219a;
        r3 = "smart_alarm";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "User_ID='";
        r4 = r4.append(r6);
        r6 = com.huawei.p461i.C5393a.m25964d();
        r4 = r4.append(r6);
        r6 = "' AND smart_alarm_index='";
        r4 = r4.append(r6);
        r0 = r0.getSmartAlarmIndex();
        r0 = r4.append(r0);
        r4 = "'";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r2.deleteStorageData(r3, r5, r0);
        goto L_0x0280;
    L_0x02c0:
        r0 = r15.obj;
        r0 = (com.huawei.hwbasemgr.IBaseResponseCallback) r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "User_ID='";
        r2 = r2.append(r3);
        r3 = com.huawei.p461i.C5393a.m25964d();
        r2 = r2.append(r3);
        r3 = "'";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = r14.f19219a;
        r4 = "smart_alarm";
        r2 = r3.queryStorageData(r4, r5, r2);
        if (r2 != 0) goto L_0x0301;
    L_0x02f1:
        r2 = "HWAlarmManager";
        r3 = new java.lang.Object[r5];
        r4 = "get smartAlart cursor is null";
        r3[r9] = r4;
        com.huawei.v.c.c(r2, r3);
        r0.onResponse(r9, r1);
        goto L_0x0010;
    L_0x0301:
        r3 = r2.moveToNext();
        if (r3 == 0) goto L_0x0365;
    L_0x0307:
        r3 = new com.huawei.datatype.SmartAlarmInfo;
        r3.<init>();
        r4 = "smart_alarm_index";
        r4 = r2.getColumnIndex(r4);
        r4 = r2.getInt(r4);
        r3.setSmartAlarmIndex(r4);
        r4 = "smart_alarm_enable";
        r4 = r2.getColumnIndex(r4);
        r4 = r2.getInt(r4);
        r3.setSmartAlarmEnable(r4);
        r4 = "smart_alarm_time";
        r4 = r2.getColumnIndex(r4);
        r4 = r2.getString(r4);
        r5 = java.lang.Integer.parseInt(r4);
        r5 = r5 / 100;
        r4 = java.lang.Integer.parseInt(r4);
        r4 = r4 % 100;
        r3.setSmartAlarmStartTime_hour(r5);
        r3.setSmartAlarmStartTime_mins(r4);
        r4 = "smart_alarm_cycle";
        r4 = r2.getColumnIndex(r4);
        r4 = r2.getInt(r4);
        r3.setSmartAlarmRepeat(r4);
        r4 = "smart_alarm_ahead_time";
        r4 = r2.getColumnIndex(r4);
        r4 = r2.getInt(r4);
        r3.setSmartAlarmAheadTime(r4);
        r1.add(r3);
        goto L_0x0301;
    L_0x0365:
        r2.close();
        r0.onResponse(r9, r1);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.i.k.handleMessage(android.os.Message):void");
    }
}
