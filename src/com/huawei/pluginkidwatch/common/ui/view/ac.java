package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1488h;
import com.huawei.pluginkidwatch.common.lib.utils.C1494n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ImageSaveRead */
public class ac {
    public static String m7223a(Context context, String str, Bitmap bitmap) {
        Exception e;
        OutputStream outputStream;
        Throwable th;
        String str2;
        String str3;
        String a = C1494n.m6927a(str);
        File file = new File(C1488h.m6881a(context));
        if (!(file.exists() || file.mkdirs())) {
            C2538c.m12680e("ImageSaveRead", "create file error");
        }
        File file2 = new File(C1488h.m6881a(context) + File.separator + a);
        if (file2.exists()) {
            return file.getPath();
        }
        if (bitmap == null) {
            return "";
        }
        FileOutputStream fileOutputStream = null;
        a = file.getPath();
        try {
            if (file2.createNewFile()) {
                OutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bitmap.compress(CompressFormat.JPEG, 70, fileOutputStream2);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                        } catch (IOException e2) {
                            C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e2.getMessage());
                            a = "";
                        }
                    }
                    if (fileOutputStream2 == null) {
                        return a;
                    }
                    try {
                        fileOutputStream2.close();
                        return a;
                    } catch (IOException e22) {
                        C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e22.getMessage());
                        return "";
                    }
                } catch (Exception e3) {
                    e = e3;
                    outputStream = fileOutputStream2;
                    try {
                        C2538c.m12680e("ImageSaveRead", "saveImage Exception e1" + e.getMessage());
                        a = "";
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                            } catch (IOException e222) {
                                C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e222.getMessage());
                                a = "";
                            }
                        }
                        if (fileOutputStream != null) {
                            return a;
                        }
                        try {
                            fileOutputStream.close();
                            return a;
                        } catch (IOException e2222) {
                            C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e2222.getMessage());
                            return "";
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                            } catch (IOException e4) {
                                C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e4.getMessage());
                                str2 = "";
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e5.getMessage());
                                str3 = "";
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
            a = "";
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                } catch (IOException e42) {
                    C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e42.getMessage());
                    str2 = "";
                }
            }
            if (fileOutputStream == null) {
                return a;
            }
            try {
                fileOutputStream.close();
                return a;
            } catch (IOException e52) {
                C2538c.m12680e("ImageSaveRead", "saveImage IOException e2" + e52.getMessage());
                str3 = "";
                return a;
            }
        } catch (Exception e6) {
            e = e6;
            C2538c.m12680e("ImageSaveRead", "saveImage Exception e1" + e.getMessage());
            a = "";
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                return a;
            }
            fileOutputStream.close();
            return a;
        }
    }

    public static Bitmap m7222a(Context context, String str) {
        String a = C1494n.m6927a(str);
        if (new File(C1488h.m6881a(context) + File.separator, a).exists()) {
            return m7224b(context, a);
        }
        return null;
    }

    public static Bitmap m7224b(Context context, String str) {
        File file = new File(C1488h.m6881a(context) + File.separator, str);
        if (!file.exists()) {
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath, options);
        options.inJustDecodeBounds = false;
        if (options.outWidth >= 200 || options.outHeight >= 200) {
            options.inSampleSize = 2;
        } else {
            options.inSampleSize = 1;
        }
        if (!(decodeFile == null || decodeFile.isRecycled())) {
            decodeFile.recycle();
        }
        return BitmapFactory.decodeFile(absolutePath, options);
    }
}
