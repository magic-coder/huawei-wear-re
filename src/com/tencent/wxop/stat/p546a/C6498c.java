package com.tencent.wxop.stat.p546a;

import android.content.Context;
import com.tencent.wxop.stat.C6547y;
import com.tencent.wxop.stat.p547b.C6509d;
import com.tencent.wxop.stat.p547b.C6523r;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public final class C6498c extends C6495d {
    private String f22577a;
    private int f22578m;
    private int f22579n = 100;
    private Thread f22580o = null;

    public C6498c(Context context, int i, Throwable th, C6547y c6547y) {
        super(context, i, c6547y);
        m29639a(99, th);
    }

    public C6498c(Context context, int i, Throwable th, Thread thread) {
        super(context, i, null);
        m29639a(2, th);
        this.f22580o = thread;
    }

    private void m29639a(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.f22577a = stringWriter.toString();
            this.f22578m = i;
            printWriter.close();
        }
    }

    public final boolean mo5347a(JSONObject jSONObject) {
        C6523r.m29785a(jSONObject, "er", this.f22577a);
        jSONObject.put("ea", this.f22578m);
        if (this.f22578m == 2 || this.f22578m == 3) {
            new C6509d(this.l).m29717a(jSONObject, this.f22580o);
        }
        return true;
    }

    public final C6499e mo5348b() {
        return C6499e.ERROR;
    }
}
