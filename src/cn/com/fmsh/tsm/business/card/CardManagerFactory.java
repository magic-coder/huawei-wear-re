package cn.com.fmsh.tsm.business.card;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.tsm.business.card.base.CardManager;
import cn.com.fmsh.tsm.business.card.core.LntAppManager;
import cn.com.fmsh.tsm.business.card.core.ShTourAppManager;
import cn.com.fmsh.tsm.business.card.core.StpcManager;
import cn.com.fmsh.tsm.business.constants.Constants;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.util.ArrayList;
import java.util.List;

public class CardManagerFactory {
    private static /* synthetic */ CardManagerFactory f9689c;
    private /* synthetic */ FMLog f9690a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9691b = CardManagerFactory.class.getName();
    private /* synthetic */ ApduHandler f9692d;

    private /* synthetic */ CardManagerFactory() {
    }

    public static CardManagerFactory instance() {
        if (f9689c == null) {
            f9689c = new CardManagerFactory();
        }
        return f9689c;
    }

    public EnumCardAppType getCardAppType() throws BusinessException {
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        if (this.f9690a == null) {
            this.f9690a = LogFactory.getInstance().getLog();
        }
        try {
            bArr = this.f9692d.transceive(bArr);
            if (FM_Bytes.isEnd9000(bArr)) {
                return (bArr[bArr.length + -4] < Constants.TagName.TERMINAL_BASEBAND_VERSION || bArr[bArr.length - 4] > Constants.TagName.CP_NO) ? EnumCardAppType.CARD_APP_TYPE_SH : EnumCardAppType.CARD_APP_TYPE_SH_TOUR;
            } else {
                if (this.f9690a != null) {
                    this.f9690a.warn(this.f9691b, new StringBuilder(Util4Java.endsWith("获収匱皌簻垓斦＄\u0001\bT\u001d指亼扷蠄异帠j", 3, 56)).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                throw new BusinessException(BCCUtil.getChars("莱厍匱盁簡埄斲５诵叕)8斅亡好赤", 150, 117), ErrorMessage.local_business_execute_fail);
            }
        } catch (Exception e) {
            if (this.f9690a != null) {
                this.f9690a.warn(this.f9691b, new StringBuilder(FM_Exception.insert(3, 117, "F,53捜亴戢衖凵玴弛帶")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            if (this.f9692d != null) {
                this.f9692d.close();
            }
            throw new BusinessException(BCCUtil.getChars("\t~p/指仢戫蠞凢玮彆帲", 120, 38), ErrorMessage.local_business_execute_fail);
        }
    }

    public List<EnumCardAppType> getCardAppTypes() throws BusinessException {
        if (this.f9690a == null) {
            this.f9690a = LogFactory.getInstance().getLog();
        }
        if (this.f9690a != null) {
            this.f9690a.debug(this.f9691b, FM_CN.equals("菡厑匹簲垑刜衴#pa", 3));
        }
        if (this.f9692d == null) {
            if (this.f9690a != null) {
                this.f9690a.error(this.f9691b, CRCUtil.substring(4, "莦及卦籩垖剟蠻斨ｅ\u0015\u000fN@处琍噾乻稶"));
            }
            throw new BusinessException(FM_Exception.insert(4, 26, "莿叔卽簭埛初衬旨ｔ讥兄刁挢医盐讱闦旻当~_G\u0005q\u0016TOo"), ErrorMessage.local_business_apdu_handler_null);
        }
        List<EnumCardAppType> arrayList = new ArrayList();
        CardManager lntAppManager = new LntAppManager();
        if (this.f9692d.open(lntAppManager.getAid())) {
            lntAppManager.setApduHandler(this.f9692d);
            byte[] appNo = lntAppManager.getAppNo();
            if (appNo != null && appNo.length > 0) {
                arrayList.add(EnumCardAppType.CARD_APP_TYPE_LNT);
            }
        }
        if (this.f9692d.open(new StpcManager().getAid())) {
            EnumCardAppType cardAppType = getCardAppType();
            if (cardAppType != null) {
                arrayList.add(cardAppType);
            }
        }
        return arrayList;
    }

    public CardManager getCardManager(EnumCardAppType enumCardAppType) {
        return enumCardAppType == null ? new StpcManager() : enumCardAppType == EnumCardAppType.CARD_APP_TYPE_SH ? new StpcManager() : (enumCardAppType == EnumCardAppType.CARD_APP_TYPE_SH_TOUR || enumCardAppType == EnumCardAppType.CARD_APP_TYPE_SH_RENT) ? new ShTourAppManager() : new LntAppManager();
    }

    public void setApduHandler(ApduHandler apduHandler) {
        this.f9692d = apduHandler;
    }
}
