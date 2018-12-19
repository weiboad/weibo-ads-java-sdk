package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.exception.ApiException;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class VideoApi extends AbstractApi
{

    private static final String  URI_INIT     = "/video/init";
    private static final String  URI_SEGMENT  = "/video/segment";
    /**
     *
     * @param api
     */
    public VideoApi(Api api) {
        super(api);
    }


    public HashMap<String, String> init(String videoName, String fileMd5, int fileSize) throws
            ApiException,  IOException, IllegalAccessException {
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("video_name", videoName)
                .addFormDataPart("file_md5", fileMd5)
                .addFormDataPart("file_size", String.valueOf(fileSize))
                .build();
        String data = api.getApiRequest().call(URI_INIT, "POST", requestBody);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }


    public HashMap<String, String> segment(String fileToken, String fileMd5, String length, int segmentSize, String
            segmentMd5, int index, byte[] content)
            throws
            ApiException,  IOException, IllegalAccessException {
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"),content);


        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file_token", fileToken)
                .addFormDataPart("file_md5", fileMd5)
                .addFormDataPart("length", length)
                .addFormDataPart("segment_size", String.valueOf(segmentSize))
                .addFormDataPart("index", String.valueOf(index))
                .addFormDataPart("segment_md5", segmentMd5)
                .addPart(Headers.of("Content-Disposition", "form-data;name=\"file\";filename=\"test.mp4\""),fileBody)
                .build();
        String data = api.getApiRequest().call(URI_SEGMENT, "POST", requestBody);
        System.out.printf("segment return %s\n", data);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

}
