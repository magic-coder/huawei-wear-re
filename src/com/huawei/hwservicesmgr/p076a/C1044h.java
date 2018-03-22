package com.huawei.hwservicesmgr.p076a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.PhoneLookup;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwcommonmodel.d.a.b;
import com.huawei.hwcommonmodel.datatypes.MsgText;
import com.huawei.hwcommonmodel.datatypes.o;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C1025h;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.hwservicesmgr.a.i;
import com.huawei.hwservicesmgr.a.j;
import com.huawei.hwservicesmgr.a.k;
import com.huawei.hwservicesmgr.a.l;
import com.huawei.hwservicesmgr.a.m;
import com.huawei.hwservicesmgr.a.n;
import com.huawei.hwservicesmgr.a.p;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: PhoneListManager */
public class C1044h extends PhoneStateListener {
    private static boolean f2055c = false;
    private static ExecutorService f2056h = Executors.newFixedThreadPool(5);
    private static final Uri f2057i = Uri.parse("content://com.android.contacts.app/yellow_page_data");
    private static final Uri f2058j = Uri.parse("content://com.android.contacts.app/number_mark");
    private static final String[] f2059k = new String[]{"name", "number"};
    private static final String[] f2060o = new String[]{"android.permission.READ_PHONE_STATE"};
    private Context f2061a;
    private TelephonyManager f2062b;
    private boolean f2063d = false;
    private o f2064e;
    private C1043e f2065f;
    private boolean f2066g = false;
    private BroadcastReceiver f2067l = new j(this);
    private PhoneStateListener f2068m = new m(this);
    private final BroadcastReceiver f2069n = new n(this);

    public C1044h(Context context) {
        this.f2061a = context;
        try {
            this.f2062b = (TelephonyManager) context.getSystemService("phone");
            this.f2065f = C1043e.m4358a(context);
        } catch (Exception e) {
            C2538c.m12680e("PhoneListManager", "Exception e = " + e.getMessage());
        }
    }

    public void m4400a() {
        if (!this.f2063d) {
            try {
                if (m4399e()) {
                    C2538c.m12674b("PhoneListManager", "onCallStateChanged() has READ_PHONE_STATE permission ");
                }
                this.f2063d = true;
                C2538c.m12677c("PhoneListManager", "register()");
                f2056h.execute(new i(this));
                this.f2061a.registerReceiver(this.f2069n, new IntentFilter("android.intent.action.PHONE_STATE"));
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("midware_phone_flag");
                this.f2061a.registerReceiver(this.f2067l, intentFilter, C0976c.f1642a, null);
            } catch (Exception e) {
                C2538c.m12680e("PhoneListManager", "Exception e = " + e.getMessage());
            }
        }
    }

    public void m4402b() {
        if (this.f2063d) {
            try {
                this.f2063d = false;
                C2538c.m12677c("PhoneListManager", "unregister()");
                f2056h.execute(new k(this));
                if (this.f2069n != null) {
                    this.f2061a.unregisterReceiver(this.f2069n);
                }
                if (this.f2067l != null) {
                    this.f2061a.unregisterReceiver(this.f2067l);
                }
            } catch (Exception e) {
                C2538c.m12680e("PhoneListManager", "Exception", e.getMessage());
            }
        }
    }

    public void m4403c() {
        try {
            C2538c.m12677c("PhoneListManager", "refreshRegister()");
            f2056h.execute(new l(this));
            this.f2063d = true;
        } catch (Exception e) {
            C2538c.m12680e("PhoneListManager", "Exception", e.getMessage());
        }
    }

    private void m4387a(String str) {
        f2056h.execute(new com.huawei.hwservicesmgr.a.o(this, str));
    }

