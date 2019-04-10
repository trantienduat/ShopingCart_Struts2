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

/**
 *
 * @author trant
 */
public class RemoveFromCartAction extends ActionSupport{

    private String[] selectedItems;
    private final String SUCCESS = "success";

    public RemoveFromCartAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        if (cart != null) {
            for (String item : selectedItems) {
                cart.removeItemFromCart(item);
            }
            session.put("CART", cart);
        }
        return SUCCESS;
    }

    public String[] getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(String[] selectedItems) {
        this.selectedItems = selectedItems;
    }

    
}
