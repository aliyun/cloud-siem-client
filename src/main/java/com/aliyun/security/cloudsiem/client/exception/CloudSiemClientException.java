package com.aliyun.security.cloudsiem.client.exception;

public class CloudSiemClientException extends Exception{

    String errCode;
    String errMessage;

    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    CloudSiemClientException(String errCode, String errMessage){
        super(String.format("%s errCode     : %s %s errMessage  : %s. ", System.lineSeparator(), errCode, System.lineSeparator(), errMessage));
        this.errCode = errCode;
        this.errMessage = errMessage;

    }

    public static CloudSiemClientException newConfigException(String errMsg){
        return new CloudSiemClientException("ConfigException", errMsg);
    }

    public static CloudSiemClientException newParameterException(String errMsg){
        return new CloudSiemClientException("ParameterException", errMsg);
    }
}
