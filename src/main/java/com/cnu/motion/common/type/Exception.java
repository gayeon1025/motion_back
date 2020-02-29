package com.cnu.motion.common.type;

public enum Exception {
    ACCOUNT_NOT_FOUND("exception.account.not-found"),
    BOARD_NOT_FOUND("exception.board.not-found");

    private String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
