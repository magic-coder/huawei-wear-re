package com.huawei.ui.main.stories.account.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataReq;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataRsp;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.p067c.be;
import com.huawei.hwdatamigrate.hihealth.p067c.bf;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.commonui.dialog.f;
import com.huawei.ui.commonui.dialog.h;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.main.e;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;
import com.huawei.ui.main.k;
import com.huawei.ui.main.stories.account.interactor.C2329a;
import com.huawei.ui.main.stories.account.interactor.C2344c;
import com.huawei.ui.main.stories.account.interactor.C2353b;
import com.huawei.ui.main.stories.account.interactor.C2354d;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import com.huawei.ui.main.stories.account.p180a.C2330a;
import com.huawei.ui.main.stories.account.p180a.C2333c;
import com.huawei.ui.main.stories.account.p180a.C2334d;
import com.huawei.ui.main.stories.p177a.p178a.C2278b;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdPartyLoginActivity extends BaseActivity implements OnClickListener {
    private static final String f8465h = ThirdPartyLoginActivity.class.getSimpleName();
    private static IWXAPI f8466o;
    private C2329a f8467a;
    private Button f8468b;
    private Button f8469c;
    private Button f8470d;
    private Button f8471e;
    private C2344c f8472f;
    private Activity f8473g;
    private ExecutorService f8474i;
    private Handler f8475j;
    private C2278b f8476k;
    private TextView f8477l;
    private TextView f8478m;
    private Context f8479n;
    private int f8480p = 0;
    private f f8481q = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_third_party_login);
        this.f8473g = this;
        this.f8479n = this;
        this.f8474i = Executors.newSingleThreadExecutor();
        m11909f();
        this.f8475j = new C2352p(getMainLooper(), this);
        this.f8472f = new C2350n(this);
        f8466o = WXAPIFactory.createWXAPI(this.f8473g.getApplicationContext(), WeChat.WEAR_APP_ID, false);
        f8466o.registerApp(WeChat.WEAR_APP_ID);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f8474i != null) {
            this.f8474i.shutdown();
        }
        this.f8476k = null;
    }

    private void m11902b(C2353b c2353b) {
        C2538c.m12674b(f8465h, "accountmigrate: showDataMigrateDialog(final AccountContext oldaccount) enter oldaccount = ", c2353b);
        String e = c2353b.m11942e();
        String d = c2353b.m11940d();
        String string = this.f8473g.getString(j.IDS_app_name);
        w wVar = new w(this.f8473g);
        wVar.a(this.f8473g.getString(j.IDS_hw_health_show_common_dialog_title)).b(String.format(this.f8473g.getString(j.IDS_migrage_handle_notice), new Object[]{string, string})).a(this.f8473g.getString(j.IDS_hw_health_show_common_dialog_ok_button), new C2339d(this, e, d)).b(this.f8473g.getString(j.IDS_hw_health_show_common_dialog_cancle_button), new C2337b(this));
        wVar.a().show();
    }

    public void m11911a() {
        C2538c.m12677c(f8465h, "Enter showDataMigrateSuccessfulDialog");
        this.f8480p = 2;
        String toUpperCase = this.f8473g.getString(j.IDS_common_notification_know_tips).toUpperCase();
        a aVar = new a(this.f8479n, k.app_update_dialogActivity);
        aVar = a.c(this.f8479n);
        aVar.b(this.f8479n.getString(j.IDS_service_area_notice_title));
        aVar.c(this.f8479n.getString(j.IDS_migrage_show_other_account_migrate_successful));
        aVar.a(toUpperCase, new C2341f(this, aVar));
        if (aVar.isShowing()) {
            C2538c.m12677c(f8465h, "showHandleMigrateDialog on click 2");
            return;
        }
        C2538c.m12677c(f8465h, "showHandleMigrateDialog on click 1");
        aVar.b();
        aVar.setCancelable(false);
    }

    public void m11914b() {
        C2538c.m12677c(f8465h, "Enter showHandleMigrateDialog");
        this.f8480p = 2;
        String toUpperCase = this.f8473g.getString(j.IDS_common_notification_know_tips).toUpperCase();
        a aVar = new a(this.f8479n, k.app_update_dialogActivity);
        aVar = a.c(this.f8479n);
        aVar.b(this.f8479n.getString(j.IDS_service_area_notice_title));
        aVar.c(this.f8479n.getString(j.IDS_migrage_forcechange_note5));
        aVar.a(toUpperCase, new C2342g(this, aVar));
        if (aVar.isShowing()) {
            C2538c.m12677c(f8465h, "showHandleMigrateDialog on click 2");
            return;
        }
        C2538c.m12677c(f8465h, "showHandleMigrateDialog on click 1");
        aVar.b();
        aVar.setCancelable(false);
    }

    public void m11912a(Context context, MergeUserAllDataReq mergeUserAllDataReq) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction("com.huawei.bone.service.MigrateIntentService");
        intent.putExtra("migrate_old_huid", mergeUserAllDataReq.getOriginalHuid());
        intent.putExtra("migrate_old_st", mergeUserAllDataReq.getOriginalST());
        intent.putExtra("migrate_current_huid", C1093a.m4739a(BaseApplication.m2632b()).m4750c());
        context.startService(intent);
    }

    private void m11898a(String str, String str2) {
        C2538c.m12677c(f8465h, "accountmigrate: sendMigrageDataToCloud enter");
        MergeUserAllDataReq mergeUserAllDataReq = new MergeUserAllDataReq();
        mergeUserAllDataReq.setOriginalHuid(str);
        mergeUserAllDataReq.setOriginalST(str2);
        com.huawei.hwcloudmodel.mgr.a.a(this.f8473g).a(mergeUserAllDataReq, new C2343h(this, str, str2, mergeUserAllDataReq));
    }

    private void m11892a(MergeUserAllDataRsp mergeUserAllDataRsp, String str, String str2, String str3, MergeUserAllDataReq mergeUserAllDataReq) {
        this.f8475j.removeMessages(14);
        if (this.f8480p == 2) {
            C2538c.m12677c(f8465h, "accountmigrate: sendMigraAgeDataToCloud mergeUserAllData back but already timeout,exit app");
            return;
        }
        this.f8480p = 0;
        if (mergeUserAllDataRsp == null) {
            C2538c.m12677c(f8465h, "accountmigrate: sendMigrageDataToCloud cancel var1 = null");
            long a = m11889a(str);
            if (a == 999) {
                this.f8475j.sendEmptyMessage(TradeCode.QUERY_TERMINAL_BACK);
            }
            Bundle bundle = new Bundle();
            bundle.putLong("error_code", a);
            C2538c.m12657a(907127009, f8465h, bundle, false, "notice cloud migrate account data but return error message." + bundle);
            C2538c.m12677c(f8465h, "accountmigrate: sendMigrageDataToCloud but cloud return faild var1.getResultCode() = ", Long.valueOf(a));
        } else if (mergeUserAllDataRsp.getResultCode() == 0) {
            C2538c.m12677c(f8465h, "accountmigrate: sendMigrageDataToCloud but cloud return  var1.getResultCode() = 0");
            m11899a(str2, str3, C1093a.m4739a(this.f8473g).m4750c());
            m11912a(this.f8479n, mergeUserAllDataReq);
        }
    }

    public void m11913a(C2353b c2353b) {
        C2538c.m12677c(f8465h, "Enter.login ");
        C2354d.m11948a(this.f8473g, c2353b, new C2345i(this));
    }

    public void m11915c() {
        C2538c.m12677c(f8465h, "accountmigrate: showRequestCloudKidWatchDialog()");
        if (this.f8481q == null) {
            this.f8481q = new h(this.f8473g, Boolean.valueOf(false)).a().a(j.IDS_sns_waiting).a(false).b();
        }
        if (this.f8481q != null) {
            this.f8481q.show();
            C2538c.m12674b(f8465h, "accountmigrate: mRequestCloudKidWatchDialog.show()");
        }
    }

    private void m11897a(C2353b c2353b, int i, int i2) {
        C2538c.m12677c(f8465h, "cancelRequestCloudKidWatchDialog() watchNum:" + i);
        if (this.f8481q != null) {
            this.f8481q.cancel();
            this.f8481q = null;
            C2538c.m12674b(f8465h, "mRequestCloudKidWatchDialog.cancel()");
            if (1 != i2) {
                return;
            }
            if (i > 0) {
                C2538c.m12677c(f8465h, "cancelRequestCloudKidWatchDialog() have kid");
                com.huawei.ui.commonui.c.a.a(this.f8473g, this.f8473g.getResources().getString(j.IDS_migrage_other_login_account_have_kid_watch));
                return;
            }
            C2538c.m12677c(f8465h, "cancelRequestCloudKidWatchDialog() dont have kid");
            m11902b(c2353b);
            return;
        }
        C2538c.m12674b(f8465h, "cancelRequestCloudKidWatchDialog() and null == mRequestCloudKidWatchDialog");
    }

    public static long m11889a(String str) {
        C2538c.m12677c(f8465h, "stringToLong()");
        long j = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
                C2538c.m12677c(f8465h, "NumberFormatException Error " + str);
            }
        }
        return j;
    }

    public static void m11899a(String str, String str2, String str3) {
        C2538c.m12677c(f8465h, "saveMigrateInfoToDB()");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C2538c.m12677c(f8465h, "null,return");
            return;
        }
        bf bfVar = new bf();
        bfVar.m3660b(str3);
        bfVar.m3657a(str);
        bfVar.m3663c(str2);
        bfVar.m3658a(false);
        bfVar.m3664c(false);
        if (C0969i.m3482a(57)) {
            bfVar.m3661b(false);
        } else {
            bfVar.m3661b(true);
        }
        bfVar.m3667d(false);
        be.m3648a().m3650a(bfVar);
        be.m3648a().m3655c(str3);
        C2538c.m12674b(f8465h, "saveMigrateInfoToDB() migrateTable = ", bfVar);
    }

    public void m11916d() {
        C2538c.m12677c(f8465h, "Enter showHandleMigrateDialog");
        a aVar = new a(this.f8479n, k.app_update_dialogActivity);
        aVar = a.c(this.f8479n);
        aVar.b(this.f8479n.getString(j.IDS_service_area_notice_title));
        aVar.c(this.f8479n.getString(j.IDS_migrage_forcechange_note4));
        aVar.a(this.f8479n.getString(j.IDS_common_notification_know_tips), new C2348l(this, aVar));
        if (aVar.isShowing()) {
            C2538c.m12677c(f8465h, "showHandleMigrateDialog on click 2");
            return;
        }
        C2538c.m12677c(f8465h, "showHandleMigrateDialog on click 1");
        aVar.b();
        aVar.setCancelable(false);
    }

    private void m11906c(C2353b c2353b) {
        C2538c.m12674b(f8465h, "accountmigrate: quaryIsCloudHaveKidWatch() accountContext = ", c2353b);
        String str = "";
        if (c2353b != null) {
            str = c2353b.m11934b();
            C2538c.m12674b(f8465h, "accountmigrate: isKidWatchExistFromCloud origin at = " + str);
        }
        Message obtainMessage = this.f8475j.obtainMessage(12, c2353b);
        obtainMessage.arg1 = 0;
        obtainMessage.arg2 = 1;
        this.f8475j.sendMessage(obtainMessage);
    }

    private void m11909f() {
        this.f8477l = (TextView) findViewById(com.huawei.ui.main.f.third_party_login_title_title);
        this.f8478m = (TextView) findViewById(com.huawei.ui.main.f.third_party_login_title_notices);
        this.f8468b = (Button) findViewById(com.huawei.ui.main.f.btnWeiXin);
        this.f8470d = (Button) findViewById(com.huawei.ui.main.f.btnQQ);
        this.f8469c = (Button) findViewById(com.huawei.ui.main.f.btnWeiBo);
        this.f8471e = (Button) findViewById(com.huawei.ui.main.f.btnHuaWei);
        this.f8468b.setOnClickListener(this);
        this.f8470d.setOnClickListener(this);
        this.f8469c.setOnClickListener(this);
        this.f8471e.setVisibility(4);
        this.f8477l.setText(getString(j.IDS_migrage_show_find_history_data));
        CharSequence format = String.format(getString(j.IDS_migrage_show_third_login_notice_new), new Object[]{getString(j.IDS_app_name)});
        C2538c.m12677c(f8465h, "click content:" + format);
        C2538c.m12677c(f8465h, "click content:" + getString(j.IDS_migrage_show_third_login_notice_new));
        C2538c.m12677c(f8465h, "click content:" + getString(j.IDS_app_name));
        this.f8478m.setText(format);
        this.f8478m.setVisibility(0);
        format = m11890a(e.wechat, getString(j.IDS_hw_show_third_login_wechat).toUpperCase());
        if (format != null) {
            this.f8468b.setText(format);
            this.f8468b.setGravity(17);
        }
        format = m11890a(e.qq, getString(j.IDS_hw_show_third_login_qq).toUpperCase());
        if (format != null) {
            this.f8470d.setText(format);
            this.f8470d.setGravity(17);
        }
        format = m11890a(e.weibo, getString(j.IDS_hw_show_third_login_weibo).toUpperCase());
        if (format != null) {
            this.f8469c.setText(format);
            this.f8469c.setGravity(17);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == com.huawei.ui.main.f.btnWeiXin) {
            m11910g();
            C2538c.m12677c(f8465h, "click weixin");
        } else if (id == com.huawei.ui.main.f.btnQQ) {
            this.f8467a = new C2330a(this);
            this.f8467a.mo2652a(this.f8472f);
            C2538c.m12677c(f8465h, "click qq");
        } else if (id == com.huawei.ui.main.f.btnWeiBo) {
            this.f8467a = new C2333c(this);
            this.f8467a.mo2652a(this.f8472f);
            C2538c.m12677c(f8465h, "click Sinawei");
        }
    }

    private void m11910g() {
        C2538c.m12677c(f8465h, "loginByWeiXin");
        if (f8466o.isWXAppInstalled()) {
            C2538c.m12677c(f8465h, "click weixin login");
            this.f8467a = new C2334d(this);
            this.f8467a.mo2652a(this.f8472f);
            return;
        }
        C2538c.m12677c(f8465h, "click weixin not installed");
        m11903b("com.tencent.mm");
    }

    private void m11903b(String str) {
        C2538c.m12677c(f8465h, "downloadAPKByPKGName");
        try {
            Uri parse = Uri.parse("market://details?id=" + str);
            if (parse != null) {
                C2538c.m12677c(f8465h, "downloadAPKByPKGName startActivity");
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.f8473g.startActivity(intent);
                return;
            }
            C2538c.m12680e(f8465h, "uri is null!");
        } catch (Exception e) {
            C2538c.m12677c(f8465h, "Exception e = " + e.getMessage());
        }
    }

    private Spanned m11890a(int i, String str) {
        Spanned spannableString = new SpannableString("   " + str);
        spannableString.setSpan(new C2349m(this.f8473g, i), 0, 1, 33);
        return spannableString;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f8467a != null) {
            this.f8467a.mo2651a(i, i2, intent);
        }
    }

    public void onBackPressed() {
        C2538c.m12677c(f8465h, "onBackPressed");
        finish();
    }

    private void m11907d(C2353b c2353b) {
        C2538c.m12677c(f8465h, "Enter reqWXNickName");
        String str = "";
        str = "";
        try {
            c2353b.m11941d(new JSONObject(m11905c("https://api.weixin.qq.com/sns/userinfo?access_token=" + c2353b.m11940d() + "&openid=" + c2353b.m11942e())).optString("nickname"));
            C2538c.m12677c(f8465h, "Enter login 1");
            m11913a(c2353b);
        } catch (JSONException e) {
            C2538c.m12677c(f8465h, "Enter ERROR JSONException", e);
            C2538c.m12677c(f8465h, "Enter login 2");
            m11913a(c2353b);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m11905c(java.lang.String r13) {
        /*
        r3 = 0;
        r11 = 1;
        r10 = 0;
        r0 = f8465h;
        r1 = new java.lang.Object[r11];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "Enter doGet urlStr:";
        r2 = r2.append(r4);
        r2 = r2.append(r13);
        r2 = r2.toString();
        r1[r10] = r2;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        if (r13 == 0) goto L_0x0029;
    L_0x0021:
        r0 = "";
        r0 = r13.equals(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x0029:
        r0 = "urlStr = null";
    L_0x002c:
        return r0;
    L_0x002d:
        r5 = "";
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0397, UnsupportedEncodingException -> 0x016d, ProtocolException -> 0x01e9, IOException -> 0x0265, all -> 0x02e1 }
        r0.<init>(r13);	 Catch:{ MalformedURLException -> 0x0397, UnsupportedEncodingException -> 0x016d, ProtocolException -> 0x01e9, IOException -> 0x0265, all -> 0x02e1 }
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x0397, UnsupportedEncodingException -> 0x016d, ProtocolException -> 0x01e9, IOException -> 0x0265, all -> 0x02e1 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0397, UnsupportedEncodingException -> 0x016d, ProtocolException -> 0x01e9, IOException -> 0x0265, all -> 0x02e1 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setReadTimeout(r1);	 Catch:{ MalformedURLException -> 0x039c, UnsupportedEncodingException -> 0x037e, ProtocolException -> 0x0365, IOException -> 0x034c, all -> 0x0338 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ MalformedURLException -> 0x039c, UnsupportedEncodingException -> 0x037e, ProtocolException -> 0x0365, IOException -> 0x034c, all -> 0x0338 }
        r1 = "GET";
        r0.setRequestMethod(r1);	 Catch:{ MalformedURLException -> 0x039c, UnsupportedEncodingException -> 0x037e, ProtocolException -> 0x0365, IOException -> 0x034c, all -> 0x0338 }
        r1 = "accept";
        r2 = "*/*";
        r0.setRequestProperty(r1, r2);	 Catch:{ MalformedURLException -> 0x039c, UnsupportedEncodingException -> 0x037e, ProtocolException -> 0x0365, IOException -> 0x034c, all -> 0x0338 }
        r1 = "connection";
        r2 = "Keep-Alive";
        r0.setRequestProperty(r1, r2);	 Catch:{ MalformedURLException -> 0x039c, UnsupportedEncodingException -> 0x037e, ProtocolException -> 0x0365, IOException -> 0x034c, all -> 0x0338 }
        r4 = r0.getInputStream();	 Catch:{ MalformedURLException -> 0x039c, UnsupportedEncodingException -> 0x037e, ProtocolException -> 0x0365, IOException -> 0x034c, all -> 0x0338 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ MalformedURLException -> 0x03a2, UnsupportedEncodingException -> 0x0384, ProtocolException -> 0x036b, IOException -> 0x0352, all -> 0x033d }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x03a2, UnsupportedEncodingException -> 0x0384, ProtocolException -> 0x036b, IOException -> 0x0352, all -> 0x033d }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x0389, ProtocolException -> 0x0370, IOException -> 0x0357, all -> 0x0341 }
    L_0x0064:
        r3 = r4.read(r1);	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x0389, ProtocolException -> 0x0370, IOException -> 0x0357, all -> 0x0341 }
        r6 = -1;
        if (r3 == r6) goto L_0x00aa;
    L_0x006b:
        r6 = 0;
        r2.write(r1, r6, r3);	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x0389, ProtocolException -> 0x0370, IOException -> 0x0357, all -> 0x0341 }
        goto L_0x0064;
    L_0x0070:
        r1 = move-exception;
        r3 = r4;
        r12 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r12;
    L_0x0076:
        r4 = f8465h;	 Catch:{ all -> 0x0346 }
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0346 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0346 }
        r7.<init>();	 Catch:{ all -> 0x0346 }
        r8 = "doGet=======";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0346 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0346 }
        r0 = r7.append(r0);	 Catch:{ all -> 0x0346 }
        r0 = r0.toString();	 Catch:{ all -> 0x0346 }
        r5[r6] = r0;	 Catch:{ all -> 0x0346 }
        com.huawei.p190v.C2538c.m12677c(r4, r5);	 Catch:{ all -> 0x0346 }
        r0 = "MalformedURLException";
        if (r3 == 0) goto L_0x009f;
    L_0x009c:
        r3.close();	 Catch:{ IOException -> 0x0127 }
    L_0x009f:
        if (r1 == 0) goto L_0x00a4;
    L_0x00a1:
        r1.close();	 Catch:{ IOException -> 0x014a }
    L_0x00a4:
        if (r2 == 0) goto L_0x002c;
    L_0x00a6:
        r2.disconnect();
        goto L_0x002c;
    L_0x00aa:
        r2.flush();	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x0389, ProtocolException -> 0x0370, IOException -> 0x0357, all -> 0x0341 }
        r1 = "UTF-8";
        r1 = r2.toString(r1);	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x0389, ProtocolException -> 0x0370, IOException -> 0x0357, all -> 0x0341 }
        r3 = f8465h;	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        r8 = "response == ";
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        r7 = r7.append(r1);	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        r7 = r7.toString();	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        r5[r6] = r7;	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        com.huawei.p190v.C2538c.m12674b(r3, r5);	 Catch:{ MalformedURLException -> 0x0070, UnsupportedEncodingException -> 0x038f, ProtocolException -> 0x0376, IOException -> 0x035d, all -> 0x0341 }
        if (r4 == 0) goto L_0x00d6;
    L_0x00d3:
        r4.close();	 Catch:{ IOException -> 0x00e3 }
    L_0x00d6:
        if (r2 == 0) goto L_0x00db;
    L_0x00d8:
        r2.close();	 Catch:{ IOException -> 0x0105 }
    L_0x00db:
        if (r0 == 0) goto L_0x03a9;
    L_0x00dd:
        r0.disconnect();
        r0 = r1;
        goto L_0x002c;
    L_0x00e3:
        r3 = move-exception;
        r4 = f8465h;
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r3 = r3.getMessage();
        r3 = r6.append(r3);
        r3 = r3.toString();
        r5[r10] = r3;
        com.huawei.p190v.C2538c.m12677c(r4, r5);
        goto L_0x00d6;
    L_0x0105:
        r2 = move-exception;
        r3 = f8465h;
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r2 = r2.getMessage();
        r2 = r5.append(r2);
        r2 = r2.toString();
        r4[r10] = r2;
        com.huawei.p190v.C2538c.m12677c(r3, r4);
        goto L_0x00db;
    L_0x0127:
        r3 = move-exception;
        r4 = f8465h;
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r3 = r3.getMessage();
        r3 = r6.append(r3);
        r3 = r3.toString();
        r5[r10] = r3;
        com.huawei.p190v.C2538c.m12677c(r4, r5);
        goto L_0x009f;
    L_0x014a:
        r1 = move-exception;
        r3 = f8465h;
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r3, r4);
        goto L_0x00a4;
    L_0x016d:
        r0 = move-exception;
        r1 = r0;
        r4 = r3;
        r2 = r3;
        r0 = r5;
    L_0x0172:
        r5 = f8465h;	 Catch:{ all -> 0x034a }
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x034a }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x034a }
        r8.<init>();	 Catch:{ all -> 0x034a }
        r9 = "doGet=======";
        r8 = r8.append(r9);	 Catch:{ all -> 0x034a }
        r1 = r1.getMessage();	 Catch:{ all -> 0x034a }
        r1 = r8.append(r1);	 Catch:{ all -> 0x034a }
        r1 = r1.toString();	 Catch:{ all -> 0x034a }
        r6[r7] = r1;	 Catch:{ all -> 0x034a }
        com.huawei.p190v.C2538c.m12677c(r5, r6);	 Catch:{ all -> 0x034a }
        if (r4 == 0) goto L_0x0199;
    L_0x0196:
        r4.close();	 Catch:{ IOException -> 0x01a5 }
    L_0x0199:
        if (r3 == 0) goto L_0x019e;
    L_0x019b:
        r3.close();	 Catch:{ IOException -> 0x01c7 }
    L_0x019e:
        if (r2 == 0) goto L_0x002c;
    L_0x01a0:
        r2.disconnect();
        goto L_0x002c;
    L_0x01a5:
        r1 = move-exception;
        r4 = f8465h;
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r4, r5);
        goto L_0x0199;
    L_0x01c7:
        r1 = move-exception;
        r3 = f8465h;
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r3, r4);
        goto L_0x019e;
    L_0x01e9:
        r0 = move-exception;
        r1 = r0;
        r4 = r3;
        r2 = r3;
        r0 = r5;
    L_0x01ee:
        r5 = f8465h;	 Catch:{ all -> 0x034a }
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x034a }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x034a }
        r8.<init>();	 Catch:{ all -> 0x034a }
        r9 = "doGet=======";
        r8 = r8.append(r9);	 Catch:{ all -> 0x034a }
        r1 = r1.getMessage();	 Catch:{ all -> 0x034a }
        r1 = r8.append(r1);	 Catch:{ all -> 0x034a }
        r1 = r1.toString();	 Catch:{ all -> 0x034a }
        r6[r7] = r1;	 Catch:{ all -> 0x034a }
        com.huawei.p190v.C2538c.m12677c(r5, r6);	 Catch:{ all -> 0x034a }
        if (r4 == 0) goto L_0x0215;
    L_0x0212:
        r4.close();	 Catch:{ IOException -> 0x0221 }
    L_0x0215:
        if (r3 == 0) goto L_0x021a;
    L_0x0217:
        r3.close();	 Catch:{ IOException -> 0x0243 }
    L_0x021a:
        if (r2 == 0) goto L_0x002c;
    L_0x021c:
        r2.disconnect();
        goto L_0x002c;
    L_0x0221:
        r1 = move-exception;
        r4 = f8465h;
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r4, r5);
        goto L_0x0215;
    L_0x0243:
        r1 = move-exception;
        r3 = f8465h;
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r3, r4);
        goto L_0x021a;
    L_0x0265:
        r0 = move-exception;
        r1 = r0;
        r4 = r3;
        r2 = r3;
        r0 = r5;
    L_0x026a:
        r5 = f8465h;	 Catch:{ all -> 0x034a }
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x034a }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x034a }
        r8.<init>();	 Catch:{ all -> 0x034a }
        r9 = "doGet=======";
        r8 = r8.append(r9);	 Catch:{ all -> 0x034a }
        r1 = r1.getMessage();	 Catch:{ all -> 0x034a }
        r1 = r8.append(r1);	 Catch:{ all -> 0x034a }
        r1 = r1.toString();	 Catch:{ all -> 0x034a }
        r6[r7] = r1;	 Catch:{ all -> 0x034a }
        com.huawei.p190v.C2538c.m12677c(r5, r6);	 Catch:{ all -> 0x034a }
        if (r4 == 0) goto L_0x0291;
    L_0x028e:
        r4.close();	 Catch:{ IOException -> 0x029d }
    L_0x0291:
        if (r3 == 0) goto L_0x0296;
    L_0x0293:
        r3.close();	 Catch:{ IOException -> 0x02bf }
    L_0x0296:
        if (r2 == 0) goto L_0x002c;
    L_0x0298:
        r2.disconnect();
        goto L_0x002c;
    L_0x029d:
        r1 = move-exception;
        r4 = f8465h;
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r4, r5);
        goto L_0x0291;
    L_0x02bf:
        r1 = move-exception;
        r3 = f8465h;
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r3, r4);
        goto L_0x0296;
    L_0x02e1:
        r0 = move-exception;
        r4 = r3;
        r2 = r3;
    L_0x02e4:
        if (r4 == 0) goto L_0x02e9;
    L_0x02e6:
        r4.close();	 Catch:{ IOException -> 0x02f4 }
    L_0x02e9:
        if (r3 == 0) goto L_0x02ee;
    L_0x02eb:
        r3.close();	 Catch:{ IOException -> 0x0316 }
    L_0x02ee:
        if (r2 == 0) goto L_0x02f3;
    L_0x02f0:
        r2.disconnect();
    L_0x02f3:
        throw r0;
    L_0x02f4:
        r1 = move-exception;
        r4 = f8465h;
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r4, r5);
        goto L_0x02e9;
    L_0x0316:
        r1 = move-exception;
        r3 = f8465h;
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        com.huawei.p190v.C2538c.m12677c(r3, r4);
        goto L_0x02ee;
    L_0x0338:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r1;
        goto L_0x02e4;
    L_0x033d:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x02e4;
    L_0x0341:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        goto L_0x02e4;
    L_0x0346:
        r0 = move-exception;
        r4 = r3;
        r3 = r1;
        goto L_0x02e4;
    L_0x034a:
        r0 = move-exception;
        goto L_0x02e4;
    L_0x034c:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r5;
        goto L_0x026a;
    L_0x0352:
        r1 = move-exception;
        r2 = r0;
        r0 = r5;
        goto L_0x026a;
    L_0x0357:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x026a;
    L_0x035d:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r12;
        goto L_0x026a;
    L_0x0365:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r5;
        goto L_0x01ee;
    L_0x036b:
        r1 = move-exception;
        r2 = r0;
        r0 = r5;
        goto L_0x01ee;
    L_0x0370:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x01ee;
    L_0x0376:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r12;
        goto L_0x01ee;
    L_0x037e:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r5;
        goto L_0x0172;
    L_0x0384:
        r1 = move-exception;
        r2 = r0;
        r0 = r5;
        goto L_0x0172;
    L_0x0389:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0172;
    L_0x038f:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r12;
        goto L_0x0172;
    L_0x0397:
        r0 = move-exception;
        r1 = r3;
        r2 = r3;
        goto L_0x0076;
    L_0x039c:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r3;
        goto L_0x0076;
    L_0x03a2:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r4;
        goto L_0x0076;
    L_0x03a9:
        r0 = r1;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.ui.main.stories.account.activity.ThirdPartyLoginActivity.c(java.lang.String):java.lang.String");
    }
}
