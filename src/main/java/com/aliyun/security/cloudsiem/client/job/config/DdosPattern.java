package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class DdosPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.DDoS;

    protected DdosPattern(JobConfigBuilder builder) {
        super(builder, prod.prodCode, prod.getSupportedRegions(), null);
    }

    public DdosPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public DdosPattern addAntiDDosOriginLog(){
        addLog(LogEnum.DDOS.AntiDDosOriginLog.getLogCode());
        return this;
    }

    public DdosPattern addAntiDDosProLog(){
        addLog(LogEnum.DDOS.AntiDDosProLog.getLogCode());
        return this;
    }

    public DdosPattern addAntiDDosLog(){
        addLog(LogEnum.DDOS.AntiDDosLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endDdosConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        return super.endConfig();
    }

}
