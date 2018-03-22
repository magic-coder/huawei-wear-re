package com.snowballtech.business.common;

import com.snowballtech.business.SnowballCommon;
import com.snowballtech.business.user.task.WTaskCardCoupon;
import com.snowballtech.business.user.task.WTaskCardDeactivate;
import com.snowballtech.business.user.task.WTaskCardListQuery;
import com.snowballtech.business.user.task.WTaskCardQuery;
import com.snowballtech.business.user.task.WTaskCardSwitch;
import com.snowballtech.business.user.task.WTaskConsumeParse;
import com.snowballtech.business.user.task.WTaskGetCplc;
import com.snowballtech.business.user.task.WTaskGetPayOrder;
import com.snowballtech.business.user.task.WTaskInitSe;
import com.snowballtech.business.user.task.WTaskIsInstanceExisted;
import com.snowballtech.business.user.task.WTaskOrderQuery;
import com.snowballtech.business.user.task.WTaskQueryOrderStatus;
import com.snowballtech.business.user.task.WTaskRechargeCoupon;
import com.snowballtech.business.user.task.WTaskRecordsOnlineQuery;
import com.snowballtech.business.user.task.WTaskRefund;
import com.snowballtech.business.user.task.WTaskSetUid;
import com.snowballtech.business.user.task.WTaskTransQuerySe;

public class IWalletServiceProvider extends SnowballCommon {
    public String setUid() {
        return getiBusinessProcess().processSynchronized(new WTaskSetUid(), getContext(), null, null);
    }

    public String initSe() {
        return getiBusinessProcess().processSynchronized(new WTaskInitSe(), getContext(), null, null);
    }

    public String getCplc() {
        return getiBusinessProcess().process(new WTaskGetCplc(), getContext(), null, null);
    }

    public String isInstanceExisted(String str) {
        return getiBusinessProcess().process(new WTaskIsInstanceExisted(), getContext(), null, str);
    }

    public String transQuerySe(String str) {
        return getiBusinessProcess().processSynchronized(new WTaskTransQuerySe(), getContext(), null, str);
    }

    public String cardSwitch(String str) {
        return getiBusinessProcess().processSynchronized(new WTaskCardSwitch(), getContext(), null, str);
    }

    public String cardDeactivate(String str) {
        return getiBusinessProcess().processSynchronized(new WTaskCardDeactivate(), getContext(), null, str);
    }

    public String cardQuery(String str) {
        return getiBusinessProcess().processSynchronized(new WTaskCardQuery(), getContext(), null, str);
    }

    public String cardListQuery() {
        return getiBusinessProcess().processSynchronized(new WTaskCardListQuery(), getContext(), null, null);
    }

    public String consumeParse(String str) {
        return getiBusinessProcess().process(new WTaskConsumeParse(), getContext(), null, str);
    }

    public String orderQuery(String str) {
        return getiBusinessProcess().process(new WTaskOrderQuery(), getContext(), null, str);
    }

    public String cardCoupon(String str) {
        return getiBusinessProcess().process(new WTaskCardCoupon(), getContext(), null, str);
    }

    public String getPayOrder(String str) {
        return getiBusinessProcess().process(new WTaskGetPayOrder(), getContext(), null, str);
    }

    public String recordsOnlineQuery(String str) {
        return getiBusinessProcess().process(new WTaskRecordsOnlineQuery(), getContext(), null, str);
    }

    public String refund(String str) {
        return getiBusinessProcess().process(new WTaskRefund(), getContext(), null, str);
    }

    public String rechargeCoupon(String str) {
        return getiBusinessProcess().process(new WTaskRechargeCoupon(), getContext(), null, str);
    }

    public String queryOrderStatus(String str) {
        return getiBusinessProcess().process(new WTaskQueryOrderStatus(), getContext(), null, str);
    }
}
