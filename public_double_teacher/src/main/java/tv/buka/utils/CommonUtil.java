package tv.buka.utils;

public class CommonUtil {
    public static Integer userRole(Integer role){
        Integer user_role=0;
        switch (role){
            case 1:
                user_role=11;
                break;
            case 2:
                user_role=12;
                break;
            case 3:
                user_role=13;
                break;
            default:user_role=role;

        }
        return user_role;
    }

    public static Integer role(Integer user_role){
        Integer role=0;
        switch (user_role){
            case 11:
                role=1;
                break;
            case 12:
                role=2;
                break;
            case 13:
                role=3;
                break;
            default:role=user_role;

        }
        return role;
    }
}
