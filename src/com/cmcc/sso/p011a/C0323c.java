package com.cmcc.sso.p011a;

import android.content.Context;
import android.text.TextUtils;
import com.cmcc.sso.sdk.p012a.C0325a;
import com.cmcc.sso.sdk.p013b.C0327a;
import com.cmcc.sso.sdk.p013b.C0328b;
import com.cmcc.sso.service.C0337g;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import dalvik.system.DexClassLoader;
import java.io.File;

public final class C0323c {
    private static final String f171a = ("cmcc-sso-" + C0325a.m194a() + ".jar");
    private static String f172b = C0325a.m194a();
    private static DexClassLoader f173c = null;

    private static int m173a(String str, String str2) {
        String[] split = str.split("[.]+");
        String[] split2 = str2.split("[.]+");
        int i = 0;
        while (i < 4) {
            try {
                if (split.length <= i) {
                    return -1;
                }
                if (split2.length <= i) {
                    return 1;
                }
                if (Integer.parseInt(split[i]) != Integer.parseInt(split2[i])) {
                    if (Integer.parseInt(split[i]) < Integer.parseInt(split2[i])) {
                        return -1;
                    }
                    if (Integer.parseInt(split[i]) > Integer.parseInt(split2[i])) {
                        return 1;
                    }
                }
                i++;
            } catch (Exception e) {
                C0327a.m200a("version compare failed...");
            }
        }
        return 0;
    }

