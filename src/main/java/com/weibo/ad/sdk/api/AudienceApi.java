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

    private static final String  URI_READING = "/audiences/info/%d";
    private static final String  URI_LIST    = "/audiences/list";
    private static final String  URI_CREATE  = "/audiences";
    private static final String  URI_UPLOAD  = "/audiences/upload";
    private static final String  URI_DELETE  = "/audiences";
    private static final String  URI_SET_COVERAGE = "/audiences/set_coverage";

    private static final MediaType MEDIA_TYP_TEXT = MediaType.parse("text/plain; charset=utf-8");

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
     * @param dataFormat
     * @param fileName
     * @param isMd5
     * @return
     * @throws IOException
     */
    public HashMap<String, String> upload(int dataFormat, String fileName, int isMd5) throws  ApiException,
            IOException, IllegalAccessException {
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("data_format", String.valueOf(dataFormat))
                .addFormDataPart("is_md5", String.valueOf(isMd5))
                .addFormDataPart("package", fileName,
                        RequestBody.create(MEDIA_TYP_TEXT, new File(fileName)))
                .build();
        String data = api.getApiRequest().call(URI_UPLOAD, "POST", requestBody);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

    /**
     *
     * @param name
     * @param dataSource
     * @param fileId
     * @param dataFormat
     * @param isMd5
     * @return
     * @throws IOException
     */
    public AudienceEntity create(String name, int dataSource, String fileId, int dataFormat, int isMd5) throws
            ApiException, IOException , IllegalAccessException{
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("data_format", String.valueOf(dataFormat));
        params.put("data_source", String.valueOf(dataSource));
        params.put("file_id", fileId);
        params.put("is_md5", String.valueOf(isMd5));
        String data = api.getApiRequest().call(URI_CREATE, "POST", params);
        return JSON.parseObject(data, AudienceEntity.class);
    }

    /**
     *
     * @param name
     * @param fileId
     * @param dataFormat
     * @param isMd5
     * @param packageId
     * @return
     * @throws IOException
     */
    public AudienceEntity create(String name,  String fileId, int dataFormat, int isMd5, int packageId) throws
            ApiException, IOException{
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("data_source", String.valueOf(1));
        params.put("data_format", String.valueOf(dataFormat));
        params.put("file_id", fileId);
        params.put("package_id", String.valueOf(packageId));
        params.put("is_md5", String.valueOf(isMd5));
        String data = api.getApiRequest().call(URI_CREATE, "POST", params);
        return JSON.parseObject(data, AudienceEntity.class);
    }

    /**
     *
     * @param name
     * @param fileId
     * @param dataFormat
     * @param isMd5
     * @param mids
     * @return
     * @throws IOException
     */
    public AudienceEntity create(String name,  String fileId, int dataFormat, int isMd5, ArrayList<String> mids)
            throws  ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("data_source", String.valueOf(2));
        params.put("data_format", String.valueOf(dataFormat));
        params.put("file_id", fileId);
        params.put("mids", JSON.toJSONString(mids));
        params.put("is_md5", String.valueOf(isMd5));
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
        String scheme = URI_DELETE + "?id=" + id;
        String data = api.getApiRequest().call(scheme, "DELETE");
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

    /**
     *
     * @param id
     * @param lookAlikeId
     * @param name
     * @param audiencesSize
     * @return
     * @throws IOException
     */
    public AudienceEntity setCoverage(int id, int lookAlikeId, String name, int audiencesSize) throws  ApiException,
            IOException{
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        params.put("look_alike_id", String.valueOf(lookAlikeId));
        params.put("audiences_size", String.valueOf(audiencesSize));
        params.put("name", name);
        String data = api.getApiRequest().call(URI_SET_COVERAGE, "POST", params);
        return JSON.parseObject(data, AudienceEntity.class);
    }
}
