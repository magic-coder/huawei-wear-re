package com.amap.api.services.core;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ANRLogWriter */
class ba extends bi {
    private String[] f12396a = new String[10];
    private int f12397b = 0;
    private boolean f12398c = false;
    private int f12399d = 0;
    private C3396a f12400e;

    /* compiled from: ANRLogWriter */
    class C3396a implements bn {
        final /* synthetic */ ba f12393a;
        private ak f12394b;

        private C3396a(ba baVar, ak akVar) {
            this.f12393a = baVar;
            this.f12394b = akVar;
        }

        public void mo4115a(String str) {
            try {
                this.f12394b.m16655b(str, this.f12393a.mo4116a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    ba() {
    }

    protected int mo4116a() {
        return 2;
    }

    protected String mo4120b() {
        return bf.f12418d;
    }

    protected String mo4118a(String str) {
        return ab.m16592b(str);
    }

    protected bn mo4117a(ak akVar) {
        try {
            if (this.f12400e == null) {
                this.f12400e = new C3396a(akVar);
            }
        } catch (Throwable th) {
            ay.m16709a(th, "ANRWriter", "getListener");
            th.printStackTrace();
        }
        return this.f12400e;
    }

    protected String mo4119a(List<ad> list) {
        InputStream fileInputStream;
        bo boVar;
        InputStream inputStream;
        Throwable e;
        IOException iOException;
        InputStream inputStream2 = null;
        bo boVar2 = null;
        try {
            File file = new File("/data/anr/traces.txt");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    boVar2 = new bo(fileInputStream, bp.f12461a);
                    Object obj = null;
                    while (true) {
                        try {
                            String str;
                            Object obj2;
                            String a = boVar2.m16844a();
                            if (a.contains("pid")) {
                                while (!a.contains("\"main\"")) {
                                    a = boVar2.m16844a();
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
                                m16758b(str);
                                if (this.f12399d == 5) {
                                    break;
                                } else if (this.f12398c) {
                                    this.f12399d++;
                                } else {
                                    for (ad adVar : list) {
                                        this.f12398c = m16756a(adVar.m16618f(), str);
                                        if (this.f12398c) {
                                            m16755a(adVar);
                                        }
                                    }
                                }
                            }
                        } catch (EOFException e2) {
                        } catch (FileNotFoundException e3) {
                            boVar = boVar2;
                            inputStream = fileInputStream;
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                    if (boVar2 != null) {
                        try {
                            boVar2.close();
                        } catch (Throwable e5) {
                            ay.m16709a(e5, "ANRWriter", "initLog1");
                            e5.printStackTrace();
                        } catch (Throwable e52) {
                            ay.m16709a(e52, "ANRWriter", "initLog2");
                            e52.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            e52 = e6;
                            ay.m16709a(e52, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            if (this.f12398c) {
                                return null;
                            }
                            return m16759c();
                        } catch (Throwable th) {
                            e52 = th;
                            ay.m16709a(e52, "ANRWriter", "initLog4");
                            e52.printStackTrace();
                            if (this.f12398c) {
                                return m16759c();
                            }
                            return null;
                        }
                    }
                } catch (FileNotFoundException e7) {
                    boVar = null;
                    inputStream = fileInputStream;
                    if (boVar != null) {
                        try {
                            boVar.close();
                        } catch (Throwable e522) {
                            ay.m16709a(e522, "ANRWriter", "initLog1");
                            e522.printStackTrace();
                        } catch (Throwable e5222) {
                            ay.m16709a(e5222, "ANRWriter", "initLog2");
                            e5222.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            iOException = e8;
                            ay.m16709a((Throwable) iOException, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            if (this.f12398c) {
                                return null;
                            }
                            return m16759c();
                        } catch (Throwable th2) {
                            e5222 = th2;
                            ay.m16709a(e5222, "ANRWriter", "initLog4");
                            e5222.printStackTrace();
                            if (this.f12398c) {
                                return m16759c();
                            }
                            return null;
                        }
                    }
                    if (this.f12398c) {
                        return null;
                    }
                    return m16759c();
                } catch (IOException e9) {
                    e5222 = e9;
                    boVar2 = null;
                    try {
                        ay.m16709a(e5222, "ANRWriter", "initLog");
                        e5222.printStackTrace();
                        if (boVar2 != null) {
                            try {
                                boVar2.close();
                            } catch (Throwable e52222) {
                                ay.m16709a(e52222, "ANRWriter", "initLog1");
                                e52222.printStackTrace();
                            } catch (Throwable e522222) {
                                ay.m16709a(e522222, "ANRWriter", "initLog2");
                                e522222.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e522222 = e10;
                                ay.m16709a(e522222, "ANRWriter", "initLog3");
                                iOException.printStackTrace();
                                if (this.f12398c) {
                                    return null;
                                }
                                return m16759c();
                            } catch (Throwable th3) {
                                e522222 = th3;
                                ay.m16709a(e522222, "ANRWriter", "initLog4");
                                e522222.printStackTrace();
                                if (this.f12398c) {
                                    return m16759c();
                                }
                                return null;
                            }
                        }
                        if (this.f12398c) {
                            return m16759c();
                        }
                        return null;
                    } catch (Throwable th4) {
                        e522222 = th4;
                        if (boVar2 != null) {
                            try {
                                boVar2.close();
                            } catch (Throwable e11) {
                                ay.m16709a(e11, "ANRWriter", "initLog1");
                                e11.printStackTrace();
                            } catch (Throwable e112) {
                                ay.m16709a(e112, "ANRWriter", "initLog2");
                                e112.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e1122) {
                                ay.m16709a(e1122, "ANRWriter", "initLog3");
                                e1122.printStackTrace();
                            } catch (Throwable e11222) {
                                ay.m16709a(e11222, "ANRWriter", "initLog4");
                                e11222.printStackTrace();
                            }
                        }
                        throw e522222;
                    }
                } catch (Throwable th5) {
                    e522222 = th5;
                    boVar2 = null;
                    if (boVar2 != null) {
                        boVar2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e522222;
                }
                if (this.f12398c) {
                    return m16759c();
                }
                return null;
            }
            if (null != null) {
                try {
                    boVar2.close();
                } catch (Throwable e12) {
                    ay.m16709a(e12, "ANRWriter", "initLog1");
                    e12.printStackTrace();
                } catch (Throwable e122) {
                    ay.m16709a(e122, "ANRWriter", "initLog2");
                    e122.printStackTrace();
                }
            }
            if (null != null) {
                try {
                    inputStream2.close();
                } catch (Throwable e5222222) {
                    ay.m16709a(e5222222, "ANRWriter", "initLog3");
                    e5222222.printStackTrace();
                } catch (Throwable e52222222) {
                    ay.m16709a(e52222222, "ANRWriter", "initLog4");
                    e52222222.printStackTrace();
                }
            }
            return null;
        } catch (FileNotFoundException e13) {
            boVar = null;
            inputStream = null;
            if (boVar != null) {
                boVar.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.f12398c) {
                return null;
            }
            return m16759c();
        } catch (IOException e14) {
            e52222222 = e14;
            boVar2 = null;
            fileInputStream = null;
            ay.m16709a(e52222222, "ANRWriter", "initLog");
            e52222222.printStackTrace();
            if (boVar2 != null) {
                boVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (this.f12398c) {
                return m16759c();
            }
            return null;
        } catch (Throwable th6) {
            e52222222 = th6;
            boVar2 = null;
            fileInputStream = null;
            if (boVar2 != null) {
                boVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e52222222;
        }
    }

    private String m16759c() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i = this.f12397b;
            while (i < 10 && i <= 9) {
                stringBuilder.append(this.f12396a[i]);
                i++;
            }
            for (i = 0; i < this.f12397b; i++) {
                stringBuilder.append(this.f12396a[i]);
            }
        } catch (Throwable th) {
            ay.m16709a(th, "ANRWriter", "getLogInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void m16758b(String str) {
        try {
            if (this.f12397b > 9) {
                this.f12397b = 0;
            }
            this.f12396a[this.f12397b] = str;
            this.f12397b++;
        } catch (Throwable th) {
            ay.m16709a(th, "ANRWriter", "addData");
            th.printStackTrace();
        }
    }
}
