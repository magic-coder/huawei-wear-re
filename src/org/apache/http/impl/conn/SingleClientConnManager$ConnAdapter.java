package org.apache.http.impl.conn;

import org.apache.http.conn.routing.HttpRoute;

public class SingleClientConnManager$ConnAdapter extends AbstractPooledConnAdapter {
    final /* synthetic */ SingleClientConnManager this$0;

    protected SingleClientConnManager$ConnAdapter(SingleClientConnManager singleClientConnManager, SingleClientConnManager$PoolEntry singleClientConnManager$PoolEntry, HttpRoute httpRoute) {
        this.this$0 = singleClientConnManager;
        super(singleClientConnManager, singleClientConnManager$PoolEntry);
        markReusable();
        singleClientConnManager$PoolEntry.route = httpRoute;
    }
}
