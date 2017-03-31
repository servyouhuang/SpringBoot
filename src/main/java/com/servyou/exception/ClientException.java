package com.servyou.exception;

public class ClientException extends Exception {

    private static final long serialVersionUID = 7725124121173340830L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ClientException() {
    }

    public ClientException(String code) {
        super("");
        this.code = code;
    }

    public ClientException(Throwable cause) {
        super(cause);
    }

    public ClientException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ClientException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
