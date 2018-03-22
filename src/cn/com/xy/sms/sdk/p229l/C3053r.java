package cn.com.xy.sms.sdk.p229l;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C3053r {
    private static String f10301a;
    private static Pattern f10302b;
    private static String f10303c;
    private static Pattern f10304d;

    static {
        String str = "(?:(?:http|https|ftp)://)?(?:[a-zA-Z0-9]{1,30})(?:\\.[a-zA-Z0-9]{1,30}){1,4}(?:[/?][^\\s]+)?|谨防|诈骗|(?:温馨|特别)?提[醒示]|泄露|回复|屏蔽|拨打|[致速]电|呼叫|请勿|勿向|注意";
        f10301a = str;
        f10302b = Pattern.compile(str);
        str = "([\\[〔])|([〕\\]])";
        f10303c = str;
        f10304d = Pattern.compile(str);
    }

    public static String m13690a(String str) {
        int indexOf;
        String substring;
        Matcher matcher = f10304d.matcher(str);
        if (matcher.find()) {
            StringBuffer stringBuffer = new StringBuffer();
            do {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (group != null) {
                    matcher.appendReplacement(stringBuffer, "【");
                }
                if (group2 != null) {
                    matcher.appendReplacement(stringBuffer, "】");
                }
            } while (matcher.find());
            matcher.appendTail(stringBuffer);
            str = stringBuffer.toString();
        }
        String replaceFirst = str.replaceAll("([:： ])[:： ]+", "$1").replaceAll("([,，。；！!;\\?][^【,，。；！!;\\?]*)【(?=[^】]*[,，。；！!;\\?])[^】]+】", "$1:").replaceFirst("[\\(（【]\\d/\\d[\\)）】]", "");
        int length = replaceFirst.length();
        if ('【' == replaceFirst.charAt(0)) {
            indexOf = replaceFirst.indexOf(12305);
            if (indexOf != -1) {
                substring = replaceFirst.substring(1, indexOf);
                if (C3053r.m13691b(substring)) {
                    return substring;
                }
            }
        }
        indexOf = length - 1;
        if ('】' == replaceFirst.charAt(indexOf)) {
            length = replaceFirst.lastIndexOf(12304);
            if (length >= 0) {
                substring = replaceFirst.substring(length + 1, indexOf);
                if (C3053r.m13691b(substring)) {
                    return substring;
                }
            }
        }
        return null;
    }

    private static boolean m13691b(String str) {
        return (str == null || str.trim().length() <= 0 || f10302b.matcher(str).find()) ? false : true;
    }
}
