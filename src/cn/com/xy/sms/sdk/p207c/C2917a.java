package cn.com.xy.sms.sdk.p207c;

import android.content.Context;
import android.util.LruCache;
import cn.com.xy.sms.sdk.p229l.C3055t;
import com.huawei.crowdtestsdk.utils.ResUtil;
import java.io.File;

public class C2917a {
    public static long f9891a = 0;
    public static LruCache<String, Long> f9892b = new LruCache(100);
    public static String f9893c = "";
    public static String f9894d = null;
    public static String f9895e = null;
    public static Context f9896f = null;
    public static boolean f9897g = false;
    public static boolean f9898h = false;
    public static String f9899i = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDQfvMvJo7qaklYMfWBU/9yjwWoFIcWHgb5+AwGw3wo2EVC9pB20eQPRG1/rywb0aTSadwyOuczoyvKBHIA11LwgNnDXVqnFMEg3K/2UoOUi4Ul2Kt6USvDebcgB1862vfqpBBAfFIgalfocGTSsd7qcpPrBk8nRJdaZWY4Rp3WiuHaJttL+Wo0DvbQyypSeTK6XzS5VTJGnbR4W+aL2+R6T0Ff+uSYCO1IBU4famAn1trUdjLA1QsT7rZkSvtrj+XkOmyzQdj8jGqYhnrh1IRbZN2a9wZZdpGllDmiaS6zEyip9bBxzbgkxZWydu9GjHMvtt+HziHRpirRcgzjYg3JAgMBAAECggEBALNwzzOBZ/bwSveQ587K0Et0NFYYdLrgVPjGNvOLQ0yT9ehP9L2On01UgzklNj0rDUPawByq/Vk/0ewoL0XyC/vZqZGuwtqRzjXOOdMx6PTrr0iHVe4L9jJiiu0R6y/oTP6w/RvC45vqaoYuVVfQph35Rr07zNvq+KhgJL3CaQ2/I7hzi1LTXsjQP4UzRKfVpfbhoM4JdCuuYqkOUst0Aw6nzsP/hMmH7c5svSnOWhqTIGioOzq3V9Tg9CL+U4qPiwGSdIQfh9ZSNDaXqAd2LKiWlBM8uNelDYcFDGd77UZRf/gR4PwT0fXaSt6IKda8lalf/azZYBiAqkrYxnHulJECgYEA8yZHlIFk1JwIrEjsj9NlVLmIv/+3OLopqXd6X6DXx2Xr+oLKdZlcXovzJfonpFXKIVPKQ5T2DD7SfS/vmbqdC/LaTZzb7FQxTa793tVDnGaCY8Svtn4/ubQhBx+JSxUDiw7JGoBjrPDa6IJyKzxoc2yy1St5FH99v0PEcTFaGHcCgYEA24PR5cL6wH4fRUJg8jS93CrQNk+CskSad0fl2Tk7a3EJXjrkwtQiXd6bm7UDGgoWenPCvLS6XaKw41U0s1Q8jW8JNIjhuMf44mCzsnAZNhmmx7ZueKqfoJtwdWQQgQuOzCEvH2I5YTsDmYWx+n2cp1bcSTC/PB2GGqPUx76k278CgYEAsLlE02IMeB8Eirvh/FMoViEXjHz+nWNpPnvRXMnZq1qf3g7LuheCNFHBovujbmTQKdLtspsFDjdm44hAvFoPJQ0Yr8pvaeBziUPDzv7wSi+TW5IsKBawmHecfcHlFsYqMhrH/dQNHjhc0xtkgZpBTItXm2oiccyMB8TodWDqW9cCgYEA0UaLBZEtnfafuVffNQozN4NZnW2QHIRq/uz8pGt7yqKpW7yp+1Rirzta/sdDfb/ATl2uelmSk1JXcWP6Kj1UvUHudLdK+u8qyCeJKcTVRE6QQjYae8+u/18xh7kuQtjR+qpoUnNCYP/yHprnYvf+MUsOGHjw2E8NWrh2Uzfd0+ECgYEA3mG2hchu3nj8i5X15agxaDc7q2lZWMvisck+ZJZLJLCHQFQos8LBLRghKGmFfuDwncAzRAGMMSfrGQGQaDZZdI62CjOResHjtdPgtSaGR/+1v7wjRyRJkI60RAXV6IqcZIdmvsZIn0P4yrQTNZHtUUBIWdUhmsOZTlWgMkkqTqU=";
    public static String f9900j = null;
    public static String f9901k = null;
    private static int f9902l = 0;
    private static int f9903m = 0;

    public static Context m13105a() {
        return f9896f;
    }

    public static String m13106a(int i) {
        return i == 1 ? "37C56C" : "33W85X";
    }

    public static String m13107a(String str) {
        String str2 = "";
        try {
            str2 = new StringBuilder(String.valueOf(C2917a.m13105a().getFilesDir().getPath())).append(File.separator).append(str).append(File.separator).toString();
            File file = new File(str2);
            if (!file.exists() || file.isFile()) {
                file.mkdirs();
            }
        } catch (Throwable th) {
        }
        return str2;
    }

    public static void m13108a(Context context) {
        Context applicationContext = context.getApplicationContext();
        f9896f = applicationContext;
        if (applicationContext == null) {
            f9896f = context;
        }
    }

    public static String m13109b() {
        return C2917a.m13107a("parse");
    }

    public static String m13110c() {
        return C2917a.m13107a("parse_temp");
    }

    public static String m13111d() {
        return C3055t.m13711d(C2917a.m13109b(), "parseUtilMain_", "jar");
    }

    public static String m13112e() {
        if (f9895e == null && C2917a.m13105a() != null) {
            f9895e = new StringBuilder(String.valueOf(C2917a.m13105a().getFilesDir().getPath())).append(File.separator).toString();
        }
        return f9895e;
    }

    public static String m13113f() {
        if (f9900j == null) {
            f9900j = C2917a.m13107a(ResUtil.TYPE_DRAWABLE);
        }
        return f9900j;
    }

    public static String m13114g() {
        if (f9901k == null) {
            f9901k = C2917a.m13107a("nqsql");
        }
        return f9901k;
    }

    public static String m13115h() {
        return C2917a.m13109b() + "init.sql";
    }

    public static String m13116i() {
        return C2917a.m13114g() + "menu.sql";
    }
}
