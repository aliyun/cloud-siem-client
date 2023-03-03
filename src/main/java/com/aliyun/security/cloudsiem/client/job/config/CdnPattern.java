package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class CdnPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.AlibabaCloudCDN;

    protected CdnPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public CdnPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public CdnPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public CdnPattern addCdnFlowLog(String projectPattern, String logStorePattern) throws CloudSiemClientException {
        addLog(LogEnum.AlibabaCloudCDN.CDNFlowLog.getLogCode(), projectPattern, logStorePattern);
        return this;
    }

    public JobConfigBuilder endCdnConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
