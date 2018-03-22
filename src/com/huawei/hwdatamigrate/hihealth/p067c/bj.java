package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiAggregateOption;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.p396c.C4556c;
import com.huawei.hihealth.data.p396c.C4557d;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4831v;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4837b;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4839d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.helpers.UtilLoggingLevel;

/* compiled from: RawQueryManager */
public class bj {
    private static Context f17843b;
    private C4831v f17844a;

    private bj() {
        this.f17844a = C4831v.m23292a(f17843b);
    }

    public static bj m23507a(@NonNull Context context) {
        f17843b = context.getApplicationContext();
        return bl.f17846a;
    }

    public List<HiHealthData> m23513a(int i, HiDataReadOption hiDataReadOption, int i2) {
        String[] strArr = new String[(hiDataReadOption.getType().length + 3)];
        strArr[0] = Integer.toString(0);
        strArr[1] = Integer.toString(i);
        strArr[2] = Integer.toString(i);
        return C4841f.m23355a(this.f17844a.mo4567a(C4843h.m23386a(hiDataReadOption.getType(), hiDataReadOption.getConstantsKey(), i2, strArr, 3), strArr), hiDataReadOption.getConstantsKey());
    }

    public List<HiHealthData> m23516a(List<Integer> list, HiAggregateOption hiAggregateOption) {
        String[] strArr;
        String a;
        int size = list.size();
        int alignType = hiAggregateOption.getAlignType();
        switch (alignType) {
            case 20001:
                strArr = new String[((size * 2) + 6)];
                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                strArr[2] = Integer.toString(20001);
                strArr[3] = Integer.toString(UtilLoggingLevel.WARNING_INT);
                strArr[4] = Integer.toString(0);
                strArr[5] = Integer.toString(0);
                a = C4843h.m23385a((List) list, strArr, 6, hiAggregateOption, true);
                break;
            default:
                strArr = new String[((size * 2) + 5)];
                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                strArr[2] = Integer.toString(alignType);
                strArr[3] = Integer.toString(0);
                strArr[4] = Integer.toString(0);
                a = C4843h.m23385a((List) list, strArr, 5, hiAggregateOption, true);
                break;
        }
        return C4841f.m23364d(this.f17844a.mo4567a(a, strArr), hiAggregateOption.getConstantsKey());
    }

    public List<HiHealthData> m23518b(List<Integer> list, HiAggregateOption hiAggregateOption) {
        int size = list.size();
        int[] type = hiAggregateOption.getType();
        int i = type[0];
        C4557d b = C4556c.m21809b(i);
        String[] constantsKey = hiAggregateOption.getConstantsKey();
        String[] strArr;
        switch (bk.f17845a[b.ordinal()]) {
            case 1:
                if (i <= UtilLoggingLevel.WARNING_INT) {
                    return m23508a((List) list, hiAggregateOption, true);
                }
                if (i <= 22099) {
                    return m23509b(list, hiAggregateOption, true);
                }
                return m23510c(list, hiAggregateOption, true);
            case 2:
                strArr = new String[((type.length + size) + 3)];
                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                strArr[2] = Integer.toString(0);
                if (i < 2000) {
                    return C4841f.m23358b(this.f17844a.mo4567a(C4843h.m23408c((List) list, strArr, 3, hiAggregateOption, true), strArr), constantsKey);
                }
                return C4841f.m23361c(this.f17844a.mo4567a(C4843h.m23411d(list, strArr, 3, hiAggregateOption, true), strArr), constantsKey);
            case 3:
                strArr = new String[(size + 4)];
                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                strArr[2] = Long.toString((long) type[0]);
                strArr[3] = Integer.toString(0);
                return C4842g.m23371a(this.f17844a.mo4567a(C4843h.m23402b((List) list, strArr, 4, hiAggregateOption, true), strArr), constantsKey);
            default:
                return null;
        }
    }

    public List<HiHealthData> m23515a(List<Integer> list, long j, long j2, int i, int i2, String[] strArr, int[] iArr, int i3) {
        Object obj = new String[(list.size() + 4)];
        obj[0] = Long.toString(j);
        obj[1] = Long.toString(j2);
        obj[2] = Integer.toString(i2);
        obj[3] = Integer.toString(0);
        C2538c.b("Debug_RawQueryManager", new Object[]{"queryMergeAggregateHealthPointDataNoAlignTypeEX() aggregateSQL = ", C4843h.m23383a(list, obj, 4, i, i2, strArr, iArr, i3), ",selectAgs = ", C4543e.m21779a(obj)});
        return C4841f.m23361c(this.f17844a.mo4567a(C4843h.m23383a(list, obj, 4, i, i2, strArr, iArr, i3), (String[]) obj), strArr);
    }

