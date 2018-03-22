package cn.com.xy.sms.sdk.p216h;

import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import cn.com.xy.sms.p204a.C2899a;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p205a.C2911b;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2987e;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p216h.p217a.C2994l;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3046k;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import cn.com.xy.sms.sdk.p229l.C3055t;
import cn.com.xy.sms.sdk.p229l.ad;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Priority;

public class C2997c implements Runnable {
    private static String f10144a = null;
    public static int f10145i = Priority.ERROR_INT;
    public static int f10146j = 90000;
    public String f10147b;
    public String f10148c;
    public C3000e f10149d;
    public C2904g f10150e;
    public boolean f10151f = false;
    public String f10152g;
    public boolean f10153h = false;

    public C2997c(String str, C3000e c3000e, String str2, boolean z, String str3, C2904g c2904g, boolean z2) {
        m13515a(str, c3000e, str2, z, str3, c2904g, z2);
    }

    public static String m13508a(boolean z) {
        try {
            if (f10144a == null) {
                f10144a = ((TelephonyManager) C2917a.m13105a().getSystemService("phone")).getDeviceId();
            }
            return C3049n.m13653e(f10144a) ? "" : z ? C2994l.m13472a(f10144a) : f10144a;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getDeviceId: " + th.getMessage(), th);
            return "";
        }
    }

    public static void m13509a(String str, int i) {
        try {
            if (C3041f.m13607a() != null) {
                new StringBuilder("length=").append(i).append(" req=").append(str);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "logNetInfo: " + th.getMessage(), th);
        }
    }

    protected static boolean m13510b() {
        if (C3049n.m13653e(C3006k.f10165k)) {
            return false;
        }
        try {
            C2911b b = C2973a.m13369b(false);
            if (b != null) {
                return b.m13087c(C3006k.f10165k);
            }
        } catch (Throwable th) {
            C2982a.m13414a("BaseHttpRunnable isAppChannel", "获取算法包内的是否为应用渠道出现异常");
        }
        return true;
    }

    static String m13511c() {
        String str = "";
        if (VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        return strArr.length > 0 ? strArr[0] : str;
    }

    public HttpURLConnection m13512a() {
        try {
            C3046k.m13626a();
            HttpURLConnection a = (this.f10147b.startsWith("https") || this.f10147b.startsWith("HTTPS")) ? C2999d.m13519a(this.f10147b) : (HttpURLConnection) new URL(this.f10147b).openConnection();
            a.setConnectTimeout(f10145i);
            a.setReadTimeout(f10146j);
            a.setDoInput(true);
            a.setDoOutput(true);
            a.setRequestMethod(HttpPost.METHOD_NAME);
            a.setUseCaches(false);
            a.setInstanceFollowRedirects(true);
            mo3633a(this.f10149d, this.f10151f, this.f10152g, a);
            if (this.f10153h) {
                a.addRequestProperty("nz", "1");
            }
            if (!C2899a.m13069a()) {
                return a;
            }
            a.addRequestProperty("encrypt", "1");
            return a;
        } catch (Throwable th) {
            C2982a.m13415a("HTTP", "BaseHttpRunnable getHttpURLConnection error: " + th.getMessage(), th);
            return null;
        }
    }

    public void m13513a(int i, String str) {
        new StringBuilder("STATUS: ").append(i).append(" responseStr: ").append(str);
        if (this.f10150e != null) {
            this.f10150e.execute(Integer.valueOf(i), str);
        }
    }

    public void mo3633a(C3000e c3000e, boolean z, String str, HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.addRequestProperty("Content-Type", "text/xml;UTF-8");
            String a = C2994l.m13473a(C3006k.f10164a, C3006k.f10165k);
            httpURLConnection.addRequestProperty("app-key", C3006k.f10165k);
            httpURLConnection.addRequestProperty("app-key-sign", a);
            httpURLConnection.addRequestProperty("compress", "1");
            httpURLConnection.addRequestProperty("loginid", "");
            httpURLConnection.addRequestProperty("recordState", ad.m13585a());
            httpURLConnection.addRequestProperty("sdkversion", C2996a.f10136h);
            if (z) {
                httpURLConnection.addRequestProperty("h-token", C2994l.m13473a("", C3006k.f10165k));
                httpURLConnection.addRequestProperty("command", "0");
            } else {
                httpURLConnection.addRequestProperty("command", "1");
            }
            if (!C3049n.m13653e(str)) {
                httpURLConnection.addRequestProperty("cmd", str);
            }
            httpURLConnection.addRequestProperty("abi", C2997c.m13511c());
            httpURLConnection.addRequestProperty("uiversion", C2973a.m13385g());
            m13517a(httpURLConnection);
            if (C2982a.f10101a) {
                C2982a.m13414a("httpheader", httpURLConnection.getRequestProperties().toString());
            }
        }
    }

