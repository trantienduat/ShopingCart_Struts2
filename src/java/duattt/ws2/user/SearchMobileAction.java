/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.user;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobile.MobileDAO;
import mobile.MobileDTO;

/**
 *
 * @author trant
 */
public class SearchMobileAction extends ActionSupport {

    private Float minPrice;
    private Float maxPrice;
    private List<MobileDTO> mobilesList;
    private Map<Boolean, String> saleList;
    private String status;

    private final String SUCCESS = "success";

    public SearchMobileAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        if (minPrice > 0 && maxPrice >0) {
            
        dao.getListMobilesByPrice(minPrice, maxPrice);
        }
        mobilesList = dao.getMobilesList();

        saleList = new HashMap<>();
        saleList.put(true, "Not Sale");
        saleList.put(false, "Sale");
        return SUCCESS;
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

    public List<MobileDTO> getMobilesList() {
        return mobilesList;
    }

    public void setMobilesList(List<MobileDTO> mobilesList) {
        this.mobilesList = mobilesList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
