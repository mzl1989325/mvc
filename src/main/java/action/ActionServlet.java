package action;

import form.ActionForm;
import form.FullForm;
import form.XmlBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author:muzonglin
 * @Description:
 * @Date:2017/6/25
 */
public class ActionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {

        String path = this.getPath(request.getServletPath());
        Map<String,XmlBean> map = (Map<String,XmlBean>) this.getServletContext().getAttribute("struts");
        XmlBean xml = map.get(path);
        String formclass = xml.getFormClass();
        ActionForm form = FullForm.full(formclass,request);
        String actiontype= xml.getActionClass();
        String url = "";
        Action action = null;
        try {
            Class clazz = Class.forName(actiontype);
            action = (Action)clazz.newInstance();
            url = action.excute(request,response,form,xml.getActionForward());
        } catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);


    }



    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {


        this.doGet(request,response);

    }


    private String getPath(String servletPath) {
        return servletPath.split("\\.")[0];
    }
}
