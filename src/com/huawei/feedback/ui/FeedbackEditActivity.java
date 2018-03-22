package com.huawei.feedback.ui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.android.app.ActionBarEx;
import com.huawei.feedback.b;
import com.huawei.feedback.bean.C4406b;
import com.huawei.feedback.bean.C4409c;
import com.huawei.feedback.bean.C4409c.C4408a;
import com.huawei.feedback.c$a;
import com.huawei.feedback.d;
import com.huawei.feedback.logic.C4413c;
import com.huawei.feedback.logic.C4415e;
import com.huawei.feedback.logic.C4418i;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.lcagent.client.LogMetricInfo;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.phoneserviceuni.common.d.a.a.a;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.d.f;
import com.huawei.phoneserviceuni.common.p132d.p496b.C5766a;
import com.huawei.phoneserviceuni.common.widget.EditTextInputFilter;
import huawei.android.widget.CounterTextLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FeedbackEditActivity extends BaseActivity {
    private static boolean f16472H = false;
    private Button f16473A;
    private ImageView f16474B;
    private TextView f16475C;
    private TextView f16476D;
    private boolean f16477E = false;
    private C4440i f16478F = null;
    private C4406b f16479G;
    private LinearLayout f16480I = null;
    private LinearLayout f16481J = null;
    private LinearLayout f16482K = null;
    private TextView f16483L;
    private TextView f16484M;
    private TextView f16485N;
    private ImageView f16486O;
    private LogCollectManager f16487P = null;
    private String f16488Q = "";
    private String f16489R;
    private File f16490S;
    private File f16491T;
    private ProgressDialog f16492U;
    private LogMetricInfo f16493V = null;
    private AlertDialog f16494W;
    private AlertDialog f16495X;
    private boolean f16496Y = false;
    private String f16497Z = "";
    public int f16498a = 1;
    private String aa = "";
    private String ab = "";
    private String ac = "";
    private int ad = 1;
    private boolean ae = false;
    private boolean af = false;
    private ActionBar ag;
    private OnClickListener ah = new C4462k(this);
    private OnClickListener ai = new C4467p(this);
    private OnClickListener aj = new C4468q(this);
    private OnClickListener ak = new C4469r(this);
    private OnClickListener al = new C4470s(this);
    private OnItemClickListener am = new C4471t(this);
    private OnClickListener an = new C4472u(this);
    private WebViewClient ao = new C4465n(this);
    private WebChromeClient ap = new C4466o(this);
    public Handler f16499b = new C4473v(this);
    private Context f16500c;
    private OnKeyListener f16501d;
    private GridView f16502e;
    private ae f16503f;
    private List<C4413c> f16504g = new ArrayList();
    private C4413c f16505h = null;
    private String f16506i = "";
    private Spinner f16507j;
    private AlertDialog f16508k;
    private AlertDialog f16509l;
    private EditText f16510m;
    private CheckBox f16511n;
    private String f16512o;
    private View f16513p;
    private View f16514q;
    private WebView f16515r;
    private ProgressBar f16516s;
    private RelativeLayout f16517t;
    private C4409c f16518u = new C4408a(0).m21155a();
    private int f16519v = 0;
    private C4409c f16520w = new C4408a(0).m21155a();
    private EditText f16521x;
    private TextView f16522y;
    private ImageView f16523z;

    class C4432a implements TextWatcher {
        final /* synthetic */ FeedbackEditActivity f16458a;

        private C4432a(FeedbackEditActivity feedbackEditActivity) {
            this.f16458a = feedbackEditActivity;
        }

        public void afterTextChanged(Editable editable) {
            this.f16458a.f16522y.setText(editable.length() + "/500");
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f16458a.m21391p();
        }
    }

    class C4433b implements TextWatcher {
        final /* synthetic */ FeedbackEditActivity f16459a;

        private C4433b(FeedbackEditActivity feedbackEditActivity) {
            this.f16459a = feedbackEditActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f16459a.m21366d(false);
                this.f16459a.f16523z.setVisibility(8);
                return;
            }
            this.f16459a.f16523z.setVisibility(0);
            this.f16459a.m21391p();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    class C4434c implements OnItemSelectedListener {
        final /* synthetic */ FeedbackEditActivity f16460a;

        private C4434c(FeedbackEditActivity feedbackEditActivity) {
            this.f16460a = feedbackEditActivity;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f16460a.f16506i = "" + i;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C4435d implements OnKeyListener {
        private C4435d() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                return true;
            }
            return false;
        }
    }

    class C4436e extends ArrayAdapter<String> {
        Context f16461a;
        String[] f16462b = new String[0];
        final /* synthetic */ FeedbackEditActivity f16463c;

        public C4436e(FeedbackEditActivity feedbackEditActivity, Context context, int i, String[] strArr) {
            this.f16463c = feedbackEditActivity;
            super(context, i, strArr);
            this.f16462b = strArr;
            this.f16461a = context;
        }

        public int getCount() {
            return this.f16462b.length;
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.f16461a).inflate(d.c(this.f16463c.f16500c, "feedback_spinner_dropview"), viewGroup, false);
            }
            ((TextView) view.findViewById(d.a(this.f16463c.f16500c, "text"))).setText(this.f16462b[i]);
            return view;
        }
    }

    class C4437f implements DialogInterface.OnClickListener {
        final /* synthetic */ FeedbackEditActivity f16464a;

        private C4437f(FeedbackEditActivity feedbackEditActivity) {
            this.f16464a = feedbackEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16464a.finish();
        }
    }

    class C4438g implements DialogInterface.OnClickListener {
        final /* synthetic */ FeedbackEditActivity f16465a;

        private C4438g(FeedbackEditActivity feedbackEditActivity) {
            this.f16465a = feedbackEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16465a.f16496Y = false;
            c.a("FeedbackEditActivity", "isFromOutside cancle click");
            this.f16465a.f16520w.m21166c(2);
        }
    }

    class C4439h implements DialogInterface.OnClickListener {
        final /* synthetic */ FeedbackEditActivity f16466a;

        private C4439h(FeedbackEditActivity feedbackEditActivity) {
            this.f16466a = feedbackEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f16466a.f16520w.m21173f() == 1) {
                this.f16466a.f16489R = this.f16466a.f16491T.getName();
            }
            if (this.f16466a.f16500c == null) {
                this.f16466a.f16500c = this.f16466a;
            }
            C5766a.m26469a().m26470a(new C4418i(this.f16466a.f16520w, this.f16466a.f16519v, this.f16466a.f16487P, null, this.f16466a.f16500c, this.f16466a.f16512o, this.f16466a.f16520w.m21185m(), this.f16466a.f16489R, this.f16466a.f16491T.toString(), this.f16466a.f16499b, this.f16466a.f16520w.m21156a()));
            this.f16466a.finish();
        }
    }

    public class C4440i extends Thread {
        final /* synthetic */ FeedbackEditActivity f16467a;
        private Context f16468b;

        public C4440i(FeedbackEditActivity feedbackEditActivity, Context context) {
            this.f16467a = feedbackEditActivity;
            this.f16468b = context;
        }

        public void m21316a(Context context) {
            this.f16468b = context;
        }

        public void run() {
            c.c("FeedbackEditActivity", "FeedbackConstData.isFromOutside()run()" + b.a());
            m21315a();
        }

        private void m21315a() {
            c.b("FeedbackEditActivity", "Log pack packageName = " + this.f16467a.ab + " versionName = " + this.f16467a.ac);
            this.f16467a.f16520w.m21163b(this.f16467a.ab);
            this.f16467a.f16520w.m21167c(this.f16467a.ac);
            if (!TextUtils.isEmpty(this.f16467a.f16497Z)) {
                this.f16467a.f16491T = new File(this.f16467a.f16497Z);
                c.b("FeedbackEditActivity", "waitUploadZipfile = " + this.f16467a.f16491T);
            }
            if (TextUtils.isEmpty(this.f16467a.f16497Z) || TextUtils.isEmpty(this.f16467a.aa)) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                this.f16467a.f16499b.sendMessage(obtain);
                return;
            }
            if (this.f16467a.f16491T.exists()) {
                this.f16467a.af = true;
            } else {
                this.f16467a.af = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    c.d("FeedbackEditActivity", "thirdAppPackage InterruptedException");
                }
                if (this.f16467a.f16491T.exists()) {
                    this.f16467a.af = true;
                }
            }
            if (this.f16467a.af) {
                this.f16467a.f16520w.m21158a(a.a(this.f16467a.aa));
                obtain = Message.obtain();
                obtain.what = 1;
                this.f16467a.f16499b.sendMessage(obtain);
                return;
            }
            c.b("FeedbackEditActivity", "LogFile not Exist");
            obtain = Message.obtain();
            obtain.what = 4;
            this.f16467a.f16499b.sendMessage(obtain);
        }
    }

    class C4441j implements OnClickListener {
        final /* synthetic */ FeedbackEditActivity f16469a;

        C4441j(FeedbackEditActivity feedbackEditActivity) {
            this.f16469a = feedbackEditActivity;
        }

        public void onClick(View view) {
            this.f16469a.f16496Y = true;
            if (com.huawei.feedback.c.c()) {
                this.f16469a.f16496Y = false;
            } else if (TextUtils.isEmpty(this.f16469a.f16521x.getText()) || TextUtils.isEmpty(this.f16469a.f16510m.getText())) {
                this.f16469a.f16496Y = false;
            } else if (m21318b()) {
                f.a(this.f16469a.f16500c, this.f16469a.getResources().getString(d.b(this.f16469a.f16500c, "formaterror_toast")));
                this.f16469a.f16496Y = false;
            } else {
                c.a("FeedbackEditActivity", "captureFilePath:" + b.a);
                if (!TextUtils.isEmpty(b.a)) {
                    File file = new File(b.a);
                    if (file.exists()) {
                        com.huawei.feedback.c.a(file);
                    }
                }
                f.a(this.f16469a);
                m21319c();
                if (this.f16469a.f16500c != null) {
                    String obj = this.f16469a.f16510m.getText().toString();
                    if (obj.trim().isEmpty()) {
                        this.f16469a.f16496Y = false;
                        return;
                    } else if (obj.length() > 500) {
                        this.f16469a.f16496Y = false;
                        return;
                    } else {
                        this.f16469a.f16520w.m21170d(obj);
                        this.f16469a.f16520w.m21176g(this.f16469a.f16521x.getText().toString());
                        this.f16469a.f16520w.m21179i(this.f16469a.f16506i);
                        this.f16469a.f16512o = this.f16469a.f16520w.m21178h() ? "1" : "0";
                        if (FeedbackEditActivity.f16472H || b.a()) {
                            c.a("FeedbackEditActivity", "feedbackInfo.getPack()" + this.f16469a.f16520w.m21173f());
                            if (!this.f16469a.f16520w.m21178h()) {
                                c.b("FeedbackEditActivity", "---draftInfo.getEncryptKey()-->>" + this.f16469a.f16518u.m21156a());
                                c.b("FeedbackEditActivity", "---feedbackInfo.getEncryptKey()-->>" + this.f16469a.f16520w.m21156a());
                                C5766a.m26469a().m26470a(new C4418i(this.f16469a.f16520w, this.f16469a.f16519v, this.f16469a.f16487P, null, this.f16469a.f16500c, this.f16469a.f16512o, this.f16469a.f16520w.m21185m(), this.f16469a.f16489R, "", this.f16469a.f16499b));
                                m21317a();
                            } else if (1 != this.f16469a.f16520w.m21173f() || TextUtils.isEmpty(this.f16469a.f16520w.m21186n())) {
                                this.f16469a.f16492U = new ProgressDialog(this.f16469a.f16500c);
                                this.f16469a.f16492U.setMessage(this.f16469a.f16500c.getString(d.b(this.f16469a.f16500c, "feedback_waiting")));
                                this.f16469a.f16492U.setCancelable(false);
                                this.f16469a.f16492U.show();
                                this.f16469a.f16478F = new C4440i(this.f16469a, this.f16469a.f16500c);
                                this.f16469a.f16478F.start();
                                return;
                            } else {
                                this.f16469a.f16491T = new File(this.f16469a.f16520w.m21186n());
                                Message obtain = Message.obtain();
                                obtain.what = 1;
                                this.f16469a.f16499b.sendMessage(obtain);
                                return;
                            }
                        }
                        C5766a.m26469a().m26470a(new C4418i(this.f16469a.f16520w, this.f16469a.f16519v, this.f16469a.f16500c, "0", this.f16469a.f16520w.m21185m()));
                        m21317a();
                    }
                }
                this.f16469a.finish();
            }
        }

        private void m21317a() {
            if (!TextUtils.isEmpty(this.f16469a.f16497Z)) {
                com.huawei.feedback.c.e(this.f16469a.f16497Z);
            }
        }

        private boolean m21318b() {
            return this.f16469a.f16521x.getText() == null || !(this.f16469a.m21350a(this.f16469a.f16521x.getText().toString()) || this.f16469a.f16521x.getText().toString().matches("^[a-zA-Z0-9]+([\\_|\\-|\\.]?[a-zA-Z0-9])*\\@[a-zA-Z0-9]+([\\_|\\-|\\.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,3}$"));
        }

        private void m21319c() {
            try {
                if (this.f16469a.f16487P != null) {
                    this.f16469a.f16498a = this.f16469a.f16487P.getUserType();
                }
            } catch (RemoteException e) {
                c.d("FeedbackEditActivity", "RemoteException");
            } catch (Exception e2) {
                c.d("FeedbackEditActivity", "The init of the object logCollectManager is exception!");
            }
        }
    }

    class C4442k implements OnClickListener {
        final /* synthetic */ FeedbackEditActivity f16470a;

        C4442k(FeedbackEditActivity feedbackEditActivity) {
            this.f16470a = feedbackEditActivity;
        }

        public void onClick(View view) {
            boolean z = !this.f16470a.f16520w.m21178h();
            if (!z || com.huawei.feedback.c.a(this.f16470a) || !com.huawei.feedback.c.a(this.f16470a, "android.permission.WRITE_EXTERNAL_STORAGE", InputDeviceCompat.SOURCE_TOUCHSCREEN)) {
                this.f16470a.f16520w.m21160a(z);
            }
        }
    }

    class C4443l implements OnTouchListener {
        final /* synthetic */ FeedbackEditActivity f16471a;

        private C4443l(FeedbackEditActivity feedbackEditActivity) {
            this.f16471a = feedbackEditActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f16471a.f16517t.setBackgroundResource(d.d(this.f16471a.f16500c, "feedback_title_bar_unnormal_color"));
                this.f16471a.f16511n.setPressed(true);
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.f16471a.f16517t.setBackgroundResource(d.d(this.f16471a.f16500c, "feedback_transparent"));
                this.f16471a.f16511n.setPressed(false);
            }
            return false;
        }
    }

    private static void m21356b(boolean z) {
        f16472H = z;
    }

    private void m21362c(boolean z) {
        m21356b(z);
    }

    private void m21345a(Object obj) {
        if (obj != null && (obj instanceof C4406b)) {
            C4406b c4406b = (C4406b) obj;
            this.f16479G = c4406b;
            if (!(TextUtils.isEmpty(c4406b.m21126a()) || TextUtils.isEmpty(c4406b.m21128b()))) {
                this.f16480I.setVisibility(0);
                this.f16483L.setText(c4406b.m21126a());
                this.f16483L.setTextColor(com.huawei.feedback.c.c(this));
            }
            if (!(TextUtils.isEmpty(c4406b.m21130c()) || TextUtils.isEmpty(c4406b.m21132d()))) {
                this.f16481J.setVisibility(0);
                this.f16484M.setText(c4406b.m21130c());
                this.f16484M.setTextColor(com.huawei.feedback.c.c(this));
            }
            if (!TextUtils.isEmpty(c4406b.m21134e()) && !TextUtils.isEmpty(c4406b.m21136f())) {
                this.f16482K.setVisibility(0);
                this.f16485N.setText(c4406b.m21134e());
                if (this.ae) {
                    this.f16482K.setEnabled(true);
                    this.f16485N.setTextColor(com.huawei.feedback.c.c(this));
                    this.f16486O.setImageResource(d.e(this.f16500c, "feedback_img_service_level11_normal"));
                    return;
                }
                this.f16482K.setBackgroundResource(d.e(this.f16500c, "feedback_btn_small_disable"));
                this.f16482K.setEnabled(false);
                this.f16485N.setTextColor(com.huawei.feedback.c.r(this));
                this.f16486O.setImageResource(d.e(this.f16500c, "feedback_img_service_level11_disable"));
            }
        }
    }

    private void m21361c() {
        if (isFinishing()) {
            c.a("FeedbackEditActivity", "FeedbackEditActivity.this.isFinishing().LACKOF_SPACE");
            return;
        }
        m21369e();
        m21387n();
    }

    private void m21365d() {
        int size = this.f16504g.size() - 1;
        if (this.f16504g.size() < 4 && size >= 0 && this.f16504g.get(size) != null) {
            this.f16504g.add(this.f16505h);
        }
        m21400t();
    }

    private void m21369e() {
        if (this.f16492U != null) {
            this.f16492U.cancel();
        }
    }

    private void m21372f() {
        if (isFinishing()) {
            c.a("FeedbackEditActivity", "FeedbackEditActivity.this.isFinishing().THIRD_APP_LOG_FAILED");
            return;
        }
        if (this.f16491T != null && this.f16491T.exists()) {
            int i = 0;
            while (i < 2) {
                if (this.f16491T.delete()) {
                    c.b("FeedbackEditActivity", "THIRD_APP_LOG_FAILED package file delete sccess!");
                    break;
                } else {
                    c.b("FeedbackEditActivity", "THIRD_APP_LOG_FAILED package file delete fail and try again");
                    i++;
                }
            }
        }
        if (this.f16492U != null) {
            this.f16492U.cancel();
        }
        C5766a.m26469a().m26470a(new C4418i(this.f16520w, this.f16519v, this.f16500c, "0", this.f16520w.m21185m()));
        finish();
    }

    private void m21374g() {
        if (this.f16493V != null) {
            File file = new File(this.f16493V.path);
            c.a("FeedbackEditActivity", "logMetricInfoFile:" + file.toString());
            if (TextUtils.isEmpty(file.toString())) {
                c.a("FeedbackEditActivity", "logMetricInfoFile file path is empty or null!");
            } else if (file.exists() && file.delete()) {
                c.a("FeedbackEditActivity", "logMetricInfoFile file delete success!");
            } else {
                c.a("FeedbackEditActivity", "logMetricInfoFile file not exist or error! file delete fail!");
            }
        }
    }

    private void m21341a(int i) {
        if (this.f16490S != null && this.f16490S.exists()) {
            int i2 = 0;
            while (i2 < 2) {
                if (this.f16490S.delete()) {
                    c.b("FeedbackEditActivity", "package file delete sccess!");
                    return;
                } else {
                    c.b("FeedbackEditActivity", "package file not exist or error! file delete fail!");
                    i2++;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b.a(false);
        this.f16500c = this;
        m21377i();
        try {
            if (getIntent() != null) {
                if (getIntent().getIntExtra(AppOpenOrDownHelper.APP_ID_PARAM, 1) != 1) {
                    this.ad = getIntent().getIntExtra(AppOpenOrDownHelper.APP_ID_PARAM, 1);
                    this.f16520w.m21169d(this.ad);
                    this.f16518u.m21169d(this.ad);
                    b.a(true);
                }
                if (!(getIntent().getStringExtra("questionType") == null || TextUtils.isEmpty(getIntent().getStringExtra("questionType")))) {
                    this.f16488Q = getIntent().getStringExtra("questionType");
                    this.f16520w.m21177h(this.f16488Q);
                    this.f16518u.m21177h(this.f16488Q);
                    this.f16520w.m21162b(0);
                    b.a(true);
                }
                if (getIntent().getStringExtra("logfilePath") != null) {
                    this.f16497Z = getIntent().getStringExtra("logfilePath");
                }
                if (getIntent().getStringExtra("aesSecret") != null) {
                    this.aa = getIntent().getStringExtra("aesSecret");
                }
                if (getIntent().getStringExtra("packageName") != null) {
                    this.ab = getIntent().getStringExtra("packageName");
                }
                if (getIntent().getStringExtra("packageVersion") != null) {
                    this.ac = getIntent().getStringExtra("packageVersion");
                }
                this.ae = getIntent().getBooleanExtra("displayHotline", false);
            }
        } catch (NotFoundException e) {
            b.a(false);
            c.d("FeedbackEditActivity", "FeedbackEditActivity oncreate NotFoundException");
        } catch (Exception e2) {
            b.a(false);
            c.d("FeedbackEditActivity", "onCreate :: hostile attack exception");
        }
        c.b("FeedbackEditActivity", "Edit feedback appid = " + this.ad);
        try {
            this.f16487P = new LogCollectManager(getApplicationContext());
        } catch (Exception e3) {
            c.d("FeedbackEditActivity", "The init of the object logCollectManager is exception!");
        }
        if (b.a()) {
            m21362c(com.huawei.feedback.c.k(this));
            if (f16472H) {
                this.f16520w.m21160a(true);
            }
        }
        m21376h();
        m21395r();
        m21348a(bundle == null, bundle);
        if (com.huawei.feedback.c.e() || com.huawei.feedback.c.m(this)) {
            Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
            if (lastNonConfigurationInstance instanceof C4440i) {
                this.f16478F = (C4440i) lastNonConfigurationInstance;
            } else if ((lastNonConfigurationInstance instanceof AlertDialog) && com.huawei.feedback.c.d() == 1) {
                this.f16508k = (AlertDialog) lastNonConfigurationInstance;
                if (!TextUtils.isEmpty(com.huawei.feedback.a.b.a.a().d())) {
                    this.f16491T = new File(com.huawei.feedback.a.b.a.a().d());
                }
                c.a("FeedbackEditActivity", "waitUploadZipfile:" + this.f16491T);
            }
            if (this.f16478F != null) {
                c.a("FeedbackEditActivity", "packageThread != null");
                this.f16478F.m21316a(this.f16500c);
                this.f16492U = new ProgressDialog(this.f16500c);
                this.f16492U.setMessage(this.f16500c.getString(d.b(this.f16500c, "feedback_waiting")));
                this.f16492U.setCancelable(false);
                this.f16492U.show();
            }
            if (this.f16508k != null) {
                this.f16508k.cancel();
                m21382k();
            }
            m21397s();
            return;
        }
        m21384l();
    }

    public void onSaveInstanceState(Bundle bundle) {
        c.a("FeedbackEditActivity", "onSaveInstanceState");
        bundle.putSerializable("original_draft", this.f16518u);
        bundle.putSerializable("edit_draft", this.f16520w);
        bundle.putInt("draft_id", this.f16519v);
        bundle.putSerializable("package_info", this.f16491T);
        bundle.putParcelable("logMetricInfo", this.f16493V);
        bundle.putString("upload_name", this.f16489R);
        bundle.putString("shared_log", this.f16512o);
        super.onSaveInstanceState(bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        c.b("FeedbackEditActivity", "---onOptionsItemSelected-->>");
        if (this.f16514q.getVisibility() != 0) {
            m21393q();
            if (!TextUtils.isEmpty(this.f16497Z)) {
                com.huawei.feedback.c.e(this.f16497Z);
            }
        } else if (this.f16515r.canGoBack()) {
            this.f16515r.goBack();
        } else {
            this.f16514q.setVisibility(8);
            this.f16513p.setVisibility(0);
            if (this.ag != null) {
                this.ag.setTitle(d.b(this.f16500c, "feedback_other_app"));
            }
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        c.b("FeedbackEditActivity", "---onKeyDown-->>");
        if (i == 4) {
            if (this.f16514q.getVisibility() == 0) {
                if (this.f16515r.canGoBack()) {
                    this.f16515r.goBack();
                    return true;
                }
                this.f16514q.setVisibility(8);
                this.f16513p.setVisibility(0);
                if (this.ag == null) {
                    return true;
                }
                this.ag.setTitle(d.b(this.f16500c, "feedback_other_app"));
                return true;
            } else if (keyEvent.getRepeatCount() == 0 && !this.f16496Y) {
                m21393q();
                if (TextUtils.isEmpty(this.f16497Z)) {
                    return true;
                }
                com.huawei.feedback.c.e(this.f16497Z);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m21376h() {
        if (!f16472H) {
            m21362c(com.huawei.feedback.c.k(this));
        }
        if (com.huawei.phoneserviceuni.common.d.a.m() && com.huawei.phoneserviceuni.common.d.a.n()) {
            setContentView(d.c(this.f16500c, "feedback_edit_50"));
        } else {
            setContentView(d.c(this.f16500c, "feedback_edit"));
        }
        this.f16513p = findViewById(d.a(this.f16500c, "feedback_edit_layout"));
        this.f16514q = findViewById(d.a(this.f16500c, "feedback_web_layout"));
        this.f16513p.setVisibility(0);
        this.f16514q.setVisibility(8);
        this.f16515r = (WebView) findViewById(d.a(this.f16500c, "feedback_webview"));
        this.f16516s = (ProgressBar) findViewById(d.a(this.f16500c, "feedback_progressbar"));
        this.f16480I = (LinearLayout) findViewById(d.a(this.f16500c, "enter_qq_lay"));
        this.f16480I.setOnClickListener(this.ah);
        this.f16481J = (LinearLayout) findViewById(d.a(this.f16500c, "police_service_lay"));
        this.f16481J.setOnClickListener(this.ai);
        this.f16482K = (LinearLayout) findViewById(d.a(this.f16500c, "hotline_service_lay"));
        this.f16482K.setOnClickListener(this.aj);
        this.f16483L = (TextView) findViewById(d.a(this.f16500c, "qq_service_text"));
        this.f16484M = (TextView) findViewById(d.a(this.f16500c, "police_service_text"));
        this.f16485N = (TextView) findViewById(d.a(this.f16500c, "hotline_text"));
        this.f16486O = (ImageView) findViewById(d.a(this.f16500c, "hotline_img"));
        this.f16507j = (Spinner) findViewById(d.a(this.f16500c, "feedback_rl_frequency"));
        this.f16507j.setAdapter(new C4436e(this, this, 17367048, getResources().getStringArray(d.h(this.f16500c, "feedback_frequency"))));
        this.f16507j.setOnItemSelectedListener(new C4434c());
        m21389o();
        this.f16510m = (EditText) findViewById(d.a(this.f16500c, "feedback_edit_activity_content_edittext"));
        this.f16521x = (EditText) findViewById(d.a(this.f16500c, "feedback_edit_activity_contact_edittext"));
        this.f16522y = (TextView) findViewById(d.a(this.f16500c, "feedback_edit_count"));
        this.f16523z = (ImageView) findViewById(d.a(this.f16500c, "name_cancel"));
        if (getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null) == 0) {
            this.f16510m.setBackgroundResource(d.e(this.f16500c, "feedback_edittext_selector"));
            this.f16521x.setBackgroundResource(d.e(this.f16500c, "feedback_edittext_selector"));
        }
        if (com.huawei.phoneserviceuni.common.d.a.m() && com.huawei.phoneserviceuni.common.d.a.n()) {
            ((CounterTextLayout) findViewById(d.a(this.f16500c, "content_countertip"))).setMaxLength(500);
        } else {
            this.f16510m.setFilters(new InputFilter[]{new EditTextInputFilter(this, 500, getString(d.b(this.f16500c, "feedback_more_than_500_characters")))});
        }
        this.f16510m.addTextChangedListener(new C4432a());
        this.f16474B = (ImageView) findViewById(d.a(this.f16500c, "feedback_edit_activity_image"));
        this.f16475C = (TextView) findViewById(d.a(this.f16500c, "feedback_record_textview"));
        this.f16475C.setTextColor(com.huawei.feedback.c.c(this));
        this.f16475C.setOnClickListener(this.ak);
        this.f16475C.setOnTouchListener(new c$a(this.f16475C, this.f16500c));
        this.f16502e = (GridView) findViewById(d.a(this.f16500c, "feedback_add_image_grid"));
        this.f16504g.add(this.f16505h);
        this.f16503f = new ae(this.f16504g, this.f16500c, this.f16499b);
        this.f16502e.setAdapter(this.f16503f);
        this.f16502e.setOnItemClickListener(this.am);
        this.f16511n = (CheckBox) findViewById(d.a(this.f16500c, "feedback_edit_activity_log_checkbox"));
        this.f16511n.setOnClickListener(new C4442k(this));
        this.f16517t = (RelativeLayout) findViewById(d.a(this.f16500c, "systemlog_layout"));
        this.f16517t.setOnTouchListener(new C4443l());
        this.f16517t.setOnClickListener(this.al);
        this.f16521x.setFilters(new InputFilter[]{new EditTextInputFilter(this, 50, getString(d.b(this.f16500c, "feedback_contact_cannot_more_than_50_characters")))});
        this.f16523z.setOnClickListener(this.an);
        this.f16473A = (Button) findViewById(d.a(this.f16500c, "feedback_edit_activity_send_btn"));
        this.f16473A.setOnClickListener(new C4441j(this));
        m21366d(false);
        this.f16521x.addTextChangedListener(new C4433b());
        this.f16476D = (TextView) findViewById(d.a(this.f16500c, "feedback_edit_add_image_text"));
        this.f16476D.setText(String.format(getString(d.b(this.f16500c, "feedback_add_image_new")), new Object[]{Integer.valueOf(4)}));
    }

    private void m21348a(boolean z, Bundle bundle) {
        if (this.f16520w == null) {
            c.a("FeedbackEditActivity", "feedbackInfo null");
            return;
        }
        this.f16510m.setText(this.f16520w.m21175g());
        this.f16506i = this.f16520w.m21185m();
        c.a("currentFrequency", this.f16506i);
        if (!(z || bundle == null)) {
            C4409c c4409c = (C4409c) bundle.getSerializable("edit_draft");
            if (c4409c != null) {
                m21347a(c4409c.m21161b());
            }
        }
        if (this.f16520w.m21178h()) {
            this.f16511n.setChecked(true);
            if (!com.huawei.feedback.c.a(this) && com.huawei.feedback.c.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", InputDeviceCompat.SOURCE_TOUCHSCREEN)) {
                return;
            }
        }
        this.f16511n.setChecked(false);
        if (this.f16519v == 0 && TextUtils.isEmpty(this.f16520w.m21181j())) {
            String b = com.huawei.feedback.c.b(this);
            if (!TextUtils.isEmpty(b) && (PhoneNumberUtils.isGlobalPhoneNumber(b) || m21358b(b))) {
                this.f16520w.m21176g(b);
            }
        }
        this.f16521x.setText(this.f16520w.m21181j());
        m21391p();
    }

    private void m21377i() {
        this.ag = getActionBar();
        if (this.ag != null) {
            this.ag.setDisplayShowCustomEnabled(true);
            this.ag.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void m21366d(boolean z) {
        if (!com.huawei.phoneserviceuni.common.d.a.j() || !com.huawei.phoneserviceuni.common.d.a.g()) {
            this.f16473A.setVisibility(0);
            this.f16473A.setEnabled(z);
        } else if (z) {
            if (com.huawei.phoneserviceuni.common.d.a.m()) {
                ActionBarEx.setEndIcon(getActionBar(), true, getResources().getDrawable(d.e(this.f16500c, "feedback_ic_sent_selector")), new C4441j(this));
            } else {
                ActionBarEx.setEndIcon(getActionBar(), true, getResources().getDrawable(d.e(this.f16500c, "feedback_smarthelper_ic_send_msg")), new C4441j(this));
            }
        } else if (com.huawei.phoneserviceuni.common.d.a.m()) {
            ActionBarEx.setEndIcon(getActionBar(), true, getResources().getDrawable(d.e(this.f16500c, "feedback_ic_sent_out_unroutable")), null);
        } else {
            ActionBarEx.setEndIcon(getActionBar(), true, getResources().getDrawable(d.e(this.f16500c, "feedback_smarthelper_ic_send_msg_disable")), null);
        }
    }

    private void m21380j() {
        this.f16520w.m21161b().clear();
    }

    private void m21346a(String str, String str2) {
        C4413c c4413c = new C4413c();
        c4413c.m21246a(str);
        if (TextUtils.isEmpty(str2)) {
            c4413c.m21248b("image/jpeg");
        } else {
            c4413c.m21248b(str2);
        }
        int size = this.f16504g.size() - 1;
        if (size >= 0 && this.f16504g.get(size) == null) {
            this.f16504g.remove(size);
        }
        this.f16504g.add(c4413c);
        if (this.f16504g.size() < 4) {
            this.f16504g.add(this.f16505h);
        }
        this.f16520w.m21159a(this.f16504g);
        m21400t();
    }

    private void m21382k() {
        View inflate;
        com.huawei.feedback.c.a(1);
        if (com.huawei.phoneserviceuni.common.d.a.f()) {
            inflate = LayoutInflater.from(this).inflate(d.c(this.f16500c, "feedback_dialog_iswifi_new"), null);
        } else {
            inflate = LayoutInflater.from(this).inflate(d.c(this.f16500c, "feedback_dialog_iswifi"), null);
        }
        Builder builder = new Builder(this);
        TextView textView = (TextView) inflate.findViewById(d.a(this.f16500c, "dialog_tv_reminder"));
        if (this.f16491T != null) {
            double length = ((double) this.f16491T.length()) / 1024.0d;
            if (length < 1024.0d) {
                textView.setText(String.format(getString(d.b(this.f16500c, "feedback_advanced_logupload_tips_new_two")), new Object[]{Integer.valueOf((int) Math.ceil(length))}));
            } else {
                textView.setText(String.format(getString(d.b(this.f16500c, "feedback_advanced_logupload_tips_new")), new Object[]{Integer.valueOf((int) Math.ceil(length / 1024.0d))}));
            }
            c.b("FeedbackEditActivity", "fileResultLength = " + length);
            builder.setView(inflate);
            builder.setPositiveButton(getString(d.b(this.f16500c, "feedback_ok")), new C4439h()).setNegativeButton(getString(d.b(this.f16500c, "feedback_cancel")), new C4438g());
            this.f16508k = builder.create();
            this.f16508k.setCanceledOnTouchOutside(false);
            this.f16508k.setOnKeyListener(this.f16501d);
            this.f16508k.show();
        }
    }

    private void m21384l() {
        Builder builder = new Builder(this);
        builder.setMessage(getString(d.b(this.f16500c, "feedback_oversea_tip")));
        builder.setPositiveButton(getString(d.b(this, "feedback_advanced_success_confirm")), new C4437f());
        this.f16509l = builder.create();
        this.f16509l.setCanceledOnTouchOutside(false);
        this.f16509l.setOnKeyListener(this.f16501d);
        this.f16509l.show();
    }

    private void m21385m() {
        View inflate;
        if (com.huawei.phoneserviceuni.common.d.a.f()) {
            inflate = LayoutInflater.from(this).inflate(d.c(this.f16500c, "feedback_dialog_zipfailed_new"), null);
        } else {
            inflate = LayoutInflater.from(this).inflate(d.c(this.f16500c, "feedback_dialog_zipfailed"), null);
        }
        Builder builder = new Builder(this);
        builder.setView(inflate);
        builder.setPositiveButton(getString(d.b(this.f16500c, "feedback_advanced_fail_confirm_one")), new C4463l(this)).setNegativeButton(getString(d.b(this.f16500c, "feedback_cancel")), new C4474w(this));
        this.f16494W = builder.create();
        this.f16494W.setCanceledOnTouchOutside(false);
        this.f16494W.setOnKeyListener(this.f16501d);
        this.f16494W.show();
    }

    private void m21387n() {
        View inflate;
        if (com.huawei.phoneserviceuni.common.d.a.f()) {
            inflate = LayoutInflater.from(this).inflate(d.c(this.f16500c, "feedback_dialog_lackof_space_new"), null);
        } else {
            inflate = LayoutInflater.from(this).inflate(d.c(this.f16500c, "feedback_dialog_lackof_space"), null);
        }
        Builder builder = new Builder(this);
        builder.setView(inflate);
        builder.setPositiveButton(getString(d.b(this.f16500c, "feedback_advanced_success_confirm")), new C4464m(this));
        this.f16495X = builder.create();
        this.f16495X.setCanceledOnTouchOutside(false);
        this.f16495X.setOnKeyListener(this.f16501d);
        this.f16495X.show();
    }

    private void m21389o() {
        this.f16501d = new C4435d();
    }

    private boolean m21350a(String str) {
        return Pattern.compile("^\\d{11}$").matcher(str).matches();
    }

    private boolean m21358b(String str) {
        return str.matches("^[a-zA-Z0-9]+([\\_|\\-|\\.]?[a-zA-Z0-9])*\\@[a-zA-Z0-9]+([\\_|\\-|\\.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,3}$");
    }

    private void m21391p() {
        String obj = this.f16510m.getText().toString();
        int length = obj.length();
        if (length <= 0 || length > 500 || obj.trim().isEmpty() || TextUtils.isEmpty(this.f16521x.getText())) {
            m21366d(false);
        } else {
            m21366d(true);
        }
    }

    private void m21342a(Intent intent) {
        String a = com.huawei.feedback.c.a(this, intent.getData());
        String type = intent.getType();
        if (a == null) {
            c.c("FeedbackEditActivity", "null == imagePath,will getRealImagePath");
            a = com.huawei.feedback.c.a(intent.getData(), this);
        }
        if (VERSION.SDK_INT <= 22 || com.huawei.feedback.c.a(this) || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            m21355b(a, type);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case TradeCode.DEAL_WITH_DOUBT /*3021*/:
                this.f16477E = false;
                if (-1 == i2 && intent != null) {
                    m21342a(intent);
                    return;
                }
                return;
            case 3022:
                if (-1 != i2) {
                    return;
                }
                if (intent.getBooleanExtra("close_activity", false)) {
                    finish();
                    return;
                } else if (intent.getBooleanExtra("del_screenshot", false)) {
                    m21380j();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private void m21355b(String str, String str2) {
        if (!com.huawei.feedback.c.a(this) && com.huawei.feedback.c.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", FragmentTransaction.TRANSIT_FRAGMENT_OPEN)) {
            return;
        }
        if (!com.huawei.feedback.c.d(str)) {
            Toast.makeText(this.f16500c, this.f16500c.getString(d.b(this.f16500c, "feedback_file_format_not_support")), 0).show();
        } else if (new File(str).exists()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (decodeFile == null) {
                Toast.makeText(this.f16500c, this.f16500c.getString(d.b(this.f16500c, "feedback_file_format_not_support")), 0).show();
                return;
            }
            if (!decodeFile.isRecycled()) {
                decodeFile.recycle();
            }
            m21346a(str, str2);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f16500c = null;
        this.f16496Y = false;
        if (this.f16492U != null && this.f16492U.isShowing()) {
            this.f16492U.cancel();
            this.f16492U = null;
        }
        if (this.f16508k != null && this.f16508k.isShowing()) {
            this.f16508k.cancel();
            this.f16508k = null;
        }
    }

    private void m21393q() {
        c.b("FeedbackEditActivity", "---!CommonConstants.isFromOutside()-->>" + (!b.a()));
        finish();
    }

    protected void onPause() {
        super.onPause();
        d.i(this, "onPause");
        d.i(this, "onReport");
    }

    protected void onResume() {
        super.onResume();
        d.i(this, "onResume");
        try {
            if (getIntent() == null || getIntent().getIntExtra(AppOpenOrDownHelper.APP_ID_PARAM, 1) == 1) {
                b.a(false);
            } else {
                b.a(true);
            }
            if (getIntent() == null || getIntent().getStringExtra("questionType") == null || TextUtils.isEmpty(getIntent().getStringExtra("questionType"))) {
                b.a(false);
            } else {
                b.a(true);
            }
        } catch (NotFoundException e) {
            b.a(false);
            c.d("FeedbackEditActivity", "FeedbackEditActivity onResume NotFoundException");
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        m21395r();
        super.onConfigurationChanged(configuration);
    }

    private void m21395r() {
        int b = f.b(this, d.f(this.f16500c, "feedback_layout_start_end_padding"));
        LayoutParams layoutParams = (LayoutParams) this.f16473A.getLayoutParams();
        if (b > 0) {
            layoutParams.width = b;
        } else if (getResources().getConfiguration().orientation == 2) {
            layoutParams.width = getResources().getDimensionPixelSize(d.f(this.f16500c, "feedback_btn_width"));
        } else {
            layoutParams.width = -1;
        }
        this.f16473A.setLayoutParams(layoutParams);
    }

    public Object onRetainNonConfigurationInstance() {
        c.a("FeedbackEditActivity", "onRetainNonConfigurationInstance");
        if (this.f16478F != null) {
            if (this.f16478F.isAlive()) {
                return this.f16478F;
            }
            if (this.f16492U != null && this.f16492U.isShowing()) {
                this.f16492U.cancel();
            }
        }
        if (this.f16508k == null || !this.f16508k.isShowing()) {
            return null;
        }
        return this.f16508k;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        m21391p();
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 4096:
                if (m21351a(iArr)) {
                    this.f16477E = true;
                    com.huawei.feedback.c.a(this, TradeCode.DEAL_WITH_DOUBT);
                    return;
                }
                c.d("FeedbackEditActivity", "WRITE_EXTERNAL_STORAGE Permission denied!");
                return;
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /*4097*/:
                if (m21351a(iArr)) {
                    m21347a(this.f16520w.m21161b());
                    return;
                }
                c.d("FeedbackEditActivity", "PERMISSION_REQUEST_SHOW_IMAGE Permission denied!");
                m21393q();
                return;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /*4098*/:
                if (m21351a(iArr)) {
                    this.f16520w.m21160a(true);
                    return;
                }
                c.d("FeedbackEditActivity", "PERMISSION_REQUEST_SAVE_LOGCAT Permission denied!");
                this.f16511n.setChecked(false);
                this.f16520w.m21160a(false);
                return;
            default:
                return;
        }
    }

    private boolean m21351a(int[] iArr) {
        if (iArr.length < 1 || iArr[0] != 0) {
            return false;
        }
        return true;
    }

    private void m21397s() {
        new Thread(new C4415e(this.f16499b, this, this.ad)).start();
    }

    private void m21400t() {
        if (this.f16503f != null) {
            this.f16503f.notifyDataSetChanged();
        }
    }

    private void m21347a(List<C4413c> list) {
        int size = list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                C4413c c4413c = (C4413c) list.get(i);
                if (c4413c != null) {
                    if (TextUtils.isEmpty(c4413c.m21245a())) {
                        m21380j();
                    } else {
                        m21355b(c4413c.m21245a(), c4413c.m21247b());
                    }
                }
            }
        }
    }

    private void m21401u() {
        WebSettings settings = this.f16515r.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        if (!(this.f16479G == null || TextUtils.isEmpty(this.f16479G.m21132d()) || !com.huawei.feedback.c.c(this, this.f16479G.m21132d()))) {
            c.b("FeedbackEditActivity", "initWebView setJavaScriptEnabled true");
            settings.setJavaScriptEnabled(true);
            com.huawei.feedback.c.a(this.f16515r);
        }
        settings.setCacheMode(-1);
        this.f16515r.setWebViewClient(this.ao);
        this.f16515r.setWebChromeClient(this.ap);
    }
}
