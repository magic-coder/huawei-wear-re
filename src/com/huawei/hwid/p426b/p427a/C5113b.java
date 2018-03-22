package com.huawei.hwid.p426b.p427a;

import android.content.Context;
import android.util.Xml;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: SDKAccountXmlImpl */
public class C5113b {
    private static void m24637a(Context context, HwAccount hwAccount, boolean z, XmlSerializer xmlSerializer) throws IllegalStateException, IllegalArgumentException, IOException {
        if (hwAccount != null) {
            xmlSerializer.startTag("", HwAccountConstants.ACCOUNT_KEY);
            xmlSerializer.attribute("", AppOpenOrDownHelper.APP_ID_PARAM, hwAccount.m25122c());
            String b = hwAccount.m25120b();
            if (z) {
                b = C5201e.m25307b(context, b);
            }
            C5176g.m25012a(xmlSerializer, "accountName", b);
            b = hwAccount.m25124d();
            if (z) {
                b = C5201e.m25307b(context, b);
            }
            C5176g.m25012a(xmlSerializer, "userId", b);
            b = hwAccount.m25134i();
            if (z) {
                b = C5201e.m25307b(context, b);
            }
            String str = "deviceId";
            if (b == null) {
                b = "";
            }
            C5176g.m25012a(xmlSerializer, str, b);
            b = hwAccount.m25136j();
            if (z) {
                b = C5201e.m25307b(context, b);
            }
            str = "subDeviceId";
            if (b == null) {
                b = "";
            }
            C5176g.m25012a(xmlSerializer, str, b);
            b = hwAccount.m25138k();
            str = "deviceType";
            if (b == null) {
                b = "";
            }
            C5176g.m25012a(xmlSerializer, str, b);
            C5176g.m25012a(xmlSerializer, "serviceToken", C5201e.m25307b(context, hwAccount.m25130g()));
            C5176g.m25012a(xmlSerializer, "loginUserName", C5201e.m25307b(context, hwAccount.m25140l()));
            C5176g.m25012a(xmlSerializer, "countryIsoCode", C5201e.m25307b(context, hwAccount.m25117a()));
            C5113b.m24639b(context, hwAccount, z, xmlSerializer);
            xmlSerializer.endTag("", HwAccountConstants.ACCOUNT_KEY);
        }
    }

