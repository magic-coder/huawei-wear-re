package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import com.huawei.hihealth.HiAggregateOption;
import com.huawei.hihealth.p394c.C4540b;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;
import org.apache.log4j.helpers.UtilLoggingLevel;

/* compiled from: SqlUtil */
public class C4843h {
    public static String m23386a(int[] iArr, String[] strArr, int i, String[] strArr2, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_session").append(".").append("_id").append(",");
        stringBuffer.append("sample_session").append(".").append("start_time").append(",");
        stringBuffer.append("sample_session").append(".").append("end_time").append(",");
        stringBuffer.append("sample_session").append(".").append("type_id").append(",");
        stringBuffer.append("sample_session").append(".").append("metadata").append(",");
        stringBuffer.append("sample_session").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(",");
        stringBuffer.append("sample_session").append(".").append("timezone").append(",");
        stringBuffer.append("sample_session").append(".").append("modified_time").append(",");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            C4843h.m23403b(stringBuffer, "sample_point", "type_id", "value", iArr[i3], strArr[i3]);
            if (i3 < length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ").append("sample_session").append(" INNER JOIN ").append("sample_point").append(" ON ").append("sample_session").append(".").append("start_time").append(" = ").append("sample_point").append(".").append("start_time").append(" and ").append("sample_session").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" = ").append("sample_point").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID);
        stringBuffer.append(" where ").append("sample_session").append(".").append("sync_status").append(" =? and ").append("sample_session").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sample_point").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        C4843h.m23388a("sample_point.type_id", iArr, iArr.length, stringBuffer, strArr2, i2);
        C4843h.m23391a(stringBuffer, "sample_session", "start_time");
        stringBuffer.append(" ORDER BY ").append("sample_session").append(".").append("start_time").append(" DESC ");
        stringBuffer.append(" limit ").append("0,").append(i);
        return stringBuffer.toString();
    }

    public static String m23385a(List<Integer> list, String[] strArr, int i, HiAggregateOption hiAggregateOption, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_session").append(".").append("start_time").append(",");
        stringBuffer.append("sample_session").append(".").append("end_time").append(",");
        stringBuffer.append("sample_session").append(".").append("type_id").append(",");
        int groupUnitType = hiAggregateOption.getGroupUnitType();
        stringBuffer.append(C4843h.m23397b(groupUnitType, hiAggregateOption.getGroupUnitSize()));
        int[] type = hiAggregateOption.getType();
        String[] constantsKey = hiAggregateOption.getConstantsKey();
        int length = type.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(C4843h.m23404c(hiAggregateOption.getAggregateType(), type[i2], constantsKey[i2]));
            if (i2 < length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ").append("sample_session").append(" INNER JOIN ").append("sample_point").append(" ON ").append("sample_session").append(".").append("start_time").append(" = ").append("sample_point").append(".").append("start_time");
        if (!z) {
            stringBuffer.append(" and ").append("sample_session").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" = ").append("sample_point").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID);
        }
        stringBuffer.append(" where ").append("sample_session").append(".").append("start_time").append(" >=? and ").append("sample_session").append(".").append("start_time").append(" <=? and ");
        switch (hiAggregateOption.getAlignType()) {
            case 20001:
                stringBuffer.append("sample_session").append(".").append("type_id").append(" >=? and ").append("sample_session").append(".").append("type_id").append(" <=? ");
                break;
            default:
                stringBuffer.append("sample_session").append(".").append("type_id").append(" =? ");
                break;
        }
        if (z) {
            stringBuffer.append(" and ").append("sample_session").append(".").append("merged").append(" =? and ").append("sample_point").append(".").append("merged").append(" =? ");
        }
        int size = list.size();
        C4843h.m23387a("sample_session.client_id", (List) list, size, stringBuffer, strArr, i);
        C4843h.m23387a("sample_point.client_id", (List) list, size, stringBuffer, strArr, size + i);
        if (groupUnitType != 0) {
            C4843h.m23390a(stringBuffer, "unit_index");
        } else {
            C4843h.m23391a(stringBuffer, "sample_session", "start_time");
        }
        C4843h.m23392a(stringBuffer, "sample_session", "start_time", hiAggregateOption.getSortOrder());
        C4843h.m23389a(stringBuffer, hiAggregateOption.getAnchor(), hiAggregateOption.getCount());
        return stringBuffer.toString();
    }

