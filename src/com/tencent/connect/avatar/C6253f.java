package com.tencent.connect.avatar;

import android.content.Context;
import android.content.Intent;
import com.tencent.open.p542b.C6375d;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6253f implements C6252b {
    final /* synthetic */ ImageActivity f21762a;

    C6253f(ImageActivity imageActivity) {
        this.f21762a = imageActivity;
    }

    public void mo5287a(C6494d c6494d) {
        this.f21762a.f21738g.setEnabled(true);
        this.f21762a.f21738g.setTextColor(-1);
        this.f21762a.f21737f.setEnabled(true);
        this.f21762a.f21737f.setTextColor(-1);
        this.f21762a.f21737f.setText("重试");
        this.f21762a.f21741j.setVisibility(8);
        this.f21762a.f21743l = true;
        this.f21762a.m28726a(c6494d.f22558b, 1);
        this.f21762a.m28752a("10660", 0);
    }

    public void mo5288a(Object obj) {
        int i;
        this.f21762a.f21738g.setEnabled(true);
        this.f21762a.f21738g.setTextColor(-1);
        this.f21762a.f21737f.setEnabled(true);
        this.f21762a.f21737f.setTextColor(-1);
        this.f21762a.f21741j.setVisibility(8);
        JSONObject jSONObject = (JSONObject) obj;
        try {
            i = jSONObject.getInt("ret");
        } catch (JSONException e) {
            e.printStackTrace();
            i = -1;
        }
        if (i == 0) {
            this.f21762a.m28726a("设置成功", 0);
            this.f21762a.m28752a("10658", 0);
            C6375d.m29144a().m29146a(this.f21762a.f21733b.m28852d(), this.f21762a.f21733b.m28849b(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "3", "0");
            Context context = this.f21762a;
            if (!(this.f21762a.f21734c == null || "".equals(this.f21762a.f21734c))) {
                Intent intent = new Intent();
                intent.setClassName(context, this.f21762a.f21734c);
                if (context.getPackageManager().resolveActivity(intent, 0) != null) {
                    context.startActivity(intent);
                }
            }
            this.f21762a.m28722a(0, jSONObject.toString(), null, null);
            this.f21762a.m28739d();
            return;
        }
        this.f21762a.m28726a("设置出错了，请重新登录再尝试下呢：）", 1);
        C6375d.m29144a().m29146a(this.f21762a.f21733b.m28852d(), this.f21762a.f21733b.m28849b(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "1");
    }

    public void mo5286a() {
    }
}
