package com.huawei.android.pushselfshow.richpush.p341c;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.WebView;
import android.widget.ImageView;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.richpush.p341c.p343b.C4180a;
import com.huawei.android.pushselfshow.richpush.p344d.C4193a;
import com.huawei.android.pushselfshow.richpush.p344d.C4194b;
import com.huawei.android.pushselfshow.richpush.p344d.C4196d;
import com.huawei.android.pushselfshow.richpush.p344d.C4197e;
import com.huawei.android.pushselfshow.utils.C4162d;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.android.pushselfshow.utils.C4210c;
import com.huawei.android.pushselfshow.utils.C4211e;
import com.huawei.android.pushselfshow.utils.p346b.C4205b;
import java.io.File;

public class C4179a implements C4162d {
    public C4205b f15720a = null;
    C4210c f15721b = new C4210c(this);
    C4210c f15722c = new C4210c(this);
    private Activity f15723d;
    private WebView f15724e;
    private C4194b f15725f;
    private C4149a f15726g = null;
    private String f15727h;
    private C4180a f15728i;
    private ImageView f15729j;
    private C4190b f15730k;
    private boolean f15731l = false;
    private boolean f15732m = false;
    private AlertDialog f15733n = null;
    private AlertDialog f15734o = null;
    private boolean f15735p = false;

    private void m20355a(Activity activity) {
        this.f15734o = new Builder(activity, C4203a.m20440g(activity)).setTitle(C4211e.m20460a(activity, "hwpush_dialog_limit_title")).setMessage(C4211e.m20460a(activity, "hwpush_dialog_limit_message")).setNegativeButton(17039360, null).setPositiveButton(C4211e.m20460a(activity, "hwpush_dialog_limit_ok"), new C4192d(this)).setOnDismissListener(new C4191c(this, activity)).create();
        this.f15734o.show();
    }

    private void m20358b(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent("com.huawei.android.push.intent.RICHPUSH");
            intent.putExtra("type", "favorite");
            if (this.f15726g != null) {
                intent.putExtra("selfshow_info", this.f15726g.m20262c());
                intent.putExtra("selfshow_token", this.f15726g.m20263d());
            }
            intent.setFlags(268468240);
            intent.putExtra("selfshowMsgOutOfBound", true);
            intent.setPackage(activity.getPackageName());
            activity.finish();
            activity.startActivity(intent);
        }
    }

    public void m20362a() {
        e.a("PushSelfShowLog", "downLoadFailed:");
        this.f15722c = null;
        m20364a(C4203a.m20419a(this.f15723d, "富媒体文件下载失败", "Failed to load the message."));
    }

    public void mo4386a(Message message) {
        e.a("PushSelfShowLog", "handleMessage " + message.what + "," + message.toString());
        switch (message.what) {
            case 1:
                m20366c((String) message.obj);
                return;
            case 2:
                m20362a();
                return;
            case 1000:
                m20355a(this.f15723d);
                return;
            default:
                return;
        }
    }

    public void m20364a(String str) {
        try {
            String a = new C4196d(this.f15723d, str).m20385a();
            e.a("PushSelfShowLog", "showErrorHtmlURI,filePath is " + a);
            if (a != null && a.length() > 0) {
                Uri fromFile = Uri.fromFile(new File(a));
                m20365b(null);
                this.f15724e.loadUrl(fromFile.toString());
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "showErrorHtmlURI failed", e);
        }
        if (C4203a.m20419a(this.f15723d, "富媒体文件下载失败", "Failed to load the message.").equals(str)) {
            C4203a.m20424a(this.f15723d, "12", this.f15726g);
        } else {
            C4203a.m20424a(this.f15723d, "6", this.f15726g);
        }
    }

    public void m20365b(String str) {
        try {
            e.a("PushSelfShowLog", "enable JavaJs support and indexFileUrl is " + str);
            String str2 = null;
            if (str != null) {
                str2 = str.substring(0, str.lastIndexOf("/"));
            }
            e.a("PushSelfShowLog", "m_activity is " + this.f15723d);
            e.a("PushSelfShowLog", "webView is " + this.f15724e);
            e.a("PushSelfShowLog", "localPath is " + str2);
            if (this.f15726g.f15566G != 0) {
                e.a("PushSelfShowLog", "pushmsg.needUserId true");
                this.f15728i = new C4180a(this.f15723d, this.f15724e, str2, true);
            } else {
                e.a("PushSelfShowLog", "pushmsg.needUserId false");
                this.f15728i = new C4180a(this.f15723d, this.f15724e, str2, false);
            }
            this.f15724e.addJavascriptInterface(new C4193a(), "console");
            this.f15724e.addJavascriptInterface(this.f15728i, "_nativeApi");
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "enable JavaJs support failed ", e);
        }
    }

    public void m20366c(String str) {
        try {
            e.a("PushSelfShowLog", "downLoadSuccess:" + str + "，and start loadLocalZip");
            m20367d(str);
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "downLoadSuccess failed", e);
        }
    }

    public void m20367d(String str) {
        if (str != null && str.length() > 0) {
            this.f15727h = C4197e.m20386a(this.f15723d, str);
            if (this.f15727h == null || this.f15727h.length() <= 0) {
                e.d("PushSelfShowLog", "check index.html file failed");
                this.f15722c = null;
            } else {
                Uri fromFile = Uri.fromFile(new File(this.f15727h));
                m20365b(this.f15727h);
                this.f15726g.f15562C = fromFile.toString();
                this.f15726g.f15564E = "text/html_local";
                this.f15725f.m20381a(this.f15726g);
                this.f15724e.loadUrl(fromFile.toString());
                return;
            }
        }
        m20364a(C4203a.m20419a(this.f15723d, "富媒体内容不正确", "Invalid content."));
    }
}
