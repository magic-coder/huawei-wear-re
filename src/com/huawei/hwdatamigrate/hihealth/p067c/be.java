package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.c.bd;
import java.util.ArrayList;

/* compiled from: MigrateDBManager */
public class be extends C0628a {
    private static be f1679a;

    private be(Context context) {
        super(context);
        new bd().a(this);
    }

    public static be m3648a() {
        be beVar;
        synchronized (be.class) {
            if (f1679a == null) {
                f1679a = new be(BaseApplication.m2632b());
            }
            beVar = f1679a;
        }
        return beVar;
    }

    public long m3650a(bf bfVar) {
        bd bdVar = new bd();
        if (bdVar.d(this, bfVar.m3656a(), bfVar.m3659b())) {
            return 0;
        }
        return bdVar.a(this, bfVar);
    }

    public int m3649a(String str, String str2) {
        return new bd().a(this, str, str2);
    }

    public ArrayList<bf> m3651a(String str) {
        return new bd().b(this, str);
    }

    public ArrayList<bf> m3653b(String str) {
        return new bd().a(this, str);
    }

    public ArrayList<bf> m3655c(String str) {
        return new bd().c(this, str);
    }

    public int m3652b(String str, String str2) {
        return new bd().b(this, str, str2);
    }

    public int m3654c(String str, String str2) {
        return new bd().c(this, str, str2);
    }

    public Integer getModuleId() {
        return Integer.valueOf(20008);
    }
}
