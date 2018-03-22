package com.amap.api.services.core;

/* compiled from: AMapCoreException */
public class C3433v extends Exception {
    private String f12510a = "未知的错误";
    private int f12511b = -1;

    public C3433v(String str) {
        super(str);
        m16985a(str);
    }

    public String m16986a() {
        return this.f12510a;
    }

    private void m16985a(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f12511b = 21;
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.f12511b = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f12511b = 23;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f12511b = 24;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f12511b = 25;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f12511b = 26;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f12511b = 27;
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.f12511b = 28;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f12511b = 29;
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.f12511b = 30;
        } else if ("未知的错误".equals(str)) {
            this.f12511b = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.f12511b = 32;
        } else if ("requeust is null".equals(str)) {
            this.f12511b = 1;
        } else if ("request url is empty".equals(str)) {
            this.f12511b = 2;
        } else if ("response is null".equals(str)) {
            this.f12511b = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f12511b = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f12511b = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f12511b = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f12511b = 7;
        } else if ("线程池为空".equals(str)) {
            this.f12511b = 8;
        } else {
            this.f12511b = -1;
        }
    }
}
