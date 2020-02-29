package com.cnu.motion.common.type;

public enum Exception {
    ACCOUNT_NOT_FOUND("exception.account.not-found"),

    // Board
    BOARD_NOT_FOUND("exception.board.not-found"),
    NOT_AUTHENTICATED_USER_FOR_DELETION("exception.board.not-authenticated-user-for-deletion");

    private String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
