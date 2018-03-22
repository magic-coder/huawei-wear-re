package com.huawei.wallet.utils.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.huawei.wallet.utils.log.LogC;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class BpDecodeUtil {
    public static Bitmap m28500a(String str, int i, int i2) {
        FileInputStream fileInputStream;
        Throwable th;
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    options.inSampleSize = m28499a(options, -1, i * i2);
                    options.inJustDecodeBounds = false;
                    fileInputStream = new FileInputStream(file);
                    try {
                        bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                LogC.m28534d("decodeFile stream close error ", false);
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        try {
                            LogC.m28534d("decodeFile error file not fount", false);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    LogC.m28534d("decodeFile stream close error ", false);
                                }
                            }
                            return bitmap;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    LogC.m28534d("decodeFile stream close error ", false);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        LogC.m28534d("decodeFile error ", false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                LogC.m28534d("decodeFile stream close error ", false);
                            }
                        }
                        return bitmap;
                    }
                } catch (FileNotFoundException e7) {
                    fileInputStream = bitmap;
                    LogC.m28534d("decodeFile error file not fount", false);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return bitmap;
                } catch (Exception e8) {
                    fileInputStream = bitmap;
                    LogC.m28534d("decodeFile error ", false);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    fileInputStream = bitmap;
                    th = th4;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
        }
        return bitmap;
    }

    private static int m28499a(Options options, int i, int i2) {
        int b = m28501b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    private static int m28501b(Options options, int i, int i2) {
        int i3;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        if (i == -1) {
            i3 = 128;
        } else {
            i3 = (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        }
        if (i3 < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        if (i != -1) {
            return i3;
        }
        return ceil;
    }
}