    private static void m24639b(Context context, HwAccount hwAccount, boolean z, XmlSerializer xmlSerializer) throws IllegalStateException, IllegalArgumentException, IOException {
        C5176g.m25012a(xmlSerializer, "siteId", hwAccount.m25126e() + "");
        String h = hwAccount.m25132h();
        String str = "accountType";
        if (h == null) {
            h = "";
        }
        C5176g.m25012a(xmlSerializer, str, h);
        h = hwAccount.m25140l();
        if (z) {
            h = C5201e.m25307b(context, h);
        }
        str = "loginUserName";
        if (h == null) {
            h = "";
        }
        C5176g.m25012a(xmlSerializer, str, h);
        h = hwAccount.m25117a();
        if (z) {
            h = C5201e.m25307b(context, h);
        }
        str = "countryIsoCode";
        if (h == null) {
            h = "";
        }
        C5176g.m25012a(xmlSerializer, str, h);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m24638a(android.content.Context r6, java.lang.String r7, java.util.List<com.huawei.hwid.core.datatype.HwAccount> r8, boolean r9) {
        /*
        r0 = com.huawei.hwid.p426b.p427a.C5113b.m24636a(r8);
        if (r0 == 0) goto L_0x0014;
    L_0x0006:
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0014;
    L_0x000c:
        if (r8 == 0) goto L_0x0014;
    L_0x000e:
        r0 = r8.isEmpty();
        if (r0 == 0) goto L_0x001d;
    L_0x0014:
        r0 = "SDKAccountXmlImpl";
        r1 = "write accounts into file error";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r0, r1);
    L_0x001c:
        return;
    L_0x001d:
        r1 = android.util.Xml.newSerializer();
        r2 = new java.io.StringWriter;
        r2.<init>();
        r1.setOutput(r2);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = "UTF-8";
        r3 = 1;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1.startDocument(r0, r3);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = "";
        r3 = "accounts";
        r1.startTag(r0, r3);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = "";
        r3 = "size";
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r4.<init>();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r5 = r8.size();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r4 = r4.append(r5);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r4 = r4.toString();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1.attribute(r0, r3, r4);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r3 = r8.iterator();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
    L_0x005d:
        r0 = r3.hasNext();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        if (r0 == 0) goto L_0x00ae;
    L_0x0063:
        r0 = r3.next();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = (com.huawei.hwid.core.datatype.HwAccount) r0;	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        com.huawei.hwid.p426b.p427a.C5113b.m24637a(r6, r0, r9, r1);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        goto L_0x005d;
    L_0x006d:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ec }
        r3.<init>();	 Catch:{ all -> 0x01ec }
        r4 = "write accounts failed!";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01ec }
        r0 = r0.getMessage();	 Catch:{ all -> 0x01ec }
        r0 = r3.append(r0);	 Catch:{ all -> 0x01ec }
        r0 = r0.toString();	 Catch:{ all -> 0x01ec }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);	 Catch:{ all -> 0x01ec }
        r2.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x001c;
    L_0x008f:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "IOException / ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);
        goto L_0x001c;
    L_0x00ae:
        r0 = "";
        r3 = "accounts";
        r1.endTag(r0, r3);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1.endDocument();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0.<init>();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1 = r6.getFilesDir();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1 = r1.getAbsolutePath();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = r0.append(r1);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1 = "/";
        r0 = r0.append(r1);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = r0.toString();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1 = com.huawei.hwid.core.p435d.C5166b.m24943d(r1);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = com.huawei.hwid.core.p435d.C5176g.m25015a(r0, r7, r1);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r1 = "SDKAccountXmlImpl";
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r4 = "write accounts into file ";
        r3 = r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r3 = r3.append(r7);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r4 = ": ";
        r3 = r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = r3.append(r0);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r0 = r0.toString();	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r1, r0);	 Catch:{ IllegalArgumentException -> 0x006d, IllegalStateException -> 0x0126, IOException -> 0x0168, Exception -> 0x01aa }
        r2.close();	 Catch:{ IOException -> 0x0107 }
        goto L_0x001c;
    L_0x0107:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "IOException / ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);
        goto L_0x001c;
    L_0x0126:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ec }
        r3.<init>();	 Catch:{ all -> 0x01ec }
        r4 = "write accounts failed!";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01ec }
        r0 = r0.getMessage();	 Catch:{ all -> 0x01ec }
        r0 = r3.append(r0);	 Catch:{ all -> 0x01ec }
        r0 = r0.toString();	 Catch:{ all -> 0x01ec }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);	 Catch:{ all -> 0x01ec }
        r2.close();	 Catch:{ IOException -> 0x0149 }
        goto L_0x001c;
    L_0x0149:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "IOException / ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);
        goto L_0x001c;
    L_0x0168:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ec }
        r3.<init>();	 Catch:{ all -> 0x01ec }
        r4 = "write accounts failed!";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01ec }
        r0 = r0.getMessage();	 Catch:{ all -> 0x01ec }
        r0 = r3.append(r0);	 Catch:{ all -> 0x01ec }
        r0 = r0.toString();	 Catch:{ all -> 0x01ec }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);	 Catch:{ all -> 0x01ec }
        r2.close();	 Catch:{ IOException -> 0x018b }
        goto L_0x001c;
    L_0x018b:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "IOException / ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);
        goto L_0x001c;
    L_0x01aa:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ec }
        r3.<init>();	 Catch:{ all -> 0x01ec }
        r4 = "write accounts failed!";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01ec }
        r0 = r0.getMessage();	 Catch:{ all -> 0x01ec }
        r0 = r3.append(r0);	 Catch:{ all -> 0x01ec }
        r0 = r0.toString();	 Catch:{ all -> 0x01ec }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);	 Catch:{ all -> 0x01ec }
        r2.close();	 Catch:{ IOException -> 0x01cd }
        goto L_0x001c;
    L_0x01cd:
        r0 = move-exception;
        r1 = "SDKAccountXmlImpl";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "IOException / ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);
        goto L_0x001c;
    L_0x01ec:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x01f1 }
    L_0x01f0:
        throw r0;
    L_0x01f1:
        r1 = move-exception;
        r2 = "SDKAccountXmlImpl";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "IOException / ";
        r3 = r3.append(r4);
        r1 = r1.getMessage();
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r2, r1);
        goto L_0x01f0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.b.a.b.a(android.content.Context, java.lang.String, java.util.List, boolean):void");
    }

    public static ArrayList<HwAccount> m24634a(String str, Context context, boolean z) {
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
                    a = C5113b.m24635a(newPullParser, context, z);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e2) {
                            C5165e.m24911d("SDKAccountXmlImpl", "IOException / " + e2.getMessage(), e2);
                        }
                    }
                } catch (XmlPullParserException e3) {
                    e = e3;
                    inputStream = inputStream2;
                    try {
                        C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
                        a = new ArrayList();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22) {
                                C5165e.m24911d("SDKAccountXmlImpl", "IOException / " + e22.getMessage(), e22);
                            }
                        }
                        return a;
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                C5165e.m24911d("SDKAccountXmlImpl", "IOException / " + e222.getMessage(), e222);
                            }
                        }
                        throw e;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    inputStream = inputStream2;
                    C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
                    a = new ArrayList();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e2222) {
                            C5165e.m24911d("SDKAccountXmlImpl", "IOException / " + e2222.getMessage(), e2222);
                        }
                    }
                    return a;
                } catch (IOException e5) {
                    e = e5;
                    inputStream = inputStream2;
                    C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
                    a = new ArrayList();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e22222) {
                            C5165e.m24911d("SDKAccountXmlImpl", "IOException / " + e22222.getMessage(), e22222);
                        }
                    }
                    return a;
                } catch (Exception e6) {
                    e = e6;
                    inputStream = inputStream2;
                    C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
                    a = new ArrayList();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e222222) {
                            C5165e.m24911d("SDKAccountXmlImpl", "IOException / " + e222222.getMessage(), e222222);
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
            C5165e.m24904a("SDKAccountXmlImpl", " sdk filepath not exist");
            a = new ArrayList();
            if (null != null) {
                try {
                    inputStream2.close();
                } catch (Throwable e2222222) {
                    C5165e.m24911d("SDKAccountXmlImpl", "IOException / " + e2222222.getMessage(), e2222222);
                }
            }
        } catch (XmlPullParserException e7) {
            e = e7;
            C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
            a = new ArrayList();
            if (inputStream != null) {
                inputStream.close();
            }
            return a;
        } catch (FileNotFoundException e8) {
            e = e8;
            C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
            a = new ArrayList();
            if (inputStream != null) {
                inputStream.close();
            }
            return a;
        } catch (IOException e9) {
            e = e9;
            C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
            a = new ArrayList();
            if (inputStream != null) {
                inputStream.close();
            }
            return a;
        } catch (Exception e10) {
            e = e10;
            C5165e.m24911d("SDKAccountXmlImpl", "read xml failed!" + e.getMessage(), e);
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
    private static java.util.ArrayList<com.huawei.hwid.core.datatype.HwAccount> m24635a(org.xmlpull.v1.XmlPullParser r7, android.content.Context r8, boolean r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r0 = "SDKAccountXmlImpl";
        r1 = "parseAccountsFromXml Start";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r0, r1);
        r0 = r7.getEventType();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = new com.huawei.hwid.core.datatype.HwAccount;
        r1.<init>();
    L_0x0015:
        r3 = 1;
        if (r3 == r0) goto L_0x0239;
    L_0x0018:
        r3 = r7.getName();
        switch(r0) {
            case 0: goto L_0x0028;
            case 1: goto L_0x001f;
            case 2: goto L_0x002a;
            case 3: goto L_0x0220;
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
        r0 = "SDKAccountXmlImpl";
        r3 = "authTokenType is null";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r0, r3);
        r0 = com.huawei.hwid.core.p435d.C5166b.m24937c(r8);
    L_0x004b:
        r1.m25123c(r0);
        r3 = "SDKAccountXmlImpl";
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
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25308c(r8, r0);
    L_0x007a:
        r1.m25121b(r0);
        r3 = "SDKAccountXmlImpl";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read mUserName: ";
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
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25308c(r8, r0);
    L_0x00ae:
        r1.m25125d(r0);
        r3 = "SDKAccountXmlImpl";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read mUserId: ";
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
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25308c(r8, r0);
    L_0x00e5:
        r1.m25133h(r0);
        r3 = "SDKAccountXmlImpl";
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
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25308c(r8, r0);
    L_0x011a:
        r1.m25135i(r0);
        r3 = "SDKAccountXmlImpl";
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
        r3 = "SDKAccountXmlImpl";
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
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25308c(r8, r0);
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
        r3 = "SDKAccountXmlImpl";
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
        r0 = "SDKAccountXmlImpl";
        r3 = "NumberFormatException: read accounts.xml parseInt error";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24908c(r0, r3);
        r0 = r1;
        goto L_0x0020;
    L_0x01b7:
        r0 = move-exception;
        r0 = "SDKAccountXmlImpl";
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
        if (r0 == 0) goto L_0x0208;
    L_0x01dc:
        r0 = r7.nextText();
        if (r9 == 0) goto L_0x01e6;
    L_0x01e2:
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25308c(r8, r0);
    L_0x01e6:
        r1.m25139k(r0);
        r3 = "SDKAccountXmlImpl";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "read loginUserName: ";
        r4 = r4.append(r5);
        r0 = com.huawei.hwid.core.encrypt.C5203g.m25316a(r0);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r3, r0);
        r0 = r1;
        goto L_0x0020;
    L_0x0208:
        r0 = "countryIsoCode";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0210:
        r0 = r7.nextText();
        if (r9 == 0) goto L_0x021a;
    L_0x0216:
        r0 = com.huawei.hwid.core.encrypt.C5201e.m25308c(r8, r0);
    L_0x021a:
        r1.m25119a(r0);
        r0 = r1;
        goto L_0x0020;
    L_0x0220:
        r0 = "account";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0228:
        r0 = "SDKAccountXmlImpl";
        r3 = "parseAccountsFromXml add account";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24912e(r0, r3);
        r2.add(r1);
        r0 = new com.huawei.hwid.core.datatype.HwAccount;
        r0.<init>();
        goto L_0x0020;
    L_0x0239:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.b.a.b.a(org.xmlpull.v1.XmlPullParser, android.content.Context, boolean):java.util.ArrayList<com.huawei.hwid.core.datatype.HwAccount>");
    }

    private static List<HwAccount> m24636a(List<HwAccount> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (HwAccount hwAccount : list) {
            if (!C5166b.m24930a(hwAccount)) {
                arrayList.add(hwAccount);
            }
        }
        try {
            if (arrayList.isEmpty() || !list.containsAll(arrayList)) {
                return list;
            }
            list.removeAll(arrayList);
            return list;
        } catch (Exception e) {
            C5165e.m24910d("SDKAccountXmlImpl", e.getMessage());
            return list;
        }
    }
}
