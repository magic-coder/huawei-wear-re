package com.cmb.pboc.scard;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.tsm.business.constants.Constants;
import com.cmb.pboc.context.ContextHolder;
import com.cmb.pboc.global.PbocSW;
import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.scard.callback.ScardCallback;
import com.cmb.pboc.utils.ParseUtils;
import com.snowballtech.apdu.constant.Constant;
import java.util.Map;
import java.util.NoSuchElementException;
import org.simalliance.openmobileapi.C3076f;
import org.simalliance.openmobileapi.C6649a;
import org.simalliance.openmobileapi.C6650b;
import org.simalliance.openmobileapi.C6651c;
import org.simalliance.openmobileapi.C6656g;

public class ScardOMA implements Scard, C3076f {
    public static final String f13493a = ScardOMA.class.getSimpleName();
    private C6651c f13494b;
    private int f13495c = 0;
    private C6650b f13496d;
    private C6650b[] f13497e;
    private int f13498f = 0;
    private String f13499g = Constant._ESE_TERMINAL;
    private C6656g f13500h = null;
    private C6649a f13501i = null;
    private boolean f13502j = false;
    private byte[] f13503k;
    private byte[] f13504l;
    private byte[] f13505m;
    private long f13506n = 0;
    private ScardCallback f13507o;

