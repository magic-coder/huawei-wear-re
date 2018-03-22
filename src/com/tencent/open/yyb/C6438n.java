package com.tencent.open.yyb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.tencent.open.p541a.C6367n;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public class C6438n {
    public static void m29354a(Context context, String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            String str5 = null;
            if (Uri.parse(str).getHost().toLowerCase().endsWith(".qq.com")) {
                str5 = ".qq.com";
            }
            instance.setCookie(str, C6438n.m29356b("logintype", "MOBILEQ", str5));
            instance.setCookie(str, C6438n.m29356b("qopenid", str2, str5));
            instance.setCookie(str, C6438n.m29356b("qaccesstoken", str3, str5));
            instance.setCookie(str, C6438n.m29356b("openappid", str4, str5));
            CookieSyncManager.getInstance().sync();
        }
    }

    private static String m29356b(String str, String str2, String str3) {
        String str4 = str + "=" + str2;
        if (str3 == null) {
            return str4;
        }
        return (str4 + "; path=/") + "; domain=" + str3;
    }

    public static Drawable m29352a(String str, Context context) {
        return C6438n.m29353a(str, context, new Rect(0, 0, 0, 0));
    }

    public static Drawable m29353a(String str, Context context, Rect rect) {
        Drawable ninePatchDrawable;
        IOException e;
        OutOfMemoryError e2;
        InputStream inputStream;
        Throwable th;
        Context applicationContext = context.getApplicationContext();
        InputStream open;
        try {
            open = applicationContext.getAssets().open(str);
            if (open != null) {
                try {
                    if (str.endsWith(".9.png")) {
                        Bitmap decodeStream = BitmapFactory.decodeStream(open);
                        if (decodeStream != null) {
                            ninePatchDrawable = new NinePatchDrawable(applicationContext.getResources(), decodeStream, decodeStream.getNinePatchChunk(), rect, null);
                        } else if (open == null) {
                            return null;
                        } else {
                            try {
                                open.close();
                                return null;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                    }
                    ninePatchDrawable = Drawable.createFromStream(open, str);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (OutOfMemoryError e5) {
                    e2 = e5;
                    inputStream = open;
                    try {
                        e2.printStackTrace();
                        C6367n.m29107b("openSDK_LOG", "-->(AppbarUtil)getDrawable : IOException");
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                ninePatchDrawable = null;
                            } catch (IOException e32) {
                                e32.printStackTrace();
                                ninePatchDrawable = null;
                            }
                            return ninePatchDrawable;
                        }
                        ninePatchDrawable = null;
                        return ninePatchDrawable;
                    } catch (Throwable th2) {
                        th = th2;
                        open = inputStream;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e32 = e6;
                    try {
                        e32.printStackTrace();
                        C6367n.m29107b("openSDK_LOG", "-->(AppbarUtil)getDrawable : IOException");
                        if (open != null) {
                            try {
                                open.close();
                                ninePatchDrawable = null;
                            } catch (IOException e322) {
                                e322.printStackTrace();
                                ninePatchDrawable = null;
                            }
                            return ninePatchDrawable;
                        }
                        ninePatchDrawable = null;
                        return ninePatchDrawable;
                    } catch (Throwable th3) {
                        th = th3;
                        if (open != null) {
                            open.close();
                        }
                        throw th;
                    }
                }
                return ninePatchDrawable;
            } else if (open == null) {
                return null;
            } else {
                try {
                    open.close();
                    return null;
                } catch (IOException e3222) {
                    e3222.printStackTrace();
                    return null;
                }
            }
        } catch (OutOfMemoryError e7) {
            e2 = e7;
            inputStream = null;
            e2.printStackTrace();
            C6367n.m29107b("openSDK_LOG", "-->(AppbarUtil)getDrawable : IOException");
            if (inputStream != null) {
                inputStream.close();
                ninePatchDrawable = null;
                return ninePatchDrawable;
            }
            ninePatchDrawable = null;
            return ninePatchDrawable;
        } catch (IOException e8) {
            e3222 = e8;
            open = null;
            e3222.printStackTrace();
            C6367n.m29107b("openSDK_LOG", "-->(AppbarUtil)getDrawable : IOException");
            if (open != null) {
                open.close();
                ninePatchDrawable = null;
                return ninePatchDrawable;
            }
            ninePatchDrawable = null;
            return ninePatchDrawable;
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    public static void m29355a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", "1000");
        bundle.putString(JoinConstants.ACTION, str2);
        bundle.putString("appid", str);
        bundle.putString("via", str3);
        new C6440p().execute(new Bundle[]{bundle});
    }
}
