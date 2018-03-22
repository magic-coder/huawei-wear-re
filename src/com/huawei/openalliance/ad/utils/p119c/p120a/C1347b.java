package com.huawei.openalliance.ad.utils.p119c.p120a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.huawei.openalliance.ad.utils.C1345b;
import com.huawei.openalliance.ad.utils.C1355c;
import com.huawei.openalliance.ad.utils.C1363g;
import com.huawei.openalliance.ad.utils.C1364h;
import com.huawei.openalliance.ad.utils.p119c.C1349a;
import com.huawei.openalliance.ad.utils.p129b.C1335c;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class C1347b extends AsyncTask<Void, Void, String> {
    private static final LinkedHashMap<String, String> f2928c = new LinkedHashMap(0, 0.75f, true);
    private HttpClient f2929a = null;
    private String f2930b;
    private C1247a f2931d;
    private Context f2932e;
    private C1346a f2933f;

    public interface C1247a {
        void mo2428a(Context context, String str);
    }

    public C1347b(Context context, C1346a c1346a, C1247a c1247a) {
        this.f2930b = C1364h.m6073a(context) + File.separator + "hiad" + File.separator;
        if (!TextUtils.isEmpty(c1346a.m5941a())) {
            this.f2930b += c1346a.m5941a() + File.separator;
        }
        File file = new File(this.f2930b);
        if (!(file.exists() || file.mkdirs())) {
            this.f2930b = C1364h.m6073a(context) + File.separator;
        }
        this.f2929a = C1349a.m5964a();
        this.f2931d = c1247a;
        this.f2932e = context;
        this.f2933f = c1346a;
    }

    private String m5947a(Object obj) {
        if (obj == null || !(obj instanceof C1346a)) {
            return null;
        }
        String e = ((C1346a) obj).m5946e();
        if (e == null) {
            return null;
        }
        File file = new File(this.f2930b + C1347b.m5950b(obj.toString()));
        if (C1345b.m5940b(file)) {
            return file.getAbsolutePath();
        }
        try {
            if (m5948a(e, file.getAbsolutePath())) {
                return file.getAbsolutePath();
            }
        } catch (Exception e2) {
            C1345b.m5937a(file);
            C1336d.m5888c("ImageFetcher", "processBitmap failed");
        }
        return null;
    }

    private boolean m5948a(String str, String str2) {
        RuntimeException e;
        Throwable th;
        Closeable closeable = null;
        Closeable closeable2 = null;
        HttpEntity httpEntity = null;
        File file = new File(str2 + ".bak");
        if (this.f2933f == null) {
            return false;
        }
        if (m5951c(file.getAbsolutePath()) != null) {
            C1336d.m5886b("ImageFetcher", "file is in progress");
            return false;
        }
        m5952d(file.getAbsolutePath());
        Closeable bufferedInputStream;
        try {
            HttpResponse execute = this.f2929a.execute(new HttpGet(str));
            int statusCode = execute.getStatusLine().getStatusCode();
            if (200 == statusCode || 206 == statusCode) {
                httpEntity = execute.getEntity();
                if (httpEntity == null) {
                    C1336d.m5888c("ImageFetcher", "response entity is null");
                    try {
                        m5953e(file.getAbsolutePath());
                        C1345b.m5935a(null);
                        C1345b.m5935a(null);
                        if (httpEntity == null) {
                            return false;
                        }
                        httpEntity.consumeContent();
                        return false;
                    } catch (IOException e2) {
                        C1336d.m5888c("ImageFetcher", "IOException");
                        return false;
                    }
                }
                long contentLength = httpEntity.getContentLength();
                long d = ((long) this.f2933f.m5945d()) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                if (contentLength < 0 || contentLength > d) {
                    C1336d.m5888c("ImageFetcher", "fileSize is not in limit", String.valueOf(d));
                    try {
                        m5953e(file.getAbsolutePath());
                        C1345b.m5935a(null);
                        C1345b.m5935a(null);
                        if (httpEntity == null) {
                            return false;
                        }
                        httpEntity.consumeContent();
                        return false;
                    } catch (IOException e3) {
                        C1336d.m5888c("ImageFetcher", "IOException");
                        return false;
                    }
                }
                int i;
                bufferedInputStream = new BufferedInputStream(httpEntity.getContent(), 8192);
                try {
                    closeable = new BufferedOutputStream(new FileOutputStream(file), 8192);
                    i = 0;
                } catch (RuntimeException e4) {
                    e = e4;
                    closeable = bufferedInputStream;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = closeable;
                        closeable = closeable2;
                    }
                } catch (Exception e5) {
                    closeable = null;
                    try {
                        C1336d.m5888c("ImageFetcher", "Error in downloadBitmap,url:" + str);
                        try {
                            m5953e(file.getAbsolutePath());
                            C1345b.m5935a(closeable);
                            C1345b.m5935a(bufferedInputStream);
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (IOException e6) {
                            C1336d.m5888c("ImageFetcher", "IOException");
                        }
                        C1345b.m5937a(file);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            m5953e(file.getAbsolutePath());
                            C1345b.m5935a(closeable);
                            C1345b.m5935a(bufferedInputStream);
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (IOException e7) {
                            C1336d.m5888c("ImageFetcher", "IOException");
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    closeable = null;
                    m5953e(file.getAbsolutePath());
                    C1345b.m5935a(closeable);
                    C1345b.m5935a(bufferedInputStream);
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        closeable.write(bArr, 0, read);
                        i += read;
                    }
                    closeable.flush();
                    if (contentLength != ((long) i)) {
                        C1336d.m5888c("ImageFetcher", "downloadUrlToStream error, downloaded size " + i + ", not equal to actual size " + httpEntity.getContentLength() + ",url" + str);
                        C1345b.m5937a(file);
                        try {
                            m5953e(file.getAbsolutePath());
                            C1345b.m5935a(closeable);
                            C1345b.m5935a(bufferedInputStream);
                            if (httpEntity == null) {
                                return false;
                            }
                            httpEntity.consumeContent();
                            return false;
                        } catch (IOException e8) {
                            C1336d.m5888c("ImageFetcher", "IOException");
                            return false;
                        }
                    } else if (!m5949a(this.f2933f.m5944c(), this.f2933f.m5943b(), file)) {
                        C1336d.m5888c("ImageFetcher", "downloadUrlToStream error, downloaded file hashcode is not right, url" + str);
                        C1345b.m5937a(file);
                        try {
                            m5953e(file.getAbsolutePath());
                            C1345b.m5935a(closeable);
                            C1345b.m5935a(bufferedInputStream);
                            if (httpEntity == null) {
                                return false;
                            }
                            httpEntity.consumeContent();
                            return false;
                        } catch (IOException e9) {
                            C1336d.m5888c("ImageFetcher", "IOException");
                            return false;
                        }
                    } else if (file.renameTo(new File(str2))) {
                        try {
                            m5953e(file.getAbsolutePath());
                            C1345b.m5935a(closeable);
                            C1345b.m5935a(bufferedInputStream);
                            if (httpEntity == null) {
                                return true;
                            }
                            httpEntity.consumeContent();
                            return true;
                        } catch (IOException e10) {
                            C1336d.m5888c("ImageFetcher", "IOException");
                            return true;
                        }
                    } else {
                        try {
                            m5953e(file.getAbsolutePath());
                            C1345b.m5935a(closeable);
                            C1345b.m5935a(bufferedInputStream);
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (IOException e11) {
                            C1336d.m5888c("ImageFetcher", "IOException");
                        }
                        C1345b.m5937a(file);
                        return false;
                    }
                } catch (RuntimeException e12) {
                    e = e12;
                    closeable2 = closeable;
                    closeable = bufferedInputStream;
                    throw e;
                } catch (Exception e13) {
                    C1336d.m5888c("ImageFetcher", "Error in downloadBitmap,url:" + str);
                    m5953e(file.getAbsolutePath());
                    C1345b.m5935a(closeable);
                    C1345b.m5935a(bufferedInputStream);
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                    C1345b.m5937a(file);
                    return false;
                }
            }
            try {
                m5953e(file.getAbsolutePath());
                C1345b.m5935a(null);
                C1345b.m5935a(null);
                if (httpEntity == null) {
                    return false;
                }
                httpEntity.consumeContent();
                return false;
            } catch (IOException e14) {
                C1336d.m5888c("ImageFetcher", "IOException");
                return false;
            }
        } catch (RuntimeException e15) {
            e = e15;
            throw e;
        } catch (Exception e16) {
            bufferedInputStream = null;
            closeable = null;
            C1336d.m5888c("ImageFetcher", "Error in downloadBitmap,url:" + str);
            m5953e(file.getAbsolutePath());
            C1345b.m5935a(closeable);
            C1345b.m5935a(bufferedInputStream);
            if (httpEntity != null) {
                httpEntity.consumeContent();
            }
            C1345b.m5937a(file);
            return false;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            closeable = null;
            m5953e(file.getAbsolutePath());
            C1345b.m5935a(closeable);
            C1345b.m5935a(bufferedInputStream);
            if (httpEntity != null) {
                httpEntity.consumeContent();
            }
            throw th;
        }
    }

    private boolean m5949a(String str, String str2, File file) {
        if (TextUtils.isEmpty(str)) {
            if (!(TextUtils.isEmpty(str2) || str2.equalsIgnoreCase(C1355c.m5977a(file)))) {
                return false;
            }
        } else if (!str.equalsIgnoreCase(C1363g.m6072a(file))) {
            return false;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    private static String m5950b(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(Charset.forName(GameManager.DEFAULT_CHARSET)));
            return C1335c.m5881a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    private synchronized String m5951c(String str) {
        return (String) f2928c.get(str);
    }

    private synchronized void m5952d(String str) {
        f2928c.put(str, str);
    }

    private synchronized void m5953e(String str) {
        f2928c.remove(str);
    }

    protected String m5954a(Void... voidArr) {
        return m5947a(this.f2933f);
    }

    protected void m5955a(String str) {
        if (this.f2931d != null && this.f2932e != null) {
            this.f2931d.mo2428a(this.f2932e, str);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5954a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5955a((String) obj);
    }
}
