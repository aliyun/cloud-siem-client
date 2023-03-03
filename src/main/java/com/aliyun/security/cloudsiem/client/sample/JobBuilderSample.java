package com.aliyun.security.cloudsiem.client.sample;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;
import com.aliyun.security.cloudsiem.client.job.config.JobConfigBuilder;

public class JobBuilderSample {

    public static void main(String[] args) throws CloudSiemClientException {

        JobConfigBuilder builder = JobConfigBuilder.builder("test_builder");
        String configString = builder.asFolder("fd-xxxx")
            .startActionTrialConfig().addActionTrailLog().endActionTrialConfig()
            .startAckConfig().addKubernetesAuditLog().endAckConfig()
            .startApiGatewayConfig(new String[]{"cn-shanghai"}).addAPIGatewayLog("api-project", "api-logstore").endApiGatewayConfig()
            .startSasConfig().addAllLogs().endSasConfig()
            .startCdnConfig(new String[]{"cn-shanghai"}).addRegion("cn-hangzhou").addCdnFlowLog("cdn-test", "cdn-test").endCdnConfig()
            .startDdosConfig().addAntiDDosLog().addAntiDDosProLog().addAntiDDosOriginLog().endDdosConfig()
            .startCfwConfig().addAllLogs().endCfwConfig()
            .startEipConfig(new String[]{"cn-shanghai"}).addEniFlowLog("eip-test", "eip-test").endEipConfig()
            .startFcConfig(new String[]{"cn-shanghai"}).addFunctionComputeOperationalLog().endFcConfig()
            .startNasConfig(new String[]{"cn-shanghai"}).addNASNFSOperationalLog().endNasConfig()
            .startOssConfig(new String[]{"cn-shanghai"}).addAllLogs().endOssConfig()
            .startBastionHostConfig().addBastionHostLog().endBastionHostConfig()
            .startMongoDbConfig(new String[]{"cn-shanghai"}).addMongoDBAuditLog().addMongoDBOperationalLog().endMongoDbConfig()
            .startRdsConfig(new String[]{"cn-shanghai"}).addRDSAuditLog("rds-test", "rds-test").endRdsConfig()
            .startSlbConfig(new String[]{"cn-shanghai"}).addCLBLayer7Log("clb-test", "clb-test").addALBLayer7Log("alb-test", "alb-test").endSlbConfig()
            .startWafConfig().addAllLogs().endWafConfig()
            .startVpcConfig(new String[]{"cn-shanghai"}).addVpcFlowLog("vpc-test", "vpc-test").endVpcConfig()
            .startPolarDbConfig(new String[]{"cn-shanghai"}).addPolarDB1XAuditLog().addPolarDB2XAuditLog().endPolarDbConfig()
            .build().toConfigString();
        System.out.println(configString);
    }
}
