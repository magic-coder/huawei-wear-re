package cn.com.fmsh.tsm.business.core;

import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import java.util.HashMap;
import java.util.Map;

public class ConfigKeyManager {
    private /* synthetic */ Map<Integer, ConfigKey> f9759a = new HashMap();

    public ConfigKeyManager() {
        m13061a();
    }

    private final /* synthetic */ void m13061a() {
        ConfigKey configKey = new ConfigKey();
        configKey.setIndex(0);
        configKey.setPrivateKey(FM_Bytes.hexStringToBytes(FM_Utils.regionMatches(5, 64, "gQ\u0010 c%d'\u0013-c!\u0013$\u0017-\u0017!gPd%fWfQd#e'mS\u0013,\u0011\"\u0011,\u0013Q\u0013&dP\u0016,\u0011VlSgT\u0011'gW\u0013SlTbPb aW\u0016,cW\u0011P\u0010#\u0017Tg'bS\u0016PgT\u0010Sb\"\u0014TfT\u0010#e'mQ\u0011,\u0016TcSbPa$e\"l eSlWg-\u0014Q\u0013!\u0017V`T\u0010!\u0010\"\u0014Pa$l!\u0011TfW`-eQlVf\"\u0010-\u0017#dS`PmP\u0013 \u0014&fT\u0017Vc,f$\u0010$eTmVm c$c&a\"d$g&\u0011W\u0016VlQ\u0016,b'b,fQlTf \u0014%\u0010 \u0011 g!mW`#\u0016'bQ\u0011#\u0017Te!d%dWa'mS` `\"\u0016,b eTlTb$\u0016S\u0014!d,")));
        configKey.setPublicKey(FM_Bytes.hexStringToBytes(FM_Long.copyValueOf("H=035jidl\u0010vy}\u0006tk\u001anae\u0014\fyvvv.)[W+6;J61E.#.U%:HI=0fi\u001f\u0010`i{\u000bu\u0000pho`\u0011\u0011xy{vvs^/%UWK?9A0\\.+%U'4>05D\u001bma\u0017\u0011\ft}\u0003vthco`\u0013\u000b\b\u000ews^,ZU TH<131_-!&!=HO4E6\u0018kd\u0012\u0017\f\b\nsvf\u001dj\u0012`\u0016{r\u0002s\u0003/][#+;:;C24\\Y&P%791G6je\u001cfc\u0013}|\u0005up\u001di\u001em\u0014\t\t\btvy)\\R\"S7MK0F,-.\"U(K240Gich`g\t\u000f}qz\u0005mc\u0013\u0017\u0010}srq&YZ#*'OI4F@,/Z&T8", 4)));
        this.f9759a.put(Integer.valueOf(configKey.getIndex()), configKey);
        configKey = new ConfigKey();
        configKey.setIndex(1);
        configKey.setPrivateKey(FM_Bytes.hexStringToBytes(Util4Java.endsWith("0w2\u000f9x \u0016*k+\u0002G~<t!d%i(mv<z:\n'\u0016!b/w7v<\t?\u0013\"h_ly5\u0002<|Q\u0016#j*h0wLxKd\"\u0016/d\u0005;K\n7k#\u001a_\u001c0v2<fQ`)\u001e,0}I\u000e>e\"b*\u00188\u00060\r?|+c)\u001e]5\u0000E\f<\u0014&n[d'u0y={$a$c+B\u0007?x<wWb hZsFL\tSf$\u001c+h\u0000=pO\u000fPbVc-\u0004Gs=\u000f;\u0011W`)ls7tO~)f i-gF\u0007=\n=\u0015Ub*\u001e\u0001FrMtM\u0013'\u001a.\u001a2pA}8f!e!\u001a'2w>}J\u0012Pn-\u001e9v6|O\u000b\"\u0014,k\\1pE\f<\u0013+dXi/s5}<y(lT\u001b,", 3, 67)));
        configKey.setPublicKey(FM_Bytes.hexStringToBytes(FM_Bytes.concat("\u001asp'&np\"_1zvW(3\rgX75\rg/@:\u0013m^1?dbu: el\u0007>Ujq\u000eMP\u0019v\rW_C\u0005|SZG\b\u0013/.Gyg(5<g`(79`\u001evM9e\u001brIS`ys:W\u0018\u0005sS.\u001euy-YAph.\\7xb.4Iv\u0015^A=\u0011`s2;edzI#\u001c\u00194&lv)Rjp\nW,6p|$%A|\u0017+8DxlX5:\u0014\u001b.1;emtL!\u0015nu9 m\u0004\u000e:T\u001br\n#!3\u0004yV+4{\u0017+YDu\u0011#4Kef[<;gbuM=al\u0007>*\u001d\u0005w9,\u001et~!!\u001c\u0007u%^Fx\u0012V+1\b`,6M\tcYA2f\u0018\u00025HgeqKR\u001b\u001bt8'", 4, 103)));
        this.f9759a.put(Integer.valueOf(configKey.getIndex()), configKey);
        configKey = new ConfigKey();
        configKey.setIndex(2);
        configKey.setPrivateKey(FM_Bytes.hexStringToBytes(FM_Int.replace(AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, "s|\rv\u0017`o\u001f\u001cpv\u0003z\rw`\u0014o\u0019\u001cD10?9&*!(Z'50>H:T-R+$\u0005tp\ryddlj\u001f\u0002v\u000ez\u0016\u0016\u0012h\u001e\u001b4202KP$Q+)B2><8MWP^XZqtt\f\u000eb\u0016dih\u001e\u0001\u0004\u000fimf\u0018\u001fA340>I$,YY-DA68IT+!+^'ur|~hebclp\u0001~{\fgbhin505H5$#W_]^A0N>>$&!-$xs~~\u0010\u0014ki\u001d\u0003ur\u000fxc\u0015\u0017`\u001eoC=>;;RR$^^04CH49*#,#/\u0002\u0000~{yhkbn\u001ej\u0007\u0006}y}egd\u001bk9:2;9<'P\\Y+E@5L;!#/X(.{")));
        configKey.setPublicKey(FM_Bytes.hexStringToBytes(CRCUtil.substring(78, "\u001f\u0005\u0014\u001e0Q-I\")\u000b\u0016hx\u0014F;\"0N!vt\u0019s\u001d=8.@\"\"whl\u0006kdLU[9P,\t\u0017\u0003x`B9S09Z\u0001\u000bh\u0007\rlF)Z7P$v\u0014o\f`\u001bJ'/=!rz\u0017t~oD<ZBO.\u0006whsc\u001e3 X2 *\n\u0016o\u000bfi2$B;Sp\no\u0004{i@>*5;_u\u0016k\u0004\u0012j3W(1 /{dkrcBOS8>Tsu\u001ev\u000f`<?.2T-p`ovjl;+[9!,r`w\u000enB5S7?/zapz\u00187S+>%Y\u0005\u0017\u001c|k\u001aK,-NS\u0003|cwunGK\\@9!wzo\u0007\u0012n0SZC!.\u000b\u0010kq\u0016o9,09S\u0004\bf\u0006~a3;,5<[we")));
        this.f9759a.put(Integer.valueOf(configKey.getIndex()), configKey);
    }

    public ConfigKey getConfigKey(int i) {
        return (ConfigKey) this.f9759a.get(Integer.valueOf(i));
    }
}
