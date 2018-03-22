package com.alipay.p238a.p239a.p240a.p241a.p242a;

import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;

public enum C3135b {
    SUCCESS_SCHEME(TradeCode.SUCESS_4_PLATFORM, "唤起成功，基于scheme"),
    SUCCESS_SERVICE(8000, "唤起成功，基于服务绑定"),
    NOT_INSTALL(7000, "钱包未安装"),
    UNSUPPORT_APP(6000, "暂未支持的应用"),
    SYS_ERROR(5000, "进程通信异常"),
    FAKE(4000, "非正式钱包"),
    UNSUPPORT_MAIN_THREAD(3000, "不支持在主线程执行");
    
    private int f10496h;
    private String f10497i;

    private C3135b(int i, String str) {
        this.f10496h = i;
        this.f10497i = str;
    }

    public final int m13962a() {
        return this.f10496h;
    }

    public final String m13963b() {
        return this.f10497i;
    }
}
