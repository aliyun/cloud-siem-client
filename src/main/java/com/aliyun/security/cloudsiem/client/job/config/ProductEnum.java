package com.aliyun.security.cloudsiem.client.job.config;

import com.alibaba.fastjson2.JSONObject;

import java.util.*;

public enum ProductEnum {

    SecurityCenter("sas", "云安全中心(态势感知）", Regions.SAS_REGION, LogEnum.SecurityCenter.class),
    Bastionhost("bastionhost", "运维安全中心（堡垒机）", Regions.BASTIONHOST_REGION, LogEnum.Bastionhost.class),
    WAF("waf", "Web应用防火墙", Regions.WAF_REGION, LogEnum.WAF.class),
    VPC("vpc", "专用网络VPC", Regions.VPC_REGION, LogEnum.VPC.class),
    DDoS("ddos", "DDoS", Regions.DDOS_REGION, LogEnum.DDOS.class),
    PolarDB("polardb", "云原生关系型数据库 PolarDB", Regions.POLARDB_REGION, LogEnum.POLARDB.class),
    CloudFirewall("cfw", "云防火墙", Regions.CFW_REGION, LogEnum.CFW.class),
    ActionTrial("actiontrail", "操作审计", Regions.ACTIONTRIAL_REGION, LogEnum.ACTION_TRAIL.class),
    ObjectStorage("oss", "对象存储", Regions.OSS_REGION, LogEnum.ObjectStorage.class),
    SLB("slb", "负载均衡", Regions.SLB_REGION, LogEnum.SLB.class),
    ACK("csk", "容器服务Kubernetes版", Regions.CSK_REGION, LogEnum.ACK.class),
    EIP("eip", "弹性公网IP", Regions.EIP_REGION, LogEnum.EIP.class),
    NAS("nas", "文件存储NAS", Regions.NAS_REGION, LogEnum.NAS.class),
    FunctionCompute("fc", "函数计算", Regions.FC_REGION, LogEnum.FunctionCompute.class),
    APIGateway("apigateway", "API网关", Regions.APIGATEWAY_REGION, LogEnum.APIGateway.class),
    MongoDB("mongodb", "云数据库MongoDB版", Regions.MONGODB_REGION, LogEnum.MongoDB.class),
    AlibabaCloudCDN("cdn", "CDN", Regions.CDN_REGION, LogEnum.AlibabaCloudCDN.class),
    ApsaraDBRDS("rds", "关系型数据库", Regions.RDS_REGION, LogEnum.ApsaraDBRDS.class);

    String prodCode;
    String prodName;
    Set<String> regions;
    ProductLog[] values;
    Set<ProductLog> supportedLog;

    ProductEnum(String prodCode, String prodName, String[] args, Class<? extends ProductLog> clazz) {
        this.prodCode = prodCode;
        this.prodName = prodName;
        regions = new HashSet<>();
        Collections.addAll(regions, args);
        values = clazz.getEnumConstants();
        supportedLog = new HashSet<>(Arrays.asList(values));
    }

    String[] getSupportedRegions() {
        return regions.toArray(new String[0]);
    }

    ProductLog[] getSupportedLogs() {
        return (ProductLog[]) supportedLog.toArray(new ProductLog[0]);
    }

    String[] getSupportedLogCodes() {
        List<String> logCodes = new ArrayList<>(supportedLog.size());
        supportedLog.forEach(e -> {
                logCodes.add(((ProductLog) e).getLogCode());
            }
        );
        return logCodes.toArray(new String[0]);
    }

    JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prodCode", prodCode);
        jsonObject.put("prodName", prodName);
        jsonObject.put("prodNameEn", this.name());
        jsonObject.put("regionList", regions);
        List<BaseLog> list = new ArrayList<>();
        for (ProductLog log : values) {
            list.add(log.getBaseLog());
        }
        jsonObject.put("logCount", list.size());
        jsonObject.put("regionCount", regions.size());
        jsonObject.put("logList", list);
        return jsonObject;
    }

    List<ProductLog> supportedAll() {
        Iterator it = supportedLog.iterator();
        List<ProductLog> list = new ArrayList<>();
        while (it.hasNext()) {
            ProductLog log = (ProductLog) it.next();
            if (log.checkPattern()) {
                list.add(log);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "ProductEnum{" +
            "prodCode='" + prodCode + '\'' +
            ", prodName='" + prodName + '\'' +
            ", regions=" + regions +
            ", supportedLog=" + supportedLog +
            ", values=" + Arrays.toString(values) +
            '}';
    }


}

