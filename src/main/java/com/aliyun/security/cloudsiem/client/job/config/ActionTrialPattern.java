package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class ActionTrialPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.ActionTrial;

    protected ActionTrialPattern(JobConfigBuilder builder) {
        super(builder, prod.prodCode, prod.getSupportedRegions(), null);
    }

    public ActionTrialPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public ActionTrialPattern addActionTrailLog(){
        addLog(LogEnum.ACTION_TRAIL.ActionTrailLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endActionTrialConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        return super.endConfig();
    }

}
