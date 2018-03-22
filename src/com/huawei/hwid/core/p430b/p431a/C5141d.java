package com.huawei.hwid.core.p430b.p431a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.exception.TokenInvalidatedException;
import com.huawei.hwid.core.p429a.C5118c;
import com.huawei.hwid.core.p430b.p431a.C5125a.C5122d;
import com.huawei.hwid.core.p430b.p431a.p432a.C5128b;
import com.huawei.hwid.core.p430b.p431a.p432a.C5131d;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.C5111b;
import com.huawei.hwid.p426b.C5114a;
import com.huawei.hwid.p428c.C5115a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.cookie.SM;
import org.apache.http.util.EntityUtils;

/* compiled from: RequestManager */
public class C5141d {
    private static boolean f18569a = false;

    public static void m24813a(Context context, C5125a c5125a, String str, Handler handler) {
        if (c5125a.m24711s() <= 0) {
            c5125a.m24690c(C5166b.m24914a(context, str));
        }
        C5165e.m24904a("RequestManager", "globalSiteId:" + c5125a.m24711s());
        new C5142e(context, c5125a, handler, str).start();
    }

    public static Bundle m24810a(Context context, C5125a c5125a, String str) {
        int u = c5125a.m24713u();
        int i = 3 - u;
        C5165e.m24906b("RequestManager", "request is " + c5125a.getClass().getName() + "  requestTimes = " + u + "  startFromTimes = " + i);
        C5141d.m24812a(context, c5125a, str, i, 0);
        Bundle i2 = c5125a.m24701i();
        if (200 == c5125a.m24702j() && c5125a.m24703k() == 0) {
            i2.putAll(c5125a.mo4631h());
        }
        return i2;
    }

    private static void m24811a(Context context, C5125a c5125a) {
        if (!(c5125a instanceof C5128b) && c5125a.m24702j() != 1007) {
            c5125a.m24698f(C5166b.m24915a());
            C5118c.m24665a(c5125a.m24686b(context), context);
            c5125a.m24717y();
        }
    }

    private static void m24812a(Context context, C5125a c5125a, String str, int i, int i2) {
        if (i >= 3) {
            C5165e.m24912e("RequestManager", "exceed max request try time");
            return;
        }
        int i3 = i + 1;
        int i4 = i2 + 1;
        if (i4 > 1) {
            C5141d.m24811a(context, c5125a);
            i4 = 1;
        }
        c5125a.m24696e(C5166b.m24915a());
        C5165e.m24906b("RequestManager", "times = " + i4);
        try {
            if (C5166b.m24924a(context)) {
                HttpResponse a = C5140c.m24808a(context, c5125a, str);
                Header[] headers = a.getHeaders(SM.SET_COOKIE);
                int statusCode = a.getStatusLine().getStatusCode();
                String entityUtils = EntityUtils.toString(a.getEntity(), GameManager.DEFAULT_CHARSET);
                C5165e.m24906b("RequestManager", "response responseXMLContent  ");
                if (TextUtils.isEmpty(entityUtils) || !entityUtils.contains("<html")) {
                    c5125a.m24680a(statusCode);
                    C5165e.m24906b("RequestManager", "httpResponseCode = " + statusCode);
                    if (200 == statusCode) {
                        if (entityUtils != null) {
                            C5165e.m24912e("RequestManager", "parse response start");
                            if (C5122d.URLType.equals(c5125a.m24678a())) {
                                c5125a.mo4632b(entityUtils);
                            } else {
                                c5125a.mo4628a(entityUtils);
                            }
                            c5125a.m24681a(i4, 200, "");
                            C5165e.m24912e("RequestManager", "parse response end");
                            C5141d.m24817b(context, c5125a, headers.length > 0 ? headers[0].getValue() : "");
                            if (!(c5125a instanceof C5131d)) {
                                C5141d.m24818b(context, c5125a, str, i3, i4);
                            } else if (f18569a) {
                                C5141d.m24814a(false);
                                C5141d.m24818b(context, c5125a, str, i3, i4);
                            }
                        }
                        C5141d.m24811a(context, c5125a);
                        return;
                    } else if (307 == statusCode) {
                        c5125a.m24681a(i4, 307, "SC_TEMPORARY_REDIRECT");
                        Header firstHeader = a.getFirstHeader(LocationManagerProxy.KEY_LOCATION_CHANGED);
                        if (firstHeader != null) {
                            String value = firstHeader.getValue();
                            if (!TextUtils.isEmpty(value)) {
                                c5125a.m24694d(value);
                                C5141d.m24812a(context, c5125a, str, i3, i4);
                            }
                        }
                        C5141d.m24811a(context, c5125a);
                        return;
                    } else {
                        c5125a.m24681a(i4, statusCode, "other code");
                        C5165e.m24906b("RequestManager", "httpResponseCode is " + statusCode + ", prepare to retry: " + i3);
                        C5141d.m24812a(context, c5125a, str, i3, i4);
                        C5141d.m24811a(context, c5125a);
                        return;
                    }
                }
                c5125a.m24680a(1001);
                c5125a.m24681a(i4, 1001, "UNSUPPORTED_ENCODING_EXCEPTION");
                return;
            }
            c5125a.m24680a(1007);
        } catch (Throwable e) {
            C5165e.m24911d("RequestManager", "SSLPeerUnverifiedException", e);
            c5125a.m24680a(3008);
            c5125a.m24681a(i4, 3008, e.getMessage());
        } catch (Throwable e2) {
            C5165e.m24911d("RequestManager", e2.getMessage(), e2);
            c5125a.m24680a(1001);
            c5125a.m24681a(i4, 1001, e2.getMessage());
        } catch (Throwable e22) {
            C5165e.m24911d("RequestManager", e22.getMessage(), e22);
            c5125a.m24680a(1002);
            c5125a.m24681a(i4, 1002, e22.getMessage());
        } catch (Throwable e222) {
            C5165e.m24911d("RequestManager", e222.getMessage(), e222);
            c5125a.m24680a(1003);
            c5125a.m24681a(i4, 1003, e222.getMessage());
        } catch (Throwable e2222) {
            C5165e.m24911d("RequestManager", "IOException:" + e2222.getMessage(), e2222);
            c5125a.m24680a(1005);
            C5165e.m24906b("RequestManager", "IOException, prepare to retry: " + i3);
            c5125a.m24681a(i4, 1005, e2222.getMessage());
            C5141d.m24812a(context, c5125a, str, i3, i4);
        } catch (Throwable e22222) {
            C5165e.m24911d("RequestManager", e22222.getMessage(), e22222);
            c5125a.m24680a(1006);
            c5125a.m24681a(i4, 1006, e22222.getMessage());
        } catch (Throwable e222222) {
            C5165e.m24911d("RequestManager", e222222.getMessage(), e222222);
            c5125a.m24680a(3000);
            c5125a.m24681a(i4, 3000, e222222.getMessage());
        } catch (Throwable e2222222) {
            C5165e.m24911d("RequestManager", "NullPointerException", e2222222);
            c5125a.m24680a(3001);
            c5125a.m24681a(i4, 3001, e2222222.getMessage());
        }
    }

