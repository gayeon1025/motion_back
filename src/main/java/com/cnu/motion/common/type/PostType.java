package com.cnu.motion.common.type;

public enum PostType {
    NOTICE,
    BOARD,
    EXAM,
    GALLERY,
    EDUCATION;

    public boolean is(PostType type) {
        return this == type;
    }
}
