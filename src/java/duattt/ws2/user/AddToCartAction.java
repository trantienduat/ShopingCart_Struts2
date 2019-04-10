/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.user;

import com.opensymphony.xwork2.ActionContext;
import duattt.ws2.user.cart.CartObj;
import java.util.List;
import java.util.Map;
import mobile.MobileDAO;
import mobile.MobileDTO;
import user.UserDTO;

/**
 *
 * @author trant
 */
public class AddToCartAction {

    private String mobileId;
    private Float minPrice;
    private Float maxPrice;
    private List<MobileDTO> mobilesList;

    private final String SUCCESS = "success";

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        if (cart == null) {
            cart = new CartObj();
        }

        MobileDAO dao = new MobileDAO();
        MobileDTO dto = dao.getMobileByID(mobileId);
        UserDTO user = (UserDTO) session.get("USER");
        cart.setCustId(user.getUserId());
        cart.addItemToCart(dto);
        session.put("CART", cart);

//        dao.getListMobilesByPrice(minPrice, maxPrice);
//        mobilesList = dao.getMobilesList();
        return SUCCESS;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public List<MobileDTO> getMobilesList() {
        return mobilesList;
    }

    public void setMobilesList(List<MobileDTO> mobilesList) {
        this.mobilesList = mobilesList;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

}
