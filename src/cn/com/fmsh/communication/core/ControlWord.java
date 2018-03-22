package cn.com.fmsh.communication.core;

public class ControlWord {
    private static /* synthetic */ int[] f9327f;
    private /* synthetic */ MessageType f9328a;
    private /* synthetic */ Direction f9329b;
    private /* synthetic */ CommandType f9330c;
    private /* synthetic */ boolean f9331d;
    private /* synthetic */ byte f9332e;

    public enum CommandType {
        HEARTBEAT(0),
        OPENSESSION(1),
        CLOSESESSION(2),
        BUSINESS_ERROR(3)
    }

    public enum Direction {
        REQUEST(0),
        RESPONSE(1)
    }

    public enum MessageType {
        BUSINESS(0),
        CONTROL(1)
    }

    static /* synthetic */ int[] m13010a() {
        int[] iArr = f9327f;
        if (iArr == null) {
            iArr = new int[CommandType.values().length];
            try {
                iArr[CommandType.BUSINESS_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CommandType.CLOSESESSION.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CommandType.HEARTBEAT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CommandType.OPENSESSION.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            f9327f = iArr;
        }
        return iArr;
    }

    public void fromBytes(byte b) {
        if ((b & 128) != 0) {
            this.f9328a = MessageType.CONTROL;
            switch ((byte) (((byte) (b & 96)) >> 5)) {
                case (byte) 0:
                    this.f9330c = CommandType.HEARTBEAT;
                    break;
                case (byte) 1:
                    this.f9330c = CommandType.OPENSESSION;
                    break;
                case (byte) 2:
                    this.f9330c = CommandType.CLOSESESSION;
                    break;
                case (byte) 3:
                    this.f9330c = CommandType.BUSINESS_ERROR;
                    break;
                default:
                    break;
            }
        }
        this.f9328a = MessageType.BUSINESS;
        if (((byte) (b & 16)) == (byte) 0) {
            this.f9329b = Direction.REQUEST;
        } else {
            this.f9329b = Direction.RESPONSE;
        }
        if (this.f9329b != Direction.RESPONSE) {
            return;
        }
        if (this.f9328a == MessageType.BUSINESS) {
            if ((b & 15) == 0) {
                this.f9331d = false;
            } else {
                this.f9331d = true;
            }
        } else if (this.f9330c != CommandType.HEARTBEAT) {
            this.f9332e = (byte) (b & 15);
        } else if ((b & 15) == 0) {
            this.f9331d = false;
        } else {
            this.f9331d = true;
        }
    }

    public CommandType getCommandType() {
        return this.f9330c;
    }

    public Direction getDirection() {
        return this.f9329b;
    }

    public byte getReponseCode() {
        return this.f9332e;
    }

    public MessageType getType() {
        return this.f9328a;
    }

    public boolean isHaveNews() {
        return this.f9331d;
    }

    public void setCommandType(CommandType commandType) {
        this.f9330c = commandType;
    }

    public void setDirection(Direction direction) {
        this.f9329b = direction;
    }

    public void setHaveNews(boolean z) {
        this.f9331d = z;
    }

    public void setReponseCode(byte b) {
        this.f9332e = b;
    }

    public void setType(MessageType messageType) {
        this.f9328a = messageType;
    }

    public byte toBytes() {
        byte b = (byte) 0;
        if (this.f9328a == MessageType.CONTROL) {
            b = (byte) -128;
            switch (m13010a()[this.f9330c.ordinal()]) {
                case 2:
                    b = (byte) (b | 32);
                    break;
                case 3:
                    b = (byte) (b | 64);
                    break;
                case 4:
                    b = (byte) (b | 96);
                    break;
            }
        }
        if (this.f9329b != Direction.RESPONSE) {
            return b;
        }
        b = (byte) (b & 16);
        return (this.f9330c == CommandType.HEARTBEAT || this.f9328a == MessageType.BUSINESS) ? this.f9331d ? (byte) (b | 1) : b : (byte) (b | (this.f9332e & 15));
    }
}
