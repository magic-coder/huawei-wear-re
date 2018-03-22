package cn.com.fmsh.communication.message.core;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.IMessage;
import cn.com.fmsh.communication.message.IMessageHandler;
import cn.com.fmsh.communication.message.enumerate.ETagType;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.snowballtech.business.constant.BusinessCode;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MessageHandler implements IMessageHandler {
    private /* synthetic */ FMLog f9443a = LogFactory.getInstance().getLog();
    private /* synthetic */ String f9444b = MessageHandler.class.getName();
    private /* synthetic */ Map<Byte, C2876b> f9445c = new HashMap();
    private /* synthetic */ Map<Integer, C2875a> f9446d = new HashMap();
    private /* synthetic */ Map<Integer, C2875a> f9447e = new HashMap();
    private /* synthetic */ boolean f9448f = false;

    public Message createMessage(int i) {
        return new Message(this, i);
    }

    public Message createMessage(int i, byte[] bArr) throws FMCommunicationMessageException {
        Message message = new Message();
        return message.fromPackageBody(i, bArr) == 0 ? message : null;
    }

    public Message createMessage(byte[] bArr) throws FMCommunicationMessageException {
        Message message = new Message();
        return message.fromPackageBody(bArr) == 0 ? message : null;
    }

    public IMessage createMessageAndRetCode(int i, byte[] bArr) throws FMCommunicationMessageException {
        IMessage message = new Message();
        return message.fromPackageBodyAndRetCode(i, bArr) == 0 ? message : null;
    }

    public IMessage createMessageAndRetCode(byte[] bArr) throws FMCommunicationMessageException {
        IMessage message = new Message();
        return message.fromPackageBodyAndRetCode(bArr) == 0 ? message : null;
    }

    public Tag createTag(byte b) {
        return new Tag(this, b);
    }

    public Tag createTag(byte b, byte[] bArr) throws FMCommunicationMessageException {
        Tag tag = new Tag();
        tag.fromPackageBody(b, bArr);
        return tag;
    }

    public Tag createTag(byte[] bArr) throws FMCommunicationMessageException {
        Tag tag = new Tag();
        tag.fromPackageBody(bArr);
        return tag;
    }

    public C2875a getMessageDefine(int i) {
        return (C2875a) this.f9446d.get(Integer.valueOf(i));
    }

    public C2875a getMessageRetDefine(int i) {
        return (C2875a) this.f9447e.get(Integer.valueOf(i));
    }

    public C2876b getTagDefine(byte b) {
        return (C2876b) this.f9445c.get(Byte.valueOf(b));
    }

    public boolean isLoad() {
        return this.f9448f;
    }

    public int loadDefine(InputStream inputStream) throws FMCommunicationMessageException {
        if (inputStream == null) {
            throw new FMCommunicationMessageException(BCCUtil.getChars("酕缲旇亲动轱奡赱", 296, 100));
        }
        try {
            int i;
            Node item;
            int i2;
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
            NodeList elementsByTagName = documentElement.getElementsByTagName(CRCUtil.substring(1, "Zxc"));
            for (i = 0; i < elementsByTagName.getLength(); i++) {
                C2876b c2876b = new C2876b();
                item = elementsByTagName.item(i);
                NamedNodeMap attributes = item.getAttributes();
                Node namedItem = attributes.getNamedItem(BCCUtil.getChars("%y", ReportInfoUtils.FEEDBACK_FAILED, 49));
                if (namedItem != null) {
                    c2876b.setId((byte) Integer.parseInt(namedItem.getNodeValue(), 16));
                }
                namedItem = attributes.getNamedItem(FM_Exception.insert(5, 4, "ehrmu"));
                if (namedItem != null) {
                    c2876b.setLength(Integer.parseInt(namedItem.getNodeValue()));
                }
                namedItem = attributes.getNamedItem(CRCUtil.substring(3, "dbvt"));
                if (namedItem != null) {
                    c2876b.setType(ETagType.valueOf(namedItem.getNodeValue()));
                }
                Node namedItem2 = attributes.getNamedItem(FM_Long.copyValueOf("hlu`", 4));
                if (namedItem2 != null) {
                    c2876b.setDesc(namedItem2.getNodeValue());
                }
                NodeList childNodes = item.getChildNodes();
                for (i2 = 0; i2 < childNodes.getLength(); i2++) {
                    namedItem = childNodes.item(i2);
                    if (namedItem != null) {
                        if (FM_Bytes.concat("Zlxo", BusinessCode.CURRENCY_CODE_RMB, 5).equals(namedItem.getNodeName())) {
                            NamedNodeMap attributes2 = namedItem.getAttributes();
                            C2877c c2877c = new C2877c();
                            Node namedItem3 = attributes2.getNamedItem(Util4Java.endsWith(";o*", 114, 63));
                            if (namedItem3 != null) {
                                c2877c.setTag((byte) Integer.parseInt(namedItem3.getNodeValue(), 16));
                            }
                            namedItem3 = attributes2.getNamedItem(FM_Long.copyValueOf("nbwb", 2));
                            if (namedItem3 != null) {
                                c2877c.setDesc(namedItem3.getNodeValue());
                            }
                            namedItem3 = attributes2.getNamedItem(FM_CN.equals("<7?0|v{m", TransportMediator.KEYCODE_MEDIA_PLAY));
                            if (namedItem3 != null) {
                                c2877c.setMultiple(Integer.parseInt(namedItem3.getNodeValue()));
                            }
                            namedItem3 = attributes2.getNamedItem(BCCUtil.getChars("6.0/+", 3, 3));
                            if (namedItem3 != null) {
                                c2877c.setExist(Integer.parseInt(namedItem3.getNodeValue()));
                            }
                            namedItem = attributes2.getNamedItem(FM_Int.replace(240, "*:/+#"));
                            if (namedItem != null) {
                                c2877c.setOrder(Integer.parseInt(namedItem.getNodeValue()));
                            }
                            c2876b.addTagItem(c2877c);
                        }
                    } else if (this.f9443a != null) {
                        this.f9443a.warn(this.f9444b, FM_Exception.insert(5, 58, "助輾\tV\u0016宑丌斘亯日ａS\u0000\u001c芗烶丳稹"));
                    }
                }
                this.f9445c.put(Byte.valueOf(c2876b.getId()), c2876b);
            }
            NodeList elementsByTagName2 = documentElement.getElementsByTagName(FM_Int.replace(5, "\u00178spgni"));
            for (i = 0; i < elementsByTagName2.getLength(); i++) {
                item = elementsByTagName2.item(i);
                NamedNodeMap attributes3 = item.getAttributes();
                String nodeValue = attributes3.getNamedItem(CRCUtil.substring(3, "stbt")).getNodeValue();
                Node namedItem4 = attributes3.getNamedItem(FM_Int.replace(1, "$<(\u001cmam"));
                C2875a c2875a = new C2875a();
                c2875a.setMessageCode(Integer.parseInt(nodeValue));
                if (namedItem4 != null) {
                    c2875a.setRetCode(namedItem4.getNodeValue());
                }
                elementsByTagName = item.getChildNodes();
                for (i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                    Node item2 = elementsByTagName.item(i2);
                    if (item2 != null) {
                        if (BCCUtil.getChars("\u0016|<2", 2, 43).equals(item2.getNodeName())) {
                            NamedNodeMap attributes4 = item2.getAttributes();
                            MessageTagDefine messageTagDefine = new MessageTagDefine();
                            Node namedItem5 = attributes4.getNamedItem(Util4Java.endsWith("U+t", 4, 73));
                            if (namedItem5 != null) {
                                messageTagDefine.setTag((byte) Integer.parseInt(namedItem5.getNodeValue(), 16));
                            }
                            namedItem5 = attributes4.getNamedItem(CRCUtil.substring(110, "6s}hnbq-"));
                            if (namedItem5 != null) {
                                messageTagDefine.setMultiple(Integer.parseInt(namedItem5.getNodeValue()));
                            }
                            namedItem5 = attributes4.getNamedItem(Util4Java.endsWith("d'th-", 4, 94));
                            if (namedItem5 != null) {
                                messageTagDefine.setExist(Integer.parseInt(namedItem5.getNodeValue()));
                            } else {
                                messageTagDefine.setExist(1);
                            }
                            item2 = attributes4.getNamedItem(FM_Utils.regionMatches(5, 77, ":0k9{"));
                            if (item2 != null) {
                                messageTagDefine.setOrder(Integer.parseInt(item2.getNodeValue()));
                            }
                            c2875a.addMessageData(messageTagDefine);
                        }
                    } else if (this.f9443a != null) {
                        this.f9443a.warn(this.f9444b, CRCUtil.substring(254, "劫轫UMP寘丄旟亵斸ｕ涌恠芘炼个穡"));
                    }
                }
                if (c2875a.getRetCode() == null) {
                    this.f9446d.put(Integer.valueOf(c2875a.getMessageCode()), c2875a);
                } else {
                    this.f9447e.put(Integer.valueOf(c2875a.getMessageCode()), c2875a);
                }
            }
            this.f9448f = true;
            if (this.f9443a != null) {
                this.f9443a.info(this.f9444b, FM_Exception.insert(4, 8, "dyd(}}3;1?%h37nny {e{%;#"));
            }
            return 0;
        } catch (Exception e) {
            if (this.f9443a != null) {
                this.f9443a.error(this.f9444b, Util4Java.getExceptionInfo(e));
            }
            throw new FMCommunicationMessageException(new StringBuilder(FM_Bytes.concat("鄔缽旊亱勡輦彗幷", 2, 122)).append(Util4Java.getExceptionInfo(e)).toString());
        } catch (Exception e2) {
            if (this.f9443a != null) {
                this.f9443a.error(this.f9444b, Util4Java.getExceptionInfo(e2));
            }
            throw new FMCommunicationMessageException(new StringBuilder(FM_Utils.regionMatches(5, 106, "鄘缱旎以劽轺当幣")).append(Util4Java.getExceptionInfo(e2)).toString());
        } catch (Exception e22) {
            if (this.f9443a != null) {
                this.f9443a.error(this.f9444b, Util4Java.getExceptionInfo(e22));
            }
            throw new FMCommunicationMessageException(new StringBuilder(FM_CN.equals("鄘缨旐亾効轷弙帴", 2)).append(Util4Java.getExceptionInfo(e22)).toString());
        }
    }
}
