package com.huawei.openalliance.ad.utils.p119c;

import android.content.Context;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;

public class C1353e {
    public static HttpResponse m5972a(Context context, HttpUriRequest httpUriRequest) throws UnsupportedEncodingException, IllegalArgumentException, IllegalStateException, IOException {
        try {
            HttpClient a = C1354f.m5973a();
            a.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, Boolean.valueOf(false));
            return a.execute(httpUriRequest);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e2) {
            C1336d.m5883a("HttpUtilsOfficial", "execute request fail", e2);
            throw new IOException("IOException[don't set proxy]");
        }
    }
}
