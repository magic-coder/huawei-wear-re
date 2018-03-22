package com.huawei.android.pushagent.p017a.p320a.p321a;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p320a.C4038a;
import com.huawei.android.pushagent.p017a.p320a.C4039b;
import java.io.InputStream;
import java.util.HashMap;

public class C4035a {
    private static HashMap f15336a = new HashMap();

    static {
        f15336a.put(Byte.valueOf((byte) 1), C4038a.class);
        f15336a.put(Byte.valueOf((byte) 2), C4039b.class);
    }

    public static C4037b m19845a(Byte b, InputStream inputStream) throws InstantiationException, IllegalAccessException, Exception {
        if (f15336a.containsKey(b)) {
            C4037b c4037b = (C4037b) ((Class) f15336a.get(b)).newInstance();
            C4037b a = c4037b.mo4354a(inputStream);
            if (a != null) {
                e.b("PushLogAC2712", "after decode msg:" + a);
            } else {
                e.d("PushLogAC2712", "call " + c4037b.getClass().getSimpleName() + " decode failed!");
            }
            return a;
        }
        e.d("PushLogAC2712", "cmdId:" + b + " is not exist, all:" + f15336a.keySet());
        throw new InstantiationException("cmdId:" + b + " is not register");
    }
}
