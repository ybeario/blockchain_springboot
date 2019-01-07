package com.cqupt.bear.blockchain.common.exception;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 570191527602767524L;

    private String errorCode;

    private Object[] args;

    public BaseException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BaseException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public BaseException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BaseException(String errorCode, Throwable cause, Object... args) {
        super(cause);
        this.errorCode = errorCode;
        this.args = args;
    }

    public String getErrorCode() {
        return errorCode;
    }

    protected Object[] getArgs() {
        return args;
    }

}
