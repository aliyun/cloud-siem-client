package com.aliyun.security.cloudsiem.client.job.config;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.aliyun.security.cloudsiem.client.exception.CloudSiemClientException;

import java.util.*;

public class ProductUtils {

    static Set<String> prods = new HashSet<>();
    static Map<String, ProductLog> code2LogMapping = new HashMap<>();
    static Map<String, ProductEnum> code2ProductMapping = new HashMap<>();

    static{
        Arrays.stream(ProductEnum.values()).forEach(e -> {
            prods.add((e.prodCode));
            code2ProductMapping.put(e.prodCode, e);
            e.supportedLog.forEach( log -> {
                code2LogMapping.put((log).getLogCode(), log);
            });
        });
    }

    static String listLogList(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prodCount", prods.size());
        jsonObject.put("logCount", code2LogMapping.size());
        JSONArray array = new JSONArray();
        for(String key : prods){
            array.add(listLogListByProductCodeInner(key));
        }
        jsonObject.put("logList", array);
        return jsonObject.toString();
    }

    static String listLogListByProductCode(String prodCode){
        if(listLogListByProductCodeInner(prodCode) == null){
            return null;
        }
        return listLogListByProductCodeInner(prodCode).toString();
    }

    static JSONObject listLogListByProductCodeInner(String prodCode){
        if(code2ProductMapping.get(prodCode) == null){
            return null;
        }
        return code2ProductMapping.get(prodCode).getJsonObject();
    }

    public static void checkProdCode(String prodCode) throws CloudSiemClientException {
        String content = Arrays.toString(prods.toArray(new String[0]));
        if(prodCode == null){
            throw CloudSiemClientException.newParameterException("product code error, input is null, excepted " + content);
        }
        if(!prods.contains(prodCode)){
            throw CloudSiemClientException.newParameterException("product code error, input is " + prodCode + ", excepted " + content);
        }
        return;
    }

    public static void checkRegions(String prodCode, String[] regions) throws CloudSiemClientException {
        for(String s : regions){
            checkRegion(prodCode, s);
        }
    }

    public static void checkRegion(String prodCode, String region) throws CloudSiemClientException {
        if(!prods.contains(prodCode)){
            throw CloudSiemClientException.newParameterException("product code error, input is " + prodCode);
        }
        if(!code2ProductMapping.get(prodCode).regions.contains(region)){
            throw CloudSiemClientException.newParameterException(String.format("regionCode error, input regionCode is %s, product[%s] support region list is %s", region, prodCode, Arrays.toString(code2ProductMapping.get(prodCode).getSupportedRegions())));
        }
        return;
    }

    public static void checkLogCode(String prodCode, String logCode) throws CloudSiemClientException {
        checkProdCode(prodCode);
        ProductEnum productEnum = code2ProductMapping.get(prodCode);
        ProductLog log = code2LogMapping.get(logCode);
        if(!productEnum.supportedLog.contains(log)){
            throw CloudSiemClientException.newParameterException("prodCode and logCode mismatch, prodCode is " + prodCode + ", excepted logCodes are " + Arrays.toString(productEnum.getSupportedLogCodes()) + ", but input logCode is " + logCode + ". ");
        }
    }

    public static void checkLogCode(ProductLog log) throws CloudSiemClientException {
        String prodCode = log.getProdCode();
        String logCode = log.getLogCode();
        ProductUtils.checkLogCode(prodCode, logCode);
    }


}
