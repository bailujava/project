package tv.buka.service.adapter;

import com.alibaba.fastjson.JSONObject;
import tv.buka.utils.Verify;
import java.util.HashMap;
import java.util.Map;

public class searchAdapter {
    public  static String   searchAdapter(String jsonStr){
        Map<String, Object> m = Verify.verifyUser(jsonStr);
        Map<String,Object> map= JSONObject.parseObject(jsonStr);
        StringBuilder stringBuilder = new StringBuilder();
        if ((Integer) m.get("status") > 0) {
                if(map.get("criteriaMap")!=null&&!"".equals(map.get("criteriaMap"))){
                    Map<String,Object> criteriaMap= JSONObject.parseObject( map.get("criteriaMap").toString(),HashMap.class);
                    for (String s : criteriaMap.keySet()) {
                        if (stringBuilder.toString().length()==0){
                            if (s.equals("or")){
                                String[] split = criteriaMap.get(s).toString().split(",");
                                stringBuilder.append(split[0]);
                                for (int i = 1; i < split.length; i++) {
                                    stringBuilder.append(" or " ).append(split[i]);
                                }
                                continue; }
                            else {stringBuilder.append(s+" ").append(criteriaMap.get(s)); continue;}
                        }
                        if (s.equals("or")){
                            String[] split = criteriaMap.get(s).toString().split(",");
                            stringBuilder.append(" and "+split[0]);
                            for (int i = 1; i < split.length; i++) {
                                stringBuilder.append(" or " ).append(split[i]);
                            } }
                        else {stringBuilder.append(" and ").append(s+" ").append(criteriaMap.get(s));}
                    }
                }

}
    return  stringBuilder.toString();
    }}
