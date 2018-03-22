package cmb.pb.ui.cmbwidget;

import cmb.pb.p203a.C2858a;
import cmb.pb.p203a.C2859b;
import java.security.Key;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.KeyGenerator;

public final class C2870e {
    private int f9313a = 0;
    private Key f9314b = null;
    private List f9315c = null;

    public C2870e(int i, String str) {
        int i2 = 0;
        this.f9313a = i;
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(new SecureRandom());
            this.f9314b = instance.generateKey();
            this.f9315c = new ArrayList();
            if (!C2858a.m12951b(str)) {
                while (i2 < str.length()) {
                    m13007a(this.f9315c.size(), str.substring(i2, i2 + 1));
                    i2++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int m13005a() {
        return this.f9315c.size();
    }

    public final void m13006a(int i) {
        if (i > 0 && this.f9315c != null && this.f9315c != null) {
            this.f9315c.remove(i - 1);
        }
    }

    public final void m13007a(int i, String str) {
        if (this.f9315c != null && this.f9315c.size() < this.f9313a && !C2858a.m12951b(str) && this.f9314b != null) {
            String a = C2859b.m12952a(str, this.f9314b);
            if (!C2858a.m12951b(a)) {
                this.f9315c.add(i, a);
            }
        }
    }

    public final String m13008b() {
        if (this.f9314b == null || this.f9315c == null || this.f9315c.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f9315c.size(); i++) {
            String b = C2859b.m12953b((String) this.f9315c.get(i), this.f9314b);
            if (C2858a.m12951b(b)) {
                return null;
            }
            stringBuilder.append(b);
        }
        return stringBuilder.toString();
    }

    public final void m13009c() {
        if (this.f9315c != null) {
            this.f9315c.clear();
        }
    }
}
