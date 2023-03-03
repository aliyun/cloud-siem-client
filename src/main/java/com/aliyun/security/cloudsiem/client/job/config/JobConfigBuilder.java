package com.aliyun.security.cloudsiem.client.job.config;

import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

import java.util.*;

public class JobConfigBuilder {

    String configName;
    String folderId;
    String folderType;
    Set<String> filterUserList;
    Map<String, LogPattern> logPatternMap;
    Map<String, ProductPattern> productConfigMap;
    boolean listenRdChange = false;
    boolean autoSubmitOnFailed = false;

    public static JobConfigBuilder builder(String builderName){
        return new JobConfigBuilder(builderName);
    }


    public static String listLog(){
        return ProductUtils.listLogList();
    }

    public static String listLogByProductCode(String prodCode){
        return ProductUtils.listLogListByProductCode(prodCode);
    }

    JobConfigBuilder(String configName){
        this.configName = configName;
        logPatternMap = new HashMap<>();
        productConfigMap = new HashMap<>();
        filterUserList = new HashSet<>();
    }

    private void check(String... args) throws CloudSiemClientException {
        for(String s : args){
            if(s == null || s.trim().length() == 0){
                throw CloudSiemClientException.newParameterException("parameter can not be null");
            }
        }
    }

    public JobConfigBuilder asFolder(String folderId) throws CloudSiemClientException {
        check(folderId);
        if((folderType != null && folderType.equals("user")) || (folderType != null && folderType.equals("folder") && !folderId.equals(this.folderId))){
            throw CloudSiemClientException.newConfigException(String.format("asUser[%s] exception,  the current builder already configured as %s, %s", folderId, this.folderType, this.folderId));
        }
        this.folderId = folderId;
        this.folderType = "folder";
        return this;
    }

    JobConfigBuilder filterUser(String[] userList) throws CloudSiemClientException {
        if(!"folder".equals(this.folderType)){
            throw CloudSiemClientException.newConfigException("only folder config support filter user. ");
        }
        filterUserList.addAll(Arrays.asList(userList));
        return this;
    }

    public JobConfigBuilder asUser(String userId) throws CloudSiemClientException {
        check(folderId);
        if((folderType != null && folderType.equals("folder")) || (folderType != null && folderType.equals("user") && !userId.equals(this.folderId))){
            throw CloudSiemClientException.newConfigException(String.format("asUser[%s] exception,  the current builder already configured as %s, %s", userId, this.folderType, this.folderId));
        }
        this.folderId = userId;
        this.folderType = "user";
        return this;
    }

    public JobConfigBuilder withLogPattern(String logCode, String productPattern, String logStorePattern) throws CloudSiemClientException {
        check(logCode, productPattern, logStorePattern);
        putLogPattern(logCode, productPattern, logStorePattern);
        return this;
    }

    public JobConfigBuilder withProductConfig(String productCode, String[] regions, String[] logCodes) throws CloudSiemClientException {
        check(productCode);
        ProductPattern pattern = new ProductPattern(this, productCode, regions, logCodes);
        if(regions == null || regions.length == 0){
            pattern.allRegion = true;
        }
        if(logCodes == null || logCodes.length == 0){
            pattern.allLog = true;
        }
        productConfigMap.put(productCode, pattern);
        return this;
    }

    JobConfigBuilder putLogPattern(String logCode, String projectPattern, String logStorePattern) throws CloudSiemClientException {
        checkParameters(projectPattern, logStorePattern);
        logPatternMap.put(logCode, new LogPattern(logCode, projectPattern, logStorePattern));
        return this;
    }

    public JobConfigBuilder listenRdChange(boolean listenRdChange){
        this.listenRdChange = listenRdChange;
        return this;
    }

    public JobConfigBuilder autoSubmitOnFailed(boolean autoSubmitOnFailed){
        this.autoSubmitOnFailed = autoSubmitOnFailed;
        return this;
    }

    public JobConfig build() throws CloudSiemClientException {
        return new JobConfig(this);
    }

    ProductPattern defaultProductPattern(String prodCode){
        return new ProductPattern(this, prodCode, null, null);
    }


    public WafPattern startWafConfig(){
        return new WafPattern(this);
    }

