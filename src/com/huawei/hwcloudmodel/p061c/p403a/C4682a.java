package com.huawei.hwcloudmodel.p061c.p403a;

import android.content.Context;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcloudmodel.p061c.C4708u;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.login.ui.login.util.C5433c;
import com.huawei.p190v.C2538c;
import com.huawei.up.p520e.C6128b;
import com.huawei.up.p520e.C6133g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: AbsHealthDataHiCloudClient */
public abstract class C4682a {
    private static final Charset f17092a = Charset.forName(GameManager.DEFAULT_CHARSET);

    protected abstract C4708u mo4552a(String str, Map<String, Object> map, int i, int i2, int i3) throws C6133g;

    public String m22426b(String str, Map<String, Object> map, int i, int i2, int i3) throws C6133g {
        C4708u a = mo4552a(str, map, i, i2, i3);
        if (a.m22530a() == null) {
            C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"Request failed. matb"});
            throw new C6133g(a.m22531b(), "Request failed. matb");
        }
        try {
            return w.a(a.m22530a());
        } catch (Exception e) {
            C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"Parse failed. matb"});
            throw new C6133g(a.m22531b(), "Parse failed.", e);
        }
    }

    protected C4708u m22423a(Context context, String str, String str2, String str3, int i, int i2, int i3) throws C6133g {
        C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"Enter request data = " + str2});
        try {
            HttpClient a = C6128b.m27909a(context, str);
            HttpRequest a2 = C6128b.m27910a(str, i, i2, false);
            C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb httpHost = " + C6128b.m27907a(str)});
            if (a2 == null) {
                throw new C6133g(2, "Service unavailable.");
            }
            a2.addHeader("Accept-Encoding", "gzip");
            a2.addHeader("Content-Encoding", "gzip");
            a2.setHeader("x-huid", C5433c.m26039a(context).m26051c());
            C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb x-huid = " + r3});
            a2.setHeader("x-version", d.f(context));
            a2.setHeader("Content-Type", "application/json;charset=UTF-8");
            a2.setHeader("Connection", "keep-alive");
            C4708u c4708u = new C4708u();
            if (str2 != null) {
                try {
                    a2.setEntity(new ByteArrayEntity(C4682a.m22422a(str2.getBytes(GameManager.DEFAULT_CHARSET))));
                    HttpResponse execute = a.execute(r2, a2);
                    C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb httpResponse status =" + execute.getStatusLine().getStatusCode()});
                    if (execute.getStatusLine().getStatusCode() == 200 || execute.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
                        if (execute.getEntity() != null) {
                            C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb httpResponse httpResponse = " + execute});
                            c4708u.m22529a(m22425a(execute));
                        } else {
                            C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb httpResponse.getEntity is null"});
                        }
                    }
                    try {
                        if (!a2.isAborted()) {
                            a2.abort();
                        }
                    } catch (Exception e) {
                        C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"request Exception e = " + e.getMessage()});
                    }
                    C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb HealthDataHiCloudClient httpResponse response code = " + c4708u.m22532c()});
                    if (c4708u.m22532c() <= 0) {
                        return c4708u;
                    }
                    String a3 = w.a(c4708u.m22530a());
                    C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb HealthDataHiCloudClient httpResponse errContent = " + a3});
                    if (a3 == null) {
                        throw new C6133g(c4708u.m22532c(), "HealthDataHiCloudClient Unknown error");
                    }
                    throw new C6133g(c4708u.m22532c(), a3);
                } catch (Exception e2) {
                    C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"Service unavailable matb"});
                    throw new C6133g(2, "Service unavailable.", e2);
                } catch (Throwable th) {
                    try {
                        if (!a2.isAborted()) {
                            a2.abort();
                        }
                    } catch (Exception e3) {
                        C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"request Exception e = " + e3.getMessage()});
                    }
                }
            } else {
                C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"matb request data is null!"});
                throw new Exception("request data is null!");
            }
        } catch (Exception e22) {
            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"getHttpClient Exception"});
            throw new C6133g(2, "Service unavailable.", e22);
        }
    }

    protected byte[] m22425a(HttpResponse httpResponse) {
        BufferedInputStream bufferedInputStream;
        IOException e;
        IllegalStateException e2;
        Throwable th;
        Exception e3;
        BufferedInputStream bufferedInputStream2 = null;
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"parseHttpResponse entity = null."});
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Object value;
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                value = contentEncoding.getValue();
            } else {
                BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
            }
            if ("gzip".equals(value) || "z".equals(value)) {
                C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"Gzip support"});
                bufferedInputStream = new BufferedInputStream(new GZIPInputStream(entity.getContent()));
            } else {
                C2538c.c("AbsHealthDataHiCloudClient", new Object[]{"Gzip not support"});
                bufferedInputStream = new BufferedInputStream(entity.getContent());
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"bin.close() error:" + e4.getMessage()});
                    }
                }
                if (byteArrayOutputStream == null) {
                    return toByteArray;
                }
                try {
                    byteArrayOutputStream.close();
                    return toByteArray;
                } catch (IOException e42) {
                    C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"baos.close() error:" + e42.getMessage()});
                    return toByteArray;
                }
            } catch (IllegalStateException e5) {
                e2 = e5;
                try {
                    C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"parseHttpResponse1 error:" + e2.getMessage()});
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e422) {
                            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"bin.close() error:" + e422.getMessage()});
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        return bufferedInputStream2;
                    }
                    try {
                        byteArrayOutputStream.close();
                        return bufferedInputStream2;
                    } catch (IOException e4222) {
                        C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"baos.close() error:" + e4222.getMessage()});
                        return bufferedInputStream2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e42222) {
                            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"bin.close() error:" + e42222.getMessage()});
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e422222) {
                            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"baos.close() error:" + e422222.getMessage()});
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e422222 = e6;
                C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"parseHttpResponse2 error:" + e422222.getMessage()});
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4222222) {
                        C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"bin.close() error:" + e4222222.getMessage()});
                    }
                }
                if (byteArrayOutputStream != null) {
                    return bufferedInputStream2;
                }
                try {
                    byteArrayOutputStream.close();
                    return bufferedInputStream2;
                } catch (IOException e42222222) {
                    C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"baos.close() error:" + e42222222.getMessage()});
                    return bufferedInputStream2;
                }
            } catch (Exception e7) {
                e3 = e7;
                C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"parseHttpResponse3 error:" + e3.getMessage()});
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e422222222) {
                        C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"bin.close() error:" + e422222222.getMessage()});
                    }
                }
                if (byteArrayOutputStream != null) {
                    return bufferedInputStream2;
                }
                try {
                    byteArrayOutputStream.close();
                    return bufferedInputStream2;
                } catch (IOException e4222222222) {
                    C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"baos.close() error:" + e4222222222.getMessage()});
                    return bufferedInputStream2;
                }
            }
        } catch (IllegalStateException e8) {
            e2 = e8;
            bufferedInputStream = bufferedInputStream2;
            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"parseHttpResponse1 error:" + e2.getMessage()});
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                return bufferedInputStream2;
            }
            byteArrayOutputStream.close();
            return bufferedInputStream2;
        } catch (IOException e9) {
            e4222222222 = e9;
            bufferedInputStream = bufferedInputStream2;
            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"parseHttpResponse2 error:" + e4222222222.getMessage()});
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                return bufferedInputStream2;
            }
            byteArrayOutputStream.close();
            return bufferedInputStream2;
        } catch (Exception e10) {
            e3 = e10;
            bufferedInputStream = bufferedInputStream2;
            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"parseHttpResponse3 error:" + e3.getMessage()});
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                return bufferedInputStream2;
            }
            byteArrayOutputStream.close();
            return bufferedInputStream2;
        } catch (Throwable th3) {
            bufferedInputStream = bufferedInputStream2;
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public static byte[] m22422a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        IOException e;
        Throwable th;
        DataOutputStream dataOutputStream2 = null;
        if (bArr == null) {
            return new byte[0];
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
            } catch (IOException e2) {
                e = e2;
                try {
                    C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"gzip error!" + e.getMessage()});
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e3) {
                            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"gzip error!" + e3.getMessage()});
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e32) {
                            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"gzip error!" + e32.getMessage()});
                        }
                    }
                    throw th;
                }
            }
            try {
                dataOutputStream.write(bArr, 0, bArr.length);
                dataOutputStream.flush();
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e322) {
                        C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"gzip error!" + e322.getMessage()});
                    }
                }
            } catch (IOException e4) {
                e322 = e4;
                dataOutputStream2 = dataOutputStream;
                C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"gzip error!" + e322.getMessage()});
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream2 = dataOutputStream;
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e322 = e5;
            byteArrayOutputStream = null;
            C2538c.e("AbsHealthDataHiCloudClient", new Object[]{"gzip error!" + e322.getMessage()});
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
