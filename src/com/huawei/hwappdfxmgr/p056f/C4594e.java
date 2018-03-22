package com.huawei.hwappdfxmgr.p056f;

import com.huawei.p190v.C2538c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: ZipUtil */
public class C4594e {
    public static void m21888a(Collection<File> collection, File file, String str, String str2) throws IOException {
        BufferedInputStream bufferedInputStream;
        IOException e;
        Exception e2;
        Throwable th;
        C2538c.b("ZipUtil", new Object[]{"==ww==zipFiles() size=" + collection.size()});
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File file2 : collection) {
            String str3;
            String name = file2.getName();
            C2538c.b("ZipUtil", new Object[]{"==ww==file.getName()=" + file2.getName()});
            try {
                str3 = new String(name.getBytes("8859_1"), "GB2312");
            } catch (UnsupportedEncodingException e3) {
                C2538c.b("ZipUtil", new Object[]{"UnsupportedEncodingException e=" + e3.getMessage()});
                str3 = name;
            }
            C2538c.c("ZipUtil", new Object[]{"==ww==resFile.isDirectory()=" + file2.isDirectory(), ";zipFileName:", str3});
            int read;
            if (file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File a : listFiles) {
                        C4594e.m21887a(a, zipOutputStream, str3);
                    }
                }
            } else {
                try {
                    byte[] bArr = new byte[1048576];
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file2), 1048576);
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                        while (true) {
                            read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        C2538c.b("ZipUtil", new Object[]{"==ww==zip ok"});
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e4) {
                                C2538c.e("ZipUtil", new Object[]{"IOException2 e=" + e4.getMessage()});
                            }
                        }
                    } catch (IOException e5) {
                        e4 = e5;
                        C2538c.b("ZipUtil", new Object[]{"IOException1 e=" + e4.getMessage()});
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e42) {
                                C2538c.e("ZipUtil", new Object[]{"IOException2 e=" + e42.getMessage()});
                            }
                        }
                    } catch (OutOfMemoryError e6) {
                        C2538c.b("ZipUtil", new Object[]{"zipFiles OutOfMemoryError"});
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e422) {
                                C2538c.e("ZipUtil", new Object[]{"IOException2 e=" + e422.getMessage()});
                            }
                        }
                    } catch (Exception e7) {
                        e2 = e7;
                        try {
                            C2538c.b("ZipUtil", new Object[]{"zipFiles Exception e : " + e2.getMessage()});
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4222) {
                                    C2538c.e("ZipUtil", new Object[]{"IOException2 e=" + e4222.getMessage()});
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException e8) {
                    e4222 = e8;
                    bufferedInputStream = null;
                    C2538c.b("ZipUtil", new Object[]{"IOException1 e=" + e4222.getMessage()});
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                } catch (OutOfMemoryError e9) {
                    bufferedInputStream = null;
                    C2538c.b("ZipUtil", new Object[]{"zipFiles OutOfMemoryError"});
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                } catch (Exception e10) {
                    e2 = e10;
                    bufferedInputStream = null;
                    C2538c.b("ZipUtil", new Object[]{"zipFiles Exception e : " + e2.getMessage()});
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                }
            }
        }
        zipOutputStream.setComment(str);
        zipOutputStream.close();
        return;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e11) {
                C2538c.e("ZipUtil", new Object[]{"IOException2 e=" + e11.getMessage()});
            }
        }
        throw th;
        throw th;
    }

    private static void m21887a(File file, ZipOutputStream zipOutputStream, String str) {
        String str2;
        IOException e;
        Throwable th;
        Exception e2;
        C2538c.b("ZipUtil", new Object[]{"zipFile()"});
        String str3 = str + (str.trim().length() == 0 ? "" : File.separator) + file.getName();
        try {
            str2 = new String(str3.getBytes("8859_1"), "GB2312");
        } catch (UnsupportedEncodingException e3) {
            C2538c.b("ZipUtil", new Object[]{"UnsupportedEncodingException e=" + e3.getMessage()});
            str2 = str3;
        }
        C2538c.b("ZipUtil", new Object[]{"rootpath=" + str2});
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File a : listFiles) {
                    C4594e.m21887a(a, zipOutputStream, str2);
                }
                return;
            }
            return;
        }
        BufferedInputStream bufferedInputStream;
        try {
            byte[] bArr = new byte[1048576];
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
            try {
                zipOutputStream.putNextEntry(new ZipEntry(str2));
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        C2538c.e("ZipUtil", new Object[]{"Exception e = " + e4.getMessage()});
                    }
                }
            } catch (IOException e5) {
                e4 = e5;
                try {
                    C2538c.b("ZipUtil", new Object[]{"IOException3 e=" + e4.getMessage()});
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e42) {
                            C2538c.e("ZipUtil", new Object[]{"Exception e = " + e42.getMessage()});
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e6) {
                            C2538c.e("ZipUtil", new Object[]{"Exception e = " + e6.getMessage()});
                        }
                    }
                    throw th;
                }
            } catch (OutOfMemoryError e7) {
                C2538c.b("ZipUtil", new Object[]{"zipFile OutOfMemoryError"});
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e422) {
                        C2538c.e("ZipUtil", new Object[]{"Exception e = " + e422.getMessage()});
                    }
                }
            } catch (Exception e8) {
                e2 = e8;
                C2538c.b("ZipUtil", new Object[]{"zipFile Exception e : " + e2.getMessage()});
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4222) {
                        C2538c.e("ZipUtil", new Object[]{"Exception e = " + e4222.getMessage()});
                    }
                }
            }
        } catch (IOException e9) {
            e4222 = e9;
            bufferedInputStream = null;
            C2538c.b("ZipUtil", new Object[]{"IOException3 e=" + e4222.getMessage()});
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (OutOfMemoryError e10) {
            bufferedInputStream = null;
            C2538c.b("ZipUtil", new Object[]{"zipFile OutOfMemoryError"});
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (Exception e11) {
            e2 = e11;
            bufferedInputStream = null;
            C2538c.b("ZipUtil", new Object[]{"zipFile Exception e : " + e2.getMessage()});
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public static LinkedList<File> m21886a(String str) {
        int i = 0;
        LinkedList<File> linkedList = new LinkedList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        C2538c.b("ZipUtil", new Object[]{"==ww==  listLinkedFiles file[]=" + listFiles.length});
        String str2 = "";
        while (i < listFiles.length) {
            str2 = listFiles[i].getName();
            if (!listFiles[i].isDirectory() && (str2.contains("_crashLog") || str2.contains("log") || str2.contains("MCU") || str2.contains("Event") || str2.contains("BT") || str2.contains("Dump") || str2.contains("Power") || str2.contains("com.huawei"))) {
                linkedList.add(listFiles[i]);
            } else if (listFiles[i].isDirectory() && str2.contains("com.huawei")) {
                linkedList.add(listFiles[i]);
            }
            i++;
        }
        return linkedList;
    }
}
