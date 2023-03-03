package com.aliyun.security.cloudsiem.client.sample;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;
import com.aliyun.security.cloudsiem.client.job.config.JobConfigBuilder;

public class JobBuilderNormalSample {

    public static void main(String[] args) throws CloudSiemClientException {

//        JobConfigBuilder builder = JobConfigBuilder.builder("test_builder");
//        String configString = builder.asFolder("fd-599jmbEyYH")
//            .withLogPattern("cloud_siem_vpc_flow_log", "vpc-test", "vpc-test")
//            .withProductConfig("vpc", new String[]{"cn-shanghai"}, new String[]{"cloud_siem_vpc_flow_log"})
//            .withProductConfig("waf", null, null)
//            .build().toConfigString();
//        System.out.println(configString);
        JobConfigBuilder builder = JobConfigBuilder.builder("test_builder");
        String configString = builder.asFolder("rd-EUx7Qp")
            .withLogPattern("cloud_siem_rds_audit_log", "vpc-test", "vpc-test")
            .withProductConfig("rds", new String[]{"cn-shanghai"}, new String[]{"cloud_siem_rds_audit_log"})
            .withProductConfig("sas", null, null)
            .build().toConfigString();
        System.out.println(configString);
    }
}
