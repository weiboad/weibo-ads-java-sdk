package com.weibo.ad.sdk;


import com.alibaba.fastjson.JSON;
import com.weibo.ad.sdk.entity.AbstractEntity;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Util
{
    private static HashMap<String, String> snakeCache = new HashMap<>();
    private static HashMap<String, String> studlyCache = new HashMap<>();


    public static String snake (String value) {
        if (value.equals("")) return "";
        String key = value;
        if (snakeCache.containsKey(key)) {
            return snakeCache.get(key);
        }

        value= String.valueOf(value.charAt(0)).toUpperCase().concat(value.substring(1));
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(value);
        while(matcher.find()){
            String word = matcher.group();
            sb.append(word.toLowerCase());
            sb.append(matcher.end() == value.length() ? "" : "_");
        }
        value =  sb.toString();
        snakeCache.put(key, value);
        return value;
    }

    public static String studly (String value) {
        if (value.equals("")) return "";
        String key = value;
        if (studlyCache.containsKey(key)) {
            return studlyCache.get(key);
        }
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(value);
        while(matcher.find()){
            String word = matcher.group();
            sb.append(Character.toUpperCase(word.charAt(0)));
            int index = word.lastIndexOf('_');
            if(index > 0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        value = sb.toString();
        studlyCache.put(key, value);
        return value;
    }

    public static RequestBody buildRequestBody(AbstractEntity obj) throws IllegalAccessException {
        HashMap<String, Object> campaignMap = objectToMap(obj);
        FormBody.Builder builder = new FormBody.Builder();
        for (Entry<String, Object> entry : campaignMap.entrySet()) {
            if (entry.getValue() != null) {
                Object value = entry.getValue();
                if (value == null) continue;
                if (value instanceof Integer) {
                    builder.add(entry.getKey(), String.valueOf(value));
                } else if (value instanceof String) {
                    builder.add(entry.getKey(), value.toString());
                } else {
                    builder.add(entry.getKey(), JSON.toJSONString(value));
                }
            }
        }
        return  builder.build();
    }

    public static HashMap<String, Object>  objectToMap(Object obj) throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = Util.snake(field.getName());
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }


}
