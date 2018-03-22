package org.apache.http.client.methods;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

@NotThreadSafe
public abstract class HttpRequestBase extends AbstractHttpMessage implements Cloneable, AbortableHttpRequest, HttpUriRequest {
    private Lock abortLock = new ReentrantLock();
    private volatile boolean aborted;
    private ClientConnectionRequest connRequest;
    private ConnectionReleaseTrigger releaseTrigger;
    private URI uri;

    public abstract String getMethod();

    public ProtocolVersion getProtocolVersion() {
        return HttpProtocolParams.getVersion(getParams());
    }

    public URI getURI() {
        return this.uri;
    }

    public RequestLine getRequestLine() {
        String method = getMethod();
        ProtocolVersion protocolVersion = getProtocolVersion();
        URI uri = getURI();
        String str = null;
        if (uri != null) {
            str = uri.toASCIIString();
        }
        if (str == null || str.length() == 0) {
            str = "/";
        }
        return new BasicRequestLine(method, str, protocolVersion);
    }

    public void setURI(URI uri) {
        this.uri = uri;
    }

    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest) throws IOException {
        if (this.aborted) {
            throw new IOException("Request already aborted");
        }
        this.abortLock.lock();
        try {
            this.connRequest = clientConnectionRequest;
        } finally {
            this.abortLock.unlock();
        }
    }

    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger) throws IOException {
        if (this.aborted) {
            throw new IOException("Request already aborted");
        }
        this.abortLock.lock();
        try {
            this.releaseTrigger = connectionReleaseTrigger;
        } finally {
            this.abortLock.unlock();
        }
    }

    private void cleanup() {
        if (this.connRequest != null) {
            this.connRequest.abortRequest();
            this.connRequest = null;
        }
        if (this.releaseTrigger != null) {
            try {
                this.releaseTrigger.abortConnection();
            } catch (IOException e) {
            }
            this.releaseTrigger = null;
        }
    }

    public void abort() {
        if (!this.aborted) {
            this.abortLock.lock();
            try {
                this.aborted = true;
                cleanup();
            } finally {
                this.abortLock.unlock();
            }
        }
    }

    public boolean isAborted() {
        return this.aborted;
    }

    public void reset() {
        this.abortLock.lock();
        try {
            cleanup();
            this.aborted = false;
        } finally {
            this.abortLock.unlock();
        }
    }

    public void releaseConnection() {
        reset();
    }

    public Object clone() throws CloneNotSupportedException {
        HttpRequestBase httpRequestBase = (HttpRequestBase) super.clone();
        httpRequestBase.abortLock = new ReentrantLock();
        httpRequestBase.aborted = false;
        httpRequestBase.releaseTrigger = null;
        httpRequestBase.connRequest = null;
        httpRequestBase.headergroup = (HeaderGroup) CloneUtils.clone(this.headergroup);
        httpRequestBase.params = (HttpParams) CloneUtils.clone(this.params);
        return httpRequestBase;
    }

    public String toString() {
        return getMethod() + HwAccountConstants.BLANK + getURI() + HwAccountConstants.BLANK + getProtocolVersion();
    }
}
