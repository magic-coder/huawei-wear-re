package com.amap.api.mapcore.util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ANRLogWriter */
class cc extends cl {
    private String[] f11590a = new String[10];
    private int f11591b = 0;
    private boolean f11592c = false;
    private int f11593d = 0;
    private C3304a f11594e;

    /* compiled from: ANRLogWriter */
    class C3304a implements dh {
        final /* synthetic */ cc f11587a;
        private cv f11588b;

        private C3304a(cc ccVar, cv cvVar) {
            this.f11587a = ccVar;
            this.f11588b = cvVar;
        }

        public void mo4023a(String str) {
            try {
                this.f11588b.m15955b(str, this.f11587a.mo4024a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    cc() {
    }

    protected int mo4024a() {
        return 2;
    }

    protected String mo4028b() {
        return ci.f11612d;
    }

    protected String mo4026a(String str) {
        return bs.m15760c(str);
    }

    protected dh mo4025a(cv cvVar) {
        try {
            if (this.f11594e == null) {
                this.f11594e = new C3304a(cvVar);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "ANRWriter", "getListener");
            th.printStackTrace();
        }
        return this.f11594e;
    }

    protected String mo4027a(List<bv> list) {
        di diVar;
        InputStream inputStream;
        Throwable e;
        IOException iOException;
        InputStream inputStream2 = null;
        di diVar2 = null;
        InputStream fileInputStream;
        try {
            File file = new File("/data/anr/traces.txt");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    diVar2 = new di(fileInputStream, dj.f11719a);
                    Object obj = null;
                    while (true) {
                        try {
                            String str;
                            Object obj2;
                            String a = diVar2.m16056a();
                            if (a.contains("pid")) {
                                while (!a.contains("\"main\"")) {
                                    a = diVar2.m16056a();
                                }
                                str = a;
                                obj2 = 1;
                            } else {
                                str = a;
                                obj2 = obj;
                            }
                            if (str.equals("")) {
                                obj = null;
                            } else {
                                obj = obj2;
                            }
                            if (obj != null) {
                                m15877b(str);
                                if (this.f11593d == 5) {
                                    break;
                                } else if (this.f11592c) {
                                    this.f11593d++;
                                } else {
                                    for (bv bvVar : list) {
                                        this.f11592c = m15875a(bvVar.m15797f(), str);
                                        if (this.f11592c) {
                                            m15874a(bvVar);
                                        }
                                    }
                                }
                            }
                        } catch (EOFException e2) {
                        } catch (FileNotFoundException e3) {
                            diVar = diVar2;
                            inputStream = fileInputStream;
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                    if (diVar2 != null) {
                        try {
                            diVar2.close();
                        } catch (Throwable e5) {
                            ca.m15831a(e5, "ANRWriter", "initLog1");
                            e5.printStackTrace();
                        } catch (Throwable e52) {
                            ca.m15831a(e52, "ANRWriter", "initLog2");
                            e52.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            e52 = e6;
                            ca.m15831a(e52, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            if (this.f11592c) {
                                return null;
                            }
                            return m15878c();
                        } catch (Throwable th) {
                            e52 = th;
                            ca.m15831a(e52, "ANRWriter", "initLog4");
                            e52.printStackTrace();
                            if (this.f11592c) {
                                return m15878c();
                            }
                            return null;
                        }
                    }
                } catch (FileNotFoundException e7) {
                    diVar = null;
                    inputStream = fileInputStream;
                    if (diVar != null) {
                        try {
                            diVar.close();
                        } catch (Throwable e522) {
                            ca.m15831a(e522, "ANRWriter", "initLog1");
                            e522.printStackTrace();
                        } catch (Throwable e5222) {
                            ca.m15831a(e5222, "ANRWriter", "initLog2");
                            e5222.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            iOException = e8;
                            ca.m15831a((Throwable) iOException, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            if (this.f11592c) {
                                return null;
                            }
                            return m15878c();
                        } catch (Throwable th2) {
                            e5222 = th2;
                            ca.m15831a(e5222, "ANRWriter", "initLog4");
                            e5222.printStackTrace();
                            if (this.f11592c) {
                                return m15878c();
                            }
                            return null;
                        }
                    }
                    if (this.f11592c) {
                        return null;
                    }
                    return m15878c();
                } catch (IOException e9) {
                    e5222 = e9;
                    diVar2 = null;
                    try {
                        ca.m15831a(e5222, "ANRWriter", "initLog");
                        e5222.printStackTrace();
                        if (diVar2 != null) {
                            try {
                                diVar2.close();
                            } catch (Throwable e52222) {
                                ca.m15831a(e52222, "ANRWriter", "initLog1");
                                e52222.printStackTrace();
                            } catch (Throwable e522222) {
                                ca.m15831a(e522222, "ANRWriter", "initLog2");
                                e522222.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e522222 = e10;
                                ca.m15831a(e522222, "ANRWriter", "initLog3");
                                iOException.printStackTrace();
                                if (this.f11592c) {
                                    return null;
                                }
                                return m15878c();
                            } catch (Throwable th3) {
                                e522222 = th3;
                                ca.m15831a(e522222, "ANRWriter", "initLog4");
                                e522222.printStackTrace();
                                if (this.f11592c) {
                                    return m15878c();
                                }
                                return null;
                            }
                        }
                        if (this.f11592c) {
                            return m15878c();
                        }
                        return null;
                    } catch (Throwable th4) {
                        e522222 = th4;
                        if (diVar2 != null) {
                            try {
                                diVar2.close();
                            } catch (Throwable e11) {
                                ca.m15831a(e11, "ANRWriter", "initLog1");
                                e11.printStackTrace();
                            } catch (Throwable e112) {
                                ca.m15831a(e112, "ANRWriter", "initLog2");
                                e112.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e1122) {
                                ca.m15831a(e1122, "ANRWriter", "initLog3");
                                e1122.printStackTrace();
                            } catch (Throwable e11222) {
                                ca.m15831a(e11222, "ANRWriter", "initLog4");
                                e11222.printStackTrace();
                            }
                        }
                        throw e522222;
                    }
                } catch (Throwable th5) {
                    e522222 = th5;
                    diVar2 = null;
                    if (diVar2 != null) {
                        diVar2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e522222;
                }
                if (this.f11592c) {
                    return m15878c();
                }
                return null;
            }
            if (null != null) {
                try {
                    diVar2.close();
                } catch (Throwable e12) {
                    ca.m15831a(e12, "ANRWriter", "initLog1");
                    e12.printStackTrace();
                } catch (Throwable e122) {
                    ca.m15831a(e122, "ANRWriter", "initLog2");
                    e122.printStackTrace();
                }
            }
            if (null != null) {
                try {
                    inputStream2.close();
                } catch (Throwable e5222222) {
                    ca.m15831a(e5222222, "ANRWriter", "initLog3");
                    e5222222.printStackTrace();
                } catch (Throwable e52222222) {
                    ca.m15831a(e52222222, "ANRWriter", "initLog4");
                    e52222222.printStackTrace();
                }
            }
            return null;
        } catch (FileNotFoundException e13) {
            diVar = null;
            inputStream = null;
            if (diVar != null) {
                diVar.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.f11592c) {
                return null;
            }
            return m15878c();
        } catch (IOException e14) {
            e52222222 = e14;
            diVar2 = null;
            fileInputStream = null;
            ca.m15831a(e52222222, "ANRWriter", "initLog");
            e52222222.printStackTrace();
            if (diVar2 != null) {
                diVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (this.f11592c) {
                return m15878c();
            }
            return null;
        } catch (Throwable th6) {
            e52222222 = th6;
            diVar2 = null;
            fileInputStream = null;
            if (diVar2 != null) {
                diVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e52222222;
        }
    }

    private String m15878c() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i = this.f11591b;
            while (i < 10 && i <= 9) {
                stringBuilder.append(this.f11590a[i]);
                i++;
            }
            for (i = 0; i < this.f11591b; i++) {
                stringBuilder.append(this.f11590a[i]);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "ANRWriter", "getLogInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void m15877b(String str) {
        try {
            if (this.f11591b > 9) {
                this.f11591b = 0;
            }
            this.f11590a[this.f11591b] = str;
            this.f11591b++;
        } catch (Throwable th) {
            ca.m15831a(th, "ANRWriter", "addData");
            th.printStackTrace();
        }
    }
}
