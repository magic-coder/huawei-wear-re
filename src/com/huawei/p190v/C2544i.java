package com.huawei.p190v;

import android.util.Log;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* compiled from: LogUtil */
class C2544i implements C2536a {
    C2544i() {
    }

    public boolean mo2672a(File file, String str, boolean z) {
        byte[] bArr = null;
        try {
            bArr = str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            Log.w("LogUtil", "write file failed");
        }
        if (bArr != null) {
            return m12694a(file, bArr, true);
        }
        return false;
    }

    public void mo2671a(File file, boolean z) {
    }

    private boolean m12694a(File file, byte[] bArr, boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(file, z);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                z2 = true;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        Log.w("LogUtil", "logOut close failed");
                    }
                }
            } catch (IOException e2) {
                try {
                    Log.w("LogUtil", "write failed in impl");
                    z2 = false;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            Log.w("LogUtil", "logOut close failed");
                        }
                    }
                    return z2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            Log.w("LogUtil", "logOut close failed");
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            fileOutputStream = null;
            Log.w("LogUtil", "write failed in impl");
            z2 = false;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z2;
    }
}
