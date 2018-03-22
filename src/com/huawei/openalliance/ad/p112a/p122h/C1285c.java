package com.huawei.openalliance.ad.p112a.p122h;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.utils.p119c.C1353e;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public class C1285c extends AsyncTask<Void, Void, C1213c> {
    private Context f2729a;
    private String f2730b;
    private C1212b f2731c;
    private C1250f f2732d;

    public C1285c(Context context, String str, C1212b c1212b, C1250f c1250f) {
        this.f2729a = context;
        this.f2730b = str;
        this.f2731c = c1212b;
        this.f2732d = c1250f;
    }

    protected C1213c m5672a(Void... voidArr) {
        HttpGet httpGet;
        Throwable e;
        Throwable th;
        Throwable th2;
        try {
            Class rspClass = this.f2731c.getRspClass();
            if (rspClass == null) {
                throw new InstantiationException("RspBean class not found!");
            }
            C1213c c1213c = (C1213c) rspClass.newInstance();
            try {
                httpGet = new HttpGet(this.f2730b);
                try {
                    HttpResponse a = C1353e.m5972a(this.f2729a, httpGet);
                    C1336d.m5886b("HiAdGetRequest", "responsecode is: ", String.valueOf(a.getStatusLine() == null ? 500 : a.getStatusLine().getStatusCode()));
                    c1213c.responseCode = r1;
                    if (httpGet == null) {
                        return c1213c;
                    }
                    try {
                        if (httpGet.isAborted()) {
                            return c1213c;
                        }
                        httpGet.abort();
                        return c1213c;
                    } catch (Throwable e2) {
                        C1336d.m5883a("HiAdGetRequest", "http get requester failed", e2);
                        return c1213c;
                    }
                } catch (IllegalArgumentException e3) {
                    e2 = e3;
                    try {
                        C1336d.m5883a("HiAdGetRequest", "request failed!", e2);
                        c1213c.responseCode = 1;
                        if (httpGet != null) {
                            return c1213c;
                        }
                        try {
                            if (!httpGet.isAborted()) {
                                return c1213c;
                            }
                            httpGet.abort();
                            return c1213c;
                        } catch (Throwable e22) {
                            C1336d.m5883a("HiAdGetRequest", "http get requester failed", e22);
                            return c1213c;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (httpGet != null) {
                            try {
                                if (!httpGet.isAborted()) {
                                    httpGet.abort();
                                }
                            } catch (Throwable e222) {
                                C1336d.m5883a("HiAdGetRequest", "http get requester failed", e222);
                            }
                        }
                        throw th;
                    }
                } catch (IllegalStateException e4) {
                    e222 = e4;
                    C1336d.m5883a("HiAdGetRequest", "request failed!", e222);
                    c1213c.responseCode = 1;
                    if (httpGet != null) {
                        return c1213c;
                    }
                    try {
                        if (!httpGet.isAborted()) {
                            return c1213c;
                        }
                        httpGet.abort();
                        return c1213c;
                    } catch (Throwable e2222) {
                        C1336d.m5883a("HiAdGetRequest", "http get requester failed", e2222);
                        return c1213c;
                    }
                } catch (IOException e5) {
                    e2222 = e5;
                    C1336d.m5883a("HiAdGetRequest", "request failed!", e2222);
                    c1213c.responseCode = 1;
                    if (httpGet != null) {
                        return c1213c;
                    }
                    try {
                        if (!httpGet.isAborted()) {
                            return c1213c;
                        }
                        httpGet.abort();
                        return c1213c;
                    } catch (Throwable e22222) {
                        C1336d.m5883a("HiAdGetRequest", "http get requester failed", e22222);
                        return c1213c;
                    }
                } catch (Exception e6) {
                    e22222 = e6;
                    C1336d.m5883a("HiAdGetRequest", "request failed!", e22222);
                    c1213c.responseCode = 1;
                    if (httpGet != null) {
                        return c1213c;
                    }
                    try {
                        if (!httpGet.isAborted()) {
                            return c1213c;
                        }
                        httpGet.abort();
                        return c1213c;
                    } catch (Throwable e222222) {
                        C1336d.m5883a("HiAdGetRequest", "http get requester failed", e222222);
                        return c1213c;
                    }
                }
            } catch (Throwable e7) {
                th2 = e7;
                httpGet = null;
                e222222 = th2;
                C1336d.m5883a("HiAdGetRequest", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpGet != null) {
                    return c1213c;
                }
                if (!httpGet.isAborted()) {
                    return c1213c;
                }
                httpGet.abort();
                return c1213c;
            } catch (Throwable e72) {
                th2 = e72;
                httpGet = null;
                e222222 = th2;
                C1336d.m5883a("HiAdGetRequest", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpGet != null) {
                    return c1213c;
                }
                if (!httpGet.isAborted()) {
                    return c1213c;
                }
                httpGet.abort();
                return c1213c;
            } catch (Throwable e722) {
                th2 = e722;
                httpGet = null;
                e222222 = th2;
                C1336d.m5883a("HiAdGetRequest", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpGet != null) {
                    return c1213c;
                }
                if (!httpGet.isAborted()) {
                    return c1213c;
                }
                httpGet.abort();
                return c1213c;
            } catch (Throwable e7222) {
                th2 = e7222;
                httpGet = null;
                e222222 = th2;
                C1336d.m5883a("HiAdGetRequest", "request failed!", e222222);
                c1213c.responseCode = 1;
                if (httpGet != null) {
                    return c1213c;
                }
                if (!httpGet.isAborted()) {
                    return c1213c;
                }
                httpGet.abort();
                return c1213c;
            } catch (Throwable th4) {
                th = th4;
                httpGet = null;
                if (httpGet != null) {
                    if (httpGet.isAborted()) {
                        httpGet.abort();
                    }
                }
                throw th;
            }
        } catch (InstantiationException e8) {
            C1336d.m5888c("HiAdGetRequest", "fail to create rsp object!");
            return null;
        } catch (IllegalAccessException e9) {
            C1336d.m5888c("HiAdGetRequest", "fail to create rsp object!");
            return null;
        }
    }

    protected void m5673a(C1213c c1213c) {
        this.f2732d.mo2430a(this.f2729a, this.f2731c, c1213c);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5672a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5673a((C1213c) obj);
    }
}
