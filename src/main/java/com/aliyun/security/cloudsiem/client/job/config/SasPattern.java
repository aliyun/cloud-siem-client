package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

public class SasPattern extends JobConfigBuilder.ProductPattern {

    static ProductEnum prod = ProductEnum.SecurityCenter;

    protected SasPattern(JobConfigBuilder builder) {
        super(builder, prod.prodCode, prod.getSupportedRegions(), null);
    }

    public SasPattern addVulnerabilityLog(){
        addLog(LogEnum.SecurityCenter.VulnerabilityLog.getLogCode());
        return this;
    }

    public SasPattern addSecurityCenterAlertLog(){
        addLog(LogEnum.SecurityCenter.SecurityCenterAlertLog.getLogCode());
        return this;
    }

    public SasPattern addProcessStartupLog(){
        addLog(LogEnum.SecurityCenter.ProcessStartupLog.getLogCode());
        return this;
    }

    public SasPattern addPortSnapshotLog(){
        addLog(LogEnum.SecurityCenter.PortSnapshotLog.getLogCode());
        return this;
    }

    public SasPattern addNetworkSnapshotLog(){
        addLog(LogEnum.SecurityCenter.NetworkSnapshotLog.getLogCode());
        return this;
    }

    public SasPattern addLogonLog(){
        addLog(LogEnum.SecurityCenter.LogonLog.getLogCode());
        return this;
    }

    public SasPattern addBaselineLog(){
        addLog(LogEnum.SecurityCenter.BaselineLog.getLogCode());
        return this;
    }

    public SasPattern addReadAndWriteLogsOfFiles(){
        addLog(LogEnum.SecurityCenter.ReadAndWriteLogsOfFiles.getLogCode());
        return this;
    }

    public SasPattern addDNSLog(){
        addLog(LogEnum.SecurityCenter.DNSLog.getLogCode());
        return this;
    }

    public SasPattern addInternetSessionLog(){
        addLog(LogEnum.SecurityCenter.InternetSessionLog.getLogCode());
        return this;
    }

    public SasPattern addInternetHttpLog(){
        addLog(LogEnum.SecurityCenter.InternetHttpLog.getLogCode());
        return this;
    }

    public SasPattern addInternetDnsLog(){
        addLog(LogEnum.SecurityCenter.InternetDnsLog.getLogCode());
        return this;
    }

    public SasPattern addAccountSnapshotLog(){
        addLog(LogEnum.SecurityCenter.AccountSnapshotLog.getLogCode());
        return this;
    }

    public SasPattern addAllLogs(){
        addLogs(prod.getSupportedLogCodes());
        return this;
    }

    public JobConfigBuilder endSasConfig() throws CloudSiemClientException {
        builder.productConfigMap.put(prod.prodCode, this);
        return super.endConfig();
    }
}
