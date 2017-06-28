package bussiness;

import form.ActionForm;

/**
 * @Author:muzonglin
 * @Description:
 * @Date:2017/6/28
 */
public class SForm extends ActionForm{

   public SForm() {

   }

   private String name;

   private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
