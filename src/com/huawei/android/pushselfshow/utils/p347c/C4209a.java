package com.huawei.android.pushselfshow.utils.p347c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.p346b.C4205b;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class C4209a {
    public Bitmap m20458a(Context context, Bitmap bitmap, float f, float f2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f3 = f / ((float) width);
            float f4 = f2 / ((float) height);
            Matrix matrix = new Matrix();
            matrix.postScale(f3, f4);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (createBitmap == null) {
                return bitmap;
            }
            e.a("PushSelfShowLog", "reScaleBitmap success");
            return createBitmap;
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "reScaleBitmap fail ,error ：" + e, e);
            return bitmap;
        }
    }

    public Bitmap m20459a(Context context, String str) {
        InputStream fileInputStream;
        Throwable e;
        Object obj;
        Throwable th;
        Bitmap bitmap = null;
        File file;
        try {
            String str2 = WBConstants.GAME_PARAMS_GAME_IMAGE_URL + System.currentTimeMillis();
            String a = C4205b.m20446a(context);
            File file2 = new File(a);
            if (!file2.exists()) {
                e.a("PushSelfShowLog", "mkdir: " + file2.getAbsolutePath());
                if (!file2.mkdirs()) {
                    e.a("PushSelfShowLog", "file mkdir failed ,path is " + file2.getPath());
                }
            }
            str2 = a + File.separator + str2;
            e.a("PushSelfShowLog", "try to download image to " + str2);
            if (new C4205b().m20453b(context, str, str2)) {
                e.a("PushSelfShowLog", "download successed");
                Options options = new Options();
                options.inDither = false;
                options.inPurgeable = true;
                options.inSampleSize = 1;
                options.inPreferredConfig = Config.RGB_565;
                file = new File(str2);
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    obj = bitmap;
                    try {
                        e.c("PushSelfShowLog", "getRemoteImage  failed  ,errorinfo is " + e.toString(), e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e3) {
                                e.c("PushSelfShowLog", "is.close() error" + e3.toString(), e3);
                            }
                        }
                        e.a("PushSelfShowLog", "image delete success");
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e32) {
                                e.c("PushSelfShowLog", "is.close() error" + e32.toString(), e32);
                                throw th;
                            }
                        }
                        if (file != null && file.isFile() && file.delete()) {
                            e.a("PushSelfShowLog", "image delete success");
                        }
                        throw th;
                    }
                } catch (Throwable e322) {
                    obj = bitmap;
                    th = e322;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    e.a("PushSelfShowLog", "image delete success");
                    throw th;
                }
                try {
                    bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                } catch (Exception e4) {
                    e322 = e4;
                    e.c("PushSelfShowLog", "getRemoteImage  failed  ,errorinfo is " + e322.toString(), e322);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    e.a("PushSelfShowLog", "image delete success");
                    return bitmap;
                }
            }
            e.a("PushSelfShowLog", "download failed");
            Object obj2 = bitmap;
            obj = bitmap;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e3222) {
                    e.c("PushSelfShowLog", "is.close() error" + e3222.toString(), e3222);
                }
            }
            if (file != null && file.isFile() && file.delete()) {
                e.a("PushSelfShowLog", "image delete success");
            }
        } catch (Exception e5) {
            e3222 = e5;
            file = bitmap;
            fileInputStream = bitmap;
            e.c("PushSelfShowLog", "getRemoteImage  failed  ,errorinfo is " + e3222.toString(), e3222);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (file != null && file.isFile() && file.delete()) {
                e.a("PushSelfShowLog", "image delete success");
            }
            return bitmap;
        } catch (Throwable e32222) {
            file = bitmap;
            fileInputStream = bitmap;
            th = e32222;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            e.a("PushSelfShowLog", "image delete success");
            throw th;
        }
        return bitmap;
    }
}
