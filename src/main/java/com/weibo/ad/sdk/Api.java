package com.weibo.ad.sdk;



public class Api
{
    public static final String API_VERSION = "v1.0.0";

    private String token;

    private String appId;

    private String appSecret;

    private ApiRequest apiRequest;

    private Long customerId = 0L;

    private Long operatorId = 0L;

    private String ragnarName;

    private String baseUrl;




    public Api(String appId, String appSecret, String token) {
        this.token = token;
        this.appId = appId;
        this.appSecret = appSecret;
        this.apiRequest = new ApiRequest(this);
    }

    public void setRagnarName(String ragnarName){
        this.ragnarName = ragnarName;
    }

    public String getRagnarName(){
        return ragnarName;
    }


    public static String getApiVersion() {
        return API_VERSION;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppId() {
        return appId;
    }

    public void setCustomerId(Long id) {
        this.customerId = id;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setOperatorId (Long id) {
        this.operatorId = id;
    }

    public Long getOperatorId() {
        return this.operatorId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public ApiRequest getApiRequest() {
        return apiRequest;
    }

    public void setApiRequest(ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