    public SasPattern startSasConfig(){
        return new SasPattern(this);
    }

    public CfwPattern startCfwConfig(){
        return new CfwPattern(this);
    }

    public DdosPattern startDdosConfig(){
        return new DdosPattern(this);
    }

    public AckPattern startAckConfig(){
        return new AckPattern(this);
    }

    public BastionHostPattern startBastionHostConfig(){
        return new BastionHostPattern(this);
    }

    public ActionTrialPattern startActionTrialConfig(){
        return new ActionTrialPattern(this);
    }


    public VpcPattern startVpcConfig(String[] regions){
        return new VpcPattern(this, regions);
    }

    public SlbPattern startSlbConfig(String[] regions){
        return new SlbPattern(this, regions);
    }

    public RdsPattern startRdsConfig(String[] regions){
        return new RdsPattern(this, regions);
    }

    public CdnPattern startCdnConfig(String[] regions){
        return new CdnPattern(this, regions);
    }

    public OssPattern startOssConfig(String[] regions){
        return new OssPattern(this, regions);
    }

    public MongoDbPattern startMongoDbConfig(String[] regions){
        return new MongoDbPattern(this, regions);
    }

    public PolarDbPattern startPolarDbConfig(String[] regions){
        return new PolarDbPattern(this, regions);
    }

    public EipPattern startEipConfig(String[] regions){
        return new EipPattern(this, regions);
    }

    public ApiGatewayPattern startApiGatewayConfig(String[] regions){
        return new ApiGatewayPattern(this, regions);
    }

    public NasPattern startNasConfig(String[] regions){
        return new NasPattern(this, regions);
    }

    public FcPattern startFcConfig(String[] regions){
        return new FcPattern(this, regions);
    }

    void checkParameters(String... params) throws CloudSiemClientException {
        for(String s : params){
            if(s == null || s.trim().length() == 0){
                throw CloudSiemClientException.newParameterException("parameter can not be null");
            }
        }
    }

    static class LogPattern{

        String logCode;
        String projectPattern;
        String logStorePattern;

        protected LogPattern(String logCode, String projectPattern, String logStorePattern) {
            this.logCode = logCode;
            this.projectPattern = projectPattern;
            this.logStorePattern = logStorePattern;
        }

        String getLogCode() {
            return logCode;
        }

        String getProjectPattern() {
            return projectPattern;
        }

        String getLogStorePattern() {
            return logStorePattern;
        }
    }

    public static class ProductPattern{

        String prodCode;
        Set<String> regions;
        Set<String> logCodes;
        JobConfigBuilder builder;
        boolean allRegion = false;
        boolean allLog = false;

        protected ProductPattern(JobConfigBuilder builder, String prodCode, String[] region, String[] logCode){
            this.prodCode = prodCode;
            this.builder = builder;
            this.regions = new HashSet<>();
            this.logCodes = new HashSet<>();
            if(logCode != null){
                logCodes.addAll(Arrays.asList(logCode));
            }
            if(region != null){
                regions.addAll(Arrays.asList(region));
            }
        }

        ProductPattern addRegion(String region){
            regions.add(region);
            return this;
        }

        ProductPattern filterRegion(String region){
            if(regions.contains(region)){
                regions.remove(region);
            }
            return this;
        }

        ProductPattern addLog(String logCode){
            logCodes.add(logCode);
            return this;
        }

        ProductPattern addLog(String logCode, String projectPattern, String logStorePattern) throws CloudSiemClientException {
            logCodes.add(logCode);
            builder.putLogPattern(logCode, projectPattern, logStorePattern);
            return this;
        }

        ProductPattern addLogs(String[] logCode){
            logCodes.addAll(Arrays.asList(logCode));
            return this;
        }

        ProductPattern filterLog(String logCode){
            logCodes.remove(logCode);
            return this;
        }

        JobConfigBuilder endConfig() throws CloudSiemClientException {
            if(regions.size() == 0){
                throw CloudSiemClientException.newConfigException(String.format("product %s regions are empty", prodCode));
            }
            if(logCodes.size() == 0){
                throw CloudSiemClientException.newConfigException(String.format("product %s logCodes are empty", prodCode));
            }
            return builder;
        }
    }


}
