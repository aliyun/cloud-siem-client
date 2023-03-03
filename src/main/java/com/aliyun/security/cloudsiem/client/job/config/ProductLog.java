package com.aliyun.security.cloudsiem.client.job.config;

public interface ProductLog {

    String getProdCode();
    String getLogCode();
    String getLogName();
    boolean checkPattern();
    String toString();
    BaseLog getBaseLog();

}
