package com.huawei.android.pushagent.p020b.p021a.p327b;

import android.content.Context;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.p026a.C4100f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.SecureRandom;

public class C4079a implements C4078b {
    private static byte[] f15443b;
    private static byte[] f15444c;
    protected Socket f15445a;
    private Context f15446d;
    private boolean f15447e = false;

    class C4077a extends InputStream {
        final /* synthetic */ C4079a f15439a;
        private InputStream f15440b;
        private byte[] f15441c = null;
        private int f15442d = 0;

        public C4077a(C4079a c4079a, InputStream inputStream) {
            this.f15439a = c4079a;
            this.f15440b = inputStream;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
            r4 = this;
            r0 = -1;
            r1 = r4.f15439a;
            monitor-enter(r1);
            r2 = r4.f15439a;	 Catch:{ all -> 0x0034 }
            r2 = r2.f15447e;	 Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x0016;
        L_0x000c:
            r2 = "PushLogAC2712";
            r3 = "secure socket is not initialized, can not read any data";
            com.huawei.android.pushagent.c.a.e.c(r2, r3);	 Catch:{ all -> 0x0034 }
            monitor-exit(r1);	 Catch:{ all -> 0x0034 }
        L_0x0015:
            return r0;
        L_0x0016:
            monitor-exit(r1);	 Catch:{ all -> 0x0034 }
            r1 = r4.f15441c;
            if (r1 == 0) goto L_0x003e;
        L_0x001b:
            r1 = r4.f15441c;
            r1 = r1.length;
            if (r1 <= 0) goto L_0x003e;
        L_0x0020:
            r1 = r4.f15442d;
            r2 = r4.f15441c;
            r2 = r2.length;
            if (r1 >= r2) goto L_0x0037;
        L_0x0027:
            r0 = r4.f15441c;
            r1 = r4.f15442d;
            r2 = r1 + 1;
            r4.f15442d = r2;
            r0 = r0[r1];
            r0 = r0 & 255;
            goto L_0x0015;
        L_0x0034:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0034 }
            throw r0;
        L_0x0037:
            r1 = "PushLogAC2712";
            r2 = "bufferByte has read end , need read bytes from socket";
            com.huawei.android.pushagent.c.a.e.a(r1, r2);
        L_0x003e:
            r1 = 0;
            r4.f15441c = r1;
            r1 = 0;
            r4.f15442d = r1;
            r1 = r4.f15440b;
            if (r1 == 0) goto L_0x0092;
        L_0x0048:
            r1 = r4.f15440b;
            r1 = r1.read();
            if (r0 != r1) goto L_0x0058;
        L_0x0050:
            r1 = "PushLogAC2712";
            r2 = "read -1 from inputstream";
            com.huawei.android.pushagent.c.a.e.c(r1, r2);
            goto L_0x0015;
        L_0x0058:
            r2 = 48;
            if (r2 != r1) goto L_0x008a;
        L_0x005c:
            r1 = r4.f15440b;
            r1 = com.huawei.android.pushagent.p020b.p021a.p327b.C4079a.m20011c(r1);
            r2 = com.huawei.android.pushagent.p020b.p021a.p327b.C4079a.f15444c;
            r1 = com.huawei.android.pushagent.p018c.p019a.p026a.C4100f.m20117b(r1, r2);
            r4.f15441c = r1;
            r1 = r4.f15441c;
            if (r1 == 0) goto L_0x0075;
        L_0x0070:
            r1 = r4.f15441c;
            r1 = r1.length;
            if (r1 != 0) goto L_0x007d;
        L_0x0075:
            r1 = "PushLogAC2712";
            r2 = "ase decrypt serverkey error";
            com.huawei.android.pushagent.c.a.e.c(r1, r2);
            goto L_0x0015;
        L_0x007d:
            r0 = r4.f15441c;
            r1 = r4.f15442d;
            r2 = r1 + 1;
            r4.f15442d = r2;
            r0 = r0[r1];
            r0 = r0 & 255;
            goto L_0x0015;
        L_0x008a:
            r1 = "PushLogAC2712";
            r2 = "read secure message error, return -1";
            com.huawei.android.pushagent.c.a.e.c(r1, r2);
            goto L_0x0015;
        L_0x0092:
            r1 = "PushLogAC2712";
            r2 = "secureInputStream is null, return -1";
            com.huawei.android.pushagent.c.a.e.c(r1, r2);
            goto L_0x0015;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.b.a.a.read():int");
        }
    }

    public C4079a(Context context) {
        this.f15446d = context;
    }

    public static void m20004a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (-1 == read) {
                throw new IOException("read -1 reached");
            }
            i += read;
        }
    }

    private byte[] m20006a(Context context) throws IOException {
        byte T = (byte) a.a(context).T();
        String U = a.a(context).U();
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        e.a("PushLogAC2712", "ready to send SecureChannelReqMessage, save clientKey for decode serverKey");
        C4079a.m20007b(bArr);
        byte[] a = C4100f.m20114a(bArr, U);
        if (a == null) {
            e.c("PushLogAC2712", "rsa encrypr clientKey error");
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(20);
        byteArrayOutputStream.write(com.huawei.android.pushagent.c.a.b(((a.length + 1) + 1) + 2));
        byteArrayOutputStream.write(T);
        byteArrayOutputStream.write(a);
        return byteArrayOutputStream.toByteArray();
    }

    public static synchronized void m20007b(byte[] bArr) {
        synchronized (C4079a.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    f15443b = new byte[bArr.length];
                    System.arraycopy(bArr, 0, f15443b, 0, bArr.length);
                }
            }
            e.a("PushLogAC2712", "key is null");
        }
    }

    private boolean m20008b(Socket socket) {
        if (socket == null) {
            e.c("PushLogAC2712", "socket is null");
            return false;
        } else if (socket.isConnected()) {
            return true;
        } else {
            e.c("PushLogAC2712", "when init Channel, socket is not ready");
            return false;
        }
    }

    public static synchronized void m20010c(byte[] bArr) {
        synchronized (C4079a.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    f15444c = new byte[bArr.length];
                    System.arraycopy(bArr, 0, f15444c, 0, bArr.length);
                }
            }
            e.a("PushLogAC2712", "key is null");
        }
    }

    private static byte[] m20011c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[2];
        C4079a.m20004a(inputStream, bArr);
        bArr = new byte[(com.huawei.android.pushagent.c.a.c(bArr) - 3)];
        C4079a.m20004a(inputStream, bArr);
        return bArr;
    }

    private static byte[] m20012d(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(48);
        byte[] a = C4100f.m20115a(bArr, f15444c);
        if (a == null || a.length == 0) {
            e.a("PushLogAC2712", "aes encrypt pushMsgData error");
            return new byte[0];
        }
        byteArrayOutputStream.write(com.huawei.android.pushagent.c.a.b((a.length + 1) + 2));
        byteArrayOutputStream.write(a);
        return byteArrayOutputStream.toByteArray();
    }

    private static synchronized byte[] m20014f() {
        byte[] bArr;
        synchronized (C4079a.class) {
            bArr = f15443b;
        }
        return bArr;
    }

    public synchronized void mo4369a() {
        e.a("PushLogAC2712", "enter pushChannel:close()");
        this.f15447e = false;
        try {
            if (this.f15445a == null) {
                e.c("PushLogAC2712", "socket is null, not need close");
                this.f15445a = null;
            } else {
                if (this.f15445a.isClosed()) {
                    e.c("PushLogAC2712", "socket has been closed");
                } else {
                    this.f15445a.close();
                }
                this.f15445a = null;
            }
        } catch (Throwable e) {
            e.c("PushLogAC2712", "close socket error: " + e.toString(), e);
            this.f15445a = null;
        } catch (Throwable th) {
            this.f15445a = null;
        }
    }

    public synchronized boolean mo4370a(Socket socket) {
        boolean z = false;
        synchronized (this) {
            if (m20008b(socket)) {
                this.f15445a = socket;
                try {
                    byte[] a = m20006a(this.f15446d);
                    OutputStream outputStream = this.f15445a.getOutputStream();
                    if (outputStream == null) {
                        e.c("PushLogAC2712", "outputStream is null");
                    } else if (a.length == 0) {
                        e.c("PushLogAC2712", "data is null");
                    } else {
                        outputStream.write(a);
                        outputStream.flush();
                        InputStream inputStream = this.f15445a.getInputStream();
                        if (m20008b(socket)) {
                            int read = inputStream.read();
                            if (-1 == read) {
                                e.a("PushLogAC2712", " read -1 when init secure channel, socket maybe closed");
                            } else if (21 == read) {
                                a = m20018a(inputStream);
                                if (a != null) {
                                    C4079a.m20010c(C4100f.m20117b(a, C4079a.m20014f()));
                                    this.f15447e = true;
                                    z = true;
                                } else {
                                    e.a("PushLogAC2712", "get server key error");
                                }
                            } else {
                                e.a("PushLogAC2712", "cmdId is not CMD_SECUREKEYEXCHANGE_RSP");
                            }
                        }
                    }
                } catch (Throwable e) {
                    e.c("PushLogAC2712", "call send cause:" + e.toString(), e);
                }
                mo4369a();
            } else {
                mo4369a();
            }
        }
        return z;
    }

    public synchronized boolean mo4371a(byte[] bArr) throws Exception {
        boolean z = false;
        synchronized (this) {
            if (this.f15445a == null) {
                e.c("PushLogAC2712", "socket is null");
            } else if (this.f15447e) {
                try {
                    byte[] d = C4079a.m20012d(bArr);
                    OutputStream outputStream = this.f15445a.getOutputStream();
                    if (outputStream == null) {
                        e.c("PushLogAC2712", "outputStream is null");
                    } else if (d.length == 0) {
                        e.c("PushLogAC2712", "data is null");
                    } else {
                        outputStream.write(d);
                        outputStream.flush();
                        z = true;
                    }
                } catch (Throwable e) {
                    e.c("PushLogAC2712", "call send cause:" + e.toString(), e);
                    mo4369a();
                }
            } else {
                e.c("PushLogAC2712", "secure socket is not initialized, can not write any data");
                mo4369a();
            }
        }
        return z;
    }

    public byte[] m20018a(InputStream inputStream) throws Exception {
        C4079a.m20004a(inputStream, new byte[2]);
        byte[] bArr = new byte[1];
        C4079a.m20004a(inputStream, bArr);
        byte b = bArr[0];
        e.a("PushLogAC2712", "result is " + b);
        if (b == (byte) 0) {
            bArr = new byte[32];
            C4079a.m20004a(inputStream, bArr);
            return bArr;
        }
        e.c("PushLogAC2712", "secure key exchange error");
        return null;
    }

    public boolean mo4372b() {
        if (this.f15445a != null) {
            return this.f15445a.isConnected();
        }
        e.c("PushLogAC2712", "socket is null");
        return false;
    }

    public Socket mo4373c() {
        return this.f15445a;
    }

    public InputStream mo4374d() {
        try {
            if (this.f15445a != null) {
                return new C4077a(this, this.f15445a.getInputStream());
            }
            e.c("PushLogAC2712", "socket is null");
            return null;
        } catch (Throwable e) {
            e.c("PushLogAC2712", "call socket.getInputStream cause:" + e.toString(), e);
        }
    }
}
