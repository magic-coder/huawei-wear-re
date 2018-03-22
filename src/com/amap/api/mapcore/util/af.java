package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: UnZipFile */
public class af {
    private C3276b f11403a;

    /* compiled from: UnZipFile */
    public interface C3273c {
        void mo4000a();

        void mo4001a(long j);
    }

    /* compiled from: UnZipFile */
    final class C32741 implements C3273c {
        final /* synthetic */ ac f11395a;

        C32741(ac acVar) {
            this.f11395a = acVar;
        }

        public void mo4001a(long j) {
            try {
                if (this.f11395a != null) {
                    this.f11395a.mo4053a(j);
                }
            } catch (Exception e) {
                ag.m15456b("UnzipFile zip Exception: " + e.getMessage());
            }
        }

        public void mo4000a() {
            if (this.f11395a != null) {
                this.f11395a.mo4062p();
            }
        }
    }

    /* compiled from: UnZipFile */
    public class C3275a {
        public boolean f11396a = false;
    }

    /* compiled from: UnZipFile */
    class C3276b {
        final /* synthetic */ af f11397a;
        private String f11398b;
        private String f11399c;
        private ac f11400d = null;
        private C3275a f11401e = new C3275a();
        private String f11402f;

        public C3276b(af afVar, String str, String str2, ac acVar) {
            this.f11397a = afVar;
            this.f11398b = str;
            this.f11399c = str2;
            this.f11400d = acVar;
        }

        public void m15435a(String str) {
            if (str.length() > 1) {
                this.f11402f = str;
            }
        }

        public String m15434a() {
            return this.f11398b;
        }

        public String m15436b() {
            return this.f11399c;
        }

        public String m15437c() {
            return this.f11402f;
        }

        public ac m15438d() {
            return this.f11400d;
        }

        public C3275a m15439e() {
            return this.f11401e;
        }

        public void m15440f() {
            this.f11401e.f11396a = true;
        }
    }

    public af(String str, String str2, ac acVar) {
        this.f11403a = new C3276b(this, str, str2, acVar);
    }

    public void m15447a() {
        if (this.f11403a != null) {
            this.f11403a.m15440f();
        }
    }

    public void m15448b() {
        if (this.f11403a != null) {
            m15442a(this.f11403a);
        } else {
            ag.m15456b("UnzipFile unzipFileTaskItem is null!");
        }
    }

