package com.huawei.hwcloudmodel.model;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONObject;

public class CustomStringRequest extends StringRequest {
    private static final String TAG = "CustomStringRequest";
    private Map<String, String> mMap = null;

    public CustomStringRequest(String str, Listener<String> listener, ErrorListener errorListener) {
        super(str, listener, errorListener);
    }

    public CustomStringRequest(int i, String str, Listener<String> listener, ErrorListener errorListener) {
        super(i, str, listener, errorListener);
    }

    public CustomStringRequest(int i, String str, Listener<String> listener, ErrorListener errorListener, Map<String, String> map) {
        super(i, str, listener, errorListener);
        this.mMap = map;
    }

    public CustomStringRequest(int i, String str, JSONObject jSONObject, Listener<String> listener, ErrorListener errorListener) {
        super(i, str, listener, errorListener);
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map hashMap = new HashMap();
        hashMap.put("Accept", "application/json");
        hashMap.put("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        return hashMap;
    }

    protected void deliverResponse(String str) {
        super.deliverResponse(str);
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return this.mMap;
    }

    protected Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new String(networkResponse.data, "utf-8"), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable e) {
            return Response.error(new ParseError(e));
        }
    }
}
