package com.aliyun.security.cloudsiem.client.job.config;

import java.io.Serializable;
import java.util.*;

public class ProductConfig implements Serializable {

    private static final long serialVersionUID = -970706013100115421L;

    String prodCode;
    List<String> regions;
    Set<LogConfig> logConfig;
    boolean allLogs;
    boolean allRegions;

    protected ProductConfig(String prodCode) {
        this(prodCode, null, null);
    }

    protected ProductConfig(String prodCode, String[] regions, String[] logCode) {
        this.prodCode = prodCode;
        if(regions != null){
            this.addRegions(regions);
        }
        if(logConfig != null){
            Arrays.stream(logCode).forEach(e -> this.addLogConfig(new LogConfig(e, null, null)));
        }
    }


    public String getProdCode() {
        return prodCode;
    }

    ProductConfig addLogConfig(LogConfig config){
        if(logConfig == null){
            logConfig = new HashSet<>();
        }
        this.logConfig.add(config);
        return this;
    }

    protected ProductConfig setProdCode(String prodCode) {
        this.prodCode = prodCode;
        return this;
    }

    public List<String> getRegions() {
        return regions;
    }


    protected ProductConfig setRegions(List<String> regions) {
        this.regions = regions;
        return this;
    }

    public Set<LogConfig> getLogConfig() {
        return logConfig;
    }

    protected ProductConfig setLogConfig(List<LogConfig> logConfig) {
        this.logConfig = new HashSet<>(logConfig) ;
        return this;
    }

    protected ProductConfig setLogConfig(Set<LogConfig> logConfig) {
        this.logConfig = new HashSet<>(logConfig) ;
        return this;
    }


    ProductConfig addRegions(String[] regionArray){
        Set<String> set = new HashSet<>();
        if(regions != null){
            set.addAll(regions);
        }
        Arrays.stream(regionArray).forEach(e -> set.add(e.toLowerCase(Locale.ROOT)));
        regions = new ArrayList<>(set);
        return this;
    }

    public boolean isAllLogs() {
        return allLogs;
    }

    void setAllLogs(boolean allLogs) {
        this.allLogs = allLogs;
    }

    public boolean isAllRegions() {
        return allRegions;
    }

    void setAllRegions(boolean allRegions) {
        this.allRegions = allRegions;
    }


}
