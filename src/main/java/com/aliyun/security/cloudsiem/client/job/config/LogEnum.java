package com.aliyun.security.cloudsiem.client.job.config;

public final class LogEnum {

    public enum SecurityCenter implements ProductLog{

        VulnerabilityLog("sas", "cloud_siem_aegis_vul_log", "漏洞日志"),
        SecurityCenterAlertLog("sas", "cloud_siem_aegis_sas_alert", "云安全中心告警日志"),
        ProcessSnapshotLog("sas", "cloud_siem_aegis_proc_snapshot", "进程快照日志"),
        ProcessStartupLog("sas", "cloud_siem_aegis_proc", "进程启动日志"),
        PortSnapshotLog("sas", "cloud_siem_aegis_port_snapshot", "端口快照日志"),
        NetworkSnapshotLog("sas", "cloud_siem_aegis_netstat_snapshot", "网络快照日志"),
        NetworkConnectionLog("sas", "cloud_siem_aegis_netstat", "网络连接日志"),
        LogonLog("sas", "cloud_siem_aegis_login_event", "登录流水日志"),
        BaselineLog("sas", "cloud_siem_aegis_health_check", "基线日志"),
        ReadAndWriteLogsOfFiles("sas", "cloud_siem_aegis_file_log", "文件读写日志"),
        DNSLog("sas", "cloud_siem_aegis_dns", "DNS解析日志"),
        FailedMySQLOrFTPLogonLogs("sas", "cloud_siem_aegis_crack_from_beaver", "Mysql/FTP登录失败日志"),
        FailedHostLogonLog("sas", "cloud_siem_aegis_crack_failed_log", "主机登录失败日志"),
        InternetSessionLog("sas", "cloud_siem_aegis_beaver_session", "互联网Session日志"),
        InternetHttpLog("sas", "cloud_siem_aegis_beaver_http", "互联网Http日志"),
        InternetDnsLog("sas", "cloud_siem_aegis_beaver_dns", "互联网Dns日志"),
        AccountSnapshotLog("sas", "cloud_siem_aegis_account_snapshot", "账号快照日志");

        BaseLog baseLog;


        SecurityCenter(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        SecurityCenter(String prodCode, String logCode, String logName, boolean checkPattern){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = checkPattern;
        }

        public String getProdCode() {
            return baseLog.prodCode;
        }

        public String getLogCode() {
            return baseLog.logCode;
        }

        public String getLogName() {
            return baseLog.logName;
        }

        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

        public String toString(){
            return baseLog.toString();
        }

    }

    public enum Bastionhost implements ProductLog{

        BastionhostLog("bastionhost", "cloud_siem_bastionhost_event", "堡垒机日志");

        BaseLog baseLog;

        Bastionhost(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }


//            @Override
//            public Log[] allValues(){
//                return IntegrateSecurityCenter.values();
//            }
    }

    public enum WAF implements ProductLog{

        WAFFlowLog("waf", "cloud_siem_waf_flow", "WAF流日志"),
        WAFAlertLog("waf", "cloud_siem_waf_alert", "WAF告警日志");

        BaseLog baseLog;

