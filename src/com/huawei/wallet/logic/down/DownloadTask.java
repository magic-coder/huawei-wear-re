package com.huawei.wallet.logic.down;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.format.Formatter;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.wallet.storage.path.PayStorageUtil;
import com.huawei.wallet.utils.log.LogC;
import com.huawei.wallet.utils.log.LogErrorConstant;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class DownloadTask extends Thread {
    protected volatile boolean f21235a = false;
    private URL f21236b;
    private String f21237c;
    private String f21238d;
    private String f21239e;
    private long f21240f = 0;
    private long f21241g = 0;
    private long f21242h = 0;
    private long f21243i = 0;
    private IDownloadTaskListener f21244j;
    private HttpURLConnection f21245k;
    private BufferedInputStream f21246l;
    private String f21247m = UUID.randomUUID().toString();
    private DownloadEntity f21248n;
    private Handler f21249o;

    class ProgressRefreshHandler extends Handler {
        private DownloadTask f21234a;

        public ProgressRefreshHandler(Looper looper, DownloadTask downloadTask) {
            super(looper);
            this.f21234a = downloadTask;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.f21234a != null) {
                this.f21234a.m28027a(message);
            }
        }
    }

    protected void m28040a() {
        this.f21235a = true;
        LogC.m28530b("DownloadTask cancel download task", false);
    }

    protected boolean m28041b() {
        return !this.f21235a;
    }

    private void m28031g() throws IOException {
        if (m28029a(this.f21237c)) {
            LogC.m28530b("DownloadTask delete file success", false);
            if (m28029a(this.f21238d)) {
                LogC.m28530b("DownloadTask delete tmp file success", false);
                return;
            } else {
                LogC.m28522a(" DownloadTask delete tmp  file fail", 907118021, LogErrorConstant.m28535a("DownloadTask.deleteExistFile", this.f21238d), false);
                throw new IOException("DownloadTask download delete temp file failed");
            }
        }
        LogC.m28522a(" DownloadTask delete file fail", 907118021, LogErrorConstant.m28535a("DownloadTask.deleteExistFile", this.f21237c), false);
        throw new IOException("DownloadTask download delete exist file failed");
    }

    private void m28032h() {
        if (this.f21246l != null) {
            try {
                this.f21246l.close();
            } catch (Throwable e) {
                LogC.m28529b(getName() + "; buffer input stream close failed,", e, false);
            }
        }
        if (this.f21245k != null) {
            this.f21245k.disconnect();
        }
    }

    private void m28033i() throws IOException {
        LogC.m28527a("DownloadTask download task prepareDownload", false);
        this.f21245k = (HttpURLConnection) this.f21236b.openConnection();
        this.f21245k.setConnectTimeout(10000);
        this.f21245k.setReadTimeout(20000);
        int responseCode = this.f21245k.getResponseCode();
        if (200 != responseCode) {
            LogC.m28522a(" DownloadTask down getresponsecode err.", 907118057, LogErrorConstant.m28535a("DownloadTask.prepareDownload", "url:" + this.f21236b.toString() + " code:" + responseCode), false);
            m28037m();
            return;
        }
        this.f21240f = (long) this.f21245k.getContentLength();
        this.f21248n.m28015a(this.f21240f);
        if (this.f21240f < 0) {
            m28037m();
            return;
        }
        this.f21249o.sendEmptyMessage(6000);
        m28034j();
        m28031g();
        LogC.m28527a(getName() + "; connected to server!", false);
    }

    private void m28034j() {
        String str = null;
        int lastIndexOf = this.f21248n.m28017b().lastIndexOf("/");
        if (-1 != lastIndexOf) {
            str = this.f21248n.m28017b().substring(lastIndexOf + 1);
        }
        if (StringUtil.m28046a(str, true)) {
            str = UUID.randomUUID().toString() + ".apk";
        }
        this.f21237c = str;
        this.f21238d = str + ".tmp";
        File file = new File(m28030b(this.f21237c));
        if (file != null) {
            try {
                this.f21239e = file.getCanonicalPath();
                if (StringUtil.m28046a(this.f21239e, true)) {
                    LogC.m28522a(" DownloadTask filepath isempty.", 907118023, LogErrorConstant.m28535a("DownloadTask.setFileInfo", null), false);
                    throw new IOException("download file null , can not download file!");
                }
            } catch (Throwable e) {
                LogC.m28526a("get file path failed,", e, false);
            }
            this.f21248n.m28016a(this.f21239e);
        }
        LogC.m28527a("DownloadTask download fileName: " + this.f21237c, false);
    }

    private void m28035k() throws IOException {
        Throwable e;
        LogC.m28527a("DownloadTask download task readData", false);
        this.f21246l = new BufferedInputStream(this.f21245k.getInputStream());
        byte[] bArr = new byte[SupportMenu.USER_MASK];
        BufferedOutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(m28030b(this.f21238d))));
            while (true) {
                int read = this.f21246l.read(bArr);
                if (read <= 0) {
                    break;
                } else if (!m28041b()) {
                    break;
                } else {
                    try {
                        bufferedOutputStream.write(bArr, 0, read);
                        this.f21241g += (long) read;
                        this.f21243i = ((long) read) + this.f21243i;
                        this.f21249o.sendEmptyMessage(6000);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
            }
            LogC.m28527a(getName() + "; while(); download finish!", false);
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e3) {
                    LogC.m28526a("finally bos.close failed.", e3, false);
                }
            }
            LogC.m28527a(getName() + "; while end! ", false);
            LogC.m28527a(getName() + "; mDownloadedSize= " + this.f21241g, false);
        } catch (IOException e4) {
            e3 = e4;
            bufferedOutputStream = null;
            try {
                LogC.m28529b(getName() + "; read data IOException:", e3, false);
                throw e3;
            } catch (Throwable th) {
                e3 = th;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable e5) {
                        LogC.m28526a("finally bos.close failed.", e5, false);
                    }
                }
                throw e3;
            }
        } catch (Throwable th2) {
            e3 = th2;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e3;
        }
    }

    private boolean m28036l() {
        File file = new File(m28039o());
        File file2 = new File(m28030b(this.f21238d));
        if (!file2.exists()) {
            return false;
        }
        boolean renameTo = file2.renameTo(file);
        LogC.m28530b("reNameTmpFile isReNameSus= " + renameTo, false);
        return renameTo;
    }

    private boolean m28029a(String str) {
        if (StringUtil.m28046a(str, true)) {
            return true;
        }
        File file = new File(m28030b(str));
        if (file != null && file.exists()) {
            return file.delete();
        }
        LogC.m28530b("DownloadTask delete file not exist:" + str, false);
        return true;
    }

    public void m28042c() {
        if (m28029a(this.f21237c)) {
            LogC.m28530b("DownloadTask delete download file success", false);
        } else {
            LogC.m28530b("DownloadTask delete download file failed", false);
        }
    }

    private void m28037m() {
        m28029a(this.f21238d);
        m28042c();
        DownloadManager.m28022a().m28024a(m28045f(), this.f21244j, 30017);
    }

    private void m28027a(Message message) {
        switch (message.what) {
            case 6000:
                String str;
                if (this.f21242h == 0) {
                    str = m28026a(this.f21241g) + File.separator + m28026a(this.f21240f);
                } else if (this.f21243i != 0) {
                    str = m28026a(this.f21243i) + File.separator + m28026a(this.f21242h);
                } else {
                    str = m28026a(this.f21241g) + File.separator + m28026a(this.f21242h);
                }
                if (this.f21244j != null) {
                    this.f21244j.mo5142a(this.f21248n, str);
                    return;
                }
                return;
            case 50000:
                int n = m28038n();
                if (this.f21244j != null) {
                    this.f21244j.mo5141a(this.f21248n, n);
                }
                if (n < 100) {
                    message.getTarget().sendEmptyMessageDelayed(50000, 1000);
                    return;
                }
                return;
            case 50001:
                message.getTarget().removeMessages(50000);
                return;
            default:
                return;
        }
    }

    private int m28038n() {
        int intValue;
        if (this.f21242h != 0) {
            if (this.f21243i != 0) {
                intValue = Long.valueOf((this.f21243i * 100) / this.f21242h).intValue();
            } else {
                intValue = Long.valueOf((this.f21241g * 100) / this.f21242h).intValue();
            }
            LogC.m28527a(getName() + "; progress:  " + intValue + "   %", false);
            return intValue;
        } else if (this.f21240f > 0) {
            intValue = Long.valueOf((this.f21241g * 100) / this.f21240f).intValue();
            LogC.m28527a(getName() + "; progress:  " + intValue + "   %", false);
            return intValue;
        } else {
            LogC.m28527a(getName() + "; progress:  " + this.f21241g, false);
            return 0;
        }
    }

    private String m28026a(long j) {
        return Formatter.formatShortFileSize(BaseApplication.b().getApplicationContext(), j);
    }

    public Handler m28043d() {
        return this.f21249o;
    }

    protected DownloadTask(DownloadEntity downloadEntity, IDownloadTaskListener iDownloadTaskListener) {
        this.f21237c = downloadEntity.m28014a();
        this.f21240f = downloadEntity.m28018c();
        this.f21242h = downloadEntity.m28021f();
        this.f21243i = downloadEntity.m28020e();
        try {
            this.f21236b = new URL(downloadEntity.m28017b());
        } catch (MalformedURLException e) {
            LogC.m28532c("new downloadTask exception: " + e, false);
        }
        this.f21244j = iDownloadTaskListener;
        this.f21248n = downloadEntity;
        this.f21241g = 0;
        this.f21235a = false;
        ThreadLooperManager a = ThreadLooperManager.m28047a();
        Looper looper = null;
        if (a != null) {
            looper = a.m28048b();
        } else {
            LogC.m28527a("DownloadTask threadLooperManager is null.", false);
        }
        if (looper != null) {
            this.f21249o = new ProgressRefreshHandler(looper, this);
        } else {
            LogC.m28527a("DownloadTask looper is null.", false);
        }
    }

    public String m28044e() {
        return this.f21247m;
    }

    public DownloadEntity m28045f() {
        return this.f21248n;
    }

    public void run() {
        boolean z = true;
        boolean z2 = false;
        LogC.m28527a("download task thread run.", false);
        try {
            if (m28041b()) {
                DownloadManager.m28022a().m28024a(this.f21248n, this.f21244j, 20018);
                this.f21249o.sendEmptyMessage(50000);
                m28033i();
                m28035k();
                if (this.f21235a) {
                    LogC.m28530b("DownloadTask run download task cancel", false);
                    m28029a(this.f21238d);
                    m28037m();
                } else {
                    if (m28036l()) {
                        boolean z3;
                        LogC.m28530b("DownloadTask run downloadedSize= " + this.f21241g + "  fileSize= " + this.f21240f, false);
                        boolean z4 = this.f21241g == this.f21240f;
                        if (this.f21244j == null || !this.f21244j.mo5144b(this.f21248n)) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        LogC.m28530b("DownloadTask run isReadSizeSuccess = " + z4 + " isValidateSuccess = " + z3, false);
                        if (z4 && z3) {
                            LogC.m28530b("DownloadTask run isSuccess true.", false);
                            if (z) {
                                LogC.m28530b("DownloadTask run isSuccess false.", false);
                                m28037m();
                            } else {
                                DownloadManager.m28022a().m28024a(this.f21248n, this.f21244j, 20017);
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        LogC.m28530b("DownloadTask run isSuccess false.", false);
                        m28037m();
                    } else {
                        DownloadManager.m28022a().m28024a(this.f21248n, this.f21244j, 20017);
                    }
                }
                this.f21249o.sendEmptyMessage(50001);
                this.f21249o.removeCallbacksAndMessages(null);
                m28032h();
                LogC.m28527a("run download task thread over.", z2);
                return;
            }
            LogC.m28527a("DownloadTask download task finish at begining", false);
        } catch (Throwable e) {
            LogC.m28526a("download task IOException,", e, false);
            m28037m();
        } catch (Throwable e2) {
            LogC.m28526a("download task exception,", e2, false);
            m28037m();
        } finally {
            this.f21249o.sendEmptyMessage(50001);
            z2 = this.f21249o;
            z2.removeCallbacksAndMessages(null);
            m28032h();
        }
    }

    private String m28030b(String str) {
        File file = new File(PayStorageUtil.m28143d(BaseApplication.b().getApplicationContext()));
        if (!(file.exists() || file.mkdirs())) {
            LogC.m28534d("make cache dir failed", false);
        }
        return file.getAbsolutePath() + File.separator + str;
    }

    private String m28039o() {
        return m28030b(this.f21237c);
    }
}
