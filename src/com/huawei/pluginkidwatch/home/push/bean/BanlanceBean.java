package com.huawei.pluginkidwatch.home.push.bean;

import com.huawei.pluginkidwatch.common.entity.model.Banlance;

public class BanlanceBean extends KOnePushBeanBase {
    public Banlance data = new Banlance();

    public String toString() {
        if (this.data == null) {
            return "BanlanceBean{data=" + this.data + '}';
        }
        return "BanlanceBean{data=" + this.data.toString() + '}';
    }
}
