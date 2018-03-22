package com.tencent.open.p541a;

import android.os.StatFs;
import java.io.File;

/* compiled from: ProGuard */
public class C6364k {
    private File f22145a;
    private long f22146b;
    private long f22147c;

    public File m29095a() {
        return this.f22145a;
    }

    public void m29097a(File file) {
        this.f22145a = file;
    }

    public long m29098b() {
        return this.f22146b;
    }

    public void m29096a(long j) {
        this.f22146b = j;
    }

    public long m29100c() {
        return this.f22147c;
    }

    public void m29099b(long j) {
        this.f22147c = j;
    }

    public static C6364k m29094b(File file) {
        C6364k c6364k = new C6364k();
        c6364k.m29097a(file);
        StatFs statFs = new StatFs(file.getAbsolutePath());
        long blockSize = (long) statFs.getBlockSize();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        c6364k.m29096a(((long) statFs.getBlockCount()) * blockSize);
        c6364k.m29099b(blockSize * availableBlocks);
        return c6364k;
    }

    public String toString() {
        return String.format("[%s : %d / %d]", new Object[]{m29095a().getAbsolutePath(), Long.valueOf(m29100c()), Long.valueOf(m29098b())});
    }
}
