package org.raphets.android.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class HashMapBeanTools {

    public static WeakHashMap<String,Object> Obj2Map(Object obj) {
        WeakHashMap<String,Object> map=new WeakHashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
