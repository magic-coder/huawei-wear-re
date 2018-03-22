package com.snowballtech.business.config;

public class BusinessConfigs {
    public static String fetchServer() {
        return ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_URL_REQUEST);
    }

    public static boolean fetchAdapterServer() {
        return Boolean.parseBoolean(ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_ISADAPTERSERVER));
    }

    public static String fetchSDKVersionCode() {
        return ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_SDK_VERSION_CODE);
    }

    public static String fetchDynamicDexUrl() {
        return ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_URL_URL_DYNAMIC_DEX);
    }

    public static String fetchSDKVersionName() {
        return ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_SDK_VERSION_NAME);
    }

    public static String getRequestHead() {
        if (fetchAdapterServer()) {
            return "https://";
        }
        return "http://";
    }
}
