package com.huawei.ui.device.activity.selectcontact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.datatype.Contact;
import com.huawei.datatype.PhoneNumber;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.b;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.views.selectcontact.C2213c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactMainActivity extends BaseActivity implements OnRequestPermissionsResultCallback, OnClickListener {
    private static String[] f7565o = new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
    boolean f7566a = false;
    List<Contact> f7567b = null;
    private Context f7568c;
    private C1990r f7569d;
    private TextView f7570e;
    private LinearLayout f7571f;
    private LinearLayout f7572g;
    private LinearLayout f7573h;
    private LinearLayout f7574i;
    private LinearLayout f7575j;
    private ListView f7576k;
    private ImageView f7577l;
    private Button f7578m;
    private C2213c f7579n;
    private long f7580p = 0;
    private int f7581q = 5;
    private Handler f7582r = new C2147h(this, this);

    private void m10996a(java.lang.String r8, java.util.ArrayList<java.lang.String> r9, java.util.ArrayList<java.lang.String> r10) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r2 = 0;
        r4 = 1;
        r5 = 0;
        r0 = r7.getContentResolver();
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        r3 = "contact_id = ?";
        r4 = new java.lang.String[r4];
        r4[r5] = r8;
        r5 = r2;
        r1 = r0.query(r1, r2, r3, r4, r5);
        if (r1 == 0) goto L_0x006a;
    L_0x0016:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        if (r0 <= 0) goto L_0x006a;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
    L_0x001c:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        if (r0 == 0) goto L_0x007d;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
    L_0x0022:
        r0 = "data1";	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r9.add(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = "data2";	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r1.getInt(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r7.m10989a(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r10.add(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        goto L_0x001c;
    L_0x0041:
        r0 = move-exception;
        r2 = "ContactMainActivity";	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r3 = 1;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r4 = 0;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r5.<init>();	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r6 = "queryContactNumber() Exception=";	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r3[r4] = r0;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        com.huawei.p190v.C2538c.m12680e(r2, r3);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r1.close();
    L_0x0069:
        return;
    L_0x006a:
        r0 = "ContactMainActivity";	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r2 = 1;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r3 = 0;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r4 = "handleWhenSelectOneItemFromContact get null cursor!";	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        com.huawei.p190v.C2538c.m12680e(r0, r2);	 Catch:{ Exception -> 0x0041, all -> 0x0083 }
        if (r1 == 0) goto L_0x0069;
    L_0x0079:
        r1.close();
        goto L_0x0069;
    L_0x007d:
        if (r1 == 0) goto L_0x0069;
    L_0x007f:
        r1.close();
        goto L_0x0069;
    L_0x0083:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0089;
    L_0x0086:
        r1.close();
    L_0x0089:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.ui.device.activity.selectcontact.ContactMainActivity.a(java.lang.String, java.util.ArrayList, java.util.ArrayList):void");
    }

    private void m10990a() {
        C2538c.m12677c("ContactMainActivity", "enter handleSetSuccess!");
    }

    private void m10997b() {
        C2538c.m12677c("ContactMainActivity", "enter handleSetFail!");
        a.b(this.f7568c, i.IDS_settings_mult_alarm_clock_synchroFailed_dialog);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_device_settings_contact_main_activity_black);
        m11007e();
        m11002c();
    }

    private void m11002c() {
        this.f7570e = (TextView) d.a(this, e.contact_main_null_tv);
        this.f7571f = (LinearLayout) d.a(this, e.contact_main_listview_layout);
        this.f7572g = (LinearLayout) d.a(this, e.contact_main_null_layout);
        this.f7573h = (LinearLayout) d.a(this, e.contact_main_bottom_add_layout);
        this.f7574i = (LinearLayout) d.a(this, e.contact_main_bottom_orderby_layout);
        this.f7575j = (LinearLayout) d.a(this, e.contact_main_bottom_delete_layout);
        this.f7577l = (ImageView) d.a(this, e.contact_main_bottom_add_image);
        this.f7578m = (Button) d.a(this, e.no_contact_add_button);
        this.f7573h.setOnClickListener(this);
        this.f7574i.setOnClickListener(this);
        this.f7575j.setOnClickListener(this);
        this.f7578m.setOnClickListener(this);
        m11005d();
    }

    private void m11005d() {
        if (this.f7566a) {
            m11011i();
        } else {
            m11012j();
        }
    }

    private void m11007e() {
        this.f7568c = getApplicationContext();
        this.f7569d = C1990r.m10400a(getApplicationContext());
        this.f7581q = this.f7569d.m10436d(this.f7568c);
        C2538c.m12677c("ContactMainActivity", "initData() mMaxContactNumber=" + this.f7581q);
        if (this.f7581q <= 0) {
            this.f7581q = 5;
            C2538c.m12680e("ContactMainActivity", "get ERROR mMaxContactNumber!");
        }
        m11008f();
    }

    private void m11008f() {
        this.f7567b = this.f7569d.m10432c(this.f7568c);
        if (this.f7567b == null || this.f7567b.size() == 0) {
            C2538c.m12677c("ContactMainActivity", "loadDataWhenContactDBNOThasData");
            m11010h();
            return;
        }
        C2538c.m12674b("ContactMainActivity", "loadDataWhenContactDBhasData, mContactTables" + this.f7567b);
        m11009g();
    }

    private void m11009g() {
        this.f7566a = true;
    }

    private void m11010h() {
        this.f7566a = false;
        this.f7567b = new ArrayList();
    }

    private void m11011i() {
        this.f7576k = (ListView) d.a(this, e.contact_main_listview);
        this.f7576k.setSelector(com.huawei.ui.device.d.device_settings_contact_listview_item_selector_black);
        this.f7579n = new C2213c(this, this.f7567b);
        C2538c.m12677c("ContactMainActivity", "getFooterViewsCount size = " + this.f7576k.getFooterViewsCount());
        if (this.f7576k.getFooterViewsCount() == 0) {
            C2538c.m12677c("ContactMainActivity", "getFooterViewsCount size = 0======");
            View inflate = LayoutInflater.from(this).inflate(f.activity_device_settings_contact_main_listview_bottom_item_layout_black, null);
            TextView textView = (TextView) d.a(inflate, e.footer_tv);
            String c = C1988p.m10381a(this.f7568c).m10394c();
            textView.setText(String.format(getResources().getString(i.IDS_contact_most_introduce), new Object[]{c, C0956c.m3344a((double) this.f7581q, 1, 0)}));
            this.f7576k.addFooterView(inflate);
        }
        this.f7576k.setAdapter(this.f7579n);
        this.f7578m.setVisibility(8);
        this.f7571f.setVisibility(0);
        this.f7573h.setVisibility(0);
        if (this.f7567b.size() > 1) {
            this.f7574i.setVisibility(0);
        } else {
            this.f7574i.setVisibility(8);
        }
        if (this.f7567b.size() > this.f7581q - 1) {
            this.f7577l.setImageResource(g.ic_add_disable);
        } else {
            this.f7577l.setImageResource(com.huawei.ui.device.d.common_add_21);
        }
        this.f7575j.setVisibility(0);
        this.f7572g.setVisibility(8);
    }

    private void m11012j() {
        this.f7572g.setVisibility(0);
        this.f7573h.setVisibility(8);
        this.f7571f.setVisibility(8);
        this.f7574i.setVisibility(8);
        this.f7575j.setVisibility(8);
        this.f7578m.setVisibility(0);
        String c = C1988p.m10381a(this.f7568c).m10394c();
        this.f7570e.setText(String.format(getResources().getString(i.IDS_contact_no_contact_introduce), new Object[]{c}));
    }

    public void onClick(View view) {
        if (!m11013k()) {
            int id = view.getId();
            if (id == e.contact_main_bottom_add_layout) {
                C2538c.m12661a("03", 1, "ContactMainActivity", "contact_main_bottom_add_layout");
                m11015m();
            } else if (id == e.contact_main_bottom_orderby_layout) {
                C2538c.m12677c("ContactMainActivity", "contact_main_bottom_orderby_layout");
                m11016n();
            } else if (id == e.contact_main_bottom_delete_layout) {
                C2538c.m12661a("03", 1, "ContactMainActivity", "contact_main_bottom_delete_layout");
                m11017o();
                r0 = new HashMap();
                r0.put("click", "1");
                r0.put("status", "delete");
                c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cE.a(), r0, 0);
            } else if (id == e.no_contact_add_button) {
                C2538c.m12661a("03", 1, "ContactMainActivity", "no_contact_add_button");
                m11015m();
                r0 = new HashMap();
                r0.put("click", "1");
                r0.put("status", "add");
                c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cE.a(), r0, 0);
            } else {
                C2538c.m12677c("ContactMainActivity", "i = " + id);
            }
        }
    }

    private boolean m11013k() {
        long currentTimeMillis = System.currentTimeMillis();
        if (1000 > currentTimeMillis - this.f7580p) {
            C2538c.m12677c("ContactMainActivity", "onClick", ">_< >_< click too much");
            this.f7580p = currentTimeMillis;
            return true;
        }
        this.f7580p = currentTimeMillis;
        return false;
    }

    private void m11014l() {
        if (this.f7581q <= this.f7567b.size()) {
            C2538c.m12677c("ContactMainActivity", "startAddContactActivity() addButtonClick() Can't greater than " + this.f7581q);
            return;
        }
        startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
    }

    private void m11015m() {
        C2538c.m12677c("ContactMainActivity", "hasPermission =" + b.a(this.f7568c, f7565o));
        if (b.a(this.f7568c, f7565o)) {
            m11014l();
        } else {
            b.a(this, f7565o, new C2145f(this));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.m12677c("ContactMainActivity", "Activity-onRequestPermissionsResult() PermissionsManager.notifyPermissionsChange()");
        com.huawei.hwcommonmodel.d.a.b.a().a(strArr, iArr);
    }

    private void m11016n() {
        if (this.f7567b.size() <= 0) {
            a.b(this.f7568c, i.IDS_contact_reach_min_contact_count);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.f7568c, ContactOrderbyActivity.class);
        startActivity(intent);
    }

    private void m11017o() {
        if (this.f7567b.size() <= 0) {
            a.b(this.f7568c, i.IDS_contact_reach_min_contact_count);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.f7568c, ContactDeleteActivity.class);
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12677c("ContactMainActivity", "requestCode=" + i + "， resultCode=" + i2);
        switch (i) {
            case 1:
                C2538c.m12677c("ContactMainActivity", "SYSTEM_CONTACT_ACTIVITY");
                m10991a(i2, intent);
                return;
            case 2:
                C2538c.m12677c("ContactMainActivity", "MORE_THAN_ONE_NUMBER_DIALOG");
                m10998b(i2, intent);
                return;
            default:
                return;
        }
    }

    private void m10991a(int i, Intent intent) {
        if (-1 == i) {
            m10992a(intent);
            return;
        }
        C2538c.m12680e("ContactMainActivity", "select data from system contact error");
    }

    private void m10992a(Intent intent) {
        String string;
        Exception exception;
        String str = "";
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (intent == null) {
            C2538c.m12680e("ContactMainActivity", "handleWhenSelectOneItemFromContact() get null data!");
            return;
        }
        Cursor query = getContentResolver().query(intent.getData(), null, null, null, null);
        if (query != null) {
            String str3;
            String str4;
            try {
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    String string2 = query.getString(query.getColumnIndex("display_name"));
                    try {
                        string = query.getString(query.getColumnIndex("_id"));
                        if (query != null) {
                            query.close();
                            str3 = string;
                            str4 = string2;
                        } else {
                            str3 = string;
                            str4 = string2;
                        }
                    } catch (Exception e) {
                        Exception exception2 = e;
                        string = string2;
                        exception = exception2;
                        try {
                            C2538c.m12680e("ContactMainActivity", "handleWhenSelectOneItemFromContact() Exception=" + exception.getMessage());
                            if (query == null) {
                                str3 = str2;
                                str4 = string;
                            } else {
                                query.close();
                                str3 = str2;
                                str4 = string;
                            }
                            m10996a(str3, arrayList, arrayList2);
                            if (arrayList != null) {
                            }
                            C2538c.m12677c("ContactMainActivity", "===wwww===have name or number");
                            return;
                        } catch (Throwable th) {
                            if (query != null) {
                                query.close();
                            }
                        }
                    }
                    m10996a(str3, arrayList, arrayList2);
                    if (arrayList != null || arrayList.size() == 0) {
                        C2538c.m12677c("ContactMainActivity", "===wwww===have name or number");
                        return;
                    } else if (1 == arrayList.size()) {
                        C2538c.m12677c("ContactMainActivity", "===wwww===have name and one number");
                        m10994a(str4, str3, (String) arrayList.get(0), (String) arrayList2.get(0));
                        return;
                    } else {
                        C2538c.m12677c("ContactMainActivity", "===wwww===have name and one number");
                        m10995a(str4, str3, arrayList, arrayList2);
                        return;
                    }
                }
            } catch (Exception e2) {
                exception = e2;
                string = str;
                C2538c.m12680e("ContactMainActivity", "handleWhenSelectOneItemFromContact() Exception=" + exception.getMessage());
                if (query == null) {
                    query.close();
                    str3 = str2;
                    str4 = string;
                } else {
                    str3 = str2;
                    str4 = string;
                }
                m10996a(str3, arrayList, arrayList2);
                if (arrayList != null) {
                }
                C2538c.m12677c("ContactMainActivity", "===wwww===have name or number");
                return;
            }
        }
        C2538c.m12680e("ContactMainActivity", "handleWhenSelectOneItemFromContact get null cursor!");
        C2538c.m12677c("ContactMainActivity", "===wwww===have no permission ===have no cursor");
        a.b(this.f7568c, i.IDS_contact_have_no_permission_to_read);
        if (query != null) {
            query.close();
        }
    }

    private String m10989a(int i) {
        C2538c.m12674b("ContactMainActivity", "getNumberType() numberType=" + i);
        switch (i) {
            case 1:
                return "Home";
            case 2:
                return "Mobile";
            case 3:
                return "Work";
            case 4:
                return "Work Fax";
            case 5:
                return "Home Fax";
            case 6:
                return "Pager";
            case 7:
                return "Other";
            case 8:
                return "Callback";
            case 9:
                return "Car";
            case 10:
                return "Company Main";
            case 11:
                return "ISDN";
            case 12:
                return "Main";
            case 13:
                return "Other Fax";
            case 14:
                return "Radio";
            case 15:
                return "Telex";
            case 16:
                return "TTY TDD";
            case 17:
                return "Work Mobile";
            case 18:
                return "Work Pager";
            case 19:
                return "Assistant";
            case 20:
                return "MMS";
            default:
                return "Custom";
        }
    }

    private void m10994a(String str, String str2, String str3, String str4) {
        C2538c.m12677c("ContactMainActivity", "send Data to Device!");
        m11001b(str, str2, str3, str4);
        m11018p();
    }

    private void m11001b(String str, String str2, String str3, String str4) {
        C2538c.m12674b("ContactMainActivity", "saveData2List, userName=" + str + "userId=" + str2 + "userNumber=" + str3 + "numberType=" + str4);
        PhoneNumber phoneNumber = new PhoneNumber(str4, str3);
        List arrayList = new ArrayList();
        arrayList.add(phoneNumber);
        this.f7567b.add(new Contact(str2, str, arrayList));
        for (int i = 0; i < this.f7567b.size(); i++) {
            C2538c.m12674b("ContactMainActivity", "saveData2List get() return ContactTable[" + i + "] = " + this.f7567b.get(i));
        }
    }

    private void m10995a(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        C2538c.m12677c("ContactMainActivity", "startSelectNumberDialog");
        Intent intent = new Intent();
        intent.setClass(this.f7568c, ContactSelectNumberDialog.class);
        intent.putExtra(HwPayConstant.KEY_USER_NAME, str);
        intent.putExtra("contactId", str2);
        intent.putStringArrayListExtra("userNumbers", arrayList);
        intent.putStringArrayListExtra("numberTypes", arrayList2);
        startActivityForResult(intent, 2);
    }

    private void m10998b(int i, Intent intent) {
        if (-1 == i) {
            m10999b(intent);
            return;
        }
        C2538c.m12680e("ContactMainActivity", "select data from select list error");
    }

    private void m10999b(Intent intent) {
        String stringExtra = intent.getStringExtra(HwPayConstant.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra("contactId");
        String stringExtra3 = intent.getStringExtra("selectNumber");
        C2538c.m12674b("ContactMainActivity", "getIntent userName=" + stringExtra + ", contactId=" + stringExtra2 + ", selectNumber=" + stringExtra3 + ", numberType=" + intent.getStringExtra("numberType"));
        m10994a(stringExtra, stringExtra2, stringExtra3, r3);
    }

    private void m11018p() {
        if (this.f7569d == null) {
            C2538c.m12680e("ContactMainActivity", "mDeviceSettingsInteractors of send2Device error null!");
            return;
        }
        if (C1988p.m10381a(this.f7568c).m10396d() != 2) {
            m11019q();
        }
        this.f7569d.m10416a(this.f7568c, this.f7567b, new C2146g(this));
    }

    private void m11019q() {
        C2538c.m12677c("ContactMainActivity", "showNoConnectedToast()");
        a.b(this.f7568c, i.IDS_device_not_connect);
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12677c("ContactMainActivity", "===www==== onResume");
        m11008f();
        m11005d();
    }

    protected void onDestroy() {
        super.onDestroy();
        C0977d.m3575n(this.f7568c);
    }
}
