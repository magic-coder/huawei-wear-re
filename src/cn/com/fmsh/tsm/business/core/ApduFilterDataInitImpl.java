package cn.com.fmsh.tsm.business.core;

import cn.com.fmsh.script.ApduFilterDataInit;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.script.core.FilterPolicy;
import java.util.ArrayList;
import java.util.List;

public class ApduFilterDataInitImpl implements ApduFilterDataInit {
    /* synthetic */ byte[][] f9715a = null;

    public ApduFilterDataInitImpl(byte[][] bArr) {
        this.f9715a = bArr;
    }

    public List<FilterPolicy> getFilterPolicies() {
        int i = 0;
        if (this.f9715a == null) {
            return null;
        }
        List<FilterPolicy> arrayList = new ArrayList();
        FilterPolicy filterPolicy = new FilterPolicy();
        filterPolicy.setCla((byte) 0);
        filterPolicy.setIns(TagName.CommandMultiple);
        byte[][] bArr = this.f9715a;
        int length = bArr.length;
        while (i < length) {
            byte[] bArr2 = bArr[i];
            if (bArr2 != null) {
                filterPolicy.addFilterData(bArr2);
            }
            i++;
        }
        arrayList.add(filterPolicy);
        return arrayList;
    }
}
