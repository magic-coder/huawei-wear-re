package com.huawei.android.pushagent.p020b.p021a.p327b;

import java.io.InputStream;
import java.net.Socket;

public interface C4078b {

    public enum C4080a {
        ChannelType_Normal,
        ChannelType_SSL,
        ChannelType_SSL_Resume,
        ChannelType_Secure
    }

    void mo4369a() throws Exception;

    boolean mo4370a(Socket socket) throws Exception;

    boolean mo4371a(byte[] bArr) throws Exception;

    boolean mo4372b();

    Socket mo4373c();

    InputStream mo4374d();
}
