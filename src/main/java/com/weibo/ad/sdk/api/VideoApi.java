package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.entity.VideoEntity;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.VideoModel;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class VideoApi extends AbstractApi
{

    private static final String  URI_READING = "/video";
    private static final String  URI_LIST    = "/video/list";
    private static final String  URI_CREATE  = "/video";

    private static final MediaType MEDIA_TYP_VIDEO = MediaType.parse("video/*; charset=utf-8");

    /**
     *
     * @param api
     */
    public VideoApi(Api api) {
        super(api);
    }

    /**
     *
     * @param id
     * @param isMd5
     * @return
     * @throws IOException
     */
    public VideoEntity read(int id, int isMd5) throws ApiException, IOException{
        String scheme = URI_READING + "?id=" + id + "&is_md5=" + isMd5;
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, VideoEntity.class);
    }

    /**
     *
     * @param page
     * @param pageSize
     * @return
     * @throws IOException
     */
    public VideoModel lists(int page, int pageSize) throws ApiException, IOException{
        String scheme = URI_LIST + "?page=" + page + "&page_size=" + pageSize;
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, VideoModel.class);
    }

    /**
     *
     * @param videoName
     * @param fileMd5
     * @param fileSize
     * @param filePath
     * @return
     * @throws IOException
     */
    public HashMap<String, String> upload(String videoName, String fileMd5, int fileSize, String filePath) throws
            ApiException,  IOException, IllegalAccessException {
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("video_name", videoName)
                .addFormDataPart("file_md5", fileMd5)
                .addFormDataPart("file_size", String.valueOf(fileSize))
                .addFormDataPart("file_content", videoName,
                        RequestBody.create(MEDIA_TYP_VIDEO, new File(filePath)))
                .build();
        String data = api.getApiRequest().call(URI_CREATE, "POST", requestBody);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }


    public HashMap<String, String> init(String videoName, String fileMd5, int fileSize) throws
            ApiException,  IOException, IllegalAccessException {
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("video_name", videoName)
                .addFormDataPart("file_md5", fileMd5)
                .addFormDataPart("file_size", String.valueOf(fileSize))
                .build();
        String data = api.getApiRequest().call("/video/init", "POST", requestBody);
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
        String data = api.getApiRequest().call("/video/segment", "POST", requestBody);
        System.out.printf("segment return %s\n", data);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

}
