package com.huawei.hwid.p426b.p427a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.C5062a;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.p436a.C5152c;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.C5111b;
import com.huawei.hwid.p428c.C5115a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: SDKAccountManager */
public final class C5112a implements C5111b {
    private static C5112a f18424a;

    private C5112a() {
    }

    public static synchronized C5112a m24618a(Context context) {
        C5112a c5112a;
        synchronized (C5112a.class) {
            if (f18424a == null) {
                C5165e.m24903a(context);
                f18424a = new C5112a();
                f18424a.m24622b(context);
            }
            c5112a = f18424a;
        }
        return c5112a;
    }

    private void m24622b(Context context) {
        C5165e.m24906b("SDKAccountManager", "init SDKAccountManager");
        C5201e.m25306a(context);
        C5152c.m24838a(context);
    }

    public boolean mo4621a(Context context, HwAccount hwAccount) {
        ArrayList c = m24623c(context);
        if (C5166b.m24930a(hwAccount)) {
            c = m24619a(c, hwAccount);
            m24620a(context, (List) c);
            C5062a.m24355a().m24360a(c);
            return true;
        }
        C5165e.m24906b("SDKAccountManager", "the account is invalid , cannot be added into file");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.huawei.hwid.core.datatype.HwAccount> mo4617a(android.content.Context r6, java.lang.String r7) {
        /*
        r5 = this;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = r5.m24623c(r6);
        monitor-enter(r2);
        r0 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0016;
    L_0x0010:
        r0 = r2.isEmpty();	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        r0 = r1;
    L_0x0018:
        return r0;
    L_0x0019:
        r3 = r2.iterator();	 Catch:{ all -> 0x003b }
    L_0x001d:
        r0 = r3.hasNext();	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x003e;
    L_0x0023:
        r0 = r3.next();	 Catch:{ all -> 0x003b }
        r0 = (com.huawei.hwid.core.datatype.HwAccount) r0;	 Catch:{ all -> 0x003b }
        if (r7 == 0) goto L_0x001d;
    L_0x002b:
        if (r0 == 0) goto L_0x001d;
    L_0x002d:
        r4 = r0.m25122c();	 Catch:{ all -> 0x003b }
        r4 = r7.equals(r4);	 Catch:{ all -> 0x003b }
        if (r4 == 0) goto L_0x001d;
    L_0x0037:
        r1.add(r0);	 Catch:{ all -> 0x003b }
        goto L_0x001d;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r0 = "SDKAccountManager";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r3.<init>();	 Catch:{ all -> 0x003b }
        r4 = "getAccountsByType accountlist size:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r4 = r1.size();	 Catch:{ all -> 0x003b }
        r3 = r3.append(r4);	 Catch:{ all -> 0x003b }
        r3 = r3.toString();	 Catch:{ all -> 0x003b }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r0, r3);	 Catch:{ all -> 0x003b }
        monitor-exit(r2);	 Catch:{ all -> 0x003b }
        r0 = r1;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.b.a.a.a(android.content.Context, java.lang.String):java.util.ArrayList<com.huawei.hwid.core.datatype.HwAccount>");
    }

    public void mo4618a(Context context, String str, String str2) {
        ArrayList c = m24623c(context);
        if (c.isEmpty()) {
            C5165e.m24906b("SDKAccountManager", "there has no account");
        } else if (TextUtils.isEmpty(str)) {
            C5165e.m24906b("SDKAccountManager", "accountName is null , can't be deleted from file");
        } else {
            synchronized (c) {
                Collection arrayList = new ArrayList();
                try {
                    Iterator it = c.iterator();
                    while (it.hasNext()) {
                        HwAccount hwAccount = (HwAccount) it.next();
                        if (hwAccount != null && str.equals(hwAccount.m25120b())) {
                            if (TextUtils.isEmpty(str2) || (!TextUtils.isEmpty(str2) && str2.equals(hwAccount.m25122c()))) {
                                arrayList.add(hwAccount);
                            }
                        }
                    }
                    if (!arrayList.isEmpty() && c.containsAll(arrayList)) {
                        c.removeAll(arrayList);
                    }
                } catch (Exception e) {
                    C5165e.m24910d("SDKAccountManager", e.getMessage());
                }
                m24620a(context, (List) c);
                C5062a.m24355a().m24360a(c);
            }
        }
    }

    public void mo4619a(Context context, String str, String str2, String str3) {
        C5165e.m24906b("SDKAccountManager", "invalidateAuthToken  type=" + str2);
        ArrayList c = m24623c(context);
        synchronized (c) {
            List<HwAccount> a = mo4617a(context, str2);
            if (!a.isEmpty()) {
                for (HwAccount hwAccount : a) {
                    if (!(hwAccount == null || TextUtils.isEmpty(str3) || !str3.equals(hwAccount.m25130g()))) {
                        mo4618a(context, hwAccount.m25120b(), str2);
                        c.remove(hwAccount);
                    }
                }
            }
            C5062a.m24355a().m24360a(c);
        }
    }

    public void mo4620a(Context context, String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            HwAccount b = mo4623b(context, str, str2);
            if (b == null) {
                C5165e.m24906b("SDKAccountManager", "don't find the account");
                return;
            }
            Bundle o = b.m25145o();
            if (o.containsKey(str3)) {
                o.putString(str3, str4);
                b = b.m25116a(o);
            } else {
                C5165e.m24906b("SDKAccountManager", "the Account don't have the key");
            }
            mo4621a(context, b);
            C5115a.m24641a(context).m24644a(b);
        }
    }

    public boolean mo4626c(Context context, String str) {
        if (!C5166b.m24955h(context) || !C5166b.m24958j(context)) {
            return false;
        }
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.huawei.hwid");
        if (accountsByType == null || accountsByType.length <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        for (Account account : accountsByType) {
            if (account != null && str.equalsIgnoreCase(account.name)) {
                return true;
            }
        }
        return false;
    }

    public HwAccount mo4623b(Context context, String str, String str2) {
        List<HwAccount> c = m24623c(context);
        if (c.isEmpty() || TextUtils.isEmpty(str)) {
            C5165e.m24906b("SDKAccountManager", "there has no account");
            return null;
        }
        if ("com.huawei.hwid".equals(str2) || "com.huawei.hwid".equals(str2)) {
            str2 = "";
        }
        synchronized (c) {
            for (HwAccount hwAccount : c) {
                if (m24621a(str, hwAccount, str2)) {
                    return hwAccount;
                }
            }
            return null;
        }
    }

    private boolean m24621a(String str, HwAccount hwAccount, String str2) {
        if (str == null || hwAccount == null || !str.equals(hwAccount.m25120b()) || (!TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str2) || !str2.equals(hwAccount.m25122c())))) {
            return false;
        }
        return true;
    }

    public boolean mo4622a(Context context, ArrayList<HwAccount> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        m24620a(context, (List) arrayList);
        C5062a.m24355a().m24360a((ArrayList) arrayList);
        return true;
    }

    public void mo4624b(Context context, String str) {
        C5165e.m24906b("SDKAccountManager", "removeAllAccounts: type=" + str);
        ArrayList c = m24623c(context);
        synchronized (c) {
            Collection a = mo4617a(context, str);
            try {
                if (!(c.isEmpty() || a.isEmpty() || !c.containsAll(a))) {
                    c.removeAll(a);
                }
            } catch (Exception e) {
                C5165e.m24910d("SDKAccountManager", e.getMessage());
            }
            m24620a(context, (List) c);
            C5062a.m24355a().m24360a(c);
        }
    }

    private ArrayList<HwAccount> m24619a(ArrayList<HwAccount> arrayList, HwAccount hwAccount) {
        if (!C5166b.m24930a(hwAccount)) {
            C5165e.m24906b("SDKAccountManager", "the account is invalid , cannot be added into file");
            return arrayList;
        } else if (arrayList == null || arrayList.isEmpty()) {
            arrayList = new ArrayList();
            arrayList.add(hwAccount);
            return arrayList;
        } else {
            String d = hwAccount.m25124d();
            String b = hwAccount.m25120b();
            CharSequence c = hwAccount.m25122c();
            synchronized (arrayList) {
                Collection arrayList2 = new ArrayList();
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        HwAccount hwAccount2 = (HwAccount) it.next();
                        if (hwAccount2 != null && ((d.equals(hwAccount2.m25124d()) || b.equals(hwAccount2.m25120b())) && ((!TextUtils.isEmpty(c) && c.equals(hwAccount2.m25122c())) || TextUtils.isEmpty(c)))) {
                            arrayList2.add(hwAccount2);
                        }
                    }
                    if (!arrayList2.isEmpty() && arrayList.containsAll(arrayList2)) {
                        arrayList.removeAll(arrayList2);
                    }
                } catch (Exception e) {
                    C5165e.m24910d("SDKAccountManager", e.getMessage());
                }
                arrayList.add(hwAccount);
            }
            return arrayList;
        }
    }

    private void m24620a(Context context, List<HwAccount> list) {
        C5176g.m25013a(context, "accounts.xml");
        try {
            C5113b.m24638a(context, "accounts.xml", (List) list, true);
        } catch (Throwable e) {
            C5165e.m24909c("SDKAccountManager", e.getMessage(), e);
        }
    }

    private ArrayList<HwAccount> m24623c(Context context) {
        ArrayList<HwAccount> c = C5062a.m24355a().m24365c();
        if (c != null && !c.isEmpty()) {
            return c;
        }
        ArrayList a = C5113b.m24634a("accounts.xml", context, true);
        C5062a.m24355a().m24360a(a);
        return a;
    }

    public void mo4625b(Context context, String str, String str2, String str3) {
    }
}
