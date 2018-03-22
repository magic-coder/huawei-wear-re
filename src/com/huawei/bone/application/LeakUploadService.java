package com.huawei.bone.application;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import com.squareup.leakcanary.AnalysisResult;
import com.squareup.leakcanary.DisplayLeakService;
import com.squareup.leakcanary.HeapDump;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeakUploadService extends DisplayLeakService {
    public static String m2629a(Context context) {
        String str = "/sdcard/huaweisystem/com.huawei.bone/";
        try {
            str = Environment.getExternalStorageDirectory().getCanonicalPath() + "/huaweisystem/com.huawei.bone/";
        } catch (IOException e) {
            Log.e("LeakUploadService", "getLogFilePathPre: fail", null);
        }
        C2538c.m12677c("LeakUploadService", "pathPre = ", str);
        return str;
    }

    protected void afterDefaultHandling(HeapDump heapDump, AnalysisResult analysisResult, String str) {
        super.afterDefaultHandling(heapDump, analysisResult, str);
        if (analysisResult.leakFound && !analysisResult.excludedLeak) {
            m2630a(heapDump.heapDumpFile, str);
        }
    }

    private void m2630a(File file, String str) {
        IOException e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            File file2 = new File(m2629a(BaseApplication.m2632b()) + "leak.txt");
            if (!(file2.exists() || file2.createNewFile())) {
                C2538c.m12677c("LeakUploadService", "uploadLeakBlocking(), file create fail ");
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2, true);
            try {
                fileOutputStream2.write(str.getBytes(GameManager.DEFAULT_CHARSET));
                fileOutputStream2.flush();
                fileOutputStream2.close();
                FileOutputStream fileOutputStream3 = null;
                if (null != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e2) {
                        C2538c.m12679d("LeakUploadService", "uploadLeakBlocking() IOException:" + e2.getMessage());
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    C2538c.m12679d("LeakUploadService", "uploadLeakBlocking() IOException:" + e2.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            C2538c.m12679d("LeakUploadService", "uploadLeakBlocking() IOException:" + e22.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            C2538c.m12679d("LeakUploadService", "uploadLeakBlocking() IOException:" + e4.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e22 = e5;
            C2538c.m12679d("LeakUploadService", "uploadLeakBlocking() IOException:" + e22.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
