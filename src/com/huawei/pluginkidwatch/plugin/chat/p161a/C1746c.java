package com.huawei.pluginkidwatch.plugin.chat.p161a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1481a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.plugin.chat.ChatActivity;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/* compiled from: CloudUtil */
class C1746c extends Thread {
    final /* synthetic */ C1745b f4791a;
    private String f4792b;
    private String f4793c;
    private String f4794d;
    private String f4795e;
    private Context f4796f;
    private String f4797g;
    private boolean f4798h;
    private Class<?> f4799i;
    private boolean f4800j;
    private String f4801k;

    public C1746c(C1745b c1745b, Context context, String str, String str2, String str3, String str4) {
        this.f4791a = c1745b;
        C2538c.m12674b("CloudUtil", "=======DownloadThread 2");
        this.f4792b = str;
        this.f4793c = str2;
        this.f4796f = context;
        this.f4794d = str3;
        this.f4795e = str4;
        this.f4797g = C1462f.m6746j();
        this.f4798h = false;
        this.f4800j = false;
        this.f4799i = null;
        this.f4801k = "";
    }

    public C1746c(C1745b c1745b, Context context, String str, String str2, String str3, String str4, String str5, String str6, Class<?> cls, boolean z) {
        this.f4791a = c1745b;
        C2538c.m12674b("CloudUtil", "=======DownloadThread 1");
        this.f4792b = str;
        this.f4793c = str2;
        this.f4796f = context;
        this.f4794d = str3;
        this.f4795e = str4;
        this.f4797g = str5;
        this.f4798h = true;
        this.f4799i = cls;
        this.f4801k = str6;
        this.f4800j = z;
    }

    public void run() {
        FileOutputStream fileOutputStream;
        IOException e;
        Exception e2;
        Throwable th;
        InputStream inputStream = null;
        InputStream fileInputStream;
        try {
            C2538c.m12674b("CloudUtil", "=======Enter DownloadThread  run");
            InputStream content = new DefaultHttpClient().execute(new HttpGet(this.f4793c)).getEntity().getContent();
            fileOutputStream = new FileOutputStream(new File(this.f4792b));
            byte[] bArr = new byte[512];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            content.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            C2538c.m12674b("CloudUtil", "======下载的文件大小：" + r1.length());
            File file = new File(this.f4792b);
            byte[] bArr2 = new byte[((int) file.length())];
            fileInputStream = new FileInputStream(file);
            try {
                int read2 = fileInputStream.read(bArr2);
                C2538c.m12674b("CloudUtil", "read ret=" + read2);
                fileInputStream.close();
                C2538c.m12674b("CloudUtil", "=======mKey:" + this.f4794d);
                C2538c.m12674b("CloudUtil", "=======mIv:" + this.f4795e);
                C2538c.m12674b("CloudUtil", "=======解密后二进制:" + C1492l.m6915b(C1481a.m6815c(bArr2, this.f4794d.getBytes(GameManager.DEFAULT_CHARSET), this.f4795e.getBytes(GameManager.DEFAULT_CHARSET))));
                File file2 = new File(this.f4792b);
                if (file2.exists()) {
                    boolean delete = file2.delete();
                    C2538c.m12674b("CloudUtil", "=======res:" + delete);
                }
                FileOutputStream fileOutputStream2;
                try {
                    fileOutputStream2 = new FileOutputStream(new File(this.f4792b));
                    try {
                        fileOutputStream2.write(r0);
                        fileOutputStream2.close();
                        C2538c.m12674b("CloudUtil", "======下载的文件解密后大小：" + file2.length());
                        this.f4791a.m8474a(this.f4792b, 0, this.f4797g);
                        if (this.f4798h && this.f4800j) {
                            String format = String.format(this.f4796f.getResources().getString(C1680l.IDS_plugin_kidwatch_chat_receive_message), new Object[]{this.f4801k});
                            if (this.f4797g.equals(C1462f.m6746j())) {
                                C2538c.m12674b("CloudUtil", "============和当前devicecode相同");
                                if (ChatActivity.class.getName().equals(C1492l.m6907a(this.f4796f))) {
                                    C2538c.m12674b("CloudUtil", "============K1Util.getCurrentActivityClassName is ChatActivity freshChatActivityUI voice");
                                    this.f4791a.m8475a(this.f4792b, this.f4796f);
                                } else {
                                    C2538c.m12674b("CloudUtil", "============K1Util.getCurrentActivityClassName is not ChatActivity freshChatActivityUI voice");
                                    this.f4791a.m8475a(this.f4792b, this.f4796f);
                                    C1497q.m6943a(this.f4796f, "chat_group_id", this.f4797g);
                                    C1495o.m6930a(this.f4796f, ChatActivity.class, format, this.f4796f.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 11, new int[0]);
                                }
                            } else {
                                C1497q.m6943a(this.f4796f, "chat_group_id", this.f4797g);
                                C1495o.m6930a(this.f4796f, this.f4799i, format, this.f4796f.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 11, C1492l.m6920d(this.f4797g));
                            }
                        } else {
                            C2538c.m12674b("CloudUtil", "============ freshChatActivityUI voice");
                            this.f4791a.m8475a(this.f4792b, this.f4796f);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                C2538c.m12680e("CloudUtil", "=======DownloadThread run error!!!  e1:" + e3.getMessage());
                            }
                        }
                    } catch (IOException e4) {
                        e3 = e4;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw e3;
                    }
                } catch (IOException e5) {
                    e3 = e5;
                    fileOutputStream2 = null;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e3;
                }
            } catch (IOException e32) {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e32;
            } catch (Exception e6) {
                e2 = e6;
                inputStream = fileInputStream;
                try {
                    C2538c.m12674b("CloudUtil", "=======DownloadThread run error!!!  e:" + e2.getMessage());
                    this.f4791a.m8474a(this.f4792b, 3, this.f4797g);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e322) {
                            C2538c.m12680e("CloudUtil", "=======DownloadThread run error!!!  e1:" + e322.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = inputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                            C2538c.m12680e("CloudUtil", "=======DownloadThread run error!!!  e1:" + e7.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (IOException e3222) {
            fileOutputStream.close();
            throw e3222;
        } catch (Exception e8) {
            e2 = e8;
            C2538c.m12674b("CloudUtil", "=======DownloadThread run error!!!  e:" + e2.getMessage());
            this.f4791a.m8474a(this.f4792b, 3, this.f4797g);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
