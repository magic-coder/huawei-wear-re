package cn.com.fmsh.tsm.business.exception;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.datatype.SportType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.snowballtech.business.constant.BusinessCode;
import org.apache.log4j.net.SyslogAppender;

public class BusinessException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = 1392832484088949611L;
    private /* synthetic */ ErrorMessage f9840a;

    public enum ErrorMessage {
        local_business_cancel(FM_CN.equals("4nq", 282), C2898a.local, BCCUtil.getChars("么勿奎琐迅稅乷ｊ揷攨刺叀涊捉亾", 2, 108)),
        local_business_apdu_handler_null(FM_Int.replace(166, "\".16"), C2898a.local, FM_Utils.regionMatches(1, 60, "\u0010]\rP捆仹奝琓嘹朧没冉")),
        local_business_execute_fail(FM_Exception.insert(4, 48, "1(x+"), C2898a.local, FM_Long.copyValueOf("C\u000f\u0018\f捑亷奔瑋嘢奃瑂\u0000\u000e\u001f\r订氐奾赩", 250)),
        local_business_init_fail(Util4Java.endsWith("`=q!", ReportInfoUtils.FEEDBACK_FAILED, 52), C2898a.local, BCCUtil.getChars("乔勭奎瑎嘮剙妉卖夯费", 94, TransportMediator.KEYCODE_MEDIA_PLAY)),
        local_business_no_card_app_type(FM_Long.copyValueOf("3744", 2), C2898a.local, Util4Java.endsWith("沶朝宨廚籰垃盁匣", 154, 29)),
        local_business_apdu_handler_busying(Util4Java.endsWith("f//i", 2, 32), C2898a.local, CRCUtil.substring(4, "PLCG挚京套瑘嘡欷徆")),
        local_message_platform_business_handle_fail(FM_Long.copyValueOf("3746", 2), C2898a.local, FM_Long.copyValueOf("幾叺夃琂丛勿奪赽", 5)),
        local_business_local_data_handler_null(FM_Long.copyValueOf("#'$)", 306), C2898a.local, FM_CN.equals("杴坹攪挥夘琋噶丵空", 5)),
        local_business_para_error(FM_Utils.regionMatches(308, 21, "=)~z"), C2898a.local, FM_Exception.insert(5, 80, "凴攩谊畱斿５压敩弋幡")),
        local_communication_connect_fail(FM_CN.equals("owiy", 3), C2898a.local, FM_Long.copyValueOf("绅童咋幷叱盚钥揽奤起", 5)),
        local_communication_connect_param_error(CRCUtil.substring(118, ":>(5"), C2898a.local, FM_Long.copyValueOf("终窲呋帤厤钯揫讼氊斳ｎ使儹盝帥厣钮揨侫怨斤攉", 248)),
        local_communication_disconnect_fail(FM_Int.replace(6, "bn06"), C2898a.local, FM_CN.equals("纅窱儼閭刡绊竼皀钫揣冭珸弛帲", 250)),
        local_communication_sign_in_fail(FM_Long.copyValueOf("4:67", 5), C2898a.local, FM_Long.copyValueOf("组竦筸刳失赸", 4)),
        local_communication_request_param_error(BCCUtil.getChars("hu(y", 1, 84), C2898a.local, BCCUtil.getChars("纙窶吐幺叡七加课汓旯ｍ纁窾捞亥斩攙", 1, 8)),
        local_communication_no_response(FM_Bytes.concat("c/5~", 3, 69), C2898a.local, FM_Int.replace(2, "纟窵杷收刳幵叹皈庛筆敥捶")),
        local_communication_invalid_version(FM_Int.replace(60, "($&\""), C2898a.local, FM_Bytes.concat("纓窶遍侴卖盕爇条斫攁", 4, TransportMediator.KEYCODE_MEDIA_PLAY)),
        local_communication_invalid_format(BCCUtil.getChars("l6f1", 5, 49), C2898a.local, FM_CN.equals("统竧议氈攫挢校弁旿敘", 164)),
        local_communication_invalid_verify(Util4Java.endsWith("~51q", SdkConstants.REQUEST_PHOTOS, 94), C2898a.local, FM_Int.replace(106, "拺旅梅髄奺赫")),
        local_communication_invalid_control(FM_Int.replace(132, "`lm3"), C2898a.local, FM_Exception.insert(4, 86, "旨攖皐抯旇掱刺嬕")),
        local_communication_invalid_session(BCCUtil.getChars("h&)r", 1, 37), C2898a.local, FM_Utils.regionMatches(5, 53, "斵敂盛伎讔")),
        local_communication_invalid_session_serial(FM_Exception.insert(1, 113, "<fuk"), C2898a.local, FM_Bytes.concat("佁试浔氶锖诳", 4, 13)),
        local_communication_invalid_direction(FM_Exception.insert(108, 82, "ir&r"), C2898a.local, FM_Long.copyValueOf("伐诚浅氵镇讴", 2)),
        local_communication_invalid_response(CRCUtil.substring(2, "6*7%"), C2898a.local, BCCUtil.getChars("递诳庄筐攨换无攜", 280, 84)),
        local_communication_no_key(FM_Long.copyValueOf("2875", 3), C2898a.local, FM_Exception.insert(86, 64, "遀俻斬６杰扤乗刪遀俻儶钿")),
        local_communication_sign_out_fail(FM_CN.equals(",6%0", 194), C2898a.local, FM_CN.equals("笱遀奠赧", ReportInfoUtils.FEEDBACK_FAILED)),
        local_communication_register_notify_exception(Util4Java.endsWith("99!+", 3, 9), C2898a.local, FM_Utils.regionMatches(5, 51, "遏俩淓恡奅瑒噯沲冁彂幫")),
        local_message_load_config_fail(FM_Int.replace(100, "`ljr"), C2898a.local, FM_Utils.regionMatches(172, 15, "劼轶W,+47bq酎罼旆亦奮赫")),
        local_message_command_data_invaild(FM_Bytes.concat("ad%=", 1, 92), C2898a.local, FM_Bytes.concat("早敎皇平厭咗廃攤挿", 146, 125)),
        local_message_apdu_execute_exception(FM_Bytes.concat("cz/y", 3, 80), C2898a.local, FM_Int.replace(4, "\u0018\f\u001bW挂们扬衂弓帬")),
        local_message_message_handle_exception(CRCUtil.substring(SportType.SPORT_TYPE_SWIM, "*.< "), C2898a.local, CRCUtil.substring(4, "\\yta|/6奚瑏冮珯弈席")),
        local_message_open_mobile_exception(FM_Exception.insert(192, 45, "}a+~"), C2898a.local, FM_Int.replace(162, "Xjxn#kfnf~p凢玫弜幹")),
        local_get_app_info_fail(FM_Utils.regionMatches(344, 30, "qv<2"), C2898a.local, FM_Exception.insert(FitnessSleepType.HW_FITNESS_DREAM, 75, "菧反卧乛庈畯俳怲她贶")),
        local_apdu_reponse_invalid(FM_Int.replace(4, "`lg3"), C2898a.local, FM_Int.replace(138, ">ra}挌仪皕哙広旺敕")),
        local_get_app_info_no_sptcc(FM_Exception.insert(4, 58, "1rd$"), C2898a.local, FM_Int.replace(5, "乗晲上浴亢逓卭")),
        local_app_load_config_fail(Util4Java.endsWith(":-`!", 6, 58), C2898a.local, FM_Bytes.concat("乂励酅缮旟亦动载天赵", 1, 24)),
        local_app_config_invaild_content(FM_Int.replace(2, "njj1"), C2898a.local, Util4Java.endsWith("久勪酚缭斈亭凂宪斿敃", 2, 76)),
        local_app_query_app_no_fail(BCCUtil.getChars("my)a", 4, 85), C2898a.local, FM_Exception.insert(5, 58, "绁窬菪叁匰皏廑男廖刄厺夶赤")),
        local_app_query_server_fail(BCCUtil.getChars("h3b4", 1, 50), C2898a.local, FM_CN.equals("桸捼栺捺丟勷侦怷菾双徎讣闣盚帼厰奠赧", 206)),
        business_order_codenot_exist(Util4Java.endsWith("28>%", 5, 6), C2898a.remote, FM_CN.equals("仱晕亴硉且孒圳", 2)),
        business_invalid_message_format(FM_Long.copyValueOf("*'$#", 146), C2898a.remote, FM_Exception.insert(288, 111, "抡斔栾彞镙讠")),
        business_invalid_message_type(FM_Exception.insert(6, 96, ":zz9"), C2898a.remote, FM_Int.replace(5, "斺攕的涋恩籲垇")),
        business_message_check_fail(FM_Int.replace(38, "+.10"), C2898a.remote, FM_Exception.insert(268, 62, "抵旉棌髆夹赣")),
        business_business_no_support(BCCUtil.getChars("bip2", 2, 103), C2898a.remote, FM_Utils.regionMatches(3, 35, "讶丌劸曞乒攭捄")),
        business_platform_busy(FM_Long.copyValueOf(";854", 3), C2898a.remote, Util4Java.endsWith("糢纖忀e议稄偀冄诌", 316, 48)),
        business_invalid_terminal(CRCUtil.substring(60, "ydo}"), C2898a.remote, BCCUtil.getChars("戝杸细竵叱斲攖", 102, 108)),
        business_operate_timeout(FM_Utils.regionMatches(2, 33, "b#$m"), C2898a.remote, Util4Java.endsWith("撒伝趆斳＋设釆旽癴弄", 2, 66)),
        business_repeat_message(FM_Int.replace(266, "o248"), C2898a.remote, BCCUtil.getChars("釟夏南", 34, 112)),
        business_message_invalid_serial(FM_CN.equals("hykz", 5), C2898a.remote, BCCUtil.getChars("南庐剛厮下辍续", 2, 45)),
        business_serial_not_exist(FM_Long.copyValueOf(":753", 2), C2898a.remote, FM_Long.copyValueOf("厒绂竨亠昒洟汯厯乘嬊坧", 5)),
        business_system_error(Util4Java.endsWith("%;0c", SyslogAppender.LOG_LOCAL3, 118), C2898a.remote, Util4Java.endsWith("糾细锔诮", SyslogAppender.LOG_LOCAL5, SpecialIssueType.BUG_TYPE_ID_CHARGE)),
        business_invalid_message_length(FM_CN.equals("hyk~", 5), C2898a.remote, Util4Java.endsWith("抧斈镣庯锏讬", 5, 13)),
        business_trade_timeout(FM_Long.copyValueOf(";844", 3), C2898a.remote, FM_Int.replace(5, "仾晎超旵")),
        business_1920_unknow(FM_Long.copyValueOf("853(", 32), C2898a.remote, FM_Int.replace(5, "kd23本矬锕诠")),
        business_interface_version_error(FM_Long.copyValueOf(";84:", 3), C2898a.remote, FM_Long.copyValueOf("丐劦採叢爖杷镁论", 2)),
        business_merchants_not_exist(BCCUtil.getChars("dyoj", 4, 117), C2898a.remote, CRCUtil.substring(HttpStatus.SC_MOVED_TEMPORARILY, "啝扱乜嬄坯")),
        business_business_stop(Util4Java.endsWith("1k'?", 4, 90), C2898a.remote, FM_CN.equals("审讬唜扼差偑歼朂务", 5)),
        business_business_will_exist(FM_Long.copyValueOf("<942", 4), C2898a.remote, FM_Int.replace(3, "乂勺匭將掬函＆尰诧朌従")),
        business_system_unknow_error(FM_Exception.insert(296, 54, "<r!w"), C2898a.remote, FM_CN.equals("粯纚杼瞢锁详", 1)),
        OT_CHECK_FAIL(Util4Java.endsWith(",wd2", BusinessCode.CURRENCY_CODE_RMB, 46), C2898a.remote, CRCUtil.substring(214, "廗畦寐裁凉夝朩圠赟桺寰枹奶起")),
        OT_APPLY_SIR_FAIL(FM_Long.copyValueOf("8:66", 5), C2898a.remote, BCCUtil.getChars("呂歧贐爣甴讣杌劯寅侃彀番司ｔz?1９奬贯", 3, 77)),
        OT_STATE_CHANGE_NOTICE(FM_Utils.regionMatches(5, 16, "`5$6"), C2898a.remote, FM_Long.copyValueOf("名款贋牪叁赺朇劦犲怀历暯遂瞰奣赪", 276)),
        OT_AC_REQUEST_NOTICE(FM_Exception.insert(2, 56, "3.g:"), C2898a.remote, FM_CN.equals("呅止赋爾叉赾搠席\u001d\u000e覚剖盄弓歧朞劥邽缴讠氊夨贯", 1)),
        OT_BUSY(Util4Java.endsWith("fmi`", 2, TransportMediator.KEYCODE_MEDIA_PLAY), C2898a.remote, FM_Long.copyValueOf("ES幷叱欽坳奜瑓寛袊冊奎", 2)),
        user_unregistered(Util4Java.endsWith("07=#", 4, 6), C2898a.remote, FM_Bytes.concat("畳戮杽泽凟", 4, 62)),
        user_incorrect_password(FM_Exception.insert(5, 104, "8aip"), C2898a.remote, FM_CN.equals("畿承実硋世歯硳", 4)),
        user_not_sign(FM_Int.replace(SportType.SPORT_TYPE_CLIMB_HILL, "hlo0"), C2898a.remote, FM_Utils.regionMatches(1, 33, "畹戥朹笪绳")),
        user_sign_apply(FM_Exception.insert(5, 19, "8,?q"), C2898a.remote, FM_Int.replace(74, "男扵坭笶续畽讦乹")),
        user_sign_fail(FM_Int.replace(5, "km07"), C2898a.remote, CRCUtil.substring(282, "筹纴夬赭")),
        user_sign_sucess(FM_Exception.insert(2, 37, "7;``"), C2898a.remote, FM_Long.copyValueOf("笲绯嶴打募", 196)),
        user_logout(FM_Exception.insert(252, 97, "1qr5"), C2898a.remote, FM_Utils.regionMatches(1, 98, "畹扤巧泿镙")),
        user_register(FM_CN.equals("j|my", SportType.SPORT_TYPE_TREADMILL), C2898a.remote, BCCUtil.getChars("畾戢左治凞", SportType.SPORT_TYPE_SWIM, 31)),
        user_severance(Util4Java.endsWith("<>h", 272, 33), C2898a.remote, FM_Utils.regionMatches(4, 67, "畼戠嶨觾约")),
        user_not_login(FM_CN.equals("fxis", 4), C2898a.remote, FM_Int.replace(5, "畲扪未癸当")),
        user_id_not_matching(FM_CN.equals("t&6(", 82), C2898a.remote, FM_Bytes.concat("畫扴躨仾讂侢恬与卺鄎", 76, 32)),
        user_locked(FM_Exception.insert(3, 42, "6!j4"), C2898a.remote, FM_CN.equals("申戻嶯镏寅", 40)),
        user_freeze(BCCUtil.getChars("d0zd", 5, 43), C2898a.remote, Util4Java.endsWith("畡戠嶷冨绒", 204, 78)),
        user_get_password_count_exceed(FM_Long.copyValueOf("c}z", 106), C2898a.remote, FM_Int.replace(284, "寗砕扩囄巯经辽制彚早丅陂")),
        user_info_incomplete(FM_Exception.insert(3, 47, "6&t "), C2898a.remote, FM_Long.copyValueOf("甬戶沶凗侹怺也寃攸ｅ讱蠦儅瘦诪皯儧侰怡", 252)),
        user_auth_code_invalid(FM_Int.replace(252, "`dfl"), C2898a.remote, Util4Java.endsWith("畯扲讧诀砞桼髗夨贲", SdkConstants.REQUEST_PHOTOS, 30)),
        user_auth_code_mobile_invalid(BCCUtil.getChars("}+;.", 348, 111), C2898a.remote, FM_Bytes.concat("髅讌砐扞杣厪响泭内戆杫叢且九膵", 242, 100)),
        not_support_retrieve_email(FM_CN.equals("pbr,", 110), C2898a.remote, BCCUtil.getChars("寄硅下敧挋郢箿戮囌", 178, 66)),
        user_auth_code_type_invalid(CRCUtil.substring(2, ">*4)"), C2898a.remote, FM_Int.replace(4, "髕讝硞籹垎丅匲酃")),
        user_auth_code_expire(FM_Int.replace(5, "km23"), C2898a.remote, FM_Exception.insert(1, 27, "骉证砚嶤辖朓")),
        sptc_open_exception(FM_CN.equals("iyhz", 5), C2898a.remote, FM_Bytes.concat("仯逕卲彗遁収甜弅平ｃ诤釚讎", 212, 100)),
        sptc_close_exception(BCCUtil.getChars("iaxq", SportType.SPORT_TYPE_TREADMILL, 121), C2898a.remote, FM_CN.equals("任遊匠兡问叅甚彔广ｔ设釗诞", 108)),
        sptc_personalization_fail(FM_Bytes.concat("j$?u", 132, 25), C2898a.remote, FM_Bytes.concat("份遑卼乥任包奴贲", 2, 82)),
        app_issuer_fail(FM_Int.replace(3, "ikl5"), C2898a.remote, FM_Bytes.concat("畱扷卦原衙奭账", 2, 71)),
        sptc_data_not_matching(Util4Java.endsWith("1!p*", 3, 49), C2898a.remote, Util4Java.endsWith("仯逆匬攮捡乍匨鄏", 110, 49)),
        card_invaild_check(BCCUtil.getChars("bu$y", 3, 82), C2898a.remote, BCCUtil.getChars("匲牓髙诗斷敐", 3, 65)),
        card_not_order(FM_Int.replace(3, "ikm0"), C2898a.remote, FM_CN.equals("匢爓诧贻兴糣丄嬂坣", 112)),
        card_order_by_other(FM_Utils.regionMatches(150, 3, "79?="), C2898a.remote, BCCUtil.getChars("匴牜诣赪兾糨乔卦酈ｇ嶣袼八井泡冃畽扬讣赪", 5, 38)),
        user_order_open(FM_Bytes.concat("hub.", 2, 108), C2898a.remote, FM_Utils.regionMatches(140, 26, "畴戡巢诨赩乊卹巠彌遜")),
        user_unsubscribe_closed(FM_Utils.regionMatches(68, 11, "%/ya"), C2898a.remote, FM_Utils.regionMatches(5, 47, "畽戳嶡适讳乔兼闳介劃肶")),
        user_order_no_open(FM_Int.replace(5, "km36"), C2898a.remote, Util4Java.endsWith("甩戼嶧诽贤伕辅札彑遁", 4, 42)),
        user_order_fail(FM_Bytes.concat("mz+p", 5, 78), C2898a.remote, Util4Java.endsWith("當戫诸贵奧贱", 1, 62)),
        user_unsubscribe_fail(FM_Exception.insert(1, 11, "4 (1"), C2898a.remote, FM_Int.replace(4, "畱扫遟讠头购")),
        user_order_invaild_info(Util4Java.endsWith("n02:", 2, 1), C2898a.remote, FM_Exception.insert(246, 64, "诸贷侻恵攪捴杓间飂")),
        sptc_app_not_issuer(CRCUtil.substring(5, "#-;*"), C2898a.remote, FM_Bytes.concat("仸遐匹廒甼木丛輣", 5, 110)),
        sptc_personalization(FM_Utils.regionMatches(4, 78, "er$n"), C2898a.remote, BCCUtil.getChars("价逐匠巪寃或丷仮匝", 3, 55)),
        invaild_personalization_info(FM_Int.replace(3, "ikj0"), C2898a.remote, FM_Exception.insert(1, 75, "丯仪匍收捿乑跴")),
        ack_card_app_unpersonal(FM_Bytes.concat("m48&", 5, 8), C2898a.remote, FM_Utils.regionMatches(282, 11, "庞甽未両京南")),
        ack_card_app_unprepare(BCCUtil.getChars("yrhe", 120, 122), C2898a.remote, BCCUtil.getChars("廆畴宏裕朰凂変", 2, 10)),
        ack_card_app_order_fail(FM_Bytes.concat("m{n}", 5, 111), C2898a.remote, FM_Utils.regionMatches(3, 110, "畻扶霑访账戉劘狣恂")),
        ack_card_app_unorder_fail(FM_Utils.regionMatches(198, 54, "'|6m"), C2898a.remote, FM_CN.equals("畱扽霅遌访戞劀犦怀", 134)),
        no_suppert_in_card(BCCUtil.getChars("{\"n4", 90, 72), C2898a.remote, FM_Bytes.concat("曞下政挛冁卯", 5, 10)),
        no_suppert_out_card(FM_CN.equals("eubp", 1), C2898a.remote, FM_Bytes.concat("暉乜攸捜奕卨", 52, 70)),
        business_order_not_exist(FM_Exception.insert(278, 60, "+g\""), C2898a.remote, BCCUtil.getChars("请卛乊存坱", 5, 57)),
        business_order_apply_no_pay(FM_Int.replace(3, "ijn3"), C2898a.remote, FM_Int.replace(338, "该匟嶿畣认し杳房歡")),
        business_order_pay_no_write(FM_Exception.insert(3, 72, "6~'l"), C2898a.remote, FM_Int.replace(1, "说匌嶮戼欼〄朢兎倲")),
        business_order_recharge_sucess(FM_CN.equals("ixj", 5), C2898a.remote, FM_Utils.regionMatches(NFCBaseActivity.TO_ADD, 42, "诬匍巰纃儓值扚勋")),
        business_order_amount_inconsistent(FM_Long.copyValueOf("<;71", 5), C2898a.remote, Util4Java.endsWith("讠匛醋飛丟笸", 5, 108)),
        business_order_unsettled_exist(CRCUtil.substring(218, "vcm>"), C2898a.remote, FM_Int.replace(1, "嬎坱厳痎讠卐")),
        business_order_recharget_fail(FM_Bytes.concat("hv%t", 2, 78), C2898a.remote, Util4Java.endsWith("讣匄以時奰贴", 4, 112)),
        business_order_apply_refund(FM_Bytes.concat("bp%", 252, 110), C2898a.remote, FM_Bytes.concat("诹卙甮诹速歮乬", 4, 17)),
        business_order_refund(FM_Long.copyValueOf("wrpd", NFCBaseActivity.TO_ADD), C2898a.remote, FM_Utils.regionMatches(366, 33, "诼匊已遁歼")),
        business_order_rechargeting(FM_CN.equals("&9(:", 196), C2898a.remote, Util4Java.endsWith("讳协欠坤儐偢乪", 308, 9)),
        business_order_paying(FM_Bytes.concat("l|l|", SportType.SPORT_TYPE_SWIM, 112), C2898a.remote, FM_CN.equals("诵匝欺坢攴仔丰", 4)),
        business_order_no_refund(BCCUtil.getChars("9js", SyslogAppender.LOG_LOCAL3, 115), C2898a.remote, FM_Long.copyValueOf("议卜下胾退正", 4)),
        business_order_card_no_inconsistent(FM_Exception.insert(4, 61, "9t3,"), C2898a.remote, FM_Long.copyValueOf("让卝绔官盛匽厮哚板歱仩晙盃匥厶乓乛膬", 3)),
        business_order_invoice(FM_Long.copyValueOf(";655", 2), C2898a.remote, FM_CN.equals("厅礭嶤飁収", 1)),
        business_order_no_invoice(FM_Exception.insert(4, 104, "9aiu"), C2898a.remote, FM_Exception.insert(4, 106, "语筆仸晕巢夫敌ｂ乕肿颊叀发礢")),
        business_unsettled_overrun(FM_Int.replace(5, "kl15"), C2898a.remote, FM_Long.copyValueOf("另疗计单跘辝九阄｝讹辐蠄奁瑄", 1)),
        trade_not_exist(FM_Long.copyValueOf("::53", 3), C2898a.remote, FM_Exception.insert(3, 45, "亣昇乌孖圳")),
        trade_handling(CRCUtil.substring(1, "?+4="), C2898a.remote, FM_Exception.insert(4, 29, "京昖奆瑙乱")),
        trade_fail(FM_Exception.insert(4, 67, "9y>b"), C2898a.remote, FM_Int.replace(326, "亿昍奰赡")),
        trade_sucess(FM_Long.copyValueOf("=;67", 4), C2898a.remote, FM_Long.copyValueOf("仦昌戌劆", 186)),
        trade_act_check_fail(FM_Int.replace(1, "gklh"), C2898a.remote, FM_Int.replace(280, "洶劸仰砗核骐央货")),
        trade_act_used(FM_Bytes.concat("mpx6", 5, 102), C2898a.remote, FM_CN.equals("浣勡亹硊差佲甶", 5)),
        no_activity(FM_Utils.regionMatches(5, 78, "`s!n"), C2898a.remote, BCCUtil.getChars("记叒啍沧杈洧势侳怢", 5, 91));

        enum C2898a {
            private static final /* synthetic */ C2898a[] f9835a = null;
            public static final C2898a local = null;
            public static final C2898a remote = null;

            static {
                local = new C2898a(FM_Utils.regionMatches(3, 101, "?7~ck"), 0);
                remote = new C2898a(FM_Int.replace(344, "?5>9-9"), 1);
                f9835a = new C2898a[]{local, remote};
            }

            private /* synthetic */ C2898a(String str, int i) {
            }

            public static C2898a valueOf(String str) {
                return (C2898a) Enum.valueOf(C2898a.class, str);
            }

            public static C2898a[] values() {
                Object obj = f9835a;
                int length = obj.length;
                Object obj2 = new C2898a[length];
                System.arraycopy(obj, 0, obj2, 0, length);
                return obj2;
            }
        }

        public static ErrorMessage instance(String str) {
            for (ErrorMessage errorMessage : values()) {
                if (errorMessage.getId().equals(str)) {
                    return errorMessage;
                }
            }
            return business_system_unknow_error;
        }

        public String getDesc() {
            return this.f9839c;
        }

        public String getId() {
            return this.f9837a;
        }

        public C2898a getType() {
            return this.f9838b;
        }
    }

    public BusinessException(String str) {
        super(str);
    }

    public BusinessException(String str, ErrorMessage errorMessage) {
        super(str);
        this.f9840a = errorMessage;
    }

    public ErrorMessage getErrorMsg() {
        return this.f9840a;
    }
}
