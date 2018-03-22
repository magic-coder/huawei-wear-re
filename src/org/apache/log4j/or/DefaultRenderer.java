package org.apache.log4j.or;

class DefaultRenderer implements ObjectRenderer {
    DefaultRenderer() {
    }

    public String doRender(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
