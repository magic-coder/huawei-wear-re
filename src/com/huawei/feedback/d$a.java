package com.huawei.feedback;

import com.huawei.crowdtestsdk.utils.ResUtil;

/* compiled from: ReflectUtils */
public enum d$a {
    RES_TYPE_ID("id"),
    RES_TYPE_LAYOUT(ResUtil.TYPE_LAYOUT),
    RES_TYPE_STRING(ResUtil.TYPE_STRING),
    RES_TYPE_DRAWABLE(ResUtil.TYPE_DRAWABLE),
    RES_TYPE_STYLE("style"),
    RES_TYPE_COLOR("color"),
    RES_TYPE_DIMEN(ResUtil.TYPE_DIMEN),
    RES_TYPE_MENU("menu"),
    RES_TYPE_ARRAY(ResUtil.TYPE_ARRAY);
    
    private String f16382j;

    private d$a(String str) {
        this.f16382j = str;
    }

    public String toString() {
        return this.f16382j;
    }
}
