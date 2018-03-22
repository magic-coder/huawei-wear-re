package org.apache.http.impl.conn;

import java.io.IOException;

public class SingleClientConnManager$PoolEntry extends AbstractPoolEntry {
    final /* synthetic */ SingleClientConnManager this$0;

    protected SingleClientConnManager$PoolEntry(SingleClientConnManager singleClientConnManager) {
        this.this$0 = singleClientConnManager;
        super(singleClientConnManager.connOperator, null);
    }

    protected void close() throws IOException {
        shutdownEntry();
        if (this.connection.isOpen()) {
            this.connection.close();
        }
    }

    protected void shutdown() throws IOException {
        shutdownEntry();
        if (this.connection.isOpen()) {
            this.connection.shutdown();
        }
    }
}
