/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duattt.ws2.user.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import mobile.MobileDTO;

/**
 *
 * @author trant
 */
public class CartObj implements Serializable {

    private String custId;
    private Map<MobileDTO, Integer> items;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Map<MobileDTO, Integer> getItems() {
        return items;
    }

    public void setItems(Map<MobileDTO, Integer> items) {
        this.items = items;
    }

    public void addItemToCart(MobileDTO dto) {
        if (this.items == null) {
            items = new HashMap<>();
        }

        int quantity = 1;
        if (items.containsKey(dto)) {
            quantity = items.get(dto) + 1;
        }
        items.put(dto, quantity);
    }

    public void removeItemFromCart(MobileDTO dto) {
        if (items == null) {
            return;
        }
        if (items.containsKey(dto)) {
            items.remove(dto);
            if (items.isEmpty()) {
                items = null;
            }
        }
    }

    public void removeItemFromCart(String mobileId) {
        if (items == null) {
            return;
        }
        MobileDTO dto = new MobileDTO(mobileId, "", 0, "", 0, 0, true);

        if (items.containsKey(dto)) {
            items.remove(dto);
            if (items.isEmpty()) {
                items = null;
            }
        }
    }
}
