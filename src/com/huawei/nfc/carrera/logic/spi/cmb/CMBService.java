package com.huawei.nfc.carrera.logic.spi.cmb;

import com.huawei.nfc.carrera.logic.spi.citic.request.ActivateCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyAidRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.NullifyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.PersonalizedRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.SmsCodeRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyAidResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.PersonalizedResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.SmsCodeResponse;

public interface CMBService {
    ActivateOrNullifyCardResponse activateCard(ActivateCardRequest activateCardRequest);

    ApplyAidResponse applyAid(ApplyAidRequest applyAidRequest);

    ApplyCardResponse applyCard(ApplyCardRequest applyCardRequest);

    ActivateOrNullifyCardResponse nullifyCard(NullifyCardRequest nullifyCardRequest);

    PersonalizedResponse personalizeCard(PersonalizedRequest personalizedRequest);

    SmsCodeResponse requestSmsForActivation(SmsCodeRequest smsCodeRequest);
}
