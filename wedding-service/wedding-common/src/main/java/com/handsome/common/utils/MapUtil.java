package com.handsome.common.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<Object,Object> buildMap(Object ...o){
        Map<Object, Object> resultMap = new HashMap<Object, Object>();
        for (int i = 0; i < o.length; i += 2) {
            resultMap.put(o[i], o[i + 1]);
        }
        return resultMap;
    };
}
