package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.model.SynchronizePushIOEntityModel;
import com.huawei.pluginkidwatch.home.push.IPushProcess;
import com.huawei.pluginkidwatch.home.push.bean.KOnePushBeanBase;
import java.util.HashMap;

/* compiled from: PushUtil */
public class C1644x {
    private static Gson f4259a = new Gson();
    private static HashMap<String, String> f4260b = new HashMap();

    static {
        f4260b.put("1", "com.huawei.pluginkidwatch.home.push.InformationToSee");
        f4260b.put("2", "com.huawei.pluginkidwatch.home.push.InformationToSee");
        f4260b.put("3", "com.huawei.pluginkidwatch.home.push.InformationToSee");
        f4260b.put("4", "com.huawei.pluginkidwatch.home.push.InformationToSee");
        f4260b.put("5", "com.huawei.pluginkidwatch.home.push.SOSMessage");
        f4260b.put("6", "com.huawei.pluginkidwatch.home.push.SOSLocat");
        f4260b.put(CardStatusQueryResponse.DEV_STATUS_LOCK, "com.huawei.pluginkidwatch.home.push.ConfirmBind");
        f4260b.put(WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD, "com.huawei.pluginkidwatch.home.push.AcquireManagerPermission");
        f4260b.put("11", "com.huawei.pluginkidwatch.home.push.GetManagerPermission");
        f4260b.put("12", "com.huawei.pluginkidwatch.home.push.AddContact");
        f4260b.put("13", "com.huawei.pluginkidwatch.home.push.GetManagerPermission");
        f4260b.put("14", "com.huawei.pluginkidwatch.home.push.InformationToSee");
        f4260b.put("15", "com.huawei.pluginkidwatch.home.push.InformationToSee");
        f4260b.put("16", "com.huawei.pluginkidwatch.home.push.RewardReached");
        f4260b.put("17", "com.huawei.pluginkidwatch.home.push.InformationToSee");
        f4260b.put("18", "com.huawei.pluginkidwatch.home.push.ChatPush");
        f4260b.put("19", "com.huawei.pluginkidwatch.home.push.RequestReward");
        f4260b.put(HwAccountConstants.TYPE_WEIXIN, "com.huawei.pluginkidwatch.home.push.CheckBillPush");
        f4260b.put("23", "com.huawei.pluginkidwatch.home.push.OtherManagerBindPush");
        f4260b.put("26", "com.huawei.pluginkidwatch.home.push.MissCallInformation");
    }

    public void m7783a(SynchronizePushIOEntityModel synchronizePushIOEntityModel, String str, Context context) {
        C2538c.m12674b("PushUtil", "=========get getPushContent");
        C1417a.m6594a(context).mo2497a(synchronizePushIOEntityModel, new C1645y(this, str, context));
    }

    private void m7781a(Context context, KOnePushBeanBase kOnePushBeanBase, String str, boolean z) {
        C2538c.m12674b("PushUtil", "========Enter processData  show:" + z);
        try {
            C2538c.m12674b("PushUtil", "======== bean.type:", kOnePushBeanBase.type + "");
            C2538c.m12674b("PushUtil", "======== processMap.get:", f4260b.get(kOnePushBeanBase.type));
            Class cls = Class.forName((String) f4260b.get(kOnePushBeanBase.type));
            cls.getMethod(IPushProcess.class.getMethods()[0].getName(), new Class[]{Context.class, String.class, Boolean.TYPE}).invoke(cls.newInstance(), new Object[]{context, str, Boolean.valueOf(z)});
        } catch (Exception e) {
            C2538c.m12680e("PushUtil", "=====processData error catch:" + e.getMessage());
        }
    }
}
