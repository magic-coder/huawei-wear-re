package com.huawei.hwid.update.provider;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.huawei.hwid.p075d.C1033a;
import java.io.File;
import java.io.IOException;

/* compiled from: ContentUriHelper */
class C1034a {
    private Context f1923a;
    private String f1924b;

    C1034a() {
    }

    public void m4174a(Context context) {
        C1033a.m4159a(context, "context nust not be null.");
        this.f1923a = context;
    }

    public File m4173a(String str) {
        String a = m4166a();
        if (a == null) {
            return null;
        }
        return C1034a.m4168b(new File(a, str));
    }

    private String m4166a() {
        String str;
        Context context = (Context) C1033a.m4160b(this.f1923a, "mContext is null, call setContext first.");
        synchronized (this) {
            if (this.f1924b == null) {
                if (context.getExternalCacheDir() != null) {
                    this.f1924b = C1034a.m4167a(context.getExternalCacheDir());
                } else {
                    this.f1924b = C1034a.m4167a(context.getFilesDir());
                }
            }
            str = this.f1924b;
        }
        return str;
    }

    public Uri m4171a(File file, String str) {
        String a = C1034a.m4167a(file);
        if (a == null) {
            return null;
        }
        a = m4169b(a);
        if (a != null) {
            return new Builder().scheme("content").authority(str).encodedPath(a).build();
        }
        return null;
    }

    private String m4169b(String str) {
        String a = m4166a();
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

    public File m4172a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        if (encodedPath == null) {
            return null;
        }
        encodedPath = m4170c(encodedPath);
        if (encodedPath != null) {
            return C1034a.m4168b(new File(encodedPath));
        }
        return null;
    }

    private String m4170c(String str) {
        String a = m4166a();
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
        String a2 = C1034a.m4167a(new File(a, Uri.decode(str.substring(indexOf + 1))));
        if (a2 == null || !a2.startsWith(a)) {
            return null;
        }
        return a2;
    }

    private static String m4167a(File file) {
        String str = null;
        if (file != null) {
            try {
                str = file.getCanonicalPath();
            } catch (IOException e) {
            }
        }
        return str;
    }

    private static File m4168b(File file) {
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
