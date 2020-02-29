package proj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class query {
    Connection conn;
    CallableStatement cs = null;
    ResultSet rs = null;
    Statement st =null;
    String query;
    
    
    String name, cost, price, size, color, dimension, brand, category,
    product_id, brand_id, category_id;
    
    public query(Connection conn) {
        this.conn = conn;
    }
    
    public  void searchProduct_by_id(Integer product_id) {
        try {
            cs = getConn().prepareCall("{call getProductBy_id(?, ?)}");
            cs.setInt(1, product_id);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            String str = cs.getString(2);
            if (str != null) {
                System.out.println(str);
            }
            else {
                rs = cs.getResultSet();
                while (rs.next()) {
                   // System.out.println("Name : " + rs.getString("p.description"));
                    name = rs.getString("p.description");
                    cost = rs.getString("p.cost");
                    price = rs.getString("p.price");
                    size = rs.getString("p.size");
                    color = rs.getString("p.color");
                    dimension = rs.getString("p.dimension");
                    brand = rs.getString("b.brand_name");
                    category = rs.getString("c.category_name");
                    this.product_id = rs.getString("p.product_id");
                    brand_id = rs.getString("b.brand_id");
                    category_id = rs.getString("c.category_id");
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        cs = null;
        rs = null;
    }
    
    public  void searchProduct_by_Name(String name) {
        try {
            cs = getConn().prepareCall("{call getProductBy_desc(?, ?)}");
            cs.setString(1, name);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            String str = cs.getString(2);
            if (str != null) {
                System.out.println(str);
            }
            else {
                rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.println("Name : " + rs.getString("p.description"));
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        cs = null;
        rs = null;
    }
    
    public List<String> getProductKeySet() {
        List<String> keyList = new ArrayList<String>();
        try {
            st = conn.createStatement();
            String sql = "SELECT p.product_id FROM product_test.products as p;";
            rs = st.executeQuery(sql);
            while(rs.next()) { 
                String id = rs.getString("product_id"); 
                keyList.add(id);
            }

            conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        rs = null;
        return keyList;
    }
    
    public Map<String, String> getBrandList() {
        Map<String, String> keyList = new HashMap<String, String>();
        try {
            st = conn.createStatement();
            String sql = "SELECT  b.brand_id, b.brand_name FROM product_test.brand as b;";
            rs = st.executeQuery(sql);
            while(rs.next()) { 
                String id = rs.getString("brand_id"); 
                String name = rs.getString("brand_name");
                keyList.put(id, name);
            }

            conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        rs = null;
        return keyList;
    }
    
    public Map<String, String> getCateList() {
        Map<String, String> keyList = new HashMap<String, String>();
        try {
            st = conn.createStatement();
            String sql = "SELECT c.category_id, c.category_name FROM product_test.category as c;";
            rs = st.executeQuery(sql);
            while(rs.next()) { 
                String id = rs.getString("category_id"); 
                String name = rs.getString("category_name");
                keyList.put(id, name);
            }

            conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        rs = null;
        return keyList;
    }
  

    public  void searchSale_by_Date(String datefrom, String dateto) {
        try {
            cs = getConn().prepareCall("{call getSale_byDate(?, ?, ?)}");
            cs.setString(1, datefrom);
            cs.setString(2, dateto);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.execute();
            String str = cs.getString(3);
            if (str != null) {
                System.out.println(str);
            }
            else {
                rs = cs.getResultSet();
                while (rs.next()) {
                   // System.out.println("Name : " + rs.getString("p.description"));
                    System.out.println(rs.getString("PRODUCT") + "\t\t" +
                   rs.getString("SOLD_UNIT") + "\t\t" + 
                            rs.getString("NET_AMOUNT"));
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        cs = null;
        rs = null;
    }
    
    public void update_product(String proid, String desc, String cost,
            String price, String color, String dim, String size, 
            String brand, String cate) {
        try {
            cs = getConn().prepareCall("{call update_product(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, proid);
            cs.setString(2, desc);
            cs.setString(3, cost);
            cs.setString(4, price);
            cs.setString(5, color);
            cs.setString(6, dim);
            cs.setString(7, size);
            cs.setString(8, brand);
            cs.setString(9, cate);
            cs.registerOutParameter(10, Types.VARCHAR);
            cs.execute();
            String str = cs.getString(10);
            if (str != null) {
                System.out.println(str);
            }
            
        } catch (SQLException e) {
            System.err.println("SQLException at [update_product]: " + e.getMessage());
           // e.printStackTrace();
        }
        cs = null;
        rs = null;
    }

    public void insert_product(String proid, String desc, String cost,
            String price, String color, String dim, String size, 
            String brand, String cate) {
        try {
            cs = getConn().prepareCall("{call insert_product(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, proid);
            cs.setString(2, desc);
            cs.setString(3, cost);
            cs.setString(4, price);
            cs.setString(5, color);
            cs.setString(6, dim);
            cs.setString(7, size);
            cs.setString(8, brand);
            cs.setString(9, cate);
            cs.registerOutParameter(10, Types.VARCHAR);
            cs.execute();
            String str = cs.getString(10);
            if (str != null) {
                System.out.println(str);
            }
        } catch (SQLException e) {
            System.err.println("SQLException at [insert_product]: " + e.getMessage());
           // e.printStackTrace();
        }
        cs = null;
        rs = null;
    }
    
    public Connection getConn() {
        return conn;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCost() {
        return cost;
    }


    public void setCost(String cost) {
        this.cost = cost;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }


    public String getSize() {
        return size;
    }


    public void setSize(String size) {
        this.size = size;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getDimension() {
        return dimension;
    }


    public void setDimension(String dimension) {
        this.dimension = dimension;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getProduct_id() {
        return product_id;
    }


    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }


    public String getBrand_id() {
        return brand_id;
    }


    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }


    public String getCategory_id() {
        return category_id;
    }


    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
    
    
    
    private void debugString(String test) {
        System.out.println("[DEBUG - class QUERY]\t\t" + test);
    }
    
}
