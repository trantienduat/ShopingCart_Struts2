/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.staff;

import mobile.MobileDAO;

/**
 *
 * @author trant
 */
public class DeleteMobileAction {

    private String pk;
    private String searchType;
    private String searchValue;
    private String status;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public DeleteMobileAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean result = dao.deleteMobile(pk);
        if (result) {
            status = "Delete successful!!!";
            return SUCCESS;
        } else {
            status = "Delete failed!!!";
            return FAIL;
        }
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
