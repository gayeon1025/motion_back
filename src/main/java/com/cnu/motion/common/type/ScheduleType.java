package com.cnu.motion.common.type;

public enum ScheduleType {
    DEPARTMENT_EVENT(1),
    CLUB_EVENT(2);

    private int value;
    ScheduleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ScheduleType getType(int value) {
        for (ScheduleType type : ScheduleType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }

        return null;
    }
}
