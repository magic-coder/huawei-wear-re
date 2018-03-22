package com.aps;

import java.util.List;

public final class bx {
    private boolean f13078a = false;
    private String f13079b = "";
    private boolean f13080c = false;
    private double f13081d = 0.0d;
    private double f13082e = 0.0d;

    protected bx(List list, String str, String str2, String str3) {
        this.f13079b = str3;
        m17467d();
    }

    private void m17467d() {
        int i;
        boolean z;
        String substring;
        String[] split;
        int i2 = 0;
        String str = this.f13079b;
        if (str != null && str.length() > 8) {
            int i3 = 0;
            for (i = 1; i < str.length() - 3; i++) {
                i3 ^= str.charAt(i);
            }
            if (Integer.toHexString(i3).equalsIgnoreCase(str.substring(str.length() - 2, str.length()))) {
                z = true;
                if (z) {
                    substring = this.f13079b.substring(0, this.f13079b.length() - 3);
                    i = 0;
                    while (i2 < substring.length()) {
                        if (substring.charAt(i2) == ',') {
                            i++;
                        }
                        i2++;
                    }
                    split = substring.split(",", i + 1);
                    if (split.length < 6) {
                        if (!(split[2].equals("") || split[split.length - 3].equals("") || split[split.length - 2].equals("") || split[split.length - 1].equals(""))) {
                            Integer.valueOf(split[2]).intValue();
                            this.f13081d = Double.valueOf(split[split.length - 3]).doubleValue();
                            this.f13082e = Double.valueOf(split[split.length - 2]).doubleValue();
                            this.f13080c = true;
                        }
                    } else {
                        return;
                    }
                }
                this.f13078a = this.f13080c;
            }
        }
        z = false;
        if (z) {
            substring = this.f13079b.substring(0, this.f13079b.length() - 3);
            i = 0;
            while (i2 < substring.length()) {
                if (substring.charAt(i2) == ',') {
                    i++;
                }
                i2++;
            }
            split = substring.split(",", i + 1);
            if (split.length < 6) {
                Integer.valueOf(split[2]).intValue();
                this.f13081d = Double.valueOf(split[split.length - 3]).doubleValue();
                this.f13082e = Double.valueOf(split[split.length - 2]).doubleValue();
                this.f13080c = true;
            } else {
                return;
            }
        }
        this.f13078a = this.f13080c;
    }

    protected final boolean m17468a() {
        return this.f13078a;
    }

    protected final double m17469b() {
        return this.f13081d;
    }

    protected final double m17470c() {
        return this.f13082e;
    }
}
