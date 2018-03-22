package com.huawei.logupload;

import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* compiled from: UploadFile */
public class C5445i {
    public static int m26102a(String str, String str2, GZIPOutputStream gZIPOutputStream) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------40612316912668\r\n");
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        stringBuilder.append("\r\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(str2);
        stringBuilder.append("\r\n");
        try {
            gZIPOutputStream.write(stringBuilder.toString().getBytes("utf-8"));
            return 0;
        } catch (IOException e) {
            return 1010;
        }
    }

    public static <T> int m26101a(T t) {
        try {
            if (t instanceof DataOutputStream) {
                ((DataOutputStream) t).write("-----------------------------40612316912668--\r\n".getBytes("utf-8"));
            } else if (t instanceof GZIPOutputStream) {
                ((GZIPOutputStream) t).write("-----------------------------40612316912668--\r\n".getBytes("utf-8"));
            }
            return 0;
        } catch (IOException e) {
            return 1010;
        }
    }
}
