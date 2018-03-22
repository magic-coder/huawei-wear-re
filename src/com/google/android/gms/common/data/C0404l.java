package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class C0404l<T> extends C0394a<T> {
    private boolean f330b = false;
    private ArrayList<Integer> f331c;

    protected C0404l(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void m479e() {
        synchronized (this) {
            if (!this.f330b) {
                int count = this.a.getCount();
                this.f331c = new ArrayList();
                if (count > 0) {
                    this.f331c.add(Integer.valueOf(0));
                    String c = mo2046c();
                    String zzd = this.a.zzd(c, 0, this.a.zzcI(0));
                    int i = 1;
                    while (i < count) {
                        int zzcI = this.a.zzcI(i);
                        String zzd2 = this.a.zzd(c, i, zzcI);
                        if (zzd2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(c).length() + 78).append("Missing value for markerColumn: ").append(c).append(", at row: ").append(i).append(", for window: ").append(zzcI).toString());
                        }
                        if (zzd2.equals(zzd)) {
                            zzd2 = zzd;
                        } else {
                            this.f331c.add(Integer.valueOf(i));
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.f330b = true;
            }
        }
    }

    public final T mo1752a(int i) {
        m479e();
        return mo2045a(m483b(i), m484c(i));
    }

    protected abstract T mo2045a(int i, int i2);

    public int mo1751b() {
        m479e();
        return this.f331c.size();
    }

    int m483b(int i) {
        if (i >= 0 && i < this.f331c.size()) {
            return ((Integer) this.f331c.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected int m484c(int i) {
        if (i < 0 || i == this.f331c.size()) {
            return 0;
        }
        int count = i == this.f331c.size() + -1 ? this.a.getCount() - ((Integer) this.f331c.get(i)).intValue() : ((Integer) this.f331c.get(i + 1)).intValue() - ((Integer) this.f331c.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int b = m483b(i);
        int zzcI = this.a.zzcI(b);
        String d = m486d();
        return (d == null || this.a.zzd(d, b, zzcI) != null) ? count : 0;
    }

    protected abstract String mo2046c();

    protected String m486d() {
        return null;
    }
}
