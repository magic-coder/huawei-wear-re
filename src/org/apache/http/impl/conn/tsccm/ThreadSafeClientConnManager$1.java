package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;

class ThreadSafeClientConnManager$1 implements ClientConnectionRequest {
    final /* synthetic */ ThreadSafeClientConnManager this$0;
    final /* synthetic */ PoolEntryRequest val$poolRequest;
    final /* synthetic */ HttpRoute val$route;

    public void abortRequest() {
        this.val$poolRequest.abortRequest();
    }

    ThreadSafeClientConnManager$1(ThreadSafeClientConnManager threadSafeClientConnManager, PoolEntryRequest poolEntryRequest, HttpRoute httpRoute) throws ConnectionPoolTimeoutException, InterruptedException {
        this.this$0 = threadSafeClientConnManager;
        this.val$poolRequest = poolEntryRequest;
        this.val$route = httpRoute;
    }

    public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
        if (this.val$route == null) {
            throw new IllegalArgumentException("Route may not be null.");
        }
        if (ThreadSafeClientConnManager.access$000(this.this$0).isDebugEnabled()) {
            ThreadSafeClientConnManager.access$000(this.this$0).debug("Get connection: " + this.val$route + ", timeout = " + j);
        }
        return new BasicPooledConnAdapter(this.this$0, this.val$poolRequest.getPoolEntry(j, timeUnit));
    }
}
