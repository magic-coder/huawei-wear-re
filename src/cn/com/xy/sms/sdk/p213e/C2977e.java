package cn.com.xy.sms.sdk.p213e;

final class C2977e implements Runnable {
    private final /* synthetic */ String f10086a;
    private final /* synthetic */ String f10087b;
    private final /* synthetic */ String f10088c;
    private final /* synthetic */ Object[] f10089d;

    C2977e(String str, String str2, String str3, Object[] objArr) {
        this.f10086a = str;
        this.f10087b = str2;
        this.f10088c = str3;
        this.f10089d = objArr;
    }

    public final void run() {
        try {
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.LogService");
            if (b != null) {
                b.getMethod("saveLogOut", new Class[]{String.class, String.class, String.class, Object[].class}).invoke(b, new Object[]{this.f10086a, this.f10087b, this.f10088c, C2973a.m13367a(this.f10089d)});
            }
        } catch (Throwable th) {
        }
    }
}
