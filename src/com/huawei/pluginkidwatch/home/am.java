package com.huawei.pluginkidwatch.home;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.ImportContact;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.utils.C1486f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: HomeActivity */
class am extends AsyncTask<String, Void, String> {
    final /* synthetic */ C1395k f4177a;
    final /* synthetic */ HomeActivity f4178b;

    am(HomeActivity homeActivity, C1395k c1395k) {
        this.f4178b = homeActivity;
        this.f4177a = c1395k;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m7665a((String[]) objArr);
    }

    protected String m7665a(String... strArr) {
        Uri uri = Phone.CONTENT_URI;
        try {
            Cursor query = this.f4178b.getContentResolver().query(uri, new String[]{"display_name", "data1", "photo_id", "contact_id"}, null, null, null);
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            if (query != null) {
                while (query.moveToNext()) {
                    ImportContact importContact = new ImportContact();
                    Object string = query.getString(1);
                    if (!(string == null || "".equals(string))) {
                        string = string.replaceAll("-", "").replaceAll(HwAccountConstants.BLANK, "");
                        if (string.startsWith("+86")) {
                            string = string.substring(3);
                        }
                    }
                    if (!TextUtils.isEmpty(string)) {
                        String string2 = query.getString(0);
                        long j = query.getLong(3);
                        importContact.setPhoneNum(string);
                        importContact.setName(string2);
                        importContact.setContactId(j);
                        arrayList.add(importContact);
                    }
                }
                query.close();
            }
            String str = "";
            if (this.f4177a.f3093m == null || "".equals(this.f4177a.f3093m)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==ww== bindDeviceInfo.SimCardNum is null ");
                return "";
            }
            String name;
            int i;
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ImportContact importContact2 = (ImportContact) it.next();
                    if (this.f4177a.f3093m.equals(importContact2.getPhoneNum())) {
                        name = importContact2.getName();
                        i = 1;
                        break;
                    }
                }
            }
            name = str;
            i = 0;
            if (i == 0) {
                if (this.f4177a.f3098r == null || "".equals(this.f4177a.f3098r)) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "==ww== phonemun  do  not exist  esle");
                    this.f4178b.m7547a(this.f4177a.f3083c, this.f4177a.f3093m, null);
                } else {
                    Bitmap a = C1486f.m6871a(this.f4178b, this.f4177a.f3098r);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (a != null) {
                        a.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        this.f4178b.m7547a(this.f4177a.f3083c, this.f4177a.f3093m, byteArrayOutputStream.toByteArray());
                    }
                }
            } else if (!("".equals(name) || name.equals(this.f4177a.f3083c))) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  name is diffrent");
                if (C1492l.m6913a(this.f4178b, C1466a.m6777a())) {
                    this.f4178b.m7639a(this.f4177a.f3083c, this.f4178b.m7636a(C1462f.m6748k().f3093m));
                }
            }
            return "";
        } catch (Exception e) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "Exception e = " + e.getMessage());
        }
    }
}
