package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class MongoDbPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.MongoDB;

    protected MongoDbPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public MongoDbPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public MongoDbPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public MongoDbPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public MongoDbPattern addMongoDBAuditLog() throws CloudSiemClientException {
        addLog(LogEnum.MongoDB.MongoDBAuditLog.getLogCode());
        return this;
    }

    public MongoDbPattern addMongoDBOperationalLog() throws CloudSiemClientException {
        addLog(LogEnum.MongoDB.MongoDBOperationalLog.getLogCode());
        return this;
    }

    public JobConfigBuilder endMongoDbConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }
}
