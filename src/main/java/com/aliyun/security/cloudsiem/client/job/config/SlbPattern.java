package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class SlbPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.SLB;

    protected SlbPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public SlbPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public SlbPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public SlbPattern addCLBLayer7Log(String projectPattern, String logStorePattern) throws CloudSiemClientException {
        addLog(LogEnum.SLB.CLBLayer7Log.getLogCode(), projectPattern, logStorePattern);
        return this;
    }

    public SlbPattern addALBLayer7Log(String projectPattern, String logStorePattern) throws CloudSiemClientException {
        addLog(LogEnum.SLB.ALBLayer7Log.getLogCode(), projectPattern, logStorePattern);
        return this;
    }

    public JobConfigBuilder endSlbConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
