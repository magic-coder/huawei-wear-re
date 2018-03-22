package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.ab;
import cn.com.xy.sms.sdk.p208d.p211c.ac;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.C2999d;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.http.client.methods.HttpGet;

public final class C3044i extends Thread {
    private static HashSet<String> f10290c = new HashSet();
    private static boolean f10291d = false;
    private int f10292a = 0;
    private ab f10293b;

    private C3044i() {
    }

    private static synchronized ab m13613a() {
        ab abVar;
        synchronized (C3044i.class) {
            Iterator it = f10290c.iterator();
            abVar = null;
            Object arrayList = new ArrayList();
            while (it != null && it.hasNext()) {
                String str = (String) it.next();
                ab b = ac.m13225b(str);
                arrayList.add(str);
                if (b != null) {
                    abVar = b;
                    break;
                }
                abVar = b;
            }
            f10290c.removeAll(arrayList);
            arrayList.clear();
        }
        return abVar;
    }

    private void m13614a(ab abVar) {
        if (!C2996a.m13492a(2)) {
            return;
        }
        if (abVar != null) {
            this.f10293b = abVar;
            File file = new File(new StringBuilder(String.valueOf(C2917a.m13112e() + "ziptemp")).append(File.separator).toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            new StringBuilder("filePath =").append(file.getAbsolutePath());
            String str = abVar.f9949c;
            File file2 = new File(file, str.substring(str.lastIndexOf(47) + 1));
            if (file2.exists()) {
                file2.delete();
            }
            if (C2982a.f10101a) {
                new StringBuilder("下载时间=").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" 下载url=").append(C2996a.f10132d).append(abVar.f9949c).append(" scene_id=").append(this.f10293b.f9948b).append(" id=").append(this.f10293b.f9947a);
            }
            boolean z = false;
            while (this.f10292a < 2 && !z) {
                boolean a;
                try {
                    String str2 = C2996a.f10132d + abVar.f9949c;
                    new StringBuilder("dUrl =").append(str2).append(" saveFilePath: ").append(file2);
                    a = m13617a(str2, file2);
                } catch (Throwable th) {
                    a = z;
                }
                this.f10292a++;
                try {
                    Thread.sleep((long) (this.f10292a * 4000));
                    z = a;
                } catch (Throwable e) {
                    C2982a.m13415a("XIAOYUAN", "downloadzippackage: " + e.getMessage(), e);
                    z = a;
                } catch (Throwable e2) {
                    try {
                        C2982a.m13415a("XIAOYUAN", "downLoadRes: " + e2.getMessage(), e2);
                        Thread.sleep(2000);
                    } catch (Throwable e22) {
                        C2982a.m13415a("XIAOYUAN", "downLoadRes: " + e22.getMessage(), e22);
                    }
                    m13614a(C3044i.m13618b());
                    return;
                }
            }
            if (z) {
                try {
                    C3050o.m13671a(file2, C2917a.m13113f());
                    long j = this.f10293b.f9947a;
                    String str3 = this.f10293b.f9949c;
                    ac.m13221a(j, 1);
                    C3055t.m13697a(file2);
                } catch (Throwable e222) {
                    C2982a.m13415a("XIAOYUAN", "downloadzippackage: " + e222.getMessage(), e222);
                    C3055t.m13697a(file2);
                } catch (Throwable e2222) {
                    C2982a.m13415a("XIAOYUAN", "downloadzippackage: " + e2222.getMessage(), e2222);
                    C3055t.m13697a(file2);
                } catch (Throwable e22222) {
                    C2982a.m13415a("XIAOYUAN", "downloadzippackage: " + e22222.getMessage(), e22222);
                    C3055t.m13697a(file2);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (Throwable e222222) {
                C2982a.m13415a("XIAOYUAN", "downLoadRes: " + e222222.getMessage(), e222222);
            }
            m13614a(C3044i.m13618b());
            return;
        }
        f10291d = false;
    }

    public static synchronized void m13615a(String str) {
        synchronized (C3044i.class) {
            if (!(C3049n.m13653e(str) || f10290c.contains(str))) {
                f10290c.add(str);
            }
        }
    }

    public static synchronized void m13616a(boolean z) {
        synchronized (C3044i.class) {
            if (!f10291d) {
                new C3044i().start();
            }
        }
    }

    private boolean m13617a(String str, File file) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        RandomAccessFile randomAccessFile;
        InputStream inputStream2 = null;
        try {
            if (C3049n.m13653e(str)) {
                httpURLConnection = null;
            } else if (str.startsWith("https") || str.startsWith("HTTPS")) {
                httpURLConnection = C2999d.m13520a(str, 1);
            } else {
                URL url = new URL(C2996a.m13481a(str));
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(5000);
                    httpURLConnection3.setReadTimeout(90000);
                    httpURLConnection3.setRequestMethod(HttpGet.METHOD_NAME);
                    httpURLConnection3.addRequestProperty("clientKey", "360_c");
                    httpURLConnection3.addRequestProperty("reqVersion", "5.2.2.1015");
                    httpURLConnection3.connect();
                    if (C2982a.f10101a) {
                        new StringBuilder("downUrl =").append(url);
                    }
                    httpURLConnection = httpURLConnection3;
                } catch (Throwable th2) {
                    httpURLConnection = httpURLConnection3;
                    randomAccessFile = null;
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th22) {
                            C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th22.getMessage(), th22);
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th222) {
                            C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th222.getMessage(), th222);
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th2222) {
                            C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th2222.getMessage(), th2222);
                        }
                    }
                    System.gc();
                    throw th;
                }
            }
            if (httpURLConnection == null) {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th3) {
                        C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th3.getMessage(), th3);
                    }
                }
                System.gc();
                return false;
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 206) {
                    long contentLength = (long) httpURLConnection.getContentLength();
                    if (C2982a.f10101a) {
                    }
                    if (contentLength == 0) {
                        if (this.f10293b != null) {
                            ac.m13222a(this.f10293b, System.currentTimeMillis() + C2973a.m13350a(18, 86400000));
                        }
                        new StringBuilder("返回大小为0，删掉zip包 resdownload=").append(this.f10293b);
                        C3055t.m13697a(file);
                        this.f10292a = 4;
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th32) {
                                C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th32.getMessage(), th32);
                            }
                        }
                        System.gc();
                        return false;
                    }
                    InputStream inputStream3 = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        randomAccessFile = new RandomAccessFile(file, "rwd");
                        try {
                            randomAccessFile.seek(0);
                            while (true) {
                                int read = inputStream3.read(bArr);
                                if (read == -1) {
                                    try {
                                        break;
                                    } catch (Throwable th322) {
                                        C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th322.getMessage(), th322);
                                    }
                                } else {
                                    randomAccessFile.write(bArr, 0, read);
                                }
                            }
                            randomAccessFile.close();
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Throwable th3222) {
                                    C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th3222.getMessage(), th3222);
                                }
                            }
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable th32222) {
                                    C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th32222.getMessage(), th32222);
                                }
                            }
                            System.gc();
                            if (C2982a.f10101a) {
                                new StringBuilder("下载了 downloadUrl=").append(str).append(" fileSize=").append(contentLength);
                            }
                            return true;
                        } catch (Throwable th4) {
                            th32222 = th4;
                            inputStream2 = inputStream3;
                        }
                    } catch (Throwable th5) {
                        th32222 = th5;
                        randomAccessFile = null;
                        inputStream2 = inputStream3;
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        System.gc();
                        throw th32222;
                    }
                } else if (responseCode == HttpStatus.SC_NOT_FOUND) {
                    new StringBuilder("responseCode==404，删掉zip包 resdownload=").append(this.f10293b);
                    if (this.f10293b != null) {
                        ac.m13222a(this.f10293b, System.currentTimeMillis() + C2973a.m13350a(18, 86400000));
                    }
                    C3055t.m13697a(file);
                    this.f10292a = 4;
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th322222) {
                            C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th322222.getMessage(), th322222);
                        }
                    }
                    System.gc();
                    return false;
                } else {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th3222222) {
                            C2982a.m13415a("XIAOYUAN", "downloadFileUseOneUrl: " + th3222222.getMessage(), th3222222);
                        }
                    }
                    System.gc();
                    return false;
                }
            } catch (Throwable th6) {
                th3222222 = th6;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                System.gc();
                throw th3222222;
            }
        } catch (Throwable th7) {
            th3222222 = th7;
            httpURLConnection = null;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            System.gc();
            throw th3222222;
        }
    }

    private static synchronized ab m13618b() {
        ab a;
        synchronized (C3044i.class) {
            a = C3044i.m13613a();
            if (a == null) {
                a = ac.m13219a();
            }
        }
        return a;
    }

    private static synchronized void m13619b(boolean z) {
        synchronized (C3044i.class) {
            f10291d = z;
        }
    }

    public final void run() {
        try {
            if (!f10291d) {
                C3044i.m13619b(true);
                Thread.sleep(3000);
                m13614a(C3044i.m13618b());
                C3044i.m13619b(false);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "run: " + th.getMessage(), th);
        }
    }
}
