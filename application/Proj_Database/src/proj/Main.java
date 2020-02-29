package proj;

import java.sql.Connection;
import java.util.*;


public class Main {
    static List<String> idList = new ArrayList<String>();
    static Map<String,String> brandList = new HashMap<String, String>();
    static Map<String, String> cateList = new HashMap<String, String>();
    static ui u;
    static Scanner sc;
    static boolean cp = false;
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
                            try {
                                printHelper("Product Id", "Integer");
                                Integer proc_id = sc.nextInt();
                                if (!product_id.contains(proc_id.toString())) {
                                    cp = true;
                                    System.out.println("Product not existed, try again!");
                                }
                                cp = false;
                                if(cp)
                                    break;
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
                                if(!brand_map.containsKey(brand.toString())) {
                                    cp = true;
                                    System.out.println("Brand not exist, try again!");
                                } else {
                                    cp = false;
                                }
                                if(cp)
                                    break;
                                printHelper("Product Category Id", "Integer");
                                Integer cate = sc.nextInt();
                                if(!cate_map.containsKey(cate.toString())) {
                                    cp = true;
                                    System.out.println("Category not exist, try again!");
                                } else {
                                    cp = false;
                                }
                                if(cp)
                                    break;
                                u.updateProduct(proc_id, desc, cost, price, color, dim, size, brand, cate);
                                u.printList_Detail();
                            } catch (Exception e) {
                                System.out.println("One of the input is not valid, try again!");
                                break;
                            }
                            System.out.println("Enter [close] to close this option OR Enter [cnt] to continue insert");
                        } while(!sc.next().equalsIgnoreCase("close"));
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
                            try {
                                printHelper("Product Id", "Integer");
                                Integer proc_id = sc.nextInt();
                                
                                for(int i = 0; i < product_id.size(); i++) {
                                    if(proc_id.toString().equals(product_id.get(i))) {
                                        cp = true;
                                        System.out.println("Product already existed, try again!");
                                        break;
                                    }
                                    cp = false;
                                }
                                if(cp)
                                    break;
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
                                if(!brand_map.containsKey(brand.toString())) {
                                    cp = true;
                                    System.out.println("Brand not exist, try again!");
                                } else {
                                    cp = false;
                                }
                                if(cp)
                                    break;
                                printHelper("Product Category Id", "Integer");
                                Integer cate = sc.nextInt();
                                if(!cate_map.containsKey(cate.toString())) {
                                    cp = true;
                                    System.out.println("Category not exist, try again!");
                                } else {
                                    cp = false;
                                }
                                if(cp)
                                    break;
                                u.insertProduct(proc_id, desc, cost, price, color, dim, size, brand, cate);
                                u.printList_Detail();
                            } catch (Exception e) {
                                System.out.println("One of the input is not valid, try again!");
                                break;
                            }
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
