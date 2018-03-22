package com.huawei.common.applog.bean;

import com.huawei.phoneserviceuni.common.d.c;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: MessageQueueManage */
public final class C4349b {
    private static final C4349b f16175c = new C4349b();
    private BlockingQueue<HashMap<String, String>> f16176a = new LinkedBlockingQueue(50);
    private BlockingQueue<Event> f16177b = new LinkedBlockingQueue();

    private C4349b() {
    }

    public static C4349b m20911a() {
        return f16175c;
    }

    public boolean m20913a(HashMap<String, String> hashMap) {
        return this.f16176a.offer(hashMap);
    }

    public HashMap<String, String> m20914b() {
        return (HashMap) this.f16176a.poll();
    }

    public boolean m20912a(Event event) {
        return this.f16177b.offer(event);
    }

    public Event m20915c() {
        return (Event) this.f16177b.poll();
    }

    public void m20916d() {
        c.d("ReportApi", "messageQueue and eventQueue clear");
        this.f16176a.clear();
        this.f16177b.clear();
    }

    public String m20917e() {
        return this.f16176a.toString();
    }

    public BlockingQueue<HashMap<String, String>> m20918f() {
        return this.f16176a;
    }
}
