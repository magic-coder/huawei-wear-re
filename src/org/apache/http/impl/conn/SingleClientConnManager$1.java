package org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;

class SingleClientConnManager$1 implements ClientConnectionRequest {
    final /* synthetic */ SingleClientConnManager this$0;
    final /* synthetic */ HttpRoute val$route;
    final /* synthetic */ Object val$state;

    public void abortRequest() {
    }

    SingleClientConnManager$1(SingleClientConnManager singleClientConnManager, HttpRoute httpRoute, Object obj) {
        this.this$0 = singleClientConnManager;
        this.val$route = httpRoute;
        this.val$state = obj;
    }

    public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) {
        return this.this$0.getConnection(this.val$route, this.val$state);
    }
}
