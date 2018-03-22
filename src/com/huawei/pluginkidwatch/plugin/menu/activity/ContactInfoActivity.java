package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.EditManagerModel;
import com.huawei.pluginkidwatch.common.entity.model.TransferPrivilegeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UnbindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.common.ui.view.ae;
import com.huawei.pluginkidwatch.common.ui.view.af;
import com.huawei.pluginkidwatch.common.ui.view.ag;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Pattern;
import org.apache.log4j.helpers.FileWatchdog;

public class ContactInfoActivity extends KidWatchBaseActivity implements OnClickListener, ag {
    private String f5528A = "0";
    private int f5529B = 8;
    private String f5530C = "-1";
    private int f5531D = 21;
    private String f5532E = "";
    private UserInfo f5533F = new UserInfo();
    private byte[] f5534G;
    private String f5535H = "0";
    private bw f5536I = new bw();
    private final int f5537J = 5;
    private final int f5538K = 11;
    private final int f5539L = 56;
    private String f5540M = "";
    private bx f5541N = null;
    private boolean f5542O = false;
    private ae f5543P;
    private C1507h f5544Q = null;
    private EditText f5545R;
    private final int f5546S = 4;
    private final int f5547T = 10;
    private final char f5548U = '·';
    private String f5549V = "";
    private OnClickListener f5550W = new bi(this);
    private TextWatcher f5551X = new bl(this);
    private TextView f5552b;
    private LinearLayout f5553c;
    private String f5554d = "";
    private TextView f5555e;
    private TextView f5556f;
    private TextView f5557g;
    private TextView f5558h;
    private TextView f5559i;
    private ImageView f5560j;
    private ImageView f5561k;
    private ImageView f5562l;
    private RelativeLayout f5563m;
    private RelativeLayout f5564n;
    private CustomDialog f5565o;
    private CustomDialog f5566p;
    private CustomDialog f5567q;
    private C1507h f5568r = null;
    private C1507h f5569s = null;
    private C1413d f5570t;
    private String f5571u = "";
    private String f5572v = "";
    private String f5573w = "";
    private String f5574x = "";
    private String f5575y = "";
    private String f5576z = "-1";

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_contact_info);
        this.f5570t = C1417a.m6594a(this);
        this.f5541N = new bx();
        this.f5543P = new ae(this);
        this.f5543P.m7239a((ag) this);
        this.f5556f = (TextView) findViewById(g.infotitle);
        this.f5552b = (TextView) findViewById(g.menu_tv_unbindall);
        this.f5553c = (LinearLayout) findViewById(g.menu_ly_delete_or_transfer);
        this.f5555e = (TextView) findViewById(g.menu_tv_info_delete);
        this.f5557g = (TextView) findViewById(g.menu_tv_info_transfer);
        this.f5558h = (TextView) findViewById(g.menu_tv_phone);
        this.f5559i = (TextView) findViewById(g.menu_tv_relation);
        this.f5560j = (ImageView) findViewById(g.menu_iv_relation_arrow);
        this.f5561k = (ImageView) findViewById(g.menu_iv_phone_arrow);
        this.f5562l = (ImageView) findViewById(g.menu_iv_head);
        this.f5563m = (RelativeLayout) findViewById(g.menu_info_rl_name);
        this.f5564n = (RelativeLayout) findViewById(g.menu_info_rl_phone);
        this.f5552b.setOnClickListener(this);
        this.f5555e.setOnClickListener(this);
        this.f5557g.setOnClickListener(this);
        this.f5563m.setOnClickListener(this);
        this.f5564n.setOnClickListener(this);
        this.f5562l.setOnClickListener(this);
        this.f5554d = getIntent().getStringExtra("ttyy");
        this.f5571u = getIntent().getStringExtra("huid");
        this.f5572v = getIntent().getStringExtra("nickname");
        this.f5573w = getIntent().getStringExtra("phoneNum");
        this.f5574x = getIntent().getStringExtra("bigHeadIcon");
        this.f5575y = getIntent().getStringExtra("headIcon");
        this.f5576z = getIntent().getStringExtra("privilege");
        this.f5528A = getIntent().getStringExtra("type");
        this.f5529B = getIntent().getIntExtra("sosPriority", 8);
        this.f5530C = getIntent().getStringExtra("deviceCode");
        this.f5531D = getIntent().getIntExtra("id", -1);
        this.f5535H = this.f5528A;
        this.f5533F.huid = this.f5571u;
        this.f5533F.nickname = this.f5572v;
        this.f5533F.privilege = this.f5576z;
        this.f5533F.bigHeadIcon = this.f5574x;
        this.f5533F.headIcon = this.f5575y;
        this.f5533F.sosPriority = this.f5529B;
        this.f5533F.type = this.f5528A;
        this.f5533F.phoneNum = this.f5573w;
        this.f5533F.deviceCode = this.f5530C;
        this.f5533F.id = this.f5531D;
        C2538c.m12674b("ContactInfoActivity", "==ww==  userinfo = " + this.f5533F.toString());
        if (C1462f.m6744i().equals(this.f5533F.huid)) {
            this.f5556f.setText(C1680l.IDS_plugin_kidwatch_menu_my_info);
        } else {
            this.f5556f.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_other_info, new Object[]{this.f5533F.nickname}));
        }
        this.f5559i.setText(this.f5572v);
        this.f5558h.setText(this.f5573w);
        m9170j();
        if ("mainSelf".equals(this.f5554d)) {
            C2538c.m12674b("ContactInfoActivity", "==ww==//主管理员进自己的页面 ");
            this.f5553c.setVisibility(8);
            this.f5552b.setVisibility(8);
            this.f5559i.setTextColor(getResources().getColor(d.menu_list_bg_edit));
            this.f5558h.setTextColor(getResources().getColor(d.menu_list_bg_edit));
        } else if ("mainNotSelf".equals(this.f5554d)) {
            C2538c.m12674b("ContactInfoActivity", "==ww==//主管理员进入其他管理员的界面 ");
            this.f5553c.setVisibility(0);
            this.f5552b.setVisibility(8);
            this.f5560j.setVisibility(0);
            this.f5561k.setVisibility(8);
            this.f5559i.setTextColor(getResources().getColor(d.menu_list_bg_edit));
        } else if ("notMain".equals(this.f5554d)) {
            C2538c.m12674b("ContactInfoActivity", "==ww==//副管理员进入自己的页面 ");
            this.f5553c.setVisibility(8);
            this.f5552b.setVisibility(8);
            this.f5552b.setText(C1680l.IDS_plugin_kidwatch_menu_unbindself_title);
            this.f5559i.setTextColor(getResources().getColor(d.menu_list_bg_edit));
            this.f5558h.setTextColor(getResources().getColor(d.menu_list_bg_edit));
            this.f5560j.setVisibility(0);
            this.f5561k.setVisibility(0);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == g.menu_tv_info_delete) {
            m9165g();
        } else if (id == g.menu_tv_info_transfer) {
            m9145a(this.f5572v);
        } else if (id == g.menu_tv_unbindall) {
            if (this.f5554d.equals("mainSelf")) {
                m9161e();
            } else if (this.f5554d.equals("notMain")) {
                m9162f();
            }
        } else if (id == g.menu_info_rl_name) {
            C2538c.m12674b("ContactInfoActivity", "==ww==menu_info_rl_name ");
            Intent intent = new Intent(this, EditRelationSettingActivity.class);
            intent.putExtra("name", this.f5533F.nickname);
            startActivity(intent);
        } else if (id == g.menu_info_rl_phone) {
            C2538c.m12674b("ContactInfoActivity", "==ww==menu_info_rl_phone ");
            if (this.f5554d.equals("mainNotSelf")) {
                C2538c.m12674b("ContactInfoActivity", "==ww==//主管理员进入其他管理员的界面 电话不让点 ");
                return;
            }
            startActivity(new Intent(this, EditPhoneNumActivity.class));
        } else if (id == g.menu_iv_head) {
            this.f5543P.m7235a();
        }
    }

    private void m9159d() {
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_menu_unbindself_loading), false);
        UnbindDeviceIOEntityModel unbindDeviceIOEntityModel = new UnbindDeviceIOEntityModel();
        unbindDeviceIOEntityModel.deviceCode = C1462f.m6746j();
        C1497q.m6942a((Context) this, "isunbindself", Boolean.valueOf(true));
        this.f5570t.mo2499a(unbindDeviceIOEntityModel, new be(this));
    }

    private void m9161e() {
        C1595v c1595v = new C1595v(this);
        c1595v.m7339a(C1680l.IDS_plugin_kidwatch_menu_unbindall_title);
        c1595v.m7348b(C1680l.IDS_plugin_kidwatch_menu_unbindall_message);
        c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new bo(this));
        c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new bp(this));
        this.f5567q = c1595v.m7338a();
        this.f5567q.show();
    }

    private void m9138a(int i, String str) {
        C2538c.m12674b("ContactInfoActivity", "===============Enter updateOption");
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.data = str;
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = i;
        this.f5570t.mo2473a(commonRetOModel, new bq(this));
    }

    private void m9145a(String str) {
        C1595v c1595v = new C1595v(this);
        c1595v.m7339a(C1680l.IDS_plugin_kidwatch_settings_usermanage_title_transferprivilege);
        c1595v.m7351b(String.format(getResources().getString(C1680l.f4406xbf8546dd), new Object[]{str}));
        c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new br(this));
        c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new bs(this));
        this.f5565o = c1595v.m7338a();
        this.f5565o.show();
    }

    private void m9152b(String str) {
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_menu_transfering), false);
        TransferPrivilegeIOEntityModel transferPrivilegeIOEntityModel = new TransferPrivilegeIOEntityModel();
        transferPrivilegeIOEntityModel.deviceCode = C1462f.m6746j();
        transferPrivilegeIOEntityModel.huid = str;
        transferPrivilegeIOEntityModel.id = this.f5531D;
        transferPrivilegeIOEntityModel.type = "1";
        this.f5570t.mo2498a(transferPrivilegeIOEntityModel, new bt(this, str));
    }

    private void m9139a(UserInfo userInfo) {
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_deleting), false);
        UnbindDeviceIOEntityModel unbindDeviceIOEntityModel = new UnbindDeviceIOEntityModel();
        unbindDeviceIOEntityModel.deviceCode = C1462f.m6746j();
        unbindDeviceIOEntityModel.userId = userInfo.huid;
        unbindDeviceIOEntityModel.id = this.f5531D;
        this.f5570t.mo2499a(unbindDeviceIOEntityModel, new bu(this, userInfo));
    }

    private void m9162f() {
        C1595v c1595v = new C1595v(this);
        c1595v.m7339a(C1680l.IDS_plugin_kidwatch_menu_unbindself_title);
        c1595v.m7348b(C1680l.f4405xefc22b48);
        c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new bv(this));
        c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new bf(this));
        this.f5566p = c1595v.m7338a();
        this.f5566p.show();
    }

    private void m9165g() {
        C1595v c1595v = new C1595v(this);
        c1595v.m7339a(C1680l.IDS_plugin_kidwatch_settings_usermanage_confirm_title_unbind);
        c1595v.m7348b(C1680l.IDS_plugin_kidwatch_settings_usermanage_confirm_unbind_content);
        c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new bg(this));
        c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new bh(this));
        this.f5566p = c1595v.m7338a();
        this.f5566p.show();
    }

    private void m9167h() {
        C2538c.m12674b("ContactInfoActivity", "========Enter other");
        if (this.f5544Q == null) {
            this.f5544Q = new C1507h(this, h.dialog_selfdefine, m.servicedialog, false);
        }
        ((TextView) this.f5544Q.findViewById(g.common_selfdefine_dialog_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_relation_info));
        this.f5545R = (EditText) this.f5544Q.findViewById(g.common_selfdefine_dialog_content);
        this.f5545R.addTextChangedListener(this.f5551X);
        this.f5544Q.show();
        this.f5544Q.findViewById(g.common_selfdefine_dialog_cancle).setOnClickListener(new bj(this));
        this.f5544Q.findViewById(g.common_selfdefine_dialog_sure).setOnClickListener(new bk(this));
    }

    private boolean m9156c(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5\\uF900-\\uFA2D]").matcher(str).find();
    }

    private void m9140a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    protected void onResume() {
        CharSequence b = C1497q.m6945b((Context) this, "menuinfophone", "");
        if (!"".equals(b)) {
            this.f5558h.setText(b);
        }
        if (C1497q.m6944b(this, "isaddselectimg").booleanValue() && C1497q.m6944b(this, "isselectImg").booleanValue()) {
            int c = C1497q.m6948c(this, "selectedimg");
            this.f5562l.setImageBitmap(null);
            if (c == g.menu_img_sister_on) {
                this.f5562l.setBackgroundResource(C1617f.kw_pic_user_girl);
                if ("".equals(this.f5533F.bigHeadIcon)) {
                    this.f5533F.type = "6";
                    this.f5536I.sendEmptyMessage(5);
                } else {
                    this.f5534G = m9147a(C1617f.kw_pic_user_girl);
                    m9169i();
                }
            } else if (c == g.menu_img_mother_on) {
                this.f5562l.setBackgroundResource(C1617f.kw_pic_relation_mid_mom);
                if ("".equals(this.f5533F.bigHeadIcon)) {
                    C2538c.m12674b("ContactInfoActivity", "==ww==  userinfo type == xixi " + this.f5533F.type);
                    this.f5533F.type = "2";
                    this.f5536I.sendEmptyMessage(5);
                } else {
                    this.f5534G = m9147a(C1617f.kw_pic_relation_mid_mom);
                    m9169i();
                }
            } else if (c == g.menu_img_gm_on) {
                this.f5562l.setBackgroundResource(C1617f.kw_pic_relation_mid_grandma);
                if ("".equals(this.f5533F.bigHeadIcon)) {
                    this.f5533F.type = "4";
                    this.f5536I.sendEmptyMessage(5);
                } else {
                    this.f5534G = m9147a(C1617f.kw_pic_relation_mid_grandma);
                    m9169i();
                }
            } else if (c == g.menu_img_brother_on) {
                this.f5562l.setBackgroundResource(C1617f.kw_pic_user_boy);
                if ("".equals(this.f5533F.bigHeadIcon)) {
                    this.f5533F.type = "5";
                    this.f5536I.sendEmptyMessage(5);
                } else {
                    this.f5534G = m9147a(C1617f.kw_pic_user_boy);
                    m9169i();
                }
            } else if (c == g.menu_img_father_on) {
                this.f5562l.setBackgroundResource(C1617f.kw_pic_relation_mid_dad);
                if ("".equals(this.f5533F.bigHeadIcon)) {
                    this.f5533F.type = "1";
                    this.f5536I.sendEmptyMessage(5);
                } else {
                    this.f5534G = m9147a(C1617f.kw_pic_relation_mid_dad);
                    m9169i();
                }
            } else if (c == g.menu_img_gf_on) {
                this.f5562l.setBackgroundResource(C1617f.kw_pic_relation_mid_grandpa);
                if ("".equals(this.f5533F.bigHeadIcon)) {
                    this.f5533F.type = "3";
                    this.f5536I.sendEmptyMessage(5);
                } else {
                    this.f5534G = m9147a(C1617f.kw_pic_relation_mid_grandpa);
                    m9169i();
                }
            }
            C1497q.m6942a((Context) this, "isaddselectimg", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "isselectImg", Boolean.valueOf(false));
        }
        if (!"".equals(C1497q.m6945b((Context) this, "editname", ""))) {
            String b2 = C1497q.m6945b((Context) this, "editname", "");
            if ("1".equals(b2)) {
                this.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_dad);
                this.f5533F.nickname = "爸爸";
                m9150b(this.f5533F);
            } else if ("2".equals(b2)) {
                this.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_mom);
                this.f5533F.nickname = "妈妈";
                m9150b(this.f5533F);
            } else if ("3".equals(b2)) {
                this.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandpa);
                this.f5533F.nickname = "爷爷";
                m9150b(this.f5533F);
            } else if ("4".equals(b2)) {
                this.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandma);
                this.f5533F.nickname = "奶奶";
                m9150b(this.f5533F);
            } else if ("0".equals(b2)) {
                Object b3 = C1497q.m6945b((Context) this, "othername", "");
                this.f5559i.setText(b3);
                this.f5533F.nickname = b3;
                m9150b(this.f5533F);
            }
            C1497q.m6943a((Context) this, "editname", "");
        }
        super.onResume();
    }

    private byte[] m9147a(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeResource.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private void m9150b(UserInfo userInfo) {
        C2538c.m12674b("ContactInfoActivity", "==ww==  setInfoToCloud success");
        if (!"7".equals(userInfo.type)) {
            C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_saving), false);
        }
        this.f5549V = userInfo.bigHeadIcon;
        C2538c.m12674b("ContactInfoActivity", "==ww== setInfoToCloud");
        EditManagerModel editManagerModel = new EditManagerModel();
        UserInfo userInfo2 = new UserInfo();
        try {
            userInfo2.id = userInfo.id;
            userInfo2.sosPriority = userInfo.sosPriority;
            userInfo2.huid = URLEncoder.encode(userInfo.huid, GameManager.DEFAULT_CHARSET);
            userInfo2.deviceCode = URLEncoder.encode(userInfo.deviceCode, GameManager.DEFAULT_CHARSET);
            userInfo2.privilege = URLEncoder.encode(userInfo.privilege, GameManager.DEFAULT_CHARSET);
            userInfo2.bigHeadIcon = URLEncoder.encode(userInfo.bigHeadIcon, GameManager.DEFAULT_CHARSET);
            userInfo2.headIcon = URLEncoder.encode(userInfo.headIcon, GameManager.DEFAULT_CHARSET);
            userInfo2.nickname = URLEncoder.encode(userInfo.nickname, GameManager.DEFAULT_CHARSET);
            userInfo2.phoneNum = URLEncoder.encode(userInfo.phoneNum, GameManager.DEFAULT_CHARSET);
            userInfo2.type = URLEncoder.encode(userInfo.type, GameManager.DEFAULT_CHARSET);
            editManagerModel.info = userInfo2;
            this.f5570t.mo2479a(editManagerModel, new bm(this));
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("ContactInfoActivity", "==ww==  editManager  catch Exception e=" + e.getMessage());
            this.f5536I.sendEmptyMessage(56);
        }
    }

    private void m9169i() {
        C2538c.m12674b("ContactInfoActivity", "==ww==  setPicToServer ");
        this.f5542O = false;
        this.f5536I.postDelayed(this.f5541N, FileWatchdog.DEFAULT_DELAY);
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_saving), false);
        new bn(this).execute(new String[0]);
    }

    public void mo2615a(af afVar, byte[] bArr) {
        if (bArr != null) {
            this.f5535H = "7";
            this.f5533F.type = "7";
            this.f5534G = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f5534G, 0, bArr.length);
            this.f5562l.setImageBitmap(null);
            this.f5562l.setImageBitmap(C1492l.m6903a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            m9169i();
        }
    }

    public void mo2616a(boolean z) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12674b("ContactInfoActivity", "==========onActivityResult requestCode:" + i + "    resultCode:" + i2);
        this.f5543P.m7236a(i, i2, intent);
        C2538c.m12674b("ContactInfoActivity", "==========onActivityResult2 requestCode:" + i + "    resultCode:" + i2);
    }

    private void m9170j() {
        if ("".equals(this.f5533F.bigHeadIcon)) {
            Resources resources = getResources();
            if (this.f5528A.equals("0")) {
                this.f5562l.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_ist_user_common));
                this.f5535H = "0";
                return;
            } else if (this.f5528A.equals("1")) {
                this.f5562l.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_dad));
                this.f5535H = "1";
                return;
            } else if (this.f5528A.equals("2")) {
                this.f5562l.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_mom));
                this.f5535H = "2";
                return;
            } else if (this.f5528A.equals("3")) {
                this.f5562l.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_grandpa));
                this.f5535H = "3";
                return;
            } else if (this.f5528A.equals("4")) {
                this.f5562l.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_grandma));
                this.f5535H = "4";
                return;
            } else if (this.f5528A.equals("5")) {
                this.f5562l.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_user_boy));
                this.f5535H = "5";
                return;
            } else if (this.f5528A.equals("6")) {
                this.f5562l.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_user_girl));
                this.f5535H = "6";
                return;
            } else {
                return;
            }
        }
        Bitmap b = C1465a.m6770a().m6776b(this.f5533F.bigHeadIcon);
        if (b == null || b.isRecycled()) {
            b = ac.m7222a(this, this.f5533F.bigHeadIcon);
            if (b != null && !b.isRecycled()) {
                this.f5534G = C1906x.m9699a(b);
                this.f5549V = this.f5533F.bigHeadIcon;
                b = C1492l.m6903a(b);
                if (b != null) {
                    this.f5562l.setImageBitmap(b);
                    return;
                }
                return;
            }
            return;
        }
        this.f5534G = C1906x.m9699a(b);
        this.f5549V = this.f5533F.bigHeadIcon;
        b = C1492l.m6903a(b);
        if (b != null) {
            this.f5562l.setImageBitmap(b);
        }
    }
}
