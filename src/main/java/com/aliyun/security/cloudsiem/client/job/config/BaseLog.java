package com.aliyun.security.cloudsiem.client.job.config;

public class BaseLog {

    String prodCode;
    String logCode;
    String logName;
    String logNameEn;
    boolean checkPattern;

    protected BaseLog(String en) {
        this.logNameEn = en;
    }

    @Override
    public String toString() {
        return "BaseLog{" +
            "prodCode='" + prodCode + '\'' +
            ", logCode='" + logCode + '\'' +
            ", logName='" + logName + '\'' +
            ", checkPattern=" + checkPattern +
            '}';
    }

    private BaseLog(String prodCode, String logCode, String logName) {
        this.prodCode = prodCode;
        this.logCode = logCode;
        this.logName = logName;
        this.checkPattern = false;
    }

    private BaseLog(String prodCode, String logCode, String logName, boolean checkPattern) {
        this.prodCode = prodCode;
        this.logCode = logCode;
        this.logName = logName;
        this.checkPattern = checkPattern;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public boolean isCheckPattern() {
        return checkPattern;
    }

    public void setCheckPattern(boolean checkPattern) {
        this.checkPattern = checkPattern;
    }

    public String getLogNameEn() {
        return logNameEn;
    }

    public void setLogNameEn(String logNameEn) {
        this.logNameEn = logNameEn;
    }
}