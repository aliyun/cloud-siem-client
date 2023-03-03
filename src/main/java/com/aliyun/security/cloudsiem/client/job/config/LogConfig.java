package com.aliyun.security.cloudsiem.client.job.config;

import java.io.Serializable;
import java.util.Objects;

public class LogConfig implements Serializable {

    String logCode;
    String projectPattern;
    String logStorePattern;

    protected LogConfig(){
    }

    protected LogConfig(String logCode){
        this(logCode, null, null);
    }

    protected LogConfig(String logCode, String projectPattern, String logStorePattern) {
        this.logCode = logCode;
        this.projectPattern = projectPattern;
        this.logStorePattern = logStorePattern;
    }

    public String getLogCode() {
        return logCode;
    }

    LogConfig setLogCode(String logCode) {
        this.logCode = logCode;
        return this;
    }


    public String getProjectPattern() {
        return projectPattern;
    }

    LogConfig setProjectPattern(String projectPattern) {
        this.projectPattern = projectPattern;
        return this;
    }

    public String getLogStorePattern() {
        return logStorePattern;
    }

    LogConfig setLogStorePattern(String logStorePattern) {
        this.logStorePattern = logStorePattern;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        LogConfig logConfig = (LogConfig) o;
        return logCode.equals(logConfig.logCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logCode);
    }
}
