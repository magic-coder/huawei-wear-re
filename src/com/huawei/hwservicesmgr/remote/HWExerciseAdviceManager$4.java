package com.huawei.hwservicesmgr.remote;

import com.huawei.datatype.SportReminder;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

final class HWExerciseAdviceManager$4 implements IBaseResponseCallback {
    HWExerciseAdviceManager$4() {
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWExerciseAdviceManager", new Object[]{"deviceSportRemindCallback  err_code = " + i});
        if (100000 == i) {
            int sport_type = ((SportReminder) obj).getSport_type();
            C2538c.c("HWExerciseAdviceManager", new Object[]{"deviceSportRemindCallback 调用运动建议的回调，实现语音播报, sportType=" + sport_type + "number=" + r8.getRun_phrase_number() + ", param=" + r8.getRun_phrase_variable()});
        }
    }
}
