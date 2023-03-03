package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class AckPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.ACK;

    protected AckPattern(JobConfigBuilder builder) {
        super(builder, prod.prodCode, prod.getSupportedRegions(), null);
    }

    public AckPattern addKubernetesAuditLog(){
        addLog(LogEnum.ACK.KubernetesAuditLog.getLogCode());
        return this;
    }

    public AckPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public JobConfigBuilder endAckConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        return super.endConfig();
    }

}
