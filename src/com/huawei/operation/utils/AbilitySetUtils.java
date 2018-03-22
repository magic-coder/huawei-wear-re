package com.huawei.operation.utils;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class AbilitySetUtils {
    private static final int DEFAULT_APP_TYPE = 0;
    private static final int HEALTH_APP_TYPE = 2;
    private static final String MOTION_PATH_ABILITY = "motionPath";
    private static final String SOCIALITY_ABILITY = "sociality";
    private static final int WEAR_APP_TYPE = 1;

    class AbilityObj {
        private Map<String, Integer> abilityMap = new HashMap();
        private int appType;

        AbilityObj() {
        }

        public void add(String str, int i) {
            this.abilityMap.put(str, Integer.valueOf(i));
        }

        public void setAppType(int i) {
            this.appType = i;
        }

        public int getAppType() {
            return this.appType;
        }
    }

    public static String getAbilitySet() {
        AbilityObj abilityObj = new AbilityObj();
        abilityObj.add(MOTION_PATH_ABILITY, 1);
        abilityObj.add(SOCIALITY_ABILITY, 1);
        abilityObj.setAppType(0);
        return new Gson().toJson(abilityObj);
    }
}
