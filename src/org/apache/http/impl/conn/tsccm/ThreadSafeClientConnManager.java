package org.apache.http.impl.conn.tsccm;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

@Deprecated
@ThreadSafe
public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    protected final AbstractConnPool connectionPool;
    private final Log log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1, TimeUnit.MILLISECONDS);
    }

    public ThreadSafeClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit) {
        this(schemeRegistry, j, timeUnit, new ConnPerRouteBean());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit, ConnPerRouteBean connPerRouteBean) {
        if (schemeRegistry == null) {
            throw new IllegalArgumentException("Scheme registry may not be null");
        }
        this.log = LogFactory.getLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = connPerRouteBean;
        this.connOperator = createConnectionOperator(schemeRegistry);
        this.pool = createConnectionPool(j, timeUnit);
        this.connectionPool = this.pool;
    }

    public ThreadSafeClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        if (schemeRegistry == null) {
            throw new IllegalArgumentException("Scheme registry may not be null");
        }
        this.log = LogFactory.getLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = new ConnPerRouteBean();
        this.connOperator = createConnectionOperator(schemeRegistry);
        this.pool = (ConnPoolByRoute) createConnectionPool(httpParams);
        this.connectionPool = this.pool;
    }

    protected void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    protected AbstractConnPool createConnectionPool(HttpParams httpParams) {
        return new ConnPoolByRoute(this.connOperator, httpParams);
    }

    protected ConnPoolByRoute createConnectionPool(long j, TimeUnit timeUnit) {
        return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, j, timeUnit);
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry);
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        return new 1(this, this.pool.requestPoolEntry(httpRoute, obj), httpRoute);
    }

    public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
        boolean isMarkedReusable;
        if (managedClientConnection instanceof BasicPooledConnAdapter) {
            BasicPooledConnAdapter basicPooledConnAdapter = (BasicPooledConnAdapter) managedClientConnection;
            if (basicPooledConnAdapter.getPoolEntry() == null || basicPooledConnAdapter.getManager() == this) {
                synchronized (basicPooledConnAdapter) {
                    BasicPoolEntry basicPoolEntry = (BasicPoolEntry) basicPooledConnAdapter.getPoolEntry();
                    if (basicPoolEntry == null) {
                        return;
                    }
                    try {
                        if (basicPooledConnAdapter.isOpen() && !basicPooledConnAdapter.isMarkedReusable()) {
                            basicPooledConnAdapter.shutdown();
                        }
                        isMarkedReusable = basicPooledConnAdapter.isMarkedReusable();
                        if (this.log.isDebugEnabled()) {
                            if (isMarkedReusable) {
                                this.log.debug("Released connection is reusable.");
                            } else {
                                this.log.debug("Released connection is not reusable.");
                            }
                        }
                        basicPooledConnAdapter.detach();
                        this.pool.freeEntry(basicPoolEntry, isMarkedReusable, j, timeUnit);
                    } catch (Throwable e) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Exception shutting down released connection.", e);
                        }
                        isMarkedReusable = basicPooledConnAdapter.isMarkedReusable();
                        if (this.log.isDebugEnabled()) {
                            if (isMarkedReusable) {
                                this.log.debug("Released connection is reusable.");
                            } else {
                                this.log.debug("Released connection is not reusable.");
                            }
                        }
                        basicPooledConnAdapter.detach();
                        this.pool.freeEntry(basicPoolEntry, isMarkedReusable, j, timeUnit);
                        return;
                    } catch (Throwable th) {
                        isMarkedReusable = basicPooledConnAdapter.isMarkedReusable();
                        if (this.log.isDebugEnabled()) {
                            if (isMarkedReusable) {
                                this.log.debug("Released connection is reusable.");
                            } else {
                                this.log.debug("Released connection is not reusable.");
                            }
                        }
                        basicPooledConnAdapter.detach();
                        this.pool.freeEntry(basicPoolEntry, isMarkedReusable, j, timeUnit);
                    }
                }
            } else {
                throw new IllegalArgumentException("Connection not obtained from this manager.");
            }
        }
        throw new IllegalArgumentException("Connection class mismatch, connection not obtained from this manager.");
    }

    public void shutdown() {
        this.log.debug("Shutting down");
        this.pool.shutdown();
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        return this.pool.getConnectionsInPool(httpRoute);
    }

    public int getConnectionsInPool() {
        return this.pool.getConnectionsInPool();
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j + HwAccountConstants.BLANK + timeUnit);
        }
        this.pool.closeIdleConnections(j, timeUnit);
    }

    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpiredConnections();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotalConnections();
    }

    public void setMaxTotal(int i) {
        this.pool.setMaxTotalConnections(i);
    }

    public int getDefaultMaxPerRoute() {
        return this.connPerRoute.getDefaultMaxPerRoute();
    }

    public void setDefaultMaxPerRoute(int i) {
        this.connPerRoute.setDefaultMaxPerRoute(i);
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return this.connPerRoute.getMaxForRoute(httpRoute);
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i) {
        this.connPerRoute.setMaxForRoute(httpRoute, i);
    }
}
