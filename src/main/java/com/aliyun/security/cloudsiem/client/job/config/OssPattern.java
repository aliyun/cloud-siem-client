package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class OssPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.ObjectStorage;

    protected OssPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public OssPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public OssPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public OssPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public OssPattern addOSSFlowLog() throws CloudSiemClientException {
        addLog(LogEnum.ObjectStorage.OSSFlowLog.getLogCode());
        return this;
    }

    public OssPattern addOSSBatchDeletionLog() throws CloudSiemClientException {
        addLog(LogEnum.ObjectStorage.OSSBatchDeletionLog.getLogCode());
        return this;
    }

    public OssPattern addOSSMeteringLog() throws CloudSiemClientException {
        addLog(LogEnum.ObjectStorage.OSSMeteringLog.getLogCode());
        return this;
    }


    public JobConfigBuilder endOssConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
