package cn.com.xy.sms.sdk.p213e;

final class C2976d implements Runnable {
    private final /* synthetic */ String f10082a;
    private final /* synthetic */ String f10083b;
    private final /* synthetic */ String f10084c;
    private final /* synthetic */ Object[] f10085d;

    C2976d(String str, String str2, String str3, Object[] objArr) {
        this.f10082a = str;
        this.f10083b = str2;
        this.f10084c = str3;
        this.f10085d = objArr;
    }

    public final void run() {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.LogService");
            if (b != null) {
                b.getMethod("saveLogIn", new Class[]{String.class, String.class, String.class, Object[].class}).invoke(b, new Object[]{this.f10082a, this.f10083b, this.f10084c, C2973a.m13367a(this.f10085d)});
            }
        } catch (Throwable th) {
        }
    }
}
