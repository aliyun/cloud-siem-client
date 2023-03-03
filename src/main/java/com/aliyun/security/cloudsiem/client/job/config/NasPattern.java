package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class NasPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.NAS;

    protected NasPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public NasPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public NasPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public NasPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public NasPattern addNASNFSOperationalLog() throws CloudSiemClientException {
        addLog(LogEnum.NAS.NASNFSOperationalLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endNasConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
