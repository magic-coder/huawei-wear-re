package com.huawei.wallet.logic.tlv;

import android.content.Intent;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.huawei.wallet.utils.log.LogC;
import java.io.IOException;

public class TlvParserUtil {
    public static String m28089a(Intent intent) {
        String a = m28090a(intent, "00B2010C00", "57");
        if (a == null) {
            for (String a2 : TlvConstant.f21295b) {
                a2 = m28090a(intent, a2, "5A");
                if (a2 != null) {
                    break;
                }
            }
        }
        return a2;
    }

    private static String m28090a(Intent intent, String str, String str2) {
        IsoDep isoDep;
        IOException e;
        String a;
        Throwable th;
        IllegalStateException e2;
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        if (tag == null) {
            return null;
        }
        try {
            isoDep = IsoDep.get(tag);
            if (isoDep != null) {
                try {
                    isoDep.connect();
                    byte[] transceive = isoDep.transceive(TlvUtil.m28100b(TlvConstant.f21294a));
                    if (transceive == null || !TlvUtil.m28096a(transceive).endsWith("9000")) {
                        LogC.m28527a("ppse not exist.", false);
                        if (isoDep == null) {
                            return null;
                        }
                        try {
                            isoDep.close();
                            return null;
                        } catch (IOException e3) {
                            LogC.m28533d("CardReaderActivity", "ERROR:" + e3.getMessage(), false);
                            return null;
                        }
                    }
                    transceive = m28093b(transceive, "4F");
                    if (transceive != null && transceive.length != 0) {
                        isoDep.transceive(TlvUtil.m28100b(transceive));
                        a = m28092a(isoDep.transceive(TlvUtil.m28099b(str)), str2);
                        if (a == null) {
                            a = null;
                        } else if ("57".equalsIgnoreCase(str2)) {
                            a = m28091a(a, 'D');
                        } else {
                            a = m28091a(a, 'F');
                        }
                        if (isoDep != null) {
                            try {
                                isoDep.close();
                            } catch (IOException e4) {
                                LogC.m28533d("CardReaderActivity", "ERROR:" + e4.getMessage(), false);
                            }
                        }
                        return a;
                    } else if (isoDep == null) {
                        return null;
                    } else {
                        try {
                            isoDep.close();
                            return null;
                        } catch (IOException e32) {
                            LogC.m28533d("CardReaderActivity", "ERROR:" + e32.getMessage(), false);
                            return null;
                        }
                    }
                } catch (IOException e5) {
                    e32 = e5;
                    try {
                        LogC.m28533d("CardReaderActivity", "ERROR:" + e32.getMessage(), false);
                        if (isoDep != null) {
                            try {
                                isoDep.close();
                            } catch (IOException e322) {
                                LogC.m28533d("CardReaderActivity", "ERROR:" + e322.getMessage(), false);
                                a = null;
                            }
                        }
                        a = null;
                        return a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (isoDep != null) {
                            try {
                                isoDep.close();
                            } catch (IOException e42) {
                                LogC.m28533d("CardReaderActivity", "ERROR:" + e42.getMessage(), false);
                            }
                        }
                        throw th;
                    }
                } catch (IllegalStateException e6) {
                    e2 = e6;
                    LogC.m28533d("CardReaderActivity", "ERROR:" + e2.getMessage(), false);
                    if (isoDep != null) {
                        try {
                            isoDep.close();
                        } catch (IOException e3222) {
                            LogC.m28533d("CardReaderActivity", "ERROR:" + e3222.getMessage(), false);
                            a = null;
                        }
                    }
                    a = null;
                    return a;
                }
            } else if (isoDep == null) {
                return null;
            } else {
                try {
                    isoDep.close();
                    return null;
                } catch (IOException e32222) {
                    LogC.m28533d("CardReaderActivity", "ERROR:" + e32222.getMessage(), false);
                    return null;
                }
            }
        } catch (IOException e7) {
            e32222 = e7;
            isoDep = null;
            LogC.m28533d("CardReaderActivity", "ERROR:" + e32222.getMessage(), false);
            if (isoDep != null) {
                isoDep.close();
            }
            a = null;
            return a;
        } catch (IllegalStateException e8) {
            e2 = e8;
            isoDep = null;
            LogC.m28533d("CardReaderActivity", "ERROR:" + e2.getMessage(), false);
            if (isoDep != null) {
                isoDep.close();
            }
            a = null;
            return a;
        } catch (Throwable th3) {
            th = th3;
            isoDep = null;
            if (isoDep != null) {
                isoDep.close();
            }
            throw th;
        }
    }

    private static String m28091a(String str, char c) {
        char c2 = (char) (c + 32);
        int indexOf = str.indexOf(c);
        if (-1 == indexOf) {
            indexOf = str.indexOf(c2);
        }
        return -1 == indexOf ? str : str.substring(0, indexOf);
    }

    public static String m28092a(byte[] bArr, String str) {
        Tlv a = new TlvParser().m28088a(bArr, 0, bArr.length).m28101a(new TlvTag(str));
        if (a != null) {
            return a.m28077c();
        }
        return null;
    }

    public static byte[] m28093b(byte[] bArr, String str) {
        Tlv a = new TlvParser().m28088a(bArr, 0, bArr.length).m28101a(new TlvTag(str));
        if (a != null) {
            return a.m28078d();
        }
        return new byte[0];
    }
}
