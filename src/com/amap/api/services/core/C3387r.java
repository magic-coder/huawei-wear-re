package com.amap.api.services.core;

import android.content.Context;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;

/* compiled from: ProtocalHandler */
public abstract class C3387r<T, V> extends bt {
    protected T f12301a;
    protected int f12302b = 1;
    protected String f12303c = "";
    protected Context f12304d;
    private int f12305h = 1;

    protected abstract String a_();

    protected abstract V mo4102b(String str) throws AMapException;

    public C3387r(Context context, T t) {
        m16569a(context, t);
    }

    private void m16569a(Context context, T t) {
        this.f12304d = context;
        this.f12301a = t;
        this.f12302b = 1;
        m16566d(ServiceSettings.getInstance().getSoTimeOut());
        m16565c(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    protected V m16572a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Throwable e) {
            C3409d.m16881a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        C3409d.m16883b(str);
        return mo4102b(str);
    }

    public V m16577g() throws AMapException {
        if (this.f12301a != null) {
            return mo4114f();
        }
        return null;
    }

    private V mo4114f() throws AMapException {
        int i = 0;
        V v = null;
        while (i < this.f12302b) {
            try {
                byte[] a;
                int protocol = ServiceSettings.getInstance().getProtocol();
                bs a2 = bs.m16858a(false);
                m16563a(ac.m16598a(this.f12304d));
                if (protocol == 1) {
                    a = a2.m16868a((bt) this);
                } else if (protocol == 2) {
                    a = a2.m16869b(this);
                } else {
                    a = null;
                }
                v = m16570b(a);
                i = this.f12302b;
            } catch (Throwable e) {
                C3409d.m16881a(e, "ProtocalHandler", "getDataMayThrowAMapException");
                i++;
                if (i >= this.f12302b) {
                    throw new AMapException(e.getErrorMessage());
                }
            } catch (Throwable e2) {
                C3409d.m16881a(e2, "ProtocalHandler", "getDataMayThrowAMapCoreException");
                i++;
                if (i < this.f12302b) {
                    try {
                        Thread.sleep((long) (this.f12305h * 1000));
                    } catch (InterruptedException e3) {
                        C3409d.m16881a(e2, "ProtocalHandler", "getDataMayThrowInterruptedException");
                        throw new AMapException(e2.getMessage());
                    }
                }
                m16578h();
                throw new AMapException(e2.m16986a());
            } catch (Throwable th) {
                C3409d.m16881a(th, "ProtocalHandler", "getDataMayThrowAMapCoreException");
                AMapException aMapException = new AMapException("未知的错误");
            }
        }
        return v;
    }

    public HttpEntity mo4099e() {
        try {
            String a_ = a_();
            String a = mo4100a(a_);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a_);
            a_ = C3436y.m16996a();
            stringBuffer.append("&ts=" + a_);
            stringBuffer.append("&scode=" + C3436y.m17000a(this.f12304d, a_, a));
            return new StringEntity(stringBuffer.toString());
        } catch (Throwable e) {
            C3409d.m16881a(e, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    public Map<String, String> c_() {
        return null;
    }

    public Map<String, String> d_() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 2.5.0");
        hashMap.put("X-INFO", C3436y.m16999a(this.f12304d, C3418l.f12485a, null));
        hashMap.put("ia", "1");
        hashMap.put("ec", "1");
        hashMap.put(SMSKeyInfo.TAG_KEY, C3434w.m16993f(this.f12304d));
        return hashMap;
    }

    private V m16570b(byte[] bArr) throws AMapException {
        return m16572a(bArr);
    }

    protected V m16578h() {
        return null;
    }

    private String mo4100a(String str) {
        String[] split = str.split(SNBConstant.FILTER);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String d : split) {
            stringBuffer.append(m16575d(d));
            stringBuffer.append(SNBConstant.FILTER);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    protected String m16574c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable e) {
            C3409d.m16881a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return new String();
        } catch (Throwable e2) {
            C3409d.m16881a(e2, "ProtocalHandler", "strEncoderException");
            return new String();
        }
    }

    protected String m16575d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable e) {
            C3409d.m16881a(e, "ProtocalHandler", "strReEncoder");
            return new String();
        } catch (Throwable e2) {
            C3409d.m16881a(e2, "ProtocalHandler", "strReEncoderException");
            return new String();
        }
    }
}
