/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import duattt.ws2.user.cart.CartObj;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import mobile.MobileDTO;
import utils.DBUtil;

/**
 *
 * @author trant
 */
public class UserDAO implements Serializable {

    public UserDTO checkLogin(String username, int password) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "select * from tbl_User where userId=? and password=?";
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setInt(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullName");
                    int role = rs.getInt("role");
                    UserDTO dto = new UserDTO(username, password, fullname, role);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

    public void Order(CartObj cart) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            if (c != null) {
                String insertOrder = "INSERT INTO dbo.tbl_Orders VALUES (?, DEFAULT)";
                ps = c.prepareStatement(insertOrder);
                ps.setString(1, cart.getCustId());              //custId
                ps.executeUpdate();

                String orderDetail = "	UPDATE tbl_Mobile SET quantity = quantity - ? WHERE mobileId=?;"
                        + "	DECLARE @orderID int "
                        + "	SET @orderID = (SELECT [to].orderId "
                        + "						FROM dbo.tbl_Orders [to]"
                        + "						 WHERE [to].createdAt = "
                        + "						 (SELECT max([to2].createdAt) FROM dbo.tbl_Orders to2))"
                        + "	INSERT INTO dbo.tbl_OrderDetails VALUES	(?, ?, ?, ROUND(?,2),@orderID)";
                ps = c.prepareStatement(orderDetail);
                for (Map.Entry<MobileDTO, Integer> entry : cart.getItems().entrySet()) {
                    ps.setInt(1, entry.getValue());                 //quantity
                    ps.setString(2, entry.getKey().getMobileId());//mobileId
                    ps.setString(3, entry.getKey().getMobileId());//mobileId
                    ps.setInt(4, entry.getValue());                 //quantity
                    ps.setDouble(5, (entry.getKey().getPrice())); //price
                    ps.setDouble(6, (entry.getKey().getPrice() * entry.getValue())); //total
                    ps.executeUpdate();
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }

    public Map<String, Integer> getOutOfQuantityProduct(CartObj cart) throws SQLException, NamingException {
        Map<String, Integer> listMobileOutOfQuantity = new HashMap<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int flag = 0;
        try {
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "SELECT tm.mobileId, tm.quantity FROM dbo.tbl_Mobile tm WHERE tm.mobileId =? AND tm.quantity < ?";
                ps = c.prepareStatement(sql);
                for (Map.Entry<MobileDTO, Integer> entry : cart.getItems().entrySet()) {
                    ps.setString(1, entry.getKey().getMobileId());
                    ps.setInt(2, entry.getValue());
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        flag = 1;
                        listMobileOutOfQuantity.put(entry.getKey().getMobileName(), rs.getInt("quantity"));
                    }
                }
                if (flag == 1) {
                    return listMobileOutOfQuantity;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return null;
    }
}
