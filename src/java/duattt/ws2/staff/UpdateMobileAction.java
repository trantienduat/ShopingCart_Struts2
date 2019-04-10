/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.staff;

import com.opensymphony.xwork2.ActionSupport;
import mobile.MobileDAO;

/**
 *
 * @author trant
 */
public class UpdateMobileAction extends ActionSupport {

    private String mobileId;
    private Double price;
    private String description;
    private Integer quantity;
    private boolean notSale;
    private String status;

    private String searchValue;
    private String searchType;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public UpdateMobileAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean result = dao.updateMobile(mobileId, price, description, quantity, notSale);
        if (result) {
            status = "Update successful!!!";
            return SUCCESS;
        } else {
            status = "Update failed!!!";
            return FAIL;
        }
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

   

}
