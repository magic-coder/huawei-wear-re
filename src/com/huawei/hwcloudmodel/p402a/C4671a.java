package com.huawei.hwcloudmodel.p402a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.p064d.C4729g;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ImageStorageAdapter */
public class C4671a {
    public static String m22419a(Context context, String str, Bitmap bitmap) {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        Exception e3;
        String a = C4729g.m22632a(context, str);
        C2538c.c("ImageStorageAdapter", new Object[]{"saveImage"});
        File file = new File(w.a(context));
        if (!(file.exists() || file.mkdirs())) {
            C2538c.e("ImageStorageAdapter", new Object[]{"create file error"});
        }
        a = w.a(context) + File.separator + a;
        File file2 = new File(a);
        if (bitmap == null) {
            C2538c.e("ImageStorageAdapter", new Object[]{"bitmap is null"});
            return null;
        }
        if (file2.exists() && !file2.delete()) {
            C2538c.e("ImageStorageAdapter", new Object[]{"delete old file error"});
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (file2.createNewFile()) {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bitmap.compress(CompressFormat.JPEG, 70, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e4) {
                            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally flush IOException e = " + e4.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e42) {
                                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e42.getMessage()});
                                }
                            }
                        } catch (Throwable th2) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e5.getMessage()});
                                }
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e422) {
                            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e422.getMessage()});
                        }
                    }
                } catch (FileNotFoundException e6) {
                    e2 = e6;
                    try {
                        C2538c.e("ImageStorageAdapter", new Object[]{"saveImage FileNotFoundException e = " + e2.getMessage()});
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                            } catch (IOException e4222) {
                                C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally flush IOException e = " + e4222.getMessage()});
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e42222) {
                                        C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e42222.getMessage()});
                                    }
                                }
                            } catch (Throwable th3) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e52) {
                                        C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e52.getMessage()});
                                    }
                                }
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e422222) {
                                C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e422222.getMessage()});
                            }
                        }
                        return a;
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                            } catch (IOException e522) {
                                C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally flush IOException e = " + e522.getMessage()});
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5222) {
                                        C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e5222.getMessage()});
                                    }
                                }
                            } catch (Throwable th5) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e52222) {
                                        C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e52222.getMessage()});
                                    }
                                }
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e522222) {
                                C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e522222.getMessage()});
                            }
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e422222 = e7;
                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage IOException e = " + e422222.getMessage()});
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e4222222) {
                            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally flush IOException e = " + e4222222.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e42222222) {
                                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e42222222.getMessage()});
                                }
                            }
                        } catch (Throwable th6) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5222222) {
                                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e5222222.getMessage()});
                                }
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e422222222) {
                            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e422222222.getMessage()});
                        }
                    }
                    return a;
                } catch (Exception e8) {
                    e3 = e8;
                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage Exception e = " + e3.getMessage()});
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e4222222222) {
                            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally flush IOException e = " + e4222222222.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e42222222222) {
                                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e42222222222.getMessage()});
                                }
                            }
                        } catch (Throwable th7) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e52222222) {
                                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e52222222.getMessage()});
                                }
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e422222222222) {
                            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e422222222222.getMessage()});
                        }
                    }
                    return a;
                }
                return a;
            }
            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage createNewFile error"});
            if (null != null) {
                try {
                    fileOutputStream.flush();
                } catch (IOException e522222222) {
                    C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally flush IOException e = " + e522222222.getMessage()});
                    if (null == null) {
                        return null;
                    }
                    try {
                        fileOutputStream.close();
                        return null;
                    } catch (IOException e5222222222) {
                        C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e5222222222.getMessage()});
                        return null;
                    }
                } catch (Throwable th8) {
                    if (null != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4222222222222) {
                            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e4222222222222.getMessage()});
                        }
                    }
                }
            }
            if (null == null) {
                return null;
            }
            try {
                fileOutputStream.close();
                return null;
            } catch (IOException e52222222222) {
                C2538c.e("ImageStorageAdapter", new Object[]{"saveImage finally close IOException e = " + e52222222222.getMessage()});
                return null;
            }
        } catch (FileNotFoundException e9) {
            FileNotFoundException fileNotFoundException = e9;
            fileOutputStream = null;
            e2 = fileNotFoundException;
            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage FileNotFoundException e = " + e2.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return a;
        } catch (IOException e10) {
            IOException iOException = e10;
            fileOutputStream = null;
            e4222222222222 = iOException;
            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage IOException e = " + e4222222222222.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return a;
        } catch (Exception e11) {
            Exception exception = e11;
            fileOutputStream = null;
            e3 = exception;
            C2538c.e("ImageStorageAdapter", new Object[]{"saveImage Exception e = " + e3.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return a;
        } catch (Throwable th9) {
            fileOutputStream = null;
            th = th9;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
