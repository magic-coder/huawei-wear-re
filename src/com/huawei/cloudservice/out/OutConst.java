package com.huawei.cloudservice.out;

import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.util.Arrays;
import java.util.List;

public class OutConst {
    public static final List<String> ABILITIES = Arrays.asList(new String[]{"basic", "aidl"});
    public static final String TAG = "OutConst";

    public static boolean hasAbility(String str) {
        return ABILITIES.contains(str);
    }

    public static int getIterfaceVersion() {
        int i = -1;
        try {
            i = Integer.parseInt(HwAccountConstants.SDK_VERSION.replace(".", ""));
            C5165e.m24904a(TAG, "version is " + i);
            return i;
        } catch (NumberFormatException e) {
            C5165e.m24910d(TAG, "NumberFormatException string cannot be parsed as an integer value");
            return i;
        } catch (Exception e2) {
            C5165e.m24910d(TAG, "Exception string cannot be parsed as an integer value");
            return i;
        }
    }
}
