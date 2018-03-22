package com.huawei.nfc.carrera.ui.bus.adapter;

import android.content.Context;
import android.util.SparseArray;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneralTradeInfo {
    private String mAmount;
    private String mDate;
    private String mStatusDesc;
    private String mTypeDesc;
    private String unitText;

    class TradeRecordUIConverter {
        private String mMoneyLabel;
        private SparseArray<String> mRecordStatus = new SparseArray();
        private SparseArray<String> mRecordTypes = new SparseArray();

        TradeRecordUIConverter(Context context) {
            this.mMoneyLabel = context.getString(R.string.nfc_money_type);
            this.mRecordStatus.put(0, "");
            this.mRecordStatus.put(2, context.getString(R.string.nfc_bus_card_air_recharge_details_refund));
            this.mRecordStatus.put(1, context.getString(R.string.nfc_state_refunding));
            this.mRecordStatus.put(3, context.getString(R.string.nfc_state_handling));
            this.mRecordTypes.put(10, context.getString(R.string.nfc_bus_card_trade_details_recharge));
            this.mRecordTypes.put(11, context.getString(R.string.nfc_bus_card_trade_details_consume));
        }

        List<GeneralTradeInfo> changeRecordListToTradeList(List<RecordInfo> list) {
            List<GeneralTradeInfo> arrayList = new ArrayList();
            for (RecordInfo changeRecordInfo2General : list) {
                GeneralTradeInfo changeRecordInfo2General2 = changeRecordInfo2General(changeRecordInfo2General);
                if (changeRecordInfo2General2 != null) {
                    arrayList.add(changeRecordInfo2General2);
                }
            }
            return arrayList;
        }

        private GeneralTradeInfo changeRecordInfo2General(RecordInfo recordInfo) {
            String str;
            String str2 = (String) this.mRecordStatus.get(recordInfo.getRecordStatus());
            String str3 = (String) this.mRecordTypes.get(recordInfo.getRecordType());
            if (11 == recordInfo.getRecordType()) {
                str = "-" + this.mMoneyLabel;
            } else {
                str = "+" + this.mMoneyLabel;
            }
            try {
                LogX.i("NumberFormatException " + recordInfo.getRecordTime());
                if (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(recordInfo.getRecordTime()).after(new Date()) && Double.parseDouble(recordInfo.getRecordAmount()) <= 0.0d) {
                    return null;
                }
            } catch (NumberFormatException e) {
                LogX.e("NumberFormatException " + e.getMessage());
            } catch (IllegalArgumentException e2) {
                LogX.e("IllegalArgumentException " + e2.getMessage());
            } catch (ParseException e3) {
                LogX.e("ParseException " + e3.getMessage());
            }
            return new GeneralTradeInfo(recordInfo.getRecordTime(), str, recordInfo.getRecordAmount(), str3, str2);
        }
    }

    public GeneralTradeInfo(String str, String str2, String str3, String str4, String str5) {
        this.mDate = str;
        this.unitText = str2;
        this.mAmount = str3;
        this.mTypeDesc = str4;
        this.mStatusDesc = str5;
    }

    public void setmDate(String str) {
        this.mDate = str;
    }

    public void setmAmount(String str) {
        this.mAmount = str;
    }

    public void setmTypeDesc(String str) {
        this.mTypeDesc = str;
    }

    public void setmStatusDesc(String str) {
        this.mStatusDesc = str;
    }

    public void setUnitText(String str) {
        this.unitText = str;
    }

    public String getmDate() {
        return this.mDate;
    }

    public String getmAmount() {
        return this.mAmount;
    }

    public String getmTypeDesc() {
        return this.mTypeDesc;
    }

    public String getmStatusDesc() {
        return this.mStatusDesc;
    }

    public String getUnitText() {
        return this.unitText;
    }

    public String toString() {
        return this.mDate + ": " + this.unitText + this.mAmount + HwAccountConstants.BLANK + this.mTypeDesc + HwAccountConstants.BLANK + this.mStatusDesc;
    }

    public static List<GeneralTradeInfo> changeRecordListToTradeList(Context context, List<RecordInfo> list) {
        return new TradeRecordUIConverter(context).changeRecordListToTradeList(list);
    }

    public void generalTradeInfoSAI1() {
    }

    public void generalTradeInfoSAI2() {
    }

    public void generalTradeInfoSAI3() {
    }

    public void generalTradeInfoSAI4() {
    }

    public void generalTradeInfoSAI5() {
    }
}
