package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class WafPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.WAF;

    protected WafPattern(JobConfigBuilder builder) {
        super(builder, prod.prodCode, prod.getSupportedRegions(), null);
    }

    public WafPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }
    public WafPattern addWafAlertLog(){
        addLog(LogEnum.WAF.WAFAlertLog.getLogCode());
        return this;
    }

    public WafPattern addWafFlowLog(){
        addLog(LogEnum.WAF.WAFFlowLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endWafConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prodCode, this);
        return super.endConfig();
    }

}
