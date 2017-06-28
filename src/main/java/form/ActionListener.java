package form;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;
import java.util.Map;

/**
 * @Author:muzonglin
 * @Description:
 * @Date:2017/6/27
 */
public class ActionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext context = servletContextEvent.getServletContext();
        String xmlpath = context.getInitParameter("struts_config");
        //String tomcatpath = context.getRealPath("\\");
        String url = ActionListener.class.getClassLoader().getResource(xmlpath).getPath();
        try {
            //Map<String,XmlBean> map = StrutsXml.parse(tomcatpath+xmlpath);
            Map<String,XmlBean> map = StrutsXml.parse(url);
            context.setAttribute("struts",map);
            System.out.println("信息:加载完成");
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("信息:已经注销");
    }
}
