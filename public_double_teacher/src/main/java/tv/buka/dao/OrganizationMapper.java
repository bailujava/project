package tv.buka.dao;

import org.apache.ibatis.annotations.Param;
import tv.buka.pojo.Organization;
import tv.buka.pojo.vo.LoginReturn;

import java.util.Map;

public interface OrganizationMapper {
    Organization selectByUserId(@Param(value = "user_id") Integer user_id, @Param(value = "now") long now);

    int insert(Map<String, Object> userMap);

}
