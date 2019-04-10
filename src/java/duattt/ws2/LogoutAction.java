/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author trant
 */
public class LogoutAction {

    public LogoutAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session.get("USER") != null) {
            session.clear();
        }
        return "success";
    }

}
