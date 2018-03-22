package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.p544a.C6443b;
import com.tencent.stat.p544a.C6444a;
import java.io.File;
import java.util.Iterator;

class C6482p implements Runnable {
    private Context f22528a = null;

    public C6482p(Context context) {
        this.f22528a = context;
    }

    public void run() {
        Iterator it = C6472e.m29549b(this.f22528a).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            C6443b c6444a = new C6444a(this.f22528a, C6474g.m29552a(this.f22528a, false), C6472e.m29547a(file), 3, 10240);
            c6444a.m29369a(C6472e.m29548b(file));
            if (C6474g.m29560c(this.f22528a) != null) {
                C6474g.m29560c(this.f22528a).post(new C6484r(c6444a));
            }
            file.delete();
            C6474g.f22503i.m29413h("delete tombstone file:" + file.getAbsolutePath().toString());
        }
    }
}
