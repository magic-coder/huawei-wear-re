package com.p252d.p253a.p254a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.model.WeightedLatLng;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: AsyncHttpResponseHandler */
public abstract class C3550g implements C3549s {
    private String f13551a;
    private Handler f13552b;
    private boolean f13553c;
    private boolean f13554d;
    private URI f13555e;
    private Header[] f13556f;
    private Looper f13557g;
    private WeakReference<Object> f13558h;

    public abstract void m17840a(int i, Header[] headerArr, byte[] bArr);

    public abstract void m17841a(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public C3550g() {
        this(null);
    }

    public C3550g(Looper looper) {
        this.f13551a = GameManager.DEFAULT_CHARSET;
        this.f13555e = null;
        this.f13556f = null;
        this.f13557g = null;
        this.f13558h = new WeakReference(null);
        if (looper == null) {
            looper = Looper.myLooper();
        }
        this.f13557g = looper;
        mo4190a(false);
        m17858b(false);
    }

    public void mo4188a(URI uri) {
        this.f13555e = uri;
    }

    public void mo4191a(Header[] headerArr) {
        this.f13556f = headerArr;
    }

    public boolean mo4192a() {
        return this.f13553c;
    }

    public void mo4190a(boolean z) {
        if (!z && this.f13557g == null) {
            z = true;
            C3543a.f13526a.mo4211c("AsyncHttpRH", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        }
        if (!z && this.f13552b == null) {
            this.f13552b = new C3551h(this, this.f13557g);
        } else if (z && this.f13552b != null) {
            this.f13552b = null;
        }
        this.f13553c = z;
    }

    public boolean mo4196b() {
        return this.f13554d;
    }

    public void m17858b(boolean z) {
        if (z) {
            this.f13557g = null;
            this.f13552b = null;
        }
        this.f13554d = z;
    }

    public void m17842a(long j, long j2) {
        C3554l c3554l = C3543a.f13526a;
        String str = "AsyncHttpRH";
        String str2 = "Progress %d from %d (%2.0f%%)";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(j2);
        objArr[2] = Double.valueOf(j2 > 0 ? ((((double) j) * WeightedLatLng.DEFAULT_INTENSITY) / ((double) j2)) * 100.0d : -1.0d);
        c3554l.mo4207a(str, String.format(str2, objArr));
    }

    public void m17860c() {
    }

    public void m17861d() {
    }

    public void mo4187a(C3549s c3549s, HttpResponse httpResponse) {
    }

    public void mo4195b(C3549s c3549s, HttpResponse httpResponse) {
    }

    public void m17839a(int i) {
        C3543a.f13526a.mo4209b("AsyncHttpRH", String.format("Request retry no. %d", new Object[]{Integer.valueOf(i)}));
    }

    public void m17862e() {
        C3543a.f13526a.mo4209b("AsyncHttpRH", "Request got cancelled");
    }

    public void m17845a(Throwable th) {
        C3543a.f13526a.mo4210b("AsyncHttpRH", "User-space exception detected!", th);
        throw new RuntimeException(th);
    }

    public final void m17855b(long j, long j2) {
        m17856b(m17838a(4, new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
    }

    public final void m17853b(int i, Header[] headerArr, byte[] bArr) {
        m17856b(m17838a(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    public final void mo4194b(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        m17856b(m17838a(1, new Object[]{Integer.valueOf(i), headerArr, bArr, th}));
    }

    public final void mo4197f() {
        m17856b(m17838a(2, null));
    }

    public final void mo4198g() {
        m17856b(m17838a(3, null));
    }

    public final void mo4193b(int i) {
        m17856b(m17838a(5, new Object[]{Integer.valueOf(i)}));
    }

    public final void mo4199h() {
        m17856b(m17838a(6, null));
    }

    protected void m17843a(Message message) {
        try {
            Object[] objArr;
            switch (message.what) {
                case 0:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 3) {
                        C3543a.f13526a.mo4212d("AsyncHttpRH", "SUCCESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        m17840a(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                        return;
                    }
                case 1:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 4) {
                        C3543a.f13526a.mo4212d("AsyncHttpRH", "FAILURE_MESSAGE didn't got enough params");
                        return;
                    } else {
                        m17841a(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2], (Throwable) objArr[3]);
                        return;
                    }
                case 2:
                    m17860c();
                    return;
                case 3:
                    m17861d();
                    return;
                case 4:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 2) {
                        C3543a.f13526a.mo4212d("AsyncHttpRH", "PROGRESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        m17842a(((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue());
                        return;
                    }
                case 5:
                    objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length != 1) {
                        C3543a.f13526a.mo4212d("AsyncHttpRH", "RETRY_MESSAGE didn't get enough params");
                        return;
                    } else {
                        m17839a(((Integer) objArr[0]).intValue());
                        return;
                    }
                case 6:
                    m17862e();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            m17845a(th);
        }
        m17845a(th);
    }

    protected void m17856b(Message message) {
        if (mo4192a() || this.f13552b == null) {
            m17843a(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            C3564v.m17895a(this.f13552b != null, "handler should not be null!");
            this.f13552b.sendMessage(message);
        }
    }

    protected Message m17838a(int i, Object obj) {
        return Message.obtain(this.f13552b, i, obj);
    }

    public void mo4189a(HttpResponse httpResponse) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] a = m17851a(httpResponse.getEntity());
            if (!Thread.currentThread().isInterrupted()) {
                if (statusLine.getStatusCode() >= 300) {
                    mo4194b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), a, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                } else {
                    m17853b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), a);
                }
            }
        }
    }

    byte[] m17851a(HttpEntity httpEntity) throws IOException {
        int i = 4096;
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                long contentLength = httpEntity.getContentLength();
                if (contentLength > 2147483647L) {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
                if (contentLength > 0) {
                    i = (int) contentLength;
                }
                try {
                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
                    byte[] bArr = new byte[4096];
                    long j = 0;
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        long j2 = ((long) read) + j;
                        byteArrayBuffer.append(bArr, 0, read);
                        if (contentLength <= 0) {
                            j = 1;
                        } else {
                            j = contentLength;
                        }
                        m17855b(j2, j);
                        j = j2;
                    }
                    C3543a.m17802a(content);
                    C3543a.m17803a(httpEntity);
                    return byteArrayBuffer.toByteArray();
                } catch (OutOfMemoryError e) {
                    System.gc();
                    throw new IOException("File too large to fit into available memory");
                } catch (Throwable th) {
                    C3543a.m17802a(content);
                    C3543a.m17803a(httpEntity);
                }
            }
        }
        return null;
    }
}
