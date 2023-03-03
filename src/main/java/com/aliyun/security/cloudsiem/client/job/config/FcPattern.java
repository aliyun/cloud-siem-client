package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class FcPattern extends JobConfigBuilder.ProductPattern{


    static ProductEnum prod = ProductEnum.FunctionCompute;

    protected FcPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public FcPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public FcPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public FcPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public FcPattern addFunctionComputeOperationalLog() throws CloudSiemClientException {
        addLog(LogEnum.FunctionCompute.FunctionComputeOperationalLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endFcConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