    private boolean m17782a() {
        if (this.f13494b == null) {
            PbocLog.m17741d(f13493a, "SEService is null");
            return false;
        } else if (this.f13494b.m29952a()) {
            if (this.f13497e == null) {
                this.f13497e = this.f13494b.m29953b();
            }
            this.f13498f = this.f13497e.length;
            if (this.f13498f <= 0) {
                PbocLog.m17741d(f13493a, "Get readers fail");
                this.f13494b.m29954c();
                return false;
            }
            if (this.f13496d == null) {
                int i = 0;
                for (C6650b c6650b : this.f13497e) {
                    i++;
                    PbocLog.m17738a(f13493a, "SE reader number: " + i + " - SE reader name: " + c6650b.m29943a());
                    if (c6650b.m29943a().indexOf(this.f13499g) != -1) {
                        this.f13496d = c6650b;
                        break;
                    }
                }
                if (this.f13496d == null) {
                    PbocLog.m17741d(f13493a, "Can't find the target reader");
                    return false;
                }
            }
            if (this.f13500h == null) {
                this.f13500h = null;
                try {
                    this.f13500h = this.f13496d.m29944b();
                } catch (Exception e) {
                    PbocLog.m17741d(f13493a, "Exception in open SE session: " + e.getMessage());
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        } else {
            PbocLog.m17741d(f13493a, "SEService isn't connected");
            return false;
        }
    }

    private byte[] m17783a(byte[] bArr) {
        String str;
        if (this.f13500h == null || this.f13500h.m29965c()) {
            PbocLog.m17741d(f13493a, "SE session isn't ready");
            return null;
        }
        byte[] c;
        try {
            if (this.f13502j) {
                PbocLog.m17738a(f13493a, "It's a select apdu command");
                if (this.f13501i != null) {
                    PbocLog.m17738a(f13493a, "Channel isn't null, now is closed and set null");
                    if (this.f13501i.m29941b()) {
                        this.f13501i = null;
                    } else {
                        this.f13501i.m29939a();
                        this.f13501i = null;
                    }
                }
                PbocLog.m17739b(f13493a, "Open logical channel with aid： " + ParseUtils.m17796a(bArr));
                this.f13501i = this.f13500h.m29963b(bArr);
                c = this.f13501i.m29942c();
                if (c == null || c.length <= 0) {
                    PbocLog.m17740c(f13493a, "Select response is null");
                    return c;
                }
                PbocLog.m17738a(f13493a, "Select response: " + ParseUtils.m17796a(c));
                return c;
            } else if (this.f13501i == null || this.f13501i.m29941b()) {
                PbocLog.m17738a(f13493a, "Open logical channel without aid");
                this.f13501i = this.f13500h.m29963b(bArr);
                c = this.f13501i.m29942c();
                if (c == null || c.length <= 0) {
                    PbocLog.m17738a(f13493a, "Select response is null");
                    return c;
                }
                PbocLog.m17738a(f13493a, "Select response: " + ParseUtils.m17796a(c));
                return c;
            } else {
                PbocLog.m17738a(f13493a, "Channel is ready");
                return null;
            }
        } catch (SecurityException e) {
            str = "Exception in prepare channel: " + e.getMessage();
            PbocLog.m17741d(f13493a, str);
            e.printStackTrace();
            return str.indexOf("Connection refused") >= 0 ? new byte[]{TagName.ResponseSingle, Constants.TagName.ACTIVITY_TOTAL} : null;
        } catch (NoSuchElementException e2) {
            str = "Exception in prepare channel: " + e2.getMessage();
            PbocLog.m17741d(f13493a, str);
            e2.printStackTrace();
            if (!this.f13502j) {
                return null;
            }
            int indexOf = str.indexOf("6a");
            int indexOf2 = str.indexOf("82");
            int indexOf3 = str.indexOf("69");
            int indexOf4 = str.indexOf("85");
            c = new byte[]{Constants.TagName.OPERATION_ID, Constants.TagName.CARD_APP_BLANCE};
            if (indexOf >= 0 && indexOf2 >= 0) {
                c[0] = Constants.TagName.PAY_ORDER_ID;
                c[1] = Constants.TagName.ACTIVITY_NAME;
            }
            if (indexOf3 < 0 || indexOf4 < 0) {
                return c;
            }
            c[0] = Constants.TagName.MAIN_ORDER_ID;
            c[1] = Constants.TagName.ACTIVITY_END;
            return c;
        } catch (IllegalStateException e3) {
            PbocLog.m17741d(f13493a, "Exception in prepare channel: " + e3.getMessage());
            e3.printStackTrace();
            return this.f13502j ? new byte[]{(byte) -88, Constants.TagName.OPERATE_TIMING} : null;
        } catch (Exception e4) {
            PbocLog.m17741d(f13493a, "Exception in prepare channel: " + e4.getMessage());
            e4.printStackTrace();
            return null;
        }
    }

    public byte[] ExchangeApdu(byte[] bArr) {
        boolean z = false;
        this.f13502j = false;
        if (bArr == null || bArr.length <= 4) {
            PbocLog.m17741d(f13493a, "APDU command is wrong");
        } else {
            if (bArr[1] == TagName.CommandMultiple && bArr[2] == (byte) 4) {
                this.f13502j = true;
                int i = bArr[4] & 255;
                this.f13503k = new byte[i];
                System.arraycopy(bArr, 5, this.f13503k, 0, i);
                PbocLog.m17738a(f13493a, "It is a select APDU command.");
                PbocLog.m17738a(f13493a, "AID: " + ParseUtils.m17796a(this.f13503k));
                PbocLog.m17738a(f13493a, "AID length: " + i);
            }
            z = true;
        }
        if (!z) {
            PbocLog.m17741d(f13493a, "APDU is wrong");
            return null;
        } else if (!m17782a()) {
            PbocLog.m17741d(f13493a, "Scard isn't ok, Please check the scard open state.");
            return null;
        } else if (this.f13502j) {
            return m17783a(this.f13503k);
        } else {
            m17783a(null);
            try {
                this.f13504l = bArr;
                PbocLog.m17738a(f13493a, "CAPDU: " + ParseUtils.m17796a(this.f13504l).substring(0, 4));
                this.f13505m = this.f13501i.m29940a(this.f13504l);
                byte[] bArr2 = this.f13505m;
                byte[] bArr3 = (bArr2 == null || bArr2.length <= 0) ? bArr2 : new byte[]{bArr2[bArr2.length - 2], bArr2[bArr2.length - 1]};
                if (bArr3 == null || bArr3.length <= 1) {
                    PbocLog.m17741d(f13493a, "RAPDU is error");
                } else if (bArr3[bArr3.length - 2] == PbocSW.f13419a[0]) {
                    PbocLog.m17739b(f13493a, "RAPDU state: " + ParseUtils.m17796a(bArr3));
                } else {
                    PbocLog.m17741d(f13493a, "RAPDU state: " + ParseUtils.m17796a(bArr3));
                }
                return this.f13505m;
            } catch (Exception e) {
                PbocLog.m17741d(f13493a, "Exception in execute apdu: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    public byte[] GetResponse(int i) {
        byte[] bArr = new byte[6];
        bArr[1] = Constants.TagName.STATION_ENAME;
        bArr[5] = (byte) (i & 255);
        bArr = ExchangeApdu(bArr);
        return bArr == null ? null : bArr;
    }

    public void closeCard() {
        PbocLog.m17738a(f13493a, "Close Card");
        if (this.f13501i != null) {
            this.f13501i.m29939a();
        }
        this.f13501i = null;
        if (this.f13500h != null) {
            this.f13500h.m29966d();
            this.f13500h.m29964b();
        }
        this.f13500h = null;
        this.f13496d = null;
        this.f13497e = null;
        this.f13498f = 0;
        if (this.f13494b != null) {
            this.f13494b.m29954c();
        }
        this.f13494b = null;
        this.f13495c = 0;
    }

    public Map getDeviceInfo() {
        return null;
    }

    public int getOpenCardState() {
        return this.f13495c;
    }

    public void init(Context context, ScardCallback scardCallback, Bundle bundle) {
        PbocLog.m17738a(f13493a, "init Scard");
        if (context != null) {
            ContextHolder.m17714a().m17715a(context);
        }
        this.f13507o = scardCallback;
    }

    public boolean isClose() {
        if (this.f13494b == null || !this.f13494b.m29952a()) {
            PbocLog.m17738a(f13493a, "Scard Closed");
            return true;
        }
        PbocLog.m17738a(f13493a, "Scard Opened");
        return false;
    }

    public void openScard() {
        PbocLog.m17738a(f13493a, "Open Card");
        this.f13506n = System.currentTimeMillis();
        this.f13495c = 0;
        this.f13495c = 1;
        if (this.f13494b != null) {
            if (this.f13494b.m29952a()) {
                PbocLog.m17738a(f13493a, "SEService is connected, Preparing scard.");
                if (m17782a()) {
                    PbocLog.m17739b(f13493a, "Scard has prepared");
                    PbocLog.m17738a(f13493a, "Open Scard takes " + (System.currentTimeMillis() - this.f13506n) + " ms");
                    if (this.f13507o != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("result", "succ");
                        this.f13507o.onResponse(bundle);
                    }
                    this.f13495c = 4;
                    return;
                }
                PbocLog.m17741d(f13493a, "Prepare scard failed");
                if (this.f13507o != null) {
                    this.f13507o.onError(new StringBuilder("Prepare scard failed"));
                    return;
                }
                return;
            }
            PbocLog.m17738a(f13493a, "SEService is disconnected. Now shutdoun.");
            this.f13494b.m29954c();
            this.f13494b = null;
        }
        PbocLog.m17738a(f13493a, "Get SEService now.");
        this.f13494b = new C6651c(ContextHolder.m17714a().m17716b(), this);
        PbocLog.m17738a(f13493a, "Waiting for SEService...");
    }

    public void serviceConnected(C6651c c6651c) {
        Log.d(f13493a, "SEService is ok ? " + c6651c.m29952a());
        if (m17782a()) {
            PbocLog.m17739b(f13493a, "Scard has prepared");
            PbocLog.m17738a(f13493a, "Open Scard takes " + (System.currentTimeMillis() - this.f13506n) + " ms");
            if (this.f13507o != null) {
                Bundle bundle = new Bundle();
                bundle.putString("result", "succ");
                this.f13507o.onResponse(bundle);
            }
            this.f13495c = 4;
            return;
        }
        PbocLog.m17741d(f13493a, "Prepare scard failed");
        if (this.f13507o != null) {
            this.f13507o.onError(new StringBuilder("Prepare scard failed"));
        }
    }
}
