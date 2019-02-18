package org.raphets.android.utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.util.TypeUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @文件名称：FastJsonTools
 * @文件作者：柯雄枫
 * @时间：2018/3/10/010 14:41
 * @邮箱：915611039@qq.com
 * @文件描述：FastJsonTools
 */
public class FastJsonTools {
    private final static String TAG = "FastJsonTools";
    
    static {
        //初始化Fastjson的参数，防止对大小写转换
        TypeUtils.compatibleWithJavaBean = true;
    }
    
    private static void Loge(String log) {
        Log.e(TAG, log);
    }
    
    // 把JSON文本parse为JavaBean
    public static <T> T json2BeanObject(String json, Type type) {
        T bean = null;
        try {
            bean = JSON.parseObject(json,type);
        } catch (Exception e) {
            Loge("[FastJsonTools] --> Exception : " + e.getMessage() + ",json = " + json);
        }

        return bean;
    }
    
    public static <T> List<T> jsonToList(String json, Class<T> type) {
        return JSONArray.parseArray(json,type);
    }

     //将JavaBean序列化为JSON文本
    public static <T> String bean2Json(T bean) {
        String json = JSON.toJSONString(bean);
        return json;
    }
    


}
