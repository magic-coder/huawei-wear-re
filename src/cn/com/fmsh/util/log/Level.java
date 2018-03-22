package cn.com.fmsh.util.log;

public enum Level {
    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3);

    public static Level instance(int i) {
        for (Level level : values()) {
            if (level.getId() == i) {
                return level;
            }
        }
        return null;
    }

    public int getId() {
        return this.f9861a;
    }
}
