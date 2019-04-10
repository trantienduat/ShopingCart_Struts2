/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import user.UserDAO;
import user.UserDTO;
import java.util.Map;

public class LoginAction extends ActionSupport {

    private String username;
    private String password;

    private final String SUCCESS = "success";
    private final String USER = "user";
    private final String STAFF = "staff";
    private final String FAIL = "fail";

    public LoginAction() {
    }

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        if (!(username.trim().length() > 0) || !(password.trim().length() > 0)) {
            return FAIL;
        }
        UserDTO userDTO = userDAO.checkLogin(username, Integer.parseInt(password));
        String url = FAIL;
        if (userDTO != null) {
            Map session = ActionContext.getContext().getSession();
            if (userDTO.getRole() == 0) {
                url = USER;
            }
            if (userDTO.getRole() == 2) {
                url = STAFF;
            }
            session.put("USER", userDTO);
//            url = SUCCESS;
        }
        return url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
