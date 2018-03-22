package com.cmb.pboc.cardop;

import android.content.Context;
import android.os.Bundle;
import com.cmb.pboc.context.ContextHolder;
import com.cmb.pboc.global.PbocValue;
import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.ota.hw.OtaPortalForHw;
import com.cmb.pboc.ota.hw.OtaValueHw;
import com.cmb.pboc.personal.Personal;
import com.cmb.pboc.scard.Scard;
import com.cmb.pboc.scard.ScardFactory;
import com.cmb.pboc.scard.callback.ScardCallback;
import com.cmb.pboc.specs.AppTerm;
import com.cmb.pboc.utils.ParseUtils;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.snowballtech.apdu.bean.SeConstants;
import com.unionpay.tsmservice.data.ResultCode;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class CMBHWSDK implements ScardCallback {
    private static final String f13366a = CMBHWSDK.class.getSimpleName();
    private static Scard f13367b;
    private static boolean f13368c;

    public CMBHWSDK(Context context, HashMap hashMap) {
        Object obj;
        PbocLog.m17738a(f13366a, "Build HwWallet SDK: 0.7");
        if (context == null) {
            PbocLog.m17741d(f13366a, "Hw context obj is null!");
            obj = null;
        } else {
            ContextHolder.m17714a().m17715a(context);
            String str = (String) hashMap.get("cmb_url");
            if (str == null || str.equalsIgnoreCase("") || !str.startsWith("http")) {
                PbocLog.m17741d(f13366a, "Hw input url is wrong!");
                obj = null;
            } else {
                OtaValueHw.f13464a = str;
                PbocLog.m17738a(f13366a, "Hw ota url is http://***.***" + OtaValueHw.f13464a.substring(15));
                obj = 1;
            }
        }
        if (obj == null) {
            throw new Exception("input is wrong");
        }
        try {
            PbocLog.m17738a(f13366a, "Build scard");
            f13367b = ScardFactory.m17781a("OMA");
            PbocValue.f13423b = null;
            PbocValue.f13424c = null;
            OtaValueHw.f13466c = null;
            OtaValueHw.f13465b = null;
        } catch (ClassNotFoundException e) {
            PbocLog.m17741d(f13366a, "ClassNotFoundException:" + e.getMessage());
            throw e;
        } catch (InstantiationException e2) {
            PbocLog.m17741d(f13366a, "InstantiationException:" + e2.getMessage());
            throw e2;
        } catch (IllegalAccessException e3) {
            PbocLog.m17741d(f13366a, "IllegalAccessException:" + e3.getMessage());
            throw e3;
        } catch (InvocationTargetException e4) {
            PbocLog.m17741d(f13366a, "InvocationTargetException:" + e4.getMessage());
            throw e4;
        } catch (Exception e5) {
            PbocLog.m17741d(f13366a, "Exception in testSEService: " + e5.toString());
            throw e5;
        }
    }

    private boolean m17708a() {
        HashMap a;
        HashMap hashMap = new HashMap();
        if (OtaValueHw.f13465b != null) {
            a = OtaValueHw.m17762a(OtaValueHw.f13465b);
            if (a != null && "succ".equalsIgnoreCase((String) a.get("result"))) {
                OtaValueHw.f13466c = (String) a.get("channel");
                PbocLog.m17738a(f13366a, "Method is ok, Set channel: " + OtaValueHw.f13466c);
                hashMap = a;
                if (hashMap != null || !"succ".equalsIgnoreCase((String) hashMap.get("result"))) {
                    return false;
                }
                PbocLog.m17738a(f13366a, "Method is ok, channel is: " + OtaValueHw.f13466c);
                return true;
            }
        }
        PbocLog.m17738a(f13366a, "Try to connect ota...");
        String a2 = OtaPortalForHw.m17757a(1, null);
        OtaValueHw.f13465b = a2;
        hashMap = OtaValueHw.m17762a(a2);
        if (OtaValueHw.f13465b != null) {
            a = OtaValueHw.m17762a(OtaValueHw.f13465b);
            if (a != null && "succ".equalsIgnoreCase((String) a.get("result"))) {
                OtaValueHw.f13466c = (String) a.get("channel");
                PbocLog.m17738a(f13366a, "Method is ok, Set channel: " + OtaValueHw.f13466c);
            }
            hashMap = a;
        }
        if (hashMap != null) {
        }
        return false;
    }

    public HashMap activate(Context context, HashMap hashMap) {
        if (m17708a()) {
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
            return OtaValueHw.m17763b(OtaPortalForHw.m17757a(7, hashMap));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", ResultCode.ERROR_DETAIL_NETWORK);
        hashMap2.put("opcode", "SHOWMSG");
        hashMap2.put("data", "网络通信失败，请稍后重试");
        PbocLog.m17741d(f13366a, "Fail to connect ota");
        return hashMap2;
    }

    public HashMap getAid(Context context, HashMap hashMap) {
        if (m17708a()) {
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
                PbocLog.m17738a(f13366a, "no timestamp input");
            }
            str = (String) hashMap.get("hwsign");
            if (str == null || str.equalsIgnoreCase("")) {
                PbocLog.m17738a(f13366a, "no hwsign input");
            }
            str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
            if (str == null || "".equalsIgnoreCase(str)) {
                OtaValueHw.f13469f = false;
                OtaValueHw.f13468e = "";
            } else {
                OtaValueHw.f13468e = str;
                OtaValueHw.f13469f = true;
            }
            return OtaValueHw.m17763b(OtaPortalForHw.m17757a(2, hashMap));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", ResultCode.ERROR_DETAIL_NETWORK);
        hashMap2.put("opcode", "SHOWMSG");
        hashMap2.put("data", "网络通信失败，请稍后重试");
        PbocLog.m17741d(f13366a, "Fail to connect ota");
        return hashMap2;
    }

    public String getSEID() {
        Object obj = null;
        if (PbocValue.f13424c != null) {
            return PbocValue.f13424c;
        }
        try {
            PbocLog.m17738a(f13366a, "Get seid from se");
            f13368c = false;
            f13367b.init(ContextHolder.m17714a().m17716b(), this, null);
            f13367b.openScard();
            long currentTimeMillis = System.currentTimeMillis();
            while (!f13368c) {
                if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                    PbocLog.m17741d(f13366a, "Open scard timeout");
                    obj = 1;
                    break;
                }
            }
            if (obj != null) {
                return null;
            }
            String a = ParseUtils.m17796a(f13367b.ExchangeApdu(ParseUtils.m17797a(SeConstants.COMMAND_CPLC)));
            PbocValue.f13423b = a.substring(0, a.length() - 4);
            PbocValue.f13424c = a.substring(26, 42);
            PbocLog.m17738a(f13366a, "SEID: " + PbocValue.f13424c);
            f13367b.closeCard();
            return PbocValue.f13424c;
        } catch (Exception e) {
            e.printStackTrace();
            PbocLog.m17741d(f13366a, e.getMessage());
        } finally {
            f13367b.closeCard();
        }
    }

    public HashMap getsms(Context context, HashMap hashMap) {
        if (m17708a()) {
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
            return OtaValueHw.m17763b(OtaPortalForHw.m17757a(6, hashMap));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", ResultCode.ERROR_DETAIL_NETWORK);
        hashMap2.put("opcode", "SHOWMSG");
        hashMap2.put("data", "网络通信失败，请稍后重试");
        PbocLog.m17741d(f13366a, "Fail to connect ota");
        return hashMap2;
    }

    public void onError(StringBuilder stringBuilder) {
        PbocLog.m17741d(f13366a, "Scard on Error");
        PbocLog.m17741d(f13366a, stringBuilder.toString());
    }

    public void onResponse(Bundle bundle) {
        PbocLog.m17738a(f13366a, "Scard on response");
        f13368c = true;
    }

    public HashMap personalize(Context context, HashMap hashMap) {
        HashMap b;
        Exception exception;
        Exception exception2;
        boolean z = false;
        if (m17708a()) {
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
            HashMap hashMap2 = new HashMap();
            try {
                boolean z2;
                PbocLog.m17738a(f13366a, "Open scard for personalize");
                f13368c = false;
                f13367b.init(ContextHolder.m17714a().m17716b(), this, null);
                f13367b.openScard();
                long currentTimeMillis = System.currentTimeMillis();
                while (!f13368c) {
                    if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                        PbocLog.m17741d(f13366a, "Open scard timeout");
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (z2) {
                    hashMap2.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
                    hashMap2.put("opcode", "SHOWMSG");
                    hashMap2.put("data", "请检查NFC功能，稍后重试");
                    PbocLog.m17741d(f13366a, "Open scard failed");
                    f13367b.closeCard();
                    return hashMap2;
                }
                String a = OtaPortalForHw.m17757a(4, hashMap);
                if ("0000".equalsIgnoreCase((String) OtaValueHw.m17763b(a).get("result"))) {
                    int a2 = Personal.m17775a(f13367b, 1, (String) OtaValueHw.m17763b(a).get("data"));
                    if (a2 != 0) {
                        PbocLog.m17741d(f13366a, "Personal initial error, " + a2);
                        str = OtaPortalForHw.m17757a(5, hashMap);
                        PbocLog.m17741d(f13366a, str);
                        b = OtaValueHw.m17763b(str);
                        f13367b.closeCard();
                        return b;
                    }
                    int i = 1;
                    while (true) {
                        try {
                            String a3 = OtaPortalForHw.m17757a(5, hashMap);
                            if ("0000".equalsIgnoreCase((String) OtaValueHw.m17763b(a3).get("result"))) {
                                boolean z3;
                                int i2;
                                if (!"true".equalsIgnoreCase((String) OtaValueHw.m17763b(a3).get("completed"))) {
                                    i++;
                                    a2 = Personal.m17776b(f13367b, i, (String) OtaValueHw.m17763b(a3).get("data"));
                                    if (a2 != 0) {
                                        PbocLog.m17741d(f13366a, "Personal package num " + i + " execute error, " + a2);
                                        b = hashMap2;
                                        z3 = z;
                                        i2 = i;
                                    } else {
                                        PbocLog.m17739b(f13366a, "Personal package num " + i + " execute success.");
                                        b = hashMap2;
                                        z3 = z;
                                        i2 = i;
                                    }
                                } else if (Personal.f13482b) {
                                    PbocLog.m17739b(f13366a, "Personalize success. Pkg num: " + i);
                                    hashMap2 = OtaValueHw.m17763b(a3);
                                    try {
                                        hashMap2.putAll(OtaValueHw.m17763b(a));
                                        hashMap2.remove("data");
                                        hashMap2.remove("completed");
                                        i2 = i;
                                        b = hashMap2;
                                        z3 = true;
                                    } catch (Exception e) {
                                        exception = e;
                                        b = hashMap2;
                                        exception2 = exception;
                                    }
                                } else {
                                    PbocLog.m17741d(f13366a, "Personalize failed. Pkg num: " + i);
                                    hashMap2 = OtaValueHw.m17763b(a3);
                                    hashMap2.remove("data");
                                    hashMap2.remove("completed");
                                    i2 = i;
                                    b = hashMap2;
                                    z3 = true;
                                }
                                if (z3) {
                                    f13367b.closeCard();
                                    return b;
                                }
                                i = i2;
                                z = z3;
                                hashMap2 = b;
                            } else {
                                PbocLog.m17741d(f13366a, a3);
                                b = OtaValueHw.m17763b(a3);
                                f13367b.closeCard();
                                return b;
                            }
                        } catch (Exception e2) {
                            exception = e2;
                            b = hashMap2;
                            exception2 = exception;
                        }
                    }
                } else {
                    PbocLog.m17741d(f13366a, a);
                    b = OtaValueHw.m17763b(a);
                    f13367b.closeCard();
                    return b;
                }
            } catch (Exception e22) {
                exception = e22;
                b = hashMap2;
                exception2 = exception;
            }
        } else {
            b = new HashMap();
            b.put("result", ResultCode.ERROR_DETAIL_NETWORK);
            b.put("opcode", "SHOWMSG");
            b.put("data", "网络通信失败，请稍后重试");
            PbocLog.m17741d(f13366a, "Fail to connect ota");
            return b;
        }
        try {
            PbocLog.m17741d(f13366a, "Personalize Exception: " + exception2.getMessage());
            return b;
        } finally {
            f13367b.closeCard();
        }
    }

    public HashMap retrieveCardInfo(String str) {
        Object obj = 1;
        HashMap hashMap = new HashMap();
        if (str == null) {
            hashMap.put("data", "cardType is null");
            PbocLog.m17741d(f13366a, "cardType is null");
        } else {
            if ("debit".equalsIgnoreCase(str)) {
                PbocValue.f13422a = "A0000003330101010003080000030801";
            } else if ("credit".equalsIgnoreCase(str)) {
                PbocValue.f13422a = "A0000003330101020003080000030801";
            } else {
                PbocValue.f13422a = "A0000003330101010003080000030801";
            }
            try {
                PbocLog.m17738a(f13366a, "Get dpan from se");
                f13368c = false;
                f13367b.init(ContextHolder.m17714a().m17716b(), this, null);
                f13367b.openScard();
                long currentTimeMillis = System.currentTimeMillis();
                while (!f13368c) {
                    if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                        PbocLog.m17741d(f13366a, "Open scard timeout");
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    hashMap.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
                    hashMap.put("opcode", "SHOWMSG");
                    hashMap.put("data", "Open scard timeout");
                    PbocLog.m17741d(f13366a, "Open scard timeout");
                } else {
                    String[] a = AppTerm.m17784a(f13367b).m17787a(PbocValue.f13422a);
                    if (a == null) {
                        hashMap.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
                        hashMap.put("opcode", "SHOWMSG");
                        hashMap.put("data", "Get card info failed");
                        PbocLog.m17741d(f13366a, "Get card info failed");
                    } else {
                        hashMap.put("dpan", a[0]);
                        hashMap.put("dpansn", a[1]);
                        hashMap.put("topamount", a[2]);
                        hashMap.put("balance", a[3]);
                        hashMap.put("expdata", a[4]);
                    }
                    f13367b.closeCard();
                }
            } catch (Exception e) {
                e.printStackTrace();
                PbocLog.m17741d(f13366a, e.getMessage());
                hashMap.put("result", ResultCode.ERROR_DETAIL_UNKNOWN_HOST);
                hashMap.put("opcode", "SHOWMSG");
                hashMap.put("data", "Get card info failed");
                hashMap.put(JoinConstants.EXCEPTION, e.getMessage());
            } finally {
                f13367b.closeCard();
            }
        }
        return hashMap;
    }

    public HashMap uninstall(Context context, HashMap hashMap) {
        if (m17708a()) {
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
            return OtaValueHw.m17763b(OtaPortalForHw.m17757a(8, hashMap));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", ResultCode.ERROR_DETAIL_NETWORK);
        hashMap2.put("opcode", "SHOWMSG");
        hashMap2.put("data", "网络通信失败，请稍后重试");
        PbocLog.m17741d(f13366a, "Fail to connect ota");
        return hashMap2;
    }

    public HashMap verify(Context context, HashMap hashMap) {
        if (m17708a()) {
            String str = (String) hashMap.get("cplc");
            if (str == null || str.equalsIgnoreCase("")) {
                throw new Exception("cplc is null!");
            }
            if (hashMap.get("cardtype") != null) {
                PbocLog.m17738a(f13366a, "Get cardtype input " + String.valueOf(hashMap.get("cardtype")));
            }
            str = (String) hashMap.get("aid");
            if (str == null || "".equalsIgnoreCase(str)) {
                throw new Exception("aid is null!");
            }
            str = (String) hashMap.get("fpan");
            if (str == null || "".equalsIgnoreCase(str)) {
                throw new Exception("fpan is null!");
            }
            str = (String) hashMap.get("timestamp");
            if (str == null || str.equalsIgnoreCase("")) {
                PbocLog.m17738a(f13366a, "no timestamp input");
            }
            str = (String) hashMap.get("hwsign");
            if (str == null || str.equalsIgnoreCase("")) {
                PbocLog.m17738a(f13366a, "no hwsign input");
            }
            str = (String) hashMap.get(SNBConstant.FIELD_TOKEN);
            if (str == null || "".equalsIgnoreCase(str)) {
                OtaValueHw.f13469f = false;
                OtaValueHw.f13468e = "";
            } else {
                OtaValueHw.f13468e = str;
                OtaValueHw.f13469f = true;
            }
            return OtaValueHw.m17763b(OtaPortalForHw.m17757a(3, hashMap));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", ResultCode.ERROR_DETAIL_NETWORK);
        hashMap2.put("opcode", "SHOWMSG");
        hashMap2.put("data", "网络通信失败，请稍后重试");
        PbocLog.m17741d(f13366a, "Fail to connect ota");
        return hashMap2;
    }
}
