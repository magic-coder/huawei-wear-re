package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
import com.amap.api.services.core.bk.C3402a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/* compiled from: LogWriter */
abstract class bi {
    private ad f12395a;

    protected abstract int mo4116a();

    protected abstract bn mo4117a(ak akVar);

    protected abstract String mo4118a(String str);

    protected abstract String mo4119a(List<ad> list);

    protected abstract String mo4120b();

    bi() {
    }

    static bi m16738a(int i) {
        switch (i) {
            case 0:
                return new bc();
            case 1:
                return new be();
            case 2:
                return new ba();
            default:
                return null;
        }
    }

    void m16754a(Context context, Throwable th, String str, String str2) {
        List<ad> b = m16745b(context);
        if (b != null && b.size() != 0) {
            String a = m16751a(th);
            if (a != null && !"".equals(a)) {
                for (ad adVar : b) {
                    if (m16756a(adVar.m16618f(), a)) {
                        m16755a(adVar);
                        String c = m16746c();
                        String a2 = m16739a(context, adVar);
                        String c2 = m16747c(context);
                        String b2 = m16744b(th);
                        if (b2 != null && !"".equals(b2)) {
                            int a3 = mo4116a();
                            StringBuilder stringBuilder = new StringBuilder();
                            if (str != null) {
                                stringBuilder.append("class:").append(str);
                            }
                            if (str2 != null) {
                                stringBuilder.append(" method:").append(str2).append("$").append("<br/>");
                            }
                            stringBuilder.append(a);
                            String a4 = mo4118a(a);
                            String a5 = m16741a(c2, a2, c, a3, b2, stringBuilder.toString());
                            if (a5 != null && !"".equals(a5)) {
                                String a6 = m16740a(context, a5);
                                String b3 = mo4120b();
                                synchronized (Looper.getMainLooper()) {
                                    ak akVar = new ak(context);
                                    m16742a(akVar, adVar.m16613a(), a4, a3, m16743a(context, a4, b3, a6, akVar));
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

    void m16753a(Context context) {
        List b = m16745b(context);
        if (b != null && b.size() != 0) {
            String a = mo4119a(b);
            if (a != null && !"".equals(a)) {
                String c = m16746c();
                String a2 = m16739a(context, this.f12395a);
                int a3 = mo4116a();
                String a4 = m16741a(m16747c(context), a2, c, a3, "ANR", a);
                if (a4 != null && !"".equals(a4)) {
                    String a5 = mo4118a(a);
                    String a6 = m16740a(context, a4);
                    String b2 = mo4120b();
                    synchronized (Looper.getMainLooper()) {
                        ak akVar = new ak(context);
                        m16742a(akVar, this.f12395a.m16613a(), a5, a3, m16743a(context, a5, b2, a6, akVar));
                    }
                }
            }
        }
    }

    protected void m16755a(ad adVar) {
        this.f12395a = adVar;
    }

    private List<ad> m16745b(Context context) {
        List<ad> a;
        Throwable th;
        Throwable th2;
        Throwable th3;
        List<ad> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    a = new an(context).m16665a();
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

    private void m16742a(ak akVar, String str, String str2, int i, boolean z) {
        am amVar = new am();
        amVar.m16657a(0);
        amVar.m16661b(str);
        amVar.m16658a(str2);
        akVar.m16654b(amVar, i);
    }

    private String m16741a(String str, String str2, String str3, int i, String str4, String str5) {
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

    private String m16740a(Context context, String str) {
        String str2 = null;
        try {
            str2 = C3436y.m17001a(context, str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    private String m16746c() {
        return bj.m16789a(new Date().getTime());
    }

    protected String m16751a(Throwable th) {
        String str = null;
        try {
            str = bj.m16790a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str;
    }

    private String m16744b(Throwable th) {
        return th.toString();
    }

    private String m16739a(Context context, ad adVar) {
        return C3436y.m16998a(context, adVar);
    }

    private String m16747c(Context context) {
        return C3434w.m16992e(context);
    }

    private boolean m16743a(Context context, String str, String str2, String str3, ak akVar) {
        boolean z;
        Throwable th;
        Throwable th2;
        OutputStream outputStream = null;
        bk bkVar = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(bf.f12415a);
            stringBuilder.append(str2);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                bkVar = bk.m16814a(file, 1, 1, 20480);
                bkVar.m16835a(mo4117a(akVar));
                if (bkVar.m16834a(str) != null) {
                    z = false;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (bkVar == null || bkVar.m16836a()) {
                        return false;
                    }
                    try {
                        bkVar.close();
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        th.printStackTrace();
                        return z;
                    }
                }
                byte[] bytes = str3.getBytes(GameManager.DEFAULT_CHARSET);
                C3402a b = bkVar.m16837b(str);
                outputStream = b.m16794a(0);
                outputStream.write(bytes);
                b.m16795a();
                bkVar.m16838b();
                z = true;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th32) {
                        th32.printStackTrace();
                    }
                }
                if (bkVar == null || bkVar.m16836a()) {
                    return true;
                }
                try {
                    bkVar.close();
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
            if (bkVar == null || bkVar.m16836a()) {
                return false;
            }
            try {
                bkVar.close();
                return false;
            } catch (Throwable th6) {
                th = th6;
            }
            if (!(bkVar == null || bkVar.m16836a())) {
                bkVar.close();
            }
            return false;
            if (!(bkVar == null || bkVar.m16836a())) {
                bkVar.close();
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

    protected boolean m16756a(String[] strArr, String str) {
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
