package com.cqupt.bear.blockchain.common.exception;

public class BusinessException extends BaseException {
    /**
     *
     */
    private static final long serialVersionUID = -6052969006553501912L;

    public BusinessException(String errorCode) {
        super(errorCode);
    }

    public BusinessException(String errorCode, Object... args) {
        super(errorCode, args);
    }

    public BusinessException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BusinessException(String errorCode, Throwable cause, Object... args) {
        super(errorCode, cause, args);
    }
}
