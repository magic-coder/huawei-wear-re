package com.huawei.pluginkidwatch.common.lib.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DownloadBitmapUtil */
public class C1486f {
    public static Bitmap m6871a(Context context, String str) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        C2538c.m12674b("DownloadBitmapUtil", "======= Enter getHttpBitmap, url is ", str);
        if (!"".equals(str) && ("".equals(str) || str.length() >= 32)) {
            String substring = str.substring(32);
            C2538c.m12674b("DownloadBitmapUtil", "==ww== DownloadBitmapUtil  url == " + str);
            C2538c.m12674b("DownloadBitmapUtil", "==ww== DownloadBitmapUtil  localUrl == " + substring);
            if (context == null || !C1492l.m6916b(context)) {
                C2538c.m12674b("DownloadBitmapUtil", "======= Network Is Not Connected !!! ");
            } else {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(substring).openConnection();
                    httpURLConnection.setConnectTimeout(2000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(true);
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        Bitmap a;
                        byte[] bArr = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        bArr = C1481a.m6816d(new String(byteArrayOutputStream.toByteArray(), GameManager.DEFAULT_CHARSET), str.substring(0, 16).getBytes(GameManager.DEFAULT_CHARSET), str.substring(16, 32).getBytes(GameManager.DEFAULT_CHARSET));
                        if (bArr != null) {
                            try {
                                a = C1486f.m6872a(bArr);
                            } catch (Exception e3) {
                                C2538c.m12680e("DownloadBitmapUtil", "Exception e = " + e3.getMessage());
                            }
                        } else {
                            a = null;
                        }
                        bitmap = a;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with download failure e = " + e4.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e42) {
                                C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with download failure e = " + e42.getMessage());
                            }
                        }
                    } catch (Exception e5) {
                        e3 = e5;
                        byteArrayOutputStream = null;
                        try {
                            C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with url" + str + "download failure e = " + e3.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e422) {
                                    C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with download failure e = " + e422.getMessage());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e4222) {
                                    C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with download failure e = " + e4222.getMessage());
                                }
                            }
                            return bitmap;
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e6) {
                                    C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with download failure e = " + e6.getMessage());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e62) {
                                    C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with download failure e = " + e62.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e3 = e7;
                    inputStream = null;
                    byteArrayOutputStream = null;
                    C2538c.m12674b("DownloadBitmapUtil", "======= Bitmap with url" + str + "download failure e = " + e3.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    byteArrayOutputStream = null;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
        }
        return bitmap;
    }

    private static Bitmap m6872a(byte[] bArr) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = 1;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }
}
