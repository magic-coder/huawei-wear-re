package com.huawei.openalliance.ad.p112a.p122h;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.utils.p119c.C1352d;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class C1286d extends AsyncTask<Void, Void, C1213c> {
    private Context f2733a;
    private String f2734b;
    private C1212b f2735c;
    private C1250f f2736d;

    public C1286d(Context context, String str, C1212b c1212b, C1250f c1250f) {
        this.f2733a = context;
        this.f2734b = str;
        this.f2735c = c1212b;
        this.f2736d = c1250f;
    }

    private void m5674a(C1250f c1250f) {
        if (c1250f != null) {
            c1250f.mo2429a();
        }
    }

    private void m5675b(C1250f c1250f) {
        if (c1250f != null) {
            c1250f.mo2431b();
        }
    }

    protected C1213c m5676a(Void... voidArr) {
        HttpPost httpPost;
        Throwable e;
        Throwable th;
        Throwable th2;
        m5674a(this.f2736d);
        try {
            Class rspClass = this.f2735c.getRspClass();
            if (rspClass == null) {
                throw new InstantiationException("RspBean class not found!");
            }
            C1213c c1213c = (C1213c) rspClass.newInstance();
            try {
                httpPost = new HttpPost(this.f2734b);
                try {
                    C1336d.m5886b("HiAdRequester", "request is: ", C1288g.m5690a(this.f2735c.toJson(), this.f2735c));
                    httpPost.setEntity(new StringEntity(r1, GameManager.DEFAULT_CHARSET));
                    HttpResponse a = C1352d.m5971a(this.f2733a, httpPost);
                    int statusCode = a.getStatusLine() == null ? 500 : a.getStatusLine().getStatusCode();
                    C1336d.m5886b("HiAdRequester", "response is: ", C1288g.m5690a(EntityUtils.toString(a.getEntity(), GameManager.DEFAULT_CHARSET), c1213c));
                    if (200 == statusCode) {
                        c1213c.fromJson(new JSONObject(r3));
                        c1213c.responseCode = 0;
                    } else {
                        c1213c.responseCode = 1;
                    }
                    if (httpPost != null) {
                        try {
                            if (!httpPost.isAborted()) {
                                httpPost.abort();
                            }
                        } catch (Throwable e2) {
                            C1336d.m5883a("HiAdRequester", "http request failed", e2);
                        }
                    }
                    m5675b(this.f2736d);
                    return c1213c;
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        C1336d.m5883a("HiAdRequester", "request failed!", e2);
                        c1213c.responseCode = 1;
                        if (httpPost != null) {
                            return c1213c;
                        }
                        try {
                            if (!httpPost.isAborted()) {
                                return c1213c;
                            }
                            httpPost.abort();
                            return c1213c;
                        } catch (Throwable e22) {
                            C1336d.m5883a("HiAdRequester", "http request failed", e22);
                            return c1213c;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (httpPost != null) {
                            try {
                                if (!httpPost.isAborted()) {
                                    httpPost.abort();
                                }
                            } catch (Throwable e222) {
                                C1336d.m5883a("HiAdRequester", "http request failed", e222);
                            }
                        }
                        throw th;
                    }
                } catch (ClassNotFoundException e4) {
                    e222 = e4;
                    C1336d.m5883a("HiAdRequester", "request failed!", e222);
                    c1213c.responseCode = 1;
                    if (httpPost != null) {
                        return c1213c;
                    }
                    try {
                        if (!httpPost.isAborted()) {
                            return c1213c;
                        }
                        httpPost.abort();
                        return c1213c;
                    } catch (Throwable e2222) {
                        C1336d.m5883a("HiAdRequester", "http request failed", e2222);
                        return c1213c;
                    }
                } catch (JSONException e5) {
                    e2222 = e5;
                    C1336d.m5883a("HiAdRequester", "request failed!", e2222);
                    c1213c.responseCode = 1;
                    if (httpPost != null) {
                        return c1213c;
                    }
                    try {
                        if (!httpPost.isAborted()) {
                            return c1213c;
                        }
                        httpPost.abort();
                        return c1213c;
                    } catch (Throwable e22222) {
                        C1336d.m5883a("HiAdRequester", "http request failed", e22222);
                        return c1213c;
                    }
                } catch (Exception e6) {
                    e22222 = e6;
                    C1336d.m5883a("HiAdRequester", "request failed!", e22222);
                    c1213c.responseCode = 1;
                    if (httpPost != null) {
                        return c1213c;
                    }
                    try {
                        if (!httpPost.isAborted()) {
                            return c1213c;
                        }
                        httpPost.abort();
                        return c1213c;
                    } catch (Throwable e222222) {
                        C1336d.m5883a("HiAdRequester", "http request failed", e222222);
                        return c1213c;
                    }
                }
            } catch (Throwable e7) {
                th2 = e7;
                httpPost = null;
                e222222 = th2;
                C1336d.m5883a("HiAdRequester", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpPost != null) {
                    return c1213c;
                }
                if (!httpPost.isAborted()) {
                    return c1213c;
                }
                httpPost.abort();
                return c1213c;
            } catch (Throwable e72) {
                th2 = e72;
                httpPost = null;
                e222222 = th2;
                C1336d.m5883a("HiAdRequester", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpPost != null) {
                    return c1213c;
                }
                if (!httpPost.isAborted()) {
                    return c1213c;
                }
                httpPost.abort();
                return c1213c;
            } catch (Throwable e722) {
                th2 = e722;
                httpPost = null;
                e222222 = th2;
                C1336d.m5883a("HiAdRequester", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpPost != null) {
                    return c1213c;
                }
                if (!httpPost.isAborted()) {
                    return c1213c;
                }
                httpPost.abort();
                return c1213c;
            } catch (Throwable e7222) {
                th2 = e7222;
                httpPost = null;
                e222222 = th2;
                C1336d.m5883a("HiAdRequester", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpPost != null) {
                    return c1213c;
                }
                if (!httpPost.isAborted()) {
                    return c1213c;
                }
                httpPost.abort();
                return c1213c;
            } catch (Throwable th4) {
                th = th4;
                httpPost = null;
                if (httpPost != null) {
                    if (httpPost.isAborted()) {
                        httpPost.abort();
                    }
                }
                throw th;
            }
        } catch (InstantiationException e8) {
            C1336d.m5888c("HiAdRequester", "fail to create rsp object!");
            return null;
        } catch (IllegalAccessException e9) {
            C1336d.m5888c("HiAdRequester", "fail to create rsp object!");
            return null;
        }
    }

    protected void m5677a(C1213c c1213c) {
        if (this.f2736d != null) {
            this.f2736d.mo2430a(this.f2733a, this.f2735c, c1213c);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5676a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5677a((C1213c) obj);
    }
}