    private List<HiHealthData> m23508a(List<Integer> list, HiAggregateOption hiAggregateOption, boolean z) {
        List<HiHealthData> arrayList = new ArrayList();
        int[] type = hiAggregateOption.getType();
        String[] constantsKey = hiAggregateOption.getConstantsKey();
        int size = list.size();
        for (int i = 0; i < type.length; i++) {
            String[] strArr;
            String a;
            Collection d;
            int i2 = type[i];
            String str = constantsKey[i];
            switch (i2) {
                case 20001:
                    if (!z) {
                        strArr = new String[(size + 4)];
                        strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                        strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                        strArr[2] = Integer.toString(20001);
                        strArr[3] = Integer.toString(UtilLoggingLevel.WARNING_INT);
                        a = C4843h.m23384a((List) list, strArr, 4, hiAggregateOption, i2, str, false);
                        break;
                    }
                    strArr = new String[(size + 5)];
                    strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                    strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                    strArr[2] = Integer.toString(20001);
                    strArr[3] = Integer.toString(UtilLoggingLevel.WARNING_INT);
                    strArr[4] = Integer.toString(0);
                    a = C4843h.m23384a((List) list, strArr, 5, hiAggregateOption, i2, str, true);
                    break;
                default:
                    if (!z) {
                        switch (hiAggregateOption.getAggregateType()) {
                            case 6:
                                strArr = new String[(list.size() + 7)];
                                strArr[0] = Integer.toString(i2);
                                strArr[1] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[2] = Long.toString(hiAggregateOption.getEndTime());
                                strArr[3] = Integer.toString(i2);
                                strArr[4] = Integer.toString(i2);
                                strArr[5] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[6] = Long.toString(hiAggregateOption.getEndTime());
                                a = C4843h.m23382a(str, (List) list, strArr, 7, false);
                                break;
                            default:
                                strArr = new String[(size + 3)];
                                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                                strArr[2] = Integer.toString(i2);
                                a = C4843h.m23384a((List) list, strArr, 3, hiAggregateOption, i2, str, false);
                                break;
                        }
                    }
                    switch (hiAggregateOption.getAggregateType()) {
                        case 6:
                            strArr = new String[(list.size() + 9)];
                            strArr[0] = Integer.toString(i2);
                            strArr[1] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[2] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[3] = Integer.toString(0);
                            strArr[4] = Integer.toString(i2);
                            strArr[5] = Integer.toString(i2);
                            strArr[6] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[7] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[8] = Integer.toString(0);
                            a = C4843h.m23382a(str, (List) list, strArr, 9, true);
                            break;
                        default:
                            strArr = new String[(size + 4)];
                            strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[2] = Integer.toString(i2);
                            strArr[3] = Integer.toString(0);
                            a = C4843h.m23384a((List) list, strArr, 4, hiAggregateOption, i2, str, true);
                            break;
                    }
            }
            Cursor a2 = this.f17844a.mo4567a(a, strArr);
            switch (hiAggregateOption.getAggregateType()) {
                case 6:
                    d = C4841f.m23363d(a2, str);
                    break;
                default:
                    d = C4841f.m23357b(a2, str);
                    break;
            }
            if (!(d == null || d.isEmpty())) {
                arrayList.addAll(d);
            }
        }
        return arrayList;
    }

