package com.huawei.openalliance.ad.p112a.p117c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1230p;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1233s;
import com.huawei.openalliance.ad.p112a.p123f.C1261a;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.List;

public class C1245a extends Handler {
    private List<C1230p> f2657a;
    private List<C1233s> f2658b;
    private int f2659c;
    private Context f2660d;
    private C1244a f2661e;
    private ArrayList<Integer> f2662f = new ArrayList(4);
    private String f2663g;

    public interface C1244a {
        void mo2432a();

        void mo2435a(Message message);

        void mo2436a(String str);

        void mo2437b();

        void mo2439b(Message message);
    }

    public C1245a(Context context, C1244a c1244a) {
        this.f2660d = context;
        this.f2661e = c1244a;
        this.f2662f.add(Integer.valueOf(1004));
        this.f2662f.add(Integer.valueOf(1005));
        this.f2662f.add(Integer.valueOf(1003));
        this.f2662f.add(Integer.valueOf(1000));
        this.f2662f.add(Integer.valueOf(1001));
        this.f2662f.add(Integer.valueOf(1002));
        this.f2662f.add(Integer.valueOf(1006));
    }

    private void m5523b() {
        if (this.f2657a != null && !this.f2657a.isEmpty()) {
            C1261a.m5582b(this.f2660d, 1, this.f2657a);
        }
    }

    public void m5524a() {
        this.f2662f.add(Integer.valueOf(1007));
    }

    public void handleMessage(Message message) {
        C1336d.m5884a("SplashHandler", "" + message.what);
        if (this.f2662f.contains(Integer.valueOf(message.what))) {
            this.f2662f.remove(new Integer(message.what));
            Object obj;
            switch (message.what) {
                case 1000:
                    this.f2662f.remove(new Integer(1001));
                    this.f2662f.remove(new Integer(1002));
                    this.f2661e.mo2437b();
                    break;
                case 1001:
                    obj = message.obj;
                    if (obj instanceof C1235b) {
                        C1235b c1235b = (C1235b) obj;
                        this.f2657a = c1235b.getPremulticontent__();
                        this.f2658b = c1235b.getSloganList__();
                        this.f2659c = c1235b.getRetcode__();
                        if (!C1261a.m5579a(this.f2660d, c1235b, 1, this)) {
                            sendEmptyMessage(1002);
                            break;
                        }
                    }
                    break;
                case 1002:
                    this.f2662f.remove(new Integer(1000));
                    this.f2662f.remove(new Integer(1001));
                    obj = message.obj;
                    if (obj instanceof String) {
                        this.f2663g = (String) obj;
                    }
                    if (!this.f2662f.contains(new Integer(1007))) {
                        this.f2661e.mo2436a(this.f2663g);
                        break;
                    }
                    break;
                case 1003:
                    this.f2662f.remove(new Integer(1004));
                    this.f2662f.remove(new Integer(1005));
                    this.f2661e.mo2432a();
                    break;
                case 1004:
                    this.f2662f.remove(new Integer(1005));
                    this.f2662f.remove(new Integer(1003));
                    this.f2661e.mo2435a(message);
                    break;
                case 1005:
                    this.f2662f.remove(new Integer(1004));
                    this.f2662f.remove(new Integer(1003));
                    this.f2661e.mo2439b(message);
                    break;
                case 1006:
                    m5523b();
                    C1261a.m5577a(this.f2660d, this.f2659c, this.f2658b);
                    break;
                case 1007:
                    this.f2662f.remove(new Integer(1001));
                    if (!this.f2662f.remove(new Integer(1002))) {
                        this.f2661e.mo2436a(this.f2663g);
                        break;
                    } else {
                        this.f2661e.mo2437b();
                        break;
                    }
            }
            super.handleMessage(message);
        }
    }
}
