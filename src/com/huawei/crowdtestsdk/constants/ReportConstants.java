package com.huawei.crowdtestsdk.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReportConstants {
    private static final String BETACLUB_APP_VERSION = "betaclub_app_version";
    private static final String HARD_VERSION = "hardware_version";
    private static final String HW_WEARABLE_APP_VERSION = "hw_wearable_app_version";
    private static final String PHONE_ANDROID_VERSION = "phone_android_version";
    private static final String PHONE_MODEL = "phone_model";
    private static final String PHONE_VERSION = "phone_version";
    private static final String ROUTER_BRAND = "router_brand";
    private static final String SERIES_NUMBER = "series_number";
    private static final String SOFTWARE_VERSION = "software_version";
    public static final List<String> USER_REPORT_PARAM_LIST = Collections.unmodifiableList(Arrays.asList(new String[]{SOFTWARE_VERSION, HARD_VERSION, PHONE_MODEL, PHONE_VERSION, PHONE_ANDROID_VERSION, BETACLUB_APP_VERSION, HW_WEARABLE_APP_VERSION, ROUTER_BRAND, SERIES_NUMBER}));
}
