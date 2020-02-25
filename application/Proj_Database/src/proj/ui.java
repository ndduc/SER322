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
        return idList;
    }
    

    
    
    
    
}
