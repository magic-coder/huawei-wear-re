package com.huawei.pluginkidwatch.common.ui.wheelview;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* compiled from: WheelBirthdayPicker */
public class C1608i {
    static String f4078a = "WheelBirthdayPicker";
    private static int f4079h = 2000;
    private static int f4080i = 2020;
    int f4081b;
    int f4082c;
    int f4083d;
    private WheelView f4084e;
    private WheelView f4085f;
    private WheelView f4086g;
    private int f4087j;
    private int f4088k;
    private int f4089l;

    public C1608i(WheelView wheelView, WheelView wheelView2, WheelView wheelView3) {
        this.f4084e = wheelView;
        this.f4085f = wheelView2;
        this.f4086g = wheelView3;
        Calendar instance = Calendar.getInstance();
        this.f4087j = instance.get(1);
        this.f4088k = instance.get(2);
        this.f4089l = instance.get(5);
    }

    public boolean m7447a() {
        if (this.f4084e.getCurrentItem() + f4079h > this.f4087j) {
            return false;
        }
        if (this.f4084e.getCurrentItem() + f4079h == this.f4087j) {
            if (this.f4085f.getCurrentItem() > this.f4088k) {
                return false;
            }
            if (this.f4085f.getCurrentItem() == this.f4088k && this.f4086g.getCurrentItem() + 1 > this.f4089l) {
                return false;
            }
        }
        return true;
    }

    public void m7446a(String str, String str2, String str3) {
        this.f4081b = C1492l.m6920d(str.trim());
        String[] strArr = new String[]{"4", "6", CardStatusQueryResponse.DEV_STATUS_LOCK, "11"};
        List asList = Arrays.asList(new String[]{"1", "3", "5", "7", "8", WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD, "12"});
        List asList2 = Arrays.asList(strArr);
        m7435a(str2);
        if (str3.trim().substring(0, 1).equals("0")) {
            this.f4083d = C1492l.m6920d(str3.trim().substring(1));
        } else {
            this.f4083d = C1492l.m6920d(str3.trim());
        }
        String[] strArr2 = new String[(f4080i - f4079h)];
        for (int i = 0; i < f4080i - f4079h; i++) {
            strArr2[i] = (f4079h + i) + "";
        }
        this.f4084e.setAdapter(new C1601a(strArr2));
        this.f4084e.setCyclic(false);
        this.f4084e.setCurrentItem(this.f4081b - f4079h);
        this.f4086g.setCyclic(true);
        m7440b(asList, asList2);
        this.f4086g.setCurrentItem(this.f4083d - 1);
        m7444e();
        m7436a(asList, asList2);
    }

    private void m7436a(List<String> list, List<String> list2) {
        C1603c c1609j = new C1609j(this, list, list2);
        C1603c c1610k = new C1610k(this, list, list2);
        C1603c c1611l = new C1611l(this);
        this.f4084e.m7404a(c1609j);
        this.f4085f.m7404a(c1610k);
        this.f4086g.m7404a(c1611l);
    }

    private void m7444e() {
        this.f4084e.setOnTouchListener(new C1612m(this));
        this.f4085f.setOnTouchListener(new C1613n(this));
        this.f4086g.setOnTouchListener(new C1614o(this));
    }

    private void m7433a(int i, List<String> list, List<String> list2) {
        int i2 = i + 1;
        if (list.contains(String.valueOf(i2))) {
            this.f4086g.setAdapter(new C1602b(1, 31, "%02d"));
        } else if (list2.contains(String.valueOf(i2))) {
            if (this.f4086g.getCurrentItem() == 30) {
                this.f4086g.setCurrentItem(29);
            }
            this.f4086g.setAdapter(new C1602b(1, 30, "%02d"));
        } else {
            m7445f();
        }
        if (this.f4087j > 2000 && !m7447a()) {
            this.f4085f.setCurrentItem(this.f4088k);
            this.f4086g.setCurrentItem(this.f4089l - 1);
        }
    }

    private void m7438b(int i, List<String> list, List<String> list2) {
        int i2 = f4079h + i;
        if (list.contains(String.valueOf(this.f4085f.getCurrentItem() + 1))) {
            this.f4086g.setAdapter(new C1602b(1, 31, "%02d"));
        } else if (list2.contains(String.valueOf(this.f4085f.getCurrentItem() + 1))) {
            this.f4086g.setAdapter(new C1602b(1, 30, "%02d"));
        } else {
            m7432a(i2);
        }
        if (this.f4087j > 2000 && !m7447a()) {
            this.f4084e.setCurrentItem(this.f4087j - f4079h);
            this.f4085f.setCurrentItem(this.f4088k);
            this.f4086g.setCurrentItem(this.f4089l - 1);
        }
    }

    private void m7440b(List<String> list, List<String> list2) {
        if (list.contains(String.valueOf(this.f4082c + 1))) {
            this.f4086g.setAdapter(new C1602b(1, 31, "%02d"));
        } else if (list2.contains(String.valueOf(this.f4082c + 1))) {
            this.f4086g.setAdapter(new C1602b(1, 30, "%02d"));
        } else if ((this.f4081b % 4 != 0 || this.f4081b % 100 == 0) && this.f4081b % HttpStatus.SC_BAD_REQUEST != 0) {
            if (this.f4086g.getCurrentItem() == 28) {
                this.f4086g.setCurrentItem(27);
            }
            this.f4086g.setAdapter(new C1602b(1, 28, "%02d"));
        } else {
            if (this.f4086g.getCurrentItem() == 29) {
                this.f4086g.setCurrentItem(28);
            }
            this.f4086g.setAdapter(new C1602b(1, 29, "%02d"));
        }
    }

    private void m7435a(String str) {
        if (str.trim().substring(0, 1).equals("0")) {
            this.f4082c = C1492l.m6920d(str.trim().substring(1)) - 1;
        } else {
            this.f4082c = C1492l.m6920d(str.trim()) - 1;
        }
        this.f4085f.setAdapter(new C1602b(1, 12, "%02d"));
        this.f4085f.setCyclic(true);
        this.f4085f.setCurrentItem(this.f4082c);
    }

    private void m7445f() {
        if (((this.f4084e.getCurrentItem() + f4079h) % 4 != 0 || (this.f4084e.getCurrentItem() + f4079h) % 100 == 0) && (this.f4084e.getCurrentItem() + f4079h) % HttpStatus.SC_BAD_REQUEST != 0) {
            if (this.f4086g.getCurrentItem() == 30 || this.f4086g.getCurrentItem() == 29 || this.f4086g.getCurrentItem() == 28) {
                this.f4086g.setCurrentItem(27);
            }
            this.f4086g.setAdapter(new C1602b(1, 28, "%02d"));
            return;
        }
        if (this.f4086g.getCurrentItem() == 30 || this.f4086g.getCurrentItem() == 29) {
            this.f4086g.setCurrentItem(28);
        }
        this.f4086g.setAdapter(new C1602b(1, 29, "%02d"));
    }

    private void m7432a(int i) {
        if ((i % 4 != 0 || i % 100 == 0) && i % HttpStatus.SC_BAD_REQUEST != 0) {
            this.f4086g.setAdapter(new C1602b(1, 28, "%02d"));
        } else {
            this.f4086g.setAdapter(new C1602b(1, 29, "%02d"));
        }
    }

    public int m7448b() {
        return this.f4084e.getCurrentItem() + f4079h;
    }

    public int m7449c() {
        return this.f4085f.getCurrentItem() + 1;
    }

    public int m7450d() {
        return this.f4086g.getCurrentItem() + 1;
    }
}
