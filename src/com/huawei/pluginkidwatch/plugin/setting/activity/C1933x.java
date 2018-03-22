package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1388d;

/* compiled from: CheckBillActivity */
class C1933x extends Handler {
    final /* synthetic */ CheckBillActivity f6701a;

    C1933x(CheckBillActivity checkBillActivity) {
        this.f6701a = checkBillActivity;
    }

    public void handleMessage(Message message) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= msg.what ==" + message.what);
        switch (message.what) {
            case 1:
                if (this.f6701a.f6321z) {
                    C1483c.m6834d(this.f6701a.f6303h, String.format(this.f6701a.getResources().getString(C1680l.f4399x10817c5a), new Object[]{Integer.valueOf(1), Integer.valueOf(5)}));
                    break;
                }
                break;
            case 2:
                C1388d c1388d = (C1388d) message.obj;
                if (c1388d != null) {
                    C2538c.m12674b("CheckBillActivity", "=checkBill= billInfo==" + c1388d);
                    this.f6701a.f6300e.add(c1388d);
                }
                this.f6701a.m9809h();
                this.f6701a.f6302g.notifyDataSetChanged();
                if (this.f6701a.f6321z) {
                    C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.f4400xdd3e287b));
                }
                this.f6701a.m9817l();
                break;
            case 4:
                this.f6701a.f6313r = 10;
                if (this.f6701a.f6321z) {
                    C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.f4398xbc51a02));
                }
                this.f6701a.m9817l();
                break;
            case 5:
                if (this.f6701a.f6321z) {
                    C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.IDS_plugin_kidwatch_common_network_disable));
                }
                this.f6701a.m9817l();
                break;
            case 6:
                if (this.f6701a.f6321z) {
                    C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.IDS_plugin_kidwatch_common_network_timeout_try));
                    break;
                }
                break;
            case 7:
                C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.f4401x3959e6e7));
                break;
            case 8:
                C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.IDS_plugin_kidwatch_settings_check_bill_main_No_SimNum));
                break;
            case 9:
                this.f6701a.m9817l();
                C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.f4402xf097c031));
                break;
            case 10:
                C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.f4404x98aaf216));
                break;
            case 11:
                C1483c.m6834d(this.f6701a.f6303h, this.f6701a.getResources().getString(C1680l.f4403x6f8a9dc8));
                break;
        }
        super.handleMessage(message);
    }
}