    private static void m15442a(C3276b c3276b) {
        if (c3276b != null) {
            ac d = c3276b.m15438d();
            if (d != null) {
                d.mo4061o();
            }
            Object a = c3276b.m15434a();
            Object b = c3276b.m15436b();
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(b)) {
                File file = new File(a);
                if (file.exists()) {
                    C3273c c32741;
                    File file2 = new File(b);
                    if (file2.exists() || !file2.mkdirs()) {
                        c32741 = new C32741(d);
                    } else {
                        c32741 = new C32741(d);
                    }
                    try {
                        if (c3276b.m15439e().f11396a && d != null) {
                            d.mo4063q();
                        }
                        m15444a(file, file2, c32741, c3276b);
                        if (c3276b.m15439e().f11396a) {
                            if (d != null) {
                                d.mo4063q();
                            }
                        } else if (d != null) {
                            d.mo4056a(c3276b.m15437c());
                        }
                    } catch (Exception e) {
                        if (c3276b.m15439e().f11396a) {
                            if (d != null) {
                                d.mo4063q();
                            }
                        } else if (d != null) {
                            d.mo4062p();
                        }
                    }
                } else if (c3276b.m15439e().f11396a) {
                    if (d != null) {
                        d.mo4063q();
                    }
                } else if (d != null) {
                    d.mo4062p();
                }
            } else if (c3276b.m15439e().f11396a) {
                if (d != null) {
                    d.mo4063q();
                }
            } else if (d != null) {
                d.mo4062p();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m15444a(java.io.File r10, java.io.File r11, com.amap.api.mapcore.util.af.C3273c r12, com.amap.api.mapcore.util.af.C3276b r13) throws java.lang.Exception {
        /*
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r5 = r13.m15439e();
        r2 = 0;
        if (r12 == 0) goto L_0x0049;
    L_0x000d:
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0080 }
        r1.<init>(r10);	 Catch:{ Exception -> 0x0080 }
        r4 = new java.util.zip.CheckedInputStream;	 Catch:{ Exception -> 0x0080 }
        r6 = new java.util.zip.CRC32;	 Catch:{ Exception -> 0x0080 }
        r6.<init>();	 Catch:{ Exception -> 0x0080 }
        r4.<init>(r1, r6);	 Catch:{ Exception -> 0x0080 }
        r6 = new java.util.zip.ZipInputStream;	 Catch:{ Exception -> 0x0080 }
        r6.<init>(r4);	 Catch:{ Exception -> 0x0080 }
    L_0x0021:
        r7 = r6.getNextEntry();	 Catch:{ Exception -> 0x0080 }
        if (r7 == 0) goto L_0x0039;
    L_0x0027:
        if (r5 == 0) goto L_0x006c;
    L_0x0029:
        r8 = r5.f11396a;	 Catch:{ Exception -> 0x0080 }
        if (r8 == 0) goto L_0x006c;
    L_0x002d:
        r6.closeEntry();	 Catch:{ Exception -> 0x0080 }
        r6.close();	 Catch:{ Exception -> 0x0080 }
        r4.close();	 Catch:{ Exception -> 0x0080 }
        r1.close();	 Catch:{ Exception -> 0x0080 }
    L_0x0039:
        r0 = r0.toString();	 Catch:{ Exception -> 0x0080 }
        r13.m15435a(r0);	 Catch:{ Exception -> 0x0080 }
        r6.close();	 Catch:{ Exception -> 0x0080 }
        r4.close();	 Catch:{ Exception -> 0x0080 }
        r1.close();	 Catch:{ Exception -> 0x0080 }
    L_0x0049:
        r6 = new java.io.FileInputStream;
        r6.<init>(r10);
        r7 = new java.util.zip.CheckedInputStream;
        r0 = new java.util.zip.CRC32;
        r0.<init>();
        r7.<init>(r6, r0);
        r1 = new java.util.zip.ZipInputStream;
        r1.<init>(r7);
        r0 = r11;
        r4 = r12;
        m15445a(r0, r1, r2, r4, r5);
        r1.close();
        r7.close();
        r6.close();
        return;
    L_0x006c:
        r8 = r7.isDirectory();	 Catch:{ Exception -> 0x0080 }
        if (r8 != 0) goto L_0x0092;
    L_0x0072:
        r8 = r7.getName();	 Catch:{ Exception -> 0x0080 }
        r8 = m15446a(r8);	 Catch:{ Exception -> 0x0080 }
        if (r8 != 0) goto L_0x0085;
    L_0x007c:
        r12.mo4000a();	 Catch:{ Exception -> 0x0080 }
        goto L_0x0039;
    L_0x0080:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0049;
    L_0x0085:
        r8 = r7.getName();	 Catch:{ Exception -> 0x0080 }
        r8 = r0.append(r8);	 Catch:{ Exception -> 0x0080 }
        r9 = ";";
        r8.append(r9);	 Catch:{ Exception -> 0x0080 }
    L_0x0092:
        r8 = r7.getSize();	 Catch:{ Exception -> 0x0080 }
        r2 = r2 + r8;
        r6.closeEntry();	 Catch:{ Exception -> 0x0080 }
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.af.a(java.io.File, java.io.File, com.amap.api.mapcore.util.af$c, com.amap.api.mapcore.util.af$b):void");
    }

    private static void m15445a(File file, ZipInputStream zipInputStream, long j, C3273c c3273c, C3275a c3275a) throws Exception {
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (c3275a == null || !c3275a.f11396a) {
                String str = file.getPath() + File.separator + nextEntry.getName();
                if (!m15446a(str)) {
                    break;
                }
                File file2 = new File(str);
                m15443a(file2);
                int a = nextEntry.isDirectory() ? !file2.mkdirs() ? i : i : m15441a(file2, zipInputStream, (long) i, j, c3273c, c3275a) + i;
                zipInputStream.closeEntry();
                i = a;
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
        if (c3273c != null) {
            c3273c.mo4000a();
        }
        ag.m15456b("ZipEntry.getName contains ../ !");
    }

    private static boolean m15446a(String str) {
        if (str.contains("../")) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m15441a(java.io.File r8, java.util.zip.ZipInputStream r9, long r10, long r12, com.amap.api.mapcore.util.af.C3273c r14, com.amap.api.mapcore.util.af.C3275a r15) throws java.lang.Exception {
        /*
        r0 = 0;
        r1 = new java.io.BufferedOutputStream;
        r2 = new java.io.FileOutputStream;
        r2.<init>(r8);
        r1.<init>(r2);
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];
    L_0x000f:
        r3 = 0;
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = r9.read(r2, r3, r4);
        r4 = -1;
        if (r3 == r4) goto L_0x0040;
    L_0x0019:
        if (r15 == 0) goto L_0x0023;
    L_0x001b:
        r4 = r15.f11396a;
        if (r4 == 0) goto L_0x0023;
    L_0x001f:
        r1.close();
    L_0x0022:
        return r0;
    L_0x0023:
        r4 = 0;
        r1.write(r2, r4, r3);
        r0 = r0 + r3;
        r4 = 0;
        r3 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x000f;
    L_0x002e:
        if (r14 == 0) goto L_0x000f;
    L_0x0030:
        r4 = (long) r0;
        r4 = r4 + r10;
        r6 = 100;
        r4 = r4 * r6;
        r4 = r4 / r12;
        if (r15 == 0) goto L_0x003c;
    L_0x0038:
        r3 = r15.f11396a;
        if (r3 != 0) goto L_0x000f;
    L_0x003c:
        r14.mo4001a(r4);
        goto L_0x000f;
    L_0x0040:
        r1.close();
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.af.a(java.io.File, java.util.zip.ZipInputStream, long, long, com.amap.api.mapcore.util.af$c, com.amap.api.mapcore.util.af$a):int");
    }

    private static void m15443a(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            m15443a(parentFile);
            if (!parentFile.mkdir()) {
            }
        }
    }
}
