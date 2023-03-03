package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class PolarDbPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.PolarDB;

    protected PolarDbPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public PolarDbPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public PolarDbPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public PolarDbPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public PolarDbPattern addPolarDB1XAuditLog() throws CloudSiemClientException {
        addLog(LogEnum.POLARDB.PolarDB1XAuditLog.getLogCode());
        return this;
    }

    public PolarDbPattern addPolarDB2XAuditLog() throws CloudSiemClientException {
        addLog(LogEnum.POLARDB.PolarDB2XAuditLog.getLogCode());
        return this;
    }


    public JobConfigBuilder endPolarDbConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
