package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: InputtipsHandler */
public class C3413h extends C3387r<C3414i, ArrayList<Tip>> {
    protected /* synthetic */ Object mo4102b(String str) throws AMapException {
        return mo4100a(str);
    }

    public C3413h(Context context, C3414i c3414i) {
        super(context, c3414i);
    }

    protected ArrayList<Tip> mo4100a(String str) throws AMapException {
        ArrayList<Tip> arrayList = null;
        try {
            arrayList = C3415j.m16946o(new JSONObject(str));
        } catch (Throwable e) {
            C3409d.m16881a(e, "InputtipsHandler", "paseJSON");
        }
        return arrayList;
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/assistant/inputtips?";
    }

    protected String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&keywords=").append(m16574c(((C3414i) this.a).f12481a));
        String str = ((C3414i) this.a).f12482b;
        if (!C3415j.m16935h(str)) {
            stringBuffer.append("&city=").append(m16574c(str));
        }
        stringBuffer.append("&key=").append(C3434w.m16993f(this.d));
        stringBuffer.append("&language=").append(C3408c.m16875b());
        return stringBuffer.toString();
    }
}
