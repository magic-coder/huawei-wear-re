package com.huawei.appmarket.sdk.service.download;

import android.os.Environment;
import android.os.StatFs;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.C4287d;
import com.huawei.appmarket.sdk.service.p372b.C4292a;
import java.io.File;

public class C4309b extends C4308c {
    private long m20773b() {
        long j = 50000000;
        try {
            StatFs statFs = new StatFs(C4287d.m20693a() ? Environment.getExternalStorageDirectory().getPath() : C4292a.m20708a().m20711d());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable e) {
            C4241a.m20530a("DefaultDiskSpacePolicy", "getSDFreeSpace exception:", e);
            return j;
        }
    }

    public C4316d mo4409a(long j) {
        return null;
    }

    public C4316d mo4410a(long j, String str) {
        C4316d c4316d = new C4316d(this);
        c4316d.f16049a = true;
        long b = m20773b();
        if (5242880 + j > b) {
            c4316d.f16049a = false;
            c4316d.f16050b = b;
        }
        c4316d.f16052d = m20776a();
        return c4316d;
    }

    public String m20776a() {
        String str = C4287d.m20692a(C4292a.m20708a().m20709b()) + "/AppCache/";
        File file = new File(str);
        if (!(file.exists() || file.mkdirs())) {
            C4241a.m20532b("DefaultDiskSpacePolicy", "getAppCache mkdirs failed!");
        }
        return str;
    }

    public void mo4411a(String str) {
    }

    public void mo4412b(String str) {
    }
}
