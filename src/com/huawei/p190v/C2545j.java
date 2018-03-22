package com.huawei.p190v;

import android.util.Log;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: LogUtil */
class C2545j implements C2536a {
    public Queue<String> f9063a = new LinkedList();
    private C2536a f9064b = null;

    C2545j(C2536a c2536a) {
        this.f9064b = c2536a;
    }

    public boolean mo2672a(File file, String str, boolean z) {
        m12698b(file, z);
        if (this.f9063a.size() != 0) {
            return m12697a(str, z);
        }
        boolean a = this.f9064b.mo2672a(file, str, z);
        if (a) {
            return a;
        }
        return m12697a(str, z);
    }

    public void mo2671a(File file, boolean z) {
        m12698b(file, z);
    }

    private boolean m12698b(File file, boolean z) {
        do {
            String str = (String) this.f9063a.peek();
            if (str == null) {
                return true;
            }
            if (!this.f9064b.mo2672a(file, str, z)) {
                Log.w("LogUtil", "  writeDelayStr failed,restore for further try");
                return false;
            }
        } while (this.f9063a.poll() != null);
        Log.w("LogUtil", "  writeDelayStr failed,poll error,be carefull");
        return false;
    }

    private boolean m12697a(String str, boolean z) {
        if (this.f9063a.size() >= 16 && this.f9063a.poll() == null) {
            Log.w("LogUtil", "  writeDelayStr failed,poll error,be carefull");
            return false;
        } else if (this.f9063a.offer(str)) {
            return true;
        } else {
            return false;
        }
    }
}
