package com.cmb.pboc.cardop;

import android.content.Context;
import android.os.Bundle;
import com.cmb.pboc.context.ContextHolder;
import com.cmb.pboc.global.PbocValue;
import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.ota.hw.OtaPortalHw;
import com.cmb.pboc.ota.hw.OtaValueHw;
import com.cmb.pboc.personal.Personal;
import com.cmb.pboc.scard.Scard;
import com.cmb.pboc.scard.ScardFactory;
import com.cmb.pboc.scard.callback.ScardCallback;
import com.cmb.pboc.specs.AppTerm;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class CMBWalletSDK implements ScardCallback {
    private static final String f13371a = CMBWalletSDK.class.getSimpleName();
    private static Scard f13372b;
    private static boolean f13373c;

    class C35371 implements Runnable {
        final /* synthetic */ CMBWalletSDK f13369a;

        C35371(CMBWalletSDK cMBWalletSDK) {
            this.f13369a = cMBWalletSDK;
        }

        public void run() {
            CMBWalletSDK.m17709a(this.f13369a);
        }
    }

    class C35382 implements Runnable {
        final /* synthetic */ CMBWalletSDK f13370a;

        C35382(CMBWalletSDK cMBWalletSDK) {
            this.f13370a = cMBWalletSDK;
        }

        public void run() {
            CMBWalletSDK.m17713b(this.f13370a);
        }
    }

    public CMBWalletSDK(Context context, HashMap hashMap) {
        boolean z;
        PbocLog.m17738a(f13371a, "Build hw sdk 0.7");
        if (context == null) {
            PbocLog.m17741d(f13371a, "Hw context obj is null!");
            z = false;
        } else {
            ContextHolder.m17714a().m17715a(context);
            String str = (String) hashMap.get("cmb_url");
            if (str == null || str.equalsIgnoreCase("") || !str.startsWith("http")) {
                PbocLog.m17741d(f13371a, "Hw input url is wrong!");
                z = false;
            } else {
                OtaValueHw.f13464a = str;
                PbocLog.m17738a(f13371a, "Hw ota url is " + OtaValueHw.f13464a);
                z = true;
            }
        }
        if (z) {
            Runnable c35371 = new C35371(this);
            Runnable c35382 = new C35382(this);
            f13373c = true;
            new Thread(c35371).start();
            new Thread(c35382).start();
            return;
        }
        throw new Exception("input parameter is wrong");
    }

    static /* synthetic */ void m17709a(CMBWalletSDK cMBWalletSDK) {
        if (f13372b == null) {
            try {
                PbocLog.m17738a(f13371a, "Before new scard");
                f13372b = ScardFactory.m17781a("OMA");
                PbocLog.m17738a(f13371a, "After new scard");
            } catch (ClassNotFoundException e) {
                PbocLog.m17741d(f13371a, "ClassNotFoundException:" + e.getMessage());
            } catch (InstantiationException e2) {
                PbocLog.m17741d(f13371a, "InstantiationException:" + e2.getMessage());
            } catch (IllegalAccessException e3) {
                PbocLog.m17741d(f13371a, "IllegalAccessException:" + e3.getMessage());
            } catch (InvocationTargetException e4) {
                PbocLog.m17741d(f13371a, "InvocationTargetException:" + e4.getMessage());
            } catch (Exception e5) {
                PbocLog.m17741d(f13371a, "Exception in testSEService: " + e5.toString());
            }
        }
        if (PbocValue.f13424c == null || "".equalsIgnoreCase(PbocValue.f13424c)) {
            f13372b.init(ContextHolder.m17714a().m17716b(), cMBWalletSDK, null);
            f13372b.openScard();
            return;
        }
        PbocLog.m17739b(f13371a, "SEID is " + PbocValue.f13424c);
    }

    private void m17710a(HashMap hashMap) {
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        while (OtaValueHw.f13465b == null) {
            if (System.currentTimeMillis() - currentTimeMillis > 15000) {
                PbocLog.m17741d(f13371a, "Wait for method result timeout!");
                break;
            }
        }
        if (OtaValueHw.f13465b != null) {
            HashMap a = OtaValueHw.m17762a(OtaValueHw.f13465b);
            if (a != null && "succ".equalsIgnoreCase((String) a.get("result"))) {
                if (OtaValueHw.f13466c != null || OtaValueHw.f13466c.equalsIgnoreCase((String) a.get("channel"))) {
                    PbocLog.m17739b(f13371a, "channel is ok.");
                    obj = 1;
                    if (obj == null) {
                        hashMap.put("result", ResultCode.ERROR_DETAIL_NETWORK);
                        hashMap.put("opcode", "SHOWMSG");
                        hashMap.put("data", "网络通信失败，请稍后重试");
                        PbocLog.m17741d(f13371a, "Get method meet error!");
                    } else if (m17711a()) {
                        hashMap.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
                        hashMap.put("opcode", "SHOWMSG");
                        hashMap.put("data", "请检查NFC功能，稍后重试");
                        PbocLog.m17741d(f13371a, "Get SEID meet error!");
                    } else {
                        PbocLog.m17739b(f13371a, "SDK is ok!");
                    }
                }
                PbocLog.m17740c(f13371a, "channel is wrong.");
            }
        }
        obj = null;
        if (obj == null) {
            hashMap.put("result", ResultCode.ERROR_DETAIL_NETWORK);
            hashMap.put("opcode", "SHOWMSG");
            hashMap.put("data", "网络通信失败，请稍后重试");
            PbocLog.m17741d(f13371a, "Get method meet error!");
        } else if (m17711a()) {
            PbocLog.m17739b(f13371a, "SDK is ok!");
        } else {
            hashMap.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
            hashMap.put("opcode", "SHOWMSG");
            hashMap.put("data", "请检查NFC功能，稍后重试");
            PbocLog.m17741d(f13371a, "Get SEID meet error!");
        }
    }

    private static boolean m17711a() {
        long currentTimeMillis = System.currentTimeMillis();
        while (PbocValue.f13424c == null) {
            if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                PbocLog.m17741d(f13371a, "wait for result timeout!");
                break;
            }
        }
        return PbocValue.f13424c != null;
    }

    private static String m17712b() {
        long currentTimeMillis = System.currentTimeMillis();
        while (OtaValueHw.f13467d == null) {
            if (System.currentTimeMillis() - currentTimeMillis > 15000) {
                PbocLog.m17741d(f13371a, "Wait for ota result timeout");
                OtaValueHw.f13467d = "result=0001&opcode=SHOWMSG&data=网络通信失败，请稍后重试&exception=Wait for ota result timeout";
                break;
            }
        }
        String str = OtaValueHw.f13467d;
        OtaValueHw.f13467d = null;
        return str;
    }

    static /* synthetic */ HashMap m17713b(CMBWalletSDK cMBWalletSDK) {
        HashMap a;
        if (OtaValueHw.f13465b != null) {
            a = OtaValueHw.m17762a(OtaValueHw.f13465b);
            if (a != null && "succ".equalsIgnoreCase((String) a.get("result"))) {
                OtaValueHw.f13466c = (String) a.get("channel");
                PbocLog.m17738a(f13371a, "channel: " + OtaValueHw.f13466c);
                return a;
            }
        }
        OtaPortalHw.m17759a().m17761a(1, null);
        String b = m17712b();
        OtaValueHw.f13465b = b;
        a = OtaValueHw.m17762a(b);
        if (a == null || !"succ".equalsIgnoreCase((String) a.get("result"))) {
            PbocLog.m17741d(f13371a, "Method result error: " + OtaValueHw.f13465b);
        } else {
            OtaValueHw.f13466c = (String) a.get("channel");
            PbocLog.m17738a(f13371a, "Set channel: " + OtaValueHw.f13466c);
        }
        return a;
    }

    public HashMap activate(Context context, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        m17710a(hashMap2);
        if (hashMap2.get("result") != null) {
            return hashMap2;
        }
        String str = (String) hashMap.get("cplc");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("cplc is null!");
        }
        str = (String) hashMap.get("dpan");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("dpan is null!");
        }
        str = (String) hashMap.get("aid");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("aid is null!");
        }
        str = (String) hashMap.get("smscode");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("smscode is null!");
        }
        str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("token is null!");
        }
        OtaValueHw.f13468e = str;
        OtaValueHw.f13469f = true;
        OtaPortalHw.m17759a().m17761a(7, hashMap);
        return OtaValueHw.m17763b(m17712b());
    }

    public HashMap getAid(Context context, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        m17710a(hashMap2);
        if (hashMap2.get("result") != null) {
            return hashMap2;
        }
        String str = (String) hashMap.get("cplc");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("cplc is null!");
        }
        str = (String) hashMap.get("fpan");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("fpan is null!");
        }
        str = (String) hashMap.get("timestamp");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("timestamp is wrong!");
        }
        str = (String) hashMap.get("hwsign");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("hwsign is null!");
        }
        str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
        if (str == null || "".equalsIgnoreCase(str)) {
            OtaValueHw.f13469f = false;
            OtaValueHw.f13468e = "";
        } else {
            OtaValueHw.f13468e = str;
            OtaValueHw.f13469f = true;
        }
        OtaPortalHw.m17759a().m17761a(2, hashMap);
        return OtaValueHw.m17763b(m17712b());
    }

    public String getSEID() {
        PbocLog.m17738a(f13371a, "Get SEID");
        if (PbocValue.f13424c != null && !"".equalsIgnoreCase(PbocValue.f13424c)) {
            PbocLog.m17738a(f13371a, "SEID is OK: " + PbocValue.f13424c);
        } else if (!m17711a()) {
            PbocLog.m17741d(f13371a, "SDK initial failed!");
        } else if (PbocValue.f13424c != null) {
            PbocLog.m17739b(f13371a, "Get SEID success.");
        } else {
            PbocLog.m17741d(f13371a, "Get SEID error!");
        }
        return PbocValue.f13424c;
    }

    public HashMap getsms(Context context, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        m17710a(hashMap2);
        if (hashMap2.get("result") != null) {
            return hashMap2;
        }
        String str = (String) hashMap.get("cplc");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("cplc is null!");
        }
        str = (String) hashMap.get("timestamp");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("timestamp is wrong!");
        }
        str = (String) hashMap.get("hwsign");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("hwsign is null!");
        }
        str = (String) hashMap.get("command");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("command is null!");
        }
        str = (String) hashMap.get("dpan");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("dpan is null!");
        }
        str = (String) hashMap.get("aid");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("aid is null!");
        }
        str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
        if (str == null || "".equalsIgnoreCase(str)) {
            OtaValueHw.f13469f = false;
            OtaValueHw.f13468e = "";
        } else {
            OtaValueHw.f13468e = str;
            OtaValueHw.f13469f = true;
        }
        OtaPortalHw.m17759a().m17761a(6, hashMap);
        return OtaValueHw.m17763b(m17712b());
    }

    public void onError(StringBuilder stringBuilder) {
        PbocLog.m17741d(f13371a, stringBuilder.toString());
    }

    public void onResponse(Bundle bundle) {
        if (!f13373c) {
            PbocLog.m17738a(f13371a, "Scard on response");
        } else if (f13372b != null) {
            f13372b.closeCard();
        }
    }

    public HashMap personalize(Context context, HashMap hashMap) {
        Exception exception;
        Exception exception2;
        Bundle bundle = null;
        boolean z = false;
        HashMap hashMap2 = new HashMap();
        m17710a(hashMap2);
        if (hashMap2.get("result") != null) {
            return hashMap2;
        }
        String str = (String) hashMap.get("cplc");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("cplc is null!");
        }
        str = (String) hashMap.get("aid");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("aid is null!");
        }
        str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("token is null!");
        }
        OtaValueHw.f13468e = str;
        OtaValueHw.f13469f = true;
        f13373c = false;
        if (f13372b != null) {
            boolean z2;
            f13372b.closeCard();
            f13372b.init(ContextHolder.m17714a().m17716b(), this, null);
            f13372b.openScard();
            long currentTimeMillis = System.currentTimeMillis();
            while (f13372b.getOpenCardState() != 4) {
                if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                    PbocLog.m17741d(f13371a, "Wait for scard timeout");
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (z2) {
                hashMap2 = new HashMap();
                hashMap2.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
                hashMap2.put("opcode", "SHOWMSG");
                hashMap2.put("data", "请检查NFC功能，稍后重试");
                PbocLog.m17741d(f13371a, "Open scard failed");
                return hashMap2;
            }
            try {
                OtaPortalHw.m17759a().m17761a(4, hashMap);
                String b = m17712b();
                if ("0000".equalsIgnoreCase((String) OtaValueHw.m17763b(b).get("result"))) {
                    str = (String) OtaValueHw.m17763b(b).get("data");
                    PbocLog.m17741d(f13371a, str);
                    int a = Personal.m17775a(f13372b, 1, str);
                    if (a != 0) {
                        PbocLog.m17741d(f13371a, "Personal initial error, " + a);
                        OtaPortalHw.m17759a().m17761a(5, hashMap);
                        str = m17712b();
                        PbocLog.m17741d(f13371a, str);
                        hashMap2 = OtaValueHw.m17763b(str);
                        f13372b.closeCard();
                        return hashMap2;
                    }
                    int i = 1;
                    while (true) {
                        OtaPortalHw.m17759a().m17761a(5, hashMap);
                        String b2 = m17712b();
                        if ("0000".equalsIgnoreCase((String) OtaValueHw.m17763b(b2).get("result"))) {
                            boolean z3;
                            int i2;
                            Object obj;
                            if (!"true".equalsIgnoreCase((String) OtaValueHw.m17763b(b2).get("completed"))) {
                                i++;
                                str = (String) OtaValueHw.m17763b(b2).get("data");
                                PbocLog.m17741d(f13371a, str);
                                a = Personal.m17776b(f13372b, i, str);
                                if (a != 0) {
                                    PbocLog.m17741d(f13371a, "Personal package num " + i + " execute error, " + a);
                                    obj = bundle;
                                    z3 = z;
                                    i2 = i;
                                } else {
                                    PbocLog.m17739b(f13371a, "Personal package num " + i + " execute success.");
                                    obj = bundle;
                                    z3 = z;
                                    i2 = i;
                                }
                            } else if (Personal.f13482b) {
                                PbocLog.m17739b(f13371a, "Personalize success. Pkg num: " + i);
                                r1 = OtaValueHw.m17763b(b2);
                                r1.putAll(OtaValueHw.m17763b(b));
                                r1.remove("data");
                                r1.remove("completed");
                                i2 = i;
                                hashMap2 = r1;
                                z3 = true;
                            } else {
                                try {
                                    PbocLog.m17741d(f13371a, "Personalize failed. Pkg num: " + i);
                                    r1 = OtaValueHw.m17763b(b2);
                                    r1.remove("data");
                                    r1.remove("completed");
                                    i2 = i;
                                    hashMap2 = r1;
                                    z3 = true;
                                } catch (Exception e) {
                                    exception = e;
                                    obj = bundle;
                                    exception2 = exception;
                                }
                            }
                            if (z3) {
                                f13372b.closeCard();
                                return hashMap2;
                            }
                            i = i2;
                            z = z3;
                            bundle = hashMap2;
                        } else {
                            PbocLog.m17741d(f13371a, b2);
                            hashMap2 = OtaValueHw.m17763b(b2);
                            f13372b.closeCard();
                            return hashMap2;
                        }
                    }
                }
                PbocLog.m17741d(f13371a, b);
                hashMap2 = OtaValueHw.m17763b(b);
                f13372b.closeCard();
                return hashMap2;
            } catch (Exception e2) {
                exception = e2;
                hashMap2 = null;
                exception2 = exception;
                try {
                    PbocLog.m17741d(f13371a, "Personalize Exception: " + exception2.getMessage());
                    return hashMap2;
                } finally {
                    f13372b.closeCard();
                }
            }
        } else {
            hashMap2 = new HashMap();
            hashMap2.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
            hashMap2.put("opcode", "SHOWMSG");
            hashMap2.put("data", "请检查NFC功能，稍后重试");
            PbocLog.m17741d(f13371a, "Scard object is null");
            return hashMap2;
        }
    }

    public HashMap queryCardInfo(String str) {
        f13373c = false;
        HashMap hashMap;
        if (f13372b != null) {
            int i;
            f13372b.closeCard();
            f13372b.init(ContextHolder.m17714a().m17716b(), this, null);
            f13372b.openScard();
            long currentTimeMillis = System.currentTimeMillis();
            while (f13372b.getOpenCardState() != 4) {
                if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                    PbocLog.m17741d(f13371a, "Wait for scard timeout");
                    i = 1;
                    break;
                }
            }
            i = false;
            if (i != 0) {
                hashMap = new HashMap();
                hashMap.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
                hashMap.put("opcode", "SHOWMSG");
                hashMap.put("data", "请检查NFC功能，稍后重试");
                PbocLog.m17741d(f13371a, "Open scard failed");
                return hashMap;
            }
            if ("debit".equalsIgnoreCase(str) || !"credit".equalsIgnoreCase(str)) {
                PbocValue.f13422a = "A0000003330101010003080000030801";
            } else {
                PbocValue.f13422a = "A0000003330101020003080000030801";
            }
            String[] a = AppTerm.m17784a(f13372b).m17786a();
            if (a == null) {
                PbocLog.m17741d(f13371a, "get card info failed!");
                return null;
            }
            hashMap = new HashMap();
            hashMap.put(Constant.KEY_PAN, a[0]);
            hashMap.put("pansn", a[1]);
            hashMap.put("topamount", a[2]);
            hashMap.put("balance", a[3]);
            hashMap.put("expdata", a[4]);
            return hashMap;
        }
        hashMap = new HashMap();
        hashMap.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
        hashMap.put("opcode", "SHOWMSG");
        hashMap.put("data", "请检查NFC功能，稍后重试");
        PbocLog.m17741d(f13371a, "Scard object is null");
        return hashMap;
    }

    public HashMap uninstall(Context context, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        m17710a(hashMap2);
        if (hashMap2.get("result") != null) {
            return hashMap2;
        }
        String str = (String) hashMap.get("cplc");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("cplc is null!");
        }
        str = (String) hashMap.get("timestamp");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("timestamp is wrong!");
        }
        str = (String) hashMap.get("hwsign");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("hwsign is null!");
        }
        str = (String) hashMap.get("dpan");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("dpan is null!");
        }
        str = (String) hashMap.get("aid");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("aid is null!");
        }
        str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
        if (str == null || "".equalsIgnoreCase(str)) {
            OtaValueHw.f13469f = false;
            OtaValueHw.f13468e = "";
        } else {
            OtaValueHw.f13468e = str;
            OtaValueHw.f13469f = true;
        }
        OtaPortalHw.m17759a().m17761a(8, hashMap);
        return OtaValueHw.m17763b(m17712b());
    }

    public HashMap verify(Context context, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        m17710a(hashMap2);
        if (hashMap2.get("result") != null) {
            return hashMap2;
        }
        String str = (String) hashMap.get("cplc");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("cplc is null!");
        }
        str = (String) hashMap.get("aid");
        if (str == null || "".equalsIgnoreCase(str)) {
            throw new Exception("aid is null!");
        }
        str = (String) hashMap.get("fpan");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("fpan is null!");
        }
        str = (String) hashMap.get("timestamp");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("timestamp is wrong!");
        }
        str = (String) hashMap.get("hwsign");
        if (str == null || str.equalsIgnoreCase("")) {
            throw new Exception("hwsign is null!");
        }
        str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
        if (str == null || "".equalsIgnoreCase(str)) {
            OtaValueHw.f13469f = false;
            OtaValueHw.f13468e = "";
        } else {
            OtaValueHw.f13468e = str;
            OtaValueHw.f13469f = true;
        }
        OtaPortalHw.m17759a().m17761a(3, hashMap);
        return OtaValueHw.m17763b(m17712b());
    }
}
