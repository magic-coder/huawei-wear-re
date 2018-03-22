package com.tencent.open.p532d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6286a;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class C6397j extends Thread {
    final /* synthetic */ C6284w f22230a;
    final /* synthetic */ Context f22231b;
    final /* synthetic */ String f22232c;
    final /* synthetic */ Bundle f22233d;
    final /* synthetic */ String f22234e;
    final /* synthetic */ C6286a f22235f;

    C6397j(C6284w c6284w, Context context, String str, Bundle bundle, String str2, C6286a c6286a) {
        this.f22230a = c6284w;
        this.f22231b = context;
        this.f22232c = str;
        this.f22233d = bundle;
        this.f22234e = str2;
        this.f22235f = c6286a;
    }

    public void run() {
        try {
            JSONObject a = C6396i.m29196a(this.f22230a, this.f22231b, this.f22232c, this.f22233d, this.f22234e);
            if (this.f22235f != null) {
                this.f22235f.mo5299a(a);
                C6367n.m29107b("openSDK_LOG", "OpenApi onComplete");
            }
        } catch (MalformedURLException e) {
            if (this.f22235f != null) {
                this.f22235f.mo5295a(e);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync MalformedURLException", e);
            }
        } catch (ConnectTimeoutException e2) {
            if (this.f22235f != null) {
                this.f22235f.mo5297a(e2);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync onConnectTimeoutException", e2);
            }
        } catch (SocketTimeoutException e3) {
            if (this.f22235f != null) {
                this.f22235f.mo5296a(e3);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync onSocketTimeoutException", e3);
            }
        } catch (C6402o e4) {
            if (this.f22235f != null) {
                this.f22235f.mo5292a(e4);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync onNetworkUnavailableException", e4);
            }
        } catch (C6399l e5) {
            if (this.f22235f != null) {
                this.f22235f.mo5291a(e5);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync onHttpStatusException", e5);
            }
        } catch (IOException e6) {
            if (this.f22235f != null) {
                this.f22235f.mo5293a(e6);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync IOException", e6);
            }
        } catch (JSONException e7) {
            if (this.f22235f != null) {
                this.f22235f.mo5298a(e7);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync JSONException", e7);
            }
        } catch (Exception e8) {
            if (this.f22235f != null) {
                this.f22235f.mo5294a(e8);
                C6367n.m29108b("openSDK_LOG", "OpenApi requestAsync onUnknowException", e8);
            }
        }
    }
}
