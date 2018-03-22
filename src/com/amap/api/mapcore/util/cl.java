package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import com.amap.api.mapcore.util.de.C3312a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/* compiled from: LogWriter */
abstract class cl {
    private bv f11589a;

    protected abstract int mo4024a();

    protected abstract dh mo4025a(cv cvVar);

    protected abstract String mo4026a(String str);

    protected abstract String mo4027a(List<bv> list);

    protected abstract String mo4028b();

    cl() {
    }

    static cl m15857a(int i) {
        switch (i) {
            case 0:
                return new cf();
            case 1:
                return new ch();
            case 2:
                return new cc();
            default:
                return null;
        }
    }

    void m15873a(Context context, Throwable th, String str, String str2) {
        List<bv> b = m15864b(context);
        if (b != null && b.size() != 0) {
            String a = m15870a(th);
            if (a != null && !"".equals(a)) {
                for (bv bvVar : b) {
                    if (m15875a(bvVar.m15797f(), a)) {
                        m15874a(bvVar);
                        String c = m15865c();
                        String a2 = m15858a(context, bvVar);
                        String c2 = m15866c(context);
                        String b2 = m15863b(th);
                        if (b2 != null && !"".equals(b2)) {
                            int a3 = mo4024a();
                            StringBuilder stringBuilder = new StringBuilder();
                            if (str != null) {
                                stringBuilder.append("class:").append(str);
                            }
                            if (str2 != null) {
                                stringBuilder.append(" method:").append(str2).append("$").append("<br/>");
                            }
                            stringBuilder.append(a);
                            String a4 = mo4026a(a);
                            String a5 = m15860a(c2, a2, c, a3, b2, stringBuilder.toString());
                            if (a5 != null && !"".equals(a5)) {
                                String a6 = m15859a(context, a5);
                                String b3 = mo4028b();
                                synchronized (Looper.getMainLooper()) {
                                    cv cvVar = new cv(context);
                                    m15861a(cvVar, bvVar.m15791a(), a4, a3, m15862a(context, a4, b3, a6, cvVar));
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    void m15872a(Context context) {
        List b = m15864b(context);
        if (b != null && b.size() != 0) {
            String a = mo4027a(b);
            if (a != null && !"".equals(a)) {
                String c = m15865c();
                String a2 = m15858a(context, this.f11589a);
                int a3 = mo4024a();
                String a4 = m15860a(m15866c(context), a2, c, a3, "ANR", a);
                if (a4 != null && !"".equals(a4)) {
                    String a5 = mo4026a(a);
                    String a6 = m15859a(context, a4);
                    String b2 = mo4028b();
                    synchronized (Looper.getMainLooper()) {
                        cv cvVar = new cv(context);
                        m15861a(cvVar, this.f11589a.m15791a(), a5, a3, m15862a(context, a5, b2, a6, cvVar));
                    }
                }
            }
        }
    }

    protected void m15874a(bv bvVar) {
        this.f11589a = bvVar;
    }

    private List<bv> m15864b(Context context) {
        List<bv> a;
        Throwable th;
        Throwable th2;
        Throwable th3;
        List<bv> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    a = new cy(context, false).m15965a();
                    try {
                    } catch (Throwable th22) {
                        th = th22;
                        list = a;
                        th3 = th;
                        try {
                            throw th3;
                        } catch (Throwable th32) {
                            th = th32;
                            a = list;
                            th22 = th;
                        }
                    }
                } catch (Throwable th4) {
                    th32 = th4;
                    throw th32;
                }
            }
        } catch (Throwable th322) {
            th = th322;
            a = null;
            th22 = th;
            th22.printStackTrace();
            return a;
        }
    }

    private void m15861a(cv cvVar, String str, String str2, int i, boolean z) {
        cx cxVar = new cx();
        cxVar.m15957a(0);
        cxVar.m15961b(str);
        cxVar.m15958a(str2);
        cvVar.m15954b(cxVar, i);
    }

    private String m15860a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2).append(",").append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    private String m15859a(Context context, String str) {
        String str2 = null;
        try {
            str2 = by.m15818a(context, str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    private String m15865c() {
        return cm.m15909a(new Date().getTime());
    }

    protected String m15870a(Throwable th) {
        String str = null;
        try {
            str = cm.m15910a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str;
    }

    private String m15863b(Throwable th) {
        return th.toString();
    }

    private String m15858a(Context context, bv bvVar) {
        return bo.m15700a(context, bvVar);
    }

    private String m15866c(Context context) {
        return bm.m15684a(context);
    }

    private boolean m15862a(Context context, String str, String str2, String str3, cv cvVar) {
        boolean z;
        Throwable th;
        Throwable th2;
        OutputStream outputStream = null;
        de deVar = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(ci.f11609a);
            stringBuilder.append(str2);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                deVar = de.m16026a(file, 1, 1, 20480);
                deVar.m16047a(mo4025a(cvVar));
                if (deVar.m16046a(str) != null) {
                    z = false;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (deVar == null || deVar.m16048a()) {
                        return false;
                    }
                    try {
                        deVar.close();
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        th.printStackTrace();
                        return z;
                    }
                }
                byte[] bytes = str3.getBytes(GameManager.DEFAULT_CHARSET);
                C3312a b = deVar.m16049b(str);
                outputStream = b.m16006a(0);
                outputStream.write(bytes);
                b.m16007a();
                deVar.m16050b();
                z = true;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th32) {
                        th32.printStackTrace();
                    }
                }
                if (deVar == null || deVar.m16048a()) {
                    return true;
                }
                try {
                    deVar.close();
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    th.printStackTrace();
                    return z;
                }
            }
            z = false;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th322) {
                    th322.printStackTrace();
                }
            }
            if (deVar == null || deVar.m16048a()) {
                return false;
            }
            try {
                deVar.close();
                return false;
            } catch (Throwable th6) {
                th = th6;
            }
            if (!(deVar == null || deVar.m16048a())) {
                deVar.close();
            }
            return false;
            if (!(deVar == null || deVar.m16048a())) {
                deVar.close();
            }
            return false;
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th7) {
            th2 = th7;
            th2.printStackTrace();
        }
    }

    protected boolean m15875a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String indexOf : strArr) {
                if (str.indexOf(indexOf) != -1) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
