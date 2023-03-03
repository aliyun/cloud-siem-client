package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class RdsPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.ApsaraDBRDS;

    protected RdsPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public RdsPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public RdsPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public RdsPattern addRDSAuditLog(String projectPattern, String logStorePattern) throws CloudSiemClientException {
        addLog(LogEnum.ApsaraDBRDS.RDSAuditLog.getLogCode(), projectPattern, logStorePattern);
        return this;
    }

    public JobConfigBuilder endRdsConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
