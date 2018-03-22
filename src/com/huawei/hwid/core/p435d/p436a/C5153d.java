package com.huawei.hwid.core.p435d.p436a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.p434c.C5147a;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.p427a.C5113b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: XmlFileGrade */
public class C5153d implements C5150a {
    public void mo4635a(Context context, int i, int i2) {
        if (i >= i2) {
            C5165e.m24910d("XmlFileGrade", "newVersion is less then oldVersion, onUpgrade error");
            return;
        }
        m24841a(context);
        m24842b(context);
    }

    private void m24841a(Context context) {
        String a;
        C5165e.m24906b("XmlFileGrade", "update HwAccounts.xml when version update");
        C5147a a2 = C5147a.m24824a(context);
        a2.m24828a("last_head_picture_url");
        C5165e.m24906b("XmlFileGrade", "delete last_head_picture_url in HwAccount.xml");
        a2.m24828a("DEVID_1");
        C5165e.m24906b("XmlFileGrade", "delete DEVID in HwAccount.xml");
        a2.m24828a("SUBDEVID");
        C5165e.m24906b("XmlFileGrade", "delete SUBDEVID in HwAccount.xml");
        a2.m24828a("hasEncryptHeadPictureUrl");
        C5165e.m24906b("XmlFileGrade", "delete hasEncryptHeadPictureUrl in HwAccount.xml");
        Object a3 = a2.m24827a("accessToken", "");
        if (!TextUtils.isEmpty(a3)) {
            a = C5201e.m25304a(context, a3);
            if (TextUtils.isEmpty(a)) {
                a2.m24828a("accessToken");
                C5165e.m24906b("XmlFileGrade", "accessToken ecb decrypt error");
            } else {
                C5165e.m24906b("XmlFileGrade", "update accessToken in HwAccount.xml");
                a2.m24831b("accessToken", a);
            }
        }
        a = a2.m24827a("UUID", "");
        if (TextUtils.isEmpty(a)) {
            a2.m24828a("UUID");
            C5165e.m24906b("XmlFileGrade", "uuid ecb decrypt error");
            return;
        }
        C5165e.m24906b("XmlFileGrade", "update uuid in HwAccount.xml");
        a2.m24831b("UUID", a);
    }

    private void m24842b(Context context) {
        if (!C5166b.m24953g(context)) {
            List a;
            if (m24843c(context)) {
                a = C5153d.m24839a("accounts.xml", context, false);
            } else {
                a = C5153d.m24839a("accounts.xml", context, true);
            }
            C5176g.m25013a(context, "accounts.xml");
            C5113b.m24638a(context, "accounts.xml", a, true);
        }
    }

    private boolean m24843c(Context context) {
        if (!TextUtils.isEmpty(C5176g.m25017b(context, "encryptversion")) || C5166b.m24928a(context, "isSDKAccountDataEncrypted", false)) {
            return false;
        }
        return true;
    }

