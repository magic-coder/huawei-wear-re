package com.huawei.hms.update.provider;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.huawei.hms.p039c.C0852a;
import java.io.File;
import java.io.IOException;

/* compiled from: ContentUriHelper */
class C0951a {
    private Context f1540a;
    private String f1541b;

    C0951a() {
    }

    public void m3322a(Context context) {
        C0852a.m3001a(context, "context nust not be null.");
        this.f1540a = context;
    }

    public File m3321a(String str) {
        String a = m3314a();
        if (a == null) {
            return null;
        }
        return C0951a.m3316b(new File(a, str));
    }

    private String m3314a() {
        String str;
        Context context = (Context) C0852a.m3003b(this.f1540a, "mContext is null, call setContext first.");
        synchronized (this) {
            if (this.f1541b == null) {
                if (context.getExternalCacheDir() != null) {
                    this.f1541b = C0951a.m3315a(context.getExternalCacheDir());
                } else {
                    this.f1541b = C0951a.m3315a(context.getFilesDir());
                }
            }
            str = this.f1541b;
        }
        return str;
    }

    public Uri m3319a(File file, String str) {
        String a = C0951a.m3315a(file);
        if (a == null) {
            return null;
        }
        a = m3317b(a);
        if (a != null) {
            return new Builder().scheme("content").authority(str).encodedPath(a).build();
        }
        return null;
    }

    private String m3317b(String str) {
        String a = m3314a();
        if (a == null || !str.startsWith(a)) {
            return null;
        }
        int length;
        if (a.endsWith("/")) {
            length = a.length();
        } else {
            length = a.length() + 1;
        }
        return Uri.encode("ContentUriHelper") + '/' + str.substring(length);
    }

    public File m3320a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        if (encodedPath == null) {
            return null;
        }
        encodedPath = m3318c(encodedPath);
        if (encodedPath != null) {
            return C0951a.m3316b(new File(encodedPath));
        }
        return null;
    }

    private String m3318c(String str) {
        String a = m3314a();
        if (a == null) {
            return null;
        }
        int indexOf = str.indexOf(47, 1);
        if (indexOf < 0) {
            return null;
        }
        if (!"ContentUriHelper".equals(Uri.decode(str.substring(1, indexOf)))) {
            return null;
        }
        String a2 = C0951a.m3315a(new File(a, Uri.decode(str.substring(indexOf + 1))));
        if (a2 == null || !a2.startsWith(a)) {
            return null;
        }
        return a2;
    }

    private static String m3315a(File file) {
        String str = null;
        if (file != null) {
            try {
                str = file.getCanonicalPath();
            } catch (IOException e) {
            }
        }
        return str;
    }

    private static File m3316b(File file) {
        File file2 = null;
        if (file != null) {
            try {
                file2 = file.getCanonicalFile();
            } catch (IOException e) {
            }
        }
        return file2;
    }
}
