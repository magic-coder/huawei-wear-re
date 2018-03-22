package com.huawei.appmarket.service.deamon.download;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.appmarket.C4234a;
import com.huawei.appmarket.p348a.p349a.C4212a;
import com.huawei.appmarket.p348a.p350b.C4213a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.service.download.C4308c;
import com.huawei.appmarket.sdk.service.download.C4316d;
import com.huawei.appmarket.service.p378b.C4324c;
import com.huawei.appmarket.service.p378b.C4325d;
import java.util.List;

public class C4328b extends C4308c {
    public static final String f16123a = (C4212a.m20466a() + ".DownloadDiskSpacePolicy");

    private C4324c m20849a(List<C4324c> list) {
        if (list != null) {
            for (C4324c c4324c : list) {
                if (c4324c.m20834c() == C4325d.INNER_SDCARD) {
                    return c4324c;
                }
            }
        }
        return null;
    }

    public C4316d mo4409a(long j) {
        C4316d c4316d = new C4316d(this);
        c4316d.f16049a = false;
        for (C4324c c4324c : C4213a.m20470c(C4234a.m20519a().m20523b())) {
            if (c4324c.m20834c() == C4325d.INNER_SDCARD) {
                break;
            }
        }
        C4324c c4324c2 = null;
        if (c4324c2 != null) {
            c4316d.f16052d = c4324c2.m20828a() + "/AppCache/";
            if (m20853a(j, c4324c2.m20835d())) {
                c4316d.f16049a = true;
            }
        }
        C4241a.m20529a("DownloadDiskSpacePolicy", "getBackupPolicy diskInfo:" + c4316d);
        return c4316d;
    }

    public C4316d mo4410a(long j, String str) {
        C4316d c4316d = new C4316d(this);
        c4316d.f16049a = true;
        C4324c b = C4213a.m20469b(C4234a.m20519a().m20523b());
        C4324c a = m20849a(C4213a.m20471d(C4234a.m20519a().m20523b()));
        if (a == null) {
            a = C4213a.m20472e(C4234a.m20519a().m20523b());
        }
        c4316d.f16050b = a.m20835d();
        c4316d.f16051c = b.m20835d();
        C4241a.m20529a("DownloadDiskSpacePolicy", "externalStorageSpace:" + c4316d.f16051c + "externalStoragePath:" + b.m20828a() + "/AppCache/");
        C4241a.m20529a("DownloadDiskSpacePolicy", "internalStorageSpace:" + c4316d.f16050b + ",internalStoragePath:" + a.m20828a() + "/AppCache/");
        if (m20853a(j, c4316d.f16051c)) {
            c4316d.f16052d = b.m20828a() + "/AppCache/";
        } else {
            String b2 = m20854b(j);
            if (b2 != null) {
                c4316d.f16052d = b2 + "/AppCache/";
                C4213a.m20468a(b2);
            } else if (m20853a(j, c4316d.f16050b)) {
                c4316d.f16052d = a.m20828a() + "/AppCache/";
                C4213a.m20468a(a.m20828a());
            } else {
                c4316d.f16049a = false;
                mo4411a(str);
            }
        }
        C4241a.m20529a("DownloadDiskSpacePolicy", "isEnough:" + c4316d.f16049a + ",availableStoragePath:" + c4316d.f16052d);
        return c4316d;
    }

    public void mo4411a(String str) {
        Intent intent = new Intent();
        intent.setAction(f16123a);
        intent.putExtra("APP_NAME", str);
        LocalBroadcastManager.getInstance(C4234a.m20519a().m20523b()).sendBroadcast(intent);
    }

    protected boolean m20853a(long j, long j2) {
        return 5242880 + j <= j2;
    }

    protected String m20854b(long j) {
        List c = C4213a.m20470c(C4234a.m20519a().m20523b());
        int size = c.size();
        if (size > 0) {
            C4324c c4324c = (C4324c) c.get(size - 1);
            String a = c4324c.m20828a();
            long d = c4324c.m20835d();
            C4241a.m20529a("DownloadDiskSpacePolicy", "maxStoragePath:" + a + ", freeSpace:" + d);
            if (m20853a(j, d)) {
                return a;
            }
        }
        return null;
    }

    public void mo4412b(String str) {
    }
}
