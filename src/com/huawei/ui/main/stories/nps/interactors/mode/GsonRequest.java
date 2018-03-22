package com.huawei.ui.main.stories.nps.interactors.mode;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class GsonRequest<T> extends Request<T> {
    private final Class<T> mClazz;
    private final Gson mGson;
    private final Map<String, String> mHeaders;
    private final JSONObject mJsonObject;
    private final Listener<T> mListener;

    public GsonRequest(String str, JSONObject jSONObject, Class<T> cls, Listener<T> listener, ErrorListener errorListener) {
        this(1, str, jSONObject, cls, null, listener, errorListener);
    }

    public GsonRequest(int i, String str, JSONObject jSONObject, Class<T> cls, Map<String, String> map, Listener<T> listener, ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mGson = new Gson();
        this.mJsonObject = jSONObject;
        this.mClazz = cls;
        this.mHeaders = map;
        this.mListener = listener;
    }

    public byte[] getBody() throws AuthFailureError {
        byte[] bArr = null;
        try {
            bArr = this.mJsonObject.toString().getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
        }
        return bArr;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map hashMap = new HashMap();
        hashMap.put("Accept", "application/json");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        return hashMap;
    }

    protected void deliverResponse(T t) {
        this.mListener.onResponse(t);
    }

    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(this.mGson.fromJson(new String(networkResponse.data, "utf-8"), this.mClazz), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable e) {
            return Response.error(new ParseError(e));
        }
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return super.getParams();
    }
}