    private List<HiHealthData> m23509b(List<Integer> list, HiAggregateOption hiAggregateOption, boolean z) {
        List<HiHealthData> arrayList = new ArrayList();
        int[] type = hiAggregateOption.getType();
        String[] constantsKey = hiAggregateOption.getConstantsKey();
        int size = list.size();
        for (int i = 0; i < type.length; i++) {
            String[] strArr;
            String b;
            Collection d;
            int i2 = type[i];
            String str = constantsKey[i];
            switch (i2) {
                case UtilLoggingLevel.SEVERE_INT /*22000*/:
                    if (!z) {
                        strArr = new String[(size + 4)];
                        strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                        strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                        strArr[2] = Integer.toString(UtilLoggingLevel.SEVERE_INT);
                        strArr[3] = Integer.toString(22099);
                        b = C4843h.m23401b(list, strArr, 4, hiAggregateOption, i2, str, false);
                        break;
                    }
                    strArr = new String[(size + 5)];
                    strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                    strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                    strArr[2] = Integer.toString(UtilLoggingLevel.SEVERE_INT);
                    strArr[3] = Integer.toString(22099);
                    strArr[4] = Integer.toString(0);
                    b = C4843h.m23401b(list, strArr, 5, hiAggregateOption, i2, str, true);
                    break;
                default:
                    if (!z) {
                        switch (hiAggregateOption.getAggregateType()) {
                            case 6:
                                strArr = new String[(list.size() + 7)];
                                strArr[0] = Integer.toString(i2);
                                strArr[1] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[2] = Long.toString(hiAggregateOption.getEndTime());
                                strArr[3] = Integer.toString(i2);
                                strArr[4] = Integer.toString(i2);
                                strArr[5] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[6] = Long.toString(hiAggregateOption.getEndTime());
                                b = C4843h.m23400b(str, (List) list, strArr, 7, false);
                                break;
                            default:
                                strArr = new String[(size + 3)];
                                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                                strArr[2] = Integer.toString(i2);
                                b = C4843h.m23401b(list, strArr, 3, hiAggregateOption, i2, str, false);
                                break;
                        }
                    }
                    switch (hiAggregateOption.getAggregateType()) {
                        case 6:
                            strArr = new String[(list.size() + 9)];
                            strArr[1] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[2] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[3] = Integer.toString(0);
                            strArr[4] = Integer.toString(i2);
                            strArr[5] = Integer.toString(i2);
                            strArr[6] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[7] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[8] = Integer.toString(0);
                            strArr[0] = Integer.toString(i2);
                            b = C4843h.m23400b(str, (List) list, strArr, 9, true);
                            break;
                        default:
                            strArr = new String[(size + 4)];
                            strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[2] = Integer.toString(i2);
                            strArr[3] = Integer.toString(0);
                            b = C4843h.m23401b(list, strArr, 4, hiAggregateOption, i2, str, true);
                            break;
                    }
            }
            Cursor a = this.f17844a.mo4567a(b, strArr);
            switch (hiAggregateOption.getAggregateType()) {
                case 6:
                    d = C4841f.m23363d(a, str);
                    break;
                default:
                    d = C4841f.m23360c(a, str);
                    break;
            }
            if (!(d == null || d.isEmpty())) {
                arrayList.addAll(d);
            }
        }
        return arrayList;
    }

    private List<HiHealthData> m23510c(List<Integer> list, HiAggregateOption hiAggregateOption, boolean z) {
        List<HiHealthData> arrayList = new ArrayList();
        int[] type = hiAggregateOption.getType();
        String[] constantsKey = hiAggregateOption.getConstantsKey();
        int size = list.size();
        for (int i = 0; i < type.length; i++) {
            String[] strArr;
            String c;
            Collection d;
            int i2 = type[i];
            String str = constantsKey[i];
            switch (i2) {
                case 22100:
                    if (!z) {
                        strArr = new String[(size + 4)];
                        strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                        strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                        strArr[2] = Integer.toString(22100);
                        strArr[3] = Integer.toString(22199);
                        c = C4843h.m23407c(list, strArr, 4, hiAggregateOption, i2, str, false);
                        break;
                    }
                    strArr = new String[(size + 5)];
                    strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                    strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                    strArr[2] = Integer.toString(22100);
                    strArr[3] = Integer.toString(22199);
                    strArr[4] = Integer.toString(0);
                    c = C4843h.m23407c(list, strArr, 5, hiAggregateOption, i2, str, true);
                    break;
                default:
                    if (!z) {
                        switch (hiAggregateOption.getAggregateType()) {
                            case 6:
                                strArr = new String[(list.size() + 7)];
                                strArr[6] = Long.toString(hiAggregateOption.getEndTime());
                                strArr[5] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[4] = Integer.toString(i2);
                                strArr[3] = Integer.toString(i2);
                                strArr[2] = Long.toString(hiAggregateOption.getEndTime());
                                strArr[1] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[0] = Integer.toString(i2);
                                c = C4843h.m23406c(str, (List) list, strArr, 7, false);
                                break;
                            default:
                                strArr = new String[(size + 3)];
                                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                                strArr[2] = Integer.toString(i2);
                                c = C4843h.m23407c(list, strArr, 3, hiAggregateOption, i2, str, false);
                                break;
                        }
                    }
                    switch (hiAggregateOption.getAggregateType()) {
                        case 6:
                            strArr = new String[(list.size() + 9)];
                            strArr[0] = Integer.toString(i2);
                            strArr[1] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[2] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[3] = Integer.toString(0);
                            strArr[4] = Integer.toString(i2);
                            strArr[5] = Integer.toString(i2);
                            strArr[6] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[7] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[8] = Integer.toString(0);
                            c = C4843h.m23406c(str, (List) list, strArr, 9, true);
                            break;
                        default:
                            strArr = new String[(size + 4)];
                            strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                            strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                            strArr[2] = Integer.toString(i2);
                            strArr[3] = Integer.toString(0);
                            c = C4843h.m23407c(list, strArr, 4, hiAggregateOption, i2, str, true);
                            break;
                    }
            }
            Cursor a = this.f17844a.mo4567a(c, strArr);
            switch (hiAggregateOption.getAggregateType()) {
                case 6:
                    d = C4841f.m23363d(a, str);
                    break;
                default:
                    d = C4841f.m23360c(a, str);
                    break;
            }
            if (!(d == null || d.isEmpty())) {
                arrayList.addAll(d);
            }
        }
        return arrayList;
    }