    private static void m24817b(Context context, C5125a c5125a, String str) {
        if (!TextUtils.isEmpty(str) && c5125a.m24703k() == 0) {
            Object obj = null;
            if (c5125a instanceof C5131d) {
                obj = ((C5131d) c5125a).m24757A();
            }
            if (!TextUtils.isEmpty(obj)) {
                C5115a.m24641a(context).m24645a(obj, str);
            }
        }
    }

    private static void m24818b(Context context, C5125a c5125a, String str, int i, int i2) throws IOException, TokenInvalidatedException {
        if (!TextUtils.isEmpty(str)) {
            C5111b a = C5114a.m24640a(context);
            if (C5141d.m24819b(c5125a)) {
                HwAccount b = a.mo4623b(context, str, null);
                String str2 = "";
                if (b != null) {
                    str2 = b.m25130g();
                }
                if (!TextUtils.isEmpty(str2)) {
                    a.mo4619a(context, str, "com.huawei.hwid", str2);
                    HwAccount b2 = a.mo4623b(context, str, null);
                    String str3 = "";
                    if (b2 != null) {
                        str3 = b2.m25130g();
                    }
                    if (TextUtils.isEmpty(str3)) {
                        C5165e.m24906b("RequestManager", "autoCheck removeAccount");
                        a.mo4625b(context, str, "com.huawei.hwid", str2);
                    } else {
                        c5125a.m24691c(str3);
                        a.mo4625b(context, str, "com.huawei.hwid", str3);
                        C5141d.m24812a(context, c5125a, str, i, i2);
                        return;
                    }
                }
                throw new TokenInvalidatedException("token is invalidated");
            } else if (C5141d.m24816a(c5125a)) {
                C5165e.m24912e("RequestManager", "user session is out of date.");
                a.mo4620a(context, str, null, "Cookie", "");
                if (C5141d.m24815a(context, str, c5125a)) {
                    C5141d.m24812a(context, c5125a, str, i, i2);
                }
            }
        }
    }

    private static boolean m24816a(C5125a c5125a) {
        if (70001101 == c5125a.m24703k()) {
            return true;
        }
        return false;
    }

    private static boolean m24819b(C5125a c5125a) {
        if (70002015 == c5125a.m24703k() || 70002016 == c5125a.m24703k()) {
            return true;
        }
        return false;
    }

    private static boolean m24815a(Context context, String str, C5125a c5125a) throws IOException, TokenInvalidatedException {
        HwAccount b = C5115a.m24641a(context).m24646b();
        if (b == null) {
            b = C5115a.m24641a(context).m24647c();
        }
        Object obj = "";
        String str2 = "";
        String str3 = "";
        if (b != null) {
            obj = b.m25130g();
            str2 = b.m25122c();
            str3 = b.m25134i();
        }
        if (TextUtils.isEmpty(obj)) {
            throw new TokenInvalidatedException("token is null");
        }
        C5141d.m24814a(true);
        C5125a c5131d = new C5131d(context, str2, obj, C5166b.m24914a(context, str), str3);
        C5141d.m24812a(context, c5131d, str, 0, 0);
        c5125a.m24680a(c5131d.m24702j());
        if (c5131d.m24702j() == 200 && (c5131d.m24703k() == 70002016 || c5131d.m24703k() == 70002015)) {
            c5125a.m24680a(3000);
        }
        if (200 != c5125a.mo4631h().getInt("responseCode")) {
            return false;
        }
        if (c5131d.m24703k() == 0) {
            return true;
        }
        return false;
    }

    private static synchronized void m24814a(boolean z) {
        synchronized (C5141d.class) {
            f18569a = z;
        }
    }
}
