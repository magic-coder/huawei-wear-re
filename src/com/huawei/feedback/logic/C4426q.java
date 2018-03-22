package com.huawei.feedback.logic;

import android.text.TextUtils;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: UploadFile */
public class C4426q {
    public static int m21275a(String str, String str2, DataOutputStream dataOutputStream) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        FileInputStream a = C4426q.m21277a(str);
        if (a == null) {
            return 0;
        }
        byte[] bArr = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------40612316912668\r\n");
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append("screenshot");
        stringBuilder.append("\"; filename=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        stringBuilder.append("\r\n");
        stringBuilder.append("Content-Type: ");
        if (TextUtils.isEmpty(str2)) {
            stringBuilder.append("image/jpeg");
        } else {
            stringBuilder.append(str2);
        }
        stringBuilder.append("\r\n");
        stringBuilder.append("\r\n");
        try {
            dataOutputStream.write(stringBuilder.toString().getBytes("utf-8"));
            while (true) {
                int read = a.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
            }
            dataOutputStream.write("\r\n".getBytes("utf-8"));
            return i;
        } catch (IOException e) {
            i = 1010;
            return i;
        } finally {
            C5767b.m26473a(a, "UploadFile");
        }
    }

    public static FileInputStream m21277a(String str) {
        try {
            return new FileInputStream(str);
        } catch (FileNotFoundException e) {
            c.d("UploadFile", "FileNotFoundException ...");
            return null;
        }
    }

    public static int m21279b(String str, String str2, DataOutputStream dataOutputStream) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return 0;
        }
        c.b("UploadFile", "key:" + str + " value:" + str2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------40612316912668\r\n");
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        stringBuilder.append("\r\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(str2);
        stringBuilder.append("\r\n");
        try {
            dataOutputStream.write(stringBuilder.toString().getBytes("utf-8"));
            return 0;
        } catch (IOException e) {
            return 1010;
        }
    }

    public static int m21276a(boolean z, DataOutputStream dataOutputStream, String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        FileInputStream a = C4426q.m21277a(str);
        if (a == null) {
            return 0;
        }
        try {
            if (a.available() <= 0) {
                C5767b.m26473a(a, "UploadFile");
                return 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-----------------------------40612316912668\r\n");
            if (z) {
                stringBuilder.append("Content-Disposition: form-data; name=\"");
                stringBuilder.append("problemRecord");
                stringBuilder.append("\"; filename=\"");
                stringBuilder.append(str);
                stringBuilder.append("\"");
                stringBuilder.append("\r\n");
            }
            stringBuilder.append("Content-Type: application/zip");
            stringBuilder.append("\r\n");
            stringBuilder.append("\r\n");
            byte[] bArr = new byte[1024];
            try {
                dataOutputStream.write(stringBuilder.toString().getBytes("utf-8"));
                while (true) {
                    int read = a.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                dataOutputStream.write("\r\n".getBytes("utf-8"));
                return i;
            } catch (IOException e) {
                i = 1010;
                return i;
            } finally {
                C5767b.m26473a(a, "UploadFile");
            }
        } catch (IOException e2) {
            C5767b.m26473a(a, "UploadFile");
            return 0;
        }
    }

    public static int m21274a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.write("-----------------------------40612316912668--\r\n".getBytes("utf-8"));
            return 0;
        } catch (IOException e) {
            return 1010;
        }
    }

    public static String m21278a(String[] strArr) {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        IOException e;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        if (strArr == null) {
            return "";
        }
        String a = com.huawei.feedback.c.a();
        if (a == null) {
            c.d("UploadFile", "storagePath null!");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(a);
        stringBuilder.append("/phoneservice/image");
        File file = new File(stringBuilder.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        int i;
        File[] fileArr;
        stringBuilder.append('/').append(com.huawei.feedback.c.b()).append(LightCloudConstants.ZIP_POSTFIX);
        a = stringBuilder.toString();
        File file2 = new File(a);
        int length = strArr.length;
        if (length > 0) {
            File[] fileArr2 = new File[length];
            for (i = 0; i < length; i++) {
                c.b("UploadFile", UploadFile.FILE_NAME + strArr[i]);
                fileArr2[i] = new File(strArr[i]);
            }
            fileArr = fileArr2;
        } else {
            fileArr = null;
        }
        if (fileArr == null || fileArr.length > 4) {
            return "";
        }
        byte[] bArr = new byte[1024];
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            i = 0;
            while (i < fileArr.length) {
                try {
                    if (fileArr[i] != null && fileArr[i].length() <= 5242880) {
                        try {
                            c.d("UploadFile", "srcThirdFile[" + i + "]" + fileArr[i].toString());
                            fileInputStream = new FileInputStream(fileArr[i]);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(fileArr[i].getName()));
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                zipOutputStream.closeEntry();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        c.d("UploadFile", "IOException two...");
                                    }
                                } else {
                                    continue;
                                }
                            } catch (FileNotFoundException e3) {
                            } catch (IOException e4) {
                                e = e4;
                                fileInputStream2 = fileInputStream;
                            }
                        } catch (FileNotFoundException e5) {
                            fileInputStream = null;
                        } catch (IOException e6) {
                            e = e6;
                        }
                    }
                    i++;
                } catch (FileNotFoundException e7) {
                    r2 = zipOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (zipOutputStream == null) {
                return a;
            }
            try {
                zipOutputStream.close();
                return a;
            } catch (IOException e8) {
                c.d("UploadFile", "IOException three...");
                return a;
            }
        } catch (FileNotFoundException e9) {
            ZipOutputStream zipOutputStream2;
            try {
                a = "";
                if (zipOutputStream2 == null) {
                    return a;
                }
                try {
                    zipOutputStream2.close();
                    return a;
                } catch (IOException e10) {
                    c.d("UploadFile", "IOException three...");
                    return a;
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e11) {
                        c.d("UploadFile", "IOException three...");
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream = null;
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            throw th;
        }
        try {
            c.d("UploadFile", "IOException one..." + e.toString());
            a = "";
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e12) {
                    c.d("UploadFile", "IOException two...");
                }
            }
            if (zipOutputStream != null) {
                return a;
            }
            try {
                zipOutputStream.close();
                return a;
            } catch (IOException e13) {
                c.d("UploadFile", "IOException three...");
                return a;
            }
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e14) {
                    c.d("UploadFile", "IOException two...");
                }
            }
            throw th;
        }
        if (zipOutputStream != null) {
            return a;
        }
        zipOutputStream.close();
        return a;
        if (zipOutputStream != null) {
            return a;
        }
        try {
            zipOutputStream.close();
            return a;
        } catch (IOException e15) {
            c.d("UploadFile", "IOException three...");
            return a;
        }
        try {
            c.d("UploadFile", "FileNotFoundException ...");
            a = "";
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e16) {
                    c.d("UploadFile", "IOException two...");
                }
            }
            if (zipOutputStream != null) {
                return a;
            }
            zipOutputStream.close();
            return a;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }
}
