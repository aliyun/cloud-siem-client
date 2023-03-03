package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class CfwPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.CloudFirewall;

    protected CfwPattern(JobConfigBuilder builder) {
        super(builder, prod.prodCode, prod.getSupportedRegions(), null);
    }

    public CfwPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public CfwPattern addCloudFirewallFlowLog(){
        addLog(LogEnum.CFW.CloudFirewallFlowLog.getLogCode());
        return this;
    }

    public CfwPattern addCloudFirewallAlertLog(){
        addLog(LogEnum.CFW.CloudFirewallAlertLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endCfwConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        return super.endConfig();
    }

}
