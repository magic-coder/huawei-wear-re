package com.huawei.ui.commonui.wheelview;

import android.support.annotation.NonNull;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.ui.commonui.wheelview.p515a.C6054a;
import com.huawei.ui.commonui.wheelview.p515a.C6055b;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* compiled from: WheelCalendarPicker */
public class C6069o {
    private static int f20960g = 1900;
    private static int f20961h = 2100;
    int f20962a;
    int f20963b;
    int f20964c;
    private WheelView f20965d;
    private WheelView f20966e;
    private WheelView f20967f;
    private int f20968i;
    private int f20969j;
    private int f20970k;
    private C5691c f20971l = null;

    public C6069o(WheelView wheelView, WheelView wheelView2, WheelView wheelView3) {
        this.f20965d = wheelView;
        this.f20966e = wheelView2;
        this.f20967f = wheelView3;
        Calendar instance = Calendar.getInstance();
        this.f20968i = instance.get(1);
        this.f20969j = instance.get(2);
        this.f20970k = instance.get(5);
    }

    public void m27757a(C5691c c5691c) {
        this.f20971l = c5691c;
    }

    public void m27756a(int i, int i2, int i3) {
        String[] strArr = new String[]{"4", "6", CardStatusQueryResponse.DEV_STATUS_LOCK, "11"};
        List asList = Arrays.asList(new String[]{"1", "3", "5", "7", "8", WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD, "12"});
        List asList2 = Arrays.asList(strArr);
        m27743a(i, i2, i3, asList, asList2);
        C5691c b = m27745b(asList, asList2);
        C5691c a = m27742a(asList, asList2);
        C5691c e = m27752e();
        m27753f();
        this.f20965d.m27702a(b);
        this.f20966e.m27702a(a);
        this.f20967f.m27702a(e);
    }

    @NonNull
    private C5691c m27752e() {
        return new C6070p(this);
    }

    @NonNull
    private C5691c m27742a(List<String> list, List<String> list2) {
        return new C6071q(this, list, list2);
    }

    private void m27753f() {
        this.f20965d.setOnTouchListener(new C6072r(this));
        this.f20966e.setOnTouchListener(new C6073s(this));
        this.f20967f.setOnTouchListener(new C6074t(this));
    }

    @NonNull
    private C5691c m27745b(List<String> list, List<String> list2) {
        return new C6075u(this, list, list2);
    }

    private void m27743a(int i, int i2, int i3, List<String> list, List<String> list2) {
        this.f20962a = i;
        this.f20963b = i2;
        this.f20964c = i3;
        String[] strArr = new String[(f20961h - f20960g)];
        for (int i4 = 0; i4 < f20961h - f20960g; i4++) {
            strArr[i4] = (f20960g + i4) + "";
        }
        this.f20965d.setAdapter(new C6054a(strArr));
        this.f20965d.setCyclic(false);
        this.f20965d.setCurrentItem(this.f20962a - f20960g);
        this.f20966e.setAdapter(new C6055b(1, 12, "%02d"));
        this.f20966e.setCyclic(true);
        this.f20966e.setCurrentItem(this.f20963b);
        this.f20967f.setCyclic(true);
        if (list.contains(String.valueOf(this.f20963b + 1))) {
            this.f20967f.setAdapter(new C6055b(1, 31, "%02d"));
        } else if (list2.contains(String.valueOf(this.f20963b + 1))) {
            this.f20967f.setAdapter(new C6055b(1, 30, "%02d"));
        } else if ((this.f20962a % 4 != 0 || this.f20962a % 100 == 0) && this.f20962a % HttpStatus.SC_BAD_REQUEST != 0) {
            this.f20967f.setAdapter(new C6055b(1, 28, "%02d"));
        } else {
            this.f20967f.setAdapter(new C6055b(1, 29, "%02d"));
        }
        this.f20967f.setCurrentItem(this.f20964c - 1);
    }

