package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.mapcore.util.bv.C3299a;
import com.amap.api.mapcore.util.dl.C3272a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: SDKCoordinatorDownload */
public class bu extends Thread implements C3272a {
    private static String f11542h = "sodownload";
    private static String f11543i = "sofail";
    private dl f11544a = new dl(this.f11545b);
    private C3297a f11545b;
    private RandomAccessFile f11546c;
    private String f11547d;
    private String f11548e;
    private String f11549f;
    private Context f11550g;

    /* compiled from: SDKCoordinatorDownload */
    class C3297a extends dp {
        private String f11541a;

        C3297a(String str) {
            this.f11541a = str;
        }

        public Map<String, String> mo4004c() {
            return null;
        }

        public Map<String, String> mo4003b() {
            return null;
        }

        public String mo4002a() {
            return this.f11541a;
        }
    }

    public bu(Context context, String str, String str2, String str3) {
        this.f11550g = context;
        this.f11549f = str3;
        this.f11547d = m15773a(context, str + "temp.so");
        this.f11548e = m15773a(context, "libwgs2gcj.so");
        this.f11545b = new C3297a(str2);
    }

    public static String m15773a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    private static String m15774b(Context context, String str) {
        return m15773a(context, str);
    }

    public void m15776a() {
        if (this.f11545b != null && !TextUtils.isEmpty(this.f11545b.mo4002a()) && this.f11545b.mo4002a().contains("libJni_wgs2gcj.so") && this.f11545b.mo4002a().contains(Build.CPU_ABI) && !new File(this.f11548e).exists()) {
            start();
        }
    }

    public void run() {
        try {
            File file = new File(m15774b(this.f11550g, "tempfile"));
            if (file.exists()) {
                bn.m15695a(this.f11550g, new C3299a(f11543i, "1.0.0", "sodownload_1.0.0").m15789a(new String[0]).m15790a());
                file.delete();
            }
            this.f11544a.m16065a(this);
        } catch (Throwable th) {
            th.printStackTrace();
            m15775b();
        }
    }

    public void mo3997a(byte[] bArr, long j) {
        try {
            if (this.f11546c == null) {
                File file = new File(this.f11547d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f11546c = new RandomAccessFile(file, "rw");
            }
        } catch (FileNotFoundException e) {
            m15775b();
            e.printStackTrace();
        } catch (Throwable th) {
            m15775b();
            th.printStackTrace();
            return;
        }
        try {
            this.f11546c.seek(j);
            this.f11546c.write(bArr);
        } catch (IOException e2) {
            m15775b();
            e2.printStackTrace();
        }
    }

    public void mo3998d() {
        m15775b();
    }

    public void mo3999e() {
        try {
            if (this.f11546c != null) {
                this.f11546c.close();
            }
            if (!bs.m15755a(this.f11547d).equalsIgnoreCase(this.f11549f)) {
                m15775b();
                bn.m15695a(this.f11550g, new C3299a(f11543i, "1.0.0", "sodownload_1.0.0").m15789a(new String[0]).m15790a());
            } else if (new File(this.f11548e).exists()) {
                m15775b();
            } else {
                new File(this.f11547d).renameTo(new File(this.f11548e));
                bn.m15695a(this.f11550g, new C3299a(f11542h, "1.0.0", "sodownload_1.0.0").m15789a(new String[0]).m15790a());
            }
        } catch (Throwable th) {
            m15775b();
            File file = new File(this.f11548e);
            if (file.exists()) {
                file.delete();
            }
            try {
                bn.m15695a(this.f11550g, new C3299a(f11543i, "1.0.0", "sodownload_1.0.0").m15789a(new String[0]).m15790a());
            } catch (bl e) {
                e.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    public void mo3996a(Throwable th) {
        try {
            if (this.f11546c != null) {
                this.f11546c.close();
            }
            m15775b();
            File file = new File(m15774b(this.f11550g, "tempfile"));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdir();
                }
                file.createNewFile();
            }
        } catch (Throwable e) {
            cd.m15825a(e, "SDKCoordinatorDownload", "onException");
        } catch (Throwable e2) {
            cd.m15825a(e2, "SDKCoordinatorDownload", "onException");
        }
    }

    private void m15775b() {
        File file = new File(this.f11547d);
        if (file.exists()) {
            file.delete();
        }
    }
}