    private void m4392b(String str) {
        String str2 = null;
        C2538c.m12677c("PhoneListManager", "currentThread = " + Thread.currentThread().getId() + ",mPhoneRing = " + f2055c);
        if (this.f2066g) {
            C2538c.m12677c("PhoneListManager", "isForbidden,return");
        } else if (f2055c) {
            C2538c.m12677c("PhoneListManager", "doPhoneRing: phone was ringing, return");
        } else {
            f2055c = true;
            if (C1025h.m4003a()) {
                String str3;
                String str4;
                C0977d.m3532a(new Intent(this.f2061a, PhoneService.class), this.f2061a);
                if (TextUtils.isEmpty(str)) {
                    C2538c.m12680e("PhoneListManager", "doPhoneRing incomingNumber is empty!");
                    str3 = null;
                    str4 = str;
                } else {
                    str4 = m4393c(str);
                    if (str4 == null || !str4.equals(str)) {
                        str3 = null;
                    } else {
                        str3 = C1044h.m4385a(this.f2061a, str);
                        if (str3 == null || str3.equals("")) {
                            str2 = m4390b(this.f2061a, str);
                        }
                    }
                }
                C2538c.m12677c("PhoneListManager", "doPhoneRing userName : " + str4 + " ; yellowPage : " + str3 + " ; markStr : " + str2);
                if (this.f2065f.m4380c() == 0) {
                    if (TextUtils.isEmpty(str)) {
                        C2538c.m12680e("PhoneListManager", "doPhoneRing incomingNumber is empty device is B1");
                        return;
                    }
                    try {
                        Thread.sleep(2000);
                        C2538c.m12677c("PhoneListManager", "doPhoneRing, B1 push need delay(ms): 2000");
                    } catch (InterruptedException e) {
                        C2538c.m12679d("PhoneListManager", "InterruptedException = " + e.getMessage());
                    }
                    if (str4 == null) {
                        str4 = "";
                    }
                    this.f2065f.m4376a(str4);
                    return;
                } else if (-1 == this.f2065f.m4380c()) {
                    C2538c.m12677c("PhoneListManager", "Send Call on Notification to 3rd device.");
                    this.f2065f.m4379b(str);
                    return;
                } else {
                    this.f2064e = m4384a(str4, str3, str2);
                    C2538c.m12677c("PhoneListManager", "doPhoneRing start NotifySendData to send command");
                    this.f2065f.m4375a(this.f2065f.m4372a(this.f2064e.a(), true, this.f2064e.c(), this.f2064e.b()), 3);
                    return;
                }
            }
            C2538c.m12677c("PhoneListManager", "have no device so do not start PhoneService.");
        }
    }

    private o m4384a(String str, String str2, String str3) {
        C2538c.m12677c("PhoneListManager", "wrapCallStateMsgData(): enter ------");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        MsgText msgText = new MsgText();
        msgText.setTextType(1);
        msgText.setTextContent(str);
        if (!(str2 == null || str2.equals(""))) {
            MsgText msgText2 = new MsgText();
            msgText2.setTextType(5);
            msgText2.setTextContent(str2);
            arrayList2.add(msgText2);
        }
        if (!(str3 == null || str3.equals(""))) {
            msgText2 = new MsgText();
            msgText2.setTextType(6);
            msgText2.setTextContent(str3);
            arrayList2.add(msgText2);
        }
        arrayList2.add(msgText);
        return new o(1, arrayList, arrayList2, false);
    }

    private void m4395d() {
        C2538c.m12677c("PhoneListManager", "doPhoneIdleOrOffHook mPhoneRing = " + f2055c);
        if (this.f2066g) {
            C2538c.m12677c("PhoneListManager", "isForbidden,return");
        } else if (f2055c) {
            f2055c = false;
            List arrayList = new ArrayList();
            MsgText msgText = new MsgText();
            msgText.setTextType(1);
            msgText.setTextContent("");
            arrayList.add(msgText);
            if (-1 == this.f2065f.m4380c()) {
                C2538c.m12677c("PhoneListManager", "Send Call off Notification to 3rd device.");
                this.f2065f.m4382e();
            } else if (this.f2065f.m4380c() == 0) {
                C2538c.m12677c("PhoneListManager", "V0 protocol do not need call off info.");
            } else {
                C2538c.m12677c("PhoneListManager", "doPhoneIdleOrOffHook start NotifySendData to send command");
                this.f2065f.m4375a(this.f2065f.m4372a(12, false, null, arrayList), 3);
                if (this.f2064e != null && !this.f2064e.d()) {
                    this.f2064e.a(true);
                }
            }
        }
    }

