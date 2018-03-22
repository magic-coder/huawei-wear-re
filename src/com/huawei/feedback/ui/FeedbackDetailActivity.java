package com.huawei.feedback.ui;

import android.app.ActionBar;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.feedback.FeedbackApi;
import com.huawei.feedback.bean.C4410d;
import com.huawei.feedback.d;
import com.huawei.feedback.logic.C4416g;
import com.huawei.feedback.logic.C4418i;
import com.huawei.feedback.logic.f;
import com.huawei.feedback.ui.CustomEdittext.CustomEditText;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.phoneserviceuni.common.d.a;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.p496b.C5766a;
import com.huawei.phoneserviceuni.common.widget.EditTextInputFilter;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class FeedbackDetailActivity extends BaseActivity {
    C4410d f16437a = null;
    C4410d f16438b = null;
    String f16439c = "";
    Bitmap f16440d = null;
    private ResizeRelativeLayout f16441e;
    private ActionBar f16442f;
    private ListView f16443g;
    private C4458g f16444h;
    private Button f16445i;
    private LinearLayout f16446j;
    private CustomEditText f16447k;
    private ImageView f16448l;
    private Button f16449m;
    private ImageButton f16450n;
    private List<C4410d> f16451o;
    private String f16452p;
    private String f16453q;
    private String f16454r;
    private boolean f16455s = false;
    private OnClickListener f16456t = new C4454d(this);
    private Handler f16457u = new C4456f(this);

    class C4431a implements DialogInterface.OnClickListener {
        private C4431a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    protected void onPause() {
        super.onPause();
        d.i(this, "onPause");
        d.i(this, "onReport");
    }

    protected void onResume() {
        super.onResume();
        d.i(this, "onResume");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (FeedbackApi.getApplicationcontext() == null) {
            c.d("FeedbackDetailActivity", "FeedbackApi.getApplicationcontext() null!");
            return;
        }
        m21302c();
        setContentView(d.c(this, "feedback_detail"));
        this.f16441e = (ResizeRelativeLayout) findViewById(d.a(this, "feedback_datail_layout"));
        this.f16443g = (ListView) findViewById(d.a(this, "feedback_detail_list"));
        m21314k();
        this.f16446j = (LinearLayout) findViewById(d.a(this, "feedback_input_layout"));
        this.f16448l = (ImageView) findViewById(d.a(this, "feedback_edittext_imageview"));
        this.f16450n = (ImageButton) this.f16446j.findViewById(d.a(this, "add_image_btn"));
        this.f16449m = (Button) this.f16446j.findViewById(d.a(this, "feedback_send_btn"));
        if (!a.m()) {
            this.f16450n.setBackground(getResources().getDrawable(d.e(this, "feedback_add_image_selectorlow")));
            this.f16449m.setBackground(getResources().getDrawable(d.e(this, "feedback_send_btn_selectorlow")));
        }
        this.f16447k = (CustomEditText) this.f16446j.findViewById(d.a(this, "feedback_input_view"));
        this.f16447k.setFilters(new InputFilter[]{new EditTextInputFilter(this, 500, getString(d.b(this, "feedback_more_than_500_characters")))});
        this.f16447k.m21283a(this.f16457u);
        m21303d();
        View inflate = LayoutInflater.from(this).inflate(d.c(this, "feedback_detail_top_type_item"), null);
        m21298b();
        m21293a(bundle);
        if (!(this.f16451o == null || this.f16451o.isEmpty())) {
            TextView textView = (TextView) inflate.findViewById(d.a(this, "feedback_top_type_txt"));
            if (!(TextUtils.isEmpty(this.f16439c) || this.f16439c.trim().matches(HwAccountConstants.DIGITAL_REGX))) {
                textView.setText(this.f16439c);
            }
            this.f16443g.addHeaderView(inflate);
        }
        C4416g.m21259c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!(this.f16447k.getText().toString().trim().isEmpty() && this.f16448l.getTag() == null)) {
            Serializable c4410d = new C4410d();
            c4410d.m21217k(this.f16447k.getText().toString().trim());
            if (this.f16448l.getTag() != null && (this.f16448l.getTag() instanceof af)) {
                af afVar = (af) this.f16448l.getTag();
                c4410d.m21219l(afVar.m21458a());
                c4410d.m21223n(afVar.m21460b());
            }
            bundle.putSerializable("save_draft_state", c4410d);
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f16440d != null && !this.f16440d.isRecycled()) {
            this.f16440d.recycle();
            this.f16440d = null;
        }
    }

    private void m21298b() {
        this.f16445i.setOnClickListener(this.f16456t);
        this.f16449m.setOnClickListener(this.f16456t);
        this.f16450n.setOnClickListener(this.f16456t);
        this.f16441e.m21453a(new C4448a(this));
        this.f16447k.addTextChangedListener(new C4452b(this));
        this.f16443g.setOnScrollListener(new C4453c(this));
    }

    private void m21293a(Bundle bundle) {
        if (this.f16451o == null || this.f16451o.isEmpty()) {
            finish();
            return;
        }
        this.f16439c = ((C4410d) this.f16451o.get(0)).m21220m();
        this.f16452p = ((C4410d) this.f16451o.get(0)).m21229r();
        this.f16453q = ((C4410d) this.f16451o.get(0)).m21233v();
        this.f16454r = ((C4410d) this.f16451o.get(0)).m21234w();
        this.f16438b = m21305e();
        this.f16437a = null;
        if (bundle != null) {
            this.f16437a = (C4410d) bundle.getSerializable("save_draft_state");
        }
        if (this.f16437a != null) {
            m21294a(this.f16437a);
        } else if (this.f16438b != null) {
            m21294a(this.f16438b);
        } else {
            m21300b(false);
        }
        this.f16444h = new C4458g(this, this.f16451o);
        this.f16443g.setAdapter(this.f16444h);
        this.f16443g.setSelection(this.f16444h.getCount());
    }

    private void m21294a(C4410d c4410d) {
        if (c4410d == null) {
            m21300b(false);
            return;
        }
        if (!(c4410d.m21228q() == null || "".equals(c4410d.m21228q()))) {
            m21297a(c4410d.m21228q(), c4410d.m21232u());
        }
        if (!(c4410d.m21226p() == null || c4410d.m21226p().isEmpty())) {
            this.f16447k.setText(c4410d.m21226p());
            this.f16449m.setEnabled(true);
            this.f16449m.setTextColor(getResources().getColor(d.d(this, "feedback_white")));
        }
        m21300b(true);
    }

    private void m21302c() {
        this.f16442f = getActionBar();
        if (this.f16442f != null) {
            this.f16442f.setDisplayShowCustomEnabled(true);
            this.f16442f.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m21309g();
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        m21309g();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == TradeCode.DEAL_WITH_DOUBT) {
            this.f16455s = false;
            if (-1 == i2 && intent != null) {
                if (this.f16448l.getTag() != null) {
                    Builder builder = new Builder(this);
                    builder.setTitle(d.b(this, "feedback_dialog_title")).setMessage(d.b(this, "feedback_notify_to_replace_pic")).setPositiveButton(17039379, new C4455e(this, intent)).setNegativeButton(17039360, new C4431a());
                    builder.create().show();
                    return;
                }
                m21291a(intent);
            }
        }
    }

    private void m21303d() {
        this.f16452p = getIntent().getStringExtra("pQuestionId");
        c.c("FeedbackDetailActivity", "pQuestionId: " + this.f16452p);
        if (this.f16452p != null) {
            List b = f.b(this.f16452p);
            this.f16451o = new ArrayList();
            int size = b.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    C4410d c4410d = (C4410d) b.get(i);
                    if (c4410d != null) {
                        Object q = c4410d.m21228q();
                        Object u = c4410d.m21232u();
                        if (TextUtils.isEmpty(q) && TextUtils.isEmpty(u)) {
                            this.f16451o.add(c4410d);
                        } else {
                            String[] split = q.split("\\|");
                            String[] split2 = u.split("\\|");
                            if (split.length > 0) {
                                String p = c4410d.m21226p();
                                for (int i2 = 0; i2 < split.length; i2++) {
                                    q = split[i2];
                                    if (!TextUtils.isEmpty(q) && new File(q).exists()) {
                                        try {
                                            C4410d c4410d2 = (C4410d) c4410d.clone();
                                            c4410d2.m21217k("");
                                            c4410d2.m21219l(split[i2]);
                                            c4410d2.m21223n(split2[i2]);
                                            this.f16451o.add(c4410d2);
                                        } catch (CloneNotSupportedException e) {
                                            c.d("FeedbackDetailActivity", "clone image CloneNotSupportedException ");
                                        }
                                    }
                                }
                                try {
                                    c4410d = (C4410d) c4410d.clone();
                                    c4410d.m21217k(p);
                                    c4410d.m21219l("");
                                    c4410d.m21223n("");
                                    this.f16451o.add(c4410d);
                                } catch (CloneNotSupportedException e2) {
                                    c.d("FeedbackDetailActivity", "clone Content CloneNotSupportedException ");
                                }
                            } else {
                                this.f16451o.add(c4410d);
                            }
                        }
                    }
                }
            }
            c.c("FeedbackDetailActivity", "listData: " + this.f16451o + "  " + this.f16451o.size());
        }
    }

    private C4410d m21305e() {
        C4410d c4410d = null;
        Iterator it = this.f16451o.iterator();
        while (it.hasNext()) {
            C4410d c4410d2 = (C4410d) it.next();
            if (c4410d2.m21224o() == 3) {
                it.remove();
            } else {
                c4410d2 = c4410d;
            }
            c4410d = c4410d2;
        }
        return c4410d;
    }

    private void m21300b(boolean z) {
        if (z) {
            this.f16445i.setVisibility(8);
            this.f16446j.setVisibility(0);
            this.f16447k.setFocusable(true);
            this.f16447k.setFocusableInTouchMode(true);
            return;
        }
        this.f16446j.setVisibility(8);
        this.f16445i.setVisibility(0);
    }

    private void m21308f() {
        if (this.f16447k.getText().toString().trim().isEmpty()) {
            this.f16449m.setEnabled(false);
            this.f16449m.setTextColor(getResources().getColor(d.d(this, "feedback_light_white")));
            return;
        }
        this.f16449m.setEnabled(true);
        this.f16449m.setTextColor(getResources().getColor(d.d(this, "feedback_white")));
    }

    private void m21309g() {
        if (FeedbackApi.getApplicationcontext() == null) {
            c.d("FeedbackDetailActivity", "FeedbackApi.getApplicationcontext() null!");
            finish();
            return;
        }
        af afVar;
        if (this.f16438b != null) {
            if (this.f16447k.getText().toString().trim().isEmpty() && this.f16448l.getTag() == null) {
                f.a(this.f16438b.m21231t());
            } else {
                String str = "";
                String str2 = "";
                if (this.f16448l.getTag() != null) {
                    afVar = (af) this.f16448l.getTag();
                    str = afVar.m21458a();
                    str2 = afVar.m21460b();
                }
                String trim = this.f16447k.getText().toString().trim();
                Object obj = "";
                if (this.f16438b.m21228q() != null) {
                    obj = this.f16438b.m21228q();
                }
                if (trim.equals(this.f16438b.m21226p()) && str.equals(r2)) {
                    finish();
                    return;
                }
                f.a(this.f16438b.m21231t());
                this.f16438b.m21217k(trim);
                this.f16438b.m21219l(str);
                this.f16438b.m21223n(str2);
                this.f16438b.m21225o(this.f16453q);
                this.f16438b.m21227p(this.f16454r);
                try {
                    this.f16438b.m21215j(new SimpleDateFormat("yyyy/M/d HH:mm", Locale.US).format(new Date()));
                } catch (IllegalArgumentException e) {
                    c.d("FeedbackDetailActivity", "get date IllegalArgumentException");
                } catch (Exception e2) {
                    c.d("FeedbackDetailActivity", "get date Exception");
                }
                f.a(this.f16438b);
            }
        } else if (this.f16447k.getText().toString().trim().isEmpty() && this.f16448l.getTag() == null) {
            finish();
            return;
        } else {
            C4410d c4410d = new C4410d();
            c4410d.m21217k(this.f16447k.getText().toString().trim());
            if (this.f16448l.getTag() != null) {
                afVar = (af) this.f16448l.getTag();
                c4410d.m21219l(afVar.m21458a());
                c4410d.m21223n(afVar.m21460b());
            }
            try {
                c4410d.m21215j(new SimpleDateFormat("yyyy/M/d HH:mm", Locale.US).format(new Date()));
            } catch (IllegalArgumentException e3) {
                c.d("FeedbackDetailActivity", "backEvent get date IllegalArgumentException");
            } catch (Exception e4) {
                c.d("FeedbackDetailActivity", "backEvent get date Exception");
            }
            c4410d.m21196c(3);
            c4410d.m21213i(this.f16439c);
            c4410d.m21221m(this.f16452p);
            c4410d.m21225o(this.f16453q);
            c4410d.m21227p(this.f16454r);
            f.a(c4410d);
        }
        Intent intent = new Intent();
        intent.putExtra("pQuestionId", this.f16452p);
        setResult(102, intent);
        finish();
    }

    private void m21311h() {
        if (a.a(this)) {
            String obj = this.f16447k.getText().toString();
            C4410d c4410d = new C4410d();
            c4410d.m21221m(this.f16452p);
            c4410d.m21196c(1);
            c4410d.m21217k(obj);
            if (this.f16448l.getTag() != null) {
                af afVar = (af) this.f16448l.getTag();
                c4410d.m21223n(afVar.m21460b());
                c4410d.m21219l(afVar.m21458a());
            }
            c4410d.m21213i(this.f16439c);
            c4410d.m21225o(this.f16453q);
            c4410d.m21227p(this.f16454r);
            try {
                c4410d.m21215j(new SimpleDateFormat("yyyy/M/d HH:mm", Locale.US).format(new Date()));
            } catch (IllegalArgumentException e) {
                c.d("FeedbackDetailActivity", "sendFeedback get date IllegalArgumentException");
            } catch (Exception e2) {
                c.d("FeedbackDetailActivity", "sendFeedback get date Exception");
            }
            if (this.f16438b != null) {
                f.a(this.f16438b.m21231t());
            }
            C5766a.m26469a().m26470a(new C4418i(c4410d));
            C4416g.m21257a((Context) this, 0, null);
            finish();
            return;
        }
        Toast.makeText(this, d.b(this, "feedback_no_network_connection_prompt"), 0).show();
    }

    private void m21312i() {
        if (!this.f16455s && !com.huawei.feedback.c.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 4096)) {
            this.f16455s = true;
            com.huawei.feedback.c.a(this, TradeCode.DEAL_WITH_DOUBT);
        }
    }

    private void m21313j() {
        this.f16448l.setVisibility(8);
        this.f16448l.setTag(null);
        if (this.f16440d != null && !this.f16440d.isRecycled()) {
            this.f16440d.recycle();
            this.f16440d = null;
        }
    }

    private void m21291a(Intent intent) {
        String a = com.huawei.feedback.c.a(this, intent.getData());
        String type = intent.getType();
        if (a == null) {
            c.c("FeedbackDetailActivity", "null == imagePath,will getRealImagePath");
            try {
                a = com.huawei.feedback.c.a(intent.getData(), this);
            } catch (Exception e) {
                c.c("FeedbackDetailActivity", "can not getRealImagePath");
            }
        }
        if (VERSION.SDK_INT <= 22 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            m21297a(a, type);
        }
    }

    private void m21297a(String str, String str2) {
        if (!com.huawei.feedback.c.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", FragmentTransaction.TRANSIT_FRAGMENT_OPEN)) {
            if (!com.huawei.feedback.c.d(str)) {
                Toast.makeText(this, getString(d.b(this, "feedback_file_format_not_support")), 0).show();
            } else if (new File(str).exists()) {
                this.f16440d = com.huawei.phoneserviceuni.common.d.f.a(str, this.f16448l.getWidth(), this.f16448l.getHeight());
                if (this.f16440d == null) {
                    Toast.makeText(this, getString(d.b(this, "feedback_file_format_not_support")), 0).show();
                } else {
                    m21292a(this.f16440d, str, str2);
                }
            } else {
                c.d("FeedbackDetailActivity", "image is not exist");
            }
        }
    }

    private void m21292a(Bitmap bitmap, String str, String str2) {
        af afVar = new af();
        afVar.m21459a(str);
        if (TextUtils.isEmpty(str2)) {
            afVar.m21461b("");
        } else {
            afVar.m21461b(str2);
        }
        this.f16448l.setVisibility(0);
        this.f16448l.setImageBitmap(bitmap);
        this.f16448l.setTag(afVar);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m21314k();
        if (this.f16444h != null) {
            this.f16444h.notifyDataSetChanged();
        }
    }

    private void m21314k() {
        int b = com.huawei.phoneserviceuni.common.d.f.b(this, d.f(this, "feedback_layout_start_end_padding"));
        this.f16445i = (Button) findViewById(d.a(this, "feedback_continue_txtview"));
        LayoutParams layoutParams = (LayoutParams) this.f16445i.getLayoutParams();
        if (b > 0) {
            layoutParams.width = b;
        } else if (getResources().getConfiguration().orientation == 2) {
            layoutParams.width = getResources().getDimensionPixelSize(d.f(this, "feedback_btn_width"));
        } else {
            layoutParams.width = -1;
        }
        this.f16445i.setLayoutParams(layoutParams);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 4096:
                if (iArr.length < 1 || iArr[0] != 0) {
                    c.d("FeedbackDetailActivity", "WRITE_EXTERNAL_STORAGE Permission denied!");
                    Toast.makeText(this, d.b(this, "feedback_no_authority_tips"), 0).show();
                    return;
                }
                this.f16455s = true;
                com.huawei.feedback.c.a(this, TradeCode.DEAL_WITH_DOUBT);
                return;
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /*4097*/:
                if (iArr.length < 1 || iArr[0] != 0) {
                    c.d("FeedbackDetailActivity", "WRITE_EXTERNAL_STORAGE denied!");
                    Toast.makeText(this, d.b(this, "feedback_no_authority_tips"), 0).show();
                    m21309g();
                    return;
                } else if (this.f16437a != null && !TextUtils.isEmpty(this.f16437a.m21228q())) {
                    m21297a(this.f16437a.m21228q(), this.f16437a.m21232u());
                    return;
                } else if (this.f16438b != null && !TextUtils.isEmpty(this.f16438b.m21228q())) {
                    m21297a(this.f16438b.m21228q(), this.f16438b.m21232u());
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
