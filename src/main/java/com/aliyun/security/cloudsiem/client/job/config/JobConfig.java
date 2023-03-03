package com.aliyun.security.cloudsiem.client.job.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serializable;
import java.util.*;

public class JobConfig implements Serializable {

    private static final long serialVersionUID = 5686981972619747561L;

    FolderConfig folderConfig;
    Map<String, LogConfig> logConfigs;
    Set<String> filterUser;
    String configName;
    boolean listenRdChange = false;
    boolean autoSubmit = false;

    @JSONField(serialize = false)
    JobConfigBuilder builder;

    protected JobConfig(JobConfigBuilder builder) {
        this.builder = builder;
//        configs = new ArrayList<>();
        logConfigs = new HashMap<>();
        listenRdChange = builder.listenRdChange;
        autoSubmit = builder.autoSubmitOnFailed;
        filterUser = builder.filterUserList;
        configName = builder.configName;
        builder.logPatternMap.keySet().forEach(key ->{
            JobConfigBuilder.LogPattern pattern = builder.logPatternMap.get(key);
            LogConfig logConfig = new LogConfig(pattern.logCode, pattern.projectPattern, pattern.logStorePattern);
            logConfigs.put(key, logConfig);
        });
        init();
    }

    private void init(){
        FolderConfig config = new FolderConfig(builder.folderId, builder.folderType);
        String[] prodCodes = builder.productConfigMap.keySet().toArray(new String[0]);
        for(String prodCode : prodCodes){
            JobConfigBuilder.ProductPattern productPattern = builder.productConfigMap.get(prodCode);
            ProductConfig productConfig = new ProductConfig(prodCode);
            if(productPattern == null){
                productPattern = builder.defaultProductPattern(prodCode);
            }
            if(productPattern.allRegion){
                productConfig.setAllRegions(productPattern.allRegion);
            }else{
                productConfig.addRegions(productPattern.regions.toArray(new String[0]));
            }

            if(productPattern.allLog) {
                productConfig.setAllLogs(productPattern.allLog);
            }else {
                String[] logCodes = productPattern.logCodes.toArray(new String[0]);
                for(String logCode : logCodes){
                    if(logCode.equalsIgnoreCase("all")){
                        continue;
                    }
                    LogConfig logConfig = new LogConfig(logCode);
                    JobConfigBuilder.LogPattern logPattern = builder.logPatternMap.get(logCode);
                    if(logPattern != null){
                        logConfig.setProjectPattern(logPattern.getProjectPattern()).setLogStorePattern(logPattern.getLogStorePattern());
                    }
                    productConfig.addLogConfig(logConfig);
                }
            }
            config.addProductConfig(productConfig);
        }
        this.folderConfig = config;
    }



    public Map<String, LogConfig> getLogConfigs() {
        return logConfigs;
    }

    void setLogConfigs(Map<String, LogConfig> logConfigs) {
        this.logConfigs = logConfigs;
    }

    public String toConfigString(){
        return JSON.toJSONString(this);
    }

    public boolean isListenRdChange() {
        return listenRdChange;
    }

    public boolean isAutoSubmit() {
        return autoSubmit;
    }

    public void setAutoSubmit(boolean autoSubmit) {
        this.autoSubmit = autoSubmit;
    }

    public FolderConfig getFolderConfig() {
        return folderConfig;
    }

    public void setFolderConfig(FolderConfig folderConfig) {
        this.folderConfig = folderConfig;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }
}
