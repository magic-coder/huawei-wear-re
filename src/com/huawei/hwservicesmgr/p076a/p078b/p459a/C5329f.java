package com.huawei.hwservicesmgr.p076a.p078b.p459a;

import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileUtil */
public class C5329f {
    public static boolean m25801a(String str) {
        C2538c.b("FileUtil", new Object[]{" == isFileExists filepath  " + str});
        if (str == null) {
            C2538c.b("FileUtil", new Object[]{" == isFileExists filepath = null"});
            return false;
        } else if (new File(str).exists()) {
            C2538c.b("FileUtil", new Object[]{" == isFileExists return true"});
            return true;
        } else {
            C2538c.b("FileUtil", new Object[]{" == isFileExists return false"});
            return false;
        }
    }

    public static long m25800a(File file, long j, int i) {
        FileNotFoundException fileNotFoundException;
        IOException iOException;
        Throwable th;
        C5326c.m25781k().clear();
        long j2 = 0;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2;
        try {
            if (file.exists()) {
                fileInputStream2 = new FileInputStream(file);
                try {
                    C5326c.m25770e(fileInputStream2.available());
                    long g = (long) C5326c.m25773g();
                    try {
                        Object obj = new byte[i];
                        while (true) {
                            int read = fileInputStream2.read(obj);
                            if (-1 == read) {
                                break;
                            } else if (read != i) {
                                Object obj2 = new byte[read];
                                System.arraycopy(obj, 0, obj2, 0, read);
                                C2538c.c("FileUtil", new Object[]{"getFileSize data = " + C0973a.a(obj2) + " num = " + read});
                                C2538c.c("FileUtil", new Object[]{"getFileSize data_clone = " + C0973a.a((byte[]) obj2.clone()) + " num = " + read});
                                C5326c.m25781k().add(r0);
                            } else {
                                C2538c.c("FileUtil", new Object[]{"getFileSize info = " + C0973a.a(obj) + " num = " + read});
                                C2538c.c("FileUtil", new Object[]{"getFileSize info_clone = " + C0973a.a((byte[]) obj.clone()) + " num = " + read});
                                C5326c.m25781k().add(r0);
                            }
                        }
                        C2538c.c("FileUtil", new Object[]{"getFileSize fileInfoList.size() = " + C5326c.m25781k().size()});
                        if (fileInputStream2 == null) {
                            return g;
                        }
                        try {
                            fileInputStream2.close();
                            return g;
                        } catch (IOException e) {
                            C2538c.e("FileUtil", new Object[]{"loadCertificates Exception:" + e.getMessage()});
                            return g;
                        }
                    } catch (FileNotFoundException e2) {
                        FileNotFoundException fileNotFoundException2 = e2;
                        j2 = g;
                        fileInputStream = fileInputStream2;
                        fileNotFoundException = fileNotFoundException2;
                    } catch (IOException e3) {
                        IOException iOException2 = e3;
                        j2 = g;
                        iOException = iOException2;
                    }
                } catch (FileNotFoundException e4) {
                    fileNotFoundException = e4;
                    fileInputStream = fileInputStream2;
                    try {
                        C2538c.e("FileUtil", new Object[]{" getFileSize FileNotFoundException e : " + fileNotFoundException.getMessage()});
                        if (fileInputStream != null) {
                            return j2;
                        }
                        try {
                            fileInputStream.close();
                            return j2;
                        } catch (IOException iOException3) {
                            C2538c.e("FileUtil", new Object[]{"loadCertificates Exception:" + iOException3.getMessage()});
                            return j2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e5) {
                                C2538c.e("FileUtil", new Object[]{"loadCertificates Exception:" + e5.getMessage()});
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    iOException3 = e6;
                    try {
                        C2538c.e("FileUtil", new Object[]{" getFileSize IOException e : " + iOException3.getMessage()});
                        if (fileInputStream2 != null) {
                            return j2;
                        }
                        try {
                            fileInputStream2.close();
                            return j2;
                        } catch (IOException iOException32) {
                            C2538c.e("FileUtil", new Object[]{"loadCertificates Exception:" + iOException32.getMessage()});
                            return j2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        throw th;
                    }
                }
            } else if (fileInputStream == null) {
                return j2;
            } else {
                try {
                    fileInputStream.close();
                    return j2;
                } catch (IOException iOException322) {
                    C2538c.e("FileUtil", new Object[]{"loadCertificates Exception:" + iOException322.getMessage()});
                    return j2;
                }
            }
        } catch (FileNotFoundException e7) {
            fileNotFoundException = e7;
            C2538c.e("FileUtil", new Object[]{" getFileSize FileNotFoundException e : " + fileNotFoundException.getMessage()});
            if (fileInputStream != null) {
                return j2;
            }
            fileInputStream.close();
            return j2;
        } catch (IOException e8) {
            iOException322 = e8;
            fileInputStream2 = fileInputStream;
            C2538c.e("FileUtil", new Object[]{" getFileSize IOException e : " + iOException322.getMessage()});
            if (fileInputStream2 != null) {
                return j2;
            }
            fileInputStream2.close();
            return j2;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }
}
