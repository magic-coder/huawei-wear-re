package cn.com.fmsh.script.bean;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ApduRequest {
    private /* synthetic */ FMLog f9494a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9495b = CRCUtil.substring(2, "NjaeI# )\"!)");
    private final /* synthetic */ int f9496c = 2;
    private final /* synthetic */ int f9497d = 1;
    private /* synthetic */ byte f9498e;
    private /* synthetic */ int f9499f;
    private /* synthetic */ byte[] f9500g;
    private /* synthetic */ Map<Integer, Integer> f9501h = new HashMap();

    public boolean addExpectationAndNext(byte[] bArr) {
        if (bArr == null) {
            this.f9494a.warn(FM_Exception.insert(3, 47, "Ff!a\u00117p%:})"), BCCUtil.getChars("\u0014\u000eCE诮汀朔朏迉嚘纜柄a乄乘乜杤按仳标诏墌劻斲ａ计氝杗杊辎囝统枉两穽＜莮厔奺赱", 5, 9));
            return false;
        } else if (bArr.length != 3) {
            this.f9494a.warn(BCCUtil.getChars("\u0013|b5\b1}'/\"", 2, 26), FM_Utils.regionMatches(3, 38, "\u0012I[\u0010诼汓杈杆迗嚗纜枉;乏丌不朲捞任桂讍墏劷斫／丂乏朴挜亥乊吅泆"));
            return false;
        } else {
            this.f9501h.put(Integer.valueOf(FM_Bytes.bytesToInt(Arrays.copyOf(bArr, 2))), Integer.valueOf(FM_Bytes.bytesToInt(Arrays.copyOfRange(bArr, 2, 3))));
            return true;
        }
    }

    public int compareTo(Object obj) {
        ApduRequest apduRequest = (ApduRequest) obj;
        return this.f9499f > apduRequest.getId() ? 1 : this.f9499f < apduRequest.getId() ? -1 : 0;
    }

    public void fromBytes(byte[] bArr) throws FMScriptHandleException, IOException {
        if (bArr != null) {
        }
    }

    public byte[] getApdu() {
        return this.f9500g;
    }

    public int getExpectationCount() {
        return this.f9501h.size();
    }

    public int getId() {
        return this.f9499f;
    }

    public int getNext4Expectation(byte[] bArr) {
        if (bArr == null) {
            this.f9494a.warn(FM_Int.replace(3, "\u0019+:tVb{xu`b"), FM_Long.copyValueOf("桥挷\u0017\u0003\u0014\u0018讽氅杛杚迊囅绋枉莥叙万三持仧的栚诜旡８详汌朔朓近囜續柀乣稬｟菧厛奻赢", 212));
            return -1;
        }
        Integer num = (Integer) this.f9501h.get(Integer.valueOf(FM_Bytes.bytesToInt(bArr)));
        return num == null ? -1 : num.intValue();
    }

    public byte getTag() {
        return this.f9498e;
    }

    public boolean isHaveExpectation() {
        return !this.f9501h.isEmpty();
    }

    public void setApdu(byte[] bArr) {
        this.f9500g = bArr;
    }

    public void setId(int i) {
        this.f9499f = i;
    }

    public void setTag(byte b) {
        this.f9498e = b;
    }

    public byte[] toBytes() {
        return null;
    }
}
