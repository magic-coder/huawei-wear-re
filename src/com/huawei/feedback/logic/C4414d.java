package com.huawei.feedback.logic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: FeedbackDraftLogic */
public final class C4414d {
    public static String m21249a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            c.d("FeedbackDraftLogic", "imagePath is empty!");
            return null;
        }
        try {
            if (com.huawei.feedback.c.b(str) <= 102400) {
                return str;
            }
            String a = com.huawei.feedback.c.a();
            if (a == null) {
                c.d("FeedbackDraftLogic", "storagePath null!");
                return null;
            }
            Bitmap decodeFile;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int ceil = (int) Math.ceil((double) (((float) options.outWidth) / 480.0f));
            int ceil2 = (int) Math.ceil((double) (((float) options.outHeight) / 854.0f));
            if (ceil <= 1 && ceil2 <= 1) {
                ceil = 1;
            } else if (ceil <= ceil2) {
                ceil = ceil2;
            }
            options.inSampleSize = ceil;
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            try {
                decodeFile = BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e) {
                c.d("FeedbackDraftLogic", "OutOfMemoryError");
                decodeFile = null;
            }
            if (decodeFile == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(a);
            stringBuilder.append("/phoneservice/image");
            File file = new File(stringBuilder.toString());
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            stringBuilder.append('/').append(com.huawei.feedback.c.b()).append(String.valueOf(i)).append(".jpg");
            str = stringBuilder.toString();
            if (!C4414d.m21250a(decodeFile, str)) {
                return null;
            }
            try {
                if (com.huawei.feedback.c.b(str) <= 2097152) {
                    return str;
                }
                c.d("FeedbackDraftLogic", "imageSize > FILE_SIZE_2M!");
                return null;
            } catch (IOException e2) {
                c.d("FeedbackDraftLogic", "getFileSize IOException!");
                return null;
            }
        } catch (FileNotFoundException e3) {
            c.d("FeedbackDraftLogic", "imagePath FileNotFoundException!");
            return null;
        } catch (IOException e4) {
            c.d("FeedbackDraftLogic", "imagePath IOException!");
            return null;
        }
    }

    public static boolean m21250a(Bitmap bitmap, String str) {
        Throwable th;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 20, byteArrayOutputStream);
        int length = byteArrayOutputStream.toByteArray().length;
        C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
        try {
            byteArrayOutputStream = new FileOutputStream(new File(str));
            if (length > 102400) {
                try {
                    bitmap.compress(CompressFormat.JPEG, 10, byteArrayOutputStream);
                } catch (FileNotFoundException e) {
                    try {
                        c.d("FeedbackDraftLogic", "compressPictureQuality FileNotFoundException");
                        C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
                        throw th;
                    }
                } catch (IOException e2) {
                    c.d("FeedbackDraftLogic", "compressPictureQuality IOException");
                    C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
                    return false;
                }
            }
            bitmap.compress(CompressFormat.JPEG, 20, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
            return true;
        } catch (FileNotFoundException e3) {
            byteArrayOutputStream = null;
            c.d("FeedbackDraftLogic", "compressPictureQuality FileNotFoundException");
            C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
            return false;
        } catch (IOException e4) {
            byteArrayOutputStream = null;
            c.d("FeedbackDraftLogic", "compressPictureQuality IOException");
            C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
            return false;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            C5767b.m26476a(byteArrayOutputStream, "FeedbackDraftLogic");
            throw th;
        }
    }
}
