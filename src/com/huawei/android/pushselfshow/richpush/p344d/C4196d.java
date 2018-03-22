package com.huawei.android.pushselfshow.richpush.p344d;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileOutputStream;

public class C4196d {
    private String f15795a;
    private Context f15796b;

    public C4196d(Context context, String str) {
        this.f15795a = str;
        this.f15796b = context;
    }

    private String m20383b() {
        return "﻿<!DOCTYPE html>\t\t<html>\t\t   <head>\t\t     <meta charset=\"utf-8\">\t\t     <title></title>\t\t     <style type=\"text/css\">\t\t\t\t html { height:100%;}\t\t\t\t body { height:100%; text-align:center;}\t    \t    .centerDiv { display:inline-block; zoom:1; *display:inline; vertical-align:top; text-align:left; width:200px; padding:10px;margin-top:100px;}\t\t\t   .hiddenDiv { height:100%; overflow:hidden; display:inline-block; width:1px; overflow:hidden; margin-left:-1px; zoom:1; *display:inline; *margin-top:-1px; _margin-top:0; vertical-align:middle;}\t\t  \t</style>    \t  </head>\t\t <body>\t\t\t<div id =\"container\" class=\"centerDiv\">";
    }

    private String m20384c() {
        return "﻿\t\t</div>  \t\t<div class=\"hiddenDiv\"></div>\t  </body>   </html>";
    }

    public String m20385a() {
        Throwable e;
        Throwable e2;
        FileOutputStream fileOutputStream = null;
        if (this.f15796b == null) {
            e.d("PushSelfShowLog", "CreateHtmlFile fail ,context is null");
            return null;
        }
        String str = m20383b() + this.f15795a + m20384c();
        String str2 = this.f15796b.getFilesDir().getPath() + File.separator + "PushService" + File.separator + "richpush";
        String str3 = "error.html";
        File file = new File(str2);
        File file2 = new File(str2 + File.separator + str3);
        FileOutputStream fileOutputStream2;
        try {
            if (!file.exists()) {
                e.a("PushSelfShowLog", "Create the path:" + str2);
                if (!file.mkdirs()) {
                    e.a("PushSelfShowLog", "!path.mkdirs()");
                    if (null == null) {
                        return null;
                    }
                    try {
                        fileOutputStream.close();
                        return null;
                    } catch (Throwable e3) {
                        e.a("PushSelfShowLog", "stream.close() error ", e3);
                        return null;
                    }
                }
            }
            if (file2.exists()) {
                C4203a.m20426a(file2);
            }
            e.a("PushSelfShowLog", "Create the file:" + str3);
            if (file2.createNewFile()) {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(str.getBytes(GameManager.DEFAULT_CHARSET));
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable e22) {
                            e.a("PushSelfShowLog", "stream.close() error ", e22);
                        }
                    }
                    return file2.getAbsolutePath();
                } catch (Exception e4) {
                    e3 = e4;
                    try {
                        e.a("PushSelfShowLog", "Create html error ", e3);
                        if (fileOutputStream2 != null) {
                            return null;
                        }
                        try {
                            fileOutputStream2.close();
                            return null;
                        } catch (Throwable e32) {
                            e.a("PushSelfShowLog", "stream.close() error ", e32);
                            return null;
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable e322) {
                                e.a("PushSelfShowLog", "stream.close() error ", e322);
                            }
                        }
                        throw e22;
                    }
                }
            }
            e.a("PushSelfShowLog", "!file.createNewFile()");
            if (null == null) {
                return null;
            }
            try {
                fileOutputStream.close();
                return null;
            } catch (Throwable e3222) {
                e.a("PushSelfShowLog", "stream.close() error ", e3222);
                return null;
            }
        } catch (Exception e5) {
            e3222 = e5;
            fileOutputStream2 = null;
            e.a("PushSelfShowLog", "Create html error ", e3222);
            if (fileOutputStream2 != null) {
                return null;
            }
            fileOutputStream2.close();
            return null;
        } catch (Throwable e32222) {
            fileOutputStream2 = null;
            e22 = e32222;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw e22;
        }
    }
}
