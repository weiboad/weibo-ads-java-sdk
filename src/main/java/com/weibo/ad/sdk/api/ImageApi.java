package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.entity.ImageEntity;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.ImageModel;
import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ImageApi extends AbstractApi
{
    private static final String  URI_CREATE  = "/openapi/image";

    private static final MediaType MEDIA_TYP_IMG = MediaType.parse("image/*; charset=utf-8");

    public ImageApi(Api api) {
        super(api);
    }


    /**
     *
     * @param imageName
     * @param filePath
     * @return
     * @throws IOException
     */
    public ImageEntity upload(String imageName, String filePath) throws
            ApiException, IOException {
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("pic", imageName,
                        RequestBody.create(MEDIA_TYP_IMG, new File(filePath)))
                .build();
        String data = api.getApiRequest().call(URI_CREATE, "POST", requestBody);
        return JSON.parseObject(data, ImageEntity.class);
    }

}
