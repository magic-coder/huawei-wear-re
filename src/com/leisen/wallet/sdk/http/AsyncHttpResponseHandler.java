package com.leisen.wallet.sdk.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.nfc.carrera.util.LogX;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CAHRSET = "UTF_8";
    protected static final int FALIURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String TAG = "AsyncHttpResponseHandler";
    private Handler handler;
    private Header[] requestHeaders = null;
    private URI requestURI = null;
    private String responseCharset = DEFAULT_CAHRSET;
    private boolean useSynchronousMode;

    class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        public ResponderHandler(AsyncHttpResponseHandler asyncHttpResponseHandler) {
            this.mResponder = asyncHttpResponseHandler;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.mResponder.handleMessage(message);
        }
    }

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    public AsyncHttpResponseHandler() {
        setUseSynchronousMode(true);
    }

    public URI getRequestURI() {
        return this.requestURI;
    }

    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }

    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    public void setRequestHeaders(Header[] headerArr) {
        this.requestHeaders = headerArr;
    }

    public void setUseSynchronousMode(boolean z) {
        if (!z && Looper.myLooper() == null) {
            z = true;
        }
        if (!z && this.handler == null) {
            this.handler = new ResponderHandler(this);
        } else if (z && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    public void setCharset(String str) {
        this.responseCharset = str;
    }

    public String getCharset() {
        return this.responseCharset == null ? DEFAULT_CAHRSET : this.responseCharset;
    }

    public void sendResponseMessage(HttpResponse httpResponse) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] responseData = getResponseData(httpResponse.getEntity());
            if (!Thread.currentThread().isInterrupted()) {
                if (responseData != null) {
                    LogX.d("AysncHttpClient", "==>" + statusLine.getStatusCode() + "==" + new String(responseData, "utf-8"));
                }
                if (statusLine.getStatusCode() > 300) {
                    sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                } else {
                    sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData);
                }
            }
        }
    }

    public void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    public void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    public void sendProgressMessage(int i, int i2) {
        sendMessage(obtainMessage(4, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public void sendCancelMessage() {
        sendMessage(obtainMessage(6, null));
    }

    public void sendSuccessMessage(int i, Header[] headerArr, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    public void sendFailureMessage(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i), headerArr, bArr, th}));
    }

    public void sendRetryMessage(int i) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(i)}));
    }

    private void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.handler.sendMessage(message);
        }
    }

    protected void handleMessage(Message message) {
        LogX.d(TAG, "message : " + message.what);
        Object[] objArr;
        switch (message.what) {
            case 0:
                objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 3) {
                    LogX.e(TAG, "SUCCESS_MESSAGE didn't got enough params");
                    return;
                } else {
                    onSuccess(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                    return;
                }
            case 1:
                objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 4) {
                    LogX.e(TAG, "FAILURE_MESSAGE didn't got enough params");
                    return;
                } else {
                    onFailure(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2], (Throwable) objArr[3]);
                    return;
                }
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            case 4:
                objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 2) {
                    LogX.e(TAG, "PROGRESS_MESSAGE didn't got enough params");
                    return;
                } else {
                    onProgress(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    return;
                }
            case 6:
                onCancel();
                return;
            default:
                return;
        }
    }

    private Message obtainMessage(int i, Object obj) {
        if (this.handler != null) {
            return Message.obtain(this.handler, i, obj);
        }
        Message obtain = Message.obtain();
        if (obtain == null) {
            return obtain;
        }
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    private byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        int i = 4096;
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                long contentLength = httpEntity.getContentLength();
                if (contentLength > 2147483647L) {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
                if (contentLength >= 0) {
                    i = (int) contentLength;
                }
                try {
                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
                    byte[] bArr = new byte[4096];
                    i = 0;
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        int i2 = i + read;
                        byteArrayBuffer.append(bArr, 0, read);
                        sendProgressMessage(i2, (int) (contentLength <= 0 ? 1 : contentLength));
                        i = i2;
                    }
                    AsyncHttpClient.silentCloseInputStream(content);
                    return byteArrayBuffer.toByteArray();
                } catch (OutOfMemoryError e) {
                    throw new IOException("File too large to fit into available memory");
                } catch (Throwable th) {
                    AsyncHttpClient.silentCloseInputStream(content);
                }
            }
        }
        return null;
    }

    public void onProgress(int i, int i2) {
    }

    public void onStart() {
    }

    public void onFinish() {
    }

    public void onCancel() {
    }
}
