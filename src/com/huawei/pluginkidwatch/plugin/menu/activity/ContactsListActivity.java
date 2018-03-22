package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import com.huawei.pluginkidwatch.common.entity.model.DeleteWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.TransferPrivilegeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UnbindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1391g;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.j;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1835f;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1838i;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1888d;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1891g;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1896m;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.List;

public class ContactsListActivity extends KidWatchBaseActivity implements OnClickListener {
    private static boolean aa = false;
    private C1507h f5577A = null;
    private C1507h f5578B = null;
    private C1507h f5579C = null;
    private C1507h f5580D = null;
    private C1507h f5581E = null;
    private Contact f5582F = null;
    private Contact f5583G = null;
    private Bitmap f5584H = null;
    private C1391g f5585I = null;
    private List<Contact> f5586J = null;
    private List<Contact> f5587K = null;
    private List<Contact> f5588L = null;
    private List<UserInfo> f5589M = null;
    private boolean f5590N = false;
    private C1891g f5591O;
    private C1888d f5592P;
    private LinearLayout f5593Q;
    private LinearLayout f5594R;
    private View f5595S;
    private int f5596T = 0;
    private List<UserInfo> f5597U;
    private View f5598V = null;
    private cw f5599W;
    private Context f5600X = null;
    private int f5601Y = 15;
    private RelativeLayout f5602Z;
    private cv ab = null;
    private int f5603b = 31;
    private int f5604c = 32;
    private int f5605d = 0;
    private ViewPager f5606e = null;
    private ImageView f5607f;
    private ImageView f5608g;
    private ImageView f5609h;
    private ImageView f5610i;
    private TextView f5611j;
    private TextView f5612k;
    private TextView f5613l;
    private TextView f5614m;
    private TextView f5615n;
    private TextView f5616o;
    private LinearLayout f5617p;
    private LinearLayout f5618q;
    private List<View> f5619r;
    private ListView f5620s = null;
    private ListView f5621t = null;
    private ImageView f5622u;
    private C1896m f5623v = null;
    private C1835f f5624w = null;
    private C1838i f5625x = null;
    private cs f5626y;
    private C1413d f5627z;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_contact_contactslist);
        m9240f();
        m9250k();
        m9251l();
        m9242g();
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12674b("ContactsListActivity", "==ww== onResume");
        m9254m();
        if (C1497q.m6944b(this, "isSort").booleanValue() || C1497q.m6944b(this, "isInvite").booleanValue() || C1497q.m6944b(this, "diteManger").booleanValue() || !"".equals(C1497q.m6945b((Context) this, "menuinfophone", ""))) {
            m9244h();
            C1497q.m6942a((Context) this, "isSort", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "isInvite", Boolean.valueOf(false));
            C1497q.m6942a((Context) this, "diteManger", Boolean.valueOf(false));
            C1497q.m6943a((Context) this, "menuinfophone", "");
        }
        if (C1462f.m6754n() || 1 != this.f5606e.getCurrentItem()) {
            this.f5613l.setVisibility(0);
            this.f5609h.setVisibility(0);
            return;
        }
        this.f5613l.setVisibility(8);
        this.f5609h.setVisibility(8);
    }

    private void m9240f() {
        this.f5600X = this;
        this.f5627z = C1417a.m6594a(getApplicationContext());
        this.f5596T = ((WindowManager) getSystemService("window")).getDefaultDisplay().getHeight() - C1492l.m6901a((Context) this, 250.0f);
        this.f5626y = new cs(this);
        this.ab = new cv();
        this.f5590N = true;
        this.f5586J = new ArrayList();
        this.f5623v = new C1896m(getApplicationContext());
        this.f5588L = new ArrayList();
        this.f5589M = new ArrayList();
        this.f5585I = new C1391g(getApplicationContext());
        this.f5587K = new ArrayList();
        this.f5597U = new ArrayList();
        this.f5591O = new C1891g();
        C1888d c1888d = this.f5592P;
        this.f5592P = C1888d.m9651a();
        this.f5594R = (LinearLayout) findViewById(g.contact_add_or_sort);
        this.f5595S = findViewById(g.contact_line_view);
        this.f5615n = (TextView) findViewById(g.menu_tv_left);
        this.f5616o = (TextView) findViewById(g.menu_tv_right);
        this.f5617p = (LinearLayout) findViewById(g.addlinkman_tv_lly);
        this.f5618q = (LinearLayout) findViewById(g.Emergency_contact_lly);
        this.f5606e = (ViewPager) findViewById(g.contacts_viewpager);
        this.f5607f = (ImageView) findViewById(g.viewpager_top_image_left);
        this.f5608g = (ImageView) findViewById(g.viewpager_top_image_right);
        this.f5607f.setBackgroundResource(C1617f.kw_img_circle);
        this.f5609h = (ImageView) findViewById(g.contact_add_linkman_imageview);
        this.f5593Q = (LinearLayout) findViewById(g.contact_add_linkman_liner);
        this.f5611j = (TextView) findViewById(g.addlinkman_tv);
        this.f5612k = (TextView) findViewById(g.Emergency_contact_tv);
        this.f5613l = (TextView) findViewById(g.textView1);
        this.f5598V = LayoutInflater.from(this).inflate(h.view_contact_notice, null);
        this.f5602Z = (RelativeLayout) findViewById(g.contact_add_navigation_rly);
        this.f5602Z.setOnClickListener(this);
        if (C1497q.m6944b(this.f5600X, "KIDWATCH_CONTACT_ADD_NAVIGATION").booleanValue()) {
            this.f5602Z.setVisibility(8);
        }
        C1497q.m6942a(this.f5600X, "KIDWATCH_CONTACT_ADD_NAVIGATION", Boolean.valueOf(true));
        this.f5615n.setOnClickListener(this);
        this.f5616o.setOnClickListener(this);
        this.f5617p.setOnClickListener(this);
        this.f5618q.setOnClickListener(this);
        this.f5611j.setOnClickListener(this);
        this.f5609h.setOnClickListener(this);
        this.f5612k.setOnClickListener(this);
        this.f5593Q.setOnClickListener(this);
        this.f5619r = new ArrayList();
        View inflate = LayoutInflater.from(this).inflate(h.activity_contact_vp_left_contactlist, null);
        View inflate2 = LayoutInflater.from(this).inflate(h.activity_contact_vp_right_contactlist, null);
        this.f5619r.add(inflate);
        this.f5619r.add(inflate2);
        this.f5620s = (ListView) inflate.findViewById(g.contact_listview_left);
        this.f5621t = (ListView) inflate2.findViewById(g.contact_listview_right);
        int a = C1497q.m6935a(this.f5600X, C1462f.m6746j() + "CONTACTNUM", -1);
        C2538c.m12674b("ContactsListActivity", " ===============haveNumSpecifyAbility SharedPreferencesUtil contactNum : " + a);
        if (-1 < a) {
            this.f5601Y = a;
        }
        C2538c.m12674b("ContactsListActivity", "==ww==getContactSum  mContactSumAb : " + this.f5601Y);
        ((TextView) this.f5598V.findViewById(g.view_contact_notice_tv)).setText(String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_other_contact), new Object[]{this.f5601Y + ""}));
        this.f5620s.addFooterView(this.f5598V, null, false);
        this.f5614m = (TextView) inflate2.findViewById(g.menu_contact_show_invitnumber);
        this.f5606e.setAdapter(new cu(this.f5619r));
        this.f5606e.setCurrentItem(0);
        this.f5606e.setOnPageChangeListener(new ct(this));
        this.f5624w = new C1835f(this, this.f5588L);
        this.f5620s.setAdapter(this.f5624w);
        this.f5625x = new C1838i(this);
        this.f5621t.setAdapter(this.f5625x);
        if (C1462f.m6754n()) {
            this.f5613l.setVisibility(0);
            this.f5609h.setVisibility(0);
            this.f5614m.setText(getResources().getQuantityString(j.IDS_plugin_kidwatch_menu_soscontactmanage_notice, 4, new Object[]{Integer.valueOf(4)}));
        } else {
            this.f5613l.setVisibility(8);
            this.f5609h.setVisibility(8);
            this.f5614m.setText(getResources().getText(C1680l.IDS_plugin_kidwatch_menu_soscontactmanage_notice_not_main));
        }
        m9244h();
        this.f5599W = new cw(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.pluginkidwatch.plugin.menu.manager");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f5599W, intentFilter);
    }

    private void m9208a(ListView listView) {
        C1838i c1838i = (C1838i) listView.getAdapter();
        if (c1838i != null) {
            int count = c1838i.getCount() * C1492l.m6901a((Context) this, 93.0f);
            LayoutParams layoutParams = listView.getLayoutParams();
            if (count < this.f5596T) {
                layoutParams.height = count;
            } else {
                layoutParams.height = this.f5596T;
            }
            listView.setLayoutParams(layoutParams);
        }
    }

    public void onClick(View view) {
        if (view.getId() == g.Emergency_contact_tv || view.getId() == g.Emergency_contact_lly || view.getId() == g.menu_tv_left) {
            this.f5606e.setCurrentItem(0);
        } else if (view.getId() == g.addlinkman_tv || view.getId() == g.addlinkman_tv_lly || view.getId() == g.menu_tv_right) {
            this.f5606e.setCurrentItem(1);
        } else if (view.getId() == g.contact_add_linkman_liner || view.getId() == g.contact_add_linkman_imageview || view.getId() == g.textView1) {
            C2538c.m12674b("ContactsListActivity", "==ww== contact_add_linkman_liner");
            if (1 == this.f5606e.getCurrentItem()) {
                C2538c.m12674b("ContactsListActivity", "==ww== contact_add_linkman_liner  VIEWPAGER_LEFT  order");
                if (!C1462f.m6754n()) {
                    return;
                }
                if (C1492l.m6916b((Context) this)) {
                    startActivity(new Intent(this, SosContactSortActivity.class));
                } else {
                    C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_common_network_disable);
                    return;
                }
            }
            if (this.f5606e.getCurrentItem() == 0) {
                C2538c.m12674b("ContactsListActivity", "==ww== contact_add_linkman_liner  VIEWPAGER_RIGHT  add");
                String format = String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_contactmanage_full), new Object[]{this.f5601Y + ""});
                C2538c.m12674b("ContactsListActivity", "==ww==  mContactNum == " + this.f5605d + " ; mContactSumAb == " + this.f5601Y);
                if (this.f5605d >= this.f5601Y) {
                    C1483c.m6832c(this, format);
                } else {
                    startActivity(new Intent(this, AddContactActivity.class));
                }
            }
        } else if (view.getId() == g.contact_tv_edit) {
            startActivity(new Intent(this, TailorContactActivity.class));
            C1497q.m6943a((Context) this, "contactname", this.f5583G.getName());
            C1497q.m6943a((Context) this, "contactphonenumber", this.f5583G.getPhoneNum());
            C1497q.m6943a((Context) this, "contactpicurl", this.f5583G.getBigHeadIcon());
            C1497q.m6947b((Context) this, "contactid", this.f5583G.getContactId());
            C1497q.m6943a((Context) this, "contactheadcion", this.f5583G.getBigHeadIcon());
            C1497q.m6943a((Context) this, "pictype", this.f5583G.type);
            m9210a(this.f5577A);
        } else if (view.getId() == g.contact_add_navigation_rly) {
            this.f5602Z.setVisibility(8);
            C1497q.m6942a(this.f5600X, "KIDWATCH_CONTACT_ADD_NAVIGATION", Boolean.valueOf(true));
        }
    }

    private void m9242g() {
        this.f5621t.setOnItemLongClickListener(new by(this));
    }

    private void m9206a(int i, int i2) {
        C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog  ShowAlertDialog");
        if (this.f5581E == null) {
            this.f5581E = new C1507h(this, h.dialog_userinfo_confirm, m.servicedialog, false);
            this.f5581E.setCanceledOnTouchOutside(true);
        }
        this.f5581E.show();
        UserInfo userInfo = (UserInfo) this.f5589M.get(i2);
        TextView textView = (TextView) this.f5581E.findViewById(g.usermanage_tv_confirm_title);
        TextView textView2 = (TextView) this.f5581E.findViewById(g.usermanage_tv_confirm_content);
        TextView textView3 = (TextView) this.f5581E.findViewById(g.usermanage_tv_cancel);
        TextView textView4 = (TextView) this.f5581E.findViewById(g.usermanage_tv_ok);
        if (i == this.f5603b) {
            textView.setText(C1680l.IDS_plugin_kidwatch_settings_usermanage_title_transferprivilege);
            textView2.setText(String.format(getResources().getString(C1680l.f4406xbf8546dd), new Object[]{userInfo.nickname}));
            textView4.setText(C1680l.IDS_plugin_kidwatch_common_ok);
        } else {
            textView.setText(C1680l.IDS_plugin_kidwatch_settings_usermanage_confirm_title_unbind);
            textView2.setText(C1680l.IDS_plugin_kidwatch_settings_usermanage_confirm_unbind_content);
            textView4.setText(C1680l.IDS_plugin_kidwatch_common_delete);
        }
        textView3.setOnClickListener(new ck(this));
        textView4.setOnClickListener(new cl(this, i, userInfo));
    }

    private void m9209a(UserInfo userInfo) {
        C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog  transferprivilege");
        if (userInfo != null && "".equals(userInfo.huid)) {
            C1483c.m6832c(this, "不允许转移权限给此管理员");
            C2538c.m12674b("ContactsListActivity", "==ww== ContactsListActivity 不允许转移权限给此管理员 huid=" + userInfo.huid);
        } else if (userInfo != null) {
            C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_menu_transfering), false);
            TransferPrivilegeIOEntityModel transferPrivilegeIOEntityModel = new TransferPrivilegeIOEntityModel();
            transferPrivilegeIOEntityModel.deviceCode = C1462f.m6746j();
            transferPrivilegeIOEntityModel.huid = userInfo.huid;
            transferPrivilegeIOEntityModel.id = userInfo.id;
            transferPrivilegeIOEntityModel.type = "1";
            this.f5627z.mo2498a(transferPrivilegeIOEntityModel, new cm(this, userInfo));
        }
    }

    private void m9222b(UserInfo userInfo) {
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_deleting), false);
        C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog  unbind");
        UnbindDeviceIOEntityModel unbindDeviceIOEntityModel = new UnbindDeviceIOEntityModel();
        unbindDeviceIOEntityModel.deviceCode = C1462f.m6746j();
        unbindDeviceIOEntityModel.userId = userInfo.huid;
        unbindDeviceIOEntityModel.id = userInfo.id;
        this.f5627z.mo2499a(unbindDeviceIOEntityModel, new cn(this, userInfo));
    }

    private void m9244h() {
        C2538c.m12674b("ContactsListActivity", "==enter  getBindUsers ");
        DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel = new DeviceBindUsersIOEntityModel();
        deviceBindUsersIOEntityModel.deviceCode = C1462f.m6746j();
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_loading), false);
        this.f5626y.postDelayed(this.ab, StatisticConfig.MIN_UPLOAD_INTERVAL);
        this.f5627z.mo2477a(deviceBindUsersIOEntityModel, new co(this));
    }

    private void m9216a(List<UserInfo> list) {
        C2538c.m12674b("ContactsListActivity", "=====Enter updateDB");
        if (list != null && list.size() > 0) {
            C1392h.m6311f(this.f5600X, C1462f.m6746j());
            for (UserInfo userInfo : list) {
                C2538c.m12674b("ContactsListActivity", "=====Enter updateDB arr:" + userInfo.toString());
                C1392h.m6279a(this.f5600X, userInfo, C1462f.m6746j());
            }
        }
    }

    private void m9246i() {
        C2538c.m12674b("ContactsListActivity", "==enter  getContactList ");
        GetContactIOEntityModel getContactIOEntityModel = new GetContactIOEntityModel();
        getContactIOEntityModel.deviceCode = C1462f.m6746j();
        this.f5627z.mo2481a(getContactIOEntityModel, new cp(this));
    }

    private void m9248j() {
        this.f5579C = new C1507h(this, h.dialog_contact_delete, m.servicedialog, false);
        this.f5579C.show();
        ((TextView) this.f5579C.findViewById(g.menu_tv_contactcancle)).setOnClickListener(new cq(this));
        ((TextView) this.f5579C.findViewById(g.menu_tv_suredeletecontact)).setOnClickListener(new cr(this));
    }

    private void m9210a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public void mo2518d() {
        DeleteWatchContactIOEntityModel deleteWatchContactIOEntityModel = new DeleteWatchContactIOEntityModel();
        deleteWatchContactIOEntityModel.deviceCode = C1462f.m6746j();
        deleteWatchContactIOEntityModel.id = this.f5582F.getContactId();
        this.f5627z.mo2476a(deleteWatchContactIOEntityModel, new cb(this));
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void m9250k() {
        this.f5621t.setOnItemClickListener(new cc(this));
    }

    private void m9207a(Intent intent, UserInfo userInfo) {
        intent.putExtra("huid", userInfo.huid);
        intent.putExtra("nickname", userInfo.nickname);
        intent.putExtra("phoneNum", userInfo.phoneNum);
        intent.putExtra("bigHeadIcon", userInfo.bigHeadIcon);
        intent.putExtra("headIcon", userInfo.headIcon);
        intent.putExtra("privilege", userInfo.privilege);
        intent.putExtra("type", userInfo.type);
        intent.putExtra("sosPriority", userInfo.sosPriority);
        intent.putExtra("deviceCode", userInfo.deviceCode);
        intent.putExtra("id", userInfo.id);
    }

    private void m9251l() {
        this.f5620s.setOnItemClickListener(new cd(this));
        this.f5620s.setOnItemLongClickListener(new cg(this));
    }

    private synchronized void m9226b(List<Contact> list) {
        if (list != null) {
            if (list.size() > 0) {
                this.f5585I.m6266c();
                for (Contact a : list) {
                    this.f5585I.m6260a(a, C1462f.m6746j());
                }
                m9254m();
            }
        }
        this.f5585I.m6266c();
        m9254m();
    }

    private void m9231c(List<Contact> list) {
        new ci(this, list).execute(new String[0]);
    }

    private void m9254m() {
        new cj(this).execute(new String[0]);
    }

    private List<Contact> m9235d(List<Contact> list) {
        List<Contact> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Contact contact = (Contact) list.get(i);
            String toUpperCase = this.f5592P.m9654b(contact.getName()).substring(0, 1).toUpperCase();
            if (toUpperCase.matches("[A-Z]")) {
                contact.setSortLetters(toUpperCase.toUpperCase());
            } else {
                contact.setSortLetters("#");
            }
            arrayList.add(contact);
        }
        return arrayList;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f5626y != null) {
            this.f5626y.removeCallbacksAndMessages(null);
        }
        C1506g.m6979b();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f5599W);
    }

    public static void m9217a(boolean z) {
        aa = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }
}
