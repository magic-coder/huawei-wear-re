package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import com.huawei.hwcommonmodel.d.a.b;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.model.ImportContact;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1833d;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1897n;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ImportContactActivity extends Activity implements OnRequestPermissionsResultCallback {
    private final int f5758a = 4;
    private final int f5759b = 5;
    private final int f5760c = 6;
    private final int f5761d = 7;
    private ImageView f5762e;
    private ImageView f5763f;
    private ListView f5764g;
    private EditText f5765h;
    private ArrayList<ImportContact> f5766i = null;
    private ArrayList<ImportContact> f5767j;
    private ArrayList<ImportContact> f5768k;
    private C1833d f5769l = null;
    private Handler f5770m = null;
    private Context f5771n = null;
    private CustomDialog f5772o = null;
    private C1897n f5773p = null;
    private Pattern f5774q = Pattern.compile("^[一-龥]*$");
    private Pattern f5775r = Pattern.compile("^[A-Za-z]+$");
    private Pattern f5776s = Pattern.compile("^[0-9]*$");
    private boolean f5777t = false;
    private TextWatcher f5778u = new ex(this);
    private OnClickListener f5779v = new fa(this);
    private OnClickListener f5780w = new fb(this);

    @SuppressLint({"HandlerLeak"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(h.activity_contact_import);
        m9433a();
        this.f5770m = new ev(this);
        if (C1492l.m6913a((Context) this, C1466a.m6777a())) {
            m9441c();
        } else {
            C1492l.m6910a((Activity) this, C1466a.m6777a());
        }
    }

    private void m9433a() {
        this.f5771n = this;
        this.f5766i = new ArrayList();
        this.f5767j = new ArrayList();
        this.f5768k = new ArrayList();
        this.f5773p = new C1897n(this, this.f5772o);
        this.f5762e = (ImageView) findViewById(g.memu_img_cancle_improt);
        this.f5763f = (ImageView) findViewById(g.menu_img_improt);
        this.f5777t = false;
        this.f5769l = new C1833d(this);
        this.f5762e.setOnClickListener(this.f5779v);
        this.f5763f.setOnClickListener(this.f5780w);
        this.f5765h = (EditText) findViewById(g.menu_search_et);
        this.f5765h.addTextChangedListener(this.f5778u);
        this.f5764g = (ListView) findViewById(g.menu_listview_improt);
        this.f5764g.setAdapter(this.f5769l);
        this.f5764g.setOnItemClickListener(new ew(this));
    }

    private void m9439b() {
        if (this.f5773p != null) {
            this.f5773p.m9666a();
        }
        if (this.f5766i == null || this.f5766i.size() <= 0) {
            this.f5769l.m8885a(null);
        } else {
            this.f5769l.m8885a(this.f5766i);
        }
    }

    private void m9441c() {
        if (this.f5773p != null) {
            this.f5773p.m9667a(C1680l.IDS_plugin_kidwatch_common_loading);
        }
        new fc(this).execute(new String[0]);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                return inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
        return false;
    }

    public ArrayList<ImportContact> m9450a(Activity activity) {
        ArrayList<ImportContact> arrayList = new ArrayList();
        Uri uri = Phone.CONTENT_URI;
        Cursor query = activity.getContentResolver().query(uri, new String[]{"display_name", "sort_key", "contact_id", "data1"}, null, null, "sort_key");
        if (query == null) {
            return null;
        }
        if (query.moveToFirst()) {
            do {
                Bitmap decodeStream;
                ImportContact importContact = new ImportContact();
                String string = query.getString(query.getColumnIndex("data1"));
                String string2 = query.getString(0);
                String a = m9431a(query.getString(1));
                int i = query.getInt(query.getColumnIndex("contact_id"));
                if (Long.valueOf(query.getLong(2)).longValue() > 0) {
                    decodeStream = BitmapFactory.decodeStream(Contacts.openContactPhotoInputStream(this.f5771n.getContentResolver(), ContentUris.withAppendedId(Contacts.CONTENT_URI, (long) i)));
                } else {
                    decodeStream = null;
                }
                importContact.setName(string2);
                importContact.sortKey = a;
                if (string != null) {
                    importContact.setPhoneNum(m9437b(string));
                }
                importContact.setContactId((long) i);
                if (decodeStream != null) {
                    importContact.setImgBitmapStr(C1906x.m9704b(decodeStream));
                } else {
                    importContact.setImgBitmapStr("");
                }
                arrayList.add(importContact);
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    public ArrayList<ImportContact> m9451a(Context context, String str) {
        ArrayList<ImportContact> arrayList = new ArrayList();
        Uri uri = Phone.CONTENT_URI;
        Cursor query = context.getContentResolver().query(uri, new String[]{"display_name", "sort_key", "contact_id", "data1"}, "display_name like ? or data1 like ? ", new String[]{"%" + str + "%", "%" + str + "%"}, "sort_key");
        if (query == null) {
            return null;
        }
        if (query.moveToFirst()) {
            do {
                Bitmap decodeStream;
                ImportContact importContact = new ImportContact();
                String string = query.getString(query.getColumnIndex("data1"));
                String string2 = query.getString(0);
                String a = m9431a(query.getString(1));
                int i = query.getInt(query.getColumnIndex("contact_id"));
                if (Long.valueOf(query.getLong(2)).longValue() > 0) {
                    decodeStream = BitmapFactory.decodeStream(Contacts.openContactPhotoInputStream(this.f5771n.getContentResolver(), ContentUris.withAppendedId(Contacts.CONTENT_URI, (long) i)));
                } else {
                    decodeStream = null;
                }
                importContact.setName(string2);
                importContact.sortKey = a;
                if (string != null) {
                    importContact.setPhoneNum(m9437b(string));
                }
                importContact.setContactId((long) i);
                if (decodeStream != null) {
                    importContact.setImgBitmapStr(C1906x.m9704b(decodeStream));
                } else {
                    importContact.setImgBitmapStr("");
                }
                arrayList.add(importContact);
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    private static String m9431a(String str) {
        String toUpperCase = str.substring(0, 1).toUpperCase();
        return toUpperCase.matches("[A-Z]") ? toUpperCase : "#";
    }

    private static String m9437b(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return str.replaceAll("[^0-9//+]", "");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        C2538c.m12674b("ImportContactActivity", "Activity-onRequestPermissionsResult() PermissionsManager.notifyPermissionsChange()");
        b.a().a(strArr, iArr);
        switch (i) {
            case 1:
                Map hashMap = new HashMap();
                while (i2 < strArr.length) {
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                    i2++;
                }
                if (hashMap.containsKey("android.permission.READ_CONTACTS") && ((Integer) hashMap.get("android.permission.READ_CONTACTS")).intValue() == 0) {
                    m9441c();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f5773p != null) {
            this.f5773p.m9666a();
        }
        this.f5773p = null;
    }
}
