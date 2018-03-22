package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.io.File;

final class C3058w implements Runnable {
    C3058w() {
    }

    public final void run() {
        try {
            String b = C2917a.m13109b();
            if (!C3049n.m13653e(b)) {
                File[] listFiles = new File(b).listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File absolutePath : listFiles) {
                        C3050o.m13680b("640", absolutePath.getAbsolutePath());
                    }
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "chJarmod =" + th.getMessage(), th);
        }
    }
}
