package com.huawei.pluginkidwatch.home;

import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonState;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateRetIOModel;

/* compiled from: HomeActivity */
class C1658m implements C1378e {
    final /* synthetic */ String f4359a;
    final /* synthetic */ HomeActivity f4360b;

    C1658m(HomeActivity homeActivity, String str) {
        this.f4360b = homeActivity;
        this.f4359a = str;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============== response --> is null");
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============retCode", baseEntityModel.retCode + "");
        if (baseEntityModel.retCode == 0 && this.f4359a.equals(C1462f.m6746j())) {
            CommonStateRetIOModel commonStateRetIOModel = (CommonStateRetIOModel) baseEntityModel;
            Object obj = "";
            String str = "";
            if (commonStateRetIOModel.commonStates.size() == 0) {
                Message message = new Message();
                message.what = 10009;
                message.arg1 = -1;
                this.f4360b.f4131c.sendMessage(message);
                return;
            }
            int i;
            for (CommonState commonState : commonStateRetIOModel.commonStates) {
                String str2;
                Object obj2;
                C2538c.m12674b("KIDWATCH_HomeActivity", "=========arr:" + commonState.toString());
                switch (commonState.type) {
                    case 1:
                        str2 = str;
                        obj2 = obj;
                        break;
                    case 2:
                        String str3 = str;
                        str = commonState.value;
                        str2 = str3;
                        break;
                    case 3:
                        str2 = commonState.value;
                        obj2 = obj;
                        break;
                    default:
                        C2538c.m12674b("KIDWATCH_HomeActivity", "=========illegal status:" + commonState.type);
                        str2 = str;
                        obj2 = obj;
                        break;
                }
                obj = obj2;
                str = str2;
            }
            if ("0".equals(obj)) {
                i = 0;
            } else if ("0".equals(str)) {
                i = 2;
            } else if ("1".equals(str)) {
                i = 3;
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========= illegal wearing");
                i = -1;
            }
            Message message2 = new Message();
            message2.what = 10009;
            message2.arg1 = i;
            this.f4360b.f4131c.sendMessage(message2);
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========getUpdateState-->table is null");
    }
}
