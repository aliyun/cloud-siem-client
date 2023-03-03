package com.aliyun.security.cloudsiem.client.job.config;


import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FolderConfig implements Serializable {

    private static final long serialVersionUID = -8995850095574010634L;

    @JSONField
    String folderId;

    @JSONField
    String type;

    List<ProductConfig> prodConfig;


    FolderConfig(){
    }

    protected FolderConfig(String folderId, String type) {
        this.folderId = folderId;
        this.type = type;
        prodConfig = new ArrayList<>();
    }

    public String getFolderId() {
        return folderId;
    }

    protected FolderConfig setFolderId(String folderId) {
        this.folderId = folderId;
        return this;
    }

    public String getType() {
        return type;
    }

    protected FolderConfig setType(String type) {
        this.type = type;
        return this;
    }

    public List<ProductConfig> getProdConfig() {
        return prodConfig;
    }

    protected FolderConfig setProdConfig(List<ProductConfig> prodConfig) {
        this.prodConfig = prodConfig;
        return this;
    }

    FolderConfig addProductConfig(ProductConfig productConfig){
        if(prodConfig == null){
            prodConfig = new ArrayList<>();
        }
        prodConfig.add(productConfig);
        return this;
    }

}
