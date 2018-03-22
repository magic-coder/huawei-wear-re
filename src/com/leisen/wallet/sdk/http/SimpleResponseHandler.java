package com.leisen.wallet.sdk.http;

import com.huawei.p190v.C2538c;

import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

public abstract class SimpleResponseHandler extends AsyncHttpResponseHandler {
    public abstract void OnFailure(String str, Throwable th);

    public abstract void onSuccess(String str);

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(getResponseString(bArr, getCharset()));
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        OnFailure(getResponseString(bArr, getCharset()), th);
    }

    private String getResponseString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            C2538c.e("", new Object[]{"==>" + e.getMessage()});
            return null;
        }
    }
}