    private static ArrayList<HwAccount> m24839a(String str, Context context, boolean z) {
        ArrayList<HwAccount> a;
        Throwable e;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str);
            if (file.exists()) {
                inputStream2 = new FileInputStream(file);
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(inputStream2, null);
                    a = C5153d.m24840a(newPullParser, context, z);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e2) {
                            C5165e.m24911d("XmlFileGrade", "IOException / " + e2.getMessage(), e2);
                        }
                    }
                } catch (XmlPullParserException e3) {
                    e = e3;
                    inputStream = inputStream2;
                    try {
                        C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
                        a = new ArrayList();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22) {
                                C5165e.m24911d("XmlFileGrade", "IOException / " + e22.getMessage(), e22);
                            }
                        }
                        return a;
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                C5165e.m24911d("XmlFileGrade", "IOException / " + e222.getMessage(), e222);
                            }
                        }
                        throw e;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    inputStream = inputStream2;
                    C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
                    a = new ArrayList();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e2222) {
                            C5165e.m24911d("XmlFileGrade", "IOException / " + e2222.getMessage(), e2222);
                        }
                    }
                    return a;
                } catch (IOException e5) {
                    e = e5;
                    inputStream = inputStream2;
                    C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
                    a = new ArrayList();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e22222) {
                            C5165e.m24911d("XmlFileGrade", "IOException / " + e22222.getMessage(), e22222);
                        }
                    }
                    return a;
                } catch (Exception e6) {
                    e = e6;
                    inputStream = inputStream2;
                    C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
                    a = new ArrayList();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e222222) {
                            C5165e.m24911d("XmlFileGrade", "IOException / " + e222222.getMessage(), e222222);
                        }
                    }
                    return a;
                } catch (Throwable th2) {
                    e = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw e;
                }
            }
            C5165e.m24904a("XmlFileGrade", " sdk filepath not exist");
            a = new ArrayList();
            if (null != null) {
                try {
                    inputStream2.close();
                } catch (Throwable e2222222) {
                    C5165e.m24911d("XmlFileGrade", "IOException / " + e2222222.getMessage(), e2222222);
                }
            }
        } catch (XmlPullParserException e7) {
            e = e7;
            C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
            a = new ArrayList();
            if (inputStream != null) {
                inputStream.close();
            }
            return a;
        } catch (FileNotFoundException e8) {
            e = e8;
            C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
            a = new ArrayList();
            if (inputStream != null) {
                inputStream.close();
            }
            return a;
        } catch (IOException e9) {
            e = e9;
            C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
            a = new ArrayList();
            if (inputStream != null) {
                inputStream.close();
            }
            return a;
        } catch (Exception e10) {
            e = e10;
            C5165e.m24911d("XmlFileGrade", "read xml failed!" + e.getMessage(), e);
            a = new ArrayList();
            if (inputStream != null) {
                inputStream.close();
            }
            return a;
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.huawei.hwid.core.datatype.HwAccount> m24840a(org.xmlpull.v1.XmlPullParser r7, android.content.Context r8, boolean r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r0 = "XmlFileGrade";
        r1 = "parseAccountsFromXml Start";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r0, r1);
        r0 = r7.getEventType();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = new com.huawei.hwid.core.datatype.HwAccount;
        r1.<init>();
    L_0x0015:
        r3 = 1;
        if (r3 == r0) goto L_0x0219;
    L_0x0018:
        r3 = r7.getName();
        switch(r0) {
            case 0: goto L_0x0028;
            case 1: goto L_0x001f;
            case 2: goto L_0x002a;
            case 3: goto L_0x0200;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r1;
    L_0x0020:
        r1 = r7.next();
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0015;
    L_0x0028:
        r0 = r1;
        goto L_0x0020;
    L_0x002a:
        r0 = "account";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0068;
    L_0x0032:
        r0 = "";
        r3 = "appId";
        r0 = r7.getAttributeValue(r0, r3);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x004b;
    L_0x0040:
        r0 = "XmlFileGrade";
        r3 = "authTokenType is null";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r0, r3);
        r0 = com.huawei.hwid.core.p435d.C5166b.m24937c(r8);
    L_0x004b:
        r1.m25123c(r0);
        r3 = "XmlFileGrade";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read authTokenType: ";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);
        r0 = r1;
        goto L_0x0020;
    L_0x0068:
        r0 = "accountName";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x009b;
    L_0x0070:
        r0 = r7.nextText();
        if (r9 == 0) goto L_0x007a;
    L_0x0076:
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25304a(r8, r0);
    L_0x007a:
        r1.m25121b(r0);
        r3 = "XmlFileGrade";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read u*n@me: ";
        r4 = r4.append(r5);
        r0 = com.huawei.hwid.core.encrypt.C5203g.m25322d(r0);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);
        r0 = r1;
        goto L_0x0020;
    L_0x009b:
        r0 = "userId";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00d3;
    L_0x00a4:
        r0 = r7.nextText();
        if (r9 == 0) goto L_0x00ae;
    L_0x00aa:
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25304a(r8, r0);
    L_0x00ae:
        r1.m25125d(r0);
        r3 = "XmlFileGrade";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read u*!d: ";
        r4 = r4.append(r5);
        r5 = "userId";
        r0 = com.huawei.hwid.core.encrypt.C5203g.m25318a(r5, r0);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);
        r0 = r1;
        goto L_0x0020;
    L_0x00d3:
        r0 = "deviceId";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0107;
    L_0x00db:
        r0 = r7.nextText();
        if (r9 == 0) goto L_0x00e5;
    L_0x00e1:
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25304a(r8, r0);
    L_0x00e5:
        r1.m25133h(r0);
        r3 = "XmlFileGrade";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read mDeviceId: ";
        r4 = r4.append(r5);
        r0 = com.huawei.hwid.core.encrypt.C5203g.m25316a(r0);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);
        r0 = r1;
        goto L_0x0020;
    L_0x0107:
        r0 = "subDeviceId";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x013c;
    L_0x0110:
        r0 = r7.nextText();
        if (r9 == 0) goto L_0x011a;
    L_0x0116:
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25304a(r8, r0);
    L_0x011a:
        r1.m25135i(r0);
        r3 = "XmlFileGrade";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read mSubDeviceId: ";
        r4 = r4.append(r5);
        r0 = com.huawei.hwid.core.encrypt.C5203g.m25316a(r0);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);
        r0 = r1;
        goto L_0x0020;
    L_0x013c:
        r0 = "deviceType";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0166;
    L_0x0144:
        r0 = r7.nextText();
        r1.m25137j(r0);
        r3 = "XmlFileGrade";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read mDeviceType: ";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);
        r0 = r1;
        goto L_0x0020;
    L_0x0166:
        r0 = "serviceToken";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x017d;
    L_0x016f:
        r0 = r7.nextText();
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25304a(r8, r0);
        r1.m25129f(r0);
        r0 = r1;
        goto L_0x0020;
    L_0x017d:
        r0 = "siteId";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x01c2;
    L_0x0186:
        r0 = r7.nextText();	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r1.m25118a(r0);	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r3 = "XmlFileGrade";
        r4 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r4.<init>();	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r5 = "read mSiteId: ";
        r4 = r4.append(r5);	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r0 = r4.append(r0);	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r0 = r0.toString();	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);	 Catch:{ NumberFormatException -> 0x01ac, Exception -> 0x01b7 }
        r0 = r1;
        goto L_0x0020;
    L_0x01ac:
        r0 = move-exception;
        r0 = "XmlFileGrade";
        r3 = "NumberFormatException: read accounts.xml parseInt error";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24908c(r0, r3);
        r0 = r1;
        goto L_0x0020;
    L_0x01b7:
        r0 = move-exception;
        r0 = "XmlFileGrade";
        r3 = "read accounts.xml parseInt error";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24908c(r0, r3);
        r0 = r1;
        goto L_0x0020;
    L_0x01c2:
        r0 = "accountType";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x01d4;
    L_0x01ca:
        r0 = r7.nextText();
        r1.m25131g(r0);
        r0 = r1;
        goto L_0x0020;
    L_0x01d4:
        r0 = "loginUserName";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x01ea;
    L_0x01dc:
        r0 = r7.nextText();
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25304a(r8, r0);
        r1.m25139k(r0);
        r0 = r1;
        goto L_0x0020;
    L_0x01ea:
        r0 = "countryIsoCode";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x001f;
    L_0x01f2:
        r0 = r7.nextText();
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25304a(r8, r0);
        r1.m25119a(r0);
        r0 = r1;
        goto L_0x0020;
    L_0x0200:
        r0 = "account";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0208:
        r0 = "XmlFileGrade";
        r3 = "parseAccountsFromXml add account";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r0, r3);
        r2.add(r1);
        r0 = new com.huawei.hwid.core.datatype.HwAccount;
        r0.<init>();
        goto L_0x0020;
    L_0x0219:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.core.d.a.d.a(org.xmlpull.v1.XmlPullParser, android.content.Context, boolean):java.util.ArrayList<com.huawei.hwid.core.datatype.HwAccount>");
    }
}