    @TargetApi(5)
    private String m4393c(String str) {
        boolean a;
        C2538c.m12677c("PhoneListManager", "getContactDisplayNameByNumber() number-------------" + str);
        if (VERSION.SDK_INT >= 23) {
            a = b.a().a(this.f2061a, "android.permission.READ_CONTACTS");
        } else {
            a = true;
        }
        C2538c.m12677c("PhoneListManager", "getContactDisplayNameByNumber hasPermission =" + a);
        if (a) {
            try {
                Uri withAppendedPath = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str));
                Cursor query = this.f2061a.getContentResolver().query(withAppendedPath, new String[]{"_id", "display_name"}, null, null, null);
                if (query != null && query.getCount() > 0) {
                    query.moveToNext();
                    str = query.getString(query.getColumnIndex("display_name"));
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                C2538c.m12680e("PhoneListManager", "getContactDisplayNameByNumber() Exception e = " + e.getMessage());
            }
        }
        C2538c.m12677c("PhoneListManager", "getContactDisplayNameByNumber() leave name-----------" + str);
        return str;
    }

    public void m4401a(byte[] bArr) {
        if (this.f2065f == null || this.f2065f.m4380c() != 0 || (byte) 1 != bArr[1]) {
            return;
        }
        if (bArr.length <= 3 || TagName.ELECTRONIC_PUBLISH_START_TIME != bArr[2]) {
            this.f2065f.m4381d();
            return;
        }
        C2538c.m12677c("PhoneListManager", "V0 Notification command send time out.");
    }

    private boolean m4399e() {
        return com.huawei.hwcommonmodel.d.b.a(this.f2061a, f2060o);
    }

    private void m4396d(String str) {
        C2538c.m12674b("PhoneListManager", "VdeferDoRing number : " + str);
        if (str == null || "".equals(str)) {
            f2056h.execute(new p(this, str));
        } else {
            m4387a(str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4385a(android.content.Context r9, java.lang.String r10) {
        /*
        r6 = 0;
        r1 = 1;
        r4 = 0;
        r0 = "PhoneListManager";
        r1 = new java.lang.Object[r1];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "enter getYellowPagesCursor number : ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        r1[r4] = r2;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        r0 = com.huawei.hwcommonmodel.p064d.C0977d.m3565h();
        if (r0 != 0) goto L_0x0027;
    L_0x0025:
        r0 = r6;
    L_0x0026:
        return r0;
    L_0x0027:
        r0 = r9.getContentResolver();	 Catch:{ Exception -> 0x007d }
        r1 = f2057i;	 Catch:{ Exception -> 0x007d }
        r2 = f2059k;	 Catch:{ Exception -> 0x007d }
        r3 = "PHONE_NUMBERS_EQUAL(number,?)";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x007d }
        r5 = 0;
        r4[r5] = r10;	 Catch:{ Exception -> 0x007d }
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x007d }
        if (r1 == 0) goto L_0x00bf;
    L_0x003e:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        if (r0 == 0) goto L_0x00bf;
    L_0x0044:
        r0 = 0;
        r6 = r1.getString(r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r0 = 1;
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r2 = "PhoneListManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r5.<init>();	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r7 = "getPredefineCursor  numbers: ";
        r5 = r5.append(r7);	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r5 = " ; name: ";
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r3[r4] = r0;	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        com.huawei.p190v.C2538c.m12677c(r2, r3);	 Catch:{ Exception -> 0x00b9, all -> 0x00b0 }
        r0 = r6;
    L_0x0077:
        if (r1 == 0) goto L_0x0026;
    L_0x0079:
        r1.close();
        goto L_0x0026;
    L_0x007d:
        r0 = move-exception;
        r1 = r0;
        r0 = r6;
    L_0x0080:
        r2 = "PhoneListManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00a9 }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a9 }
        r5.<init>();	 Catch:{ all -> 0x00a9 }
        r7 = "Exception e : ";
        r5 = r5.append(r7);	 Catch:{ all -> 0x00a9 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x00a9 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x00a9 }
        r1 = r1.toString();	 Catch:{ all -> 0x00a9 }
        r3[r4] = r1;	 Catch:{ all -> 0x00a9 }
        com.huawei.p190v.C2538c.m12680e(r2, r3);	 Catch:{ all -> 0x00a9 }
        if (r6 == 0) goto L_0x0026;
    L_0x00a4:
        r6.close();
        goto L_0x0026;
    L_0x00a9:
        r0 = move-exception;
    L_0x00aa:
        if (r6 == 0) goto L_0x00af;
    L_0x00ac:
        r6.close();
    L_0x00af:
        throw r0;
    L_0x00b0:
        r0 = move-exception;
        r6 = r1;
        goto L_0x00aa;
    L_0x00b3:
        r0 = move-exception;
        r8 = r0;
        r0 = r6;
        r6 = r1;
        r1 = r8;
        goto L_0x0080;
    L_0x00b9:
        r0 = move-exception;
        r8 = r0;
        r0 = r6;
        r6 = r1;
        r1 = r8;
        goto L_0x0080;
    L_0x00bf:
        r0 = r6;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwservicesmgr.a.h.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m4390b(android.content.Context r12, java.lang.String r13) {
        /*
        r11 = this;
        r4 = 1;
        r5 = 0;
        r6 = 0;
        r0 = com.huawei.hwcommonmodel.p064d.C0977d.m3568i();
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r6;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = "PhoneListManager";
        r1 = new java.lang.Object[r4];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "enter getNumberMark number : ";
        r2 = r2.append(r3);
        r2 = r2.append(r13);
        r2 = r2.toString();
        r1[r5] = r2;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        r0 = f2058j;
        r0 = r0.buildUpon();
        r1 = "number";
        r2 = android.net.Uri.encode(r13);
        r0 = r0.appendQueryParameter(r1, r2);
        r1 = "call_type";
        r2 = "18";
        r2 = android.net.Uri.encode(r2);
        r0 = r0.appendQueryParameter(r1, r2);
        r1 = r0.build();
        r0 = "PhoneListManager";
        r2 = new java.lang.Object[r4];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "getNumberMark uri: ";
        r3 = r3.append(r4);
        r4 = r1.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2[r5] = r3;
        com.huawei.p190v.C2538c.m12677c(r0, r2);
        r0 = r12.getContentResolver();	 Catch:{ Exception -> 0x018c, all -> 0x01b8 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x018c, all -> 0x01b8 }
        if (r1 != 0) goto L_0x007c;
    L_0x0075:
        if (r1 == 0) goto L_0x007a;
    L_0x0077:
        r1.close();
    L_0x007a:
        r0 = r6;
        goto L_0x000a;
    L_0x007c:
        r0 = "PhoneListManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r3 = 0;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r4.<init>();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = "getNumberMark cursor: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        com.huawei.p190v.C2538c.m12677c(r0, r2);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r0 == 0) goto L_0x01d1;
    L_0x00a4:
        r0 = 0;
        r2 = r1.getString(r0);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r0 = 1;
        r3 = r1.getString(r0);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r0 = 2;
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r4 = "others";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x0100;
    L_0x00bb:
        r6 = r0;
    L_0x00bc:
        r4 = "PhoneListManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r8.<init>();	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r9 = "getNumberMark  classify: ";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r3 = r8.append(r3);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r8 = " ; phoneNum: ";
        r3 = r3.append(r8);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r3 = " ; phoneName : ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r2 = " ; numberMark : ";
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r5[r7] = r0;	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        com.huawei.p190v.C2538c.m12677c(r4, r5);	 Catch:{ Exception -> 0x01cb, all -> 0x01c0 }
        r0 = r6;
    L_0x00f9:
        if (r1 == 0) goto L_0x000a;
    L_0x00fb:
        r1.close();
        goto L_0x000a;
    L_0x0100:
        r4 = "fraud";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x0113;
    L_0x0108:
        r4 = r12.getResources();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = com.huawei.hwdevicemgr.d.number_mark_fraud;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        goto L_0x00bc;
    L_0x0113:
        r4 = "crank";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x0126;
    L_0x011b:
        r4 = r12.getResources();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = com.huawei.hwdevicemgr.d.number_mark_crank;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        goto L_0x00bc;
    L_0x0126:
        r4 = "express";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x0139;
    L_0x012e:
        r4 = r12.getResources();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = com.huawei.hwdevicemgr.d.number_mark_express;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        goto L_0x00bc;
    L_0x0139:
        r4 = "house agent";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x014d;
    L_0x0141:
        r4 = r12.getResources();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = com.huawei.hwdevicemgr.d.number_mark_house_agent;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        goto L_0x00bc;
    L_0x014d:
        r4 = "promote sales";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x0161;
    L_0x0155:
        r4 = r12.getResources();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = com.huawei.hwdevicemgr.d.number_mark_promote_sales;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        goto L_0x00bc;
    L_0x0161:
        r4 = "taxi";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x0175;
    L_0x0169:
        r4 = r12.getResources();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = com.huawei.hwdevicemgr.d.number_mark_taxi;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        goto L_0x00bc;
    L_0x0175:
        r4 = "satelite";
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        if (r4 == 0) goto L_0x0189;
    L_0x017d:
        r4 = r12.getResources();	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r5 = com.huawei.hwdevicemgr.d.contacts_str_filter_Maritime_Satellite_calls;	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x01c5, all -> 0x01c0 }
        goto L_0x00bc;
    L_0x0189:
        r6 = r0;
        goto L_0x00bc;
    L_0x018c:
        r0 = move-exception;
        r1 = r0;
        r0 = r6;
    L_0x018f:
        r2 = "PhoneListManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x01c2 }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c2 }
        r5.<init>();	 Catch:{ all -> 0x01c2 }
        r7 = "Exception e : ";
        r5 = r5.append(r7);	 Catch:{ all -> 0x01c2 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x01c2 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x01c2 }
        r1 = r1.toString();	 Catch:{ all -> 0x01c2 }
        r3[r4] = r1;	 Catch:{ all -> 0x01c2 }
        com.huawei.p190v.C2538c.m12680e(r2, r3);	 Catch:{ all -> 0x01c2 }
        if (r6 == 0) goto L_0x000a;
    L_0x01b3:
        r6.close();
        goto L_0x000a;
    L_0x01b8:
        r0 = move-exception;
        r1 = r6;
    L_0x01ba:
        if (r1 == 0) goto L_0x01bf;
    L_0x01bc:
        r1.close();
    L_0x01bf:
        throw r0;
    L_0x01c0:
        r0 = move-exception;
        goto L_0x01ba;
    L_0x01c2:
        r0 = move-exception;
        r1 = r6;
        goto L_0x01ba;
    L_0x01c5:
        r0 = move-exception;
        r10 = r0;
        r0 = r6;
        r6 = r1;
        r1 = r10;
        goto L_0x018f;
    L_0x01cb:
        r0 = move-exception;
        r10 = r0;
        r0 = r6;
        r6 = r1;
        r1 = r10;
        goto L_0x018f;
    L_0x01d1:
        r0 = r6;
        goto L_0x00f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwservicesmgr.a.h.b(android.content.Context, java.lang.String):java.lang.String");
    }
}
