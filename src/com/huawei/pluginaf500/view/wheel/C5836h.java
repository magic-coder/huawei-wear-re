package com.huawei.pluginaf500.view.wheel;

/* compiled from: WheelRemindSportPicker */
public class C5836h {
    private static final String f20091a = "WheelRemindSportPicker".toString();
    private WheelView f20092b;
    private int f20093c;

    public C5836h(WheelView wheelView) {
        this.f20092b = wheelView;
    }

    public void m26985a(String str) {
        this.f20093c = (Integer.parseInt(str.trim()) / 15) - 1;
        this.f20092b.setAdapter(new C5831a(new String[]{"15", "30", "45", "60", "75", "90", "105", "120"}));
        this.f20092b.setCyclic(true);
        this.f20092b.setCurrentItem(this.f20093c);
        this.f20092b.setHanziFontFlag(false);
        this.f20092b.m26967a(new C5837i(this));
        this.f20092b.f20056a = (float) 30;
    }
}
