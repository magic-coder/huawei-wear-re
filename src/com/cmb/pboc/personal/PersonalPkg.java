package com.cmb.pboc.personal;

import com.cmb.pboc.global.PbocValue;
import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.scard.Scard;
import com.cmb.pboc.utils.ParseUtils;
import java.util.ArrayList;
import java.util.List;

public class PersonalPkg {
    private static final String f13485a = PersonalPkg.class.getSimpleName();
    private Scard f13486b;
    private int f13487c;
    private String f13488d;
    private List f13489e;
    private boolean f13490f;
    private String f13491g;

    public PersonalPkg(Scard scard, int i, String str) {
        if (scard == null || str == null || str.length() <= 0) {
            PbocLog.m17741d(f13485a, "Build personal pkg object error, Parameters is wrong.");
            throw new Exception("Build personal pkg object error, Parameters is wrong.");
        }
        this.f13486b = scard;
        this.f13487c = i;
        if (m17777a(str)) {
            PbocLog.m17738a(f13485a, "Initial APDU Package success.");
        } else {
            PbocLog.m17741d(f13485a, "Initial APDU Package failed.");
            throw new Exception("Initial APDU Package failed.");
        }
    }

    private boolean m17777a(String str) {
        this.f13488d = str;
        this.f13489e = new ArrayList();
        int indexOf = this.f13488d.indexOf("#");
        if (indexOf < 0) {
            PbocLog.m17741d(f13485a, "Can't find delimiter in APDU package.");
            return false;
        }
        if (indexOf == 0) {
            this.f13488d = this.f13488d.substring(1);
            PbocLog.m17738a(f13485a, "Remove the head delimiter in APDU package.");
        }
        String[] split = this.f13488d.split("[#]+");
        if (split == null || split.length <= 0) {
            PbocLog.m17741d(f13485a, "Split APDU package error.");
            return false;
        }
        for (indexOf = 0; indexOf < split.length; indexOf++) {
            this.f13489e.add(new ApduInfo(indexOf + 1, split[indexOf]));
        }
        if (split.length != this.f13489e.size()) {
            PbocLog.m17741d(f13485a, "Apdus num is incorrect in parse.");
            return false;
        }
        PbocLog.m17738a(f13485a, "APDU list length: " + this.f13489e.size());
        return true;
    }

    public final boolean m17778a() {
        return this.f13490f;
    }

    public final String m17779b() {
        return this.f13491g;
    }

    public final int m17780c() {
        if (this.f13489e == null || 1 > this.f13489e.size()) {
            PbocLog.m17741d(f13485a, "APDU list is null.");
            return -1;
        }
        ApduInfo apduInfo;
        long currentTimeMillis = System.currentTimeMillis();
        ApduInfo apduInfo2 = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        for (ApduInfo apduInfo22 : this.f13489e) {
            if (apduInfo22.m17772b() != null && 1 <= apduInfo22.m17772b().length()) {
                i2++;
                PbocLog.m17738a(f13485a, "Now execute the #" + i2 + " Apdu Command");
                for (int i3 = 0; i3 < 3; i3++) {
                    i = apduInfo22.m17771a(this.f13486b);
                    if (-1 == i || i == 0 || -11 == i) {
                        break;
                    }
                }
                if (i != 0) {
                    ApduInfo apduInfo3 = apduInfo22;
                    boolean z2 = i;
                    apduInfo = apduInfo3;
                    break;
                }
                z = i;
            } else {
                PbocLog.m17741d(f13485a, "Apdu Command is null");
            }
        }
        apduInfo = apduInfo22;
        int i4 = z;
        if (i4 == 0) {
            this.f13490f = true;
        } else {
            this.f13490f = false;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.f13487c < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(String.valueOf(this.f13487c));
        int a = apduInfo.m17770a();
        if (a < 10) {
            stringBuffer.append("00");
        } else if (a >= 10 && a < 100) {
            stringBuffer.append("0");
        }
        stringBuffer.append(String.valueOf(a));
        a = apduInfo.m17773c();
        byte[] bArr = new byte[(a + 4)];
        bArr[0] = (byte) 0;
        bArr[1] = (byte) 0;
        bArr[2] = (byte) ((a >> 8) & 255);
        bArr[3] = (byte) (a & 255);
        System.arraycopy(apduInfo.m17774d(), 0, bArr, 4, a);
        stringBuffer.append(ParseUtils.m17796a(bArr));
        this.f13491g = stringBuffer.toString();
        PbocValue.f13429h = this.f13491g;
        PbocLog.m17738a(f13485a, "PersonalPkg's last Apdu RESP=" + PbocValue.f13429h);
        PbocLog.m17738a(f13485a, "APDU total number: " + this.f13489e.size());
        PbocLog.m17738a(f13485a, "Execute total number: " + i2);
        PbocLog.m17738a(f13485a, "Execute apdu package #" + this.f13487c + " takes " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return i4;
    }
}
