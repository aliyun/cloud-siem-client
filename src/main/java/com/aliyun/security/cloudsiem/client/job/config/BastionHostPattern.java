package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class BastionHostPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.Bastionhost;

    protected BastionHostPattern(JobConfigBuilder builder) {
        super(builder, prod.prodCode, prod.getSupportedRegions(), null);
    }

    public BastionHostPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public BastionHostPattern addBastionHostLog(){
        addLog(LogEnum.Bastionhost.BastionhostLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endBastionHostConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        return super.endConfig();
    }
}
