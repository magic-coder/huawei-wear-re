package com.google.zxing.p295e;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EANManufacturerOrgSupport */
final class C3871g {
    private final List<int[]> f14946a = new ArrayList();
    private final List<String> f14947b = new ArrayList();

    C3871g() {
    }

    String m19279a(String str) {
        m19277a();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.f14946a.size();
        for (int i = 0; i < size; i++) {
            int[] iArr = (int[]) this.f14946a.get(i);
            int i2 = iArr[0];
            if (parseInt < i2) {
                return null;
            }
            if (parseInt <= (iArr.length == 1 ? i2 : iArr[1])) {
                return (String) this.f14947b.get(i);
            }
        }
        return null;
    }

    private void m19278a(int[] iArr, String str) {
        this.f14946a.add(iArr);
        this.f14947b.add(str);
    }

    private synchronized void m19277a() {
        if (this.f14946a.isEmpty()) {
            int[] iArr = new int[2];
            iArr[1] = 19;
            m19278a(iArr, "US/CA");
            m19278a(new int[]{30, 39}, "US");
            m19278a(new int[]{60, 139}, "US/CA");
            m19278a(new int[]{300, 379}, "FR");
            m19278a(new int[]{380}, "BG");
            m19278a(new int[]{383}, "SI");
            m19278a(new int[]{385}, "HR");
            m19278a(new int[]{387}, "BA");
            m19278a(new int[]{HttpStatus.SC_BAD_REQUEST, 440}, "DE");
            m19278a(new int[]{450, 459}, "JP");
            m19278a(new int[]{460, 469}, "RU");
            m19278a(new int[]{471}, "TW");
            m19278a(new int[]{474}, "EE");
            m19278a(new int[]{475}, "LV");
            m19278a(new int[]{476}, "AZ");
            m19278a(new int[]{477}, "LT");
            m19278a(new int[]{478}, "UZ");
            m19278a(new int[]{479}, "LK");
            m19278a(new int[]{480}, "PH");
            m19278a(new int[]{481}, "BY");
            m19278a(new int[]{482}, "UA");
            m19278a(new int[]{484}, "MD");
            m19278a(new int[]{485}, "AM");
            m19278a(new int[]{486}, "GE");
            m19278a(new int[]{487}, "KZ");
            m19278a(new int[]{489}, "HK");
            m19278a(new int[]{490, 499}, "JP");
            m19278a(new int[]{500, 509}, "GB");
            m19278a(new int[]{520}, "GR");
            m19278a(new int[]{528}, "LB");
            m19278a(new int[]{529}, "CY");
            m19278a(new int[]{531}, "MK");
            m19278a(new int[]{535}, "MT");
            m19278a(new int[]{539}, "IE");
            m19278a(new int[]{540, 549}, "BE/LU");
            m19278a(new int[]{560}, "PT");
            m19278a(new int[]{569}, "IS");
            m19278a(new int[]{570, 579}, "DK");
            m19278a(new int[]{590}, "PL");
            m19278a(new int[]{594}, "RO");
            m19278a(new int[]{599}, "HU");
            m19278a(new int[]{HeartRateDetail.HEART_RATE_TYPE_SPORT, HeartRateDetail.HEART_RATE_TYPE_TRANQUILLIZATION}, "ZA");
            m19278a(new int[]{603}, "GH");
            m19278a(new int[]{608}, "BH");
            m19278a(new int[]{609}, "MU");
            m19278a(new int[]{611}, "MA");
            m19278a(new int[]{613}, "DZ");
            m19278a(new int[]{616}, "KE");
            m19278a(new int[]{618}, "CI");
            m19278a(new int[]{619}, "TN");
            m19278a(new int[]{621}, "SY");
            m19278a(new int[]{622}, "EG");
            m19278a(new int[]{624}, "LY");
            m19278a(new int[]{625}, "JO");
            m19278a(new int[]{626}, "IR");
            m19278a(new int[]{627}, "KW");
            m19278a(new int[]{628}, "SA");
            m19278a(new int[]{629}, "AE");
            m19278a(new int[]{640, 649}, "FI");
            m19278a(new int[]{690, 695}, PayManagerSettingSwitchDialog.COUNTRY_CODE_CN);
            m19278a(new int[]{700, 709}, "NO");
            m19278a(new int[]{729}, "IL");
            m19278a(new int[]{730, 739}, "SE");
            m19278a(new int[]{740}, "GT");
            m19278a(new int[]{741}, "SV");
            m19278a(new int[]{742}, "HN");
            m19278a(new int[]{743}, "NI");
            m19278a(new int[]{744}, "CR");
            m19278a(new int[]{745}, "PA");
            m19278a(new int[]{746}, "DO");
            m19278a(new int[]{750}, "MX");
            m19278a(new int[]{754, 755}, "CA");
            m19278a(new int[]{759}, "VE");
            m19278a(new int[]{760, 769}, "CH");
            m19278a(new int[]{770}, "CO");
            m19278a(new int[]{773}, "UY");
            m19278a(new int[]{775}, "PE");
            m19278a(new int[]{777}, "BO");
            m19278a(new int[]{779}, "AR");
            m19278a(new int[]{780}, "CL");
            m19278a(new int[]{784}, "PY");
            m19278a(new int[]{785}, "PE");
            m19278a(new int[]{786}, "EC");
            m19278a(new int[]{789, 790}, "BR");
            m19278a(new int[]{800, 839}, "IT");
            m19278a(new int[]{840, 849}, "ES");
            m19278a(new int[]{850}, "CU");
            m19278a(new int[]{858}, "SK");
            m19278a(new int[]{859}, "CZ");
            m19278a(new int[]{860}, "YU");
            m19278a(new int[]{865}, "MN");
            m19278a(new int[]{867}, "KP");
            m19278a(new int[]{868, 869}, "TR");
            m19278a(new int[]{870, 879}, "NL");
            m19278a(new int[]{880}, "KR");
            m19278a(new int[]{885}, "TH");
            m19278a(new int[]{888}, "SG");
            m19278a(new int[]{890}, "IN");
            m19278a(new int[]{893}, "VN");
            m19278a(new int[]{896}, "PK");
            m19278a(new int[]{899}, "ID");
            m19278a(new int[]{900, 919}, "AT");
            m19278a(new int[]{930, 939}, "AU");
            m19278a(new int[]{940, 949}, "AZ");
            m19278a(new int[]{955}, "MY");
            m19278a(new int[]{958}, "MO");
        }
    }
}
