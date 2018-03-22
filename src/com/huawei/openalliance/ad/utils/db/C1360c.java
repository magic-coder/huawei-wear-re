package com.huawei.openalliance.ad.utils.db;

import android.content.Context;
import com.huawei.openalliance.ad.utils.db.bean.AdEventRecord;
import com.huawei.openalliance.ad.utils.db.bean.C1359a;
import com.huawei.openalliance.ad.utils.db.bean.MaterialRecord;
import com.huawei.openalliance.ad.utils.db.bean.SloganRecord;
import com.huawei.openalliance.ad.utils.db.bean.TestMaterialRecord;
import com.huawei.openalliance.ad.utils.db.bean.ThirdPartyEventRecord;
import com.huawei.openalliance.ad.utils.db.bean.UserCloseRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1360c {
    private static List<C1359a> f2946b = new ArrayList(4);
    private static List<C1359a> f2947c = new ArrayList(4);
    private C1357a f2948a;

    static {
        f2946b.add(new MaterialRecord());
        f2946b.add(new AdEventRecord());
        f2946b.add(new TestMaterialRecord());
        f2946b.add(new ThirdPartyEventRecord());
        f2947c.add(new MaterialRecord());
        f2947c.add(new AdEventRecord());
        f2947c.add(new ThirdPartyEventRecord());
        f2947c.add(new SloganRecord());
        f2947c.add(new UserCloseRecord());
    }

    public C1360c(C1357a c1357a, Context context) {
        this.f2948a = c1357a;
    }

    private String m6063a(String[] strArr, String[] strArr2) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList = new ArrayList(4);
        if (strArr2 != null) {
            List asList = Arrays.asList(strArr2);
        } else {
            Object obj = arrayList;
        }
        if (strArr == null || strArr.length <= 0 || strArr2 == null) {
            return null;
        }
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (asList.contains(str)) {
                stringBuilder.append(str);
            } else {
                stringBuilder.append("\"\"");
            }
            if (i != strArr.length - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    private void m6064a(String str) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" INSERT INTO ");
        stringBuilder.append(str);
        stringBuilder.append(" SELECT ");
        try {
            try {
                String a = m6063a(this.f2948a.m5997d(str), this.f2948a.m5997d("_temp_" + str));
                if (a != null) {
                    stringBuilder.append(a);
                    stringBuilder.append(" FROM ");
                    stringBuilder.append("_temp_" + str);
                    try {
                        this.f2948a.m5996c(stringBuilder.toString());
                        return;
                    } catch (Exception e) {
                        throw new Exception("DbUpdateHelper insertData mDbHelper.executeSQL error");
                    }
                }
                throw new Exception("DbUpdateHelper insertData sInsertColumns is null. [tableName=" + str + "]");
            } catch (Exception e2) {
                throw new Exception("DbUpdateHelper insertData mDbHelper.getOldColumnNames error ");
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public void m6065a() throws Exception {
        for (C1359a c1359a : f2947c) {
            String w = c1359a.m6006w();
            if (this.f2948a.m5998e(w)) {
                this.f2948a.m5999f(w);
                C1336d.m5886b("DbUpdateHelper", "tableName exist moidfy table successfully.");
                try {
                    this.f2948a.m5996c(c1359a.m6005v());
                    m6064a(w);
                    C1336d.m5886b("DbUpdateHelper", "insert data to table successfully.");
                    this.f2948a.m5991a(w);
                    C1336d.m5886b("DbUpdateHelper", "drop table temp table successfully.");
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                this.f2948a.m5996c(c1359a.m6005v());
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    public void m6066b() throws Exception {
        for (C1359a w : f2946b) {
            String w2 = w.m6006w();
            if (this.f2948a.m5998e(w2)) {
                try {
                    this.f2948a.m5995b(w2);
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        for (C1359a w3 : f2947c) {
            try {
                this.f2948a.m5996c(w3.m6005v());
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