    public static C0337g m174a(Context context) {
        try {
            return (C0337g) C0323c.m175a(context, "com.cmcc.sso.service.core.BusinessThread").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Class m175a(Context context, String str) {
        Class a = C0323c.m176a(context, str, false);
        if (a != null) {
            return a;
        }
        C0327a.m204c("first try load failed...");
        return C0323c.m176a(context, str, true);
    }

    private static Class m176a(Context context, String str, boolean z) {
        String str2;
        boolean z2 = false;
        if (!z) {
            try {
                if (f173c != null) {
                    C0327a.m200a("use cache classloader");
                    return f173c.loadClass(str);
                }
            } catch (Exception e) {
                r1 = C0325a.m197b();
                Object b;
                if (!TextUtils.isEmpty(b)) {
                    C0324d.m185a(new File(b));
                }
                C0324d.m185a(new File(C0325a.m195a(context)));
                C0328b.m208a(context, "lastCheckTime", "");
                return null;
            }
        }
        String b2 = C0325a.m197b();
        b2 = !TextUtils.isEmpty(b2) ? C0323c.m177a(context, b2, "cmcc-sso-", LightCloudConstants.ZIP_POSTFIX) : null;
        C0327a.m200a("sdcardZipVersion " + b2);
        String a = C0323c.m177a(context, C0325a.m195a(context), "cmcc-sso-", LightCloudConstants.ZIP_POSTFIX);
        C0327a.m200a("contextZipVersion " + a);
        if (!TextUtils.isEmpty(b2)) {
            if (TextUtils.isEmpty(a) || C0323c.m173a(a, b2) < 0) {
                C0323c.m178a(context, C0325a.m195a(context), b2, false);
            }
            a = C0325a.m197b() + "/cmcc-sso-" + b2 + LightCloudConstants.ZIP_POSTFIX;
            String str3 = C0325a.m195a(context) + "/cmcc-sso-" + b2 + LightCloudConstants.ZIP_POSTFIX;
            String str4 = C0325a.m195a(context) + "/cmcc-sso-" + b2 + ".jar";
            String str5 = C0325a.m195a(context) + "/" + C0324d.m190b(context, b2);
            File file = new File(str3);
            File file2 = new File(str4);
            File file3 = new File(str5);
            if (file2.exists() && file3.exists() && C0324d.m188a(context, file2) && C0324d.m188a(context, file3)) {
                C0327a.m200a("dst file already exists, stop copying zip file.");
            } else {
                if (file2.exists()) {
                    file2.delete();
                }
                if (file3.exists()) {
                    file3.delete();
                }
                if (C0324d.m192b()) {
                    C0327a.m200a("copying: " + a);
                    C0324d.m183a(context, a, str3);
                }
                C0324d.m186a(str3, C0325a.m195a(context));
                if (file2.exists() && file3.exists()) {
                    C0323c.m178a(context, C0325a.m195a(context), b2, true);
                    C0324d.m191b(context, file);
                    C0324d.m191b(context, file2);
                    C0324d.m191b(context, file3);
                } else {
                    C0327a.m200a("unzip file can't get so file or jar file.");
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file3.exists()) {
                        file3.delete();
                    }
                }
            }
        }
        b2 = C0323c.m177a(context, C0325a.m195a(context), "cmcc-sso-", ".jar");
        if (TextUtils.isEmpty(b2)) {
            str2 = null;
        } else {
            File file4 = new File(C0325a.m195a(context) + "/" + C0324d.m190b(context, b2));
            if (file4.exists()) {
                z2 = C0324d.m188a(context, file4);
            }
            if (z2) {
                str2 = "cmcc-sso-" + b2 + ".jar";
                C0327a.m200a("context latest " + str2);
                str2 = C0325a.m195a(context) + "/" + str2;
            } else {
                C0327a.m200a("so file don't exist, skip this version...");
                str2 = null;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            C0327a.m200a("init default jar");
            str2 = f171a;
            File file5 = new File(C0325a.m195a(context));
            if (!file5.exists()) {
                file5.mkdir();
            }
            str2 = C0321a.m166a(context, str2, file5);
            C0324d.m191b(context, new File(str2));
            C0324d.m191b(context, new File(C0321a.m166a(context, C0324d.m190b(context, C0325a.m194a()), file5)));
            C0324d.m182a(context, str2);
            str2 = C0325a.m195a(context) + "/" + f171a;
        } else {
            int lastIndexOf = str2.lastIndexOf("cmcc-sso-") + 9;
            int indexOf = str2.indexOf(".jar");
            if (indexOf > 0 && lastIndexOf > 0) {
                f172b = str2.substring(lastIndexOf, indexOf);
            }
            C0327a.m200a("loading patch: " + str2);
            C0324d.m182a(context, str2);
        }
        DexClassLoader dexClassLoader = new DexClassLoader(str2, C0325a.m195a(context), null, context.getClassLoader());
        f173c = dexClassLoader;
        return dexClassLoader.loadClass(str);
    }

    private static String m177a(Context context, String str, String str2, String str3) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        String a = C0325a.m194a();
        int length = listFiles.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2;
            File file2 = listFiles[i];
            C0327a.m200a("parsing " + file2.getPath());
            String name = file2.getName();
            if (name.startsWith(str2) && name.endsWith(str3)) {
                int indexOf = name.indexOf(str3);
                if (indexOf > 0) {
                    name = name.substring(9, indexOf);
                    C0327a.m200a("version num " + name);
                    if (C0323c.m173a(a, name) <= 0) {
                        if (C0324d.m188a(context, file2)) {
                            obj2 = name.equals(C0325a.m194a()) ? 1 : obj;
                            i++;
                            obj = obj2;
                            a = name;
                        } else {
                            C0327a.m200a("hash don't match: " + file2.getAbsolutePath());
                        }
                    }
                }
            }
            name = a;
            obj2 = obj;
            i++;
            obj = obj2;
            a = name;
        }
        if (a.equals(C0325a.m194a()) && obj == null) {
            return null;
        }
        C0327a.m200a("latest version: " + a);
        return a;
    }

    private static void m178a(Context context, String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (!((name.contains(C0325a.m194a()) && C0324d.m188a(context, file2)) || (name.contains(f172b) && C0324d.m188a(context, file2)))) {
                            boolean contains = file2.getName().contains(str2);
                            if (contains && !z) {
                                file2.delete();
                            } else if (contains && !z) {
                                file2.delete();
                            }
                        }
                    }
                }
            }
        }
    }
}
