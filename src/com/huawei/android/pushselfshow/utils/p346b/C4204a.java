package com.huawei.android.pushselfshow.utils.p346b;

import com.huawei.android.pushagent.c.a.e;
import java.io.File;

public class C4204a {
    private String f15813a;
    private String f15814b;

    public C4204a(String str, String str2) {
        this.f15813a = str;
        this.f15814b = str2;
    }

    public static File m20444a(String str, String str2) {
        File file;
        String[] split = str2.split("/");
        File file2 = new File(str);
        int i = 0;
        while (i < split.length - 1) {
            try {
                i++;
                file2 = new File(file2, new String(split[i].getBytes("8859_1"), "GB2312"));
            } catch (Exception e) {
                Exception exception = e;
                file = file2;
                Exception exception2 = exception;
            }
        }
        e.a("PushSelfShowLog", "file1 = " + file2);
        if (!(file2.exists() || file2.mkdirs())) {
            e.a("PushSelfShowLog", "ret.mkdirs faild");
        }
        String str3 = new String(split[split.length - 1].getBytes("8859_1"), "GB2312");
        e.a("PushSelfShowLog", "substr = " + str3);
        file = new File(file2, str3);
        try {
            e.a("PushSelfShowLog", "file2 = " + file);
        } catch (Exception e2) {
            exception2 = e2;
            exception2.printStackTrace();
            return file;
        }
        return file;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m20445a() {
        /*
        r12 = this;
        r2 = 0;
        r0 = r12.f15814b;	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r1 = "/";
        r0 = r0.endsWith(r1);	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        if (r0 != 0) goto L_0x0022;
    L_0x000b:
        r0 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r0.<init>();	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r1 = r12.f15814b;	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r0 = r0.append(r1);	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r1 = "/";
        r0 = r0.append(r1);	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r12.f15814b = r0;	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
    L_0x0022:
        r6 = new java.util.zip.ZipFile;	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r0 = new java.io.File;	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r1 = r12.f15813a;	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r0.<init>(r1);	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r6.<init>(r0);	 Catch:{ ZipException -> 0x061d, IOException -> 0x0619, IllegalStateException -> 0x0615, NoSuchElementException -> 0x0611, all -> 0x0609 }
        r7 = r6.entries();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r8 = new byte[r0];	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0036:
        r0 = r7.hasMoreElements();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        if (r0 == 0) goto L_0x05c2;
    L_0x003c:
        r0 = r7.nextElement();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = (java.util.zip.ZipEntry) r0;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r0.isDirectory();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        if (r1 == 0) goto L_0x00ad;
    L_0x0048:
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "ze.getName() = ";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = r0.getName();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3 = r3.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r3);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3 = r12.f15814b;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.append(r3);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3 = r0.getName();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.append(r3);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3 = new java.lang.String;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "8859_1";
        r1 = r1.getBytes(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "GB2312";
        r3.<init>(r1, r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = "PushSelfShowLog";
        r4 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r5 = "str = ";
        r4 = r4.append(r5);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = r4.append(r3);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = r4.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = new java.io.File;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1.<init>(r3);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.mkdir();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        if (r1 != 0) goto L_0x0036;
    L_0x00ad:
        r1 = r12.f15814b;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3 = r0.getName();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3 = com.huawei.android.pushselfshow.utils.p346b.C4204a.m20444a(r1, r3);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r3.isDirectory();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        if (r1 == 0) goto L_0x00e2;
    L_0x00bd:
        if (r6 == 0) goto L_0x00c2;
    L_0x00bf:
        r6.close();	 Catch:{ IOException -> 0x00c3 }
    L_0x00c2:
        return;
    L_0x00c3:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "zfile.close error:";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r0);
        goto L_0x00c2;
    L_0x00e2:
        r1 = "PushSelfShowLog";
        r4 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r5 = "ze.getName() = ";
        r4 = r4.append(r5);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r5 = r0.getName();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = r4.append(r5);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r5 = ",output file :";
        r4 = r4.append(r5);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r5 = r3.getAbsolutePath();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = r4.append(r5);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = r4.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r0.getName();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        if (r1 == 0) goto L_0x0145;
    L_0x0117:
        r0 = "PushSelfShowLog";
        r1 = "ze.getName() is empty= ";
        com.huawei.android.pushagent.c.a.e.a(r0, r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        if (r6 == 0) goto L_0x00c2;
    L_0x0121:
        r6.close();	 Catch:{ IOException -> 0x0125 }
        goto L_0x00c2;
    L_0x0125:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "zfile.close error:";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r0);
        goto L_0x00c2;
    L_0x0145:
        r1 = r6.getInputStream(r0);	 Catch:{ IOException -> 0x0656, IllegalStateException -> 0x03c8, IndexOutOfBoundsException -> 0x047b, all -> 0x052e }
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x065d, IllegalStateException -> 0x0644, IndexOutOfBoundsException -> 0x0632, all -> 0x0620 }
        r5.<init>(r3);	 Catch:{ IOException -> 0x065d, IllegalStateException -> 0x0644, IndexOutOfBoundsException -> 0x0632, all -> 0x0620 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x0663, IllegalStateException -> 0x064a, IndexOutOfBoundsException -> 0x0638, all -> 0x0626 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x0663, IllegalStateException -> 0x064a, IndexOutOfBoundsException -> 0x0638, all -> 0x0626 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0668, IllegalStateException -> 0x064f, IndexOutOfBoundsException -> 0x063d, all -> 0x062b }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0668, IllegalStateException -> 0x064f, IndexOutOfBoundsException -> 0x063d, all -> 0x062b }
    L_0x0158:
        r0 = 0;
        r9 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = r3.read(r8, r0, r9);	 Catch:{ IOException -> 0x0167, IllegalStateException -> 0x0653, IndexOutOfBoundsException -> 0x0641 }
        r9 = -1;
        if (r0 == r9) goto L_0x0200;
    L_0x0162:
        r9 = 0;
        r4.write(r8, r9, r0);	 Catch:{ IOException -> 0x0167, IllegalStateException -> 0x0653, IndexOutOfBoundsException -> 0x0641 }
        goto L_0x0158;
    L_0x0167:
        r0 = move-exception;
    L_0x0168:
        r9 = "PushSelfShowLog";
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x062f }
        r10.<init>();	 Catch:{ all -> 0x062f }
        r11 = "os.write error:";
        r10 = r10.append(r11);	 Catch:{ all -> 0x062f }
        r0 = r0.getMessage();	 Catch:{ all -> 0x062f }
        r0 = r10.append(r0);	 Catch:{ all -> 0x062f }
        r0 = r0.toString();	 Catch:{ all -> 0x062f }
        com.huawei.android.pushagent.c.a.e.a(r9, r0);	 Catch:{ all -> 0x062f }
        if (r1 == 0) goto L_0x0189;
    L_0x0186:
        r1.close();	 Catch:{ IOException -> 0x036a, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0189:
        if (r3 == 0) goto L_0x018e;
    L_0x018b:
        r3.close();	 Catch:{ IOException -> 0x038a, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x018e:
        if (r4 == 0) goto L_0x0193;
    L_0x0190:
        r4.close();	 Catch:{ IOException -> 0x03a9, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0193:
        if (r5 == 0) goto L_0x0036;
    L_0x0195:
        r5.close();	 Catch:{ IOException -> 0x019a, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x019a:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "tempFOS.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x01ba:
        r0 = move-exception;
        r2 = r6;
    L_0x01bc:
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x060d }
        r3.<init>();	 Catch:{ all -> 0x060d }
        r4 = "upZipFile error:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x060d }
        r0 = r0.getMessage();	 Catch:{ all -> 0x060d }
        r0 = r3.append(r0);	 Catch:{ all -> 0x060d }
        r0 = r0.toString();	 Catch:{ all -> 0x060d }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ all -> 0x060d }
        if (r2 == 0) goto L_0x00c2;
    L_0x01db:
        r2.close();	 Catch:{ IOException -> 0x01e0 }
        goto L_0x00c2;
    L_0x01e0:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "zfile.close error:";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r0);
        goto L_0x00c2;
    L_0x0200:
        if (r1 == 0) goto L_0x0205;
    L_0x0202:
        r1.close();	 Catch:{ IOException -> 0x027b, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0205:
        if (r3 == 0) goto L_0x020a;
    L_0x0207:
        r3.close();	 Catch:{ IOException -> 0x02e0, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x020a:
        if (r4 == 0) goto L_0x020f;
    L_0x020c:
        r4.close();	 Catch:{ IOException -> 0x0344, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x020f:
        if (r5 == 0) goto L_0x0036;
    L_0x0211:
        r5.close();	 Catch:{ IOException -> 0x0216, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x0216:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "tempFOS.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x0236:
        r0 = move-exception;
    L_0x0237:
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0363 }
        r2.<init>();	 Catch:{ all -> 0x0363 }
        r3 = "upZipFile error:";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0363 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0363 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0363 }
        r0 = r0.toString();	 Catch:{ all -> 0x0363 }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ all -> 0x0363 }
        if (r6 == 0) goto L_0x00c2;
    L_0x0256:
        r6.close();	 Catch:{ IOException -> 0x025b }
        goto L_0x00c2;
    L_0x025b:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "zfile.close error:";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r0);
        goto L_0x00c2;
    L_0x027b:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r9 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r10 = "zFileIn.close error:";
        r9 = r9.append(r10);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r9.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0205;
    L_0x029b:
        r0 = move-exception;
    L_0x029c:
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0363 }
        r2.<init>();	 Catch:{ all -> 0x0363 }
        r3 = "upZipFile error:";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0363 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0363 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0363 }
        r0 = r0.toString();	 Catch:{ all -> 0x0363 }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ all -> 0x0363 }
        if (r6 == 0) goto L_0x00c2;
    L_0x02bb:
        r6.close();	 Catch:{ IOException -> 0x02c0 }
        goto L_0x00c2;
    L_0x02c0:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "zfile.close error:";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r0);
        goto L_0x00c2;
    L_0x02e0:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9 = "is.close error:";
        r3 = r3.append(r9);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x020a;
    L_0x02ff:
        r0 = move-exception;
    L_0x0300:
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0363 }
        r2.<init>();	 Catch:{ all -> 0x0363 }
        r3 = "upZipFile error:";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0363 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0363 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0363 }
        r0 = r0.toString();	 Catch:{ all -> 0x0363 }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ all -> 0x0363 }
        if (r6 == 0) goto L_0x00c2;
    L_0x031f:
        r6.close();	 Catch:{ IOException -> 0x0324 }
        goto L_0x00c2;
    L_0x0324:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "zfile.close error:";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r0);
        goto L_0x00c2;
    L_0x0344:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "os.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x020f;
    L_0x0363:
        r0 = move-exception;
    L_0x0364:
        if (r6 == 0) goto L_0x0369;
    L_0x0366:
        r6.close();	 Catch:{ IOException -> 0x05e9 }
    L_0x0369:
        throw r0;
    L_0x036a:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r9 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r10 = "zFileIn.close error:";
        r9 = r9.append(r10);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r9.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0189;
    L_0x038a:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9 = "is.close error:";
        r3 = r3.append(r9);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x018e;
    L_0x03a9:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "os.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0193;
    L_0x03c8:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
    L_0x03cd:
        r9 = "PushSelfShowLog";
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x062f }
        r10.<init>();	 Catch:{ all -> 0x062f }
        r11 = "os.write error:";
        r10 = r10.append(r11);	 Catch:{ all -> 0x062f }
        r0 = r0.getMessage();	 Catch:{ all -> 0x062f }
        r0 = r10.append(r0);	 Catch:{ all -> 0x062f }
        r0 = r0.toString();	 Catch:{ all -> 0x062f }
        com.huawei.android.pushagent.c.a.e.a(r9, r0);	 Catch:{ all -> 0x062f }
        if (r1 == 0) goto L_0x03ee;
    L_0x03eb:
        r1.close();	 Catch:{ IOException -> 0x041f, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x03ee:
        if (r3 == 0) goto L_0x03f3;
    L_0x03f0:
        r3.close();	 Catch:{ IOException -> 0x043e, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x03f3:
        if (r4 == 0) goto L_0x03f8;
    L_0x03f5:
        r4.close();	 Catch:{ IOException -> 0x045c, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x03f8:
        if (r5 == 0) goto L_0x0036;
    L_0x03fa:
        r5.close();	 Catch:{ IOException -> 0x03ff, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x03ff:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "tempFOS.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x041f:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r9 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r10 = "zFileIn.close error:";
        r9 = r9.append(r10);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r9.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x03ee;
    L_0x043e:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9 = "is.close error:";
        r3 = r3.append(r9);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x03f3;
    L_0x045c:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "os.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x03f8;
    L_0x047b:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
    L_0x0480:
        r9 = "PushSelfShowLog";
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x062f }
        r10.<init>();	 Catch:{ all -> 0x062f }
        r11 = "os.write error:";
        r10 = r10.append(r11);	 Catch:{ all -> 0x062f }
        r0 = r0.getMessage();	 Catch:{ all -> 0x062f }
        r0 = r10.append(r0);	 Catch:{ all -> 0x062f }
        r0 = r0.toString();	 Catch:{ all -> 0x062f }
        com.huawei.android.pushagent.c.a.e.a(r9, r0);	 Catch:{ all -> 0x062f }
        if (r1 == 0) goto L_0x04a1;
    L_0x049e:
        r1.close();	 Catch:{ IOException -> 0x04d2, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x04a1:
        if (r3 == 0) goto L_0x04a6;
    L_0x04a3:
        r3.close();	 Catch:{ IOException -> 0x04f1, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x04a6:
        if (r4 == 0) goto L_0x04ab;
    L_0x04a8:
        r4.close();	 Catch:{ IOException -> 0x050f, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x04ab:
        if (r5 == 0) goto L_0x0036;
    L_0x04ad:
        r5.close();	 Catch:{ IOException -> 0x04b2, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x04b2:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "tempFOS.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0036;
    L_0x04d2:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r9 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r10 = "zFileIn.close error:";
        r9 = r9.append(r10);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r9.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x04a1;
    L_0x04f1:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r9 = "is.close error:";
        r3 = r3.append(r9);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x04a6;
    L_0x050f:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "os.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r3.append(r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r0 = r0.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r1, r0);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x04ab;
    L_0x052e:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
    L_0x0533:
        if (r1 == 0) goto L_0x0538;
    L_0x0535:
        r1.close();	 Catch:{ IOException -> 0x0548, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0538:
        if (r3 == 0) goto L_0x053d;
    L_0x053a:
        r3.close();	 Catch:{ IOException -> 0x0567, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x053d:
        if (r4 == 0) goto L_0x0542;
    L_0x053f:
        r4.close();	 Catch:{ IOException -> 0x0585, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0542:
        if (r5 == 0) goto L_0x0547;
    L_0x0544:
        r5.close();	 Catch:{ IOException -> 0x05a3, ZipException -> 0x01ba, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0547:
        throw r0;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
    L_0x0548:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r7 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r7.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r8 = "zFileIn.close error:";
        r7 = r7.append(r8);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r7.append(r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r2, r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0538;
    L_0x0567:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r7 = "is.close error:";
        r3 = r3.append(r7);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r3.append(r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r2, r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x053d;
    L_0x0585:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "os.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r3.append(r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r2, r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0542;
    L_0x05a3:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r3.<init>();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r4 = "tempFOS.close error:";
        r3 = r3.append(r4);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.getMessage();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r3.append(r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        r1 = r1.toString();	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        com.huawei.android.pushagent.c.a.e.a(r2, r1);	 Catch:{ ZipException -> 0x01ba, IOException -> 0x0236, IllegalStateException -> 0x029b, NoSuchElementException -> 0x02ff }
        goto L_0x0547;
    L_0x05c2:
        if (r6 == 0) goto L_0x00c2;
    L_0x05c4:
        r6.close();	 Catch:{ IOException -> 0x05c9 }
        goto L_0x00c2;
    L_0x05c9:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "zfile.close error:";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r0);
        goto L_0x00c2;
    L_0x05e9:
        r1 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "zfile.close error:";
        r3 = r3.append(r4);
        r1 = r1.getMessage();
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.huawei.android.pushagent.c.a.e.a(r2, r1);
        goto L_0x0369;
    L_0x0609:
        r0 = move-exception;
        r6 = r2;
        goto L_0x0364;
    L_0x060d:
        r0 = move-exception;
        r6 = r2;
        goto L_0x0364;
    L_0x0611:
        r0 = move-exception;
        r6 = r2;
        goto L_0x0300;
    L_0x0615:
        r0 = move-exception;
        r6 = r2;
        goto L_0x029c;
    L_0x0619:
        r0 = move-exception;
        r6 = r2;
        goto L_0x0237;
    L_0x061d:
        r0 = move-exception;
        goto L_0x01bc;
    L_0x0620:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x0533;
    L_0x0626:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        goto L_0x0533;
    L_0x062b:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0533;
    L_0x062f:
        r0 = move-exception;
        goto L_0x0533;
    L_0x0632:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x0480;
    L_0x0638:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        goto L_0x0480;
    L_0x063d:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0480;
    L_0x0641:
        r0 = move-exception;
        goto L_0x0480;
    L_0x0644:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x03cd;
    L_0x064a:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        goto L_0x03cd;
    L_0x064f:
        r0 = move-exception;
        r3 = r2;
        goto L_0x03cd;
    L_0x0653:
        r0 = move-exception;
        goto L_0x03cd;
    L_0x0656:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x0168;
    L_0x065d:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x0168;
    L_0x0663:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        goto L_0x0168;
    L_0x0668:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0168;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.b.a.a():void");
    }
}
