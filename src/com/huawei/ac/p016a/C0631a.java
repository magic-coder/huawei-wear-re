package com.huawei.ac.p016a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.datatype.WearableOpenAppInfo;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.t;
import com.huawei.hwcommonmodel.datatypes.w;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.p190v.C2538c;
import java.nio.ByteBuffer;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: HWWakeAppManager */
public class C0631a {
    private static C0631a f1125a;
    private static Context f1126b;
    private w f1127c = new w();

    public static C0631a m2326a(Context context) {
        if (f1125a == null && context != null) {
            f1126b = context;
            C2538c.m12677c("HWWakeAppManager", "getInstance() context = " + context);
            f1125a = new C0631a();
        }
        return f1125a;
    }

    private C0631a() {
    }

    public void m2328a(byte[] bArr) {
        WearableOpenAppInfo wearableOpenAppInfo = new WearableOpenAppInfo();
        String a = C0973a.m3509a(bArr);
        C2538c.m12674b("HWWakeAppManager", "handleOpenApp data = " + a);
        try {
            for (s sVar : this.f1127c.a(a.substring(4, a.length())).a) {
                switch (Integer.parseInt(sVar.a(), 16)) {
                    case 1:
                        wearableOpenAppInfo.setPackageName(C0973a.m3514c(sVar.b()));
                        break;
                    case 2:
                        wearableOpenAppInfo.setClassName(C0973a.m3514c(sVar.b()));
                        break;
                    default:
                        break;
                }
            }
            m2327a(wearableOpenAppInfo);
        } catch (t e) {
            C2538c.m12680e("HWWakeAppManager", "COMMAND_ID_GET_DATE error e = " + e);
        }
    }

    private void m2327a(WearableOpenAppInfo wearableOpenAppInfo) {
        if (f1126b != null) {
            Bundle bundle = new Bundle();
            bundle.putString("openPackageName", wearableOpenAppInfo.getPackageName());
            bundle.putString("openClassName", wearableOpenAppInfo.getClassName());
            Intent intent = new Intent();
            intent.setClassName(f1126b, "com.huawei.bone.root.SplashActivity");
            intent.putExtras(bundle);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            f1126b.startActivity(intent);
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(23);
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.put(TagName.ELECTRONIC_PUBLISH_START_TIME);
        allocate.put((byte) 4);
        allocate.put(C0973a.m3512b(C0973a.m3507a(100000)));
        deviceCommand.setDataLen(allocate.array().length);
        deviceCommand.setDataContent(allocate.array());
        C1023c.m3920a(f1126b).m3995b(deviceCommand);
    }
}
