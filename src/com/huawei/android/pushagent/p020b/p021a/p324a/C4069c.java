package com.huawei.android.pushagent.p020b.p021a.p324a;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.C4060c;
import com.huawei.android.pushagent.p017a.C4060c.C4059a;
import com.huawei.android.pushagent.p017a.C4061d;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p018c.p027c.C4115e;
import com.huawei.android.pushagent.p020b.p021a.p324a.p326b.C4074c;
import com.huawei.android.pushagent.p020b.p021a.p327b.C4079a;
import com.huawei.android.pushagent.p020b.p021a.p327b.C4081c;
import com.huawei.android.pushagent.p020b.p021a.p327b.C4082d;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class C4069c extends Thread {
    protected C4061d f15420a = null;
    protected Context f15421b = null;
    protected C4065a f15422c = null;

    public enum C4076a {
        SocketEvent_CONNECTING,
        SocketEvent_CONNECTED,
        SocketEvent_CLOSE,
        SocketEvent_MSG_RECEIVED
    }

    public C4069c(C4065a c4065a) {
        super("SocketRead_" + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date()));
        this.f15422c = c4065a;
        this.f15421b = c4065a.f15411d;
        this.f15420a = c4065a.f15408a;
    }

    protected Socket m19975a(String str, int i, boolean z) throws Exception {
        Throwable e;
        Socket socket;
        try {
            socket = new Socket();
            try {
                String property;
                String str2;
                int parseInt;
                socket.getTcpNoDelay();
                if (this instanceof C4074c) {
                    if (C4115e.m20148c()) {
                        C4115e.m20143a(1, a.a(socket));
                    } else {
                        a.a(1, a.a(socket));
                    }
                }
                if (VERSION.SDK_INT >= 11) {
                    String property2 = System.getProperty("http.proxyHost");
                    property = System.getProperty("http.proxyPort");
                    if (property == null) {
                        property = "-1";
                    }
                    str2 = property2;
                    parseInt = Integer.parseInt(property);
                } else {
                    str2 = Proxy.getHost(this.f15421b);
                    parseInt = Proxy.getPort(this.f15421b);
                }
                int a = C4103b.m20122a(this.f15421b);
                m19976a(C4076a.SocketEvent_CONNECTING, new Bundle());
                e.a("PushLogAC2712", "enter createSocket(" + str + ":" + i + ", proxy:" + z + "(" + str2 + ":" + parseInt + ")");
                boolean z2 = (TextUtils.isEmpty(str2) || -1 == parseInt || 1 == a) ? false : true;
                boolean ac = com.huawei.android.pushagent.b.b.a.a(this.f15421b).ac();
                e.b("PushLogAC2712", "useProxy is valid:" + z2 + ", allow proxy:" + ac);
                if (z && z2 && ac) {
                    e.b("PushLogAC2712", "use Proxy " + str2 + ":" + parseInt + " to connect to push server.");
                    socket.connect(new InetSocketAddress(str2, parseInt), ((int) com.huawei.android.pushagent.b.b.a.a(this.f15421b).u()) * 1000);
                    property = "CONNECT " + str + ":" + i;
                    socket.getOutputStream().write((property + " HTTP/1.1\r\nHost: " + property + "\r\n\r\n").getBytes(GameManager.DEFAULT_CHARSET));
                    InputStream inputStream = socket.getInputStream();
                    StringBuilder stringBuilder = new StringBuilder(100);
                    a = 0;
                    do {
                        char read = (char) inputStream.read();
                        stringBuilder.append(read);
                        a = ((a == 0 || a == 2) && read == '\r') ? a + 1 : ((a == 1 || a == 3) && read == '\n') ? a + 1 : 0;
                    } while (a != 4);
                    property = new BufferedReader(new StringReader(stringBuilder.toString())).readLine();
                    if (property != null) {
                        e.a("PushLogAC2712", "read data:" + com.huawei.android.pushagent.c.a.a.e.a(property));
                    }
                } else {
                    e.b("PushLogAC2712", "create socket without proxy");
                    socket.connect(new InetSocketAddress(str, i), ((int) com.huawei.android.pushagent.b.b.a.a(this.f15421b).u()) * 1000);
                }
                e.a("PushLogAC2712", "write the lastcontectsucc_time to the pushConfig.xml file");
                socket.setSoTimeout(((int) com.huawei.android.pushagent.b.b.a.a(this.f15421b).u()) * 1000);
                return socket;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.c("PushLogAC2712", "call getBytes cause:" + e.toString(), e);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable e3) {
                        e.a("PushLogAC2712", "close socket cause:" + e3.toString(), e3);
                    }
                }
                throw new C4060c("create socket failed", C4059a.Err_Connect);
            } catch (SocketException e4) {
                e3 = e4;
                e.c("PushLogAC2712", "call setSoTimeout cause:" + e3.toString(), e3);
                if (socket != null) {
                    socket.close();
                }
                throw new C4060c("create socket failed", C4059a.Err_Connect);
            } catch (IOException e5) {
                e3 = e5;
                e.c("PushLogAC2712", "call connect cause:" + e3.toString(), e3);
                if (socket != null) {
                    socket.close();
                }
                throw new C4060c("create socket failed", C4059a.Err_Connect);
            } catch (NumberFormatException e6) {
                e3 = e6;
                e.c("PushLogAC2712", "call connect cause:" + e3.toString(), e3);
                if (socket != null) {
                    socket.close();
                }
                throw new C4060c("create socket failed", C4059a.Err_Connect);
            } catch (IllegalArgumentException e7) {
                e3 = e7;
                e.c("PushLogAC2712", "call connect cause:" + e3.toString(), e3);
                if (socket != null) {
                    socket.close();
                }
                throw new C4060c("create socket failed", C4059a.Err_Connect);
            } catch (Exception e8) {
                e3 = e8;
                e.c("PushLogAC2712", "call createSocket cause:" + e3.toString(), e3);
                if (socket != null) {
                    socket.close();
                }
                throw new C4060c("create socket failed", C4059a.Err_Connect);
            }
        } catch (UnsupportedEncodingException e9) {
            e3 = e9;
            socket = null;
            e.c("PushLogAC2712", "call getBytes cause:" + e3.toString(), e3);
            if (socket != null) {
                socket.close();
            }
            throw new C4060c("create socket failed", C4059a.Err_Connect);
        } catch (SocketException e10) {
            e3 = e10;
            socket = null;
            e.c("PushLogAC2712", "call setSoTimeout cause:" + e3.toString(), e3);
            if (socket != null) {
                socket.close();
            }
            throw new C4060c("create socket failed", C4059a.Err_Connect);
        } catch (IOException e11) {
            e3 = e11;
            socket = null;
            e.c("PushLogAC2712", "call connect cause:" + e3.toString(), e3);
            if (socket != null) {
                socket.close();
            }
            throw new C4060c("create socket failed", C4059a.Err_Connect);
        } catch (NumberFormatException e12) {
            e3 = e12;
            socket = null;
            e.c("PushLogAC2712", "call connect cause:" + e3.toString(), e3);
            if (socket != null) {
                socket.close();
            }
            throw new C4060c("create socket failed", C4059a.Err_Connect);
        } catch (IllegalArgumentException e13) {
            e3 = e13;
            socket = null;
            e.c("PushLogAC2712", "call connect cause:" + e3.toString(), e3);
            if (socket != null) {
                socket.close();
            }
            throw new C4060c("create socket failed", C4059a.Err_Connect);
        } catch (Exception e14) {
            e3 = e14;
            socket = null;
            e.c("PushLogAC2712", "call createSocket cause:" + e3.toString(), e3);
            if (socket != null) {
                socket.close();
            }
            throw new C4060c("create socket failed", C4059a.Err_Connect);
        }
    }

    protected void m19976a(C4076a c4076a, Bundle bundle) {
        this.f15422c.mo4357a(c4076a, bundle);
    }

    protected boolean m19977a() throws C4060c {
        Socket socket = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e.a("PushLogAC2712", "start to create socket");
            if (this.f15420a == null || this.f15420a.f15391a == null || this.f15420a.f15391a.length() == 0) {
                e.d("PushLogAC2712", "the addr is " + this.f15420a + " is invalid");
                return false;
            } else if (this.f15420a.f15393c == null) {
                e.d("PushLogAC2712", "config sslconetEntity.channelType cfgErr:" + this.f15420a.f15393c + " cannot connect!!");
                return false;
            } else {
                socket = m19975a(this.f15420a.f15391a, this.f15420a.f15392b, this.f15420a.f15394d);
                e.a("PushLogAC2712", "conetEntity.channelType:" + this.f15420a.f15393c);
                switch (this.f15420a.f15393c) {
                    case ChannelType_Normal:
                        this.f15422c.f15410c = new C4081c(this.f15421b);
                        break;
                    case ChannelType_SSL:
                    case ChannelType_SSL_Resume:
                        this.f15422c.f15410c = new C4082d(this.f15421b);
                        break;
                    case ChannelType_Secure:
                        this.f15422c.f15410c = new C4079a(this.f15421b);
                        break;
                    default:
                        e.d("PushLogAC2712", "conetEntity.channelType is invalid:" + this.f15420a.f15393c);
                        PushService.a().stopService();
                        socket.close();
                        return false;
                }
                if (this.f15422c.f15410c.mo4370a(socket)) {
                    socket.setSoTimeout(0);
                    e.a("PushLogAC2712", "connect cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms, result:" + this.f15422c.f15410c.mo4372b());
                    if (this.f15422c.f15410c.mo4372b()) {
                        InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f15420a.f15391a, this.f15420a.f15392b);
                        Bundle bundle = new Bundle();
                        bundle.putString("server_ip", inetSocketAddress.getAddress().getHostAddress());
                        bundle.putInt("server_port", inetSocketAddress.getPort());
                        bundle.putString("client_ip", socket.getLocalAddress().getHostAddress());
                        bundle.putInt("client_port", socket.getLocalPort());
                        bundle.putInt("channelEntity", this.f15422c.mo4360e().ordinal());
                        this.f15422c.mo4357a(C4076a.SocketEvent_CONNECTED, bundle);
                        return true;
                    }
                    e.d("PushLogAC2712", "Socket connect failed");
                    throw new C4060c("create SSLSocket failed", C4059a.Err_Connect);
                }
                e.d("PushLogAC2712", "call conetEntity.channel.init failed!!");
                socket.close();
                throw new C4060c("init socket error", C4059a.Err_Connect);
            }
        } catch (Throwable e) {
            e.c("PushLogAC2712", "call connectSync cause " + e.toString(), e);
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable e2) {
                    e.a("PushLogAC2712", "close socket cause:" + e2.toString(), e2);
                }
            }
            throw new C4060c(e, C4059a.Err_Connect);
        } catch (Throwable e3) {
            e.c("PushLogAC2712", "call connectSync cause " + e3.toString(), e3);
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable e22) {
                    e.a("PushLogAC2712", "close socket cause:" + e22.toString(), e22);
                }
            }
            throw new C4060c(e3, C4059a.Err_Connect);
        }
    }

    protected abstract void mo4367b() throws Exception;

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (m19977a()) {
                currentTimeMillis = System.currentTimeMillis();
                mo4367b();
            }
            e.a("PushLogAC2712", "normal to quit.");
            Bundle bundle = new Bundle();
            bundle.putLong("connect_time", System.currentTimeMillis() - currentTimeMillis);
            m19976a(C4076a.SocketEvent_CLOSE, bundle);
            e.b("PushLogAC2712", "total connect Time:" + (System.currentTimeMillis() - currentTimeMillis) + " process quit, so close socket");
            if (this.f15422c.f15410c != null) {
                try {
                    this.f15422c.f15410c.mo4369a();
                } catch (Throwable e) {
                    e.c("PushLogAC2712", e.toString(), e);
                }
            }
        } catch (Throwable e2) {
            e.c("PushLogAC2712", "connect occurs :" + e2.toString(), e2);
            Serializable serializable = e2.f15390a;
            Bundle bundle2 = new Bundle();
            if (serializable != null) {
                bundle2.putSerializable("errorType", serializable);
            }
            bundle2.putString("push_exception", e2.toString());
            m19976a(C4076a.SocketEvent_CLOSE, bundle2);
            e.b("PushLogAC2712", "total connect Time:" + (System.currentTimeMillis() - currentTimeMillis) + " process quit, so close socket");
            if (this.f15422c.f15410c != null) {
                try {
                    this.f15422c.f15410c.mo4369a();
                } catch (Throwable e22) {
                    e.c("PushLogAC2712", e22.toString(), e22);
                }
            }
        } catch (Throwable e222) {
            e.c("PushLogAC2712", "connect cause :" + e222.toString(), e222);
            Bundle bundle3 = new Bundle();
            bundle3.putString("push_exception", e222.toString());
            m19976a(C4076a.SocketEvent_CLOSE, bundle3);
            e.b("PushLogAC2712", "total connect Time:" + (System.currentTimeMillis() - currentTimeMillis) + " process quit, so close socket");
            if (this.f15422c.f15410c != null) {
                try {
                    this.f15422c.f15410c.mo4369a();
                } catch (Throwable e2222) {
                    e.c("PushLogAC2712", e2222.toString(), e2222);
                }
            }
        } catch (Throwable th) {
            e.b("PushLogAC2712", "total connect Time:" + (System.currentTimeMillis() - currentTimeMillis) + " process quit, so close socket");
            if (this.f15422c.f15410c != null) {
                try {
                    this.f15422c.f15410c.mo4369a();
                } catch (Throwable e3) {
                    e.c("PushLogAC2712", e3.toString(), e3);
                }
            }
        }
        e.a("PushLogAC2712", "connect thread exit!");
    }
}
