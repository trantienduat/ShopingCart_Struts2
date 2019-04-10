/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtil;

/**
 *
 * @author trant
 */
public class MobileDAO implements Serializable {

    private List<MobileDTO> mobilesList;

    public List<MobileDTO> getMobilesList() {
        return mobilesList;
    }

    public void getListMobiles(String searchType, String searchValue) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "SELECT * FROM dbo.tbl_Mobile tm WHERE " + searchType + " like ?";
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + searchValue + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    Double price = rs.getDouble("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean isNotSale = rs.getBoolean("notSale");
                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, isNotSale);
                    if (mobilesList == null) {
                        mobilesList = new ArrayList<>();
                    }
                    mobilesList.add(dto);
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
    }

    public boolean deleteMobile(String mobileId) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "DELETE FROM dbo.tbl_Mobile WHERE dbo.tbl_Mobile.mobileId =?";
                ps = c.prepareStatement(sql);
                ps.setString(1, mobileId);
                int result = ps.executeUpdate();
                if (result > 0) {
                    return true;
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
        return false;
    }

    public boolean updateMobile(String mobileId, double price, String description, int quantity, boolean notSale) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "UPDATE tbl_Mobile SET description=?, price=?, quantity=?, notSale=? WHERE mobileId=?";
                ps = c.prepareStatement(sql);
                ps.setString(1, description);
                ps.setDouble(2, price);
                ps.setInt(3, quantity);
                ps.setBoolean(4, notSale);
                ps.setString(5, mobileId);
                int result = ps.executeUpdate();
                if (result > 0) {
                    return true;
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
        return false;
    }

    public boolean insertMobile(MobileDTO dto) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "INSERT INTO tbl_Mobile VALUES(?,?,?,?,?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setString(1, dto.getMobileId());
                ps.setString(2, dto.getDescription());
                ps.setDouble(3, dto.getPrice());
                ps.setString(4, dto.getMobileName());
                ps.setInt(5, dto.getYearOfProduction());
                ps.setInt(6, dto.getQuantity());
                ps.setBoolean(7, dto.isIsNotSale());
                int result = ps.executeUpdate();
                if (result > 0) {
                    return true;
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
        return false;
    }

    public void getListMobilesByPrice(float minPrice, float maxPrice) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //swap if minPrice < maxPrice
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "SELECT * FROM dbo.tbl_Mobile tm WHERE tm.price <= ? AND tm.price >= ?";
                ps = c.prepareStatement(sql);
                ps.setFloat(1, maxPrice);
                ps.setFloat(2, minPrice);
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (this.mobilesList == null) {
                        this.mobilesList = new ArrayList<>();
                    }
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean isNotSale = rs.getBoolean("notSale");
                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, isNotSale);
                    this.mobilesList.add(dto);
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
    }

    public MobileDTO getMobileByID(String mobileId) throws SQLException, NamingException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //swap if minPrice < maxPrice
            c = DBUtil.getConnection();
            if (c != null) {
                String sql = "SELECT * FROM dbo.tbl_Mobile tm WHERE tm.mobileId = ?";
                ps = c.prepareStatement(sql);
                ps.setString(1, mobileId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (this.mobilesList == null) {
                        this.mobilesList = new ArrayList<>();
                    }
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean isNotSale = rs.getBoolean("notSale");
                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, isNotSale);
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
}
