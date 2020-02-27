package proj;

import java.sql.Connection;
import java.util.*;


public class Main {
    static List<String> idList = new ArrayList<String>();
    static Map<String,String> brandList = new HashMap<String, String>();
    static Map<String, String> cateList = new HashMap<String, String>();
    static ui u;
    static Scanner sc;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
        u = new ui();
        u.printList_Detail();
        idList = u.getIdList();
        
        
        
        System.out.println("Enter program terminal.");
        printPrompt();
      //  sc = new Scanner(System.in);
        
        do {
            sc = new Scanner(System.in);
                switch(sc.next()) {
                    case "price":
                        do {
                            System.out.println("Enter product id to perform price check");
                            String id = sc.next();
                            for(int i = 0; i < idList.size();i++) {
                                if(id.equals(idList.get(i))) {
                                    u.printPrice(idList.get(i));
                                    break;
                                }
                            }
                            System.out.println("Enter [close] to close this option OR Enter [cnt] to continue price check");
                        } while(!sc.next().equalsIgnoreCase("close"));
                       
                        break;
                    case "product":
                        do {
                            System.out.println("Enter product description to perform product search");
                            String name = sc.next();
                            u.printProduct_Seach(name);
                            
                            System.out.println("Enter [close] to close this option OR Enter [cnt] to continue search product");
                        } while(!sc.next().equalsIgnoreCase("close"));
                        
                        break;
                    case "sale":        //show number of sold unit 
                        do {
                            System.out.println("Enter Date begining\tFormat: YYYY-MM-DD");
                            String datefrom = sc.next();
                            
                            System.out.println("Enter Date ending\tFormat: YYYY-MM-DD");
                            sc = new Scanner(System.in);
                            String dateto = sc.next();
                            u.printSold(datefrom, dateto);
                            
                            System.out.println("Enter [close] to close this option OR Enter [cnt] to continue report");
                        } while(!sc.next().equalsIgnoreCase("close"));
                        
                        break;
                    case "update":
                        System.out.println("Not Implemented");
                        break;
                    case "insert":
                        do {
                            
                            /**
                             * this need a loop to handle duplicate key in this
                             * */
                            u.printList_Detail();
                            u.printBrandList();
                            u.printCateList();  
                            List<String> product_id = u.getIdList();
                            Map<String, String> brand_map = u.getBrandMap();
                            Map<String, String> cate_map = u.getCateMap();
                            
                            printHelper("Product Id", "Integer");
                            Integer proc_id = sc.nextInt();
                            printHelper("Product Description", "String");
                            String desc = sc.next();
                            printHelper("Product Cost", "Double");
                            Double cost = sc.nextDouble();
                            printHelper("Product Price", "Double");
                            Double price = sc.nextDouble();
                            printHelper("Product Color", "String");
                            String color = sc.next();
                            printHelper("Product Dimension", "String");
                            String dim = sc.next();
                            printHelper("Product Size", "String");
                            String size = sc.next();
                            printHelper("Product Brand Id", "Integer");
                            Integer brand = sc.nextInt();
                            printHelper("Product Category Id", "Integer");
                            Integer cate = sc.nextInt();
                        
                            u.insertProduct(proc_id, desc, cost, price, color, dim, size, brand, cate);
                            u.printList_Detail();
                            System.out.println("Enter [close] to close this option OR Enter [cnt] to continue insert");
                        } while(!sc.next().equalsIgnoreCase("close"));
                        break;
                    case "exit":
                        do {
                            u.printList_Detail();
                            u.printBrandList();
                            u.printCateList();  
                            List<String> product_id = u.getIdList();
                            Map<String, String> brand_map = u.getBrandMap();
                            Map<String, String> cate_map = u.getCateMap();
                        } while(!sc.next().equalsIgnoreCase("close"));
                        break;
                        
                }
                printPrompt();
        } while(!sc.next().equalsIgnoreCase("exit"));
        
        System.out.println("Program is terminated");
    }
    
    static void printPrompt() {
        System.out.println("Available Option:\n[price]\t->\t as Price Check\n[product]\t->\t to search for product"
                + "\n[sale]\t->\t to look for sold unit"
                + "\n[insert]\t->\t to add new product"
                + "\n[update]\t->\t to update product"
                + "\n[exit]\t->\t to terminate the program\n");
    }
    
    static void printHelper(String what, String format) {
        System.out.println("Please enter " + what + " - Format( " +
                format + " ):");
    }
}