    public static String m23384a(List<Integer> list, String[] strArr, int i, HiAggregateOption hiAggregateOption, int i2, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_session").append(".").append("start_time").append(",");
        stringBuffer.append("sample_session").append(".").append("end_time").append(",");
        stringBuffer.append("sample_session").append(".").append("type_id").append(",");
        stringBuffer.append(C4843h.m23378a(hiAggregateOption.getAggregateType(), str));
        stringBuffer.append(" from ").append("sample_session");
        stringBuffer.append(" where ").append("sample_session").append(".").append("start_time").append(" >=? and ").append("sample_session").append(".").append("start_time").append(" <=? and ");
        switch (i2) {
            case 20001:
            case UtilLoggingLevel.SEVERE_INT /*22000*/:
                stringBuffer.append("sample_session").append(".").append("type_id").append(" >=? and ").append("sample_session").append(".").append("type_id").append(" <=? ");
                break;
            default:
                stringBuffer.append("sample_session").append(".").append("type_id").append(" =? ");
                break;
        }
        if (z) {
            stringBuffer.append(" and ").append("sample_session").append(".").append("merged").append(" =? ");
        }
        C4843h.m23387a("sample_session.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        C4843h.m23391a(stringBuffer, "sample_session", "type_id");
        C4843h.m23392a(stringBuffer, "sample_session", "start_time", hiAggregateOption.getSortOrder());
        C4843h.m23389a(stringBuffer, hiAggregateOption.getAnchor(), hiAggregateOption.getCount());
        return stringBuffer.toString();
    }

    public static String m23401b(List<Integer> list, String[] strArr, int i, HiAggregateOption hiAggregateOption, int i2, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_session_health").append(".").append("start_time").append(",");
        stringBuffer.append("sample_session_health").append(".").append("end_time").append(",");
        stringBuffer.append("sample_session_health").append(".").append("type_id").append(",");
        stringBuffer.append(C4843h.m23399b(hiAggregateOption.getAggregateType(), str));
        stringBuffer.append(" from ").append("sample_session_health");
        stringBuffer.append(" where ").append("sample_session_health").append(".").append("start_time").append(" >=? and ").append("sample_session_health").append(".").append("start_time").append(" <=? and ");
        switch (i2) {
            case 20001:
            case UtilLoggingLevel.SEVERE_INT /*22000*/:
                stringBuffer.append("sample_session_health").append(".").append("type_id").append(" >=? and ").append("sample_session_health").append(".").append("type_id").append(" <=? ");
                break;
            default:
                stringBuffer.append("sample_session_health").append(".").append("type_id").append(" =? ");
                break;
        }
        if (z) {
            stringBuffer.append(" and ").append("sample_session_health").append(".").append("merged").append(" =? ");
        }
        C4843h.m23387a("sample_session_health.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        C4843h.m23391a(stringBuffer, "sample_session_health", "type_id");
        C4843h.m23392a(stringBuffer, "sample_session_health", "start_time", hiAggregateOption.getSortOrder());
        C4843h.m23389a(stringBuffer, hiAggregateOption.getAnchor(), hiAggregateOption.getCount());
        return stringBuffer.toString();
    }

    public static String m23407c(List<Integer> list, String[] strArr, int i, HiAggregateOption hiAggregateOption, int i2, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_session_core").append(".").append("start_time").append(",");
        stringBuffer.append("sample_session_core").append(".").append("end_time").append(",");
        stringBuffer.append("sample_session_core").append(".").append("type_id").append(",");
        stringBuffer.append(C4843h.m23405c(hiAggregateOption.getAggregateType(), str));
        stringBuffer.append(" from ").append("sample_session_core");
        stringBuffer.append(" where ").append("sample_session_core").append(".").append("start_time").append(" >=? and ").append("sample_session_core").append(".").append("start_time").append(" <=? and ");
        switch (i2) {
            case 20001:
            case UtilLoggingLevel.SEVERE_INT /*22000*/:
                stringBuffer.append("sample_session_core").append(".").append("type_id").append(" >=? and ").append("sample_session_core").append(".").append("type_id").append(" <=? ");
                break;
            default:
                stringBuffer.append("sample_session_core").append(".").append("type_id").append(" =? ");
                break;
        }
        if (z) {
            stringBuffer.append(" and ").append("sample_session_core").append(".").append("merged").append(" =? ");
        }
        C4843h.m23387a("sample_session_core.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        C4843h.m23391a(stringBuffer, "sample_session_core", "type_id");
        C4843h.m23392a(stringBuffer, "sample_session_core", "start_time", hiAggregateOption.getSortOrder());
        C4843h.m23389a(stringBuffer, hiAggregateOption.getAnchor(), hiAggregateOption.getCount());
        return stringBuffer.toString();
    }

    public static String m23402b(List<Integer> list, String[] strArr, int i, HiAggregateOption hiAggregateOption, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_sequence").append(".").append("start_time").append(",");
        stringBuffer.append("sample_sequence").append(".").append("end_time").append(",");
        stringBuffer.append("sample_sequence").append(".").append("type_id").append(",");
        stringBuffer.append(" count ").append("(").append("sample_sequence").append(".").append("type_id").append(")").append(" as ").append(hiAggregateOption.getConstantsKey()[0]);
        stringBuffer.append(" from ").append("sample_sequence");
        stringBuffer.append(" where ").append("sample_sequence").append(".").append("start_time").append(" >=? and ").append("sample_sequence").append(".").append("start_time").append(" <=? and ").append("sample_sequence").append(".").append("type_id").append(" =? ");
        if (z) {
            stringBuffer.append(" and ").append("sample_sequence").append(".").append("merged").append(" =? ");
        }
        C4843h.m23387a("sample_sequence.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        C4843h.m23392a(stringBuffer, "sample_sequence", "start_time", hiAggregateOption.getSortOrder());
        C4843h.m23389a(stringBuffer, hiAggregateOption.getAnchor(), hiAggregateOption.getCount());
        return stringBuffer.toString();
    }

    public static String m23408c(List<Integer> list, String[] strArr, int i, HiAggregateOption hiAggregateOption, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_point").append(".").append("start_time").append(",");
        stringBuffer.append("sample_point").append(".").append("end_time").append(",");
        stringBuffer.append("sample_point").append(".").append("type_id").append(",");
        int groupUnitType = hiAggregateOption.getGroupUnitType();
        stringBuffer.append(C4843h.m23377a(groupUnitType, hiAggregateOption.getGroupUnitSize(), "sample_point"));
        int[] type = hiAggregateOption.getType();
        String[] constantsKey = hiAggregateOption.getConstantsKey();
        int length = type.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(C4843h.m23404c(hiAggregateOption.getAggregateType(), type[i2], constantsKey[i2]));
            if (i2 < length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ").append("sample_point");
        stringBuffer.append(" where ").append("sample_point").append(".").append("start_time").append(" >=? and ").append("sample_point").append(".").append("start_time").append(" <=? ");
        if (z) {
            stringBuffer.append(" and ").append("sample_point").append(".").append("merged").append(" =? ");
        }
        C4843h.m23388a("sample_point.type_id", type, type.length, stringBuffer, strArr, i);
        C4843h.m23387a("sample_point.client_id", (List) list, list.size(), stringBuffer, strArr, i + type.length);
        if (groupUnitType == 0) {
            C4843h.m23391a(stringBuffer, "sample_point", "start_time");
        } else if (groupUnitType == 8) {
            C4843h.m23391a(stringBuffer, "sample_point", WBConstants.AUTH_PARAMS_CLIENT_ID);
        } else {
            C4843h.m23390a(stringBuffer, "unit_index");
        }
        C4843h.m23392a(stringBuffer, "sample_point", "start_time", hiAggregateOption.getSortOrder());
        C4843h.m23389a(stringBuffer, hiAggregateOption.getAnchor(), hiAggregateOption.getCount());
        return stringBuffer.toString();
    }

    public static String m23411d(List<Integer> list, String[] strArr, int i, HiAggregateOption hiAggregateOption, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_point_health").append(".").append("start_time").append(",");
        stringBuffer.append("sample_point_health").append(".").append("end_time").append(",");
        stringBuffer.append("sample_point_health").append(".").append("type_id").append(",");
        int groupUnitType = hiAggregateOption.getGroupUnitType();
        stringBuffer.append(C4843h.m23377a(groupUnitType, hiAggregateOption.getGroupUnitSize(), "sample_point_health"));
        int[] type = hiAggregateOption.getType();
        String[] constantsKey = hiAggregateOption.getConstantsKey();
        int length = type.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(C4843h.m23410d(hiAggregateOption.getAggregateType(), type[i2], constantsKey[i2]));
            if (i2 < length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ").append("sample_point_health");
        stringBuffer.append(" where ").append("sample_point_health").append(".").append("start_time").append(" >=? and ").append("sample_point_health").append(".").append("start_time").append(" <=? ");
        if (z) {
            stringBuffer.append(" and ").append("sample_point_health").append(".").append("merged").append(" =? ");
        }
        C4843h.m23388a("sample_point_health.type_id", type, type.length, stringBuffer, strArr, i);
        C4843h.m23387a("sample_point_health.client_id", (List) list, list.size(), stringBuffer, strArr, i + type.length);
        if (groupUnitType != 0) {
            C4843h.m23390a(stringBuffer, "unit_index");
        } else {
            C4843h.m23391a(stringBuffer, "sample_point_health", "start_time");
        }
        C4843h.m23392a(stringBuffer, "sample_point_health", "start_time", hiAggregateOption.getSortOrder());
        C4843h.m23389a(stringBuffer, hiAggregateOption.getAnchor(), hiAggregateOption.getCount());
        return stringBuffer.toString();
    }

    public static String m23383a(List<Integer> list, String[] strArr, int i, int i2, int i3, String[] strArr2, int[] iArr, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("sample_point_health").append(".").append("start_time").append(",");
        stringBuffer.append("sample_point_health").append(".").append("end_time").append(",");
        stringBuffer.append("sample_point_health").append(".").append("type_id").append(",");
        stringBuffer.append(C4843h.m23377a(i2, 1, "sample_point_health"));
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            stringBuffer.append(C4843h.m23410d(iArr[i5], i3, strArr2[i5]));
            if (i5 < length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ").append("sample_point_health");
        stringBuffer.append(" where ").append("sample_point_health").append(".").append("start_time").append(" >=? and ").append("sample_point_health").append(".").append("start_time").append(" <=? and ").append("sample_point_health").append(".").append("type_id").append(" =? and ").append("sample_point_health").append(".").append("merged").append(" =? ");
        C4843h.m23387a("sample_point_health.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        if (i2 != 0) {
            C4843h.m23390a(stringBuffer, "unit_index");
        } else {
            C4843h.m23391a(stringBuffer, "sample_point_health", "start_time");
        }
        C4843h.m23392a(stringBuffer, "sample_point_health", "start_time", i4);
        return stringBuffer.toString();
    }

    public static String m23379a(int i, int[] iArr, String[] strArr, List<Integer> list, String[] strArr2, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ").append("* , ").append(" max ").append("(modified_time) as ").append("modified_time").append(" , ");
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            stringBuffer.append(C4843h.m23398b(1, iArr[i4], strArr[i4]));
            if (i4 < length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ").append("hihealth_stat_day");
        stringBuffer.append(" where ").append("hihealth_stat_day").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        C4843h.m23388a("hihealth_stat_day.stat_type", iArr, iArr.length, stringBuffer, strArr2, i3);
        C4843h.m23387a("hihealth_stat_day.date", (List) list, list.size(), stringBuffer, strArr2, i3 + iArr.length);
        stringBuffer.append(" group by ").append("hihealth_stat_day").append(".").append("date");
        C4843h.m23392a(stringBuffer, "hihealth_stat_day", "date", i2);
        C4843h.m23389a(stringBuffer, 0, i);
        return stringBuffer.toString();
    }

    public static String m23380a(int i, int[] iArr, String[] strArr, String[] strArr2, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select ");
        stringBuffer.append("* ,");
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            stringBuffer.append(C4843h.m23410d(1, iArr[i4], strArr[i4]));
            if (i4 < length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ").append("sample_point_health");
        stringBuffer.append(" where ").append("sample_point_health").append(".").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sample_point_health").append(".").append("sync_status").append(" =? ");
        C4843h.m23388a("sample_point_health.type_id", iArr, iArr.length, stringBuffer, strArr2, i3);
        stringBuffer.append(" group by ").append("sample_point_health").append(".").append("start_time");
        C4843h.m23392a(stringBuffer, "sample_point_health", "start_time", i2);
        C4843h.m23389a(stringBuffer, 0, i);
        return stringBuffer.toString();
    }

    public static String m23382a(String str, List<Integer> list, String[] strArr, int i, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Select (count(*) +(select (case t1.type_id when ? then 1 else 0 end) from sample_session t1 ");
        stringBuffer.append("where t1.start_time >= ? and t1.start_time <= ?");
        if (z) {
            stringBuffer.append(" and t1.merged =?  ");
        }
        stringBuffer.append("ORDER BY start_time ASC LIMIT 0,1 )) as ");
        stringBuffer.append(str);
        stringBuffer.append(" From sample_session t1 inner join sample_session t2 on t2.start_time = (Select min(start_time)");
        stringBuffer.append(" From sample_session t2 where t2.start_time >= t1.end_time) ");
        stringBuffer.append(" and t1.type_id <> ? and t2.type_id = ? and t1.start_time >= ? and t1.start_time <= ? ");
        if (z) {
            stringBuffer.append(" and t1.merged =?  ");
        }
        C4843h.m23387a("t1.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        return stringBuffer.toString();
    }

    public static String m23400b(String str, List<Integer> list, String[] strArr, int i, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Select (count(*) +(select (case t1.type_id when ? then 1 else 0 end) from sample_session_health t1 ");
        stringBuffer.append("where t1.start_time >= ? and t1.start_time <= ?");
        if (z) {
            stringBuffer.append(" and t1.merged =?  ");
        }
        stringBuffer.append("ORDER BY start_time ASC LIMIT 0,1 )) as ");
        stringBuffer.append(str);
        stringBuffer.append(" From sample_session_health t1 inner join sample_session_health t2 on t2.start_time = (Select min(start_time)");
        stringBuffer.append(" From sample_session_health t2 where t2.start_time >= t1.end_time) ");
        stringBuffer.append(" and t1.type_id <> ? and t2.type_id = ? and t1.start_time >= ? and t1.start_time <= ? ");
        if (z) {
            stringBuffer.append(" and t1.merged =?  ");
        }
        C4843h.m23387a("t1.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        return stringBuffer.toString();
    }

    public static String m23406c(String str, List<Integer> list, String[] strArr, int i, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Select (count(*) +(select (case t1.type_id when ? then 1 else 0 end) from sample_session_core t1 ");
        stringBuffer.append("where t1.start_time >= ? and t1.start_time <= ?");
        if (z) {
            stringBuffer.append(" and t1.merged =?  ");
        }
        stringBuffer.append("ORDER BY start_time ASC LIMIT 0,1 )) as ");
        stringBuffer.append(str);
        stringBuffer.append(" From sample_session_core t1 inner join sample_session_core t2 on t2.start_time = (Select min(start_time)");
        stringBuffer.append(" From sample_session_core t2 where t2.start_time >= t1.end_time) ");
        stringBuffer.append(" and t1.type_id <> ? and t2.type_id = ? and t1.start_time >= ? and t1.start_time <= ? ");
        if (z) {
            stringBuffer.append(" and t1.merged =?  ");
        }
        C4843h.m23387a("t1.client_id", (List) list, list.size(), stringBuffer, strArr, i);
        return stringBuffer.toString();
    }

    private static String m23397b(int i, int i2) {
        String str = "";
        String str2 = "datetime(sample_session.start_time/1000" + C4843h.m23374a();
        switch (i) {
            case 1:
                return "(strftime('%H', " + str2 + "*60+" + "strftime('%M', " + str2 + ")/" + i2 + " as " + "unit_index" + ",";
            case 2:
                return "strftime('%Y-%m-%d %H', " + str2 + " as " + "unit_index" + ",";
            case 3:
                return "strftime('%Y-%m-%d', " + str2 + " as " + "unit_index" + ",";
            case 4:
                return "strftime('%Y-%W', " + str2 + " as " + "unit_index" + ",";
            case 5:
                return "strftime('%Y-%m', " + str2 + " as " + "unit_index" + ",";
            case 6:
                return "strftime('%Y', " + str2 + " as " + "unit_index" + ",";
            case 7:
                return "strftime('AGG_ALL', " + str2 + " as " + "unit_index" + ",";
            default:
                return str;
        }
    }

    private static String m23377a(int i, int i2, String str) {
        String str2 = "";
        String str3 = "datetime(" + str + ".start_time/1000" + C4843h.m23374a();
        switch (i) {
            case 1:
                return "(strftime('%H', " + str3 + "*60+" + "strftime('%M', " + str3 + ")/" + i2 + " as " + "unit_index" + ",";
            case 2:
                return "strftime('%Y-%m-%d %H', " + str3 + " as " + "unit_index" + ",";
            case 3:
                return "strftime('%Y-%m-%d', " + str3 + " as " + "unit_index" + ",";
            case 4:
                return "strftime('%Y-%W', " + str3 + " as " + "unit_index" + ",";
            case 5:
                return "strftime('%Y-%m', " + str3 + " as " + "unit_index" + ",";
            case 6:
                return "strftime('%Y', " + str3 + " as " + "unit_index" + ",";
            case 7:
                return "strftime('AGG_ALL', " + str3 + " as " + "unit_index" + ",";
            default:
                return str2;
        }
    }

    private static String m23374a() {
        return C4540b.m21752a(null) + "*36, 'unixepoch'))";
    }

    private static String m23398b(int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (i) {
            case 1:
                C4843h.m23403b(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
                break;
            case 2:
                C4843h.m23393a(stringBuffer, "hihealth_stat_day", "stat_type", i2, str);
                break;
            case 3:
                C4843h.m23394a(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
                break;
            case 4:
                C4843h.m23409c(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
                break;
            case 5:
                C4843h.m23412d(stringBuffer, "hihealth_stat_day", "stat_type", "value", i2, str);
                break;
        }
        return stringBuffer.toString();
    }

    private static String m23404c(int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (i) {
            case 1:
                C4843h.m23403b(stringBuffer, "sample_point", "type_id", "value", i2, str);
                break;
            case 2:
                C4843h.m23393a(stringBuffer, "sample_point", "type_id", i2, str);
                break;
            case 3:
                C4843h.m23394a(stringBuffer, "sample_point", "type_id", "value", i2, str);
                break;
            case 4:
                C4843h.m23409c(stringBuffer, "sample_point", "type_id", "value", i2, str);
                break;
            case 5:
                C4843h.m23412d(stringBuffer, "sample_point", "type_id", "value", i2, str);
                break;
        }
        return stringBuffer.toString();
    }

    private static String m23410d(int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (i) {
            case 1:
                C4843h.m23403b(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
                break;
            case 2:
                C4843h.m23393a(stringBuffer, "sample_point_health", "type_id", i2, str);
                break;
            case 3:
                C4843h.m23394a(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
                break;
            case 4:
                C4843h.m23409c(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
                break;
            case 5:
                C4843h.m23412d(stringBuffer, "sample_point_health", "type_id", "value", i2, str);
                break;
        }
        return stringBuffer.toString();
    }

    private static String m23378a(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (i) {
            case 1:
                stringBuffer.append(" sum ").append("(").append("sample_session").append(".").append("end_time").append(" - ").append("sample_session").append(".").append("start_time").append(" )/1000").append(" as ").append(str);
                break;
            case 2:
                stringBuffer.append(" count ").append("(").append("sample_session").append(".").append("type_id").append(")").append(" as ").append(str);
                break;
        }
        return stringBuffer.toString();
    }

    private static String m23399b(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (i) {
            case 1:
                stringBuffer.append(" sum ").append("(").append("sample_session_health").append(".").append("end_time").append(" - ").append("sample_session_health").append(".").append("start_time").append(" )/1000").append(" as ").append(str);
                break;
            case 2:
                stringBuffer.append(" count ").append("(").append("sample_session_health").append(".").append("type_id").append(")").append(" as ").append(str);
                break;
        }
        return stringBuffer.toString();
    }

    private static String m23405c(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (i) {
            case 1:
                stringBuffer.append(" sum ").append("(").append("sample_session_core").append(".").append("end_time").append(" - ").append("sample_session_core").append(".").append("start_time").append(" )/1000").append(" as ").append(str);
                break;
            case 2:
                stringBuffer.append(" count ").append("(").append("sample_session_core").append(".").append("type_id").append(")").append(" as ").append(str);
                break;
        }
        return stringBuffer.toString();
    }

    public static void m23387a(String str, List<Integer> list, int i, StringBuffer stringBuffer, String[] strArr, int i2) {
        if (i2 == 0) {
            stringBuffer.append(str).append(" in ( ");
        } else {
            stringBuffer.append(" and ").append(str).append(" in ( ");
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 == 0) {
                stringBuffer.append(" ? ");
            } else {
                stringBuffer.append(",?");
            }
            strArr[i2 + i3] = Integer.toString(((Integer) list.get(i3)).intValue());
        }
        stringBuffer.append(" )");
    }

    public static void m23388a(String str, int[] iArr, int i, StringBuffer stringBuffer, String[] strArr, int i2) {
        if (i2 == 0) {
            stringBuffer.append(str).append(" in ( ");
        } else {
            stringBuffer.append(" and ").append(str).append(" in ( ");
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 == 0) {
                stringBuffer.append(" ? ");
            } else {
                stringBuffer.append(",?");
            }
            strArr[i2 + i3] = Integer.toString(iArr[i3]);
        }
        stringBuffer.append(" )");
    }

    public static boolean m23395a(long j) {
        return j > 0;
    }

    public static String m23376a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INSERT INTO ");
        stringBuffer.append("hihealth_temp");
        stringBuffer.append(" ( ");
        stringBuffer.append("tempKey").append(", ");
        stringBuffer.append("tempValue");
        stringBuffer.append(" ) ");
        stringBuffer.append(" VALUES ");
        stringBuffer.append(" ( ");
        stringBuffer.append(i).append(", ");
        stringBuffer.append(i2);
        stringBuffer.append(" ) ");
        return stringBuffer.toString();
    }

    public static String m23375a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DELETE FROM ");
        stringBuffer.append("sync_cache");
        stringBuffer.append(" where ");
        stringBuffer.append("_id");
        stringBuffer.append(" in ");
        stringBuffer.append(" ( ");
        stringBuffer.append(" select ").append("tempValue").append(" from ").append("hihealth_temp");
        stringBuffer.append(" where ").append("tempKey").append(" = ").append(i);
        stringBuffer.append(" ) ");
        return stringBuffer.toString();
    }

    public static String m23396b(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DELETE FROM ");
        stringBuffer.append("hihealth_temp");
        stringBuffer.append(" where ");
        stringBuffer.append("tempKey");
        stringBuffer.append(" = ");
        stringBuffer.append(i);
        return stringBuffer.toString();
    }

    public static void m23390a(StringBuffer stringBuffer, String str) {
        stringBuffer.append(" group by ").append(str);
    }

    private static void m23391a(StringBuffer stringBuffer, String str, String str2) {
        stringBuffer.append(" group by ").append(str).append(".").append(str2);
    }

    public static String m23381a(String str, int i, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (i) {
            case 0:
                stringBuffer.append(str).append(" ASC ");
                break;
            case 1:
                stringBuffer.append(str).append(" DESC ");
                break;
        }
        C4843h.m23389a(stringBuffer, i2, i3);
        return stringBuffer.toString();
    }

    private static void m23392a(StringBuffer stringBuffer, String str, String str2, int i) {
        switch (i) {
            case 0:
                stringBuffer.append(" ORDER BY ").append(str).append(".").append(str2).append(" ASC ");
                return;
            case 1:
                stringBuffer.append(" ORDER BY ").append(str).append(".").append(str2).append(" DESC ");
                return;
            default:
                return;
        }
    }

    private static void m23389a(StringBuffer stringBuffer, int i, int i2) {
        if (i2 > 0) {
            stringBuffer.append(" limit ").append(i).append(",").append(i2);
        }
    }

    private static void m23393a(StringBuffer stringBuffer, String str, String str2, int i, String str3) {
        stringBuffer.append(" sum ").append("(").append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append("1 else 0 end)").append(" as ").append(str3);
    }

    private static void m23394a(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append("(").append(" sum ").append("(").append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" else 0 end)").append("/").append(" sum ").append("(").append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append("1 else 0 end))").append(" as ").append(str4);
    }

    private static void m23403b(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(" sum ").append("(").append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" else 0 end)").append(" as ").append(str4);
    }

    private static void m23409c(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(" max ").append("(").append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" end)").append(" as ").append(str4);
    }

    private static void m23412d(StringBuffer stringBuffer, String str, String str2, String str3, int i, String str4) {
        stringBuffer.append(" min ").append("(").append(" case ").append(str).append(".").append(str2).append(" when ").append(i).append(" then ").append(str).append(".").append(str3).append(" end)").append(" as ").append(str4);
    }
}
