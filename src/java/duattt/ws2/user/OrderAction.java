/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import duattt.ws2.user.cart.CartObj;
import java.util.Map;
import user.UserDAO;

/**
 *
 * @author trant
 */
public class OrderAction extends ActionSupport {

    private String status;

    private final String SUCCESS = "success";

    public OrderAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        UserDAO dao = new UserDAO();
        status = "";
        Map<String, Integer> listMobileOutOfQuantity = dao.getOutOfQuantityProduct(cart);//get list mobile is outOfquantity
        if (listMobileOutOfQuantity == null) {
            dao.Order(cart);
            status = "Your Order has been received! Thanks for your order!";
            session.remove("CART");
        } else {
            for (Map.Entry<String, Integer> entry : listMobileOutOfQuantity.entrySet()) {
                status += "Product <b><font style=\"color: black\">" + entry.getKey() 
                        + "</font></b> has <b><font style=\"color: black\">" + entry.getValue() 
                        + "</font></b> item(s) left!" + "<br>";
                System.out.println(status);
            }
        }
        return SUCCESS;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
