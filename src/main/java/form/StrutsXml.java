package form;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:muzonglin
 * @Description:
 * @Date:2017/6/25
 */
public class StrutsXml {


    public static Map<String,XmlBean> parse(String xmlPath) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(xmlPath));
        Element root = document.getRootElement();
        Map<String,XmlBean> rmap = new HashMap<String,XmlBean>();
        Element actionroot = root.getChild("action-mapping");
        List<Element> action = actionroot.getChildren();
        for(Element element:action){
            XmlBean xmlBean = new XmlBean();
            String name = element.getAttributeValue("name");
            xmlBean.setBeanName(name);
            Element actionForm = root.getChild("formbeans");
            List<Element> form = actionForm.getChildren();
            for(Element element1:form) {
                if(name.equals(element1.getAttributeValue("name"))) {
                    String formclass = element1.getAttributeValue("class");
                    xmlBean.setFormClass(formclass);
                    break;
                }
            }
            String path = element.getAttributeValue("path");
            xmlBean.setPath(path);
            String type = element.getAttributeValue("type");
            xmlBean.setActionClass(type);
            List<Element> forword = element.getChildren();
            Map<String,String> map = new HashMap<String,String>();
            for(Element x:forword) {
                String fname = x.getAttributeValue("name");
                String fvalue = x.getAttributeValue("value");
                map.put(fname,fvalue);
            }
            xmlBean.setActionForward(map);
            rmap.put(path,xmlBean);
        }

        return  rmap;
    }

}
