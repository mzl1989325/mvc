package bussiness;

import action.Action;
import form.ActionForm;
import form.FullForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author:muzonglin
 * @Description:
 * @Date:2017/6/28
 */
public class SAction implements Action {

    public String excute(HttpServletRequest request, HttpServletResponse response, ActionForm actionForm, Map<String, String> forwordMap) {

        String url = "fail";
        SForm myform = (SForm)actionForm;
        if(myform.getName().equals("123")) {
            url = "success";
        }

        return forwordMap.get(url);
    }
}
