package org.apache.log4j.or.sax;

import org.apache.log4j.or.ObjectRenderer;
import org.xml.sax.Attributes;

public class AttributesRenderer implements ObjectRenderer {
    public String doRender(Object obj) {
        if (obj instanceof Attributes) {
            StringBuffer stringBuffer = new StringBuffer();
            Attributes attributes = (Attributes) obj;
            int length = attributes.getLength();
            Object obj2 = 1;
            for (int i = 0; i < length; i++) {
                if (obj2 != null) {
                    obj2 = null;
                } else {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(attributes.getQName(i));
                stringBuffer.append('=');
                stringBuffer.append(attributes.getValue(i));
            }
            return stringBuffer.toString();
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
