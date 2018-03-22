package com.tencent.stat.p544a;

import android.content.Context;
import com.tencent.stat.C6470c;
import com.tencent.stat.p545b.C6463m;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public class C6444a extends C6443b {
    private String f22344k;
    private int f22345l;
    private int f22346m = 100;

    public C6444a(Context context, int i, int i2, Throwable th) {
        super(context, i);
        if (th != null) {
            Throwable th2 = new Throwable(th);
            try {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                if (stackTrace != null && stackTrace.length > this.f22346m) {
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[this.f22346m];
                    for (int i3 = 0; i3 < this.f22346m; i3++) {
                        stackTraceElementArr[i3] = stackTrace[i3];
                    }
                    th2.setStackTrace(stackTraceElementArr);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            this.f22344k = stringWriter.toString();
            this.f22345l = i2;
            printWriter.close();
        }
    }

    public C6444a(Context context, int i, String str, int i2, int i3) {
        super(context, i);
        if (str != null) {
            if (i3 <= 0) {
                i3 = C6470c.m29537t();
            }
            if (str.length() <= i3) {
                this.f22344k = str;
            } else {
                this.f22344k = str.substring(0, i3);
            }
        }
        this.f22345l = i2;
    }

    public C6445c mo5342a() {
        return C6445c.ERROR;
    }

    public void m29369a(long j) {
        this.b = j;
    }

    public boolean mo5343a(JSONObject jSONObject) {
        C6463m.m29445a(jSONObject, "er", this.f22344k);
        jSONObject.put("ea", this.f22345l);
        return true;
    }
}
