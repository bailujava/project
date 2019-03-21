package tv.buka.service;



import tv.buka.pojo.Role;
import tv.buka.utils.BaseResp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {

    Object login(String jsonStr);

    BaseResp clientslogin(String jsonStr);

    BaseResp insertDepartment(String jsonStr);

    BaseResp listdepartment(String jsonStr);

    BaseResp removedepartment(String jsonStr);

    BaseResp updatedepartment(String jsonStr);

    BaseResp listaccount(String jsonStr);

    BaseResp removeaccount(String jsonStr);

    BaseResp updateaccount(String jsonStr);

    BaseResp insertaccount(String jsonStr);

    BaseResp insertbatchaccount(String jsonStr);

    BaseResp accountanddepartment(String jsonStr);

    Object createcourse(String jsonStr);

    BaseResp removecourse(String jsonStr);

    BaseResp updatecourse(String jsonStr);

    BaseResp getcourse(String jsonStr);

    BaseResp listcourse(String jsonStr);

    BaseResp accountcourse(String jsonStr);

    BaseResp listcontrolcourse(String jsonStr);

    BaseResp getcoursedetails(String jsonStr);

    BaseResp listcurriculum(String jsonStr);

    BaseResp nextcourse(String jsonStr);

    BaseResp selectExtend(HashMap<String, Object> map);

    BaseResp action(HashMap<String, Object> map);

    BaseResp overview(String jsonStr);

    List<Role> listrole();

    Map<String,Object> servertime();

    /*int classesbegin(String jsonStr);

    int classesover(String jsonStr);

    BaseResp entercourse(String jsonStr);

    BaseResp callin(String jsonStr);

    BaseResp remove(String jsonStr);*/





}
