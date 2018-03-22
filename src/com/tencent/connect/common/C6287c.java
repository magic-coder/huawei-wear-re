package com.tencent.connect.common;

import android.os.Handler;
import android.os.Message;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6399l;
import com.tencent.open.p532d.C6402o;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6286a;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6287c implements C6286a {
    final /* synthetic */ C6245a f21870a;
    private final C6252b f21871b;
    private final Handler f21872c;

    public C6287c(C6245a c6245a, C6252b c6252b) {
        this.f21870a = c6245a;
        this.f21871b = c6252b;
        this.f21872c = new C6288d(this, C6395h.m29184a().getMainLooper(), c6245a);
    }

    public void mo5299a(JSONObject jSONObject) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = jSONObject;
        obtainMessage.what = 0;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5293a(IOException iOException) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = iOException.getMessage();
        obtainMessage.what = -2;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5295a(MalformedURLException malformedURLException) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = malformedURLException.getMessage();
        obtainMessage.what = -3;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5298a(JSONException jSONException) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = jSONException.getMessage();
        obtainMessage.what = -4;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5297a(ConnectTimeoutException connectTimeoutException) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = connectTimeoutException.getMessage();
        obtainMessage.what = -7;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5296a(SocketTimeoutException socketTimeoutException) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = socketTimeoutException.getMessage();
        obtainMessage.what = -8;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5292a(C6402o c6402o) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = c6402o.getMessage();
        obtainMessage.what = -10;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5291a(C6399l c6399l) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = c6399l.getMessage();
        obtainMessage.what = -9;
        this.f21872c.sendMessage(obtainMessage);
    }

    public void mo5294a(Exception exception) {
        Message obtainMessage = this.f21872c.obtainMessage();
        obtainMessage.obj = exception.getMessage();
        obtainMessage.what = -6;
        this.f21872c.sendMessage(obtainMessage);
    }
}
