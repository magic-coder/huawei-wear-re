package com.huawei.hwid.openapi.out;

import java.util.Arrays;
import java.util.List;

public class OutConst {
    public static final List ABILITIES = Arrays.asList(new String[]{"basic"});
    public static final int version = 1006;

    public static int getIterfaceVersion() {
        return 1006;
    }

    public static boolean hasAbility(String str) {
        return ABILITIES.contains(str);
    }
}
