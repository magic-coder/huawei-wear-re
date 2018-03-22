package com.huawei.hwid.core.p435d.p436a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: PropertiesGrade */
public class C5151b implements C5150a {
    public void mo4635a(Context context, int i, int i2) {
        if (i >= i2) {
            C5165e.m24910d("PropertiesGrade", "newVersion is less then oldVersion, onUpgrade error");
            return;
        }
        C5165e.m24906b("PropertiesGrade", "update settings.properties when version update");
        m24836a(context, i);
    }

    private void m24836a(Context context, int i) {
        C5165e.m24906b("PropertiesGrade", "begin update curName in settings.properties");
        String a = C5151b.m24835a(context, "curName");
        C5176g.m25011a(context, new String[]{"curName"});
        if (TextUtils.isEmpty(a)) {
            C5165e.m24906b("PropertiesGrade", "curName is null in settings.properties");
            return;
        }
        if (C5166b.m24928a(context, "isSDKAccountDataEncrypted", false)) {
            C5176g.m25011a(context, new String[]{"isSDKAccountDataEncrypted"});
            a = C5201e.m25304a(context, a);
        } else if (i < 3) {
            a = C5201e.m25308c(context, a);
        }
        if (TextUtils.isEmpty(a)) {
            C5165e.m24906b("PropertiesGrade", "curName ecb decrypt error");
            return;
        }
        C5165e.m24906b("PropertiesGrade", "update curName in settings.properties");
        C5176g.m25009a(context, "curName", a);
    }

    public static synchronized String m24835a(Context context, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        String str2;
        InputStream inputStream;
        Object obj;
        FileOutputStream fileOutputStream3 = null;
        synchronized (C5151b.class) {
            try {
                Properties properties = new Properties();
                if (new File(context.getFilesDir().getPath() + "/" + "settings.properties").exists()) {
                    fileOutputStream = fileOutputStream3;
                } else {
                    fileOutputStream = context.openFileOutput("settings.properties", 0);
                }
                try {
                    InputStream openFileInput = context.openFileInput("settings.properties");
                    if (openFileInput != null) {
                        try {
                            properties.load(openFileInput);
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileOutputStream2 = fileOutputStream;
                            fileInputStream = openFileInput;
                            fileOutputStream3 = fileOutputStream2;
                            try {
                                C5165e.m24911d("PropertiesGrade", "Can not find the file settings.properties", e);
                                if (fileOutputStream3 != null) {
                                    try {
                                        fileOutputStream3.close();
                                    } catch (Throwable e3) {
                                        C5165e.m24911d("PropertiesGrade", "IOException / " + e3.getMessage(), e3);
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e32) {
                                        C5165e.m24911d("PropertiesGrade", "IOException / " + e32.getMessage(), e32);
                                    }
                                }
                                str2 = "";
                                return str2;
                            } catch (Throwable th) {
                                e32 = th;
                                if (fileOutputStream3 != null) {
                                    try {
                                        fileOutputStream3.close();
                                    } catch (Throwable e4) {
                                        C5165e.m24911d("PropertiesGrade", "IOException / " + e4.getMessage(), e4);
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e42) {
                                        C5165e.m24911d("PropertiesGrade", "IOException / " + e42.getMessage(), e42);
                                    }
                                }
                                throw e32;
                            }
                        } catch (IOException e5) {
                            e32 = e5;
                            fileOutputStream2 = fileOutputStream;
                            inputStream = openFileInput;
                            fileOutputStream3 = fileOutputStream2;
                            C5165e.m24911d("PropertiesGrade", "IOException / " + e32.getMessage(), e32);
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (Throwable e322) {
                                    C5165e.m24911d("PropertiesGrade", "IOException / " + e322.getMessage(), e322);
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e3222) {
                                    C5165e.m24911d("PropertiesGrade", "IOException / " + e3222.getMessage(), e3222);
                                }
                            }
                            str2 = "";
                            return str2;
                        } catch (Throwable th2) {
                            e3222 = th2;
                            fileOutputStream2 = fileOutputStream;
                            inputStream = openFileInput;
                            fileOutputStream3 = fileOutputStream2;
                            if (fileOutputStream3 != null) {
                                fileOutputStream3.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e3222;
                        }
                    }
                    C5165e.m24906b("PropertiesGrade", "inStream is null");
                    str2 = properties.getProperty(str);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e6) {
                            C5165e.m24911d("PropertiesGrade", "IOException / " + e6.getMessage(), e6);
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (Throwable e422) {
                            C5165e.m24911d("PropertiesGrade", "IOException / " + e422.getMessage(), e422);
                        }
                    }
                } catch (FileNotFoundException e7) {
                    e3222 = e7;
                    fileOutputStream2 = fileOutputStream;
                    obj = fileOutputStream3;
                    fileOutputStream3 = fileOutputStream2;
                    C5165e.m24911d("PropertiesGrade", "Can not find the file settings.properties", e3222);
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    str2 = "";
                    return str2;
                } catch (IOException e8) {
                    e3222 = e8;
                    fileOutputStream2 = fileOutputStream;
                    obj = fileOutputStream3;
                    fileOutputStream3 = fileOutputStream2;
                    C5165e.m24911d("PropertiesGrade", "IOException / " + e3222.getMessage(), e3222);
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    str2 = "";
                    return str2;
                } catch (Throwable th3) {
                    e3222 = th3;
                    fileOutputStream2 = fileOutputStream;
                    obj = fileOutputStream3;
                    fileOutputStream3 = fileOutputStream2;
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3222;
                }
            } catch (FileNotFoundException e9) {
                e3222 = e9;
                obj = fileOutputStream3;
                C5165e.m24911d("PropertiesGrade", "Can not find the file settings.properties", e3222);
                if (fileOutputStream3 != null) {
                    fileOutputStream3.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                str2 = "";
                return str2;
            } catch (IOException e10) {
                e3222 = e10;
                fileInputStream = fileOutputStream3;
                C5165e.m24911d("PropertiesGrade", "IOException / " + e3222.getMessage(), e3222);
                if (fileOutputStream3 != null) {
                    fileOutputStream3.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                str2 = "";
                return str2;
            } catch (Throwable th4) {
                e3222 = th4;
                fileInputStream = fileOutputStream3;
                if (fileOutputStream3 != null) {
                    fileOutputStream3.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3222;
            }
        }
        return str2;
    }
}
