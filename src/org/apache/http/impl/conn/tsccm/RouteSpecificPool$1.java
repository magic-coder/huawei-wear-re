package org.apache.http.impl.conn.tsccm;

import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

class RouteSpecificPool$1 implements ConnPerRoute {
    final /* synthetic */ RouteSpecificPool this$0;

    RouteSpecificPool$1(RouteSpecificPool routeSpecificPool) {
        this.this$0 = routeSpecificPool;
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return this.this$0.maxEntries;
    }
}
