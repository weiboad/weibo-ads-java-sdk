package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.entity.AudienceEntity;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.AudienceModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class AudienceApi extends AbstractApi
{

    private static final String  URI_READING = "/audiences/%d";
    private static final String  URI_LIST    = "/audiences";
    private static final String  URI_CREATE  = "/audiences";
    private static final String  URI_DELETE  = "/audiences/%d";

    public AudienceApi(Api api) {
        super(api);
    }

    /**
     *
     * @param id
     * @return
     * @throws IOException
     */
    public AudienceEntity read(int id) throws ApiException,IOException {
        String data = api.getApiRequest().call(String.format(URI_READING, id));
        return JSON.parseObject(data, AudienceEntity.class);
    }

    /**
     *
     * @param name
     * @param status
     * @param dataSource
     * @param page
     * @param pageSize
     * @return
     * @throws IOException
     */
    public AudienceModel lists(String name, int status, int dataSource, int page, int pageSize) throws  ApiException,IOException{
        String scheme = URI_LIST .concat( "?page=" + page + "&page_size=" + pageSize);
        if (!name.equals("")) {
            scheme +="&name=" + name;
        }
        if (status >= 0) {
            scheme += "&status=" + status;
        }
        if (dataSource >= 0) {
            scheme += "&data_source=" + dataSource;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, AudienceModel.class);
    }


    /**
     *
     * @param name
     * @param fileId
     * @param dataFormat
     * @return
     * @throws IOException
     */
    public AudienceEntity create(String name,  String fileId, int dataFormat) throws
            ApiException, IOException , IllegalAccessException{
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("data_format", String.valueOf(dataFormat));
        params.put("data_source", "1");
        params.put("sub_type", "0");
        params.put("file_id", fileId);
        String data = api.getApiRequest().call(URI_CREATE, "POST", params);
        return JSON.parseObject(data, AudienceEntity.class);
    }

    /**
     *
     * @param name
     * @param packageId
     * @return
     * @throws IOException
     */
    public AudienceEntity create(String name, int audiencesSize, int packageId) throws
            ApiException, IOException{
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("data_source", "2");
        params.put("package_id", String.valueOf(packageId));
        params.put("sub_type", "0");
        params.put("audiences_size", String.valueOf(audiencesSize));
        String data = api.getApiRequest().call(URI_CREATE, "POST", params);
        return JSON.parseObject(data, AudienceEntity.class);
    }

    /**
     *
     * @param name
     * @param mids
     * @return
     * @throws IOException
     */
    public AudienceEntity create(String name, int subType, String[] mids)
            throws  ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("data_source", "3");
        params.put("sub_type", String.valueOf(subType));
        params.put("mids", mids.toString());
        String data = api.getApiRequest().call(URI_CREATE, "POST", params);
        return JSON.parseObject(data, AudienceEntity.class);
    }


    /**
     *
     * @param name
     * @return
     * @throws IOException
     */
    public AudienceEntity create(String name, int subType, int[] adIds, String bhv, String startTime, String endTime,
            int ratio, int seed)
            throws  ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("data_source", "3");
        params.put("sub_type", String.valueOf(subType));
        params.put("ad_ids", adIds.toString());
        params.put("bhv", bhv);
        params.put("start_time", startTime);
        params.put("end_time", endTime);
        params.put("bhv", String.valueOf(ratio));
        params.put("seed", String.valueOf(seed));
        String data = api.getApiRequest().call(URI_CREATE, "POST", params);
        return JSON.parseObject(data, AudienceEntity.class);
    }

    /**
     *
     * @param id
     * @return
     * @throws IOException
     */
    public HashMap<String, String> delete(int id) throws  ApiException, IOException {
        String data = api.getApiRequest().call(String.format(URI_DELETE, id), "DELETE");
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

}
