package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Message;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import com.huawei.hwversionmgr.a.b;
import com.huawei.hwversionmgr.a.e;
import com.huawei.hwversionmgr.utils.c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: CheckNewVersionThread */
public class C5386i implements Runnable {
    private static boolean f19157e = false;
    private Context f19158a;
    private String f19159b;
    private Handler f19160c;
    private Boolean f19161d;
    private PackageInfo f19162f = null;
    private String f19163g = "";

    public static boolean m25904a() {
        return f19157e;
    }

    public static void m25903a(boolean z) {
        f19157e = z;
    }

    public void m25905a(PackageInfo packageInfo) {
        this.f19162f = packageInfo;
    }

    public void m25906a(String str) {
        this.f19163g = str;
    }

    public C5386i(Context context, String str, Handler handler, Boolean bool) {
        this.f19158a = context;
        this.f19159b = str;
        this.f19160c = handler;
        this.f19161d = bool;
    }

    public void run() {
        Object a;
        c.b(this.f19159b);
        if (this.f19162f != null) {
            a = C5388k.m25920a(this.f19158a, this.f19162f, this.f19163g);
        } else {
            a = C5388k.m25921a(this.f19158a, this.f19159b);
        }
        C2538c.c("CheckNewVersionThread", new Object[]{"send json: \n" + a.toString()});
        String a2 = C5387j.m25913a(a.toString());
        C2538c.c("CheckNewVersionThread", new Object[]{"receive json:" + a2});
        if (a2 != null) {
            e a3 = C5385h.m25899a(a2);
            Message message = new Message();
            if (a3 != null) {
                C2538c.c("CheckNewVersionThread", new Object[]{"==ww==  new version buildNewVersionInfoXML applicationInfo = " + a3.toString()});
                String str = a3.b;
                C2538c.c("CheckNewVersionThread", new Object[]{"sendJsonStreamToServer: applicationInfo.STATUS:" + a3.t + ";"});
                String str2 = a3.e + "full/" + "filelist.xml";
                if (a3.t == 0) {
                    e a4 = m25902a(this.f19158a, str2, a3);
                    if (a4 == null) {
                        message.what = 0;
                    } else {
                        C2538c.c("CheckNewVersionThread", new Object[]{"getFileListXMLFromServer: applicationInfo.STATUS:" + a4.t + ";"});
                        a4.u = a4.e + "full/" + a4.j;
                        b a5 = C5387j.m25908a(a4);
                        a5.b = str;
                        if (this.f19161d.booleanValue()) {
                            message.what = 1;
                        } else {
                            message.what = 2;
                        }
                        message.obj = a5;
                        a3 = a4;
                    }
                } else {
                    if (this.f19161d.booleanValue()) {
                        message.what = 1;
                    } else {
                        message.what = 2;
                    }
                    C2538c.c("CheckNewVersionThread", new Object[]{"applicationInfo is NULL;"});
                }
            } else {
                message.what = 0;
            }
            if (this.f19161d.booleanValue()) {
                c.a(null);
                c.a(a3);
            } else {
                c.b(null);
                c.b(a3);
            }
            if (!C5386i.m25904a()) {
                this.f19160c.sendMessage(message);
                return;
            }
            return;
        }
        Message message2 = new Message();
        message2.what = 0;
        if (C5386i.m25904a()) {
            C2538c.c("CheckNewVersionThread", new Object[]{"CancelCheckFlag is ture;"});
            return;
        }
        this.f19160c.sendMessage(message2);
        if (this.f19161d.booleanValue()) {
            c.a(null);
        } else {
            c.b(null);
        }
    }

    private e m25902a(Context context, String str, e eVar) {
        Object obj;
        e a;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = -1;
        Object toByteArray;
        try {
            i = C5387j.m25907a(context, str, byteArrayOutputStream);
            C2538c.c("CheckNewVersionThread", new Object[]{"retrieve filelist.xml: \n" + byteArrayOutputStream.toString(GameManager.DEFAULT_CHARSET)});
            if (i == 200) {
                C2538c.c("CheckNewVersionThread", new Object[]{"get file list success"});
                toByteArray = byteArrayOutputStream.toByteArray();
                i = 0;
                while (i < toByteArray.length && toByteArray[i] != TagName.TagExpectationAndNext) {
                    i++;
                }
                obj = new byte[(toByteArray.length - i)];
                System.arraycopy(toByteArray, i, obj, 0, toByteArray.length - i);
                a = C5384g.m25894a(new ByteArrayInputStream(obj), eVar);
            } else {
                a = null;
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                C2538c.c("CheckNewVersionThread", new Object[]{"pack error!", e});
            }
        } catch (IOException e2) {
            C2538c.c("CheckNewVersionThread", new Object[]{"IOException"});
            if (i == 200) {
                C2538c.c("CheckNewVersionThread", new Object[]{"get file list success"});
                toByteArray = byteArrayOutputStream.toByteArray();
                i = 0;
                while (i < toByteArray.length && toByteArray[i] != TagName.TagExpectationAndNext) {
                    i++;
                }
                obj = new byte[(toByteArray.length - i)];
                System.arraycopy(toByteArray, i, obj, 0, toByteArray.length - i);
                a = C5384g.m25894a(new ByteArrayInputStream(obj), eVar);
            } else {
                a = null;
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                C2538c.c("CheckNewVersionThread", new Object[]{"pack error!", e3});
            }
        } catch (Throwable th) {
            if (i == 200) {
                C2538c.c("CheckNewVersionThread", new Object[]{"get file list success"});
                obj = byteArrayOutputStream.toByteArray();
                i = 0;
                while (i < obj.length && obj[i] != TagName.TagExpectationAndNext) {
                    i++;
                }
                Object obj2 = new byte[(obj.length - i)];
                System.arraycopy(obj, i, obj2, 0, obj.length - i);
                C5384g.m25894a(new ByteArrayInputStream(obj2), eVar);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                C2538c.c("CheckNewVersionThread", new Object[]{"pack error!", e4});
            }
        }
        return a;
    }
}
