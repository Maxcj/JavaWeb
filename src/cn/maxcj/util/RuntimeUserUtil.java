package cn.maxcj.util;

import cn.maxcj.bean.system.RuntimeUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author maxcj
 */
public class RuntimeUserUtil {

    public static RuntimeUser getRuntimeUser(HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("id");
        String email = (String) request.getSession().getAttribute("email");
        List<Integer> roleList = (List<Integer>) request.getSession().getAttribute("roleList");
        return new RuntimeUser(id, email, roleList);
    }


}
