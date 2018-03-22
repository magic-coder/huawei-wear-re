package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.routing.HttpRoute;

class ConnPoolByRoute$1 implements PoolEntryRequest {
    final /* synthetic */ ConnPoolByRoute this$0;
    final /* synthetic */ WaitingThreadAborter val$aborter;
    final /* synthetic */ HttpRoute val$route;
    final /* synthetic */ Object val$state;

    public void abortRequest() {
        ConnPoolByRoute.access$000(this.this$0).lock();
        try {
            this.val$aborter.abort();
        } finally {
            ConnPoolByRoute.access$000(this.this$0).unlock();
        }
    }

    ConnPoolByRoute$1(ConnPoolByRoute connPoolByRoute, WaitingThreadAborter waitingThreadAborter, HttpRoute httpRoute, Object obj) throws InterruptedException, ConnectionPoolTimeoutException {
        this.this$0 = connPoolByRoute;
        this.val$aborter = waitingThreadAborter;
        this.val$route = httpRoute;
        this.val$state = obj;
    }

    public BasicPoolEntry getPoolEntry(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
        return this.this$0.getEntryBlocking(this.val$route, this.val$state, j, timeUnit, this.val$aborter);
    }
}
