package com.huawei.appmarket.service.deamon.download;

import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class C4331e {
    protected static final C4331e f16126a = new C4331e();
    protected C4332f f16127b = null;
    public DownloadService f16128c = null;
    private final AtomicInteger f16129d = new AtomicInteger();
    private final List<Message> f16130e = new ArrayList();

    public static C4331e m20857a() {
        return f16126a;
    }

    public DownloadService m20859b() {
        return f16126a.f16128c;
    }
}
