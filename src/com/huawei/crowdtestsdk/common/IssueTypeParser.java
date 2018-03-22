package com.huawei.crowdtestsdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.Xml;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class IssueTypeParser {
    private static final String BETA_TYPE = "betaTypeId";
    private static final String BUG_TYPE = "bugTypeId";
    private static final String CLASS_NAME = "className";
    private static final String DESC = "desc";
    private static final String IMAGE = "image";
    private static final String IMAG_TITLEBAR = "imageTitleBar";
    private static final String ISSUE_TYPE = "IssueType";
    private static final String TITLE = "title";
    private static final String UNKNOWN_ISSUE_BETA_ID = "new_ques_type_9999";
    private static final int UNKNOWN_ISSUE_ID = 9999;
    private static List<IssueType> issueTypeList = new ArrayList();
    private static List<IssueType> issueTypeListRnd = new ArrayList();
    private static SparseArray<IssueType> issueTypeMapRnd = new SparseArray();
    private static IssueTypeParser issueTypeParser;

    public static IssueTypeParser getInstance() {
        if (issueTypeParser == null) {
            issueTypeParser = new IssueTypeParser();
        }
        return issueTypeParser;
    }

    public static IssueType getIssueTypeByBetaId(Context context, String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            C2511g.m12483c("BETACLUB_SDK", "[IssueTypeParser.getIssueTypeByBetaId]betaId in params is null or empty");
            return getUnknownIssueType(context);
        }
        for (IssueType issueType : issueTypeList) {
            if (str.equalsIgnoreCase(issueType.getBetaTypeId())) {
                return issueType;
            }
        }
        return getUnknownIssueType(context);
    }

    public static IssueType getUnknownIssueType(Context context) {
        C2511g.m12481b("BETACLUB_SDK", "[IssueTypeParser.getUnknownIssueType]getUnknownIssueType");
        IssueType issueType = new IssueType();
        issueType.setBugTypeId(UNKNOWN_ISSUE_ID);
        issueType.setBetaTypeId(UNKNOWN_ISSUE_BETA_ID);
        issueType.setDesc(context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_unknown_issue_type", ResUtil.TYPE_STRING)));
        issueType.setClassName(context, null);
        return issueType;
    }

    public static int getIssueTypeSize() {
        return issueTypeList.size();
    }

    public static IssueType getIssueTypeByIndex(int i) {
        if (i < 0 || i >= issueTypeList.size()) {
            return getUnknownIssueType(AppContext.getInstance().getApplicationContext());
        }
        return (IssueType) issueTypeList.get(i);
    }

    public void parseIssueType(Context context, int i) {
        C2511g.m12481b("BETACLUB_SDK", "[IssueTypeParser.parseIssueType]load configuration");
        issueTypeList.clear();
        try {
            C2511g.m12481b("BETACLUB_SDK", "[IssueTypeParser.parseIssueType]xmlPath id is:" + i);
            XmlPullParser xml = context.getResources().getXml(i);
            if (xml == null) {
                C2511g.m12481b("BETACLUB_SDK", "[IssueTypeParser.parseIssueType]xmlParser is null");
                return;
            }
            xml.next();
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2 && xml.getName().equals(ISSUE_TYPE)) {
                    IssueType issueType = new IssueType();
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    issueType.setBugTypeId(getIntValue(asAttributeSet, BUG_TYPE));
                    issueType.setBetaTypeId(getStringValue(asAttributeSet, BETA_TYPE));
                    issueType.setTitle(getStringRValue(context, asAttributeSet, "title"));
                    issueType.setDesc(getStringRValue(context, asAttributeSet, "desc"));
                    issueType.setImageId(getImageRValue(asAttributeSet, "image"));
                    issueType.setClassName(context, getStringValue(asAttributeSet, CLASS_NAME));
                    C2511g.m12477a("BETACLUB_SDK", "[IssueTypeParser.parseIssueType : ]" + issueType.getClassName());
                    issueTypeList.add(issueType);
                }
            }
            IOUtils.close(null);
        } catch (Throwable e) {
            C2511g.m12479a("BETACLUB_SDK", "[IssueTypeParser.parseIssueType]Error parsing xml configuration:", e);
        } catch (Throwable e2) {
            C2511g.m12479a("BETACLUB_SDK", "[IssueTypeParser.parseIssueType]Error loading configuration:", e2);
        } finally {
            IOUtils.close(null);
        }
    }

    private static int getIntValue(AttributeSet attributeSet, String str) {
        int i = -1;
        String attributeValue = attributeSet.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                i = Integer.parseInt(attributeValue);
            } catch (Exception e) {
            }
        }
        return i;
    }

    private static String getStringValue(AttributeSet attributeSet, String str) {
        return attributeSet.getAttributeValue(null, str);
    }

    private static String getStringRValue(Context context, AttributeSet attributeSet, String str) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue > 0) {
            return context.getResources().getText(attributeResourceValue, "").toString();
        }
        return attributeSet.getAttributeValue(null, str);
    }

    private static int getImageRValue(AttributeSet attributeSet, String str) {
        return attributeSet.getAttributeResourceValue(null, str, 0);
    }

    public static IssueType getIssueTypeByBugTypeId(int i) {
        C2511g.m12481b("BETACLUB_SDK", "[IssueTypeParser.getIssueTypeByBugTypeId]bugTypeId : " + i);
        for (IssueType issueType : issueTypeList) {
            int bugTypeId = issueType.getBugTypeId();
            C2511g.m12481b("BETACLUB_SDK", "[IssueTypeParser.getIssueTypeByBugTypeId] x : " + bugTypeId);
            if (i == bugTypeId) {
                return issueType;
            }
        }
        C2511g.m12481b("BETACLUB_SDK", "[IssueTypeParser.getIssueTypeByBugTypeId]for finished!");
        return getUnknownIssueType(AppContext.getInstance().getApplicationContext());
    }
}
