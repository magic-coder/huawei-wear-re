package org.apache.http.conn.params;

import org.apache.http.conn.routing.HttpRoute;

class ConnManagerParams$1 implements ConnPerRoute {
    ConnManagerParams$1() {
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return 2;
    }
}
