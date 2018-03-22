package cn.com.xy.sms.sdk.p220j.p221a;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.Callable;

public final class C3016a implements Callable<Map<String, Object>> {
    Context f10179a;
    String f10180b;
    String f10181c;
    String f10182d;
    long f10183e;
    Map<String, String> f10184f;
    Thread f10185g = null;

    public final void m13542a() {
        this.f10179a = null;
        this.f10180b = null;
        this.f10181c = null;
        this.f10182d = null;
        this.f10183e = 0;
        this.f10184f = null;
        this.f10185g = null;
    }

    public final /* synthetic */ Object call() {
        this.f10185g = Thread.currentThread();
        return C3017b.m13543a(this.f10179a, this.f10180b, this.f10181c, this.f10182d, this.f10183e, this.f10184f);
    }
}
