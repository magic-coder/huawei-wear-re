package com.huawei.hwid.core.p430b.p431a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.vermanager.C5313c;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: HttpRequest */
public abstract class C5125a {
    protected int f18468a = 200;
    protected int f18469b = -1;
    protected int f18470c = -1;
    protected String f18471d;
    protected String f18472e;
    protected int f18473f = 3;
    protected int f18474g = 1;
    private String f18475h = "";
    private ArrayList<Integer> f18476i = new ArrayList();
    private boolean f18477j = false;
    private boolean f18478k = false;
    private boolean f18479l = true;
    private boolean f18480m = false;
    private int f18481n = 0;
    private String f18482o;
    private String f18483p;
    private String f18484q;
    private ArrayList<String> f18485r = new ArrayList();
    private boolean f18486s = false;
    private C5122d f18487t = C5122d.XMLType;

    /* compiled from: HttpRequest */
    class C5119a extends HandlerThread {
        private C5120b f18455a = null;
        private C5107a f18456b = null;

        public C5119a(String str, C5107a c5107a) {
            super(str);
            this.f18456b = c5107a;
        }

        protected void onLooperPrepared() {
            this.f18455a = new C5120b(this.f18456b);
            super.onLooperPrepared();
        }

        public C5120b m24668a() {
            int i = 1000;
            while (this.f18455a == null) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                try {
                    C5119a.sleep(4);
                    i = i2;
                } catch (Throwable e) {
                    C5165e.m24911d("RequestManager", e.getMessage(), e);
                    i = i2;
                }
            }
            return this.f18455a;
        }
    }

    /* compiled from: HttpRequest */
    class C5120b extends Handler {
        private C5107a f18457a;

        public C5120b(C5107a c5107a) {
            this.f18457a = c5107a;
        }

        public void m24669a() {
            getLooper().quit();
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.f18457a.m24602e((Bundle) message.obj);
                m24669a();
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: HttpRequest */
    public class C5121c {
        private static String f18458a = C5313c.m25694a().mo4687d();
    }

    /* compiled from: HttpRequest */
    public enum C5122d {
        XMLType,
        URLType,
        JSONType
    }

    /* compiled from: HttpRequest */
    public class C5123e {
        private static String f18463a = C5313c.m25694a().mo4680a();
        private static String f18464b = C5313c.m25694a().mo4683b();
        private static String f18465c = C5313c.m25694a().mo4685c();
    }

    protected abstract void mo4628a(String str) throws XmlPullParserException, IOException;

    protected abstract String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException;

    public abstract String mo4630g();

    public void m24683a(C5122d c5122d) {
        this.f18487t = c5122d;
    }

    public C5122d m24678a() {
        return this.f18487t;
    }

    public static String m24675b() {
        return C5121c.f18458a;
    }

    public static String m24676c() {
        return C5123e.f18465c;
    }

    protected String m24692d() {
        String b;
        synchronized (C5125a.class) {
            b = C5123e.f18464b;
        }
        return b;
    }

    protected String mo4633f() {
        return null;
    }

    protected void mo4632b(String str) {
    }

    public void mo4627a(Context context, C5125a c5125a, String str, CloudRequestHandler cloudRequestHandler) {
    }

    public Bundle mo4631h() {
        return m24701i();
    }

    public Bundle m24701i() {
        Bundle bundle = new Bundle();
        bundle.putInt("responseCode", this.f18468a);
        bundle.putInt("resultCode", this.f18469b);
        bundle.putInt(Constant.KEY_ERROR_CODE, this.f18470c);
        bundle.putString(Constant.KEY_ERROR_DESC, this.f18471d);
        bundle.putString("TGC", this.f18472e);
        bundle.putIntegerArrayList("UIHandlerErrCodeList", m24706n());
        bundle.putBoolean("isUIHandlerAllErrCode", m24707o());
        bundle.putBoolean("isIngoreTokenErr", m24708p());
        return bundle;
    }

    public int m24702j() {
        return this.f18468a;
    }

    public void m24680a(int i) {
        this.f18468a = i;
    }

    public int m24703k() {
        return this.f18469b;
    }

    public int m24704l() {
        return this.f18470c;
    }

    public String m24705m() {
        return this.f18471d;
    }

    public void m24691c(String str) {
        this.f18472e = str;
    }

    public void m24687b(int i) {
        this.f18476i.add(Integer.valueOf(i));
    }

    public ArrayList<Integer> m24706n() {
        return this.f18476i;
    }

    public void m24685a(boolean z) {
        this.f18477j = z;
    }

    public boolean m24707o() {
        return this.f18477j;
    }

    public boolean m24708p() {
        return this.f18478k;
    }

    public int m24709q() {
        return this.f18474g;
    }

    public String m24710r() {
        String g = mo4630g();
        if (TextUtils.isEmpty(g)) {
            return "";
        }
        return g.substring(g.lastIndexOf("/") + 1);
    }

    public void m24690c(int i) {
        this.f18481n = i;
        String g = mo4630g();
        String str = "";
        if (this.f18481n >= 1 && this.f18481n <= 999) {
            str = String.valueOf(i);
        }
        this.f18482o = C5181l.m25036a(g, new String[]{"\\{0\\}", str});
    }

    public int m24711s() {
        return this.f18481n;
    }

    public String m24679a(Context context) {
        if (TextUtils.isEmpty(this.f18482o)) {
            return mo4630g() + "?Version=" + "12000" + "&cVersion=" + C5166b.m24963o(context);
        }
        return this.f18482o + "?Version=" + "12000" + "&cVersion=" + C5166b.m24963o(context);
    }

    public void m24694d(String str) {
        this.f18482o = str;
    }

    public boolean m24712t() {
        return this.f18479l;
    }

    public int m24713u() {
        return this.f18473f;
    }

    public void m24693d(int i) {
        this.f18473f = i;
    }

    protected void m24689b(boolean z) {
        this.f18480m = z;
    }

    protected C5120b m24677a(Context context, C5125a c5125a, C5107a c5107a) {
        C5119a c5119a = new C5119a("BackgroundHandlerThread", c5107a);
        c5119a.start();
        return c5119a.m24668a();
    }

    public String m24714v() {
        return this.f18483p;
    }

    public void m24696e(String str) {
        this.f18483p = str;
    }

    public String m24715w() {
        return this.f18484q;
    }

    public void m24698f(String str) {
        this.f18484q = str;
    }

    public void m24681a(int i, int i2, String str) {
        if (i2 == 200 && this.f18469b != 0 && this.f18470c > 0) {
            i2 = this.f18470c;
            str = m24705m();
        }
        ArrayList arrayList = this.f18485r;
        String str2 = "{times:%d,code:%d,msg:%s}";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "result ok";
        }
        objArr[2] = str;
        arrayList.add(String.format(str2, objArr));
    }

    public String m24716x() {
        if (this.f18485r.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        int size = this.f18485r.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append((String) this.f18485r.get(i));
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m24717y() {
        this.f18485r.clear();
    }

    public Bundle m24686b(Context context) {
        Object x = m24716x();
        if (TextUtils.isEmpty(x)) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(HwAccountConstants.EXTRA_OPLOG_OPID, "0");
        bundle.putString(HwAccountConstants.EXTRA_OPLOG_REQTIME, m24714v());
        bundle.putString(HwAccountConstants.EXTRA_OPLOG_RSPTIME, m24715w());
        bundle.putString(HwAccountConstants.EXTRA_OPLOG_OPDETAIL, x);
        bundle.putString("url", m24679a(context));
        bundle.putInt("siteID", m24711s());
        int j = m24702j();
        if (1008 == j || 1005 == j || 3008 == j || m24718z()) {
            bundle.putBoolean(HwAccountConstants.EXTRA_OPLOG_IS_REQUEST_EXCEPTION, true);
            bundle.putString(HwAccountConstants.EXTRA_OPLOG_ERROR, String.valueOf(j));
            return bundle;
        }
        int k = m24703k();
        if (-1 != k) {
            bundle.putString(HwAccountConstants.EXTRA_OPLOG_ERROR, String.valueOf(k));
        } else if (-1 != m24704l()) {
            bundle.putString(HwAccountConstants.EXTRA_OPLOG_ERROR, String.valueOf(m24704l()));
        } else {
            bundle.putString(HwAccountConstants.EXTRA_OPLOG_ERROR, String.valueOf(j));
        }
        bundle.putBoolean(HwAccountConstants.EXTRA_OPLOG_IS_REQUEST_EXCEPTION, false);
        return bundle;
    }

    public boolean m24718z() {
        return (200 == m24702j() || 307 == m24702j()) ? false : true;
    }
}
