package cn.com.fmsh.tsm.business.core;

import cn.com.fmsh.communication.core.LinkInfo;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.Level;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Configration {
    private /* synthetic */ FMLog f9761a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9762b = Configration.class.getName();
    private /* synthetic */ String f9763c;
    private /* synthetic */ String f9764d;
    private /* synthetic */ int f9765e;
    private /* synthetic */ byte[] f9766f;
    private /* synthetic */ byte[] f9767g;
    private /* synthetic */ Map<String, List<Key>> f9768h = new HashMap();
    private /* synthetic */ List<byte[]> f9769i = new ArrayList();
    private /* synthetic */ Map<String, LinkInfo> f9770j = new HashMap();
    private /* synthetic */ Map<Integer, String> f9771k = new HashMap();
    private /* synthetic */ int f9772l;
    private /* synthetic */ String f9773m;
    private /* synthetic */ byte f9774n = (byte) 0;
    private /* synthetic */ String f9775o = "";
    private /* synthetic */ String f9776p = "";
    private /* synthetic */ Level f9777q = Level.ERROR;

    public class Key {
        final /* synthetic */ Configration f9760a;
        public byte[] exponent;
        public int index = 0;
        public byte[] modulus;

        public Key(Configration configration) {
            this.f9760a = configration;
        }
    }

    public void addAid(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            this.f9769i.add(bArr);
        }
    }

    public void addBusinessAndServer(int i, String str) {
        if (str != null) {
            this.f9771k.put(Integer.valueOf(i), str);
        }
    }

    public void addKey(String str, int i, byte[] bArr, byte[] bArr2) {
        if (str != null && bArr != null && bArr2 != null && i != -1) {
            Key key = new Key(this);
            key.index = i;
            key.exponent = bArr;
            key.modulus = bArr2;
            List list = (List) this.f9768h.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f9768h.put(str, list);
            }
            list.add(key);
        } else if (this.f9761a != null) {
            this.f9761a.warn(this.f9762b, CRCUtil.substring(FitnessSleepType.HW_FITNESS_DREAM, "勹轹酂罴斂仦丶宀铴侽怨斤ｑ徍劳轣皍寒钺侫怺斠攃"));
        }
    }

    public void addServers(String str, int i, int i2, String str2) {
        if (str != null && str.length() > 0 && i > 0 && str2 != null && str2.length() > 0) {
            LinkInfo linkInfo = new LinkInfo();
            linkInfo.setAddress(str);
            linkInfo.setPort(i);
            linkInfo.setTimeout(i2);
            this.f9770j.put(str2, linkInfo);
        }
    }

    public byte[][] getAids() {
        return (byte[][]) this.f9769i.toArray((byte[][]) Array.newInstance(Byte.TYPE, new int[]{1, 1}));
    }

    public String getBusinessVersion() {
        return this.f9763c;
    }

    public String getCompanyCode() {
        return this.f9775o;
    }

    public String[] getKeies4Server() {
        return (String[]) this.f9770j.keySet().toArray(new String[0]);
    }

    public Key[] getKeys(String str) {
        List list = (List) this.f9768h.get(str);
        if (list != null) {
            return (Key[]) list.toArray(new Key[0]);
        }
        if (this.f9761a != null) {
            this.f9761a.warn(this.f9762b, new StringBuilder(FM_Bytes.concat("鄔罡斂仭泰李\u0006", 2, 22)).append(str).append(FM_CN.equals("\b宿廃盌rob", 2)).toString());
        }
        return null;
    }

    public LinkInfo getLinkInfo(String str) {
        return (LinkInfo) this.f9770j.get(str);
    }

    public Level getLogLevel() {
        return this.f9777q;
    }

    public byte getOrderSource() {
        return this.f9774n;
    }

    public String getSdkVersion() {
        return this.f9776p;
    }

    public String getServer4Business(int i) {
        return (String) this.f9771k.get(Integer.valueOf(i));
    }

    public String getServerDomain() {
        return this.f9764d;
    }

    public int getServerPort() {
        return this.f9765e;
    }

    public int getSocketTimeout() {
        return this.f9772l;
    }

    public byte[] getTerminalNumber() {
        return this.f9767g;
    }

    public byte[] getTerminalType() {
        return this.f9766f;
    }

    public String getUserCode() {
        return this.f9773m;
    }

    public void setBusinessVersion(String str) {
        this.f9763c = str;
    }

    public void setCompanyCode(String str) {
        this.f9775o = str;
    }

    public void setLogLevel(Level level) {
        this.f9777q = level;
    }

    public void setOrderSource(byte b) {
        this.f9774n = b;
    }

    public void setSdkVersion(String str) {
        this.f9776p = str;
    }

    public void setServerDomain(String str) {
        this.f9764d = str;
    }

    public void setServerPort(int i) {
        this.f9765e = i;
    }

    public void setSocketTimeout(int i) {
        this.f9772l = i;
    }

    public void setTerminalNumber(byte[] bArr) {
        this.f9767g = bArr;
    }

    public void setTerminalType(byte[] bArr) {
        this.f9766f = bArr;
    }

    public void setUserCode(String str) {
        this.f9773m = str;
    }
}
