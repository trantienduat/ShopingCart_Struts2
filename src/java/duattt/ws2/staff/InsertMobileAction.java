/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.staff;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import mobile.MobileDAO;
import mobile.MobileDTO;

/**
 *
 * @author trant
 */
public class InsertMobileAction extends ActionSupport {

    private String mobileId;
    private String description;
    private double price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean isNotSale;
    private String status;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public InsertMobileAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, isNotSale);
        boolean result = dao.insertMobile(dto);
        if (result) {
            status = "Insert Successful!!";
            return SUCCESS;
        } else {
            status = "Insert Failed!!";
            return FAIL;
        }
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIsNotSale() {
        return isNotSale;
    }

    public void setIsNotSale(boolean isNotSale) {
        this.isNotSale = isNotSale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
