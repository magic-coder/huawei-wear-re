package com.tencent.connect.avatar;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.connect.common.C6245a;
import com.tencent.connect.common.C6287c;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6396i;
import com.tencent.open.p542b.C6375d;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6286a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.apache.http.client.methods.HttpPost;

/* compiled from: ProGuard */
class C6256i extends C6245a {
    final /* synthetic */ ImageActivity f21766a;

    public C6256i(ImageActivity imageActivity, C6284w c6284w) {
        this.f21766a = imageActivity;
        super(c6284w);
    }

    public void m28763a(Bitmap bitmap, C6252b c6252b) {
        Bundle c = m28713c();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 40, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        bitmap.recycle();
        C6286a c6287c = new C6287c(this, c6252b);
        c.putByteArray("picture", toByteArray);
        C6396i.m29198a(this.c, C6395h.m29184a(), "user/set_user_face", c, HttpPost.METHOD_NAME, c6287c);
        C6375d.m29144a().m29146a(this.c.m28852d(), this.c.m28849b(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "0");
    }
}
