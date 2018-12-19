package com.weibo.ad.sdk.api;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.exception.ApiException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: com.weibo.ad.sdk.api
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Created at 2018/11/23 上午11:04
 */
public class DataApi extends AbstractApi {

    private static final String URI_READING = "/data/%d";
    private static final String URI_LIST = "/data";
    private static final String URI_EXTENSION = "/data/extension";
    private static final String URI_CALCULATE = "/data/calculate";
    private static final String URI_CALCULATION = "/data/calculation";
    private static final String URI_CUSTOM = "/data/custom";
    private static final String URI_INDUSTRY = "/data/industry/%d";

    public DataApi(Api api) {
        super(api);
    }

    public String list(int type, int page, int pageSize, int industry, String name, int sort, int sortType,
            int packMixedType, int packMixedStatus, int supplierId) throws ApiException, IOException {
        String url = URI_LIST + "?type=" + type + "&page=" + page + "&page_size=" + pageSize;
        if (industry > 0) {
            url += "&industry=" + industry;
        }
        if (name != null) {
            url += "&name=" + name;
        }
        if (sort > 0) {
            url += "&sort=" + sort;
        }
        if (sortType > 0) {
            url += "&sort_type=" + sortType;
        }
        if (packMixedType > 0) {
            url += "&pack_mixed_type=" + packMixedType;
        }
        if (packMixedStatus > 0) {
            url += "&pack_mixed_status=" + packMixedStatus;
        }
        if (supplierId > 0) {
            url += "&supplier_id=" + supplierId;
        }
        return api.getApiRequest().call(url);
    }

    public String read(int id, int type) throws ApiException, IOException {
        String url = String.format(URI_READING, id) + "?type=" + type;
        return api.getApiRequest().call(url);
    }

    public String createExtension(int packetId, int multiple, String packName, String packDesc)
            throws ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("market_packet_id", String.valueOf(packetId));
        params.put("multiple", String.valueOf(multiple));
        params.put("pack_name", packName);
        params.put("pack_desc", packDesc);
        return api.getApiRequest().call(URI_EXTENSION, "POST", params);
    }

    public String createCalculate(int packetId, int commissionPacketId, int type, String packName, String packDesc)
            throws ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("market_packet_id", String.valueOf(packetId));
        params.put("commission_packet_id", String.valueOf(commissionPacketId));
        params.put("calculation_type", String.valueOf(type));
        params.put("pack_name", packName);
        params.put("pack_desc", packDesc);
        return api.getApiRequest().call(URI_CALCULATE, "POST", params);
    }

    public String getCalculation(int page, int pageSize, String name, int sort, int sortType,
            int packMixedType, int packMixedStatus, int supplierId) throws ApiException, IOException {
        String url = URI_CALCULATION + "?page=" + page + "&page_size=" + pageSize;
        if (name != null) {
            url += "&name=" + name;
        }
        if (sort > 0) {
            url += "&sort=" + sort;
        }
        if (sortType > 0) {
            url += "&sort_type=" + sortType;
        }
        if (packMixedType > 0) {
            url += "&pack_mixed_type=" + packMixedType;
        }
        if (packMixedStatus > 0) {
            url += "&pack_mixed_status=" + packMixedStatus;
        }
        if (supplierId > 0) {
            url += "&supplier_id=" + supplierId;
        }

        return api.getApiRequest().call(url);
    }

    public String getCustom(int page, int pageSize, String name, int sort, int sortType,
            int packMixedType, int packMixedStatus, int dataSource) throws ApiException, IOException {
        String url = URI_CUSTOM + "?page=" + page + "&page_size=" + pageSize;
        if (name != null) {
            url += "&name=" + name;
        }
        if (sort > 0) {
            url += "&sort=" + sort;
        }
        if (sortType > 0) {
            url += "&sort_type=" + sortType;
        }
        if (packMixedType > 0) {
            url += "&pack_mixed_type=" + packMixedType;
        }
        if (packMixedStatus > 0) {
            url += "&pack_mixed_status=" + packMixedStatus;
        }
        if (dataSource > 0) {
            url += "&data_source=" + dataSource;
        }

        return api.getApiRequest().call(url);
    }


    public String industry(int id, int type, int page, int pageSize,  int sort) throws ApiException, IOException {
        String url = String.format(URI_INDUSTRY, id) + "?type=" + type + "&page=" + page + "&page_size=" + pageSize;
        if (sort > 0) {
            url += "&sort=" + sort;
        }
        return api.getApiRequest().call(url);
    }
}