    public List<HiHealthData> m23520c(List<Integer> list, HiAggregateOption hiAggregateOption) {
        int size = list.size();
        int[] type = hiAggregateOption.getType();
        int i = type[0];
        String[] strArr;
        switch (bk.f17845a[C4556c.m21809b(i).ordinal()]) {
            case 1:
                if (i <= UtilLoggingLevel.WARNING_INT) {
                    return m23508a((List) list, hiAggregateOption, false);
                }
                if (i <= 22099) {
                    return m23509b(list, hiAggregateOption, false);
                }
                return m23510c(list, hiAggregateOption, false);
            case 2:
                strArr = new String[((type.length + size) + 2)];
                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                if (i < 2000) {
                    return C4841f.m23364d(this.f17844a.mo4567a(C4843h.m23408c((List) list, strArr, 2, hiAggregateOption, false), strArr), hiAggregateOption.getConstantsKey());
                }
                return C4841f.m23367e(this.f17844a.mo4567a(C4843h.m23411d(list, strArr, 2, hiAggregateOption, false), strArr), hiAggregateOption.getConstantsKey());
            case 3:
                strArr = new String[(size + 3)];
                strArr[0] = Long.toString(hiAggregateOption.getStartTime());
                strArr[1] = Long.toString(hiAggregateOption.getEndTime());
                strArr[2] = Long.toString((long) type[0]);
                return C4842g.m23371a(this.f17844a.mo4567a(C4843h.m23402b((List) list, strArr, 3, hiAggregateOption, false), strArr), hiAggregateOption.getConstantsKey());
            default:
                return null;
        }
    }

    public List<HiHealthData> m23512a(int i, int i2, int[] iArr, String[] strArr, List<Integer> list, int i3) {
        String[] strArr2 = new String[((iArr.length + 1) + list.size())];
        strArr2[0] = Integer.toString(i);
        return C4839d.m23338a(this.f17844a.mo4567a(C4843h.m23379a(i2, iArr, strArr, (List) list, strArr2, i3, 1), strArr2), strArr);
    }

    public List<HiHealthData> m23511a(int i, int i2, int[] iArr, String[] strArr, int i3) {
        String[] strArr2 = new String[(iArr.length + 2)];
        strArr2[0] = Integer.toString(i);
        strArr2[1] = Integer.toString(0);
        return C4837b.m23327a(this.f17844a.mo4567a(C4843h.m23380a(i2, iArr, strArr, strArr2, i3, 2), strArr2), strArr);
    }

    public List<Integer> m23514a(long j, long j2, int i, List<Integer> list) {
        String[] strArr = new String[(list.size() + 3)];
        strArr[0] = Long.toString(j);
        strArr[1] = Long.toString(j2);
        strArr[2] = Integer.toString(i);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select distinct(client_id) from sample_point where ").append("start_time").append(" >=? and ").append("start_time").append(" <=? and ").append("type_id").append(" =? ");
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, list.size(), stringBuffer, strArr, 3);
        return C4841f.m23366e(this.f17844a.mo4567a(stringBuffer.toString(), strArr), WBConstants.AUTH_PARAMS_CLIENT_ID);
    }

    public List<Integer> m23517a(List<Integer> list, String str) {
        String[] strArr = new String[(list.size() + 1)];
        strArr[0] = Integer.toString(0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ").append("distinct(").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(")").append(" from ").append(str).append(" where ").append("sync_status").append(" =? ");
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, list.size(), stringBuffer, strArr, 1);
        return C4841f.m23366e(this.f17844a.mo4567a(stringBuffer.toString(), strArr), WBConstants.AUTH_PARAMS_CLIENT_ID);
    }

    public List<Integer> m23519b(List<Integer> list, String str) {
        String[] strArr = new String[list.size()];
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ").append("distinct(").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(")").append(" from ").append(str).append(" where ");
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, list.size(), stringBuffer, strArr, 0);
        return C4841f.m23366e(this.f17844a.mo4567a(stringBuffer.toString(), strArr), WBConstants.AUTH_PARAMS_CLIENT_ID);
    }
}
