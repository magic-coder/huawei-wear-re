package com.huawei.openalliance.ad.utils.p119c;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.openalliance.ad.utils.C1361e;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

public class C1352d {
    private static String m5970a(HttpUriRequest httpUriRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(httpUriRequest.getMethod()).append(HwAccountConstants.BLANK).append(httpUriRequest.getProtocolVersion());
        stringBuffer.append(" head:");
        for (Header header : httpUriRequest.getAllHeaders()) {
            stringBuffer.append(header.getName()).append("=").append(header.getValue());
        }
        stringBuffer.append(" reqLine:" + httpUriRequest.getRequestLine());
        return stringBuffer.toString();
    }

    public static HttpResponse m5971a(Context context, HttpUriRequest httpUriRequest) throws UnsupportedEncodingException, IllegalArgumentException, IllegalStateException, IOException {
        try {
            HttpClient a = C1349a.m5964a();
            C1336d.m5886b("HttpUtils", C1361e.m6067a("direct connect start! req:" + C1352d.m5970a(httpUriRequest)));
            return a.execute(httpUriRequest);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e2) {
            C1336d.m5883a("HttpUtils", "execute request fail", e2);
            throw new IOException("IOException[don't set proxy]");
        }
    }
}
