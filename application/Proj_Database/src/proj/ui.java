package proj;

import java.sql.*;
import java.util.*;

public class ui {
    Map<String, product> productMap;
    List<String> idList;
    connector con;
    public ui() {
        productMap = new HashMap<String, product>();
    }
    
    
    
    public void printList_Detail() {
        setItemList_Detail();
        for(String e : productMap.keySet()) {
            System.out.println(e + "\t\t" + productMap.get(e).getName());
        }
    }
    
    private void setItemList_Detail() {
        idList = createItemList();
        System.out.println("Availabel Item - Enter product id to add item to cart");
        for(int i = 0; i < idList.size(); i++) {
            createItemList_Detail(idList.get(i));
        }
    }
    
    private void createItemList_Detail(String productId) {
        con = new connector(connection_info.url, connection_info.driver, connection_info.user, connection_info.pass);
        product pro = new product(Integer.valueOf(productId));
        productMap.put(productId, pro);
    }
    
    private List<String> createItemList() {
        con = new connector(connection_info.url, connection_info.driver, connection_info.user, connection_info.pass);
        Connection conn = con.getConn();
        query qry = new query(conn);
        return qry.getProductKeySet();
    }
    
    public void printBrandList() {
        Map<String, String> mp = createBrandList();
        System.out.println("Available Brand:");
        System.out.println("ID\t\tBrand");
        for(String e: mp.keySet()) {
            System.out.println(e + "\t\t" + mp.get(e));
        }
    }
    
    public void printCateList() {
        Map<String, String> mp = createCateList();
        System.out.println("Available Category:");
        System.out.println("ID\t\tCategory");
        for(String e: mp.keySet()) {
            System.out.println(e + "\t\t" + mp.get(e));
        }
    }
    
    private Map<String, String> createBrandList() {
        con = new connector(connection_info.url, connection_info.driver, connection_info.user, connection_info.pass);
        Connection conn = con.getConn();
        query qry = new query(conn);
        return qry.getBrandList();
    }
    
    private Map<String, String> createCateList() {
        con = new connector(connection_info.url, connection_info.driver, connection_info.user, connection_info.pass);
        Connection conn = con.getConn();
        query qry = new query(conn);
        return qry.getCateList();
    }
    
    @SuppressWarnings("unused")
    public void insertProduct(Integer proid, String desc, Double cost,
            Double price, String color, String dim, String size, 
            Integer brand, Integer cate) {
        con = new connector(connection_info.url, connection_info.driver, connection_info.user, connection_info.pass);
        Connection conn = con.getConn();
        query qry = new query(conn);
        qry.insert_product(proid.toString(), desc, cost.toString(), price.toString(), color, dim, size, brand.toString(), cate.toString());
    
        
    }

    
    public void printPrice(String id) {
        System.out.println("Product: " + productMap.get(id).getName() + "\t\tPrice: " + productMap.get(id).getPrice());
    }
    
    public void printSold(String datefrom, String dateto) {
        Connection conn = con.getConn();
        query qry = new query(conn);
        qry.searchSale_by_Date(datefrom, dateto); 
    }
    
    
    public void printProduct_Seach(String product) {
        con = new connector(connection_info.url, connection_info.driver, connection_info.user, connection_info.pass);
        query qry = new query(con.getConn());
        qry.searchProduct_by_Name(product);
    }

    public Map<String, product> getProductMap() {
        return productMap;
    }



    public List<String> getIdList() {
        setItemList_Detail();
        return idList;
    }
    
    public Map<String, String> getBrandMap() {
        return createBrandList();
    }
    
    public Map<String, String> getCateMap() {
        return createCateList();
    }

    
    
    
    
}
