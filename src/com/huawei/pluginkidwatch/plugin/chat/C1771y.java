package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatActivity */
class C1771y implements C1378e {
    final /* synthetic */ C1744a f4867a;
    final /* synthetic */ ChatActivity f4868b;

    C1771y(ChatActivity chatActivity, C1744a c1744a) {
        this.f4868b = chatActivity;
        this.f4867a = c1744a;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        CommonRetIModel commonRetIModel = (CommonRetIModel) baseEntityModel;
        if (commonRetIModel == null || commonRetIModel.retCode != 0) {
            C2538c.m12674b("ChatActivity", "========addText return Failure");
            this.f4868b.m8383a(this.f4867a, 1);
            return;
        }
        C2538c.m12674b("ChatActivity", "========addText return model：" + commonRetIModel);
        C2538c.m12674b("ChatActivity", "========addText return Success");
        this.f4868b.m8383a(this.f4867a, 0);
        this.f4868b.m8453u();
    }
}
