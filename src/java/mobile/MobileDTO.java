/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import java.io.Serializable;

/**
 *
 * @author trant
 */
public class MobileDTO implements Serializable {

    private String mobileId;
    private String description;
    private double price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean isNotSale;

    public MobileDTO() {
    }

    public MobileDTO(String mobileId, String description, double price, String mobileName, int yearOfProduction, int quantity, boolean isNotSale) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
        this.mobileName = mobileName;
        this.yearOfProduction = yearOfProduction;
        this.quantity = quantity;
        this.isNotSale = isNotSale;
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MobileDTO)) {
            return false;
        }

        MobileDTO other = (MobileDTO) obj;
        if (this.mobileId == null || other.mobileId == null
                || !this.mobileId.equals(other.mobileId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobileId != null ? mobileId.hashCode() : 0);
        return hash;
    }

}
