package com.zhh.util.excel;

import java.io.Serializable;

/**
 * @author zhh.yin
 * @version v.1.0.0
 * @description This's class description
 * @date 2018/12/22 17:54
 */
public class ExcelException extends Exception implements Serializable {

    private static final long serialVersionUID = -9087211953447691489L;

    private Integer errCode;
    private String errMessage;

    public ExcelException(Integer errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public ExcelException(String message, Integer errCode, String errMessage) {
        super(message);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public ExcelException(String message, Throwable cause, Integer errCode, String errMessage) {
        super(message, cause);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public ExcelException(Throwable cause, Integer errCode, String errMessage) {
        super(cause);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public ExcelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer errCode, String errMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