        WAF(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum VPC implements ProductLog{

        VPCFlowLog("vpc", "cloud_siem_vpc_flow_log", "VPC流日志");

        BaseLog baseLog;

        VPC(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = true;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum ObjectStorage implements ProductLog{

        OSSMeteringLog("oss", "cloud_siem_oss_meter_log", "OSS计量日志"),
        OSSBatchDeletionLog("oss", "cloud_siem_oss_delete_log", "OSS批量删除日志"),
        OSSFlowLog("oss", "cloud_siem_oss_access_log", "OSS流日志");

        BaseLog baseLog;

        ObjectStorage(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum DDOS implements ProductLog{

        AntiDDosOriginLog("ddos", "cloud_siem_ddos_protect_log", "DDoS原生防护日志"),
        AntiDDosProLog("ddos", "cloud_siem_ddos_coo_log", "DDoS新BGP高防流日志"),
        AntiDDosLog("ddos", "cloud_siem_ddos_gf_log", "DDoS高防流日志(老高防)");

        BaseLog baseLog;

        DDOS(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum ACTION_TRAIL implements ProductLog{

        ActionTrailLog("actiontrail", "cloud_siem_trail_actiontrail", "操作审计日志");

        BaseLog baseLog;

        ACTION_TRAIL(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum APIGateway implements ProductLog{

        APIGatewayLog("apigateway", "cloud_siem_apigateway_log", "API网关日志");

        BaseLog baseLog;

        APIGateway(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = true;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum AlibabaCloudCDN implements ProductLog{

        CDNFlowLog("cdn", "cloud_siem_cdn_flow_log", "CDN流日志");

        BaseLog baseLog;

        AlibabaCloudCDN(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = true;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum CFW implements ProductLog{

        CloudFirewallFlowLog("cfw", "cloud_siem_cfw_flow", "云防火墙流日志"),
        CloudFirewallAlertLog("cfw", "cloud_siem_cfw_alert", "云防火墙告警日志");

        BaseLog baseLog;

        CFW(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum ACK implements ProductLog{

        KubernetesAuditLog("csk", "cloud_siem_k8s_audit", "K8S审计日志");

        BaseLog baseLog;

        ACK(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum EIP implements ProductLog{

        ENIFlowLog("eip", "cloud_siem_vpc_eni_log", "弹性网卡流日志");

        BaseLog baseLog;

        EIP(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = true;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum FunctionCompute implements ProductLog{

        FunctionComputeOperationalLog("fc", "cloud_siem_fc_log", "函数计算运行日志");
        BaseLog baseLog;
        FunctionCompute(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum MongoDB implements ProductLog{

        MongoDBOperationalLog("mongodb", "cloud_siem_mongodb_flow_log", "MongoDB运行日志"),
        MongoDBAuditLog("mongodb", "cloud_siem_mongodb_audit_log", "MongoDB审计日志");

        BaseLog baseLog;

        MongoDB(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum NAS implements ProductLog{

        NASNFSOperationalLog("nas", "cloud_siem_nas_audit_log", "NAS NFS运行日志");

        BaseLog baseLog;
        NAS(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum POLARDB implements ProductLog{

        PolarDB1XAuditLog("polardb", "cloud_siem_polardb1x_audit", "polardb1x审计日志"),
        PolarDB2XAuditLog("polardb", "cloud_siem_polardb2x_audit", "polardb1x审计日志");


        BaseLog baseLog;
        POLARDB(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = false;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum ApsaraDBRDS implements ProductLog{

        RDSAuditLog("rds", "cloud_siem_rds_audit_log", "RDS审计日志");

        BaseLog baseLog;

        ApsaraDBRDS(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = true;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

    public enum SLB implements ProductLog{

        CLBLayer7Log("slb", "cloud_siem_vpc_slb7l_log", "CLB7层日志"),
        ALBLayer7Log("slb", "cloud_siem_alb_flow_log", "ALB流日志");


        BaseLog baseLog;
        SLB(String prodCode, String logCode, String logName){
            baseLog = new BaseLog(name());
            baseLog.prodCode = prodCode;
            baseLog.logCode = logCode;
            baseLog.logName = logName;
            baseLog.checkPattern = true;
        }

        @Override
        public String getProdCode() {
            return baseLog.prodCode;
        }

        @Override
        public String getLogCode() {
            return baseLog.logCode;
        }

        @Override
        public String getLogName() {
            return baseLog.logName;
        }

        @Override
        public boolean checkPattern(){
            return baseLog.checkPattern;
        }

        public String toString(){
            return baseLog.toString();
        }

        public BaseLog getBaseLog(){
            return baseLog;
        }

    }

}