    public void m27760b(int i, int i2, int i3) {
        String[] strArr = new String[]{"4", "6", CardStatusQueryResponse.DEV_STATUS_LOCK, "11"};
        List asList = Arrays.asList(new String[]{"1", "3", "5", "7", "8", WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD, "12"});
        List asList2 = Arrays.asList(strArr);
        m27746b(i, i2, i3, asList, asList2);
        C5691c d = m27751d(asList, asList2);
        C5691c c = m27748c(asList, asList2);
        C5691c g = m27754g();
        m27753f();
        this.f20965d.m27702a(d);
        this.f20966e.m27702a(c);
        this.f20967f.m27702a(g);
    }

    @NonNull
    private C5691c m27754g() {
        return new C6076v(this);
    }

    @NonNull
    private C5691c m27748c(List<String> list, List<String> list2) {
        return new C6077w(this, list, list2);
    }

    @NonNull
    private C5691c m27751d(List<String> list, List<String> list2) {
        return new C6078x(this, list, list2);
    }

    private void m27746b(int i, int i2, int i3, List<String> list, List<String> list2) {
        this.f20962a = i;
        this.f20963b = i2;
        this.f20964c = i3;
        String[] strArr = new String[(2100 - f20960g)];
        for (int i4 = 0; i4 < 2100 - f20960g; i4++) {
            strArr[i4] = (f20960g + i4) + "";
        }
        this.f20965d.setAdapter(new C6054a(strArr));
        this.f20965d.setCyclic(false);
        this.f20965d.setCurrentItem(this.f20962a - f20960g);
        this.f20966e.setAdapter(new C6055b(1, 12, "%02d"));
        this.f20966e.setCyclic(true);
        this.f20966e.setCurrentItem(this.f20963b);
        this.f20967f.setCyclic(true);
        if (list.contains(String.valueOf(this.f20963b + 1))) {
            this.f20967f.setAdapter(new C6055b(1, 31, "%02d"));
        } else if (list2.contains(String.valueOf(this.f20963b + 1))) {
            this.f20967f.setAdapter(new C6055b(1, 30, "%02d"));
        } else if ((this.f20962a % 4 != 0 || this.f20962a % 100 == 0) && this.f20962a % HttpStatus.SC_BAD_REQUEST != 0) {
            this.f20967f.setAdapter(new C6055b(1, 28, "%02d"));
        } else {
            this.f20967f.setAdapter(new C6055b(1, 29, "%02d"));
        }
        this.f20967f.setCurrentItem(this.f20964c - 1);
    }

    public void m27758a(String str, String str2, String str3) {
        this.f20962a = Integer.parseInt(str.trim());
        if (str2.trim().substring(0, 1).equals("0")) {
            this.f20963b = Integer.parseInt(str2.trim().substring(1)) - 1;
        } else {
            this.f20963b = Integer.parseInt(str2.trim()) - 1;
        }
        if (str3.trim().substring(0, 1).equals("0")) {
            this.f20964c = Integer.parseInt(str3.trim().substring(1));
        } else {
            this.f20964c = Integer.parseInt(str3.trim());
        }
        m27756a(this.f20962a, this.f20963b, this.f20964c);
    }

    public void m27761b(String str, String str2, String str3) {
        this.f20962a = Integer.parseInt(str.trim());
        if (str2.trim().substring(0, 1).equals("0")) {
            this.f20963b = Integer.parseInt(str2.trim().substring(1)) - 1;
        } else {
            this.f20963b = Integer.parseInt(str2.trim()) - 1;
        }
        if (str3.trim().substring(0, 1).equals("0")) {
            this.f20964c = Integer.parseInt(str3.trim().substring(1));
        } else {
            this.f20964c = Integer.parseInt(str3.trim());
        }
        m27760b(this.f20962a, this.f20963b, this.f20964c);
    }

    public int m27755a() {
        return this.f20965d.getCurrentItem() + f20960g;
    }

    public int m27759b() {
        return this.f20966e.getCurrentItem() + 1;
    }

    public int m27762c() {
        return this.f20967f.getCurrentItem() + 1;
    }
}
