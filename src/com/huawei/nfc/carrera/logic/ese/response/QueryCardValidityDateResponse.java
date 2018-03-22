package com.huawei.nfc.carrera.logic.ese.response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class QueryCardValidityDateResponse extends QueryCardBaseResponse {
    public String expireDate;
    public int validityTermStatus;

    public QueryCardValidityDateResponse() {
        this.resultCode = -1;
    }

    public QueryCardValidityDateResponse(int i) {
        super(i);
    }

    public QueryCardValidityDateResponse(int i, String str, String str2, int i2) {
        this.resultCode = i;
        this.expireDate = str2;
        this.validityTermStatus = i2;
    }

    public QueryCardValidityDateResponse(int i, String str) {
        this.resultCode = i;
        parse(str);
    }

    private void parse(String str) {
        if (str.length() >= 20) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
            simpleDateFormat.setLenient(false);
            try {
                String substring = str.substring(0, 8);
                this.expireDate = str.substring(8, 16);
                Date parse = simpleDateFormat.parse(substring + "000001");
                Date parse2 = simpleDateFormat.parse(this.expireDate + "235959");
                Date date = new Date(System.currentTimeMillis());
                if (date.before(parse)) {
                    this.validityTermStatus = 1;
                }
                if (date.after(parse2)) {
                    this.validityTermStatus = 2;
                }
                this.validityTermStatus = 0;
                return;
            } catch (ParseException e) {
                this.validityTermStatus = -1;
                return;
            }
        }
        this.validityTermStatus = -1;
    }
}
