package tv.buka.utils;

import tv.buka.common.AccessToken;

import java.util.HashMap;

public class AuthUserUtil {
    //不兼容子账号
    public static HashMap<String,Object> checkAdmin(HashMap map){
        HashMap<String, Object> returnMap = new HashMap<>();
        if (AccessToken.getInstance().check(map.get("user_token") + "",map.get("user_device")+"")){
            Long user_id = AccessToken.getInstance().getIdByToken(map.get("user_token") + "").longValue();
            if (user_id.equals(42733l)){
                returnMap.put("user_id",user_id);
                returnMap.put("key", LoadMessage.map.get("application_key"));
                returnMap.put("model_id",2);
                return returnMap;
            }else {
                return BaseResp.userError();
            }
        }else {
            return BaseResp.userError();
        }
    }
}
