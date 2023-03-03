package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class ApiGatewayPattern extends JobConfigBuilder.ProductPattern{

    static ProductEnum prod = ProductEnum.APIGateway;

    protected ApiGatewayPattern(JobConfigBuilder builder, String[] regions) {
        super(builder, prod.prodCode, regions, null);
    }

    public ApiGatewayPattern addRegion(String region){
        super.addRegion(region);
        return this;
    }

    public ApiGatewayPattern filterRegion(String region){
        super.filterRegion(region);
        return this;
    }

    public ApiGatewayPattern addAPIGatewayLog(String projectPattern, String logStoreName) throws CloudSiemClientException {
        addLog(LogEnum.APIGateway.APIGatewayLog.getLogCode(), projectPattern, logStoreName);
        return this;
    }

    public JobConfigBuilder endApiGatewayConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        ProductUtils.checkRegions(prodCode, regions.toArray(new String[0]));
        return super.endConfig();
    }

}
