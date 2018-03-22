package com.huawei.ui.homewear21.p175a;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdevicefontmgr.C1021a;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1996x;
import com.huawei.ui.homewear21.c;
import com.huawei.ui.homewear21.card.p176a.C2243a;
import com.huawei.ui.homewear21.i;
import java.util.List;

/* compiled from: HomeFragment */
class C2234r extends Handler {
    final /* synthetic */ C2217a f8148a;

    C2234r(C2217a c2217a) {
        this.f8148a = c2217a;
    }

    public void handleMessage(Message message) {
        if (this.f8148a.getActivity() == null || this.f8148a.getActivity().isFinishing()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Activity is finishing or null.");
            return;
        }
        int deviceConnectState;
        switch (message.what) {
            case 1:
                this.f8148a.m11448a(11, this.f8148a.ak, ((Boolean) message.obj).booleanValue());
                break;
            case 2:
                this.f8148a.m11448a(1, this.f8148a.ak, ((Boolean) message.obj).booleanValue());
                break;
            case 3:
                a.a(this.f8148a.f7992A, i.IDS_not_support_gold_card);
                break;
            case 4:
                a.a(this.f8148a.f7992A, i.IDS_confirm_network_whether_connected);
                break;
            case 5:
                a.a(this.f8148a.f7992A, i.IDS_main_sns_member_account_has_been_effective);
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Account has been effective, please login again");
                break;
            case 6:
                a.a(this.f8148a.f7992A, i.IDS_main_sns_member_activation_no_get_my_user_infor_failure);
                break;
            case 7:
                this.f8148a.m11448a(2, this.f8148a.ak, ((Boolean) message.obj).booleanValue());
                break;
            case 8:
                C2538c.m12661a("MainUI", 1, "HomeFragment", "reset factory success");
                this.f8148a.f8004M.m10450n();
                this.f8148a.m11556k();
                this.f8148a.f8019d.m11686a();
                this.f8148a.aa();
                break;
            case 9:
                a.b(this.f8148a.f7992A, i.IDS_settings_restore_factory_settings_low_battery_dialog_msg);
                break;
            case 10:
                this.f8148a.m11472a((List) message.obj);
                break;
            case 11:
                a.b(this.f8148a.f7992A, i.IDS_plugin_menu_reset_failed);
                this.f8148a.m11556k();
                break;
            case 12:
                this.f8148a.m11507e(i.IDS_main_sns_member_activation_get_my_user_infor);
                break;
            case 13:
                this.f8148a.m11556k();
                break;
            case 14:
                this.f8148a.m11448a(15, this.f8148a.ak, ((Boolean) message.obj).booleanValue());
                break;
            case 15:
                this.f8148a.m11555j();
                break;
            case 16:
                this.f8148a.m11556k();
                break;
            case 17:
                this.f8148a.aO();
                break;
            case 18:
                this.f8148a.ac();
                break;
            case 19:
                this.f8148a.bn();
                break;
            case 24:
                this.f8148a.ab();
                break;
            case 26:
                this.f8148a.bv();
                break;
            case 27:
                this.f8148a.aK();
                break;
            case 1001:
                this.f8148a.ag = C2243a.m11601a().m11614c();
                this.f8148a.m11416P();
                if (this.f8148a.ag == null) {
                    this.f8148a.m11495c(3);
                    C2538c.m12661a("MainUI", 0, "HomeFragment", "deviceInfo is null");
                    break;
                }
                deviceConnectState = this.f8148a.ag.getDeviceConnectState();
                this.f8148a.f8019d.m11687a(new DeviceInfo[0]);
                this.f8148a.m11485b(this.f8148a.ag);
                this.f8148a.m11495c(deviceConnectState);
                break;
            case 1002:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter GET_BATTETY_LEVEL");
                C2243a.m11601a().m11608a(new C2235s(this));
                break;
            case 1003:
                deviceConnectState = message.arg1;
                this.f8148a.f8026k.setImageDrawable(C1996x.m10458b(deviceConnectState, this.f8148a.f7992A));
                this.f8148a.f8028m.setText(C0956c.m3344a((double) deviceConnectState, 2, 0));
                this.f8148a.f8026k.setVisibility(0);
                this.f8148a.f8028m.setVisibility(0);
                if (deviceConnectState > 10) {
                    this.f8148a.f8028m.setTextColor(this.f8148a.f7992A.getResources().getColor(c.color_device_battery_value));
                    break;
                } else {
                    this.f8148a.f8028m.setTextColor(this.f8148a.f7992A.getResources().getColor(c.common_dialog_red_btn_color));
                    break;
                }
            case 1004:
                this.f8148a.m11553h();
                break;
            case 1005:
                this.f8148a.m11554i();
                break;
            case 1007:
                this.f8148a.ah();
                break;
            case 1008:
                this.f8148a.m11538z();
                break;
            case 1009:
                C1988p.m10381a(this.f8148a.f7992A).m10397e();
                break;
            case 1010:
                this.f8148a.ai();
                break;
            case 1011:
                this.f8148a.m11496c((DeviceInfo) message.obj);
                this.f8148a.m11503d((DeviceInfo) message.obj);
                break;
            case 1013:
                this.f8148a.aA();
                break;
            case 1014:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "MSG_RETRY_REFRESH_SETTING_LIST");
                this.f8148a.ai();
                break;
            case 1015:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "MSG_PUSH_WEATHER_REPORT_CIRCUL");
                this.f8148a.aW();
                break;
            case 1016:
                this.f8148a.bh();
                break;
            case 1017:
                this.f8148a.ag();
                break;
            case 1018:
                com.huawei.u.a.a();
                com.huawei.i.a.a(BaseApplication.m2632b());
                com.huawei.h.a.a(BaseApplication.m2632b());
                C1021a.m3912a(BaseApplication.m2632b());
                C1026q.m4018a(BaseApplication.m2632b());
                break;
            case 1020:
                this.f8148a.aK();
                break;
            case 1021:
                this.f8148a.bG();
                break;
            case 1022:
                this.f8148a.ag = C2243a.m11601a().m11614c();
                if (this.f8148a.ag != null && this.f8148a.ag.getProductType() != 10) {
                    this.f8148a.bd();
                    break;
                }
                C2538c.m12661a("MainUI", 0, "HomeFragment", "null or leo");
                break;
                break;
            case 1023:
                this.f8148a.bd();
                break;
            default:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter default");
                break;
        }
        super.handleMessage(message);
    }
}
