package com.huawei.android.pushagent.p017a.p322b.p323a;

import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.tsm.business.constants.Constants;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.C4043b;
import com.huawei.android.pushagent.p017a.p322b.C4044c;
import com.huawei.android.pushagent.p017a.p322b.C4045d;
import com.huawei.android.pushagent.p017a.p322b.C4046e;
import com.huawei.android.pushagent.p017a.p322b.C4047f;
import com.huawei.android.pushagent.p017a.p322b.C4049h;
import com.huawei.android.pushagent.p017a.p322b.C4050i;
import com.huawei.android.pushagent.p017a.p322b.C4051j;
import com.huawei.android.pushagent.p017a.p322b.C4052k;
import com.huawei.android.pushagent.p017a.p322b.C4053l;
import com.huawei.android.pushagent.p017a.p322b.C4054m;
import com.huawei.android.pushagent.p017a.p322b.C4055n;
import com.huawei.android.pushagent.p017a.p322b.C4056o;
import com.huawei.android.pushagent.p017a.p322b.C4057p;
import com.huawei.android.pushagent.p017a.p322b.C4058q;
import java.io.InputStream;
import java.util.HashMap;

public class C4040a {
    private static HashMap f15346a = new HashMap();

    static {
        f15346a.put(Byte.valueOf((byte) -47), C4047f.class);
        f15346a.put(Byte.valueOf((byte) -37), C4052k.class);
        f15346a.put(Byte.valueOf((byte) -45), C4045d.class);
        f15346a.put(Byte.valueOf((byte) -33), C4050i.class);
        f15346a.put(Byte.valueOf((byte) -35), C4056o.class);
        f15346a.put(Byte.valueOf((byte) -41), C4058q.class);
        f15346a.put(Byte.valueOf(TagName.CommandSingle), C4053l.class);
        f15346a.put(Byte.valueOf((byte) -48), C4046e.class);
        f15346a.put(Byte.valueOf((byte) -38), C4051j.class);
        f15346a.put(Byte.valueOf((byte) -46), C4044c.class);
        f15346a.put(Byte.valueOf((byte) -34), C4049h.class);
        f15346a.put(Byte.valueOf((byte) -36), C4055n.class);
        f15346a.put(Byte.valueOf((byte) -42), C4057p.class);
        f15346a.put(Byte.valueOf(TagName.ScriptDown), C4054m.class);
        f15346a.put(Byte.valueOf(TagName.CommandMultiple), C4043b.class);
        f15346a.put(Byte.valueOf((byte) -91), C4043b.class);
        f15346a.put(Byte.valueOf(Constants.TagName.OPERATION_ID), C4043b.class);
        f15346a.put(Byte.valueOf(Constants.TagName.OPERATION_STEP), C4043b.class);
    }

    public static C4041b m19863a(Byte b, InputStream inputStream) throws InstantiationException, IllegalAccessException, Exception {
        if (f15346a.containsKey(b)) {
            C4041b c4041b = (C4041b) ((Class) f15346a.get(b)).newInstance();
            if (c4041b.mo4353a() == (byte) -1) {
                c4041b.m19867b(b.byteValue());
            }
            C4041b a = c4041b.mo4356a(inputStream);
            if (a != null) {
                e.a("PushLogAC2712", "after decode msg:" + a.a(a.mo4353a()));
            } else {
                e.d("PushLogAC2712", "call " + c4041b.getClass().getSimpleName() + " decode failed!");
            }
            return a;
        }
        e.d("PushLogAC2712", "cmdId:" + b + " is not exist, all:" + f15346a.keySet());
        throw new InstantiationException("cmdId:" + b + " is not register");
    }
}
