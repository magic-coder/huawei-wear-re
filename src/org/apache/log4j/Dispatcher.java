package org.apache.log4j;

import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.helpers.BoundedFIFO;

class Dispatcher extends Thread {
    private AppenderAttachableImpl aai;
    private BoundedFIFO bf;
    AsyncAppender container;
    private boolean interrupted = false;

    Dispatcher(BoundedFIFO boundedFIFO, AsyncAppender asyncAppender) {
        this.bf = boundedFIFO;
        this.container = asyncAppender;
        this.aai = asyncAppender.aai;
        setDaemon(true);
        setPriority(1);
        setName(new StringBuffer().append("Dispatcher-").append(getName()).toString());
    }

    void close() {
        synchronized (this.bf) {
            this.interrupted = true;
            if (this.bf.length() == 0) {
                this.bf.notify();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r1 = r3.bf;
        monitor-enter(r1);
        r0 = r3.bf;	 Catch:{ all -> 0x0047 }
        r0 = r0.length();	 Catch:{ all -> 0x0047 }
        if (r0 != 0) goto L_0x001b;
    L_0x000b:
        r0 = r3.interrupted;	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x0016;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0047 }
    L_0x0010:
        r0 = r3.aai;
        r0.removeAllAppenders();
        return;
    L_0x0016:
        r0 = r3.bf;	 Catch:{ InterruptedException -> 0x0044 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0044 }
    L_0x001b:
        r0 = r3.bf;	 Catch:{ all -> 0x0047 }
        r0 = r0.get();	 Catch:{ all -> 0x0047 }
        r2 = r3.bf;	 Catch:{ all -> 0x0047 }
        r2 = r2.wasFull();	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x002e;
    L_0x0029:
        r2 = r3.bf;	 Catch:{ all -> 0x0047 }
        r2.notify();	 Catch:{ all -> 0x0047 }
    L_0x002e:
        monitor-exit(r1);	 Catch:{ all -> 0x0047 }
        r1 = r3.container;
        r1 = r1.aai;
        monitor-enter(r1);
        r2 = r3.aai;	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x003f;
    L_0x0038:
        if (r0 == 0) goto L_0x003f;
    L_0x003a:
        r2 = r3.aai;	 Catch:{ all -> 0x0041 }
        r2.appendLoopOnAppenders(r0);	 Catch:{ all -> 0x0041 }
    L_0x003f:
        monitor-exit(r1);	 Catch:{ all -> 0x0041 }
        goto L_0x0000;
    L_0x0041:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0041 }
        throw r0;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0047 }
        goto L_0x0010;
    L_0x0047:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0047 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.Dispatcher.run():void");
    }
}
