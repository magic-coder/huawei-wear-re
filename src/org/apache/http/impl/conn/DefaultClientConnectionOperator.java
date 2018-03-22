package org.apache.http.impl.conn;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@ThreadSafe
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    protected final DnsResolver dnsResolver;
    private final Log log = LogFactory.getLog(getClass());
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry) {
        if (schemeRegistry == null) {
            throw new IllegalArgumentException("Scheme registry amy not be null");
        }
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = new SystemDefaultDnsResolver();
    }

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        if (schemeRegistry == null) {
            throw new IllegalArgumentException("Scheme registry may not be null");
        } else if (dnsResolver == null) {
            throw new IllegalArgumentException("DNS resolver may not be null");
        } else {
            this.schemeRegistry = schemeRegistry;
            this.dnsResolver = dnsResolver;
        }
    }

    public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openConnection(org.apache.http.conn.OperatedClientConnection r14, org.apache.http.HttpHost r15, java.net.InetAddress r16, org.apache.http.protocol.HttpContext r17, org.apache.http.params.HttpParams r18) throws java.io.IOException {
        /*
        r13 = this;
        if (r14 != 0) goto L_0x000a;
    L_0x0002:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Connection may not be null";
        r2.<init>(r3);
        throw r2;
    L_0x000a:
        if (r15 != 0) goto L_0x0014;
    L_0x000c:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Target host may not be null";
        r2.<init>(r3);
        throw r2;
    L_0x0014:
        if (r18 != 0) goto L_0x001e;
    L_0x0016:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Parameters may not be null";
        r2.<init>(r3);
        throw r2;
    L_0x001e:
        r2 = r14.isOpen();
        if (r2 == 0) goto L_0x002c;
    L_0x0024:
        r2 = new java.lang.IllegalStateException;
        r3 = "Connection must not be open";
        r2.<init>(r3);
        throw r2;
    L_0x002c:
        r2 = r13.schemeRegistry;
        r3 = r15.getSchemeName();
        r2 = r2.getScheme(r3);
        r6 = r2.getSchemeSocketFactory();
        r3 = r15.getHostName();
        r7 = r13.resolveHostname(r3);
        r3 = r15.getPort();
        r8 = r2.resolvePort(r3);
        r2 = 0;
    L_0x004b:
        r3 = r7.length;
        if (r2 >= r3) goto L_0x00aa;
    L_0x004e:
        r4 = r7[r2];
        r3 = r7.length;
        r3 = r3 + -1;
        if (r2 != r3) goto L_0x00ab;
    L_0x0055:
        r3 = 1;
    L_0x0056:
        r0 = r18;
        r5 = r6.createSocket(r0);
        r14.opening(r5, r15);
        r9 = new org.apache.http.conn.HttpInetSocketAddress;
        r9.<init>(r15, r4, r8);
        r4 = 0;
        if (r16 == 0) goto L_0x006f;
    L_0x0067:
        r4 = new java.net.InetSocketAddress;
        r10 = 0;
        r0 = r16;
        r4.<init>(r0, r10);
    L_0x006f:
        r10 = r13.log;
        r10 = r10.isDebugEnabled();
        if (r10 == 0) goto L_0x008f;
    L_0x0077:
        r10 = r13.log;
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "Connecting to ";
        r11 = r11.append(r12);
        r11 = r11.append(r9);
        r11 = r11.toString();
        r10.debug(r11);
    L_0x008f:
        r0 = r18;
        r4 = r6.connectSocket(r5, r9, r4, r0);	 Catch:{ ConnectException -> 0x00ad, ConnectTimeoutException -> 0x00b6 }
        if (r5 == r4) goto L_0x00ea;
    L_0x0097:
        r14.opening(r4, r15);	 Catch:{ ConnectException -> 0x00ad, ConnectTimeoutException -> 0x00b6 }
    L_0x009a:
        r0 = r17;
        r1 = r18;
        r13.prepareSocket(r4, r0, r1);	 Catch:{ ConnectException -> 0x00ad, ConnectTimeoutException -> 0x00b6 }
        r4 = r6.isSecure(r4);	 Catch:{ ConnectException -> 0x00ad, ConnectTimeoutException -> 0x00b6 }
        r0 = r18;
        r14.openCompleted(r4, r0);	 Catch:{ ConnectException -> 0x00ad, ConnectTimeoutException -> 0x00b6 }
    L_0x00aa:
        return;
    L_0x00ab:
        r3 = 0;
        goto L_0x0056;
    L_0x00ad:
        r4 = move-exception;
        if (r3 == 0) goto L_0x00ba;
    L_0x00b0:
        r2 = new org.apache.http.conn.HttpHostConnectException;
        r2.<init>(r15, r4);
        throw r2;
    L_0x00b6:
        r4 = move-exception;
        if (r3 == 0) goto L_0x00ba;
    L_0x00b9:
        throw r4;
    L_0x00ba:
        r3 = r13.log;
        r3 = r3.isDebugEnabled();
        if (r3 == 0) goto L_0x00e6;
    L_0x00c2:
        r3 = r13.log;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Connect to ";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r5 = " timed out. ";
        r4 = r4.append(r5);
        r5 = "Connection will be retried using another IP address";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.debug(r4);
    L_0x00e6:
        r2 = r2 + 1;
        goto L_0x004b;
    L_0x00ea:
        r4 = r5;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.DefaultClientConnectionOperator.openConnection(org.apache.http.conn.OperatedClientConnection, org.apache.http.HttpHost, java.net.InetAddress, org.apache.http.protocol.HttpContext, org.apache.http.params.HttpParams):void");
    }

    public void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams) throws IOException {
        if (operatedClientConnection == null) {
            throw new IllegalArgumentException("Connection may not be null");
        } else if (httpHost == null) {
            throw new IllegalArgumentException("Target host may not be null");
        } else if (httpParams == null) {
            throw new IllegalArgumentException("Parameters may not be null");
        } else if (operatedClientConnection.isOpen()) {
            Scheme scheme = this.schemeRegistry.getScheme(httpHost.getSchemeName());
            if (scheme.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory) {
                SchemeLayeredSocketFactory schemeLayeredSocketFactory = (SchemeLayeredSocketFactory) scheme.getSchemeSocketFactory();
                try {
                    Socket createLayeredSocket = schemeLayeredSocketFactory.createLayeredSocket(operatedClientConnection.getSocket(), httpHost.getHostName(), httpHost.getPort(), httpParams);
                    prepareSocket(createLayeredSocket, httpContext, httpParams);
                    operatedClientConnection.update(createLayeredSocket, httpHost, schemeLayeredSocketFactory.isSecure(createLayeredSocket), httpParams);
                    return;
                } catch (ConnectException e) {
                    throw new HttpHostConnectException(httpHost, e);
                }
            }
            throw new IllegalArgumentException("Target scheme (" + scheme.getName() + ") must have layered socket factory.");
        } else {
            throw new IllegalStateException("Connection must be open");
        }
    }

    protected void prepareSocket(Socket socket, HttpContext httpContext, HttpParams httpParams) throws IOException {
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpParams));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
        int linger = HttpConnectionParams.getLinger(httpParams);
        if (linger >= 0) {
            socket.setSoLinger(linger > 0, linger);
        }
    }

    protected InetAddress[] resolveHostname(String str) throws UnknownHostException {
        return this.dnsResolver.resolve(str);
    }
}
