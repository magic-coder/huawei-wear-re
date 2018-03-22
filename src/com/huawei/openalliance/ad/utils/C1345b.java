package com.huawei.openalliance.ad.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import com.huawei.openalliance.ad.utils.p129b.C1335c;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import com.sina.weibo.sdk.component.ShareRequestParam;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class C1345b {
    public static String m5934a(String str) {
        String a = C1365i.m6078a(str, ShareRequestParam.REQ_UPLOAD_PIC_PARAM_IMG, "src");
        return (a == null || !a.startsWith("file:///")) ? a : a.substring(8);
    }

    public static void m5935a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                C1336d.m5883a("FileUtil", "IOException", e);
            }
        }
    }

    public static void m5936a(String str, List<String> list) {
        if (!C1365i.m6081a(str)) {
            List arrayList = new ArrayList(4);
            if (list != null) {
                try {
                    for (String file : list) {
                        arrayList.add(new File(file).getCanonicalPath());
                    }
                } catch (Exception e) {
                    C1336d.m5888c("FileUtil", "get image canonical path fail");
                }
            }
            try {
                File file2 = new File(str);
                if (file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file3 : listFiles) {
                            String canonicalPath = file3.getCanonicalPath();
                            if (!(file3.isDirectory() || arrayList.contains(canonicalPath))) {
                                C1345b.m5937a(file3);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                C1336d.m5888c("FileUtil", "delete image fail");
            }
        }
    }

    public static boolean m5937a(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        return file.renameTo(file2) ? file2.delete() : false;
    }

    public static boolean m5938a(File file, long j, String str) {
        return file.exists() && file.length() > 0 && file.length() <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * j;
    }

    public static boolean m5939a(InputStream inputStream) {
        Object obj = null;
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr, 0, bArr.length);
            obj = C1335c.m5881a(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C1336d.m5888c("FileUtil", "fail to close input stream");
                }
            }
        } catch (IOException e2) {
            C1336d.m5888c("FileUtil", "IOException");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C1336d.m5888c("FileUtil", "fail to close input stream");
                }
            }
        } catch (Exception e4) {
            C1336d.m5888c("FileUtil", "Exception");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    C1336d.m5888c("FileUtil", "fail to close input stream");
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    C1336d.m5888c("FileUtil", "fail to close input stream");
                }
            }
        }
        return "47494638".equals(obj);
    }

    public static boolean m5940b(File file) {
        return file.exists() && file.length() > 0;
    }
}
