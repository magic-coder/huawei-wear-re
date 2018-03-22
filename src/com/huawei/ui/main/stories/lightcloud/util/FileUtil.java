package com.huawei.ui.main.stories.lightcloud.util;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.ui.main.stories.lightcloud.data.LightCloudObject;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudCallBack;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudHttpCallBack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;

public class FileUtil {
    private static final String TAG = "UIDV_FileUtil";
    private static volatile FileUtil instance = null;
    private Context mContext;

    public static FileUtil getInstance(Context context) {
        C2538c.m12677c(TAG, "getInstance");
        if (instance == null) {
            synchronized (FileUtil.class) {
                if (instance == null) {
                    instance = new FileUtil(context);
                }
            }
        }
        return instance;
    }

    private FileUtil(Context context) {
        C2538c.m12677c(TAG, "FileUtil");
        this.mContext = context.getApplicationContext();
    }

    public void doDownload(LightCloudObject lightCloudObject, final LightCloudHttpCallBack lightCloudHttpCallBack) {
        C2538c.m12677c(TAG, "doDownload");
        if (lightCloudObject == null) {
            C2538c.m12677c(TAG, "lightCloudObject is null");
            return;
        }
        String fileId = lightCloudObject.getFileId();
        final String downloadUrl = lightCloudObject.getDownloadUrl();
        if (fileId == null || fileId.equals("")) {
            C2538c.m12677c(TAG, "fileId is null");
        } else if (downloadUrl == null || downloadUrl.equals("")) {
            C2538c.m12677c(TAG, "downloadUrl is null");
        } else {
            fileId = this.mContext.getFilesDir().getAbsolutePath() + File.separator + LightCloudConstants.DOWNLOAD_DIR + File.separator + fileId;
            if (fileId == null || fileId.equals("")) {
                C2538c.m12677c(TAG, "savePath is null");
                return;
            }
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                public void run() {
                    FileUtil.this.download(downloadUrl, fileId, lightCloudHttpCallBack);
                }
            });
        }
    }

    private void download(String str, String str2, LightCloudHttpCallBack lightCloudHttpCallBack) {
        InputStream inputStream;
        int i;
        String str3;
        MalformedURLException e;
        Throwable th;
        int i2;
        IOException e2;
        MalformedURLException malformedURLException;
        IOException iOException;
        Throwable th2;
        C2538c.m12677c(TAG, "download");
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream = null;
        int i3 = -1;
        String str4 = LightCloudConstants.DOWNLOAD_FAIL;
        FileOutputStream fileOutputStream2;
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(str);
            if (url.getProtocol().toLowerCase(Locale.US).equals("https")) {
                C2538c.m12677c(TAG, "https");
                httpURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
            int responseCode = httpURLConnection.getResponseCode();
            try {
                int i4;
                C2538c.m12677c(TAG, "resCode = ", Integer.valueOf(responseCode));
                if (200 == responseCode) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        C2538c.m12677c(TAG, "saveFile");
                        int lastIndexOf = str2.lastIndexOf(47);
                        String fileDir = getFileDir(str2, lastIndexOf);
                        if (createFileDir(str2)) {
                            C2538c.m12674b(TAG, "savePath = " + str2);
                            String str5 = str2 + LightCloudConstants.ZIP_POSTFIX;
                            C2538c.m12674b(TAG, "zipPath = " + str5);
                            File file = new File(str5);
                            String substring = str5.substring(lastIndexOf + 1, str5.length());
                            C2538c.m12677c(TAG, "fileName = " + substring);
                            File file2 = new File(fileDir + File.separator + HwAccountConstants.SPLIIT_UNDERLINE + substring);
                            fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                fileOutputStream2.flush();
                                boolean renameTo = file2.renameTo(file);
                                C2538c.m12677c(TAG, "isRenameOk = " + renameTo);
                                if (renameTo) {
                                    i = 0;
                                    str3 = LightCloudConstants.RESPONSE_RESULT_SUCCESS;
                                    i4 = 0;
                                    fileOutputStream = fileOutputStream2;
                                    inputStream2 = inputStream;
                                } else {
                                    if (file2.exists()) {
                                        renameTo = file2.delete();
                                        C2538c.m12677c(TAG, "deleteRet = " + renameTo);
                                    }
                                    i = -1;
                                    try {
                                        str3 = "rename fail";
                                        i4 = -1;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream2 = inputStream;
                                    } catch (MalformedURLException e3) {
                                        e = e3;
                                        try {
                                            C2538c.m12677c(TAG, "MalformedURLException e = ", e.getMessage());
                                            i = -1;
                                            str3 = e.getMessage();
                                            closeInputStream(inputStream);
                                            closeFileOutputStream(fileOutputStream2);
                                            lightCloudHttpCallBack.onResponce(-1, str3);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            i2 = i;
                                            fileOutputStream = fileOutputStream2;
                                            inputStream2 = inputStream;
                                            i3 = i2;
                                            closeInputStream(inputStream2);
                                            closeFileOutputStream(fileOutputStream);
                                            lightCloudHttpCallBack.onResponce(i3, str4);
                                            throw th;
                                        }
                                    } catch (IOException e4) {
                                        e2 = e4;
                                        i2 = i;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream2 = inputStream;
                                        i3 = i2;
                                        try {
                                            C2538c.m12677c(TAG, "IOException e = ", e2.getMessage());
                                            i3 = -1;
                                            str3 = e2.getMessage();
                                            closeInputStream(inputStream2);
                                            closeFileOutputStream(fileOutputStream);
                                            lightCloudHttpCallBack.onResponce(-1, str3);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            closeInputStream(inputStream2);
                                            closeFileOutputStream(fileOutputStream);
                                            lightCloudHttpCallBack.onResponce(i3, str4);
                                            throw th;
                                        }
                                    }
                                }
                            } catch (MalformedURLException e5) {
                                malformedURLException = e5;
                                i = responseCode;
                                e = malformedURLException;
                                C2538c.m12677c(TAG, "MalformedURLException e = ", e.getMessage());
                                i = -1;
                                str3 = e.getMessage();
                                closeInputStream(inputStream);
                                closeFileOutputStream(fileOutputStream2);
                                lightCloudHttpCallBack.onResponce(-1, str3);
                            } catch (IOException e6) {
                                iOException = e6;
                                fileOutputStream = fileOutputStream2;
                                inputStream2 = inputStream;
                                i3 = responseCode;
                                e2 = iOException;
                                C2538c.m12677c(TAG, "IOException e = ", e2.getMessage());
                                i3 = -1;
                                str3 = e2.getMessage();
                                closeInputStream(inputStream2);
                                closeFileOutputStream(fileOutputStream);
                                lightCloudHttpCallBack.onResponce(-1, str3);
                            } catch (Throwable th5) {
                                th2 = th5;
                                fileOutputStream = fileOutputStream2;
                                inputStream2 = inputStream;
                                i3 = responseCode;
                                th = th2;
                                closeInputStream(inputStream2);
                                closeFileOutputStream(fileOutputStream);
                                lightCloudHttpCallBack.onResponce(i3, str4);
                                throw th;
                            }
                        }
                        C2538c.m12677c(TAG, "createFileDir false");
                        closeInputStream(inputStream);
                        closeFileOutputStream(null);
                        lightCloudHttpCallBack.onResponce(responseCode, str4);
                        return;
                    } catch (MalformedURLException e7) {
                        malformedURLException = e7;
                        fileOutputStream2 = null;
                        i = responseCode;
                        e = malformedURLException;
                        C2538c.m12677c(TAG, "MalformedURLException e = ", e.getMessage());
                        i = -1;
                        str3 = e.getMessage();
                        closeInputStream(inputStream);
                        closeFileOutputStream(fileOutputStream2);
                        lightCloudHttpCallBack.onResponce(-1, str3);
                    } catch (IOException e8) {
                        iOException = e8;
                        inputStream2 = inputStream;
                        i3 = responseCode;
                        e2 = iOException;
                        C2538c.m12677c(TAG, "IOException e = ", e2.getMessage());
                        i3 = -1;
                        str3 = e2.getMessage();
                        closeInputStream(inputStream2);
                        closeFileOutputStream(fileOutputStream);
                        lightCloudHttpCallBack.onResponce(-1, str3);
                    } catch (Throwable th6) {
                        th2 = th6;
                        inputStream2 = inputStream;
                        i3 = responseCode;
                        th = th2;
                        closeInputStream(inputStream2);
                        closeFileOutputStream(fileOutputStream);
                        lightCloudHttpCallBack.onResponce(i3, str4);
                        throw th;
                    }
                }
                String str6 = str4;
                i4 = responseCode;
                str3 = str6;
                closeInputStream(inputStream2);
                closeFileOutputStream(fileOutputStream);
                lightCloudHttpCallBack.onResponce(i4, str3);
            } catch (MalformedURLException e9) {
                malformedURLException = e9;
                inputStream = null;
                fileOutputStream2 = null;
                i = responseCode;
                e = malformedURLException;
                C2538c.m12677c(TAG, "MalformedURLException e = ", e.getMessage());
                i = -1;
                str3 = e.getMessage();
                closeInputStream(inputStream);
                closeFileOutputStream(fileOutputStream2);
                lightCloudHttpCallBack.onResponce(-1, str3);
            } catch (IOException e10) {
                iOException = e10;
                i3 = responseCode;
                e2 = iOException;
                C2538c.m12677c(TAG, "IOException e = ", e2.getMessage());
                i3 = -1;
                str3 = e2.getMessage();
                closeInputStream(inputStream2);
                closeFileOutputStream(fileOutputStream);
                lightCloudHttpCallBack.onResponce(-1, str3);
            } catch (Throwable th7) {
                th2 = th7;
                i3 = responseCode;
                th = th2;
                closeInputStream(inputStream2);
                closeFileOutputStream(fileOutputStream);
                lightCloudHttpCallBack.onResponce(i3, str4);
                throw th;
            }
        } catch (MalformedURLException e11) {
            e = e11;
            inputStream = null;
            fileOutputStream2 = null;
            i = -1;
            C2538c.m12677c(TAG, "MalformedURLException e = ", e.getMessage());
            i = -1;
            str3 = e.getMessage();
            closeInputStream(inputStream);
            closeFileOutputStream(fileOutputStream2);
            lightCloudHttpCallBack.onResponce(-1, str3);
        } catch (IOException e12) {
            e2 = e12;
            C2538c.m12677c(TAG, "IOException e = ", e2.getMessage());
            i3 = -1;
            str3 = e2.getMessage();
            closeInputStream(inputStream2);
            closeFileOutputStream(fileOutputStream);
            lightCloudHttpCallBack.onResponce(-1, str3);
        }
    }

    public void doUnZip(LightCloudObject lightCloudObject, LightCloudCallBack lightCloudCallBack) {
        C2538c.m12677c(TAG, "Enter doUnZip ");
        if (lightCloudObject == null) {
            C2538c.m12677c(TAG, "lightCloudObject is null");
            return;
        }
        C2538c.m12677c(TAG, "lightCloudObject:" + lightCloudObject.toString());
        String fileId = lightCloudObject.getFileId();
        if (fileId == null || fileId.equals("")) {
            C2538c.m12677c(TAG, "fileId is null");
            return;
        }
        String ver = lightCloudObject.getVer();
        if (ver == null || ver.equals("")) {
            C2538c.m12677c(TAG, "ver is null");
            return;
        }
        final String str = BaseApplication.m2632b().getFilesDir().getAbsolutePath() + File.separator + LightCloudConstants.DOWNLOAD_DIR + File.separator + fileId + LightCloudConstants.ZIP_POSTFIX;
        final String str2 = BaseApplication.m2632b().getFilesDir().getAbsolutePath() + File.separator + LightCloudConstants.DOWNLOAD_DIR + File.separator + fileId;
        final LightCloudObject lightCloudObject2 = lightCloudObject;
        final LightCloudCallBack lightCloudCallBack2 = lightCloudCallBack;
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                FileUtil.this.UnZip(str, str2, lightCloudObject2, lightCloudCallBack2);
            }
        });
    }

    private void UnZip(String str, String str2, LightCloudObject lightCloudObject, LightCloudCallBack lightCloudCallBack) {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        FileNotFoundException e;
        IOException e2;
        IllegalArgumentException e3;
        Exception e4;
        Throwable th;
        C2538c.m12677c(TAG, "UnZip");
        FileInputStream fileInputStream2 = null;
        ZipInputStream zipInputStream2 = null;
        FileOutputStream fileOutputStream = null;
        int i = 0;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(fileInputStream);
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        C2538c.m12677c(TAG, "szName=" + name);
                        boolean createFileDir;
                        if (nextEntry.isDirectory()) {
                            C2538c.m12677c(TAG, "zipEntry.isDirectory()");
                            createFileDir = createFileDir(str2 + File.separator + name.substring(0, name.length() - 1));
                            C2538c.m12677c(TAG, "mkdir status=" + createFileDir);
                        } else {
                            C2538c.m12677c(TAG, "zipEntry.isFile");
                            File file = new File(str2 + File.separator + name);
                            File parentFile = file.getParentFile();
                            if (!parentFile.exists()) {
                                createFileDir = parentFile.mkdirs();
                                C2538c.m12677c(TAG, "parentFile mkdir status=" + createFileDir);
                            }
                            createFileDir = file.createNewFile();
                            C2538c.m12677c(TAG, "result = ", Boolean.valueOf(createFileDir));
                            closeFileOutputStream(fileOutputStream);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                    fileOutputStream2.flush();
                                }
                                fileOutputStream = fileOutputStream2;
                            } catch (FileNotFoundException e5) {
                                e = e5;
                                fileOutputStream = fileOutputStream2;
                                zipInputStream2 = zipInputStream;
                                fileInputStream2 = fileInputStream;
                            } catch (IOException e6) {
                                e2 = e6;
                                fileOutputStream = fileOutputStream2;
                            } catch (IllegalArgumentException e7) {
                                e3 = e7;
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e8) {
                                e4 = e8;
                                fileOutputStream = fileOutputStream2;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        zipInputStream2 = zipInputStream;
                        fileInputStream2 = fileInputStream;
                    } catch (IOException e10) {
                        e2 = e10;
                    } catch (IllegalArgumentException e11) {
                        e3 = e11;
                    } catch (Exception e12) {
                        e4 = e12;
                    }
                }
                closeFileInputStream(fileInputStream);
                closeZipInputStream(zipInputStream);
                closeFileOutputStream(fileOutputStream);
            } catch (FileNotFoundException e13) {
                e = e13;
                fileInputStream2 = fileInputStream;
                try {
                    C2538c.m12677c(TAG, "FileNotFoundException:" + e.getMessage());
                    i = -3;
                    closeFileInputStream(fileInputStream2);
                    closeZipInputStream(zipInputStream2);
                    closeFileOutputStream(fileOutputStream);
                    if (new File(str2).isDirectory()) {
                    }
                    C2538c.m12677c(TAG, "unZip and the dir fail");
                    lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    zipInputStream = zipInputStream2;
                    closeFileInputStream(fileInputStream);
                    closeZipInputStream(zipInputStream);
                    closeFileOutputStream(fileOutputStream);
                    throw th;
                }
            } catch (IOException e14) {
                e2 = e14;
                zipInputStream = null;
                try {
                    C2538c.m12677c(TAG, "IOException:" + e2.getMessage());
                    i = -3;
                    closeFileInputStream(fileInputStream);
                    closeZipInputStream(zipInputStream);
                    closeFileOutputStream(fileOutputStream);
                    if (new File(str2).isDirectory()) {
                    }
                    C2538c.m12677c(TAG, "unZip and the dir fail");
                    lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    closeFileInputStream(fileInputStream);
                    closeZipInputStream(zipInputStream);
                    closeFileOutputStream(fileOutputStream);
                    throw th;
                }
            } catch (IllegalArgumentException e15) {
                e3 = e15;
                zipInputStream = null;
                C2538c.m12677c(TAG, "IllegalArgumentException:" + e3.getMessage());
                i = -3;
                closeFileInputStream(fileInputStream);
                closeZipInputStream(zipInputStream);
                closeFileOutputStream(fileOutputStream);
                if (new File(str2).isDirectory()) {
                }
                C2538c.m12677c(TAG, "unZip and the dir fail");
                lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
                return;
            } catch (Exception e16) {
                e4 = e16;
                zipInputStream = null;
                C2538c.m12677c(TAG, "Exception:" + e4.getMessage());
                i = -3;
                closeFileInputStream(fileInputStream);
                closeZipInputStream(zipInputStream);
                closeFileOutputStream(fileOutputStream);
                if (new File(str2).isDirectory()) {
                }
                C2538c.m12677c(TAG, "unZip and the dir fail");
                lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
                return;
            } catch (Throwable th5) {
                th = th5;
                zipInputStream = null;
                closeFileInputStream(fileInputStream);
                closeZipInputStream(zipInputStream);
                closeFileOutputStream(fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e17) {
            e = e17;
            C2538c.m12677c(TAG, "FileNotFoundException:" + e.getMessage());
            i = -3;
            closeFileInputStream(fileInputStream2);
            closeZipInputStream(zipInputStream2);
            closeFileOutputStream(fileOutputStream);
            if (new File(str2).isDirectory()) {
            }
            C2538c.m12677c(TAG, "unZip and the dir fail");
            lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
            return;
        } catch (IOException e18) {
            e2 = e18;
            fileInputStream = null;
            zipInputStream = null;
            C2538c.m12677c(TAG, "IOException:" + e2.getMessage());
            i = -3;
            closeFileInputStream(fileInputStream);
            closeZipInputStream(zipInputStream);
            closeFileOutputStream(fileOutputStream);
            if (new File(str2).isDirectory()) {
            }
            C2538c.m12677c(TAG, "unZip and the dir fail");
            lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
            return;
        } catch (IllegalArgumentException e19) {
            e3 = e19;
            fileInputStream = null;
            zipInputStream = null;
            C2538c.m12677c(TAG, "IllegalArgumentException:" + e3.getMessage());
            i = -3;
            closeFileInputStream(fileInputStream);
            closeZipInputStream(zipInputStream);
            closeFileOutputStream(fileOutputStream);
            if (new File(str2).isDirectory()) {
            }
            C2538c.m12677c(TAG, "unZip and the dir fail");
            lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
            return;
        } catch (Exception e20) {
            e4 = e20;
            fileInputStream = null;
            zipInputStream = null;
            C2538c.m12677c(TAG, "Exception:" + e4.getMessage());
            i = -3;
            closeFileInputStream(fileInputStream);
            closeZipInputStream(zipInputStream);
            closeFileOutputStream(fileOutputStream);
            if (new File(str2).isDirectory()) {
            }
            C2538c.m12677c(TAG, "unZip and the dir fail");
            lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
            return;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            zipInputStream = null;
            closeFileInputStream(fileInputStream);
            closeZipInputStream(zipInputStream);
            closeFileOutputStream(fileOutputStream);
            throw th;
        }
        if (new File(str2).isDirectory() || i != 0) {
            C2538c.m12677c(TAG, "unZip and the dir fail");
            lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -3);
            return;
        }
        C2538c.m12677c(TAG, "unZip finish");
        C0996a.m3611a(this.mContext, String.valueOf(10000), lightCloudObject.getFileId(), lightCloudObject.getVer(), new C0993c());
        lightCloudCallBack.onResponce(lightCloudObject.getFileId(), i);
    }

    private static String getFileDir(String str, int i) {
        try {
            return str.substring(0, i);
        } catch (StringIndexOutOfBoundsException e) {
            C2538c.m12677c(TAG, "StringIndexOutOfBoundsException:" + e.getMessage());
            return null;
        }
    }

    private static boolean createFileDir(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            String str2 = TAG;
            Object[] objArr = new Object[1];
            objArr[0] = "mkdirRet:" + (mkdirs ? "sucess" : LightCloudConstants.RESPONSE_RESULT_FAIL);
            C2538c.m12677c(str2, objArr);
            if (!mkdirs) {
                return false;
            }
        }
        return true;
    }

    private static void closeInputStream(InputStream inputStream) {
        C2538c.m12677c(TAG, "closeInputStream");
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException:" + e.getMessage());
            }
        }
    }

    private static void closeFileOutputStream(FileOutputStream fileOutputStream) {
        C2538c.m12677c(TAG, "closeFileOutputStream");
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException:" + e.getMessage());
            }
        }
    }

    private static void closeFileInputStream(FileInputStream fileInputStream) {
        C2538c.m12677c(TAG, "closeFileOutputStream");
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException:" + e.getMessage());
            }
        }
    }

    private static void closeZipInputStream(ZipInputStream zipInputStream) {
        C2538c.m12677c(TAG, "closeZipInputStream");
        if (zipInputStream != null) {
            try {
                zipInputStream.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException:" + e.getMessage());
            }
        }
    }
}
