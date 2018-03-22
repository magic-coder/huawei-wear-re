package cn.com.fmsh.script.core;

import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApduFilter {
    private /* synthetic */ List<FilterPolicy> f9509a = new ArrayList();

    public void addFilterPolicy(FilterPolicy filterPolicy) {
        this.f9509a.add(filterPolicy);
    }

    public byte[] filter(byte[] bArr) {
        FMLog log = LogFactory.getInstance().getLog();
        if (bArr == null || bArr.length < 5) {
            if (log != null) {
                log.warn(ApduFilter.class.getName(), FM_CN.equals("讠氊辞溮旭＀诪汌支挾乌呚沖", 4));
            }
            return null;
        } else if (this.f9509a.size() < 1) {
            return null;
        } else {
            for (FilterPolicy filterPolicy : this.f9509a) {
                if (filterPolicy != null && filterPolicy.getCla() == bArr[0] && filterPolicy.getIns() == bArr[1]) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                    byte[][] filterDatas = filterPolicy.getFilterDatas();
                    int length = filterDatas.length;
                    int i = 0;
                    while (i < length) {
                        byte[] bArr2 = filterDatas[i];
                        if (!Arrays.equals(bArr2, copyOfRange)) {
                            i++;
                        } else if (log == null) {
                            return bArr2;
                        } else {
                            log.debug(ApduFilter.class.getName(), new StringBuilder(Util4Java.endsWith("m+1#菱厉盜\u0010\u0003\u0007＆", 5, 121)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
                            return bArr2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
    }
}
