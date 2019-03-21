package tv.buka.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {
    public static Boolean isNullOrEmptyString(Map<String,Object> map,String key){
        if(map.get(key)!=null && !map.get(key).equals("")){
            return true;
        }
        return false;
    }
    public static List<Map<String, Object>> toListMap(String json){
        List<Object> list = JSON.parseArray(json);

        List< Map<String,Object>> listw = new ArrayList<Map<String,Object>>();
        for (Object object : list){
            Map<String,Object> ageMap = new HashMap<String,Object>();
            Map <String,Object> ret = (Map<String, Object>) object;//取出list里面的值转为map
        /*for (Entry<String, Object> entry : ret.entrySet()) {
            ageMap.put(entry.getKey());
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            listw.add(ageMap);  //添加到list集合  成为 list<map<String,Object>> 集合
        }  */
            listw.add(ret);
        }
        return listw;

    }
    public final static boolean isJSON(String test) {
        try {
            JSONObject.parseObject(test);
        } catch (JSONException ex) {
            try {
                JSONObject.parseArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}
