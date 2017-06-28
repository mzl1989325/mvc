package action;

import form.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author:muzonglin
 * @Description:
 * @Date:2017/6/25
 */
public interface Action {

    String excute(HttpServletRequest request, HttpServletResponse response,
                  ActionForm actionForm, Map<String,String> forwordMap);
}
