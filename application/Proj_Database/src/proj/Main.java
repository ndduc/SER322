package proj;

import java.sql.Connection;
import java.util.*;


public class Main {
    static List<String> idList = new ArrayList<String>();
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
                    case "exit":
                        break;
                        
                }
                printPrompt();
        } while(!sc.next().equalsIgnoreCase("exit"));
        
        System.out.println("Program is terminated");
    }
    
    static void printPrompt() {
        System.out.println("Available Option:\n[price]\t->\t as Price Check\n[product]\t->\t to search for product"
                + "\n[sale]\t->\t to look for sold unit"
                + "\n[exit]\t->\t to terminate the program\n");
    }
}
