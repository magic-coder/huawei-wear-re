package com.huawei.feedback.logic;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.feedback.b;
import com.huawei.feedback.bean.C4409c;
import com.huawei.feedback.bean.C4410d;
import com.huawei.feedback.component.ProgressService;
import com.huawei.feedback.d;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.lcagent.client.LogMetricInfo;
import com.huawei.lcagent.client.MetricConstant;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* compiled from: FeedbackSubmitTask */
public class C4418i implements Runnable {
    LogCollectManager f16405a = null;
    LogMetricInfo f16406b = null;
    private C4409c f16407c = null;
    private boolean f16408d = false;
    private C4410d f16409e = null;
    private int f16410f = 0;
    private Context f16411g;
    private int f16412h = 1;
    private Handler f16413i;
    private boolean f16414j = false;
    private String f16415k;
    private String f16416l;
    private String f16417m;
    private String f16418n;
    private String f16419o;
    private Handler f16420p = new C4419j(this);

    public C4418i(C4409c c4409c, int i, Context context, String str, String str2) {
        this.f16407c = c4409c;
        this.f16410f = i;
        this.f16411g = context;
        this.f16415k = str;
        this.f16416l = str2;
        this.f16414j = false;
    }

    public C4418i(C4410d c4410d) {
        this.f16409e = c4410d;
        this.f16408d = true;
    }

    public C4418i(C4409c c4409c, int i, LogCollectManager logCollectManager, LogMetricInfo logMetricInfo, Context context, String str, String str2, String str3, String str4, Handler handler) {
        this.f16407c = c4409c;
        this.f16410f = i;
        this.f16405a = logCollectManager;
        this.f16406b = logMetricInfo;
        this.f16414j = true;
        this.f16411g = context;
        this.f16415k = str;
        this.f16416l = str2;
        this.f16417m = str3;
        this.f16418n = str4;
        this.f16413i = handler;
    }

    public C4418i(C4409c c4409c, int i, LogCollectManager logCollectManager, LogMetricInfo logMetricInfo, Context context, String str, String str2, String str3, String str4, Handler handler, String str5) {
        this.f16407c = c4409c;
        this.f16410f = i;
        this.f16405a = logCollectManager;
        this.f16406b = logMetricInfo;
        this.f16414j = true;
        this.f16411g = context;
        this.f16415k = str;
        this.f16416l = str2;
        this.f16417m = str3;
        this.f16418n = str4;
        this.f16413i = handler;
        this.f16419o = str5;
    }

    public void run() {
        if (this.f16408d) {
            m21267b();
        } else {
            m21266a();
        }
    }

