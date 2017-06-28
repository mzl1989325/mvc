package form;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * @Author:muzonglin
 * @Description:
 * @Date:2017/6/25
 */
public class FullForm {
    public FullForm () {

    }

    public static ActionForm full(String formPath, HttpServletRequest request){
        ActionForm form = null;
        try {
            Class clazz = Class.forName(formPath);
            form = (ActionForm) clazz.newInstance();
            Field[] filed_ar = clazz.getDeclaredFields();
            for(Field f:filed_ar) {
                f.setAccessible(true);
                f.set(form,request.getParameter(f.getName()));
                f.setAccessible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return form;
    }
}
