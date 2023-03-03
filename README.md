    辅助工具类，帮助构建复杂的Request。
    批量任务接入，需要按资源目录、云产品的信息，输入日志的配置信息，比如以下json配置：
```{"autoSubmit":false,"configName":"test_builder","folderConfig":{"folderId":"rd-EUx7Qp","prodConfig":[{"allLogs":false,"allRegions":false,"logConfig":[{"logCode":"cloud_siem_rds_audit_log","logStorePattern":"vpc-test","projectPattern":"vpc-test"}],"prodCode":"rds","regions":["cn-shanghai"]},{"allLogs":true,"allRegions":true,"prodCode":"sas"}],"type":"folder"},"listenRdChange":false,"logConfigs":{"cloud_siem_rds_audit_log":{"logCode":"cloud_siem_rds_audit_log","logStorePattern":"vpc-test","projectPattern":"vpc-test"}}}```

可以使用Builder辅助构建。
```
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
```