    private void m21266a() {
        int i;
        List b = this.f16407c.m21161b();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        int size = b.size();
        if (size > 0) {
            int i2;
            for (i2 = 0; i2 < size; i2++) {
                C4413c c4413c = (C4413c) b.get(i2);
                if (c4413c != null) {
                    String a = c4413c.m21245a();
                    String b2 = c4413c.m21247b();
                    if (!TextUtils.isEmpty(a)) {
                        stringBuilder3.append(a);
                        stringBuilder3.append("|");
                        stringBuilder.append(C4414d.m21249a(a, i2));
                        stringBuilder.append("|");
                        stringBuilder2.append(b2);
                        stringBuilder2.append("|");
                    }
                }
            }
            i2 = stringBuilder2.length() - 1;
            int length = stringBuilder.length() - 1;
            if (stringBuilder.length() - 1 >= 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (i2 >= 0) {
                stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            }
            if (length >= 0) {
                stringBuilder3.deleteCharAt(stringBuilder3.length() - 1);
            }
        }
        long parseLong = Long.parseLong(new SimpleDateFormat("MMddHHmmssSSS").format(new Date()));
        C4410d c4410d = new C4410d();
        if (!b.a()) {
            C4416g.m21257a(this.f16411g, 0, null);
        }
        if (TextUtils.isEmpty(this.f16407c.m21184l())) {
            c4410d.m21213i(this.f16411g.getResources().getString(d.b(this.f16411g, "feedback_cloud_service")));
        } else {
            c4410d.m21213i(this.f16407c.m21184l());
        }
        c4410d.m21217k(this.f16407c.m21175g());
        c4410d.m21219l(stringBuilder3.toString());
        c4410d.m21223n(stringBuilder2.toString());
        c4410d.m21225o(String.valueOf(this.f16407c.m21183k()));
        c4410d.m21209g(this.f16407c.m21185m());
        c4410d.m21193b(4);
        if (!TextUtils.isEmpty(this.f16407c.m21184l())) {
            c4410d.m21227p(this.f16407c.m21184l());
        }
        c4410d.m21207f(String.valueOf(parseLong));
        c4410d.m21204e(this.f16418n);
        c4410d.m21191a(this.f16407c.m21178h());
        c4410d.m21195b(this.f16407c.m21180i());
        c4410d.m21194b(this.f16407c.m21181j());
        c4410d.m21203e(this.f16407c.m21165c());
        c4410d.m21221m(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        c4410d.m21190a(this.f16419o);
        if (this.f16407c.m21165c() != 0) {
            f.c(c4410d);
        } else if (f.a() == null || f.a().size() >= 500) {
            this.f16420p.sendEmptyMessage(3);
        } else {
            c4410d.m21203e((int) f.a(c4410d));
        }
        boolean a2 = C4412b.m21244a(this.f16407c, this.f16410f, stringBuilder3.toString(), stringBuilder.toString(), stringBuilder2.toString(), this.f16406b, this.f16405a, this.f16414j, this.f16420p, this.f16416l, this.f16415k, this.f16417m, c4410d, this.f16412h);
        c.a("FeedbackSubmitTask", a2 + "");
        if (r5 > 0) {
            for (String str : stringBuilder.toString().split("\\|")) {
                if (str != null && str.contains("/phoneservice/image")) {
                    C5767b.m26478a(str);
                }
            }
        }
        if (!TextUtils.isEmpty(this.f16415k) && this.f16415k.equals("1") && this.f16414j && a2) {
            if (!com.huawei.feedback.c.h(this.f16411g)) {
                Intent intent = new Intent(this.f16411g, ProgressService.class);
                intent.setClassName(this.f16411g, "com.huawei.feedback.component.ProgressService");
                this.f16411g.startService(intent);
            }
            c.a("FeedbackSubmitTask", "开始日志上传");
            Intent intent2 = new Intent(MetricConstant.ACTION_UPLOAD_REQUEST_INTENT);
            intent2.setClassName(this.f16411g, "com.huawei.logupload.LogUploadService");
            intent2.putExtra("alert_visible", false);
            intent2.putExtra("filepath", this.f16418n);
            intent2.putExtra("id", parseLong);
            intent2.putExtra("usertype", 5);
            intent2.putExtra("encrypt", true);
            intent2.putExtra("privacy", false);
            intent2.putExtra(UploadFile.SYS_ID_CHANNEL, 7);
            intent2.putExtra(UploadFile.SIZE_LABEL, new File(this.f16418n).length());
            intent2.putExtra("feedBackPackageName", this.f16411g.getPackageName());
            intent2.putExtra("feedBackClassName", C4418i.class.getName());
            if (com.huawei.feedback.c.f(this.f16411g) == 1) {
                i = 1;
            } else {
                i = 7;
            }
            intent2.putExtra("flags", i);
            intent2.putExtra(UploadFile.ENCRYTKEY, this.f16419o);
            this.f16411g.startService(intent2);
        } else if (((!TextUtils.isEmpty(this.f16415k) && this.f16415k.equals("0")) || b.a()) && this.f16407c.m21173f() == 1) {
            File file = new File(this.f16407c.m21186n());
            if (TextUtils.isEmpty(file.toString())) {
                c.a("FeedbackSubmitTask", "file path is empty or null");
            } else if (file.exists() && file.delete()) {
                c.b("FeedbackSubmitTask", "package file delete sccess!");
            } else {
                c.b("FeedbackSubmitTask", "file not exist or error! file delete fail!");
            }
        }
    }

    private void m21267b() {
        if (this.f16409e != null) {
            String a = C4414d.m21249a(this.f16409e.m21228q(), 0);
            C4412b.m21242a(this.f16409e, a);
            if (a != null && !a.equals(this.f16409e.m21228q())) {
                C5767b.m26478a(a);
            }
        }
    }
}
