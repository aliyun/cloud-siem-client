package com.aliyun.security.cloudsiem.client.sample;

import com.aliyun.security.cloudsiem.client.job.config.JobConfigBuilder;

public class JobBuilderListLogSample {

    public static void main(String[] args){

        String logJson = JobConfigBuilder.listLog();
        String prodJson = JobConfigBuilder.listLogByProductCode("sas");
        System.out.println(logJson);
        System.out.println(prodJson);
    }
}
