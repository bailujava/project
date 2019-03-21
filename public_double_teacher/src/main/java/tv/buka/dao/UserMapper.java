package tv.buka.dao;

import org.apache.ibatis.annotations.Param;
import tv.buka.pojo.vo.LoginReturn;

import java.util.Map;

public interface UserMapper {
    LoginReturn login(Map<String, Object> map);


}
