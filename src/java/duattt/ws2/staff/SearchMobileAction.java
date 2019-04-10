/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.staff;

import com.opensymphony.xwork2.ActionContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobile.MobileDAO;
import mobile.MobileDTO;

/**
 *
 * @author trant
 */
public class SearchMobileAction {

    private String searchValue;
    private String searchType;
    private List<MobileDTO> mobilesList;
    private Map<Boolean, String> saleList;
    private String status;

    private final String SUCCESS = "success";

    public SearchMobileAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        dao.getListMobiles(searchType, searchValue);
        mobilesList = dao.getMobilesList();

        saleList = new HashMap<>();
        saleList.put(true, "Not Sale");
        saleList.put(false, "Sale");
        return SUCCESS;
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

    public List<MobileDTO> getMobilesList() {
        return mobilesList;
    }

    public void setMobilesList(List<MobileDTO> mobilesList) {
        this.mobilesList = mobilesList;
    }

    public Map<Boolean, String> getSaleList() {
        return saleList;
    }

    public void setSaleList(Map<Boolean, String> saleList) {
        this.saleList = saleList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
