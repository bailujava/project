package tv.buka.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class JSONUtils {
    public JSONUtils() {
    }

    public static final boolean isJSONValid(String test) {
        try {
            JSONObject.parseObject(test);
        } catch (JSONException e) {
            try {
                JSONObject.parseArray(test);
            } catch (JSONException var3) {
                return false;
            }
        }
        if (test .equals("")){
            return false;
        }
        return true;
    }
}
