package com.huawei.sim;

import android.os.Message;
import com.huawei.ah.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;

/* compiled from: PluginSimAdapter */
public interface C4501b extends b {
    void mo4467a(Message message);

    void mo4468a(IBaseResponseCallback iBaseResponseCallback);

    void mo4469a(String str, int i, IBaseResponseCallback iBaseResponseCallback, IBaseResponseCallback iBaseResponseCallback2);

    void mo4470a(String str, IBaseResponseCallback iBaseResponseCallback, IBaseResponseCallback iBaseResponseCallback2);

    void mo4471a(String str, String str2, int i);

    void mo4472a(boolean z);

    boolean mo4473a(MultiSimDeviceInfo multiSimDeviceInfo);

    int mo4474b();

    void mo4475b(IBaseResponseCallback iBaseResponseCallback);

    String mo4476c();

    String mo4477d();

    int mo4478e();

    String mo4479f();

    String mo4480g();

    MultiSimDeviceInfo mo4481h();

    boolean mo4482i();

    boolean mo4483j();

    String mo4484k();
}
