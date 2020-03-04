package proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * Create sql connection class
 * constructor take
 * url, driver, user, pass
 * url indicates database connection string
 * */
public class connector {
    Connection conn;
    String url;
    String driver;
    String user;
    String pass;
    
    
    /**
     * constructor set require variable then create a connection with setConnection()
     * */
    
    public connector(String url, String driver, String user, String pass) {
        this.url = url;
        this.driver = driver;
        this.user = user;
        this.pass = pass;
        setConnection();
    }
    
    
    /**
     * set connection
     * where conn is instance connection variable
     * */
    private void setConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    

    /**
     * getter and setter
     * */
    public Connection getConn() {
        return conn;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
    
    
    
    
}
