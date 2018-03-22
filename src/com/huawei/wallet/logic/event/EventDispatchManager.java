package com.huawei.wallet.logic.event;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class EventDispatchManager {
    private Map<String, IEventListener> f21257a;
    private byte[] f21258b;

    class EventDispatchInstance {
        static EventDispatchManager f21256a = new EventDispatchManager();

        private EventDispatchInstance() {
        }
    }

    private EventDispatchManager() {
        this.f21257a = new ConcurrentHashMap();
        this.f21258b = new byte[0];
    }

    public static EventDispatchManager m28051a() {
        return EventDispatchInstance.f21256a;
    }

    public void m28055a(String str, IEventListener iEventListener) {
        synchronized (this.f21258b) {
            this.f21257a.put(str, iEventListener);
        }
    }

    public void m28054a(String str) {
        m28052b("removeKeyPermission");
        synchronized (this.f21258b) {
            this.f21257a.remove(str);
        }
    }

    public void m28053a(IEventType iEventType, Object obj) {
        synchronized (this.f21258b) {
            for (Entry value : this.f21257a.entrySet()) {
                ((IEventListener) value.getValue()).onEventCallBack(iEventType, obj);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m28056a(java.lang.String r3, com.huawei.wallet.logic.event.IEventType r4, java.lang.Object r5) {
        /*
        r2 = this;
        r1 = r2.f21258b;
        monitor-enter(r1);
        r0 = r2.f21257a;	 Catch:{ all -> 0x0018 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r2.f21257a;	 Catch:{ all -> 0x0018 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0018 }
        r0 = (com.huawei.wallet.logic.event.IEventListener) r0;	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r0.onEventCallBack(r4, r5);	 Catch:{ all -> 0x0018 }
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        goto L_0x0008;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wallet.logic.event.EventDispatchManager.a(java.lang.String, com.huawei.wallet.logic.event.IEventType, java.lang.Object):void");
    }

    private void m28052b(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess(str);
        }
    }
}
