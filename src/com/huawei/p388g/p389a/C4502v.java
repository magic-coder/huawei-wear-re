package com.huawei.p388g.p389a;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.sim.C4501b;
import com.huawei.w.c;

/* compiled from: PluginSimAdapterImpl */
public class C4502v implements C4501b {
    private static C4502v f16674a;
    private static c f16675b;

    private C4502v() {
        f16675b = c.a();
        if (f16675b == null) {
            C2538c.e("PluginSimAdapterImpl", new Object[]{"mMultiSimMgr is null"});
        }
    }

    public static C4502v m21543a() {
        C4502v c4502v;
        synchronized (C4502v.class) {
            C2538c.c("PluginSimAdapterImpl", new Object[]{"instance: " + f16674a});
            if (f16674a == null) {
                f16674a = new C4502v();
            }
            c4502v = f16674a;
        }
        return c4502v;
    }

    public void mo4470a(String str, IBaseResponseCallback iBaseResponseCallback, IBaseResponseCallback iBaseResponseCallback2) {
        if (f16675b != null) {
            f16675b.a(str, iBaseResponseCallback, iBaseResponseCallback2);
            return;
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"openEsim mMultiSimMgr is null"});
    }

    public void mo4468a(IBaseResponseCallback iBaseResponseCallback) {
        if (f16675b != null) {
            f16675b.a(iBaseResponseCallback);
            return;
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"regiserBTConnectChangerCallBack mMultiSimMgr is null"});
    }

    public void mo4475b(IBaseResponseCallback iBaseResponseCallback) {
        if (f16675b != null) {
            f16675b.b(iBaseResponseCallback);
            return;
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"unRegiserBTConnectChangerCallBack mMultiSimMgr is null"});
    }

    public int mo4474b() {
        if (f16675b != null) {
            return f16675b.i();
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"blueToothConnectStatus mMultiSimMgr is null"});
        return 0;
    }

    public void mo4469a(String str, int i, IBaseResponseCallback iBaseResponseCallback, IBaseResponseCallback iBaseResponseCallback2) {
        if (f16675b != null) {
            f16675b.b(str, i, iBaseResponseCallback, iBaseResponseCallback2);
            return;
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"sendConformCode mMultiSimMgr is null"});
    }

    public void mo4472a(boolean z) {
        if (f16675b != null) {
            f16675b.a(z);
            return;
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"setAppAuthStatus mMultiSimMgr is null"});
    }

    public String mo4476c() {
        String str = "";
        if (f16675b != null) {
            return f16675b.j();
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"getEsimPermission mMultiSimMgr is null"});
        return str;
    }

    public String mo4477d() {
        String str = "";
        if (f16675b != null) {
            return f16675b.o();
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"getEsimPermission mMultiSimMgr is null"});
        return str;
    }

    public int mo4478e() {
        if (f16675b != null) {
            return f16675b.l();
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"getEsimPermission mMultiSimMgr is null"});
        return 0;
    }

    public String mo4479f() {
        String str = "";
        if (f16675b != null) {
            return f16675b.m();
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"getEsimPermission mMultiSimMgr is null"});
        return str;
    }

    public void mo4471a(String str, String str2, int i) {
        if (f16675b != null) {
            f16675b.a(str, str2, i);
            return;
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"getEsimPermission mMultiSimMgr is null"});
    }

    public boolean mo4473a(MultiSimDeviceInfo multiSimDeviceInfo) {
        if (f16675b != null) {
            return f16675b.a(f16675b.k());
        }
        return false;
    }

    public String mo4480g() {
        String str = "";
        if (f16675b != null) {
            return f16675b.n();
        }
        return "";
    }

    public MultiSimDeviceInfo mo4481h() {
        if (f16675b != null) {
            return f16675b.k();
        }
        C2538c.e("PluginSimAdapterImpl", new Object[]{"getEsimPermission mMultiSimMgr is null"});
        return new MultiSimDeviceInfo();
    }

    public boolean mo4482i() {
        if (f16675b != null) {
            return f16675b.f();
        }
        return false;
    }

    public boolean mo4483j() {
        if (f16675b != null) {
            return f16675b.g();
        }
        return false;
    }

    public String mo4484k() {
        String str = "";
        if (f16675b != null) {
            return f16675b.d();
        }
        return str;
    }

    public void mo4467a(Message message) {
        if (f16675b != null) {
            f16675b.a(message);
        }
    }

    public static void m21544l() {
        C2538c.e("PluginSimAdapterImpl", new Object[]{"onDestroy"});
        synchronized (C4502v.class) {
            f16674a = null;
            f16675b = null;
        }
    }
}
