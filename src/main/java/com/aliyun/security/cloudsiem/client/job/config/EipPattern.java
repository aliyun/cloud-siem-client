package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class EipPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.EIP;

    protected EipPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public EipPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public EipPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public EipPattern addEniFlowLog(String projectPattern, String logStoreName) throws CloudSiemClientException {
        addLog(LogEnum.EIP.ENIFlowLog.getLogCode(), projectPattern, logStoreName);
        return this;
    }

    public JobConfigBuilder endEipConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
