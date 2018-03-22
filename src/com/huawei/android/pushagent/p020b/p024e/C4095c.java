package com.huawei.android.pushagent.p020b.p024e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import java.io.File;
import org.json.JSONObject;

public class C4095c {

    class C4094a {
        String f15489a;
        int f15490b;
        String f15491c;
        Object f15492d;

        private C4094a() {
            this.f15489a = "";
            this.f15490b = -1;
            this.f15491c = "";
            this.f15492d = null;
        }
    }

    private static C4094a m20097a(String str) {
        C4094a c4094a = new C4094a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("file")) {
                c4094a.f15489a = jSONObject.getString("file");
                e.a("PushLogAC2712", "ModifyStruct mFileName is " + c4094a.f15489a);
            }
            if (jSONObject.has("type")) {
                c4094a.f15490b = jSONObject.getInt("type");
                e.a("PushLogAC2712", "ModifyStruct mModifyType is " + c4094a.f15490b);
            }
            if (jSONObject.has("name")) {
                c4094a.f15491c = jSONObject.getString("name");
                e.a("PushLogAC2712", "ModifyStruct mName is " + c4094a.f15491c);
            }
            if (!jSONObject.has("val")) {
                return c4094a;
            }
            c4094a.f15492d = jSONObject.get("val");
            e.a("PushLogAC2712", "ModifyStruct mVal is " + c4094a.f15492d);
            return c4094a;
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
            return null;
        }
    }

    public static synchronized void m20098a(Context context, String str) {
        synchronized (C4095c.class) {
            e.a("PushLogAC2712", "enter ModifyConfigs modify jsonStr is : " + str);
            C4094a a = C4095c.m20097a(str);
            if (a != null) {
                if (!TextUtils.isEmpty(a.f15489a)) {
                    switch (a.f15490b) {
                        case 1:
                            if (!TextUtils.isEmpty(a.f15491c)) {
                                if (!new h(context, a.f15489a).a(a.f15491c, a.f15492d)) {
                                    e.d("PushLogAC2712", "enter ModifyConfigs saveString failed!");
                                    break;
                                } else {
                                    e.a("PushLogAC2712", "enter ModifyConfigs saveString sucessfully! filename is " + a.f15489a + ",itemName is " + a.f15491c + ",itemValue is " + a.f15492d);
                                    break;
                                }
                            }
                            e.d("PushLogAC2712", "enter ModifyConfigs saveString failed! mName or mVal is null");
                            break;
                        case 2:
                            if (!TextUtils.isEmpty(a.f15491c)) {
                                File file = new File(context.getCacheDir().getParent() + File.separator + "shared_prefs" + File.separator + a.f15489a + ".xml");
                                if (file.isFile() && file.exists()) {
                                    if (!new h(context, a.f15489a).f(a.f15491c)) {
                                        e.d("PushLogAC2712", "enter ModifyConfigs removeKey failed, maybe the key is not exist!");
                                        break;
                                    } else {
                                        e.a("PushLogAC2712", "enter ModifyConfigs removeKey sucessfully! the fileName is " + a.f15489a + ",the key is " + a.f15491c);
                                        break;
                                    }
                                }
                                e.d("PushLogAC2712", "the file is not exist! file path is" + file);
                                break;
                            }
                            e.d("PushLogAC2712", "enter ModifyConfigs removeKey failed! mName is null");
                            break;
                            break;
                        case 3:
                            String str2 = context.getCacheDir().getParent() + File.separator + "shared_prefs" + File.separator + a.f15489a + ".xml";
                            File file2 = new File(str2);
                            if (file2.isFile() && file2.exists()) {
                                if (!file2.delete()) {
                                    e.d("PushLogAC2712", "delete failed! file path is " + str2);
                                    break;
                                } else {
                                    e.a("PushLogAC2712", "delete success! file path is " + str2);
                                    break;
                                }
                            }
                            e.d("PushLogAC2712", "the file is not exist! file path is" + str2);
                            break;
                            break;
                        default:
                            e.d("PushLogAC2712", "the modifyType:" + a.f15490b + " is not supported! ");
                            break;
                    }
                }
                e.d("PushLogAC2712", "enter ModifyConfigs struct failed to create sharepreference file!");
            } else {
                e.d("PushLogAC2712", "enter ModifyConfigs struct is null !");
            }
        }
    }
}
