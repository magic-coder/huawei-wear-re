package com.huawei.openalliance.ad.inter.constant;

import com.sina.weibo.sdk.constant.WBConstants;

public enum EventType {
    IMPRESSION("imp"),
    CLICK("click"),
    SWIPEUP("swipeup"),
    REMOVE("remove"),
    SHARE(WBConstants.ACTION_LOG_TYPE_SHARE),
    FAVORITE("favorite"),
    CLOSE("userclose"),
    SHOWEND("showstop");
    
    private final String event;

    private EventType(String str) {
        this.event = str;
    }

    public String value() {
        return this.event;
    }
}