    public void m13515a(String str, C3000e c3000e, String str2, boolean z, String str3, C2904g c2904g, boolean z2) {
        this.f10149d = c3000e;
        this.f10147b = str;
        this.f10148c = str2;
        this.f10150e = c2904g;
        this.f10151f = z;
        this.f10152g = str3;
        this.f10153h = z2;
    }

    public void m13516a(String str, String str2) {
        new StringBuilder("STATUS: ").append(str).append(" responseStr: ").append(str2);
        if (this.f10150e != null) {
            this.f10150e.execute(str, str2);
        }
    }

    protected void m13517a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.addRequestProperty("x", C2991i.m13460b());
            if (!C2997c.m13510b()) {
                return;
            }
            if (this.f10147b.endsWith("token/")) {
                httpURLConnection.addRequestProperty("s", C2997c.m13508a(false));
                return;
            }
            String a = C2997c.m13508a(true);
            if (C3049n.m13653e(a)) {
                a = C2947n.m13284d(C2917a.m13105a(), "UNIQUE_CODE");
                if (a == null) {
                    a = "";
                }
            }
            httpURLConnection.addRequestProperty("p", a);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "addHeadSign: " + th.getMessage(), th);
        }
    }

    public void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = m13512a();
            httpURLConnection.connect();
            Closeable outputStream = httpURLConnection.getOutputStream();
            String a = C3050o.m13667a(2);
            new StringBuilder("url=").append(this.f10147b);
            new StringBuilder("content=").append(this.f10148c);
            C2982a.m13414a("xyvalue", "keyStr: " + a);
            byte[] a2 = C2987e.m13427a(this.f10148c, a);
            if (this.f10153h) {
                a2 = C3049n.m13647b(a2);
            }
            outputStream.write(a2);
            outputStream.flush();
            C3055t.m13696a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            new StringBuilder("URL:").append(this.f10147b).append("  code=").append(responseCode);
            if (responseCode == 200) {
                outputStream = httpURLConnection.getInputStream();
                a2 = C3055t.m13705a((InputStream) outputStream);
                int length = a2.length;
                C2997c.m13509a(this.f10148c, length);
                if (((long) length) > 26214400) {
                    m13513a(-9, "");
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                            return;
                        } catch (Throwable th) {
                            C2982a.m13415a("XIAOYUAN", "run: " + th.getMessage(), th);
                            return;
                        }
                    }
                    return;
                }
                if (this.f10153h) {
                    a2 = C3049n.m13645a(a2);
                }
                m13513a(0, new String(C2987e.m13428a(a2, a.getBytes()), GameManager.DEFAULT_CHARSET));
                C3055t.m13696a(outputStream);
            } else {
                m13513a(-8, "");
            }
        } catch (Throwable th2) {
            try {
                C2982a.m13415a("HTTP", "2 http error: " + th2.getMessage(), th2);
                if (th2.getClass() == SocketTimeoutException.class) {
                    m13513a(-6, "");
                } else {
                    m13513a(-7, "");
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    return;
                }
                return;
            } catch (Throwable th22) {
                C2982a.m13415a("XIAOYUAN", "run: " + th22.getMessage(), th22);
                return;
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th222) {
                C2982a.m13415a("XIAOYUAN", "run: " + th222.getMessage(), th222);
            }
        }
    }
}
