package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class VpcPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.VPC;

    protected VpcPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public VpcPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public VpcPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public VpcPattern addVpcFlowLog(String projectPattern, String logStorePattern) throws CloudSiemClientException {
        addLog(LogEnum.VPC.VPCFlowLog.getLogCode(), projectPattern, logStorePattern);
        return this;
    }


    public JobConfigBuilder endVpcConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }

}
