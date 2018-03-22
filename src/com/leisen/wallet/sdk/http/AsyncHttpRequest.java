package com.leisen.wallet.sdk.http;

import android.util.Log;
import com.huawei.p190v.C2538c;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest implements Runnable {
    private static final String TAG = "AsyncHttpRequest";
    private boolean cancelIsNotified = false;
    private int executionCount;
    private final AbstractHttpClient httpClient;
    private final HttpContext httpContext;
    private final HttpUriRequest httpUriRequest;
    private boolean isCancelled = false;
    private boolean isFinished = false;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        this.httpClient = abstractHttpClient;
        this.httpContext = httpContext;
        this.httpUriRequest = httpUriRequest;
        this.responseHandler = responseHandlerInterface;
    }

    public void run() {
        if (!isCancelled()) {
            if (this.responseHandler != null) {
                this.responseHandler.sendStartMessage();
            }
            if (!isCancelled()) {
                try {
                    makeRequestWithRetries();
                } catch (Throwable e) {
                    if (isCancelled() || this.responseHandler == null) {
                        Log.e(TAG, "makeRequestWithRetries returned error, but handler is null");
                    } else {
                        Log.e(TAG, "!isCancelled() && responseHandler != null");
                        this.responseHandler.sendFailureMessage(0, null, null, e);
                    }
                }
                if (!isCancelled()) {
                    if (this.responseHandler != null) {
                        this.responseHandler.sendFinishMessage();
                    }
                    this.isFinished = true;
                }
            }
        }
    }

    private void makeRequestWithRetries() throws IOException {
        IOException iOException = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.httpClient.getHttpRequestRetryHandler();
        boolean z = true;
        while (z) {
            try {
                makeRequest();
                return;
            } catch (UnknownHostException e) {
                try {
                    boolean z2;
                    IOException iOException2;
                    IOException iOException3 = new IOException("UnknownHostException exception:" + e.getMessage());
                    if (this.executionCount > 0) {
                        int i = this.executionCount + 1;
                        this.executionCount = i;
                        if (httpRequestRetryHandler.retryRequest(iOException3, i, this.httpContext)) {
                            z2 = true;
                            iOException2 = iOException3;
                            z = z2;
                            iOException = iOException2;
                            if (z && this.responseHandler != null) {
                                this.responseHandler.sendRetryMessage(this.executionCount);
                            }
                        }
                    }
                    z2 = false;
                    iOException2 = iOException3;
                    z = z2;
                    iOException = iOException2;
                    this.responseHandler.sendRetryMessage(this.executionCount);
                } catch (Throwable e2) {
                    Throwable th = e2;
                    Log.e(TAG, "Unhandled exception origin cause", th);
                    iOException = new IOException("Unhandled exception: " + th.getMessage());
                }
            } catch (IOException e3) {
                iOException = e3;
                if (!isCancelled()) {
                    int i2 = this.executionCount + 1;
                    this.executionCount = i2;
                    z = httpRequestRetryHandler.retryRequest(iOException, i2, this.httpContext);
                    this.responseHandler.sendRetryMessage(this.executionCount);
                } else {
                    return;
                }
            }
        }
        throw iOException;
    }

    private void makeRequest() throws IOException {
        if (!isCancelled()) {
            if (this.httpUriRequest.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            C2538c.e("AysncHttpClient", new Object[]{"==>get response before"});
            C2538c.e("AysncHttpClient", new Object[]{"==>get response after" + this.httpClient.execute(this.httpUriRequest).getStatusLine().getStatusCode()});
            if (!isCancelled() && this.responseHandler != null) {
                this.responseHandler.sendResponseMessage(r0);
            }
        }
    }

    public boolean isCancelled() {
        if (this.isCancelled) {
            sendCancelNotification();
        }
        return this.isCancelled;
    }

    private synchronized void sendCancelNotification() {
        if (!(this.isFinished || !this.isCancelled || this.cancelIsNotified)) {
            this.cancelIsNotified = true;
            if (this.responseHandler != null) {
                this.responseHandler.sendCancelMessage();
            }
        }
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    public boolean cancel(boolean z) {
        this.isCancelled = true;
        this.httpUriRequest.abort();
        return isCancelled();
    }
}
