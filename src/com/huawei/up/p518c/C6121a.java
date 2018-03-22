package com.huawei.up.p518c;

import android.content.Context;
import android.os.Bundle;
import com.huawei.up.p404b.C4694a;
import com.huawei.up.p519d.C6126c;
import com.huawei.up.p520e.C6127a;
import com.huawei.up.p520e.C6134h;
import java.io.IOException;
import java.security.SecureRandom;
import org.apache.http.HttpResponse;

/* compiled from: UserInfoManager */
public class C6121a {
    private String m27884a(String str, String str2, String str3) {
        String str4 = System.currentTimeMillis() + ":" + new SecureRandom().nextInt(1000);
        return "Digest user=" + str3 + ",nonce=" + str4 + ",response=" + C6127a.m27905a(str4 + ":" + str, str2);
    }

    public void m27885a(Context context, String str, C4694a c4694a) throws IOException {
        C6126c c6126c = new C6126c(context, str, context.getPackageName(), "0", C6134h.m27924b(context), "39000000");
        HttpResponse a = c6126c.m27890a(c6126c.m27904a());
        if (a != null) {
            Bundle a2 = c6126c.m27903a(a);
            if (c4694a != null) {
                c4694a.mo4558a(a2);
            }
        } else if (c4694a != null) {
            c4694a.mo4557a(-1);
        }
    }

    public void m27886a(Context context, String str, String str2, String str3, String str4, C4694a c4694a) {
        try {
            m27885a(context, str2, new C6122b(this, str2, str, context, str3, str4, c4694a));
        } catch (IOException e) {
            if (c4694a != null) {
                c4694a.mo4557a(-1);
            }
        }
    }
}
