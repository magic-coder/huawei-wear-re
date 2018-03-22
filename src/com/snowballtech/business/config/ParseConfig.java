package com.snowballtech.business.config;

import com.snowballtech.business.BuildConfig;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ObjectUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.HashMap;
import java.util.Map;

public class ParseConfig {
    public static final String CFG_CUSTOMER = "customer";
    public static final String CFG_DATA_INTERACTION_MODULE = "data_interaction_module";
    public static final String CFG_ENVIRONMENT = "environment";
    public static final String CFG_ISACCESSSIGN = "isAccessSign";
    public static final String CFG_ISADAPTERSERVER = "isAdapterServer";
    public static final String CFG_ISSHOWLOGFLAG = "isShowLogFlag";
    public static final String CFG_OMA_MODULE = "oma_module";
    public static final String CFG_SDK_VERSION_CODE = "sdk_version_code";
    public static final String CFG_SDK_VERSION_NAME = "sdk_version_name";
    public static final String CFG_URL_REQUEST = "url_request";
    public static final String CFG_URL_URL_DYNAMIC_DEX = "url_dynamic_dex";
    private static volatile ParseConfig singleton;
    public Map<String, String> configs;

    public static ParseConfig getInstance() {
        if (singleton == null) {
            synchronized (ParseConfig.class) {
                if (singleton == null) {
                    singleton = new ParseConfig();
                }
            }
        }
        return singleton;
    }

    private ParseConfig() {
        loadConfig();
    }

    private void loadConfigServer(String str) {
        if (!ValueUtil.isEmpty(str)) {
            if (str.equals("dev")) {
                updateProperties(ObjectUtil.fetchProperties(DevConfig.class, new DevConfig()));
            } else if (str.equals("test")) {
                updateProperties(ObjectUtil.fetchProperties(TestConfig.class, new TestConfig()));
            } else if (str.equals("sittest")) {
                updateProperties(ObjectUtil.fetchProperties(SitTestConfig.class, new SitTestConfig()));
            } else if (str.equals(BuildConfig.environment)) {
                updateProperties(ObjectUtil.fetchProperties(ProductConfig.class, new ProductConfig()));
            }
        }
    }

    private void loadConfigEnv() {
        updateProperties(ObjectUtil.fetchPropertiesFromFinalClass(BuildConfig.class));
        if (this.configs != null && this.configs.size() > 0) {
            LogUtil.internalSwitchLog(fetchConfig("sdk_log_switch"));
            LogUtil.updateVersion(fetchConfig(CFG_SDK_VERSION_CODE));
        }
    }

    private void updateProperties(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                this.configs.put(str, (String) map.get(str));
            }
        }
    }

    private void loadConfig() {
        if (this.configs == null || this.configs.size() == 0) {
            this.configs = new HashMap();
            loadConfigEnv();
            loadConfigServer(fetchConfig(CFG_ENVIRONMENT));
        }
    }

    public String fetchConfig(String str) {
        if (this.configs == null) {
            loadConfig();
        }
        String str2 = "";
        LogUtil.log("add by yong" + str);
        if (this.configs == null || ValueUtil.isEmpty(str)) {
            return str2;
        }
        return (String) this.configs.get(str);
    }

    public void release() {
        if (this.configs != null) {
            this.configs.clear();
            this.configs = null;
        }
    }
}
